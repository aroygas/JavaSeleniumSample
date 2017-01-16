package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by aroyg on 13.01.2017.
 */
public class DomainPage extends SuperPage {

    @FindBy(xpath="//input[@title='search domain']")
    WebElement searchForDomain;

    @FindBy(xpath="//li/a[contains(text(),'Company')]")
    WebElement companyTab;

    @FindBy(xpath="//li/a[contains(text(),'People')]")
    WebElement peopleTab;

    @FindBy(xpath="//input[@id='check_all_none']")
    WebElement selectAll;

    @FindBy(xpath="//span[@title='Add to list']")
    WebElement addToList;

    @FindBy(xpath="//li[contains(text(),'Create another list')]")
    WebElement createAnotherList;

    @FindBy(xpath="//form[@onsubmit='return create_new_list();']/div/input[@id='list_name']")
    WebElement newListNameInput;

    @FindBy(xpath="//input[@value='Create list']")
    WebElement createList;

    @FindBy(xpath="//span[contains(text(),'people were added to list')]")
    public WebElement peopleWereAddedToList;

    //There is no default constructor in SuperPage so we'll use this one with driver as @param to use same driver instance in all tests
    public DomainPage(WebDriver driver) {
        super(driver);
    }

    public void searchForDomain(String strDomain) {
        searchForDomain.click();
        searchForDomain.sendKeys(strDomain);
        searchForDomain.submit();
    }

    public void goToCompanyTab() {
        companyTab.click();
    }

    public void goToPeopleTab() {
        peopleTab.click();
    }

    public void addAllEmployeesToNewList(String strListName) {
        selectAll();
        addToList.click();
        createAnotherList.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(newListNameInput));
        newListNameInput.click();
        newListNameInput.sendKeys(strListName);
        createList.click();
    }

    public void selectAll() {
        selectAll.click();
    }
}
