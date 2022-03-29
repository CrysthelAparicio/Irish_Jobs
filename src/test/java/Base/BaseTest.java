package Base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

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





        //*[@id="page"]/div[3]/div/div[1]/div/div/div/div[1]/div[1]/div[1]
        //*[@id="page"]/div[3]/div/div[1]/div/div/div/div[1]/div[1]/div[2]
    }

    private void Login(){
        /*WebElement optionOne = webDriver.findElement(By.xpath("//*[@id='flights']/div[1]/a"));
        optionOne.click();*/

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


        try{
            WebElement ActualTitle = Webdriver.findElement(By.xpath("//*[@id=\'page\']/div[3]/div/div[1]/div/div/h2"));
            String ExpectedTitle = "RECOMMENDED JOBS FOR YOU";
            Assert.assertEquals(ExpectedTitle, ActualTitle.getText());
            System.out.println("Assertions True");
        }
        catch (Exception e){
            System.out.println("False");
        }

    }

    public static void main(String arg[]){
        BaseTest baseTest = new BaseTest();
        baseTest.setUp();
    }
}
