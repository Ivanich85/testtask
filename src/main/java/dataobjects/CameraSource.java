package dataobjects;

import java.io.Serializable;

public class CameraSource implements Serializable {
    private final static long serialVersionUID = 1L;
    private VideoStreamType urlType;
    private String videoUrl;

    public VideoStreamType getUrlType() {
        return urlType;
    }

    public void setUrlType(VideoStreamType urlType) {
        this.urlType = urlType;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
