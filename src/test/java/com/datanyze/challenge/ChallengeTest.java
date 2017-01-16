package com.datanyze.challenge;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageFactory.AlertsPage;
import pageFactory.DomainPage;

/**
 * Created by aroyg on 13.01.2017.
 */
public class ChallengeTest extends SuperTest{

    AlertsPage objAlertsPage;
    DomainPage objDomainPage;

    @Test(enabled = true, priority = 0)
    public void addTrackedTechnologies() {
        objAlertsPage = new AlertsPage(driver);
        objHomePage.goToAlerts();
        objAlertsPage.goToAlertSettings();
        objAlertsPage.addTechnology("Yandex Metrica");
        objAlertsPage.addTechnology("Adobe Campaign");
        objAlertsPage.saveAlertSettings();
        Assert.assertTrue(objAlertsPage.settingsUpdated.isDisplayed());
        System.out.println("Technologies added!");
    }

    @Test(enabled = true, priority = 1)
    public void addFilters() {
        objAlertsPage.addFilter("Country");
        objAlertsPage.addCountry("Russia");
        objAlertsPage.addFilter("Tag");
        objAlertsPage.addTag("Fortune1000");
        objAlertsPage.saveAlertFilters();
        Assert.assertTrue(objAlertsPage.filtersUpdated.isDisplayed());
        System.out.println("Filters added!");
    }

    @Test(enabled = true, priority = 2)
    public void searchForDomain() {
        objDomainPage = new DomainPage(driver);
        objDomainPage.searchForDomain("amazon.com");
        objDomainPage.goToCompanyTab();
        objDomainPage.goToPeopleTab();
        objDomainPage.addAllEmployeesToNewList("Test Company Prospects");
        Assert.assertTrue(objDomainPage.peopleWereAddedToList.isDisplayed());
        System.out.println("All employees added to new list!");
    }
}
