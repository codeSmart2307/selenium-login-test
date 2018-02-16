import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenChrome {

    @Test
    public void openChromeBrowser() {
        //Open web browser
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Navigate to website
        driver.get("http://opensource.demo.orangehrmlive.com/");
        String title = driver.getTitle();
        System.out.println(title);

        //Interact with web page
        Assert.assertEquals(title, "OrangeHRM");
        //Verify content (assertion)
    }
}

