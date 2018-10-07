package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import support.Generator;

import java.util.concurrent.TimeUnit;

public class Web {
    public static WebDriver createChrome(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
        WebDriver mybrowser = new ChromeDriver();
        mybrowser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        mybrowser.manage().window().maximize();
        return mybrowser;
    }
}
