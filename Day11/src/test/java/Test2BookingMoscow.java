import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test2BookingMoscow {

    private static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "c:\\students\\AT2020-03-21\\Day10\\src\\resourse\\chromedriver");
        System.setProperty("webdriver.chrome.silentOutput", "true"); //Timeout does not clean

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 10);
        Date threeDay = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 5);
        Date tenDay = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String datePlusThreeDays =dateFormat.format(threeDay);
        String datePlusTenDays = dateFormat.format(tenDay);

        driver.get("https://booking.com");
        WebElement city = driver.findElement(By.id("ss"));
        city.sendKeys("Moscow");
        city.click();

        WebElement element = driver.findElement(By.xpath("//ul[@role = 'listbox']/li[1]"));
        element.click();

        WebElement dateCheckIn = driver.findElement(By.xpath(String.format("//*[@class='bui-calendar']//td[@data-date='%s']", datePlusThreeDays )));
        dateCheckIn.click();
        WebElement dateCheckOut = driver.findElement(By.xpath(String.format("//*[@class='bui-calendar']//td[@data-date='%s']", datePlusTenDays )));
        dateCheckOut.click();

        element = driver.findElement(By.xpath("//*[@id='xp__guests__toggle']"));
        Actions make = new Actions(driver);
        Action adultsRooms = make.moveToElement(element).click().
                moveToElement(driver.findElement(By.xpath("//*[@class='u-clearfix']//div[1]//div//div[2]//button[2]"))).
                click().click().
                moveToElement(driver.findElement(By.xpath("//*[@class='u-clearfix']//div[3]//div//div[2]//button[2]"))).
                click().build();
        adultsRooms.perform();
        element.submit();


        WebElement checkboxPriceMin = driver.findElement(By.xpath("//*[@id='filter_price']//a[1]"));
        checkboxPriceMin.click();
        int priceMin = Integer.parseInt(checkboxPriceMin.getText().replaceAll("[^0-9]+", ""));
        System.out.println(String.format("Maximum price of minimum: %d", priceMin));
        Thread.sleep(5000);

        WebElement price = driver.findElement(By.xpath("//*[@id='hotellist_inner']/div[1]//div[@aria-hidden='true']"));
        String priceMaxMin = price.getText().substring(4).replace(" ","");
        int priceMinFirst = Integer.parseInt(priceMaxMin)/5;
        System.out.println(String.format("Price first hotel: %d", priceMinFirst));

        driver.quit();

        Assert.assertTrue("This is not true!",  priceMinFirst <= priceMin);
    }
}
