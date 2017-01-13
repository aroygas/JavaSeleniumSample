package com.datanyze.challange;

import org.testng.annotations.Test;
import pageFactory.AlertsPage;
import pageFactory.DomainPage;

/**
 * Created by aroyg on 13.01.2017.
 */
public class ChallengeTest extends SuperTest{

    AlertsPage objAlertsPage = new AlertsPage(driver);
    DomainPage objDomainPage = new DomainPage(driver);

    @Test(enabled = true, priority = 0)
    public void addTrackedTechnologies() {
        objHomePage.goToAlerts();
        objAlertsPage.goToAlertSettings();
        objAlertsPage.addTechnology("FirstTechnology");
        objAlertsPage.addTechnology("SecondTechnology");
        objAlertsPage.saveAlertSettings();
        System.out.println("Technologies added!");
    }

    @Test(enabled = true, priority = 1)
    public void addFilters() {
        objAlertsPage.goToFilters();
        objAlertsPage.addFilter("FirstFilter");
        objAlertsPage.addFilter("SecondFilter");
        objAlertsPage.saveAlertFilters();
        System.out.println("Filters added!");
    }

    @Test(enabled = true, priority = 2)
    public void searchForDomain() {
        objDomainPage.searchForDomain();
        objDomainPage.goToCompanyTab();
        objDomainPage.goToPeopleTab();
        objDomainPage.addAllEmployeesToList("Test Company Prospects");
        System.out.println("Filters added!");
    }
}
