package adp.tcs.automation.pages;

import org.openqa.selenium.WebElement;

import adp.tcs.automation.locators.DocsUploadLocators;
import adp.tcs.automation.stepsfiles.BaseTempletSteps;

/**
 * Created by Thorasa on 04/13/2017.
 */
public class DocsUpoladPages extends BaseTempletSteps{

	
	public WebElement urgentFileNeededLink(){
        WebElement element = getDriver().findElement(DocsUploadLocators.URGENT_FILE_NEEDED_LINK);
        return element;
    }
	
	public WebElement todoFileNeededLink(){
        WebElement element = getDriver().findElement(DocsUploadLocators.TODO_FILE_NEEDED_LINK);
        return element;
    }
	
	public WebElement file_Upload_Save_Btn(){
        WebElement element = getDriver().findElement(DocsUploadLocators.FILE_UPLOAD_SAVE_BTN);
        return element;
    }
	
	public WebElement file_Upload_Done_Btn(){
        WebElement element = getDriver().findElement(DocsUploadLocators.FILE_UPLOAD_DONE_BTN);
        return element;
    }
}
