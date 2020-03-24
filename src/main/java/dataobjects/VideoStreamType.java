package dataobjects;

import com.google.gson.annotations.SerializedName;

public enum VideoStreamType {
    @SerializedName("ARCHIVE")
    ARCHIVE,

    @SerializedName("LIVE")
    LIVE;
}
