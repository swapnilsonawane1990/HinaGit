package adp.tcs.automation.stepsfiles;

import adp.tcs.automation.locators.nhefHireLocators;
import adp.tcs.automation.pages.MassProcessingPage;
import adp.tcs.automation.pages.NHEFpage;
import adp.tcs.automation.utilities.NHEFfilesCreation;
import adp.tcs.automation.utilities.TakeScreenshotAction;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;

/**
 * Created by BhuteSac on 10/16/2016.
 */
public class NHFL_Hire extends BaseTempletSteps {

    public String workingDir = System.getProperty("user.dir");
    public TakeScreenshotAction screenshot = new TakeScreenshotAction();
    public NHEFfilesCreation nhefFiles = new NHEFfilesCreation();
    private MassProcessingPage massProcessObj = new MassProcessingPage();
    private NHEFpage nhEFpageobj = new NHEFpage();

    @Given("User Hire the records with NHEF and current date")
    public void nhefHireCurrentDate(@Named("FileName") String fileName) throws Exception {
        try {
            nhefFiles.nhefHireWithCurrentDate(fileName);
            sleep(4000);
            userClick(massProcessObj.operations_Tab());
            sleep(2000);
            userClick(nhEFpageobj.nhef_NHEF_SUB_LINK());
            sleep(2000);
            if(!isDisplayed(nhEFpageobj.nhef_NHEF_SUB_LINK())) {
                for (int i = 1; i >= 10; i++) {
                    userClick(massProcessObj.operations_Tab());
                    sleep(2000);
                    userClick(nhEFpageobj.nhef_NHEF_SUB_LINK());
                    sleep(2000);
                    if (isDisplayed(nhEFpageobj.nhef_NHEF_SUB_LINK())) {
                        break;
                    }
                }
            }

            nhEFpageobj.nhef_HEADER_NAME().click();
            sleep(2000);
            nhEFpageobj.nhef_UPLOAD_BUTTON_LINK().sendKeys(workingDir+"\\src\\test\\resources\\NHFLfiles\\nhef_test.txt");
            sleep(2000);
            explicitWaitForElement(nhefHireLocators.UPLOAD_SUCCESS_MSG,50);
           // nhEFpageobj.nhef_UPLOAD_BUTTON_LINK().click();
          //  Runtime.getRuntime().exec( +"\\src\\test\\resources\\NHFLfiles\\ReportUpload.exe");

            sleep(10000);
            waitForLoad();
            if(nhEFpageobj.nhef_UPLOAD_SUCCESS_MSG().isDisplayed())
            {
                verifyTest("Nhef Hire with current date done successfully", true);
            }

        } catch (Exception e) {
            screenshot.getScreenshot("nhefHireCurrentDate");
            verifyTest("Nhef Hire with current date is faield", false);
            e.printStackTrace();
        }
    }

    @Given("User Hire the records with NHEF and Specified date")
    public void nhefHireSpecifiedDate(@Named("FileName") String fileName) throws Exception {
        try {
            nhefFiles.nhefHireSpecifiedDate(fileName);
            //Go to the NHEF Page
            massProcessObj.operations_Tab().click();
            sleep(2000);
            nhEFpageobj.nhef_NHEF_SUB_LINK().click();
            sleep(2000);
            nhEFpageobj.nhef_HEADER_NAME().click();
            sleep(2000);
            nhEFpageobj.nhef_UPLOAD_BUTTON_LINK().sendKeys(workingDir+"\\src\\test\\resources\\NHFLfiles\\nhef_test.txt");
            sleep(5000);
            waitForLoad();
            sleep(5000);
            if(nhEFpageobj.nhef_UPLOAD_SUCCESS_MSG().isDisplayed())
            {
                verifyTest("Nhef Hire with Specified date done successfully", true);
            }

        } catch (Exception e) {
            screenshot.getScreenshot("nhefHireSpecifiedDate");
            verifyTest("Nhef Hire with user specified date is faield", false);
            e.printStackTrace();
        }
    }
}
