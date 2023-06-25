import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.time.Duration;


public class WebDriverHome {

    // 0. Load Skillo site http://training.skillo-bg.com/ - Done
    // 1. Check Skillo logo element is visible - - Done
    // 2. Click login btn- - Done
    // 3. Validate that the URL is correct - Done
    // 4. Validate that the sign in text is visible - Done
    // 5. Enter user name - Done
    // 6. Enter pass - Done
    // 7. Select remember me btn - Done
    // 8. Click sign in and check the btn is enabled - Done
    // 9. Validate that the logout btn is visible - Done

    // TODO: 6/15/2023 - Home work for next time
    // 10.Validate that the Profile tab is visible
    // 11.Validate that the new post btn is visible
    // 12.Validate that the URL is correct

    //auto_user/ auto_pass
    private static WebDriver driver;
    final String URL = "http://training.skillo-bg.com:4300/posts/all";

    @BeforeMethod
    public void setupDriver (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("0. Load Skillo site http://training.skillo-bg.com/ ");
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void loginTest(){
        System.out.println("1. Check Skillo logo element is visible");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement homeLogoE1 = driver.findElement(By.id("homeIcon"));
        Assert.assertTrue(homeLogoE1.isDisplayed(), "HomeLogo is not visible");

        System.out.println("2.  Click login btn");
        WebElement loginBtn = driver.findElement(By.id("nav-link-login"));
        loginBtn.click();

        System.out.println(" 3. Validate that the URL is correct");
        //String expectedLoginPageURL = "http://training.skillo-bg.com:4300/users/login";


        System.out.println("4. Validate that the sign in text is visible");
        WebElement signBtn = driver.findElement(By.xpath("//p[text()='Sign in']"));
        Assert.assertTrue(signBtn.isDisplayed(), "Sign in btn is not displayed");

        System.out.println(" 5. Enter user name");
        WebElement userName = driver.findElement(By.name("usernameOrEmail"));
        userName.sendKeys("Iliya");

        System.out.println(" 6. Enter pass");
        WebElement pass = driver.findElement(By.id("defaultLoginFormPassword"));
        pass.clear();
        pass.sendKeys("123456");

        System.out.println(" 7. Select remember me btn");
        WebElement rememberBtn = driver.findElement(By.cssSelector(".remember-me-button"));
        rememberBtn.click();

        System.out.println(" 8. Click sign in and check the btn is enabled");
        WebElement signInBtn = driver.findElement(By.id("sign-in-button"));

        System.out.println("Sign in is enabled");
        Assert.assertTrue(signInBtn.isEnabled(), "Sign in Btn is not enable");
        signInBtn.click();

        System.out.println(" Validate that the logout btn is visible ");
        WebElement logOutBtn = driver.findElement(By.cssSelector(".fa-sign-out-alt"));
        Assert.assertTrue(logOutBtn.isDisplayed(), "Log-out Btn is not displayed");

        System.out.println(" 10. Validate that the Profile tab is visible ");
        WebElement profileTab = driver.findElement(By.id("nav-link-profile"));
        Assert.assertTrue(profileTab.isDisplayed(), "Profile Tab is not displayed");

        System.out.println(" 11.Validate that the new post btn is visible");
        WebElement newPost = driver.findElement(By.id("nav-link-new-post"));
        Assert.assertTrue(newPost.isDisplayed(), "New Post Btn is not displayed");

        System.out.println(" 12.Validate that the URL is correct");
        String expectedURL = "http://training.skillo-bg.com:4300/posts/all";
        wait.until(ExpectedConditions.urlToBe(expectedURL));

    }
    @AfterMethod
    public void cleanup(){
        driver.close();
    }

}
