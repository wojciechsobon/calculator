package com.sobon.study.testing.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage {

    private WebDriver driver;

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("http://localhost:8080/");
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void setFirstNumber(String number) {
        WebElement elem = driver.findElement(By.name("Liczba1"));
        elem.sendKeys(number);
    }

    public void setSecondNumber(String number) {
        WebElement elem = driver.findElement(By.name("Liczba2"));
        elem.sendKeys(number);
    }

    public void chooseOperation(String id) {
        WebElement element = driver.findElement(By.id(id));
        element.click();
    }

    public void sumbit() {
        driver.findElement(By.id("submit")).click();
    }

    public String getResult() {
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("result"))).getText();
    }
}
