package com.hepsiburada.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class Driver {

    private Driver(){}

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();


    public static WebDriver getDriver(){

        if(driverPool.get()==null){

            String browser = ConfigurationReader.getProperty("browser");
            String headless = ConfigurationReader.getProperty("headless");
            switch (browser) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless=new");
                    if(headless.equalsIgnoreCase("true")){
                        driverPool.set((new ChromeDriver(options)));
                    }else{
                        driverPool.set((new ChromeDriver()));
                    }
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                break;
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--headless=new");
                    if(headless.equalsIgnoreCase("true")){
                        driverPool.set((new FirefoxDriver(firefoxOptions)));
                    }else{
                        driverPool.set((new FirefoxDriver()));
                    }
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                break;
            }


        }
        return driverPool.get();
    }

    public static void closeDriver(){
        if(driverPool.get() !=null){
            driverPool.get().quit();
            driverPool.remove();
        }
    }


}
