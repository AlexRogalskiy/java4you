package com.sensiblemetrics.api.alpenidos.core.facade5;

import com.sensiblemetrics.api.alpenidos.core.facade5.management.VideoConversionFacade;
import java.io.File;

public class Demo {

    public static void main(final String[] args) {
        final VideoConversionFacade converter = new VideoConversionFacade();
        final File mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4");
    }
}
