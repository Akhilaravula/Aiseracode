package test.java.pages;
import main.java.utilis.webDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import  java.time.Duration;
import test.java.pages.Staticvalues.*;

public class FillForm {
        public WebDriver driver;
        Duration d;
        WebDriverWait wait;
        ArrayList element;
        Staticvalues s;
        ArrayList listfroms;

        public FillForm(WebDriver driver) {
            this.driver = driver;
            this.d =  Duration.ofSeconds(50);
            this.wait = new WebDriverWait(driver,d);
            this.s = new Staticvalues();
            this.listfroms = s.getelementslist();
            this.element = new ArrayList();
            System.out.println(listfroms);
            System.out.println(s);

        }


       private By buttonlocator = By.xpath("//a[@title='Software Testing']");

        public void clickbutton(){
              WebElement labelone = driver.findElement(buttonlocator);
              String labelonetext = labelone.getText();

              //System.out.println(labelonetext);


        }
        public void getelements() {

            element = new ArrayList();
            element.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='QTP (Quick Test Professional)']"))).getText());
            element.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='java_technologies']/descendant::a[@title='Selenium']"))).getText());
            element.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Mobile App Testing']"))).getText());
            element.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Cucumber Testing']"))).getText());
            element.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='SoapUI']"))).getText());

            Iterator ele = element.iterator();
            while (ele.hasNext()) {
                System.out.println(" myelement" + " " + ele.next());
            }
        }
             /**  public void compare()
        {
            boolean isequal= true;
            //System.out.println("method");
            if(isequal){
                System.out.println("All items are matched");
            } else{
                System.out.println("few of them are not matched");
            }
            for(int i=0;i<element.size();i++)
            {

                if(listfroms.get(i).equals(element.get(i))){

              }
            }
            }  */

               public void compareiterator()
               {
                   boolean isequal= true;
                   //System.out.println("method");
                   if(isequal){
                       System.out.println("All items are matched");
                   } else{
                       System.out.println("few of them are not matched");
                   }
                   Iterator ele= element.iterator();
                   Iterator lis = listfroms.iterator();
                   while(ele.hasNext() && lis.hasNext())
                   {
                       if(ele.next().equals(lis.next())){
                   }
               }

}

    public void UploadFile()
    {
        System.out.println("Hello1");

        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
        System.out.println("Hello2");


        WebElement upload = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='file']")));
        upload.sendKeys("C:\\Users\\AkhilaReddy\\Downloads\\page.html");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Press']"))).click();

        System.out.println(upload);

        System.out.println("Hello4");
    }

}
