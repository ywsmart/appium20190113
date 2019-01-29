package com.hogwarts.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Function：driver类
 *
 * @author YangWang
 * @date 2019-01-13
 * Created by YangWang on 2019-01-13 15:06.
 */
public class Driver {
    private static AppiumDriver<AndroidElement> driver;

    public static void start() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        GlobalConfig config = GlobalConfig.load("/data/globalConfig.yaml");
        config.appium.capabilities.keySet().forEach(key -> {
            Object value = config.appium.capabilities.get(key);
            desiredCapabilities.setCapability(key, value);
        });

        URL remoteUrl = null;
        try {
            remoteUrl = new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static AppiumDriver<AndroidElement> getCurrentDriver() {
        return driver;
    }
}
