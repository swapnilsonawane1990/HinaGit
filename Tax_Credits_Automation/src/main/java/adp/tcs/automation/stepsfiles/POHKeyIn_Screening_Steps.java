package adp.tcs.automation.stepsfiles;

import adp.tcs.automation.locators.POHKeyIn_Screening_Locators;
import adp.tcs.automation.pages.MonitoringPages;
import adp.tcs.automation.pages.POHKeyIn_Screening;
import adp.tcs.automation.pages.SearchSSNthroughHub;
import adp.tcs.automation.utilities.TakeScreenshotAction;
import adp.tcs.automation.utilities.WndowAction;
import adp.tcs.automation.utilities.randomSSNgenrater;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * Created by garghina on 10/10/2016.
 */
public class POHKeyIn_Screening_Steps extends BaseTempletSteps {
    private MonitoringPages dataentrylink = new MonitoringPages();
    private POHKeyIn_Screening_Locators pohKeyIn_screening_locators = new POHKeyIn_Screening_Locators();
    private HubValidationsSteps unitname = new HubValidationsSteps();
    private POHKeyIn_Screening pOHKeyIn_Screening = new POHKeyIn_Screening();
    private WndowAction wndowAction = new WndowAction();
    private randomSSNgenrater ssnGenerator = new randomSSNgenrater();
    private SearchSSNthroughHub searchSSNthroughHub = new SearchSSNthroughHub();
    private TakeScreenshotAction screenshot = new TakeScreenshotAction();
    String expmesg, actmesg;

    @When("User Perform POHKeyIn screening for eligible record")
    public void POHKeyInscreening(@Named("CompanyName") String CompanyName)throws Exception{
        try{
        String ssn = String.valueOf(ssnGenerator.generateSSN());
        dataentrylink.data_Entry_Link().click();
        pOHKeyIn_Screening.CAandPOHKeyFromPaper_Link().click();
        pOHKeyIn_Screening.TaxCredits_image().click();
        explicitWaitForElement(POHKeyIn_Screening_Locators.POHKeyIn_RadioButton, 40);
        pOHKeyIn_Screening.POHKeyIn_RadioButton().click();
        sleep(1000);
        pOHKeyIn_Screening.CompanyName_Field().sendKeys(CompanyName);
        sleep(4000);
        pOHKeyIn_Screening.Company_Name_Dropdown().click();
        sleep(2000);
        unitname.unitNameSelection("Arizona TANF Credit");
        sleep(2000);
        explicitWaitForElement(POHKeyIn_Screening_Locators.StartScreening_Button, 65);
        pOHKeyIn_Screening.StartScreening_Button().click();
        wndowAction.switchtoChildWindow();
        sleep(10000);
        explicitWaitForElement(POHKeyIn_Screening_Locators.SSN_Field, 40);
        pOHKeyIn_Screening.SSN_Field().sendKeys(String.valueOf(ssnGenerator.generateSSN()));
        sleep(4000);
        pOHKeyIn_Screening.Hire_Date().click();
        sleep(2000);
        pOHKeyIn_Screening.Hire_Date().sendKeys(currentdate());
        selectDropdown(pOHKeyIn_Screening.Credit_Name_Select(), "AZ_TANF");
        explicitWaitForElement(pohKeyIn_screening_locators.Continue_Button, 20);
        pOHKeyIn_Screening.Continue_Button().click();
        explicitWaitForElement(pohKeyIn_screening_locators.POH_State_Form_Only, 20);
        pOHKeyIn_Screening.FirstName_Field().sendKeys(getExcelData().get("FNAME"));
        pOHKeyIn_Screening.Lastname_Field().sendKeys(getExcelData().get("LNAME"));
        pOHKeyIn_Screening.Address_Field().sendKeys(getExcelData().get("HOME_STREET_ADDRESS"));
        pOHKeyIn_Screening.Zipcode_Field().sendKeys(getExcelData().get("ZIP"));
        pOHKeyIn_Screening.POH_State_Form_Only().click();
        sleep(4000);
        pOHKeyIn_Screening.Continue_Button().click();
        sleep(2000);
        explicitWaitForElement(pohKeyIn_screening_locators.POH_AZ_TANF_TEXT, 50);
        pOHKeyIn_Screening.AZ_First_Question().click();
        pOHKeyIn_Screening.AZ_Second_question().click();
        pOHKeyIn_Screening.AZ_Third_question().click();
        pOHKeyIn_Screening.Extra_Info_SSN().sendKeys(ssn);
        pOHKeyIn_Screening.Extra_Info_Date().sendKeys(currentdate());
        } catch (Exception e) {
            e.printStackTrace();
            screenshot.getScreenshot("POHKeyInscreening");
            verifyTest("User is on mail in page -- gotoMailInScreeningPage()", false);
        }
        sleep(2000);
        pOHKeyIn_Screening.Continue_Button().click();
    }

    @Then("Screening should be completed successfully")
    public void VerifyMessage() {
        verifyTest("Screening should be completed successfully");
        expmesg = "Screening completed - thank you! You can safely close this window/tab now.";
        actmesg = pOHKeyIn_Screening.ScreeningCompleted_Message().getText();
        boolean isDispalyed = false;

        if (actmesg.equals(expmesg)) {
            isDispalyed = true;
        }

        verifyTest("Text not Present", isDispalyed);
    }
}
