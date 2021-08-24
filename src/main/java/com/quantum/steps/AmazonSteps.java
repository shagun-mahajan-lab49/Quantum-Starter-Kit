package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.quantum.pages.AmazonWebPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@QAFTestStepProvider
public class AmazonSteps {

    @Then("I should see \"(.*?)\" product in search result")
    public void iShouldSeeProduct(String productName) {
        new AmazonWebPage().verifyProductExists(productName);
    }

    @When("I click on \"(.*?)\" product in search result")
    public void iClickOnProduct(String productName) {
        new AmazonWebPage().clickOnProduct(productName);
    }

    @When("I should see \"(.*?)\" header on detail screen")
    public void iShouldSeeProductNameOnDetailScreen(String productName) {
        new AmazonWebPage().verifyProductHeader(productName);
    }

    @Then("I should see \"(.*?)\" product in cart")
    public void iShouldSeeProductInCart(String productName) {
        new AmazonWebPage().verifyProductInCart(productName);
    }

}
