package test.java.TestBase;

import main.java.utilis.ConfigReader;
import main.java.utilis.webDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
       public   WebDriver driver;
      @BeforeMethod
    public void setUp()
     {
         //driver = webDriverManager.createDriver();

        //String urls = ConfigReader.getProperty("url");
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

      //  driver.get("https://www.guru99.com/");
        //System.out.println("urls");
    }
    // @AfterMethod
    //public void tearDown()
     //{
         //driver.quit();
    // }

}
