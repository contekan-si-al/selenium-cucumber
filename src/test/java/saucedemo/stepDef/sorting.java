package saucedemo.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class sorting {
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";


        @Given("User Login saucedemo sukses")
        public void user_login_saucedemo_sukses() throws Exception {
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

        @When("User klik Name A to Z")
        public void user_klik_name_a_to_z() throws Exception {
                driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
                Thread.sleep(500);
        }

        @And("User pilih harga low to high")
        public void user_pilih_harga_low_to_high() throws Exception {
                driver.findElement(By.xpath("//option[@value='lohi']")).click();
                Thread.sleep(500);
        }

        @Then("User melihat produk terurut")
        public void user_melihat_produk_terurut() {
                Assert.assertEquals("$7.99",driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[2]//div[2]//div[1]")).getText());
                System.out.println("Scenario : choose price (low to high)");
                System.out.println("If Success Sorting Price Low to High, You Can See Firt Product Will See Price " + driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[2]//div[2]//div[1]")).getText());
                driver.quit();
        }

}
