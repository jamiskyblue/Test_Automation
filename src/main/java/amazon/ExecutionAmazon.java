package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExecutionAmazon {
    public static WebDriver driver;
    //for using on every test

    public static void sleepFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeTest(alwaysRun = true)// now on we don't have to use setup method on every test case
    public void setup() {//by creating void setup method we don't have to use main method
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();//for maximizing the page
        driver.get("https://www.amazon.com");//this code we use for open a browser
        sleepFor(3);
    }

    @AfterTest(alwaysRun = true)//now on we don't have to use close method on every test
    public void close() {
        sleepFor(3);
        driver.quit();
        //driver.close();
    }

    @Test
    public void clickOnAccount() {
        driver.findElement(By.id("nav-link-accountList")).click();
    }
        @Test
        public void searchForBooks(){
            //setup();//AFTER importing @before test annotation
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java Books");
            //driver.findElement(By.xpath("//input[@type='submit'and value='go']")).click();
            //close();//after importing @after test annotation
        }
    }


