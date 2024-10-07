package main.java.utilis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class webDriverManager {
    WebDriver driver;



    public void createDriver(String browser) {
        if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\AkhilaReddy\\edgedriver\\msedgedriver.exe");
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\AkhilaReddy\\chromedriver\\chromedriver.exe");
            driver = new ChromeDriver();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
