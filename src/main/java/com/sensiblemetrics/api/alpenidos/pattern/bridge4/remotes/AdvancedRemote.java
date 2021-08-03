package com.sensiblemetrics.api.alpenidos.pattern.bridge4.remotes;

import com.sensiblemetrics.api.alpenidos.pattern.bridge4.devices.Device;

public class AdvancedRemote extends BasicRemote {

    public AdvancedRemote(Device device) {
        super.device = device;
    }

    public void mute() {
        System.out.println("Remote: mute");
        device.setVolume(0);
    }
}
