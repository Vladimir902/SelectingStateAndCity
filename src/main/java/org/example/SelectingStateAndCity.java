package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SelectingStateAndCity {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        driver.findElement(By.id("firstName")).sendKeys("Vladimir");
        driver.findElement(By.id("lastName")).sendKeys("Malakovski");
        driver.findElement(By.id("userEmail")).sendKeys("vladicabt@hotmail.com");

        WebElement element = driver.findElement(By.id("gender-radio-1"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        /// Locate the "Male" radio button label using the for attribute
        WebElement maleGenderLabel = driver.findElement(By.cssSelector("label[for='gender-radio-1']"));

        // Click on the "Male" radio button label
        maleGenderLabel.click();

        driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys("0123456789");


        WebElement subjectsInput = driver.findElement(By.id("subjectsInput"));

        // Send keys to the Subjects input field
        subjectsInput.sendKeys("Math");
        subjectsInput.sendKeys(Keys.ENTER);

        //scroll down to on the page when you find specific element
        WebElement element2 = driver.findElement(By.id("currentAddress"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);

        //clicking on the third checkbox and entering home address in Address field
        driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']")).click();
        driver.findElement(By.id("currentAddress")).sendKeys("Kire Kostadinovski 17");


        //Locating and selecting the calendar
        try {
            driver.findElement(By.id("dateOfBirthInput")).click();
        } catch (NoSuchElementException e) {
            System.out.println("Date picker input field not found.");
        }

        //Entering valid month of birth in the calendar section
        try {
            driver.findElement(By.xpath("//div[@class='react-datepicker__month-dropdown-container react-datepicker__month-dropdown-container--select']/select/option[3]")).click();
        } catch (NoSuchElementException e) {
            System.out.println("Month dropdown or option not found.");
        }

        //Entering valid year of birth in the calendar section
        try {
            WebElement yearDropdown = driver.findElement(By.className("react-datepicker__year-select"));
            yearDropdown.click();


            Select selectYear = new Select(yearDropdown);
            selectYear.selectByValue("2022");

            driver.findElement(By.cssSelector(".react-datepicker__day.react-datepicker__day--013")).click();
        } catch (NoSuchElementException e) {
            System.out.println("Year dropdown not found.");
        }


        //finding the dropdowns and providing values in the State and City fields
        driver.findElement(By.cssSelector("#state")).click();

        try {
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='react-select-3-input']"))).sendKeys("Uttar");
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@id,'react-select')]"))).click();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        try {
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='react-select-4-input']"))).sendKeys("Merrut");
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@id,'react-select')]"))).click();
        } catch(NoSuchElementException e) {
            System.out.println(e.getMessage());
        }


    }

}

