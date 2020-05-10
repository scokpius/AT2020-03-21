import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test1BookingParis {

    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "c:\\students\\AT2020-03-21\\Day10\\src\\resourse\\chromedriver");
        System.setProperty("webdriver.chrome.silentOutput", "true"); //Timeout does not clean

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 3);
        Date threeDay = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date tenDay = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String datePlusThreeDays =dateFormat.format(threeDay);
        String datePlusTenDays = dateFormat.format(tenDay);

        driver.get("https://booking.com");
        WebElement city = driver.findElement(By.id("ss"));
        city.sendKeys("Paris");
        city.click();
        WebElement element = driver.findElement(By.xpath("//ul[@role = 'listbox']//li[@data-i='0']"));
        element.click();

        WebElement dateCheckIn = driver.findElement(By.xpath(String.format("//*[@class='bui-calendar']//td[@data-date='%s']", datePlusThreeDays )));
        dateCheckIn.click();
        WebElement dateCheckOut = driver.findElement(By.xpath(String.format("//*[@class='bui-calendar']//td[@data-date='%s']", datePlusTenDays )));
        dateCheckOut.click();



        element = driver.findElement(By.xpath("//*[@id='xp__guests__toggle']"));
        element.click();
        WebElement adults = driver.findElement(By.xpath("//*[@class='u-clearfix']//div[1]//div//div[2]//button[2]"));
        adults.click();
//        adults.click();
        WebElement rooms = driver.findElement(By.xpath("//*[@class='u-clearfix']//div[3]//div//div[2]//button[2]"));
        rooms.click();
        WebElement adults1 = driver.findElement(By.xpath("//*[@class='u-clearfix']//div[1]//div//div[2]//button[2]"));
        adults1.click();
        adults1.submit();

        WebElement checkboxPriceMax = driver.findElement(By.xpath("//*[@id='filter_price']//a[5]"));
        checkboxPriceMax.click();
        int priceMax = Integer.parseInt(checkboxPriceMax.getText().replaceAll("[^0-9]+", ""));
        System.out.println(String.format("Maximum price: %d", priceMax));
        Thread.sleep(5000);

        WebElement sortingMin = driver.findElement(By.xpath("//*[@id='sort_by']/ul/li[3]/a"));
        sortingMin.click();
        Thread.sleep(5000);

        WebElement price = driver.findElement(By.xpath("//*[@id='hotellist_inner']/div[1]//div[@aria-hidden='true']"));
        int priceMaxMin = Integer.parseInt(price.getText().substring(4).replace(" ",""))/7;
        System.out.println(String.format("Minimum price of maximum: %d", priceMaxMin));

        driver.quit();


        Assert.assertTrue("This is not true!", priceMaxMin >= priceMax);


    }
}
