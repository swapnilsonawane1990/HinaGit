package adp.tcs.automation.stepsfiles;

import adp.tcs.automation.utilities.TakeScreenshotAction;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;

/**
 * Created by BhuteSac on 10/6/2016.
 */
public class StandAloneScreening_Steps extends BaseTempletSteps {

    private ScreeningSteps scrsteps = new ScreeningSteps();
    private TakeScreenshotAction screenshot = new TakeScreenshotAction();

    /**
     * This method is used to Perform Stand Alone AND Walmart Screening.
     */
    @Given("User Perform Stand Alone Screening")
    @Alias("User Perform Web In Walmart Screening")
    public void StandAloneScreening() throws Exception{
        try{
        scrsteps.verifyPageActons();
        } catch (Exception e) {
            e.printStackTrace();
            screenshot.getScreenshot("StandAloneScreening");
            verifyTest("User is on mail in page -- gotoMailInScreeningPage()", false);
        }
    }
}
