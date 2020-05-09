import java.lang.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    private static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "c:\\students\\AT2020-03-21\\Day10\\src\\resourse\\chromedriver");
        System.setProperty("webdriver.chrome.silentOutput", "true"); //Timeout does not clean
//        driver.get("https://selenium.dev");
//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());
//        driver.navigate().to("https://ya.ru");
//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());
//        driver.navigate().back();
//        driver.navigate().refresh();
//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());
        driver.get("https://google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Погода Минск");
        element.submit();
        Thread.sleep(1000);
        WebElement element1 = driver.findElement(By.xpath("//*[@id='wob_dp']/div[2]"));
        element1.click();
        String weatherDay = driver.findElement(By.xpath("//*[@id='wob_dp']/div[2]/div")).getAttribute("aria-label");
       // String weatherGrad = driver.findElement(By.cssSelector("svg[id='wob_gsvg'] > text[aria-label$='12:00']")).getText(); // тоько если текст видимый
        String path = "svg[id='wob_gsvg'] > text[aria-label$='"+weatherDay+" 12:00']";
        String weather = driver.findElement(By.cssSelector(path)).getAttribute("aria-label");
        String[] weatherGrad = weather.split(" ");
        System.out.println(String.format(" День недели: %s.\n Время определения температуры: 12:00.\n Температура: %s",
                weatherDay, weatherGrad[0]));
        driver.quit();
    }
}
