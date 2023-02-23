package FirstTest;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Alerts {

    WebDriver driver;

    @BeforeClass
    public void BeforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

    }

    @AfterClass
    public void AfterClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void clickForOk() {
        WebElement buttonConfirm = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        buttonConfirm.click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();

        WebElement result = driver.findElement(By.id("result"));
        String resultText = result.getText();

        Assert.assertEquals(alertText, "I am a JS Confirm");
        Assert.assertEquals(resultText, "You clicked: Ok");
    }

    @Test
    public void clickForCancel() {
        WebElement buttonConfirm = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        buttonConfirm.click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.dismiss();

        WebElement result = driver.findElement(By.id("result"));
        String resultText = result.getText();

        Assert.assertEquals(alertText, "I am a JS Confirm");
        Assert.assertEquals(resultText, "You clicked: Cancel");
    }

    @Test
    public void clickForPromptOkSend() {
        WebElement buttonConfirm = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        buttonConfirm.click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.sendKeys("QA Kostina");
        alert.accept();

        WebElement result = driver.findElement(By.id("result"));
        String resultText = result.getText();

        Assert.assertEquals(alertText, "I am a JS prompt");
        Assert.assertEquals(resultText, "You entered: QA Kostina");
    }
    @Test
    public void clickForPromptOk() {
        WebElement buttonConfirm = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        buttonConfirm.click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();

        WebElement result = driver.findElement(By.id("result"));
        String resultText = result.getText();

        Assert.assertEquals(alertText, "I am a JS prompt");
        Assert.assertEquals(resultText, "You entered:");
    }

    @Test
    public void clickForPromptCancelSend() {
        WebElement buttonConfirm = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        buttonConfirm.click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.sendKeys("QA Kostina");
        alert.dismiss();

        WebElement result = driver.findElement(By.id("result"));
        String resultText = result.getText();

        Assert.assertEquals(alertText, "I am a JS prompt");
        Assert.assertEquals(resultText, "You entered: null");
    }
    @Test
    public void clickForPromptCancel() {
        WebElement buttonConfirm = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        buttonConfirm.click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.dismiss();

        WebElement result = driver.findElement(By.id("result"));
        String resultText = result.getText();

        Assert.assertEquals(alertText, "I am a JS prompt");
        Assert.assertEquals(resultText, "You entered: null");
    }

}
