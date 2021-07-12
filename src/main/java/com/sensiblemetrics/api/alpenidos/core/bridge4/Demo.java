package com.sensiblemetrics.api.alpenidos.core.bridge4;

import com.sensiblemetrics.api.alpenidos.core.bridge4.devices.Device;
import com.sensiblemetrics.api.alpenidos.core.bridge4.devices.Radio;
import com.sensiblemetrics.api.alpenidos.core.bridge4.devices.Tv;
import com.sensiblemetrics.api.alpenidos.core.bridge4.remotes.AdvancedRemote;
import com.sensiblemetrics.api.alpenidos.core.bridge4.remotes.BasicRemote;

public class Demo {

    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");

        final BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");

        final AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}
