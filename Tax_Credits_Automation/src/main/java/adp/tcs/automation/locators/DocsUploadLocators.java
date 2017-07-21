package adp.tcs.automation.locators;

import org.openqa.selenium.By;

import adp.tcs.automation.stepsfiles.BaseTempletSteps;

/**
 * Created by Thorasa on 04/13/2017.
 */
public class DocsUploadLocators extends BaseTempletSteps{

	public static final By URGENT_FILE_NEEDED_LINK = By.xpath("//div[@class='activity-tile activity-tile--urgent']");
	public static final By TODO_FILE_NEEDED_LINK = By.xpath("//div[@class='activity-tile activity-tile--urgent']");
	public static String FILE_UPLOAD_CONSTANT = "//div[@class='actionator__container ng-scope']//div[@actionator-card='process']";
	public static final By FILE_UPLOAD_SAVE_BTN = By.xpath("//button//span[text()='save']");
	public static final By FILE_UPLOAD_DONE_BTN = By.xpath("//button[contains(text(),'M DONE UPLOADING')]");
	
	
}
