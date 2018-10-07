package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver browser) {
        super(browser);
    }

    public LoginPage clickSignIn(){
        browser.findElement(By.cssSelector("a.login")).click();
        return new LoginPage(browser);
    }

    public SearchResultPage search(String query){
        browser.findElement(By.id("search_query_top")).sendKeys(query);
        browser.findElement(By.className("button-search")).click();
        return new SearchResultPage(browser);
    }
}
