package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by aroyg on 13.01.2017.
 */
public class HomePage extends SuperPage{

    @FindBy(xpath="//h4[contains(text(),'Welcome to Datanyze!')]")
    WebElement welcomeDialog;

    @FindBy(xpath="//h4[contains(text(),'Welcome to Datanyze!')]/ancestor::div/button")
    WebElement closeWelcomeDialog;

    @FindBy(xpath="//span[@class='menu-labels'][contains(text(),'Alerts')]")
    WebElement alerts;

    @FindBy(xpath="//span[@class='menu-labels'][contains(text(),'Domains')]")
    WebElement domains;

    @FindBy(xpath="//span[@class='menu-labels'][contains(text(),'Domains')]")
    WebElement logOutButton;

    //There is no default constructor in SuperPage so we'll use this one with driver as @param to use same driver instance in all tests
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean checkHomePageIsOpened() {
        return welcomeDialog.isDisplayed();
    }

    public void closeWelcomeDialog() {
        closeWelcomeDialog.click();
    }

    public void goToAlerts() {
        closeWelcomeDialog.click();
    }

    public void goToDomains() {
        closeWelcomeDialog.click();
    }

    public void logOutOfThePlatform() {
        logOutButton.click();
    }

}
