package com.sobon.study.testing.app;

import com.sobon.study.testing.Main;
import com.sobon.study.testing.pageObjects.CalculatorPage;
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
    private static CalculatorPage page;

    @BeforeClass
    public static void setup() throws MalformedURLException {
        SpringApplication.run(Main.class);
        driver = new RemoteWebDriver(new URL("http://localhost:9515"), DesiredCapabilities.chrome());
        page = new CalculatorPage(driver);
    }

    @AfterClass
    public static void cleanUp() {
        driver.close();
    }

    @Test
    public void pageLoads() {
        page.openPage();
        assertEquals("Kalkulator",page.getTitle());
    }

    @Test
    public void addTest(){
        page.openPage();
        page.setFirstNumber("1");
        page.setSecondNumber("2");
        page.chooseOperation("add");
        page.sumbit();

        assertEquals("Wynik: 3.0",page.getResult());
    }

}