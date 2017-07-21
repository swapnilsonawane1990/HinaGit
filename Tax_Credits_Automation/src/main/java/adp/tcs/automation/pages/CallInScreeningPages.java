package adp.tcs.automation.pages;

import adp.tcs.automation.locators.CallInScreening;
import adp.tcs.automation.locators.ScreeningLocators;
import adp.tcs.automation.stepsfiles.BaseTempletSteps;
import adp.tcs.automation.utilities.UserAction;
import adp.tcs.automation.utilities.randomSSNgenrater;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by bhutesac on 9/28/2016.
 */
public class CallInScreeningPages extends BaseTempletSteps{
    private WebElement element = null;

    private CallInScreening callInScreening;
    private randomSSNgenrater ssnGenerator = new randomSSNgenrater();
    private String SSN = null;
    private ScreeningPages screeningPages = new ScreeningPages();
    private UserAction userAct = new UserAction();


    public WebElement callIn_CALl_IN_SUB_TAB(){

        element = getDriver().findElement(callInScreening.CALl_IN_SUB_TAB);
        return element;
    }

    public WebElement callIn_DATA_ENTRY_TAB(){

        element = getDriver().findElement(callInScreening.DATA_ENTRY_TAB);
        return element;
    }

    public WebElement callIn_Scrrening_Page_Title(){

        element = getDriver().findElement(callInScreening.CALL_IN_PERSONAL_INFO_TITLE);
        return element;
    }
    public WebElement callIn_Scrrening_Continue_Button(){

        element = getDriver().findElement(callInScreening.CALL_IN_CONTINUE_BUTTON);
        return element;
    }

    public WebElement callIn_Screening_Prev_Emp_Ye(){

        element = getDriver().findElement(callInScreening.CALL_PREVIOUS_EMP_YES_BUTTON);
        return element;
    }

    public WebElement callIn_Screening_Prev_Emp_No(){

        element = getDriver().findElement(callInScreening.CALL_PREVIOUS_EMP_NO_BUTTON);
        return element;
    }

    public WebElement callIn_CALL_IN_EXTENSION_INPUT_BOX(){

        element = getDriver().findElement(callInScreening.CALL_IN_EXTENSION_INPUT_BOX);
        return element;
    }

