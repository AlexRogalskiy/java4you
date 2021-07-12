package com.sensiblemetrics.api.alpenidos.core.facade5.management;

import com.sensiblemetrics.api.alpenidos.core.facade5.codec.Codec;
import com.sensiblemetrics.api.alpenidos.core.facade5.codec.MPEG4CompressionCodec;
import com.sensiblemetrics.api.alpenidos.core.facade5.codec.OggCompressionCodec;
import com.sensiblemetrics.api.alpenidos.core.facade5.factory.CodecFactory;
import com.sensiblemetrics.api.alpenidos.core.facade5.model.AudioMixer;
import com.sensiblemetrics.api.alpenidos.core.facade5.model.VideoFile;
import com.sensiblemetrics.api.alpenidos.core.facade5.utils.BitrateReader;
import java.io.File;

public class VideoConversionFacade {

    public File convertVideo(final String fileName, final String format) {
        System.out.println("VideoConversionFacade: conversion started.");

        final VideoFile file = new VideoFile(fileName);
        final Codec sourceCodec = CodecFactory.extract(file);

        Codec destinationCodec;
        if (format.equals("mp4")) {
            destinationCodec = new OggCompressionCodec();
        } else {
            destinationCodec = new MPEG4CompressionCodec();
        }

        final VideoFile buffer = BitrateReader.read(file, sourceCodec);
        final VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);
        final File result = (new AudioMixer()).fix(intermediateResult);

        System.out.println("VideoConversionFacade: conversion completed.");

        return result;
    }
}
