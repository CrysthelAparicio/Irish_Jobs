package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class BaseTest {
    private WebDriver Webdriver;

    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        Webdriver = new ChromeDriver();
        Webdriver.get("https://www.irishjobs.ie/login");
        //*[@id="app"]/div[2]/div/div[2]/button[1]
        /////*[@id="app"]/div[2]/div/div[2]/button[2]

        System.out.println("Login");
     //*   WebElement CookiesButton = driver.findElement(By.xpath("*[@id=\"app\"]/div[2]/div/div[2]/button[2]"));
       //** CookiesButton.click();
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

        WebElement loginButton = Webdriver.findElement(By.linkText("loginButton"));
        loginButton.click();




    }

    public static void main(String arg[]){
        BaseTest baseTest = new BaseTest();
        baseTest.setUp();
    }
}
