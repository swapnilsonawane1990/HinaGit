package adp.tcs.automation.stepsfiles;

import adp.tcs.automation.pages.IndividualPsnDolComPages;
import adp.tcs.automation.pages.MassProcessingPage;
import adp.tcs.automation.utilities.TakeScreenshotAction;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;

/**
 * Created by bhutesac on 9/28/2016.
 */
public class indivitualPsnDolCom_Steps extends BaseTempletSteps {

    TakeScreenshotAction screenshot = new TakeScreenshotAction();
    MassProcessingPage massProcess = new MassProcessingPage();
    IndividualPsnDolComPages indiPsnDolComPages = new IndividualPsnDolComPages();

    @When("User Update the PSN Details For Records")
    public void indivitualPSNUpdate(@Named("numberOfRecords") String numberOfRecords) throws Exception {
        try{
            Thread.sleep(2000);
            verifyTest("User Update the PSN Details For Records");
            indiPsnDolComPages.indivitualPSN(numberOfRecords);
            Thread.sleep(2000);
        }catch(Exception e)
        {
            screenshot.getScreenshot("indivitualPSNUpdate");
            verifyTest("User Update the PSN Details For Records", false);
            e.printStackTrace();
        }

    }

    @When("User Update the DOL Details For Records")
    public void indivitualDOLUpdate(@Named("numberOfRecords") String numberOfRecords) throws Exception {
        try{
            Thread.sleep(2000);
            verifyTest("User Update the DOL Details For Records");
            indiPsnDolComPages.indivitualDol(numberOfRecords);
            Thread.sleep(2000);
        }catch(Exception e)
        {
            screenshot.getScreenshot("indivitualDOLUpdate");
            verifyTest("User Update the DOL Details For Records", false);
            e.printStackTrace();
        }

    }

    @When("User Update the COM Details For Records")
    public void indivitualCOMUpdate(@Named("numberOfRecords") String numberOfRecords) throws Exception {
        try{
            Thread.sleep(2000);
            verifyTest("User Update the COM Details For Records");
            indiPsnDolComPages.indivitualCom(numberOfRecords);
            Thread.sleep(2000);
        }catch(Exception e)
        {
            screenshot.getScreenshot("indivitualDOLUpdate");
            verifyTest("User Update the COM Details For Records", false);
            e.printStackTrace();
        }
    }

}
