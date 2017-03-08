/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium.test;

import java.io.File;

/**
 *
 * @author Root
 */
public class SeleniumProperties {
    public File driverChrome = new File("D:/Development/Selenium/chromedriver.exe");
    public File driverEdge = new File("D:/Development/Selenium/MicrosoftWebDriver.exe");
    public void setDriverProperty(){
        System.setProperty("webdriver.chrome.driver", driverChrome.getAbsolutePath());
        System.setProperty("webdriver.edge.driver", driverEdge.getAbsolutePath());
    }
}
