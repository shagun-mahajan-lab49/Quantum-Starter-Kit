/**
 * 
 */
package com.quantum.steps;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.util.StringUtil;
import com.quantum.utils.AppiumUtils;
import com.quantum.utils.ConfigurationUtils;
import com.quantum.utils.ConsoleUtils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;


@QAFTestStepProvider
public class CommonStepsDefs {

	@Then("I switch to frame \"(.*?)\"")
	public static void switchToFrame(String nameOrIndex) {
		if (StringUtil.isNumeric(nameOrIndex)) {
			int index = Integer.parseInt(nameOrIndex);
			new WebDriverTestBase().getDriver().switchTo().frame(index);
		} else {
			new WebDriverTestBase().getDriver().switchTo().frame(nameOrIndex);
		}
	}

	@Then("I switch to \"(.*?)\" frame by element")
	public static void switchToFrameByElement(String loc) {
		new WebDriverTestBase().getDriver().switchTo().frame(new QAFExtendedWebElement(loc));
	}

	@When("I am using an AppiumDriver")
	public void testForAppiumDriver() {
		if (ConfigurationUtils.getBaseBundle().getPropertyValue("driver.name").contains("Remote"))
			ConsoleUtils.logWarningBlocks("Driver is an instance of QAFExtendedWebDriver");
		else if (AppiumUtils.getAppiumDriver() instanceof IOSDriver)
			ConsoleUtils.logWarningBlocks("Driver is an instance of IOSDriver");
		else if (AppiumUtils.getAppiumDriver() instanceof AndroidDriver)
			ConsoleUtils.logWarningBlocks("Driver is an instance of AndroidDriver");
	}

	@When("I open webpage \"(.*?)\" on browser")
	public static void openBrowser(String url){
		String getDevice = ConfigurationUtils.getDesiredDeviceCapabilities().getCapability("model").toString();
		if(getDevice.toLowerCase().contains("iphone")) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("name", "Safari");
			new WebDriverTestBase().getDriver().executeScript("mobile:application:open", params);
			new WebDriverTestBase().getDriver().findElementByXPath("//XCUIElementTypeButton[@label=\"Address\"]").click();
			new WebDriverTestBase().getDriver().findElementByXPath("//*[@label='Address']").sendKeys(url + "\n");
		} else {
			CommonStep.get(url);
		}
	}

	@When("I scroll down to \"(.*?)\"")
	public static void scrollToElement(String locator){
		boolean flag=true;
		int count=1;
		while(flag){
			try {
				new QAFExtendedWebElement(By.xpath(locator));
				flag=false;
				break;
			}
			catch(Exception NoSuchElementException) {
				count=count+1;
				Map<String, Object> params = new HashMap<>();
				params.put("start","40%,90%");
				params.put("end","40%,20%");
				params.put("duration","2");
				Object res= new WebDriverTestBase().getDriver().executeScript("mobile:touch:swipe",params);
				if(count==5)
				{
					break;
				}
			}
		}
	}

	@Given("^I open \"(.*?)\" website$")
	public void iOpenWebsite(String url) throws Throwable {
		new WebDriverTestBase().getDriver().get(url);
	}
}