    public WebElement callIn_CALL_IN_GET_CALL_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_IN_GET_CALL_BUTTON);
        return element;
    }

    public WebElement callIn_CALL_IN_COMPANY_SEARCH_BOX(){

        element = getDriver().findElement(callInScreening.CALL_IN_COMPANY_SEARCH_BOX);
        return element;
    }

    public WebElement CALL_IN_UNIT_SEARCH_SEARCH(){

        element = getDriver().findElement(callInScreening.CALL_IN_UNIT_SEARCH_SEARCH);
        return element;
    }

    public WebElement callIn_CALL_UNIT_NAME_BOX(){

        element = getDriver().findElement(callInScreening.CALL_UNIT_NAME_BOX);
        return element;
    }

    public WebElement callIn_CALL_UNIT_NAME_SEARCH_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_UNIT_NAME_SEARCH_BUTTON);
        return element;
    }
    public WebElement callIn_CALL_UNIT_SELECT_FIRST_ENTRY_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_UNIT_SELECT_FIRST_ENTRY_BUTTON);
        return element;
    }

    public WebElement callIn_CALL_UNIT_START_SCREENING_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_UNIT_START_SCREENING_BUTTON);
        return element;
    }

    public WebElement callIn_CALL_IN_PERSONAL_INFO_FIRST_NAME(){

        element = getDriver().findElement(callInScreening.CALL_IN_PERSONAL_INFO_FIRST_NAME);
        return element;
    }
    public WebElement callIn_SCALL_TEMP_ASSISTANCE_QUE1_YES_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_TEMP_ASSISTANCE_QUE1_YES_BUTTON);
        return element;
    }

    public WebElement callIn_CALL_TEMP_ASSISTANCE_QUE1_NO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_TEMP_ASSISTANCE_QUE1_NO_BUTTON);
        return element;
    }

    public WebElement callIn_CALL_TEMP_ASSISTANCE_QUE2_YES_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_TEMP_ASSISTANCE_QUE2_YES_BUTTON);
        return element;
    }
    public WebElement callIn_CALL_TEMP_ASSISTANCE_QUE2_NO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_TEMP_ASSISTANCE_QUE2_NO_BUTTON);
        return element;
    }

    public WebElement callIn_CALL_TEMP_ASSISTANCE_QUE3_YES_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_TEMP_ASSISTANCE_QUE3_YES_BUTTON);
        return element;
    }

    public WebElement callIn_CALL_TEMP_ASSISTANCE_QUE3_NO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_TEMP_ASSISTANCE_QUE3_NO_BUTTON);
        return element;
    }
    public WebElement callIn_CALL_TEMP_ASSISTANCE_PRIMARY_RECIPIENT_NAME_TEXTBOX(){

        element = getDriver().findElement(callInScreening.CALL_TEMP_ASSISTANCE_PRIMARY_RECIPIENT_NAME_TEXTBOX);
        return element;
    }

    public WebElement callIn_CALL_TEMP_ASSISTANCE_CITY_NAME_TEXTBOX(){

        element = getDriver().findElement(callInScreening.CALL_TEMP_ASSISTANCE_CITY_NAME_TEXTBOX);
        return element;
    }

    public WebElement callIn_CALL_TEMP_ASSISTANCE_STATE_TEXTBOX(){

        element = getDriver().findElement(callInScreening.CALL_TEMP_ASSISTANCE_STATE_TEXTBOX);
        return element;
    }
    public WebElement callIn_CALL_TEMP_ASSISTANCE_STATE_DROPDOWN(){

        element = getDriver().findElement(callInScreening.CALL_TEMP_ASSISTANCE_STATE_DROPDOWN);
        return element;
    }

    public WebElement callIn_CALL_TEMP_ASSISTANCE_NOTE_TEXTBOX(){

        element = getDriver().findElement(callInScreening.CALL_TEMP_ASSISTANCE_NOTE_TEXTBOX);
        return element;
    }

    public WebElement callIn_CALL_IN_CONTINUE_ONLY_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_IN_CONTINUE_ONLY_BUTTON);
        return element;
    }
    
    public WebElement callIn_CALL_IN_EXIT_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_IN_EXIT_BUTTON);
        return element;
    }
    
    
    public WebElement callIn_CALL_INVALID_ADDRESS_LABEL(){

        element = getDriver().findElement(callInScreening.CALL_IN_INVALID_ADDRESS_LABEL);
        return element;
    }
    
    public WebElement callIn_CALL_FELONY_QUE1_YES_BUTTON(){
        element = getDriver().findElement(callInScreening.CALL_FELONY_QUE1_YES_BUTTON);
        return element;
    }

    public WebElement callIn_CALL_FELONY_QUE1_NO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_FELONY_QUE1_NO_BUTTON);
        return element;
    }

    public WebElement callIn_CALL_FELONY_QUE2_YES_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_FELONY_QUE2_YES_BUTTON);
        return element;
    }
    public WebElement callIn_CALL_FELONY_QUE2_NO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_FELONY_QUE2_NO_BUTTON);
        return element;
    }

    public WebElement callIn_CALL_FELONY_QUE3_YES_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_FELONY_QUE3_YES_BUTTON);
        return element;
    }

    public WebElement callIn_CALL_FELONY_QUE3_NO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_FELONY_QUE3_NO_BUTTON);
        return element;
    }
    public WebElement callIn_CALL_FELONY_QUE4_YES_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_FELONY_QUE4_YES_BUTTON);
        return element;
    }

    public WebElement callIn_CALL_FELONY_QUE4_NO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_FELONY_QUE4_NO_BUTTON);
        return element;
    }

    public WebElement callIn_CALL_VOCATIONAL_REHAB_YESSA_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_VOCATIONAL_REHAB_YESSA_RADIO_BUTTON);
        return element;
    }
    public WebElement callIn_CALL_VOCATIONAL_REHAB_YESTW_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_VOCATIONAL_REHAB_YESTW_RADIO_BUTTON);
        return element;
    }

    public WebElement callIn_CALL_VOCATIONAL_REHAB_YESVA_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_VOCATIONAL_REHAB_YESVA_RADIO_BUTTON);
        return element;
    }

    public WebElement callIn_CALL_VOCATIONAL_REHAB_NO_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_VOCATIONAL_REHAB_NO_RADIO_BUTTON);
        return element;
    }
    public WebElement callIn_CALL_SSI_YES_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_SSI_YES_RADIO_BUTTON);
        return element;
    }

    public WebElement callIn_CALL_SSI_NO_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_SSI_NO_RADIO_BUTTON);
        return element;
    }

    public WebElement callIn_CALL_LTUE_QUE1_YES_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_LTUE_QUE1_YES_RADIO_BUTTON);
        return element;
    }
    public WebElement callIn_CALL_LTUE_QUE1_NO_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_LTUE_QUE1_NO_RADIO_BUTTON);
        return element;
    }

    public WebElement callIn_CALL_LTUE_QUE2_YES_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_LTUE_QUE2_YES_RADIO_BUTTON);
        return element;
    }

    public WebElement callIn_CALL_LTUE_QUE2_NO_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_LTUE_QUE2_NO_RADIO_BUTTON);
        return element;
    }
    public WebElement callIn_CALL_LTUE_DATE_SELECT(){

        element = getDriver().findElement(callInScreening.CALL_LTUE_DATE_SELECT);
        return element;
    }

    public WebElement callIn_CALL_LTUE_SELECT_DROPDOWN(){

        element = getDriver().findElement(callInScreening.CALL_LTUE_SELECT_DROPDOWN);
        return element;
    }

    public WebElement callIn_CALL_LTUE_SELECT_DROPDOWN_PA(){

        element = getDriver().findElement(callInScreening.CALL_LTUE_SELECT_DROPDOWN_FOR_PA);
        return element;
    }


    public WebElement callIn_CALL_CA_VETERAN_YES_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_CA_VETERAN_YES_RADIO_BUTTON);
        return element;
    }
    public WebElement callIn_CALL_CA_VETERAN_NO_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_CA_VETERAN_NO_RADIO_BUTTON);
        return element;
    }

    public WebElement callIn_CALL_CA_VETERAN_12M_YES_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_CA_VETERAN_12M_YES_RADIO_BUTTON);
        return element;
    }


    public WebElement callIn_CALL_CA_VETERAN__12M_NO_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_CA_VETERAN__12M_NO_RADIO_BUTTON);
        return element;
    }

    public WebElement callIn_CALL_CA_EIC_NO_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_CA_EIC_NO_RADIO_BUTTON);
        return element;
    }

    public WebElement callIn_CALL_CA_FELONY_YES_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_CA_FELONY_YES_RADIO_BUTTON);
        return element;
    }

    public WebElement callIn_CALL_CA_FELONY_NO_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_CA_FELONY_NO_RADIO_BUTTON);
        return element;
    }
    public WebElement callIn_CALL_CA_CALWORK_YES_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_CA_CALWORK_YES_RADIO_BUTTON);
        return element;
    }
    public WebElement callIn_CALL_CA_CALWORK_NO_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_CA_CALWORK_NO_RADIO_BUTTON);
        return element;
    }
    public WebElement callIn_CALL_CA_GENERALASSIS_YES_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_CA_GENERALASSIS_YES_RADIO_BUTTON);
        return element;
    }
    public WebElement callIn_CALL_CA_GENERALASSIS_NO_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_CA_GENERALASSIS_NO_RADIO_BUTTON);
        return element;
    }
    public WebElement callIn_CALL_CA_GENERALRELIF_YES_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_CA_GENERALRELIF_YES_RADIO_BUTTON);
        return element;
    }
    public WebElement callIn_CALL_CA_GENERALRELIF_NO_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_CA_GENERALRELIF_NO_RADIO_BUTTON);
        return element;
    }
    public WebElement callIn_CALL_CA_UNEMPLOYED_YES_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_CA_UNEMPLOYED_YES_RADIO_BUTTON);
        return element;
    }
    //----
    public WebElement callIn_CALL_CA_EIC_YES_RADIO_BUTTO(){

        element = getDriver().findElement(callInScreening.CALL_CA_EIC_YES_RADIO_BUTTON);
        return element;
    }


    public WebElement callIn_CALL_CA_UNEMPLOYED_NO_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_CA_UNEMPLOYED_NO_RADIO_BUTTON);
        return element;
    }
    public WebElement callIn_CALL_CA_SELF_EMPLOYED_YES_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_CA_SELF_EMPLOYED_YES_RADIO_BUTTON);
        return element;
    }
    public WebElement callIn_CALL_CA_SELF_EMPLOYED_NO_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_CA_SELF_EMPLOYED_NO_RADIO_BUTTON);
        return element;
    }
    public WebElement callIn_CALL_CA_FULL_TIME_STUDENT_YES_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_CA_FULL_TIME_STUDENT_YES_RADIO_BUTTON);
        return element;
    }
    public WebElement callIn_CALL_CA_FULL_TIME_STUDENT_NO_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_CA_FULL_TIME_STUDENT_NO_RADIO_BUTTON);
        return element;
    }
    public WebElement callIn_CALL_CA_DEGREE_12M_YES_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_CA_DEGREE_12M_YES_RADIO_BUTTON);
        return element;
    }

    public WebElement callIn_CALL_CA_DEGREE_12M_NO_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_CA_DEGREE_12M_NO_RADIO_BUTTON);
        return element;
    }

    public WebElement callIn_CALL_CA_WAGES_TEXTBOX(){

        element = getDriver().findElement(callInScreening.CALL_CA_WAGES_TEXTBOX);
        return element;
    }

    public WebElement callIn_Esign_CheckBOX(){

        element = getDriver().findElement(callInScreening.CALL_ESIGN_CHECKBOX);
        return element;
    }
    public WebElement callIn_Esign_CheckBOX_FIT2(){

        element = getDriver().findElement(callInScreening.CALL_ESIGN_CHECKBOX_FIT2);
        return element;
    }


    public WebElement callIn_CALL_IEC_Native_American_NO_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_IEC_Native_American_NO_RADIO_BUTTON);
        return element;
    }
    public WebElement callIn_Pennsylvania_EIP_YES_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_Pennsylvania_EIP_YES_RADIO_BUTTON);
        return element;
    }
    public WebElement callIn_Pennsylvania_EIP_NO_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_Pennsylvania_EIP_NO_RADIO_BUTTON);
        return element;
    }

    public WebElement callIn_CALL_CA_FED_IEC_NATIVE_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_CA_FED_IEC_NATIVE_RADIO_BUTTON);
        return element;
    }

    public WebElement callIn_CALL_ADDRESS_TEXTBOX(){

        element = getDriver().findElement(callInScreening.CALL_CA_ADDRESS_TEXTBOX);
        return element;
    }

    public WebElement callIn_CALL_IN_PERSONAL_INFO_LNAME_NAME(){

        element = getDriver().findElement(callInScreening.CALL_IN_PERSONAL_INFO_LNAME_NAME);
        return element;
    }
    public WebElement callIn_CALL_IN_PERSONAL_INFO_SSN_NAME(){

        element = getDriver().findElement(callInScreening.CALL_IN_PERSONAL_INFO_SSN_NAME);
        return element;
    }
    public WebElement callIn_CALL_IN_PERSONAL_INFO_CSSN_NAME(){

        element = getDriver().findElement(callInScreening.CALL_IN_PERSONAL_INFO_CSSN_NAME);
        return element;
    }
    public WebElement callIn_CALL_IN_PERSONAL_INFO_ZIP_NAME(){

        element = getDriver().findElement(callInScreening.CALL_IN_PERSONAL_INFO_ZIP_NAME);
        return element;
    }    
    
    public WebElement callIn_CALL_IN_PERSONAL_INFO_DOB_NAME(){

        element = getDriver().findElement(callInScreening.CALL_IN_PERSONAL_INFO_DOB_NAME);
        return element;
    }
    
    public WebElement CALL_IN_PERSONAL_INFO_AGE_CHECK_YES(){

        element = getDriver().findElement(callInScreening.CALL_IN_PERSONAL_INFO_AGE_CHECK_YES);
        return element;
    }
    
    public WebElement CALL_IN_PERSONAL_INFO_AGE_CHECK_NO(){

        element = getDriver().findElement(callInScreening.CALL_IN_PERSONAL_INFO_AGE_CHECK_NO);
        return element;
    }

    public WebElement callIn_CALL_IN_NO_CALL_PENDING_MSG(){

        element = getDriver().findElement(callInScreening.CALL_IN_NO_CALL_PENDING_MSG);
        return element;
    }


    public WebElement callIn_CALL_UNIT_PERSONAL_INFO_TITLE(){

        element = getDriver().findElement(callInScreening.CALL_UNIT_PERSONAL_INFO_TITLE);
        return element;
    }

    public WebElement callIn_CALL_FOOD_STAMP_YES_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_FOOD_STAMP_YES_RADIO_BUTTON);
        return element;
    }

    public WebElement callIn_CALL_FOOD_STAMP_NO_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_FOOD_STAMP_NO_RADIO_BUTTON);
        return element;
    }

    public WebElement callIn_CALL_VET_FOOD_STAMP_YES_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_VET_FOOD_STAMP_YES_RADIO_BUTTON);
        return element;
    }

    public WebElement callIn_CALL_VET_FOOD_STAMP_NO_RADIO_BUTTON(){

        element = getDriver().findElement(callInScreening.CALL_VET_FOOD_STAMP_NO_RADIO_BUTTON);
        return element;
    }

    public WebElement callIn_Exit_Button(){

        element = getDriver().findElement(callInScreening.CALL_IN_SCREENING_COM_EXIT);
        return element;
    }

    public WebElement callIn_hire_Info_Gave_Info_Date(){
        WebElement element = getDriver().findElement(callInScreening.CALL_GAVE_INFO_DATE);
        element.clear();
        return element;
    }

    public WebElement callIn_hire_Info_Job_Offer_Date(){
        WebElement element = getDriver().findElement(callInScreening.CALL_JOB_OFFER_DATE);
        element.clear();
        return element;
    }

    public WebElement callIn_hire_Info_Hire_Date(){
        WebElement element = getDriver().findElement(callInScreening.CALL_HIRE_DATE);
        element.clear();
        return element;
    }

    public WebElement callIn_hire_Info_Start_Date(){
        WebElement element = getDriver().findElement(callInScreening.CALL_JOB_START_DATE);
        element.clear();
        return element;
    }

    public WebElement callIn_hire_Info_Job_Title(){
        WebElement element = getDriver().findElement(callInScreening.CALL_IN_JOB_TITLE);
        element.clear();
        return element;
    }

    public WebElement callIn_hire_Info_Starting_Wages(){
        WebElement element = getDriver().findElement(callInScreening.CALL_STARTING_WAGES);
        element.clear();
        return element;
    }


    //Manual Call In Screening

    public void callInManualStart()
    {

        sleep(3000);
        userClick(callIn_DATA_ENTRY_TAB());
        sleep(2000);
        userClick(callIn_CALl_IN_SUB_TAB());
        sleep(2000);
        if(!isDisplayed(callIn_CALL_IN_EXTENSION_INPUT_BOX())) {
            for (int i = 1; i <= 10; i++) {
                userClick(callIn_DATA_ENTRY_TAB());
                sleep(2000);
                userClick(callIn_CALl_IN_SUB_TAB());
                sleep(2000);
                if (isDisplayed(callIn_CALL_IN_EXTENSION_INPUT_BOX())) {
                    break;
                }
            }
        }

        callIn_CALL_IN_EXTENSION_INPUT_BOX().sendKeys(getExcelData().get("EXTENSION_NUMBER"));
        callIn_DATA_ENTRY_TAB().click();
        sleep(2000);
        getDriver().findElement(By.xpath("//*[@id=\"title\"]/span[2]")).click();
        callIn_CALL_IN_GET_CALL_BUTTON().click();
        sleep(5000);
        callIn_CALL_IN_COMPANY_SEARCH_BOX().sendKeys(getExcelData().get("COMPANY_NAME"));
        sleep(2000);
        getDriver().findElement(By.xpath("//a[@class='ng-scope ng-binding'][.='"+getExcelData().get("COMPANY_NAME")+"']")).click();
        CALL_IN_UNIT_SEARCH_SEARCH().click();
        sleep(2000);
        callIn_CALL_UNIT_NAME_BOX().sendKeys(getExcelData().get("UNIT_STATE"));
        sleep(2000);
        callIn_CALL_UNIT_NAME_SEARCH_BUTTON().click();
        sleep(3000);
        callIn_CALL_UNIT_SELECT_FIRST_ENTRY_BUTTON().click();
        sleep(2000);
        callIn_CALL_UNIT_START_SCREENING_BUTTON().click();
        sleep(5000);




    }

