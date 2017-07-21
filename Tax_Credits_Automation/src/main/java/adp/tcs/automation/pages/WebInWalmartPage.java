package adp.tcs.automation.pages;

import adp.tcs.automation.locators.WebInWalmartScreening;
import adp.tcs.automation.stepsfiles.BaseTempletSteps;
import adp.tcs.automation.utilities.WndowAction;
import adp.tcs.automation.utilities.randomSSNgenrater;
import org.openqa.selenium.WebElement;

/**
 * Created by BhuteSac on 10/7/2016.
 */
public class WebInWalmartPage extends BaseTempletSteps {


    WebElement element = null;
    private ScreeningPages screeningPages = new ScreeningPages();
    private randomSSNgenrater ssnGenerator = new randomSSNgenrater();
    private String SSN = null;

    WndowAction windowAct = new WndowAction();

    public WebElement walmart_TELEPHONE_NUMBER_WALMART(){

        element = getDriver().findElement(WebInWalmartScreening.TELEPHONE_NUMBER_WALMART);
        return element;
    }

    public WebElement walmart_SSN_FIRST_WALMART(){

        element = getDriver().findElement(WebInWalmartScreening.SSN_FIRST_WALMART);
        return element;
    }

    public WebElement walmart_AGE_YES_WALMART(){

        element = getDriver().findElement(WebInWalmartScreening.AGE_YES_WALMART);
        return element;
    }

    public WebElement walmart_AGE_NO_WALMART(){

        element = getDriver().findElement(WebInWalmartScreening.AGE_NO_WALMART);
        return element;
    }

    public WebElement walmart_CONFIRM_SSN_WALMART(){

        element = getDriver().findElement(WebInWalmartScreening.CONFIRM_SSN_WALMART);
        return element;
    }

    public WebElement walmart_DOB_WALMART(){

        element = getDriver().findElement(WebInWalmartScreening.DOB_WALMART);
        return element;
    }

    public WebElement walmart_FIRST_NAME_WALMART(){

        element = getDriver().findElement(WebInWalmartScreening.FIRST_NAME_WALMART);
        return element;
    }

    public WebElement walmart_MIDDLE_NAME_WALMART(){

        element = getDriver().findElement(WebInWalmartScreening.MIDDLE_NAME_WALMART);
        return element;
    }

    public WebElement walmart_LAST_NAME_WALMART(){

        element = getDriver().findElement(WebInWalmartScreening.LAST_NAME_WALMART);
        return element;
    }

    public WebElement walmart_AGE_YES_CCTW_YES(){

        element = getDriver().findElement(WebInWalmartScreening.AGE_YES_CCTW_YES);
        return element;
    }

    public WebElement walmart_AGE_NO_CCWTW_NO(){

        element = getDriver().findElement(WebInWalmartScreening.AGE_NO_CCWTW_NO);
        return element;
    }

