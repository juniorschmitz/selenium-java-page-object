package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage{

    public MyAccountPage(WebDriver browser) {
        super(browser);
    }

    public String getMyName() {
        return browser.findElement(By.className("account")).getText();
    }
}
