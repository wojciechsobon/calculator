package com.sobon.study.testing.app;

import com.sobon.study.testing.Main;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Main.class)
@WebAppConfiguration
@SpringBootTest
public class SeleniumTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setup() throws MalformedURLException {
        SpringApplication.run(Main.class);
        driver = new RemoteWebDriver(new URL("http://localhost:9515"), DesiredCapabilities.chrome());
    }

    @AfterClass
    public static void cleanUp() {
        driver.close();
    }

    @Test
    public void pageLoads() {
        driver.get("http://localhost:8080/");
        assertEquals("Kalkulator", driver.getTitle());
    }


}