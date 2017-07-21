package adp.tcs.automation.stepsfiles;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import adp.tcs.automation.locators.DocsUploadLocators;
import adp.tcs.automation.locators.SearchSSNHub;
import adp.tcs.automation.pages.DocsUpoladPages;

/**
 * Created by Thorasa on 04/13/2017.
 */
public class DocsUploadSteps extends BaseTempletSteps{
	
	DocsUpoladPages docs = new DocsUpoladPages();
	
	@When("Click on urgent file needed link")
	public void clickOnUrgentFileNeddedLink() {
		try {
			docs.urgentFileNeededLink().click();
		} catch (Exception e) {
			e.printStackTrace();
			verifyTest("Faliure in verifyHubSearchResultGrid page", false);
		}
	}
	
	@When("Click on todo file needed link")
	public void clickOnTodoFileNeddedLink() {
		try {
			docs.todoFileNeededLink().click();
		} catch (Exception e) {
			e.printStackTrace();
			verifyTest("Faliure in verifyHubSearchResultGrid page", false);
		}
	}
	
	@Then("Upload needed files")
	public void uploadDocs(){
        try {      
        	sleep(4000);
        	int count = getCount(DocsUploadLocators.FILE_UPLOAD_CONSTANT);
        	for(int row = 1; row<=count; row++){
        		sleep(2000);
        		String fileNeededSsn = DocsUploadLocators.FILE_UPLOAD_CONSTANT + "[" + row + "]//dt[text()='SSN']/following::dd[1]";        		
				if(getExcelData().get("SSN").contains(getText(fileNeededSsn).replace("XXX-XX-", ""))) {
					System.out.println("Inside");
					String selectFilePath = DocsUploadLocators.FILE_UPLOAD_CONSTANT + "[" + row + "]//a[@class='card-btn-container__upload-btn-link']";
					sleep(4000);
					userClick(selectFilePath);
					sleep(4000);
					uploadFile(fileUploadScripts+"DocumentUpload_Automation.jpg");
					sleep(4000);
					String saveBtn = DocsUploadLocators.FILE_UPLOAD_CONSTANT + "[" + row + "]//button/span[text()='save']";
					userClick(saveBtn);
					sleep(4000);					
					docs.file_Upload_Done_Btn().click();
					sleep(4000);					
					break;
				}
        	} 
		} catch (Exception e) {
			e.printStackTrace();
			verifyTest("Faliure in uploadDocs page",false);
		}
    }
	
	public static void uploadFile(String fileLocation) {
        try {
        	StringSelection ss = new StringSelection(fileLocation);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null); //copy the above string to clip board     
            Robot robot;
            robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(2000); 
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL); //paste the copied string into the dialog box
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER); //enter        	
        } catch (Exception exp) {
        	exp.printStackTrace();
        }
    }


}
