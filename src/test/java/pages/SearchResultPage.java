package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends BasePage {
    public SearchResultPage(WebDriver browser) {
        super(browser);
    }

    public WebElement firstProductResult() {
        WebElement product = browser.findElement(By.className("product-container"));
        return product;
    }
}
