package test.java.tests;

import main.java.utilis.webDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import test.java.TestBase.TestBase;
import test.java.pages.FillForm;

import java.util.concurrent.TimeUnit;


public class LoginPageTest extends TestBase {
   @Test
   public void fillform() {
       FillForm f = new FillForm(driver);
           //driver.get(urls)
            //f.clickbutton();
            //f.getelements();
            f.UploadFile();
            //f.compare();
           // f.compareiterator();

           //fillform.method();
           //driver.findElement()

       }



}
