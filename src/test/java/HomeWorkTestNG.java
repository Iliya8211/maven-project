package lecture14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWorkWaits {
    //Test scenario ID:2 - Check that the Log out Btn is visible and is not as well
    //1. Log in into the Skillo portal
    //2. Check that it is correct page
    //3. Log In into Skillo portal
    //4.Verify successful logIn - popUp message
    //5. Check that Log Out Btn is enable
    //6. Press the Log Out Btn
    //7. Verify that you are Log Out

    private static ChromeDriver driver;
    private final String HOME_URL = "http://training.skillo-bg.com/posts/all";

    @BeforeMethod
    public void setup (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get(HOME_URL);
    }
   @Test
   public void logInIntoPortal (){
       System.out.println("1. Log in into the Skillo portal");
       WebElement homePage = driver.findElement(By.id("nav-link-login"));
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
       wait.until(ExpectedConditions.elementToBeClickable(homePage)); //clickable means is displayed and is enabled at the same time.
       homePage.click();

       System.out.println("2. Check that it is correct page");
       WebElement logIn = driver.findElement(By.cssSelector(".h4"));
       String actualHeaderText = logIn.getText();
       Assert.assertEquals(actualHeaderText, "Sign in", "Expected header text to be, but got" +
               actualHeaderText);

       System.out.println("3. Log In into Skillo portal");
       WebElement username = driver.findElement(By.id("defaultLoginFormUsername"));
       wait.until(ExpectedConditions.visibilityOf(username));
       username.clear();//Its not supposed to be any letters in it but for the learning purpose it added it.
       username.sendKeys("iliya");

       WebElement password = driver.findElement(By.id("defaultLoginFormPassword"));
       wait.until(ExpectedConditions.visibilityOf(password));
       password.clear(); //same story as username
       password.sendKeys("123456");

       WebElement signIn = driver.findElement(By.id("sign-in-button"));
       wait.until(ExpectedConditions.visibilityOf(signIn));
       signIn.click();

       System.out.println("4.Verify successful logIn - popUp message");
       WebElement toastElement = driver.findElement(By.cssSelector(".toast-message"));// we get those locators after JavaScript on page was disabled
       wait.until(ExpectedConditions.visibilityOf(toastElement));
       String toastMsg = toastElement.getText().trim();
       Assert.assertEquals(toastMsg, "Successful login!", "Log In not successful, but got " + toastMsg);

       System.out.println("5. Check that Log Out Btn is enable");
       WebElement logOutBtn = driver.findElement(By.cssSelector(".fa-sign-out-alt"));
       wait.until(ExpectedConditions.visibilityOf(logOutBtn));
       Assert.assertTrue(logOutBtn.isEnabled(), "Log Out Btn is not enable and you cannot click on it");

       System.out.println("6. Press the Log Out Btn");
       logOutBtn.click();

       System.out.println("7. Verify that you are Log Out");
       WebElement logOutToastMsg = driver.findElement(By.cssSelector(".toast-message")); // we get those locators after JavaScript on page was disabled
       wait.until(ExpectedConditions.visibilityOf(logOutToastMsg));
       String actualLogOutText = logOutToastMsg.getText().trim();
       Assert.assertEquals(actualLogOutText, "Successful logout!", "Log out not successful, we got"
       + actualLogOutText);
   }
   @AfterMethod
    public void cleanup (){
        driver.close();
   }
}

