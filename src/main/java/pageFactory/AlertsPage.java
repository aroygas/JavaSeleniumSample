package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by aroyg on 13.01.2017.
 */
public class AlertsPage extends SuperPage {

    @FindBy(xpath="//a[@href='/settings/?tab=alerts']")
    WebElement alertsSettings;

    @FindBy(xpath="//input[@class='select2-search__field']")
    WebElement technologyNameInput;

    @FindBy(xpath="//input[@value='Add for tracking']")
    WebElement saveAlertSettings;

    @FindBy(xpath="//span[contains(text(),'Select a Condition')]")
    WebElement addFilterButton;

    @FindBy(xpath="//input[@class='select2-search__field']")
    WebElement filterNameInput;

    @FindBy(xpath="//input[@value='Save filters']")
    WebElement saveAlertFilters;

    //There is no default constructor in SuperPage so we'll use this one with driver as @param to use same driver instance in all tests
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public void goToAlertSettings() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(alertsSettings));
        alertsSettings.click();
    }

    public void pressAddTechnology() {
        technologyNameInput.click();
    }

    public void addTechnologyName(String strTechnologyName) {
        technologyNameInput.sendKeys(strTechnologyName);
        driver.findElement(By.xpath("//li/span[contains(text(),'" + strTechnologyName +"')]")).click();
    }

    public void addTechnology(String strTechnologyName){
        pressAddTechnology();
        addTechnologyName(strTechnologyName);
        System.out.println("Technology " + strTechnologyName + " added!");
    }

    public void saveAlertSettings() {
        saveAlertSettings.click();
    }

    public void pressAddFilter() {
        addFilterButton.click();
    }

    public void setFilterName(String strFilterName) {
        filterNameInput.sendKeys(strFilterName);
    }

    public void addFilter(String strFilterName){
        pressAddFilter();
        setFilterName(strFilterName);
        driver.findElement(By.xpath("//li[contains(text(),'" + strFilterName +"')]")).click();
        System.out.println("Filter " + strFilterName + " added!");
    }

    public void saveAlertFilters() {
        saveAlertFilters.click();
    }
}
