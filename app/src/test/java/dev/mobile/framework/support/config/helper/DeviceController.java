package dev.mobile.framework.support.config.helper;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;

public class DeviceController {

    protected AndroidDriver driver;

    public DeviceController(WebDriver webDriver) {
        driver = ((AndroidDriver) webDriver);
    }

    public boolean wifiOn() {
        ConnectionState state = new ConnectionStateBuilder().withWiFiEnabled().build();
        androidDriver.setConnection(state);
         boolean status = state.isWiFiEnabled();
         return status;
        //androidDriver.toggleWifi();
        /*try {
            Runtime.getRuntime().exec("adb shell svc wifi enable");withWiFiEnabled
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public boolean wifiOff() {
        ConnectionState state = new ConnectionStateBuilder().withWiFiDisabled().build();
        androidDriver.setConnection(state);
        boolean status = state.isWiFiEnabled();
        Assert.assertTrue(state.isWiFiEnabled(),"wifi is switched off");
     //   androidDriver.toggleWifi();
        /*try {
            Runtime.getRuntime().exec("adb shell svc wifi disable");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return status;
    }

    public void blueToothToggle()  {
        Process status = null;
        try {
            status = (Runtime.getRuntime().exec("adb shell settings get global bluetooth_on"));
        if (status.toString() == "1") Runtime.getRuntime().exec("\n" +
                "adb shell am broadcast -a io.appium.settings.bluetooth --es setstatus disable ");
        else Runtime.getRuntime().exec("\n" +
                "adb shell am broadcast -a io.appium.settings.bluetooth --es setstatus enable");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void developerModeOn() {
        try {
            Runtime.getRuntime().exec("adb shell am start -S com.android.settings/.Settings/$DevelopmentSettingsActivity");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void screenOrientationToggle() {
        driver.rotate(ScreenOrientation.LANDSCAPE);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void notificationTest() {
        driver.toggleWifi();
    }

    public void blockAnimation()  {
        try {
            Runtime.getRuntime().exec("adb shell settings put global window_animation_scale 0 ");
            Runtime.getRuntime().exec("adb shell settings put global transition_animation_scale 0");
            Runtime.getRuntime().exec("adb shell settings put global animator_duration_scale 0");
            Thread.sleep(5000);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void enableAnimation()  {
        try {
            Runtime.getRuntime().exec("adb shell settings put global window_animation_scale 1");
            Runtime.getRuntime().exec("adb shell settings put global transition_animation_scale 1");
            Runtime.getRuntime().exec("adb shell settings put global animator_duration_scale 1");
            Thread.sleep(5000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void killAll() {
        //ConnectionState state = driver.setConnection(new ConnectionStateBuilder().withWiFiDisabled().build());
        //Assert.assertTrue(state.isWiFiEnabled(),"wifi is switched off");
        //androidDriver.toggleWifi();
        try {
            Runtime.getRuntime().exec("adb shell ps|grep -v root|grep -v system|grep -v NAME|grep -v shell|grep -v smartcard|grep -v androidshmservice|grep -v bluetooth|grep -v radio|grep -v nfc|grep -v \"com.android.\"|grep -v \"android.process.\"|grep -v \"com.google.android.\"|grep -v \"com.sec.android.\"|grep -v \"com.google.process.\"|grep -v \"com.samsung.android.\"|grep -v \"com.smlds\" |awk '{print $2}'| xargs adb shell kill");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

