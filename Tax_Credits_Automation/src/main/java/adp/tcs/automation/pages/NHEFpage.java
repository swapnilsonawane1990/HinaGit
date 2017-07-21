package adp.tcs.automation.pages;

import adp.tcs.automation.locators.nhefHireLocators;
import adp.tcs.automation.stepsfiles.BaseTempletSteps;
import org.openqa.selenium.WebElement;

/**
 * Created by BhuteSac on 10/16/2016.
 */
public class NHEFpage extends BaseTempletSteps {

    public WebElement nhef_NHEF_SUB_LINK(){
        WebElement element = getDriver().findElement(nhefHireLocators.NHEF_SUB_LINK);
        return element;
    }

    public WebElement nhef_UPLOAD_BUTTON_LINK(){
        WebElement element = getDriver().findElement(nhefHireLocators.UPLOAD_BUTTON_LINK);
        return element;
    }
    public WebElement nhef_UPLOAD_MSG_ERROR(){
        WebElement element = getDriver().findElement(nhefHireLocators.UPLOAD_MSG_ERROR);
        return element;
    }

    public WebElement nhef_UPLOAD_SUCCESS_MSG(){
        WebElement element = getDriver().findElement(nhefHireLocators.UPLOAD_SUCCESS_MSG);
        return element;
    }
    public WebElement nhef_HEADER_NAME(){
        WebElement element = getDriver().findElement(nhefHireLocators.HEADER_NAME);
        return element;
    }



}
