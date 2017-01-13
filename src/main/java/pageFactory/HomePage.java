package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by aroyg on 13.01.2017.
 */
public class HomePage extends SuperPage{

    @FindBy(xpath="//h4[contains(text(),'Welcome to Datanyze!')]")
    WebElement welcomeDialog;

    @FindBy(xpath="//h4[contains(text(),'Welcome to Datanyze!')]/ancestor::div/button")
    WebElement closeWelcomeDialog;

    @FindBy(xpath="//a[@href='https://www.datanyze.com/alerts/']")
    WebElement alerts;

    @FindBy(xpath="//span[@class='menu-labels'][contains(text(),'Domains')]")
    WebElement domains;

    @FindBy(xpath="//span[@class='hidden-xs user-name-line']")
    WebElement profileButton;

    @FindBy(xpath="//a[contains(text(),'Logout')]")
    WebElement logOutButton;



    //There is no default constructor in SuperPage so we'll use this one with driver as @param to use same driver instance in all tests
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean checkHomePageIsOpened() {
        return welcomeDialog.isDisplayed();
    }

    public void closeWelcomeDialog() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(closeWelcomeDialog));
        closeWelcomeDialog.click();
    }

    public void goToAlerts() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(alerts));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        alerts.click();
    }

    public void goToDomains() {
        closeWelcomeDialog.click();
    }

    public void logOutOfThePlatform() {
        profileButton.click();
        logOutButton.click();
    }

}
