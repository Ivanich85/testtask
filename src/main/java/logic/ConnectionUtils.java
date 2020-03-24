package logic;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ConnectionUtils {

    public static String getURLContent(String urlStr) {
        if (urlStr == null) {
            return StringUtils.EMPTY;
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(urlStr).openStream())) ) {
            StringBuilder builder = new StringBuilder();
            String responseLine;
            while ((responseLine = reader.readLine()) != null) {
                builder.append(responseLine);
            }
            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return StringUtils.EMPTY;
    }
}
