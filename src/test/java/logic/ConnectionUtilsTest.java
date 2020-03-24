package logic;

import abstracttest.AbstractTest;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConnectionUtilsTest extends AbstractTest {
    @Before
    public void init() {
        gson = new Gson();
    }

    @Test
    public void getURLContent() {
        Assert.assertEquals("{    \"urlType\": \"LIVE\",    \"videoUrl\": \"rtsp://127.0.0.1/1\"}", ConnectionUtils.getURLContent("http://www.mocky.io/v2/5c51b230340000094f129f5d"));
    }

}