    public WebElement walmart_TANF_ASSIT_9M_YES(){

        element = getDriver().findElement(WebInWalmartScreening.TANF_ASSIT_9M_YES);
        return element;
    }
    public WebElement walmart_TANF_ASSIT_9M_NO(){

        element = getDriver().findElement(WebInWalmartScreening.TANF_ASSIT_9M_NO);
        return element;
    }
    public WebElement walmart_TANF_ASSIT_18LATM_YES(){

        element = getDriver().findElement(WebInWalmartScreening.TANF_ASSIT_18LATM_YES);
        return element;
    }
    public WebElement walmart_TANF_ASSIT_18LATM_NO(){

        element = getDriver().findElement(WebInWalmartScreening.TANF_ASSIT_18LATM_NO);
        return element;
    }
    public WebElement walmart_TANF_ASSIT_18ANYM_YES(){

        element = getDriver().findElement(WebInWalmartScreening.TANF_ASSIT_18ANYM_YES);
        return element;
    }
    public WebElement walmart_TANF_ASSIT_18ANYM_NO(){

        element = getDriver().findElement(WebInWalmartScreening.TANF_ASSIT_18ANYM_NO);
        return element;
    }
    public WebElement walmart_TANF_WOTC_ELIGIBLE_YES(){

        element = getDriver().findElement(WebInWalmartScreening.TANF_WOTC_ELIGIBLE_YES);
        return element;
    }
    public WebElement walmart_TANF_WOTC_ELIGIBLE_NO(){

        element = getDriver().findElement(WebInWalmartScreening.TANF_WOTC_ELIGIBLE_NO);
        return element;
    }
    public WebElement walmart_TANF_PAYMENT_CHKBOX(){

        element = getDriver().findElement(WebInWalmartScreening.TANF_PAYMENT_CHKBOX);
        return element;
    }
    public WebElement walmart_FOOD_STAMP_QUE1_YES(){

        element = getDriver().findElement(WebInWalmartScreening.FOOD_STAMP_QUE1_YES);
        return element;
    }
    public WebElement walmart_FOOD_STAMP_QUE1_NO(){

        element = getDriver().findElement(WebInWalmartScreening.FOOD_STAMP_QUE1_NO);
        return element;
    }
    public WebElement walmart_FOOD_STAMP_QUE2_YES(){

        element = getDriver().findElement(WebInWalmartScreening.FOOD_STAMP_QUE2_YES);
        return element;
    }
    public WebElement walmart_FOOD_STAMP_QUE2_NO(){

        element = getDriver().findElement(WebInWalmartScreening.FOOD_STAMP_QUE2_NO);
        return element;
    }
    public WebElement walmart_HIRE_INFO_GAVE_INFO_DATE(){

        element = getDriver().findElement(WebInWalmartScreening.HIRE_INFO_GAVE_INFO_DATE);
        return element;
    }
    public WebElement walmart_HOURLY_WAGES_WALMART(){

        element = getDriver().findElement(WebInWalmartScreening.HOURLY_WAGES_WALMART);
        return element;
    }
    public WebElement walmart_HOURLY_WAGES(){

        element = getDriver().findElement(WebInWalmartScreening.HOURLY_WAGES);
        return element;
    }
    public WebElement walmart_JOB_OFFER_DATE_WALMART(){

        element = getDriver().findElement(WebInWalmartScreening.JOB_OFFER_DATE_WALMART);
        return element;
    }
    public WebElement walmart_JOB_HIRE_DATE_WALMART(){

        element = getDriver().findElement(WebInWalmartScreening.JOB_HIRE_DATE_WALMART);
        return element;
    }
    public WebElement JOB_START_DATE_WALMART(){

        element = getDriver().findElement(WebInWalmartScreening.JOB_START_DATE_WALMART);
        return element;
    }
    public WebElement walmart_JOB_POSITION_WALMART(){

        element = getDriver().findElement(WebInWalmartScreening.JOB_POSITION_WALMART);
        return element;
    }
    public WebElement walmart_DONE_BUTTON_WALMART(){

        element = getDriver().findElement(WebInWalmartScreening.DONE_BUTTON_WALMART);
        return element;
    }

    public void performHireSingleFlowWalmart(){
        try {
    		/*screeningPages.hire_Info_Gave_Info_Date().sendKeys(getExcelData().get("HIRE_GAVE_INFO_DATE"));
    		screeningPages.hire_Info_Job_Offer_Date().sendKeys(getExcelData().get("HIRE_JOB_OFFER_DATE"));
    		screeningPages.hire_Info_Hire_Date().sendKeys(getExcelData().get("HIRE_DATE"));
    		screeningPages.hire_Info_Start_Date().sendKeys(getExcelData().get("HIRE_START_DATE"));*/
            walmart_HIRE_INFO_GAVE_INFO_DATE().sendKeys(currentdate());
            walmart_JOB_OFFER_DATE_WALMART().sendKeys(currentdate());
            walmart_JOB_HIRE_DATE_WALMART().sendKeys(currentdate());
            JOB_START_DATE_WALMART().sendKeys(currentdate());
            selectDropdown(walmart_JOB_POSITION_WALMART(),getExcelData().get("HIRE_JOB_POSITION"));
            walmart_HOURLY_WAGES_WALMART().sendKeys(getExcelData().get("HIRE_WAGE"));
           // selectDropdown(screeningPages.hire_Info_Wage_Type(),getExcelData().get("HIRE_WAGE_TYPE"));
            screeningPages.personalInfo_Continue_Button().click();
        } catch (Exception e) {
            e.printStackTrace();
            verifyTest("Faliure in performHireInfomationPageActions page",false);
        }
    }


