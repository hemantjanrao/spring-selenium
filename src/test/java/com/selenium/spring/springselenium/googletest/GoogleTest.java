package com.selenium.spring.springselenium.googletest;

import com.github.javafaker.Faker;
import com.selenium.spring.springselenium.SpringBaseTestNg;
import com.selenium.spring.springselenium.page.google.GooglePage;
import com.selenium.spring.springselenium.util.ScreenshotUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class GoogleTest extends SpringBaseTestNg {

    @Autowired
    private GooglePage googlePage;

    @Autowired
    private ScreenshotUtil screenshotUtil;

    @Autowired
    private Faker faker;

    @AfterMethod
    public void tearDown(){
        this.screenshotUtil.takeScreenshot(faker.file().fileName());
        this.googlePage.close();
    }

    @Test
    public void googleTest(){
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());

        this.googlePage.getSearchComponent().search("spring boot");

        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
    }

}
