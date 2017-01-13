package com.datanyze.challenge;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageFactory.HomePage;
import pageFactory.LoginPage;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * Created by aroyg on 13.01.2017.
 */

/**
 * This is a base class for all tests.
 * It sets up the environment before the tests.
 * And it terminates environment in the end of the tests.
 */
public class SuperTest {
    //Name some common Pages needed to be used in each test
    LoginPage objLogin;
    HomePage objHomePage;
    //Declare logger
    protected Logger LOG;
    //Create empty thread driver
    protected WebDriver driver = null;
    //WebDriver driver;
    int intImplicitlyWait = 10;
    private String currentMethodName;

    @BeforeSuite
    @Parameters({"url", "userName", "password"})
    public void setUp(String url, String userName, String password){
        //Create logger
        System.out.println("\n\nStart test\n\n");
        LOG = Logger.getLogger("Start test");
        //Create chrome driver
        System.setProperty("webdriver.chrome.driver", "chrome/chromedriver.exe");
        driver = new ChromeDriver();
        //Logging in
        Login(url, userName, password);
    }

    @BeforeMethod
    public void getName(Method method) {
        this.currentMethodName=method.getName();
        LOG.info("A test : " + currentMethodName + " started!");
        System.out.println("A test : " + currentMethodName + " started!");
    }

    @AfterSuite
    public void logOutAndClose() throws InterruptedException {
        objHomePage.logOutOfThePlatform();
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
