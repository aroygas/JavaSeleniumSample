package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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

    @FindBy(xpath="//input[@placeholder='Start typing country name']")
    WebElement countryName;

    @FindBy(xpath="//input[@placeholder='Start typing tag name']")
    WebElement tagName;

    @FindBy(xpath="//input[@value='Save filters']")
    WebElement saveAlertFilters;

    @FindBy(xpath="//span[contains(text(),'Your settings have been updated.')]")
    public WebElement settingsUpdated;

    @FindBy(xpath="//span[contains(text(),'The filters have been saved successfully.')]")
    public WebElement filtersUpdated;

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

    public void setCountryName(String strCountryName) {
        countryName.sendKeys(strCountryName);
    }

    public void setTagName(String strTagName) {
        tagName.sendKeys(strTagName);
    }

    public void addFilter(String strFilterName){
        pressAddFilter();
        setFilterName(strFilterName);
        driver.findElement(By.xpath("//li[contains(text(),'" + strFilterName +"')]")).click();
        System.out.println("Filter " + strFilterName + " added!");
    }

    public void addCountry(String strCountryName){
        countryName.click();
        setCountryName(strCountryName);
        driver.findElement(By.xpath("//li[contains(text(),'" + strCountryName +"')]")).click();
        System.out.println("Country " + strCountryName + " added to country filter!");
    }

    public void addTag(String strTagName){
        tagName.click();
        setTagName(strTagName);
        driver.findElement(By.xpath("//li[contains(text(),'" + strTagName +"')]")).click();
        System.out.println("Tag " + strTagName + " added to tag filter!");
    }

    public void saveAlertFilters() {
        saveAlertFilters.click();
    }
}
