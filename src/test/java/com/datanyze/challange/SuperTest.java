package com.datanyze.challange;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import pageFactory.HomePage;
import pageFactory.LoginPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by aroyg on 13.01.2017.
 */
public class SuperTest {
    //Name some common Pages needed to be used in each test
    LoginPage objLogin;
    HomePage objHomePage;
    //Declare logger
    protected Logger LOG;
    //Create empty thread driver
    protected WebDriver driver = null;
    //Declare soft assertions
    protected SoftAssert softAssert;
    //WebDriver driver;
    int intImplicitlyWait = 10;

    @BeforeMethod
    @Parameters({"loginPage", "userName", "password"})
    public void setUp(String loginPage, String userName, String password){
        //Create logger
        System.out.println("\n\nStart test\n\n");
        LOG = Logger.getLogger("Start test");
        //Create chrome driver
        System.setProperty("webdriver.chrome.driver", "chrome/chromedriver.exe");
        driver = new ChromeDriver();
        //Logging in
        Login(loginPage, userName, password);
    }

    @AfterMethod
    public void postCondition() throws InterruptedException {
        //Close the browser
        driver.quit();
    }

    /**
     * This method sets up driver and logs to
     * @param strLoginPage
     * using credentials:
     * @param strUserName
     * @param strPassword
     */
    public void Login(String strLoginPage, String strUserName, String strPassword){
        driver.manage().timeouts().implicitlyWait(intImplicitlyWait, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(strLoginPage);

        //Create Login Page object
        objLogin = new LoginPage(driver);

        System.out.println("Login to: " + strLoginPage);
        System.out.println("User name: " + strUserName);
        System.out.println("Password: " + strPassword);

        //Logging to system
        objLogin.loginToSystem(strUserName, strPassword);

        //Create home page
        objHomePage = new HomePage(driver);

        //Verify home page
        Assert.assertTrue(objHomePage.checkHomePageIsOpened());
        System.out.println("User " + strUserName + " has successfully logged in!");

        objHomePage.closeWelcomeDialog();
    }
}
