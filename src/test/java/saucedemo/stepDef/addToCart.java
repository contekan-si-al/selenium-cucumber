package saucedemo.stepDef;

import org.junit.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import saucedemo.config.env;
import java.util.concurrent.TimeUnit;

public class addToCart extends env{
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User Login saucedemo")
    public void user_login_saucedemo() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Thread.sleep(500);
    }

    @When("User klik tombol Add to Cart")
    public void user_klik_tombol_add_to_cart() throws Exception {
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        Thread.sleep(500);
    }

    @And("User klik icon cart")
    public void user_klik_icon_cart() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        Thread.sleep(500);
    }

    @Then("User melihat hasil pilihan produk")
    public void user_melihat_hasil_pilihan_produk() {
        Assert.assertEquals("Sauce Labs Backpack",driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText());
        System.out.println("Scenario : Adding product to cart");
        System.out.println("If Success Add Product to Cart " + driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText() + " , You Can See Title Product Name " + driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText() + "  in Cart Page");
        driver.quit();
    }

}
