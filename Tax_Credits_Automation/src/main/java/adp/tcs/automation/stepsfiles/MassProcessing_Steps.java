package adp.tcs.automation.stepsfiles;


import adp.tcs.automation.pages.MassProcessingPage;
import adp.tcs.automation.utilities.TakeScreenshotAction;
import org.jbehave.core.annotations.Given;

/**
 * Created by BhuteSac on 7/25/2016.
 */
public class MassProcessing_Steps extends BaseTempletSteps {
	private TakeScreenshotAction screenshot = new TakeScreenshotAction();
    private MassProcessingPage massProcess = new MassProcessingPage();

    @Given("Search for Record and Do the eSign mass Print Queue")
    public void searchSSNforEdit() throws Exception {
        try{
            Thread.sleep(2000);
            verifyTest("Search for Record and Do the eSign mass Print Queue");
            massProcess.EsignMassPrint("1");
        }catch(Exception e) {
            screenshot.getScreenshot("searchSSNforEdit");
            verifyTest("Search for Record and Do the eSign mass Print Queue", false);
            e.printStackTrace();
        }

    }

    @Given("Esign Mass Print Queue with User Specified Dates")
    public void esignWithSpecifiedDates() throws Exception {
        try{
            sleep(2000);
            verifyTest("Search for Records with date SSN and State");
            massProcess.EsignMassWithSpecifiedDate("1");

        }catch(Exception e) {
            screenshot.getScreenshot("esignWithSpecifiedDates");
            verifyTest("esign With Specified Dates", false);
            e.printStackTrace();
        }

    }

}
