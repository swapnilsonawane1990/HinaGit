package adp.tcs.automation.stepsfiles;

import adp.tcs.automation.locators.CAKeyIn_ScreeningLocators;
import adp.tcs.automation.locators.SearchSSNHub;
import adp.tcs.automation.pages.CAKeyIn_Screening;
import adp.tcs.automation.pages.MonitoringPages;
import adp.tcs.automation.pages.SearchSSNthroughHub;
import adp.tcs.automation.utilities.WndowAction;
import adp.tcs.automation.utilities.randomSSNgenrater;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebElement;

/**
 * Created by garghina on 10/6/2016.
 */
public class CAKeyIn_Screening_Steps extends BaseTempletSteps {
    private MonitoringPages dataentrylink = new MonitoringPages();
    private CAKeyIn_ScreeningLocators CAKeyIn_ScreeningLocators = new CAKeyIn_ScreeningLocators();
    private HubValidationsSteps unitname = new HubValidationsSteps();
    private CAKeyIn_Screening caKeyIn_screening = new CAKeyIn_Screening();
    private WndowAction wndowAction = new WndowAction();
    private randomSSNgenrater ssnGenerator = new randomSSNgenrater();
    private SearchSSNthroughHub searchSSNthroughHub = new SearchSSNthroughHub();
    String expmesg, actmesg;

    @When("User Perform CAKeyIn screening for eligible record")
    public void CaKeyInscreening(@Named("CompanyName") String CompanyName) {
        dataentrylink.data_Entry_Link().click();
        caKeyIn_screening.CAandPOHKeyFromPaper_Link().click();
        caKeyIn_screening.TaxCredits_image().click();
        explicitWaitForElement(CAKeyIn_ScreeningLocators.CAKeyIn_RadioButton, 40);
        caKeyIn_screening.CAKeyIn_RadioButton().click();
        sleep(1000);
        caKeyIn_screening.CompanyName_Field().sendKeys(CompanyName);
        sleep(4000);
        caKeyIn_screening.Company_Name_Dropdown().click();
        sleep(2000);
        unitname.unitNameSelection("H-CA-Chatsworth-AHI");
        sleep(2000);
        explicitWaitForElement(CAKeyIn_ScreeningLocators.StartScreening_Button, 65);
        caKeyIn_screening.StartScreening_Button().click();
        wndowAction.switchtoChildWindow();
        sleep(10000);
        explicitWaitForElement(CAKeyIn_ScreeningLocators.SSN_Field, 40);
        caKeyIn_screening.SSN_Field().sendKeys(String.valueOf(ssnGenerator.generateSSN()));
        sleep(4000);
        caKeyIn_screening.Hire_Date().click();
        sleep(2000);
        //selectCalenderDate(currentdate());
        caKeyIn_screening.Hire_Date().sendKeys(currentdate());
        caKeyIn_screening.Credit_Name_click().click();
        explicitWaitForElement(CAKeyIn_ScreeningLocators.Continue_Button, 20);
        caKeyIn_screening.Continue_Button().click();
        explicitWaitForElement(CAKeyIn_ScreeningLocators.CA_State_Forms, 20);
        caKeyIn_screening.EDD_ReleaseForm_CheckBox().click();
        caKeyIn_screening.T_4506_CheckBox().click();
        caKeyIn_screening.SF_180_CheckBox().click();
        caKeyIn_screening.FirstName_Field().sendKeys(getExcelData().get("FNAME"));
        caKeyIn_screening.Lastname_Field().sendKeys(getExcelData().get("LNAME"));
        caKeyIn_screening.Address_Field().sendKeys(getExcelData().get("HOME_STREET_ADDRESS"));
        caKeyIn_screening.Zipcode_Field().sendKeys(getExcelData().get("ZIP"));
        caKeyIn_screening.CA01_StateForm_CheckBox().click();
        sleep(40000);
        caKeyIn_screening.Continue_Button().click();
        sleep(2000);
        explicitWaitForElement(CAKeyIn_ScreeningLocators.Military_TargetGroup_Checkbox, 50);
        caKeyIn_screening.Military_TargetGroup_Checkbox().click();
        caKeyIn_screening.EarnedIncomeCredit_TargetGroup_Checkbox().click();
        caKeyIn_screening.Felony_TargetGroup_Checkbox().click();
        caKeyIn_screening.GeneralAssistance_TargetGroup_Checkbox().click();
        caKeyIn_screening.UnemployedFulltimeStudent_TargetGroup_Checkbox().click();
        sleep(2000);
        caKeyIn_screening.Continue_Button().click();
    }

    @Then("Screening should be completed successfully")
    public void VerifyMessage() {
        verifyTest("Screening should be completed successfully");
        expmesg = "Screening completed - thank you! You can safely close this window/tab now.";
        actmesg = caKeyIn_screening.ScreeningCompleted_Message().getText();
        boolean isDispalyed = false;

        if (actmesg.equals(expmesg)) {
            isDispalyed = true;
        }

        verifyTest("Text not Present", isDispalyed);
    }
}
