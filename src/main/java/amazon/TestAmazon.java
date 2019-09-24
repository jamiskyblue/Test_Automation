package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestAmazon {
    public static WebDriver driver;

    public static void sleepFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //public static void main(String[] args) {


        public void setup () {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            driver = new ChromeDriver();
            driver.get("https://www.amazon.com");
            sleepFor(3);
            //driver.findElement(By.id("nav=link_accountList")).click();

        }
        public void close () {
            sleepFor(3);
            driver.close();
            driver.quit();
        }

        @Test
        public void clickOnOrders () {
            setup();
            driver.findElement(By.id("nav-orders")).click();
            close();
        }
        @Test
        public void searchForBooks () {
            setup();
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java Books");
            driver.findElement(By.xpath("//input[@type='submit'and @value='go']")).click();
            close();
        }
    }
//}
