package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by aroyg on 13.01.2017.
 */
public class AlertsPage extends SuperPage {

    @FindBy(xpath="//h4[contains(text(),'Welcome to Datanyze!')]")
    WebElement alertsSettings;

    @FindBy(xpath="//h4[contains(text(),'Welcome to Datanyze!')]")
    WebElement addTechnologyButton;

    @FindBy(xpath="//h4[contains(text(),'Welcome to Datanyze!')]")
    WebElement technologyNameInput;

    @FindBy(xpath="//h4[contains(text(),'Welcome to Datanyze!')]")
    WebElement saveAlertSettings;

    @FindBy(xpath="//h4[contains(text(),'Welcome to Datanyze!')]")
    WebElement alertsFilters;

    @FindBy(xpath="//h4[contains(text(),'Welcome to Datanyze!')]")
    WebElement addFilterButton;

    @FindBy(xpath="//h4[contains(text(),'Welcome to Datanyze!')]")
    WebElement filterNameInput;

    @FindBy(xpath="//h4[contains(text(),'Welcome to Datanyze!')]")
    WebElement saveAlertFilters;

    //There is no default constructor in SuperPage so we'll use this one with driver as @param to use same driver instance in all tests
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public void goToAlertSettings() {
        alertsSettings.click();
    }

    public void pressAddTechnology() {
        addTechnologyButton.click();
    }

    public void setTechnologyName(String strTechnologyName) {
        technologyNameInput.clear();
        technologyNameInput.sendKeys(strTechnologyName);
    }

    public void addTechnology(String strTechnologyName){
        pressAddTechnology();
        setTechnologyName(strTechnologyName);
        System.out.println("Technology " + strTechnologyName + " added!");
    }

    public void saveAlertSettings() {
        saveAlertSettings.click();
    }

    public void goToFilters() {
        alertsFilters.click();
    }

    public void pressAddFilter() {
        addFilterButton.click();
    }

    public void setFilterName(String strFilterName) {
        filterNameInput.clear();
        filterNameInput.sendKeys(strFilterName);
    }

    public void addFilter(String strFilterName){
        pressAddFilter();
        setFilterName(strFilterName);
        System.out.println("Filter " + strFilterName + " added!");
    }

    public void saveAlertFilters() {
        saveAlertFilters.click();
    }
}
