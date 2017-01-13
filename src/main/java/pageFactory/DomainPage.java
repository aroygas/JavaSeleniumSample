package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by aroyg on 13.01.2017.
 */
public class DomainPage extends SuperPage {

    @FindBy(xpath="//h4[contains(text(),'Welcome to Datanyze!')]")
    WebElement searchForDomain;

    @FindBy(xpath="//h4[contains(text(),'Welcome to Datanyze!')]")
    WebElement companyTab;

    @FindBy(xpath="//h4[contains(text(),'Welcome to Datanyze!')]")
    WebElement peopleTab;

    //There is no default constructor in SuperPage so we'll use this one with driver as @param to use same driver instance in all tests
    public DomainPage(WebDriver driver) {
        super(driver);
    }

    public void searchForDomain() {
        searchForDomain.click();
    }

    public void goToCompanyTab() {
        companyTab.click();
    }

    public void goToPeopleTab() {
        peopleTab.click();
    }

    public void addAllEmployeesToList(String strListName) {
        peopleTab.click();
    }
}
