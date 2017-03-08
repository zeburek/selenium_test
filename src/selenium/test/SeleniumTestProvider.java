/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium.test;

import java.util.List;
import java.util.ResourceBundle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Root
 */
public class SeleniumTestProvider {
    //Setting variables
    public final String checkString = "Check ";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public WebDriver mainDriver;
    private int testId = 0;
    private int testIdPassed=0;
    private String remHref;
    private final ResourceBundle seleniumStringBundle = ResourceBundle.getBundle("selenium/test/SeleniumStringsBundle");
    //End of variables
    
    public void runTest(){
        checkFirstLine();
        checkOpenImages();
        checkFirstImage();
        checkFirstLinkAfterReturn();
        checkForAllDone(testIdPassed==testId);
    }
    
    private void checkFirstLine(){
        List<WebElement> findElements = mainDriver.findElements(By.xpath("//*[@class='srg']//h3/a"));
        checkForPassedTest(findElements.get(0).getAttribute("href").contains("seleniumhq.org"));
        remHref = findElements.get(0).getAttribute("href");
    }
    
    private void checkOpenImages(){
        mainDriver.findElement(By.linkText(seleniumStringBundle.getString("test.Images"))).click();
        WebElement myDynamicElement = (new WebDriverWait(mainDriver, 10))
                  .until(ExpectedConditions.presenceOfElementLocated(By.id("ires")));
        checkForPassedTest(mainDriver.getCurrentUrl().contains("tbm=isch"));
    }
    
    private void checkFirstImage() {
        List<WebElement> findElements = mainDriver.findElements(By.xpath("//*[@id=\"rg_s\"]/div/a"));
        checkForPassedTest(findElements.get(0).getAttribute("href").contains("seleniumhq.org"));
    }
    
    private void checkFirstLinkAfterReturn(){
        mainDriver.findElement(By.linkText(seleniumStringBundle.getString("test.All"))).click();
        WebElement myDynamicElement = (new WebDriverWait(mainDriver, 10))
                  .until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));
        
        List<WebElement> findElements = mainDriver.findElements(By.xpath("//*[@class='srg']//h3/a"));
        checkForPassedTest(findElements.get(0).getAttribute("href").equals(remHref));
    }
    
    public void setWebDriverForTest(WebDriver driver){
        mainDriver = driver;
    }
    
    private void checkForPassedTest(boolean b){
        testId++;
        if(b){
            testIdPassed++;
            System.out.println(ANSI_GREEN+checkString+"passed"+"("+testId+")"+ANSI_RESET);
        } else {
            System.out.println(ANSI_RED+checkString+"failed"+"("+testId+")"+ANSI_RESET);
            /*try {
                throw new TestFailException();
            } catch (TestFailException ex) {
                Logger.getLogger(SeleniumTestProvider.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        }
    }
    
    private void checkForAllDone(boolean b){
        if(b){
            testIdPassed++;
            System.out.println(ANSI_GREEN+"TEST PASSED!"+ANSI_RESET);
        } else {
            System.out.println(ANSI_RED+"TEST FAILED!"+ANSI_RESET);
        }
    }

    
}
