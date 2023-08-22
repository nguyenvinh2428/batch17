import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class LambdatestPractice {

    @Test
    public void TC_01() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground/");

        driver.findElement(By.xpath("//a[contains(.,'Input')]")).click(); //shorter version to not store click in as WebElement

        WebElement namefield = driver.findElement(By.cssSelector("input[id='name']"));
        namefield.sendKeys("Vinh");

        WebElement emailField = driver.findElement(By.cssSelector("input[id='inputEmail4']"));
        emailField.sendKeys("nguyenvinh01@gmail.com");

        WebElement password = driver.findElement(By.cssSelector("input[id='inputPassword4']"));
        password.sendKeys("password123");

        WebElement company = driver.findElement(By.cssSelector("input[id='company']"));
        company.sendKeys("mycompany");

        WebElement website = driver.findElement(By.cssSelector("input[id='websitename']"));
        website.sendKeys("www.mycompany.com");

        WebElement city = driver.findElement(By.cssSelector("input[id='inputCity']"));
        city.sendKeys("skokie");

        WebElement address1 = driver.findElement(By.cssSelector("input[id='inputAddress1']"));
        address1.sendKeys("123 address");

        WebElement address2 = driver.findElement(By.cssSelector("input[id='inputAddress2']"));
        address2.sendKeys("321 address");

        WebElement state = driver.findElement(By.cssSelector("input[id='inputState']"));
        state.sendKeys("IL");

        WebElement zipCode = driver.findElement(By.cssSelector("input[id='inputZip']"));
        zipCode.sendKeys("60077");

        WebElement submitButton = driver.findElement(By.xpath("//button[contains(.,'Submit')]"));
        submitButton.click();

        Thread.sleep(2000);

        List<WebElement> allText = driver.findElements(By.xpath("//p"));
        for (int i = 0; i < allText.size(); i++) {

            if (allText.get(i).getText().contains("Thanks")) {
                Assert.assertEquals(allText.get(i).getText(), "Thanks for contacting us, we will get back to you shortly");
                System.out.println(allText.get(i).getText());
                break;

            }
        }
    }
}