    public void walmartPersonalInformation()
    {
        try {
            SSN = String.valueOf(ssnGenerator.generateSSN());

            getExcelData().put("SSN", SSN);
            getExcelData().put("CSSN", SSN);
            walmart_FIRST_NAME_WALMART().sendKeys(getExcelData().get("FNAME"));  // user input in First Name text field.
            walmart_MIDDLE_NAME_WALMART().sendKeys(getExcelData().get("MNAME"));  // user input in Middle Name text field.
            walmart_LAST_NAME_WALMART().sendKeys(getExcelData().get("LNAME"));
            walmart_TELEPHONE_NUMBER_WALMART().sendKeys(getExcelData().get("TELEPHONE"));
            walmart_SSN_FIRST_WALMART().sendKeys(getExcelData().get("SSN"));// user input in SSN text field.
            if(getExcelData().get("AGE").equals("YES"))
            {
                walmart_AGE_YES_WALMART().click();
                waitForLoad();
                walmart_CONFIRM_SSN_WALMART().sendKeys(getExcelData().get("SSN"));
                walmart_DOB_WALMART().sendKeys(getExcelData().get("DOB"));

            }
            else{
                walmart_AGE_NO_WALMART().click();
                waitForLoad();
                walmart_CONFIRM_SSN_WALMART().sendKeys(getExcelData().get("SSN"));
            }
            screeningPages.personalInfo_Continue_Button().click();
            waitForLoad();
        } catch (Exception e) {
            verifyTest("Faliure in walmartPersonalInformation page",false);
            e.printStackTrace();
        }

    }

    public void performTemporaryAssistanceWalmart(){
        try {
            if(getExcelData().get("TEMP_ASSISTANCE_QUE_A").equals("YES")) {
                walmart_TANF_ASSIT_9M_YES().click();
                walmart_TANF_ASSIT_18LATM_YES().click();
                walmart_TANF_ASSIT_18ANYM_YES().click();
                walmart_TANF_WOTC_ELIGIBLE_YES().click();

                walmart_TANF_PAYMENT_CHKBOX().click();
                screeningPages.tempAssistance_Recipient_TxtBox().sendKeys(getExcelData().get("PRIMARY_RECIPIENT_NAME"));
                screeningPages.tempAssistance_Relation_TxtBox().sendKeys(getExcelData().get("TEMP_ASSISTANCE_RELATION"));
                screeningPages.tempAssistance_City_TxtBox().sendKeys(getExcelData().get("TEMP_ASSISTANCE_CITY"));
                selectDropdown(screeningPages.tempAssistance_State_Dropdown(), getExcelData().get("TEMP_ASSISTANCE_STATE"));
                screeningPages.tempAssistance_Continue_Btn().click();
            }else{
                walmart_TANF_ASSIT_9M_NO().click();
                walmart_TANF_ASSIT_18LATM_NO().click();
                walmart_TANF_ASSIT_18ANYM_NO().click();
                walmart_TANF_WOTC_ELIGIBLE_NO().click();
                walmart_TANF_PAYMENT_CHKBOX().click();
                // screeningPages.tempAssistance_Continue_Btn().click();
            }
        } catch (Exception e) {
            verifyTest("Faliure in performTemporaryAssistancePageActions page",false);
            e.printStackTrace();
        }
    }

    public void performFoodStampsPageWalmart(){
        try {
            if(getExcelData().get("FOOD_STAMPS_QUE").equals("YES")) {
                walmart_FOOD_STAMP_QUE1_YES().click();
                sleep(1000);
                walmart_FOOD_STAMP_QUE2_YES().click();
                waitForLoad();
                screeningPages.foodStamps_Recipient_TxtBox().sendKeys(getExcelData().get("FOOD_STAMPS_RECIPIENT_NAME"));
                screeningPages.foodStamps_Relation_TxtBox().sendKeys(getExcelData().get("FOOD_STAMPS_RECIPIENT_RELATION"));
                screeningPages.foodStamps_City_TxtBox().sendKeys(getExcelData().get("FOOD_STAMPS_CITY"));
                selectDropdown(screeningPages.foodStamps_State_Dropdown(),getExcelData().get("FOOD_STAMPS_STATE"));
                screeningPages.foodStamps_Continue_Btn().click();
            }else{
                screeningPages.foodStamps_No_Btn().click();
                walmart_FOOD_STAMP_QUE2_NO().click();
                waitForLoad();
            }
        } catch (Exception e) {
            verifyTest("Faliure in performFoodStampsPageActions page",false);
            e.printStackTrace();
        }
    }

}
