package Base;

import jdk.dynalink.beans.StaticClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.sql.Driver;

public class BaseTest {
    private WebDriver Webdriver;

    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        Webdriver = new ChromeDriver();
        Webdriver.get("https://www.irishjobs.ie/login");
        Login();
        SearchRecomendations();
        RecomendedJobsForYour();
        Webdriver.quit();


    }

    private void Login(){
        /*WebElement optionOne = webDriver.findElement(By.xpath("//*[@id='flights']/div[1]/a"));
        optionOne.click();*/

        //*[@id="app"]/div[2]/div/div[2]/button[2]
        WebElement CoockieAccept = Webdriver.findElement(By.xpath(" //*[@id=\'app\']/div[2]/div/div[2]/button[2]"));
        CoockieAccept.click();
        //Login
        //*[@id="Email"]
        WebElement inputName = Webdriver.findElement(By.id("Email"));
        inputName.sendKeys("apariciocrysthel@gmail.com");
        inputName.sendKeys(Keys.ENTER);
        ////*[@id="Password"]
        WebElement inputPass = Webdriver.findElement(By.id("Password"));
        inputPass.sendKeys("Guitarra3151");
        ///* //*[@id="loginButton"]
        inputPass.sendKeys(Keys.ENTER);


        /*
        WebElement loginButton1 = Webdriver.findElement(By.id("loginButton"));
        loginButton1.click();
        loginButton1.sendKeys(Keys.ENTER);
        */
        /*

*/

    }
    private void SearchRecomendations(){
        /*WebElement optionOne = webDriver.findElement(By.xpath("//*[@id='flights']/div[1]/a"));
        optionOne.click();*/

        System.out.println("Find Job");

        WebElement SearchButton = Webdriver.findElement(By.xpath("//*[@id=\'logged-in\']/li[1]/a"));
        SearchButton.click();
        /*Webdriver.findElement(By.xpath("//*[@id=\'page\']/div[3]/div/div[1]/div/div/h2"));
        Alert alert= Webdriver.switchTo().alert();
        alert.accept();*/

    }

    private void RecomendedJobsForYour(){


        WebElement ActualTitle = Webdriver.findElement(By.xpath("//*[@id=\'page\']/div[3]/div/div[1]/div/div/h2"));
        String ExpectedTitle = "RECOMMENDED JOBS FOR YOU";
        //SoftAssert SoftAssert = new SoftAssert();
        Assert.assertEquals(ExpectedTitle, ActualTitle.getText());
        try{
            System.out.println("Assertions True Title");

         }
        catch (Exception e){
            System.out.println("Assertions False");
        }

        ArrayList<String> list = new ArrayList<>();
        list.add("");
        list.add("Elements for this Recommendations");
        List<WebElement> li_Group = Webdriver.findElements(By.className("similar-job-listings"));
        /*
        int i = 1;
        while (i<li_Group.size()){
            WebElement element;
            element = Webdriver.findElement(By.xpath("/html/body/div/div[3]/div/div[1]/div/div/div/div[1]/div[1]/div["+i+"]"));
            list.add(getAttribute(element,"textContent"));
        }

        i=i+1;
        System.out.println("Elements "+ i);
        */
        Boolean HaveElements = li_Group.size()>0;
        Assert.assertTrue(HaveElements);
        System.out.println("Assertions True Valores Mayores a 0");

    }

    public static String getAttribute(WebElement element, String attribute){
        return element.getAttribute(attribute);
    }

    public static void main(String arg[]){
        BaseTest baseTest = new BaseTest();
        baseTest.setUp();
    }
}
