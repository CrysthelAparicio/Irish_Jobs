package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    private WebDriver driver;

    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.irishjobs.ie/login");
        //*[@id="app"]/div[2]/div/div[2]/button[1]
        /////*[@id="app"]/div[2]/div/div[2]/button[2]
        WebElement CookiesButton = driver.findElement(By.xpath("*[@id=\"app\"]/div[2]/div/div[2]/button[2]"));
        CookiesButton.click();
        //Login
        //*[@id="Email"]
        WebElement inputName = driver.findElement(By.id("Email"));
        inputName.sendKeys("apariciocrysthel@gmail.com");
        ////*[@id="Password"]
        WebElement inputPass = driver.findElement(By.id("Password"));
        inputPass.sendKeys("Guitarra3151");
        ///* //*[@id="loginButton"]
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

    }

    public static void main(String arg[]){
        BaseTest baseTest = new BaseTest();
        baseTest.setUp();
    }
}