// Start Call In Screening Page

    public void callInScreeningStart()
    {
        callIn_DATA_ENTRY_TAB().click();
        sleep(2000);
        callIn_CALl_IN_SUB_TAB().click();
        sleep(2000);
        callIn_CALL_IN_EXTENSION_INPUT_BOX().sendKeys(getExcelData().get("EXTENSION_NUMBER"));
        callIn_CALL_IN_GET_CALL_BUTTON().click();
        sleep(5000);
        callIn_CALL_UNIT_START_SCREENING_BUTTON().click();
        sleep(5000);
    }

    //PERSONAL INFORMATION PAGE

    public void personalinforCallIn()
    {
        try {
            SSN = String.valueOf(ssnGenerator.generateSSN());
            sleep(2000);
            getExcelData().put("SSN", SSN);
            getExcelData().put("CSSN", SSN);
            callIn_CALL_IN_PERSONAL_INFO_SSN_NAME().sendKeys(getExcelData().get("SSN"));
            callIn_CALL_IN_PERSONAL_INFO_CSSN_NAME().sendKeys(getExcelData().get("CSSN"));
            callIn_CALL_IN_PERSONAL_INFO_FIRST_NAME().sendKeys(getExcelData().get("FNAME"));
            callIn_CALL_IN_PERSONAL_INFO_LNAME_NAME().sendKeys(getExcelData().get("LNAME"));
            callIn_CALL_IN_PERSONAL_INFO_ZIP_NAME().sendKeys(getExcelData().get("ZIP_CODE"));
            
            if(getExcelData().get("AGE").equals("YES")){
            	CALL_IN_PERSONAL_INFO_AGE_CHECK_YES().click();
            	sleep(2000);
            	callIn_CALL_IN_PERSONAL_INFO_DOB_NAME().sendKeys(getExcelData().get("DOB"));
            	sleep(2000);
            	callIn_Scrrening_Page_Title().click();
                sleep(2000);
                callIn_Scrrening_Continue_Button().click();
                sleep(2000);
            }else{
            	CALL_IN_PERSONAL_INFO_AGE_CHECK_NO().click();            	
            }
            
        } catch (Exception e) {
            verifyTest("Faliure in personalinforCallIn page",false);
            e.printStackTrace();
        }

    }

    //previous Employement
    public void callInpreviousEmployment() {
        try {
            if(getExcelData().get("PREVIOUS_EMPLOYEMENT").equals("YES")) {
                callIn_Screening_Prev_Emp_Ye().click();  // Click on previous Employement Yes button.
            }else{
                callIn_Screening_Prev_Emp_No().click();   // Click on previous Employement No button.
            }
        } catch (Exception e) {
            verifyTest("Faliure in callInpreviousEmployment page",false);
            e.printStackTrace();
        }
    }

    public void performVeternFoodStampsPage(){
        try {
            if(getExcelData().get("Are you a member of a family that has received food stamps anytime since 04/23/2015 (15 months ago)").equals("YES")) {
                callIn_CALL_VET_FOOD_STAMP_YES_RADIO_BUTTON().click();
                sleep(2000);
                //DATA
                screeningPages.veternFoodStamps_Continue_Button().click();
            }else{
                callIn_CALL_VET_FOOD_STAMP_NO_RADIO_BUTTON().click();
            }
        } catch (Exception e) {
            verifyTest("Faliure in performVeternFoodStampsPageActions page",false);
            e.printStackTrace();
        }
    }

    public void performFoodStampsPage(){
        try {
            if(getExcelData().get("FOOD_STAMPS_QUE").equals("YES")) {
                callIn_CALL_FOOD_STAMP_YES_RADIO_BUTTON().click();
                sleep(2000);
                //DATA
                screeningPages.veternFoodStamps_Continue_Button().click();
            }else{
                callIn_CALL_FOOD_STAMP_NO_RADIO_BUTTON().click();
            }
        } catch (Exception e) {
            verifyTest("Faliure in performVeternFoodStampsPageActions page",false);
            e.printStackTrace();
        }
    }


    //TANF Page
    public void callInperformTemporaryAssistancePageActions(){
        try {
            if(getExcelData().get("TEMP_ASSISTANCE_QUE_A").equals("YES")) {
                callIn_SCALL_TEMP_ASSISTANCE_QUE1_YES_BUTTON().click();
                callIn_CALL_TEMP_ASSISTANCE_QUE2_YES_BUTTON().click();
                callIn_CALL_TEMP_ASSISTANCE_QUE3_YES_BUTTON().click();
                callIn_CALL_TEMP_ASSISTANCE_PRIMARY_RECIPIENT_NAME_TEXTBOX().sendKeys(getExcelData().get("PRIMARY_RECIPIENT_NAME"));
                callIn_CALL_TEMP_ASSISTANCE_CITY_NAME_TEXTBOX().sendKeys(getExcelData().get("TEMP_ASSISTANCE_CITY"));
                selectDropdown(callIn_CALL_TEMP_ASSISTANCE_STATE_DROPDOWN(), getExcelData().get("TEMP_ASSISTANCE_STATE"));
                callIn_CALL_TEMP_ASSISTANCE_NOTE_TEXTBOX().sendKeys(getExcelData().get("NOTE_CALLIN"));
                callIn_CALL_IN_CONTINUE_ONLY_BUTTON().click();
            }else{
                callIn_CALL_TEMP_ASSISTANCE_QUE1_NO_BUTTON().click();
                callIn_CALL_TEMP_ASSISTANCE_QUE2_NO_BUTTON().click();
                callIn_CALL_TEMP_ASSISTANCE_QUE3_NO_BUTTON().click();
                callIn_CALL_IN_CONTINUE_ONLY_BUTTON().click();
            }
        } catch (Exception e) {
            verifyTest("Faliure in callInperformTemporaryAssistancePageActions page",false);
            e.printStackTrace();
        }
    }

    //Felony Page

    public void callInFelonyPage(){
        try {
            if(getExcelData().get("FELONY_QUE_1").equals("YES")) {
                callIn_CALL_FELONY_QUE1_YES_BUTTON().click();
                if(getExcelData().get("FELONY_CONVIECTED_FOR_FELONY_QUE2").equals("YES")){
                    callIn_CALL_FELONY_QUE2_YES_BUTTON().click();
                }else{
                    callIn_CALL_FELONY_QUE2_NO_BUTTON().click();
                }
                if(getExcelData().get("FELONY_CONVIECTED_FOR_FELONY_QUE3").equals("YES")){
                    callIn_CALL_FELONY_QUE3_YES_BUTTON().click();
                }else{
                    callIn_CALL_FELONY_QUE3_NO_BUTTON().click();
                }

                if(getExcelData().get("FELONY_CONVIECTED_FOR_FELONY_QUE4").equals("YES")){
                    callIn_CALL_FELONY_QUE4_YES_BUTTON().click();
                }else{
                    callIn_CALL_FELONY_QUE4_NO_BUTTON().click();
                }
                //DATA INPUT
                callIn_CALL_IN_CONTINUE_ONLY_BUTTON().click();
            }else{
                callIn_CALL_FELONY_QUE1_NO_BUTTON().click();
            }
        } catch (Exception e) {
            verifyTest("Faliure in callInFelony page",false);
            e.printStackTrace();
        }
    }

    //VOCATIONAL REHAB

    public void callInVocationalPage(){
        try {
            sleep(2000);
            if(getExcelData().get("VOCATIONAL_REHABILIATION_QUE").equals("YES STATE AGENCY")) {
                callIn_CALL_VOCATIONAL_REHAB_YESSA_RADIO_BUTTON().click();
                callIn_CALL_IN_CONTINUE_ONLY_BUTTON().click();
            }
            if(getExcelData().get("VOCATIONAL_REHABILIATION_QUE").equals("YES TICKET TO WORK PROGRAM")) {
                callIn_CALL_VOCATIONAL_REHAB_YESTW_RADIO_BUTTON().click();
                callIn_CALL_IN_CONTINUE_ONLY_BUTTON().click();
            }
            if(getExcelData().get("VOCATIONAL_REHABILIATION_QUE").equals("YES VA")) {
                callIn_CALL_VOCATIONAL_REHAB_YESVA_RADIO_BUTTON().click();
                sleep(2000);
                callIn_CALL_IN_CONTINUE_ONLY_BUTTON().click();
            }
            if(getExcelData().get("VOCATIONAL_REHABILIATION_QUE").equals("NO")) {
                callIn_CALL_VOCATIONAL_REHAB_NO_RADIO_BUTTON().click();
            }

        } catch (Exception e) {
            verifyTest("Faliure in callInVocationalPage page",false);
            e.printStackTrace();
        }
    }


    //SSI Page
    public void callInperformSSIPage(){
        try {
            sleep(2000);
            waitForLoad();
            if(getExcelData().get("SSI").equals("YES")) {
                callIn_CALL_SSI_YES_RADIO_BUTTON().click();

            }else{
                callIn_CALL_SSI_NO_RADIO_BUTTON().click();
            }
        } catch (Exception e) {
            verifyTest("Faliure in callInperformSSI page",false);
            e.printStackTrace();
        }
    }

    //Long term Unemployed

    public void performLongTermUnemplymentPageActions(){
        try {
            if(getExcelData().get("LONG_TERM_UNEMP_QUE_1").equals("YES")) {
                callIn_CALL_LTUE_QUE1_YES_RADIO_BUTTON().click();
                sleep(6000);
                waitForLoad();
                if(getExcelData().get("LONG_TERM_UNEMP_QUE_2").equals("YES")){
                    callIn_CALL_LTUE_QUE2_YES_RADIO_BUTTON().click();

                    waitForLoad();
                    callIn_CALL_LTUE_DATE_SELECT().sendKeys(getExcelData().get("LONG_TERM_UNEMP_START_DATE"));
                   // callIn_CALL_LTUE_QUE2_YES_RADIO_BUTTON().click();
                  //  selectDropdown(callIn_CALL_LTUE_SELECT_DROPDOWN(),getExcelData().get("LONG_TERM_STATE"));
                    callIn_CALL_IN_CONTINUE_ONLY_BUTTON().click();
                }else{
                    callIn_CALL_LTUE_QUE2_NO_RADIO_BUTTON().click();
                }
            }else{
                callIn_CALL_LTUE_QUE1_NO_RADIO_BUTTON().click();
            }
        } catch (Exception e) {
            verifyTest("Faliure in performLongTermUnemplymentPage page",false);
            e.printStackTrace();
        }
    }

    //Esign

    public void callInEsign(){
        try {
            sleep(2000);
            callIn_Scrrening_Continue_Button().click();
            sleep(8000);
            if(loadPropValues("envName").equalsIgnoreCase("Fit2"))

            {
                callIn_Esign_CheckBOX_FIT2().click();
            }
            else{
                callIn_Esign_CheckBOX().click();
            }

            sleep(2000);
            if(getExcelData().get("Scenario").equals("Call-In_MassProcess_Combo_PA")){
                callIn_CALL_LTUE_SELECT_DROPDOWN_PA().click();
                sleep(1000);
                selectDropdown(callIn_CALL_LTUE_SELECT_DROPDOWN_PA(), getExcelData().get("CALL_IN_ESIGN_REASON"));
            }
            else {
                callIn_CALL_LTUE_SELECT_DROPDOWN().click();
                sleep(1000);
                selectDropdown(callIn_CALL_LTUE_SELECT_DROPDOWN(), getExcelData().get("CALL_IN_ESIGN_REASON"));
            }
            sleep(1000);
            callIn_CALL_IN_CONTINUE_ONLY_BUTTON().click();
            sleep(2000);
        } catch (Exception e) {
            verifyTest("Faliure in callInEsign page",false);
            e.printStackTrace();
        }
    }

    //IEC page

    public void callInIEC(){
        try {
            sleep(5000);
            if(getExcelData().get("IEC_QUE_1").equals("YES")) {
                callIn_CALL_IEC_Native_American_NO_RADIO_BUTTON().click();
                sleep(3000);
                callIn_CALL_IN_CONTINUE_ONLY_BUTTON().click();
                sleep(2000);
            }else{
                callIn_CALL_CA_FED_IEC_NATIVE_RADIO_BUTTON().click();
            }
        } catch (Exception e) {
            verifyTest("Faliure in  callInIEC page",false);
            e.printStackTrace();
        }
    }

    public void callInPennsylvaniaEIP(){
        try {
            sleep(5000);
            if(getExcelData().get("CALL_IN_PENNSYLVANIA_EIP").equals("YES")) {
                callIn_Pennsylvania_EIP_YES_RADIO_BUTTON().click();
                sleep(2000);
            }else{
                callIn_Pennsylvania_EIP_NO_RADIO_BUTTON().click();
            }
        } catch (Exception e) {
            verifyTest("Faliure in callInPennsylvaniaEIP page",false);
            e.printStackTrace();
        }
    }
    //Address Page

    public void callInAdress(){
        try {
            sleep(2000);
            callIn_CALL_ADDRESS_TEXTBOX().sendKeys(getExcelData().get("HOME_STREET_ADDRESS"));
            sleep(2000);
            callIn_Scrrening_Continue_Button().click();
            sleep(4000);
            String pageHeader = screeningPages.screeningPageTitle().getText();
            if(pageHeader.equalsIgnoreCase("Address"))
            {
                sleep(2000);
                callIn_Scrrening_Continue_Button().click();
            }
        } catch (Exception e) {
            verifyTest("Faliure in callInAdress page",false);
            e.printStackTrace();
        }
    }

    //Address Page

    public void callInInstruction(){
        try {
            sleep(2000);
            callIn_Scrrening_Continue_Button().click();
        } catch (Exception e) {
            verifyTest("Faliure in callInInstruction page",false);
            e.printStackTrace();
        }
    }

    public void callInExit(){
        try {
        	callIn_CALL_IN_EXIT_BUTTON().click();
        } catch (Exception e) {
            verifyTest("Faliure in click of exit button",false);
            e.printStackTrace();
        }
    }
    
    //Thank you Page

    public void callInThankYou(){
        try {
            callIn_Scrrening_Continue_Button().click();
        } catch (Exception e) {
            verifyTest("Faliure in callInThankYou page",false);
            e.printStackTrace();
        }
    }

    //CA Militory Page

    public void callInCAMilitary(){
        try {
            sleep(3000);
            if(getExcelData().get("CA_MILITORY_QUE_1").equals("YES")) {
                callIn_CALL_CA_VETERAN_YES_RADIO_BUTTON().click();
                waitForLoad();
                if(getExcelData().get("CA_MILITORY_QUE_2").equals("YES")) {
                    waitForLoad();
                    callIn_CALL_CA_VETERAN_12M_YES_RADIO_BUTTON().click();
                    waitForLoad();
                }else{
                    callIn_CALL_CA_VETERAN__12M_NO_RADIO_BUTTON().click();
                    waitForLoad();
                }
                //DATA iNPUT
                callIn_CALL_IN_CONTINUE_ONLY_BUTTON().click();
                waitForLoad();
            }else{
                callIn_CALL_CA_VETERAN_NO_RADIO_BUTTON().click();
                waitForLoad();
            }
        } catch (Exception e) {
            verifyTest("Faliure in callInCAMilitary page",false);
            e.printStackTrace();
        }
    }

    //CA Earn Income

    public void callInCAEarnIncome(){
        try {
            sleep(3000);
            if(getExcelData().get("CA_EARNED_INCOME_CREDIT_QUE_1").equals("YES")) {
                callIn_CALL_CA_EIC_YES_RADIO_BUTTO().click();
                waitForLoad();
                callIn_CALL_IN_CONTINUE_ONLY_BUTTON().click();
                waitForLoad();
            }else{
                callIn_CALL_CA_EIC_NO_RADIO_BUTTON().click();
                waitForLoad();
            }
        } catch (Exception e) {
            verifyTest("Faliure in callInCAEarnIncome page",false);
            e.printStackTrace();
        }
    }

    //CA Felony

    public void callInCAFelony(){
        try {
            if(getExcelData().get("CA_FELONY_QUE_1").equals("YES")) {
                callIn_CALL_CA_FELONY_YES_RADIO_BUTTON().click();
                sleep(3000);
                waitForLoad();
                //Data Input
                callIn_CALL_IN_CONTINUE_ONLY_BUTTON().click();
                sleep(3000);
                waitForLoad();
            }else{
                callIn_CALL_CA_FELONY_NO_RADIO_BUTTON().click();
                sleep(3000);
                waitForLoad();
                callIn_CALL_IN_CONTINUE_ONLY_BUTTON().click();
                sleep(3000);
                waitForLoad();
            }
        } catch (Exception e) {
            verifyTest("Faliure in callInCAFelony page",false);
            e.printStackTrace();
        }
    }

    //CA GENERAL ASSISTANCE
    public void callInCAGeneralAssistance(){
        try {
            if(getExcelData().get("CA_GENERAL_ASSISTANCE_QUE_1").equals("YES")) {
                callIn_CALL_CA_CALWORK_YES_RADIO_BUTTON().click();
                if(getExcelData().get("CA_GENERAL_ASSISTANCE_QUE_2").equals("YES")){
                    callIn_CALL_CA_GENERALASSIS_YES_RADIO_BUTTON().click();
                    waitForLoad();
                }else{
                    callIn_CALL_CA_GENERALASSIS_NO_RADIO_BUTTON().click();
                    waitForLoad();
                }
                if(getExcelData().get("CA_GENERAL_ASSISTANCE_QUE_3").equals("YES")){
                    callIn_CALL_CA_GENERALRELIF_YES_RADIO_BUTTON().click();
                    waitForLoad();
                }else{
                    callIn_CALL_CA_GENERALRELIF_NO_RADIO_BUTTON().click();
                    waitForLoad();
                }
            }else{
                callIn_CALL_CA_CALWORK_NO_RADIO_BUTTON().click();
                if(getExcelData().get("CA_GENERAL_ASSISTANCE_QUE_2").equals("YES")){
                    callIn_CALL_CA_GENERALASSIS_YES_RADIO_BUTTON().click();
                    waitForLoad();
                }else{
                    callIn_CALL_CA_GENERALASSIS_NO_RADIO_BUTTON().click();
                    waitForLoad();
                }
                if(getExcelData().get("CA_GENERAL_ASSISTANCE_QUE_3").equals("YES")){
                    callIn_CALL_CA_GENERALRELIF_YES_RADIO_BUTTON().click();
                    waitForLoad();
                }else{
                    callIn_CALL_CA_GENERALRELIF_NO_RADIO_BUTTON().click();
                    waitForLoad();
                }
               // callIn_CA8LL_IN_CONTINUE_ONLY_BUTTON().click();
            }
        } catch (Exception e) {
            verifyTest("Faliure in callInCAGeneralAssistance page",false);
            e.printStackTrace();
        }
    }

    //CA Unemployed Full Time Student

    public void callInCAUnemployedFullTimeStudent(){
        try {
            if(getExcelData().get("CA_UNEMPLOYED_FTS_QUE_1").equals("YES")) {
                callIn_CALL_CA_UNEMPLOYED_YES_RADIO_BUTTON().click();
                waitForLoad();
                callIn_CALL_CA_SELF_EMPLOYED_YES_RADIO_BUTTON().click();
                waitForLoad();
                callIn_CALL_CA_FULL_TIME_STUDENT_YES_RADIO_BUTTON().click();
                waitForLoad();
                callIn_CALL_CA_DEGREE_12M_YES_RADIO_BUTTON().click();
                waitForLoad();

                //Data Input
                callIn_CALL_IN_CONTINUE_ONLY_BUTTON().click();
                waitForLoad();
            }else{
                callIn_CALL_CA_UNEMPLOYED_NO_RADIO_BUTTON().click();
                waitForLoad();
            }
        } catch (Exception e) {
            verifyTest("Faliure in callInCAUnemployedFullTimeStudent page",false);
            e.printStackTrace();
        }
    }


    public void performHireInfomationPageActions(){
        try {
            if (getExcelData().get("HIRE_CURRENT_DATE").equalsIgnoreCase("YES")) {
                callIn_hire_Info_Gave_Info_Date().sendKeys(currentdate());
                callIn_hire_Info_Job_Offer_Date().sendKeys(currentdate());
                callIn_hire_Info_Hire_Date().sendKeys(currentdate());
               callIn_hire_Info_Start_Date().sendKeys(currentdate());


            }
            else if (getExcelData().get("HIRE_CURRENT_DATE").equalsIgnoreCase("CALCULATE_DATE"))
                {
                    String newdate =addSubtractfromCurrentDate(Integer.valueOf(getExcelData().get("HIRE_DATE_CALCULATE_NO_OF_DAYS")));
                    callIn_hire_Info_Gave_Info_Date().sendKeys(newdate);
                    callIn_hire_Info_Job_Offer_Date().sendKeys(newdate);
                    callIn_hire_Info_Hire_Date().sendKeys(newdate);
                    callIn_hire_Info_Start_Date().sendKeys(newdate);
            }
            else {
                callIn_hire_Info_Gave_Info_Date().sendKeys(getExcelData().get("HIRE_GAVE_INFO_DATE"));
                callIn_hire_Info_Job_Offer_Date().sendKeys(getExcelData().get("HIRE_JOB_OFFER_DATE"));
                callIn_hire_Info_Hire_Date().sendKeys(getExcelData().get("HIRE_DATE"));
                callIn_hire_Info_Start_Date().sendKeys(getExcelData().get("HIRE_START_DATE"));
            }
            callIn_hire_Info_Starting_Wages().sendKeys(getExcelData().get("HIRE_WAGE"));
           // userAct.switchToFrame("call_in_screening");
            selectDropdownByValue(callIn_hire_Info_Job_Title(),getExcelData().get("HIRE_JOB_POSITION"));

           // selectDropdown(callIn_hire_Info_Starting_Wages(),getExcelData().get("HIRE_WAGE_TYPE"));
            screeningPages.IEC_SP_Continue_Btn().click();

            sleep(5000);
            if (isDisplayed(ScreeningLocators.QUESTION_DISPLAYED)) {
                screeningPages.IEC_SP_Continue_Btn().click();
            }

        } catch (Exception e) {
            e.printStackTrace();
            verifyTest("Faliure in performHireInfomationPageActions page",false);
        }
    }
}
