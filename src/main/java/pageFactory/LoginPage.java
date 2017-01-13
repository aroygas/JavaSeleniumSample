package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by aroyg on 13.01.2017.
 */
public class LoginPage extends SuperPage{

    @FindBy(name="email")
    WebElement userName;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath="//input[@type='Submit']")
    WebElement login;

    //There is no default constructor in SuperPage so we'll use this one with driver as @param to use same driver instance in all tests
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private void setUserName(String strUserName) {
        userName.clear();
        userName.sendKeys(strUserName);
    }

    private void setPassword(String strPassword) {
        password.clear();
        password.sendKeys(strPassword);
    }

    private void clickLogin() {
        login.click();
    }

    /**
     * This POM method will be exposed in test case to login in the application
     * @param strUserName
     * @param strPassword
     */
    public void loginToSystem(String strUserName,String strPassword){
        setUserName(strUserName);
        setPassword(strPassword);
        clickLogin();
    }
}
