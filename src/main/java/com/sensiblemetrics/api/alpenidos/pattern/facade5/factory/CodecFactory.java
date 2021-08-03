package com.sensiblemetrics.api.alpenidos.pattern.facade5.factory;

import com.sensiblemetrics.api.alpenidos.pattern.facade5.codec.Codec;
import com.sensiblemetrics.api.alpenidos.pattern.facade5.codec.MPEG4CompressionCodec;
import com.sensiblemetrics.api.alpenidos.pattern.facade5.codec.OggCompressionCodec;
import com.sensiblemetrics.api.alpenidos.pattern.facade5.model.VideoFile;

public class CodecFactory {

    public static Codec extract(VideoFile file) {
        String type = file.getCodecType();
        if (type.equals("mp4")) {
            System.out.println("CodecFactory: extracting mpeg audio...");
            return new MPEG4CompressionCodec();
        }

        System.out.println("CodecFactory: extracting ogg audio...");
        return new OggCompressionCodec();
    }
}
