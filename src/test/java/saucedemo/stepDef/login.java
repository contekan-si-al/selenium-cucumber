package saucedemo.stepDef;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import saucedemo.pages.DashboardPage;
import saucedemo.config.env;

import java.util.concurrent.TimeUnit;

public class login extends env{
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    DashboardPage dashboardPage;

    @Given("Halaman Login saucedemo")
    public void halamanLoginSaucedemo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

    }

    @When("Input Username")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input Password")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("clik Login button")
    public void clikLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User in on dashboard page")
    public void userInOnDashboardPage() {
        dashboardPage = new DashboardPage(driver);
        dashboardPage.userInDashboard();
        driver.quit();
    }

    @And("Input Invalid Password")
    public void inputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("secretsauce");
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        String errorLogin = driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match any user in this service')]")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }
}
