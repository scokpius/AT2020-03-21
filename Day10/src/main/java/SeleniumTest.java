import java.lang.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "c:\\students\\AT2020-03-21\\Day10\\src\\resourse\\chromedriver");
//        System.setProperty("webdriver.chrome.silentOutput", "true"); //Timeout does not clean
        // driver.get("https://selenium.dev");
        driver.get("https://google.com");
//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());
//        driver.navigate().to("https://ya.ru");
//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());
//        driver.navigate().back();
//        driver.navigate().refresh();
//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Погода Минск");
        element.submit();
        WebElement element1 = driver.findElement(By.xpath("//*[@id=\'tsf\']/div[2]/div[1]/div[2]/div/div[2]/input"));
        element1.clear();
        element1.sendKeys("Погода на завтра");
        element1.submit();
        System.out.println(driver.findElement(By.xpath("//*[@id=\'wob_tm\']")));
        driver.quit();
    }
}
