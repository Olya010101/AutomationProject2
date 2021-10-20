import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import java.lang.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.Date;

public class Project2 {


    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vlada\\Downloads\\Selenium\\Drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.cssSelector("[href='Process.aspx'")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        int randomQuantity = (int) (Math.random() * 100);

        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys("" + randomQuantity);
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        if (randomQuantity < 10) {

            String actualTotalNumber = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal")).getAttribute("value");
            String expectedTotalNumber = "" + (int) ((randomQuantity * 100));

            assertEquals(actualTotalNumber, expectedTotalNumber);

        } else if (randomQuantity >= 10) {

            String actualTotalNumber = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal")).getAttribute("value");
            String expectedTotalNumber = "" + (int) ((randomQuantity * 100) - (randomQuantity * 100 * 0.08));

            assertEquals(actualTotalNumber, expectedTotalNumber);

        } else {

            System.out.println("Wrong quantity");
        }

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(randomFirstOrLastNameOrCityOrState() + " " + randomFirstOrLastNameOrCityOrState());
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(randomStreetAddress());
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(randomFirstOrLastNameOrCityOrState());
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(randomState());
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(randomZipCode());
        List <WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
        int randomNo = (int)(Math.random()* radioButtons.size());
        radioButtons.get(randomNo).click();

        String Visa = "";
        String MasterCard = "";
        String AMEX = "";
        String cardNum = "0123456789";

        switch (randomNo) {

            case 0:

            for (int i = 0; i < 15; i++) {

                Visa += (int)(Math.random()*cardNum.length());

            }

            driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("4" + Visa);
            break;

            case 1:

                for (int i = 0; i < 15; i++) {

                    MasterCard += (int)(Math.random()*cardNum.length());

                }

                driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("5" + MasterCard);
                break;

            case 2:

                for (int i = 0; i < 14; i++) {

                    AMEX += (int)(Math.random()*cardNum.length());

                }

                driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("3" + AMEX);
                break;
        }
        DateFormat dateFormat = new SimpleDateFormat("MM/yy");
        Date currentDate = new Date();

        System.out.println(currentDate);

        String date = dateFormat.format(currentDate);


        String dateEntered = "" + (int)(1 + Math.random()*11) + "/" + (int)(22 + Math.random()*8);
        if (dateEntered.length() < 5) {

            dateEntered = "0" + dateEntered;
        }
        if (dateEntered.charAt(4) > date.charAt(4)) {

            driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys(dateEntered);

        }

        else {

            System.out.println(dateEntered);
            System.out.println(date);


        }

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
        assertTrue(driver.getPageSource().contains("New order has been successfully added"));

        driver.findElement(By.cssSelector("[href='Default.aspx'")).click();

        //driver.quit();

    }


    public static String randomFirstOrLastNameOrCityOrState() {

    String str = "abcdefghjklmnopqrstuvwxyz";
    String str2 = "ABCDEFGHJKLMNOPQRSTUVWXYZ";
    String remaining = "";
    String firstLetter = "";

    for (int i = 0; i < 1; i++) {

        int randomIndex = (int)(Math.random()*str2.length());

    firstLetter += str2.charAt(randomIndex);

    for (int j = 0; j < 6; j++)  {

        randomIndex = (int)(Math.random()*str.length());

     remaining += str.charAt(randomIndex);
    }

    }

    return firstLetter + remaining;
    }

    public static String randomState() {

        String state = "ABCDEFGHJKLMNOPQRSTUVWXYZ";
        String str = "";

        for (int i = 0; i < 2; i++) {

            int randomIndex = (int)(Math.random()*state.length());

            str += state.charAt(randomIndex);
        }

        return str;

    }
    public static String randomStreetAddress() {

    String number = "" + (int)(100 + Math.random());

    return number + " " + randomFirstOrLastNameOrCityOrState();
    }

    public static String randomZipCode() {

        String zipCode = "";

        for (int i = 0; i < 5; i++) {

            zipCode += (int) (Math.random()*10);

        }

        return zipCode;
    }

}


