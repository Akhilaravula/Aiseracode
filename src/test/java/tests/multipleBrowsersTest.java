package test.java.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import main.java.utilis.webDriverManager;

public class multipleBrowsersTest {
    WebDriver driver;

    @Test
    @Parameters("browser")
    public void verifywindowTitle(String browser) {
        webDriverManager wb = new webDriverManager();
        wb.createDriver(browser);
        driver = wb.getDriver();
        driver.get("https://www.guru99.com/");
        System.out.println("Page Title is :" + driver.getTitle());
        driver.quit();
    }
}
h