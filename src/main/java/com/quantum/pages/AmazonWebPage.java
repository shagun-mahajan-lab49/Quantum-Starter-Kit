package com.quantum.pages;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.utils.ReportUtils;

public class AmazonWebPage extends WebDriverBaseTestPage<WebDriverTestPage> {
    @Override
    protected void openPage(PageLocator pageLocator, Object... objects) {

    }

    public void verifyProductExists(String productName) {
        ReportUtils.logAssert("Verify Product exists", new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("amazon.result.text"), productName)).isDisplayed());
    }

    public void clickOnProduct(String productName) {
        QAFExtendedWebElement productLabel = new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("amazon.result.text"), productName));
        productLabel.click();
    }

    public void verifyProductInCart(String productName) {
        ReportUtils.logAssert("Verify Product in Cart", new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("amazon.web.cart.product"), productName)).isDisplayed());
    }

    public void verifyProductHeader(String productName) {
        ReportUtils.logAssert("Verify Product Header on detail screen", new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("amazon.web.productHeader"), productName)).isDisplayed());
    }
}
