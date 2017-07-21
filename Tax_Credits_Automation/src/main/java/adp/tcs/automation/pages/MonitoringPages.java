package adp.tcs.automation.pages;

import org.openqa.selenium.WebElement;

import adp.tcs.automation.locators.MassProcessing;
import adp.tcs.automation.locators.MonitoringLocators;
import adp.tcs.automation.stepsfiles.BaseTempletSteps;

public class MonitoringPages extends BaseTempletSteps{

	
	public WebElement data_Entry_Link(){
		WebElement element = getDriver().findElement(MonitoringLocators.DATA_ENTRY_LINK);
        return element;
    }
    
    public WebElement monitoring_Link(){
    	WebElement element = getDriver().findElement(MonitoringLocators.MONITORING_LINK);
        return element;
    }
    
    public WebElement unique_Id_Text_Field_Monitoring(){
    	WebElement element = getDriver().findElement(MonitoringLocators.UNIQUE_ID_TEXT_FIELD_ON_MONITORING);
        return element;
    }
    
    public WebElement search_Btn_Monitoring(){
    	WebElement element = getDriver().findElement(MonitoringLocators.SEARCH_BUTTON_ON_MONITORING);
        return element;
    }
    
    public WebElement search_Result_Error_Desc_Field(){
    	WebElement element = getDriver().findElement(MonitoringLocators.SEARCH_RESULT_ERROR_DISCRIPTION_FIELD);
        return element;
    }
}
