package googletest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleSearchTest {
    private WebDriver driver;


    @BeforeTest
    public void SetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    @AfterTest
    public void TearDown() { driver.close(); }

    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {

        return new Object[][] { { "John" }, { "Wick" } };

    }

    @Test(dataProvider = "data-provider")
    public void SearchTest(String data) {
        driver.findElement(By.xpath("//input[@class=\"gLFyf gsfi\"]")).sendKeys(data);
        driver.getTitle().contains(data);

    }

}
