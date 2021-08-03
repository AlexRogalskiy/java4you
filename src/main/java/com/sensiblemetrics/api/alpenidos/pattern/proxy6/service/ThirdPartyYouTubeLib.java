package com.sensiblemetrics.api.alpenidos.pattern.proxy6.service;

import com.sensiblemetrics.api.alpenidos.pattern.proxy6.model.Video;
import java.util.HashMap;

public interface ThirdPartyYouTubeLib {

    HashMap<String, Video> popularVideos();

    Video getVideo(String videoId);
}
