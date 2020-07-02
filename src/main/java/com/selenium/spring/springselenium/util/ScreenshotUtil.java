package com.selenium.spring.springselenium.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Path;

@Component
public class ScreenshotUtil {

    @Autowired
    private WebDriver driver;

    @Value("${screenshot.path}/img.png")
    private Path path;

    public void takeScreenshot(final String fileName){
        try {
            File screenshotAs = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(screenshotAs, this.path.resolve(fileName).toFile());
        } catch (Exception ignored){
            System.out.println("File Exception");
        }
    }
}
