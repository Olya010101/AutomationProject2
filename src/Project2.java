import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.lang.*;


public class Project2 {

//import static org.testng.AssertJUnit.assertTrue;

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vlada\\Downloads\\Selenium\\Drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        Thread.sleep(2000);

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("[href='Process.aspx'")).click();

        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys("" + randomProductQuantity());
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();

        String totalNumber = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal")).getAttribute("value");
        //System.out.println(randomProductQuantity());
        //System.out.println(calculate());

        //Assert.assertEquals(totalNumber, calculate());

    }

    public static int randomProductQuantity() {
        int randomQuantity;

        randomQuantity = (int)(Math.random()*100);

        return randomQuantity;
    }

    public static String calculate() {
        int total = randomQuantity * 100;

        return "" + total;

    }

    public static String randomFirstName() {

        String str = "abcdefghjklmnopqrstuvwxyz";
        String str2 = "ABCDEFGHJKLMNOPQRSTUVWXYZ";
        String remaining = "";

                String firstLetter = "" + Math.random();

        for (int i = 0; i < 6; i++) {

            remaining += Math.random();
        }

        return firstLetter + remaining;
    }


    public static String randomLastName() {

        String str = "abcdefghjklmnopqrstuvwxyz";
        String str2 = "ABCDEFGHJKLMNOPQRSTUVWXYZ";
        String remaining = "";

        String firstLetter = "" + Math.random();

        for (int i = 0; i < 6; i++) {

            remaining += Math.random();
        }

        return firstLetter + remaining;
    }



}
