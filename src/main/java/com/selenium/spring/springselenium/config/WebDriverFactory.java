package com.selenium.spring.springselenium.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    public WebDriver getWebDriver(String browser){
        return new ChromeDriver();
    }
}
