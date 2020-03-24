package dataobjects;

import java.io.Serializable;

public class Aggregation implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private VideoStreamType urlType;
    private String videoUrl;
    private String value;
    private Integer ttl;

    private Aggregation(Integer id, VideoStreamType urlType, String videoUrl, String value, Integer ttl) {
        this.id = id;
        this.urlType = urlType;
        this.videoUrl = videoUrl;
        this.value = value;
        this.ttl = ttl;
    }

    public Aggregation() {
    }

    public static Aggregation aggregate(Integer id, CameraSource sourceData, CameraToken cameraToken) {
        if (id == null || sourceData == null || cameraToken == null) {
            return new Aggregation();
        }
        return new Aggregation(id, sourceData.getUrlType(), sourceData.getVideoUrl(), cameraToken.getValue(), cameraToken.getTtl());
    }

    public Integer getId() {
        return id;
    }

    public VideoStreamType getUrlType() {
        return urlType;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public String getValue() {
        return value;
    }

    public Integer getTtl() {
        return ttl;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Aggregation)) {
            return false;
        }
        Aggregation aggr = (Aggregation) obj;
        return this.id == aggr.id
                && this.ttl == aggr.ttl
                && this.urlType.equals(aggr.urlType)
                && this.value.equals(aggr.value)
                && this.videoUrl.equals(aggr.videoUrl);
    }

    @Override
    public int hashCode() {
        return id + 31 * ttl + urlType.name().length() + value.length() + videoUrl.length();
    }
}