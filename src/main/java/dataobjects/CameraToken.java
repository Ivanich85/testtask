package dataobjects;

import java.io.Serializable;

public class CameraToken implements Serializable {
    private final static long serialVersionUID = 1L;
    private String value;
    private Integer ttl;


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getTtl() {
        return ttl;
    }

    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }
}
