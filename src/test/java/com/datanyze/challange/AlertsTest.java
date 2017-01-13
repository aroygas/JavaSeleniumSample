package com.datanyze.challange;

import net.sf.testng.databinding.TestInput;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import pageFactory.HomePage;

/**
 * Created by aroyg on 13.01.2017.
 */
public class AlertsTest extends SuperTest{

    @Test(enabled = true, priority = 0, groups = {"login", "smoke"})
    public void createAlert() {

        objHomePage.goToAlerts();

        LOG.info("User has successfully logged in!");
    }
}
