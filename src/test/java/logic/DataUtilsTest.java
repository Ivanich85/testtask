package logic;

import abstracttest.AbstractTest;
import dataobjects.*;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.crypto.Data;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DataUtilsTest extends AbstractTest {
    private Camera cameraTest;

    @Before
    public void init() {
        cameraTest = new Camera();
        cameraTest.setId(1);
        cameraTest.setSourceDataUrl("http://www.mocky.io/v2/5c51b230340000094f129f5d");
        cameraTest.setTokenDataUrl("http://www.mocky.io/v2/5c51b5b6340000554e129f7b?mocky-delay=1s");

        cameraSourceExpected = new CameraSource();
        cameraSourceExpected.setVideoUrl("rtsp://127.0.0.1/1");
        cameraSourceExpected.setUrlType(VideoStreamType.LIVE);

        cameraTokenExpected = new CameraToken();
        cameraTokenExpected.setValue("fa4b588e-249b-11e9-ab14-d663bd873d93");
        cameraTokenExpected.setTtl(120);

        testAggregationExpected = Aggregation.aggregate(1, cameraSourceExpected, cameraTokenExpected);
    }

    @Test
    public void createAggregationList() {
        Assert.assertEquals(testAggregationExpected, DataUtils.createAggregationList(Arrays.asList(cameraTest), 1).get(0));
    }
}