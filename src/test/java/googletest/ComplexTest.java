package googletest;

import com.sun.deploy.util.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ComplexTest {
    private WebDriver driver;
    String eMail;


    @BeforeTest
    public void SetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void TearDown() { driver.close(); }

    @Test
    public void ComplexRegistrationTest()throws Exception {
        driver.get("https://temp-mail.org/uk/");
        eMail = driver.findElement(By.xpath("//*[@id=\"mail\"]")).getAttribute("value");

        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.xpath("//a[contains(@class, 'login')]")).click();

        driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys(eMail);
        driver.findElement(By.xpath("//button[@id=\"SubmitCreate\"]")).click();

        driver.findElement(By.xpath("//input[@id=\"customer_firstname\"]")).sendKeys("Name");
        driver.findElement(By.xpath("//input[@id=\"customer_lastname\"]")).sendKeys("SecName");
        driver.findElement(By.xpath("//input[@id=\"passwd\"]")).sendKeys("passw0rd");
        driver.findElement(By.xpath("//input[@id=\"address1\"]")).sendKeys("MyAdress");
        driver.findElement(By.xpath("//input[@id=\"city\"]")).sendKeys("MyCity");

        Select drpState = new Select(driver.findElement(By.xpath("//select[@id=\"id_state\"]")));
        drpState.selectByIndex(3);

        driver.findElement(By.xpath("//input[@id=\"postcode\"]")).sendKeys("40123");
        driver.findElement(By.xpath("//input[@id=\"phone_mobile\"]")).sendKeys("5-500-123");
        driver.findElement(By.xpath("//button[@id=\"submitAccount\"]")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//p[@class=\"info-account\"]")), "Welcome to your account. Here you can manage all of your personal information and orders.");

    }
}
