import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test3BookingOslo {

    private static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "c:\\students\\AT2020-03-21\\Day10\\src\\resourse\\chromedriver");
        System.setProperty("webdriver.chrome.silentOutput", "true"); //Timeout does not clean

        driver.get("https://booking.com");
        WebElement city = driver.findElement(By.id("ss"));
        city.sendKeys("Oslo");
        city.click();
        WebElement element = driver.findElement(By.xpath("//ul[@role = 'listbox']//li[@data-i='0']"));
        element.click();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date threeDay = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tenDay = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String datePlusThreeDays =dateFormat.format(threeDay);
        String datePlusTenDays = dateFormat.format(tenDay);

        WebElement dateCheckIn = driver.findElement(By.xpath(String.format("//*[@class='bui-calendar']//td[@data-date='%s']", datePlusThreeDays )));
        dateCheckIn.click();
        WebElement dateCheckOut = driver.findElement(By.xpath(String.format("//*[@class='bui-calendar']//td[@data-date='%s']", datePlusTenDays )));
        dateCheckOut.click();

        element = driver.findElement(By.xpath("//*[@id='xp__guests__toggle']"));
        Actions make = new Actions(driver);
        Action adultsRooms = make.moveToElement(element).click().
                moveToElement(driver.findElement(By.xpath("//*[@class='u-clearfix']//div[2]//div//div[2]//button[2]"))).
                click().build();
        adultsRooms.perform();
        element.submit();

   //   WebElement checkboxStars = driver.findElement(By.xpath("//*[@id='filter_class']"));
        Action checkboxStar = make.moveToElement(driver.findElement(By.xpath("//*[@id='filter_class']/div[2]/a[1]"))).
                click().moveToElement(driver.findElement(By.xpath("//*[@id='filter_class']/div[2]/a[2]"))).
                click().build();
        checkboxStar.perform();
        Thread.sleep(5000);

        WebElement hotelTen = driver.findElement(By.xpath("//*[@id='hotellist_inner']/div[@data-hotelid][10]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", hotelTen);
        Thread.sleep(1000);
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.backgroundColor = 'lime'", hotelTen);
        Thread.sleep(2000);

        WebElement nameHotel = driver.findElement(By.xpath("//*[@id='hotellist_inner']/div[@data-hotelid][10]//span[@data-et-click]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.color = 'red'", nameHotel);
        Thread.sleep(5000);

        Assert.assertEquals("Change of color name of Hotel doesn't work","color: red;", nameHotel.getAttribute("style"));

        driver.quit();
    }
}
