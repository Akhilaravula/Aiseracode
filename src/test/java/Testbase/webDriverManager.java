package test.java.Testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;

public class webDriverManager {
    WebDriver driver;
    @Parameters
    public  WebDriver createDriver(String browser)
    {



        if(browser.equalsIgnoreCase("edge"))
        {
            System.setProperty("webdriver.edge.driver","C:\\Users\\AkhilaReddy\\edgedriver\\msedgedriver.exe");
            driver = new EdgeDriver();
        }
        else if(browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver","C:\\Users\\AkhilaReddy\\chromedriver\\chromedriver.exe");
           driver = new ChromeDriver();
        }

       return driver;

    }


}




    //{

        //System.setProperty("webdriver.chrome.driver","C:\\Users\\AkhilaReddy\\chromedriver\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        //return driver;
        //driver.get("https://www.demoqa.com/books");
        //System.out.println("Hello world!");
    //}


    //}
