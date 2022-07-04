package dev.mobile.framework.tests;


import org.testng.annotations.Test;

import java.io.IOException;
//Task 4
public class DeviceControlsTest extends BaseTest {

    @Test(description = "Test wifi on")
    public void WifiOnTest() {
        boolean status = deviceController().wifiOn();
        Assert.assertTrue(status, "Wifi is on");

    }

    @Test(description = "Test wifi off")
    public void WifiOffTest() {
        boolean status = deviceController().wifiOff();
        Assert.assertTrue(status, "Wifi is off");
    }

    @Test(description = "Blue tooth Toggle")
    public void bluetoothTest() {
        deviceController().blueToothToggle();
    }

    @Test(description = "developer mode on")
    public void developerModeTest() {
        deviceController().developerModeOn();
    }

    @Test(description = "screenOrientationTest")
    public void screenOrientationTest() {
        deviceController().screenOrientationToggle();
    }

    @Test(description = "animation block")
    public void animationBlock() {
        deviceController().blockAnimation();
    }

    @Test(description = "close apps in the background")
    public void closeAppTest() {
        deviceController().killAll();
    }
}
