package com.sensiblemetrics.api.alpenidos.pattern.facade5.utils;

import com.sensiblemetrics.api.alpenidos.pattern.facade5.codec.Codec;
import com.sensiblemetrics.api.alpenidos.pattern.facade5.model.VideoFile;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BitrateReader {

    public static VideoFile read(VideoFile file, Codec codec) {
        System.out.println("BitrateReader: reading file...");
        return file;
    }

    public static VideoFile convert(VideoFile buffer, Codec codec) {
        System.out.println("BitrateReader: writing file...");
        return buffer;
    }
}
