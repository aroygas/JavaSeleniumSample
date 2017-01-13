package pageFactory;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

/**
 * Created by aroyg on 13.01.2017.
 */

/***
 * This is the base Page class where shared services are available.
 * All other pages in Page Factory should extend this SuperPage!
 ***/
public class SuperPage {
    //protected WebDriver
    public WebDriver driver;
    //A time for driver to wait an element during lazy loading using AjaxElementLocatorFactory
    private static int DRIVER_WAIT = 10;
    //Logging for debugging and other needs
    private static Logger LOG = Logger.getLogger(SuperPage.class);

    /***
     * Constructor
     * @param driver an instance of WebDriver
     */
    public SuperPage(WebDriver driver) {
        //Enabling lazy loading
        ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
        LOG.info("Initializing elements!");
        //This initElements method will create all WebElements
        PageFactory.initElements(finder, this);
        //Will try not to create new drivers without need
        this.driver = driver;
    }
}
