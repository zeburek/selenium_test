/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium.test;

/**
 *
 * @author Root
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest  {
    public static SeleniumProperties prop = new SeleniumProperties();
    public static SeleniumTestProvider testProv = new SeleniumTestProvider();
    public static void main(String[] args) throws InterruptedException {
        prop.setDriverProperty();
        
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.ru");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Selenium");
        element = driver.findElement(By.name("btnG")); 
        element.click();
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                  .until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));

        testProv.setWebDriverForTest(driver);
        
        testProv.runTest();
        driver.quit();
    }
}
