package dataobjects;

import abstracttest.AbstractTest;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AggregationTest extends AbstractTest {
    @Before
    public void init() {
        gson = new Gson();
        cameraSourceExpected = new CameraSource();
        cameraSourceExpected.setVideoUrl("rtsp://127.0.0.1/1");
        cameraSourceExpected.setUrlType(VideoStreamType.LIVE);

        cameraTokenExpected = new CameraToken();
        cameraTokenExpected.setValue("fa4b5d52-249b-11e9-ab14-d663bd873d93");
        cameraTokenExpected.setTtl(120);

        testAggregationExpected = Aggregation.aggregate(1, cameraSourceExpected, cameraTokenExpected);
    }

    @Test
    public void aggregate() {
        CameraSource cameraSource =  gson.fromJson("{    \"urlType\": \"LIVE\",    \"videoUrl\": \"rtsp://127.0.0.1/1\"}", CameraSource.class);
        CameraToken cameraToken = gson.fromJson("{    \"value\": \"fa4b5d52-249b-11e9-ab14-d663bd873d93\",    \"ttl\": 120}", CameraToken.class);
        Aggregation aggregationActual = Aggregation.aggregate(1, cameraSource, cameraToken);
        Assert.assertEquals(testAggregationExpected, aggregationActual);
    }

}