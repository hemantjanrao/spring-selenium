package com.selenium.spring.springselenium.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

@Lazy
@Configuration
public class WebDriverConfig {

    @Value("${timeout:60}")
    private int webDriverWait;

    @Bean
    @Primary
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver firefoxDriver(){
        WebDriverManager.firefoxdriver().setup();

        return new FirefoxDriver();
    }

    @Bean
    @ConditionalOnMissingBean
    public WebDriver chromeDriver(){
        WebDriverManager.chromedriver().setup();

        return new ChromeDriver();
    }

    @Bean
    public WebDriverWait webDriverWait(WebDriver driver){
        return new WebDriverWait(driver, webDriverWait);
    }
}
