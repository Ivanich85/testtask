package logic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dataobjects.Aggregation;
import dataobjects.Camera;
import dataobjects.CameraSource;
import dataobjects.CameraToken;
import org.apache.commons.collections4.CollectionUtils;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

import static logic.ConnectionUtils.getURLContent;

public class DataUtils {
    private final static Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public static String aggregateResults(String URL, int threads){
        return GSON.toJson(createAggregationList(GSON.fromJson(getURLContent(URL), new TypeToken<List<Camera>>(){}.getType()), threads));
    }

    public static List<Aggregation> createAggregationList(List<Camera> cameras, int maxThreads) {
        List<Aggregation> aggregateDates = new LinkedList<>();
        if (CollectionUtils.isEmpty(cameras)) {
            return aggregateDates;
        }
        int camerasSize = cameras.size();
        int threads = camerasSize <= maxThreads ? camerasSize : maxThreads != 0 ? maxThreads : 1;
        ExecutorService service = Executors.newFixedThreadPool(threads);
        List<Callable<Aggregation>> callables = new LinkedList<>();
        cameras.stream().forEach(camera -> callables.add(() -> fromCamera(camera)));
        try {
            service.invokeAll(callables, 120, TimeUnit.SECONDS).forEach(future -> {
                try {
                    aggregateDates.add(future.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
        return aggregateDates;
    }

    private static Aggregation fromCamera(Camera camera) {
        CameraSource sourceData = GSON.fromJson(getURLContent(camera.getSourceDataUrl()), CameraSource.class);
        CameraToken cameraToken = GSON.fromJson(getURLContent(camera.getTokenDataUrl()), CameraToken.class);
        return Aggregation.aggregate(camera.getId(), sourceData, cameraToken);
    }

}
