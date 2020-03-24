package abstracttest;

import com.google.gson.Gson;
import dataobjects.Aggregation;
import dataobjects.CameraSource;
import dataobjects.CameraToken;

public class AbstractTest {
    protected Gson gson;
    protected CameraSource cameraSourceExpected;
    protected CameraToken cameraTokenExpected;
    protected Aggregation testAggregationExpected;
}
