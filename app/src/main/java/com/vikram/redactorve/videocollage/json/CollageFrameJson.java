package com.vikram.redactorve.videocollage.json;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CollageFrameJson {
    @SerializedName("collageframes")
    public List<FrameInfo> imgInfo;
}
