package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class Base {

    public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException {
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/global.properties");
        Properties prop=new Properties();
        prop.load(fis);

        AndroidDriver<AndroidElement> driver;

        File appDir=new File("src/main/java");
        File app=new File(appDir,(String)prop.get(appName));
        DesiredCapabilities cap=new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        String device=(String) prop.get("device");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,device);
        cap.setCapability(MobileCapabilityType.NO_RESET,false);
        cap.setCapability("uiautomator1ServerInstallTimeout","5000");
        cap.setCapability("uiautomator1ServerLaunchTimeout","5000");
        cap.setCapability("adbExecTimeout","3000");
        cap.setCapability("autoGrantPermissions",false);
        cap.setCapability("appPackage", "com.nobroker.app");
        cap.setCapability("appActivity", "com.nobroker.app.activities.NBSplashScreen");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        cap.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
        driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);
        return driver;
    }
}
