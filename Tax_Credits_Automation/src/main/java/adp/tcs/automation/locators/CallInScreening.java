package adp.tcs.automation.locators;

import org.openqa.selenium.By;

/**
 * Created by bhutesac on 9/28/2016.
 */
public class CallInScreening {

    public static By CALL_IN_EXTENSION_INPUT_BOX = By.xpath("//input[@name='extension']");
    public static By DATA_ENTRY_TAB = By.xpath("//a[@class='menu-label'][.='Data Entry']");
    public static By CALl_IN_SUB_TAB = By.xpath("//a[@href='#/dataEntry/callInIVR'][.='Call-in IVR']");
    public static By CALL_IN_GET_CALL_BUTTON = By.xpath("//*[@id=\"ng-app\"]/div/div[2]/div/div[2]/div/div[1]/div[2]/div/button/span");
    public static By CALL_IN_COMPANY_SEARCH_BOX = By.xpath("//input[@name='companySearch']");
    public static By CALL_IN_NO_CALL_PENDING_MSG = By.xpath("//span[@class='ng-binding ng-scope'][contains(text(),'There is no pending call for this extension')]");


    //select the comapany by providing comapany
    //strong[.='Motox']
    public static By CALL_IN_UNIT_SEARCH_SEARCH = By.xpath("//i[@class='fa fa-search popup_help']");

    public static By CALL_UNIT_PERSONAL_INFO_TITLE = By.xpath("//h2[.='Personal Info']");
    public static By CALL_UNIT_NAME_BOX = By.xpath("//input[@id='unitHelpSearchName']");
    public static By CALL_UNIT_NAME_SEARCH_BUTTON = By.xpath("//button[@id='unit_help_btn']");

    public static By CALL_UNIT_SELECT_FIRST_ENTRY_BUTTON = By.xpath("//*[@id=\"unitHelpTable\"]/tbody/tr[1]/td[2]");
    public static By CALL_UNIT_START_SCREENING_BUTTON = By.xpath("//span[.='Start Screening']");


    //personal info Screening page
    public static By CALL_IN_PERSONAL_INFO_FIRST_NAME = By.xpath("//*[@id=\"question\"]/div[2]/div[2]/input");
    public static By CALL_IN_PERSONAL_INFO_LNAME_NAME = By.xpath("//*[@id=\"question\"]/div[2]/div[9]/input");
    public static By CALL_IN_PERSONAL_INFO_SSN_NAME = By.xpath("//*[@id=\"question\"]/div[2]/div[16]/input");
    public static By CALL_IN_PERSONAL_INFO_CSSN_NAME = By.xpath("//*[@id=\"question\"]/div[2]/div[23]/input");
    public static By CALL_IN_PERSONAL_INFO_ZIP_NAME = By.xpath("//*[@id=\"question\"]/div[2]/div[30]/input");
    public static By CALL_IN_PERSONAL_INFO_DOB_NAME = By.xpath("//*[@id=\"question\"]/div[2]/div[44]/input");
    public static By CALL_IN_PERSONAL_INFO_AGE_CHECK_YES = By.xpath("//input[@id='AgeCheck_YES']");
    public static By CALL_IN_PERSONAL_INFO_AGE_CHECK_NO = By.xpath("//input[@id='AgeCheck_NO']");
    

    public static By CALL_IN_PERSONAL_INFO_TITLE = By.xpath("//*[@id=\"questions\"]/h2");
    public static By CALL_IN_CONTINUE_BUTTON = By.xpath("//button[@id='continuebutton']");

    //Previous Employement Page

    public static By CALL_PREVIOUS_EMP_YES_BUTTON = By.xpath("//*[@id=\"PreviousEmployed_YES\"]");
    public static By CALL_PREVIOUS_EMP_NO_BUTTON = By.xpath("//*[@id=\"PreviousEmployed_NO\"]");

    //Temporary Assistance
    //que1
    public static By CALL_TEMP_ASSISTANCE_QUE1_YES_BUTTON = By.xpath("//*[@id=\"TANF_WOTC2Years_YES\"]");
    public static By CALL_TEMP_ASSISTANCE_QUE1_NO_BUTTON = By.xpath("//*[@id=\"TANF_WOTC2Years_NO\"]");

    //que2
    public static By CALL_TEMP_ASSISTANCE_QUE2_YES_BUTTON = By.xpath("//*[@id=\"TANF_WOTCNotEligible_YES\"]");
    public static By CALL_TEMP_ASSISTANCE_QUE2_NO_BUTTON = By.xpath("//*[@id=\"TANF_WOTCNotEligible_NO\"]");

    //que3
    public static By CALL_TEMP_ASSISTANCE_QUE3_YES_BUTTON = By.xpath("//*[@id=\"TANF_WOTCAsst18M_YES\"]");
    public static By CALL_TEMP_ASSISTANCE_QUE3_NO_BUTTON = By.xpath("//*[@id=\"TANF_WOTCAsst18M_NO\"]");

    public static By CALL_TEMP_ASSISTANCE_PRIMARY_RECIPIENT_NAME_TEXTBOX = By.xpath("//*[@id=\"question\"]/div[2]/div[37]/input");
    public static By CALL_TEMP_ASSISTANCE_CITY_NAME_TEXTBOX = By.xpath("//*[@id=\"question\"]/div[2]/div[51]/input");
    public static By CALL_TEMP_ASSISTANCE_STATE_TEXTBOX = By.xpath("//*[@id=\"question\"]/div[2]/div[51]/input");

    public static By CALL_TEMP_ASSISTANCE_STATE_DROPDOWN = By.xpath("//*[@id=\"question\"]/div[2]/div[58]/div[4]/div/select");
    public static By CALL_TEMP_ASSISTANCE_NOTE_TEXTBOX = By.xpath("//*[@id=\"question\"]/div[2]/div[65]/input");
    public static By CALL_IN_CONTINUE_ONLY_BUTTON = By.xpath("//button[@id='continuebutton']");
    public static By CALL_IN_EXIT_BUTTON = By.xpath("//*[@id='ng-app']/div[2]/div[2]/div/div[1]/div/button/span");
    
    //Felony
    //que1
    public static By CALL_FELONY_QUE1_YES_BUTTON = By.xpath("//*[@id=\"Felony_General_YES\"]");
    public static By CALL_FELONY_QUE1_NO_BUTTON = By.xpath("//*[@id=\"Felony_General_NO\"]");

    //QUE2
    public static By CALL_FELONY_QUE2_YES_BUTTON = By.xpath("//*[@id=\"Felony_ReleaseProgram_YES\"]");
    public static By CALL_FELONY_QUE2_NO_BUTTON = By.xpath("//*[@id=\"Felony_ReleaseProgram_NO\"]");

    //QUE3
    public static By CALL_FELONY_QUE3_YES_BUTTON = By.xpath("//*[@id=\"Felony_Convicted_YES\"]");
    public static By CALL_FELONY_QUE3_NO_BUTTON = By.xpath("//*[@id=\"Felony_Convicted_NO\"]");

   // QUE4
    public static By CALL_FELONY_QUE4_YES_BUTTON = By.xpath("//*[@id=\"Felony_General_YES\"]");
    public static By CALL_FELONY_QUE4_NO_BUTTON = By.xpath("//*[@id=\"Felony_General_NO\"]");

    // data input
    //*[@id="question"]/div[2]/div[44]/div[4]/div/input
    //*[@id="question"]/div[2]/div[51]/div[4]/div/input
    //*[@id="question"]/div[2]/div[58]/div[4]/div/input
    //select
    //*[@id="question"]/div[2]/div[79]/input
    //*[@id="question"]/div[2]/div[86]/input
    //*[@id="question"]/div[2]/div[93]/input

    //Vocational Rehab Page

    public static By CALL_VOCATIONAL_REHAB_YESSA_RADIO_BUTTON = By.xpath("//*[@id=\"VocationalRehab_VocRehab_YESSA\"]");
    public static By CALL_VOCATIONAL_REHAB_YESTW_RADIO_BUTTON = By.xpath("//*[@id=\"VocationalRehab_VocRehab_YESTW\"]");
    public static By CALL_VOCATIONAL_REHAB_YESVA_RADIO_BUTTON = By.xpath("//*[@id=\"VocationalRehab_VocRehab_YESVA\"]");
    public static By CALL_VOCATIONAL_REHAB_NO_RADIO_BUTTON = By.xpath("//*[@id=\"VocationalRehab_VocRehab_NO\"]");

            //DATA
    //*[@id="question"]/div[2]/div[16]/input
    //select
    //*[@id="question"]/div[2]/div[30]/input
    //*[@id="question"]/div[2]/div[37]/input

    //SSI Page

   // QUE1
    public static By CALL_SSI_YES_RADIO_BUTTON = By.xpath("//*[@id=\"SSI_YES\"]");
    public static By CALL_SSI_NO_RADIO_BUTTON = By.xpath("//*[@id=\"SSI_NO\"]");

    //Long Term Unemployemnt
//QUE1
    public static By CALL_LTUE_QUE1_YES_RADIO_BUTTON = By.xpath("//*[@id=\"LongTermUnemployed_Period_YES\"]");
    public static By CALL_LTUE_QUE1_NO_RADIO_BUTTON = By.xpath("//*[@id=\"LongTermUnemployed_Period_NO\"]");
//QUE2

    public static By CALL_LTUE_QUE2_YES_RADIO_BUTTON = By.xpath("//*[@id=\"LongTermUnemployed_Benefit_YES\"]");
    public static By CALL_LTUE_QUE2_NO_RADIO_BUTTON = By.xpath("//*[@id=\"LongTermUnemployed_Benefit_NO\"]");

    //DATE DROPDOWN SELECT

    public static By CALL_LTUE_DATE_SELECT = By.xpath("//*[@class=\"hasDatepicker\"]");

    public static By CALL_LTUE_SELECT_DROPDOWN = By.xpath("//*[@id=\"question\"]/div[2]/div[44]/div[4]/div/select");
    public static By CALL_LTUE_SELECT_DROPDOWN_FOR_PA = By.xpath("//*[@id=\"question\"]/div[2]/div[37]/div[4]/div/select");


        //Esign
        //continue button
        //div[@class-'radio radio-margin']/input

    public static By CALL_ESIGN_CHECKBOX = By.xpath(" //*[@name='chk5803']");
    public static By CALL_ESIGN_CHECKBOX_FIT2 = By.xpath("//*[@name='chk6373']");
        //select
        //continue button chk6373


    //CA Veteran Page

    public static By CALL_CA_VETERAN_YES_RADIO_BUTTON = By.xpath("//*[@id=\"CANEC_Veteran_YES\"]");
    public static By CALL_CA_VETERAN_NO_RADIO_BUTTON = By.xpath("//*[@id=\"CANEC_Veteran_NO\"]");

    public static By CALL_CA_VETERAN_12M_YES_RADIO_BUTTON = By.xpath("//*[@id=\"CANEC_Veteran_12m_YES\"]");
    public static By CALL_CA_VETERAN__12M_NO_RADIO_BUTTON = By.xpath("//*[@id=\"CANEC_Veteran_12m_NO\"]");

    //select
    //*[@id="question"]/div[2]/div[23]/div[4]/div/input
    //*[@id="question"]/div[2]/div[30]/div[4]/div/input

   //CA Earn Income Page
   public static By CALL_CA_EIC_YES_RADIO_BUTTON = By.xpath("//*[@id=\"CANEC_EIC_YES\"]");
    public static By CALL_CA_EIC_NO_RADIO_BUTTON = By.xpath("//*[@id=\"CANEC_EIC_NO\"]");
    //IF YES CONTINUE BUTTON ELSE NO.

    //*[@id="question"]/div[2]/div[9]/input

    //CA Felony

    public static By CALL_CA_FELONY_YES_RADIO_BUTTON = By.xpath("//*[@id=\"CANEC_Felony_YES\"]");
    public static By CALL_CA_FELONY_NO_RADIO_BUTTON = By.xpath("//*[@id=\"CANEC_Felony_NO\"]");

    //DATA
    //*[@id="question"]/div[2]/div[16]/input
    //*[@id="question"]/div[2]/div[23]/input
    //SELECT
    //*[@id="question"]/div[2]/div[37]/input
    //*[@id="question"]/div[2]/div[44]/input

    //CA GENERAL ASSISTANCE


    public static By CALL_CA_CALWORK_YES_RADIO_BUTTON = By.xpath("//*[@id=\"CANEC_CalWorks_YES\"]");
    public static By CALL_CA_CALWORK_NO_RADIO_BUTTON = By.xpath("//*[@id=\"CANEC_CalWorks_NO\"]");

    public static By CALL_CA_GENERALASSIS_YES_RADIO_BUTTON = By.xpath("//*[@id=\"CANEC_GeneralAssistance_YES\"]");
    public static By CALL_CA_GENERALASSIS_NO_RADIO_BUTTON = By.xpath("//*[@id=\"CANEC_GeneralAssistance_NO\"]");

    public static By CALL_CA_GENERALRELIF_YES_RADIO_BUTTON = By.xpath("//*[@id=\"CANEC_GeneralRelief_YES\"]");
    public static By CALL_CA_GENERALRELIF_NO_RADIO_BUTTON = By.xpath("//*[@id=\"CANEC_GeneralRelief_NO\"]");

    //CA UNEMPLOYMENT FULL TIME STUDENT

    public static By CALL_CA_UNEMPLOYED_YES_RADIO_BUTTON = By.xpath("//*[@id=\"CANEC_Unemployed_YES\"]");
    public static By CALL_CA_UNEMPLOYED_NO_RADIO_BUTTON = By.xpath("//*[@id=\"CANEC_Unemployed_NO\"]");



    public static By CALL_CA_SELF_EMPLOYED_YES_RADIO_BUTTON = By.xpath("//*[@id=\"CANEC_Self_Employed_6M_YES\"]");
    public static By CALL_CA_SELF_EMPLOYED_NO_RADIO_BUTTON = By.xpath("//*[@id=\"CANEC_Self_Employed_6M_NO\"]");

    public static By CALL_CA_FULL_TIME_STUDENT_YES_RADIO_BUTTON = By.xpath("//*[@id=\"CANEC_Full_Time_Student_6M_YES\"]");
    public static By CALL_CA_FULL_TIME_STUDENT_NO_RADIO_BUTTON = By.xpath("//*[@id=\"CANEC_Full_Time_Student_6M_NO\"]");

    public static By CALL_CA_DEGREE_12M_YES_RADIO_BUTTON = By.xpath("//*[@id=\"CANEC_Degree_12M_YES\"]");
    public static By CALL_CA_DEGREE_12M_NO_RADIO_BUTTON = By.xpath("//*[@id=\"CANEC_Degree_12M_NO\"]");

    //*[@id="question"]/div[2]/div[30]/input
    //*[@id="question"]/div[2]/div[37]/input


    //ADRESS
    public static By CALL_CA_ADDRESS_TEXTBOX = By.xpath("//*[@id=\"question\"]/div[2]/div[9]/input");
    public static By CALL_IN_INVALID_ADDRESS_LABEL =  By.xpath("//div[contains(text(),'address you have entered does not appear to be valid or cannot be matched')]");
    
    //hire

    public static By CALL_CA_WAGES_TEXTBOX = By.xpath("//*[@id=\"txtWage\"]");
    //select

    //IEC Page

    public static By CALL_IEC_Native_American_NO_RADIO_BUTTON = By.xpath("//*[@id=\"FED_IEC_Native_American_YES\"]");
    public static By CALL_CA_FED_IEC_NATIVE_RADIO_BUTTON = By.xpath("//*[@id=\"FED_IEC_Native_American_NO\"]");


    // food stamps

    public static By CALL_FOOD_STAMP_YES_RADIO_BUTTON = By.xpath("//input[@id='FoodStamps6_YES']");
    public static By CALL_FOOD_STAMP_NO_RADIO_BUTTON = By.xpath("//input[@id='FoodStamps6_NO']");

    // Veteran food stamps

    public static By CALL_VET_FOOD_STAMP_YES_RADIO_BUTTON = By.xpath("//input[@id='Veteran_Food_Stamps_YES']");
    public static By CALL_VET_FOOD_STAMP_NO_RADIO_BUTTON = By.xpath("//input[@id='Veteran_Food_Stamps_NO']");

    // Pennsylvania EIP

    public static By CALL_Pennsylvania_EIP_YES_RADIO_BUTTON = By.xpath("//*[@id='PA_TANF_FamilyMember_TANF_YES']");
    public static By CALL_Pennsylvania_EIP_NO_RADIO_BUTTON = By.xpath("//*[@id='PA_TANF_FamilyMember_TANF_NO']");

    //Hire Page
    public static By CALL_GAVE_INFO_DATE = By.xpath("//div[@class='question_title'][1]//span[2][text()='Gave Information Date']/ancestor::div[1]/following::input[1]");
    public static By CALL_JOB_OFFER_DATE = By.xpath("//div[@class='question_title'][1]//span[2][text()='Job Offer Date']/ancestor::div[1]/following::input[1]");
    public static By CALL_HIRE_DATE = By.xpath("//div[@class='question_title'][1]//span[2][text()='Employment Hire Date']/ancestor::div[1]/following::input[1]");
    public static By CALL_JOB_START_DATE = By.xpath("//div[@class='question_title'][1]//span[2][text()='Employment Start Date']/ancestor::div[1]/following::input[1]");

    public static By CALL_IN_JOB_TITLE = By.xpath("//*[@id=\"question\"]/div[2]/div[72]/div[4]/div/select");
    public static By CALL_STARTING_WAGES = By.xpath("//*[@id='txtWage']");
//Exit Button

public static By CALL_IN_SCREENING_COM_EXIT = By.xpath("//BUTTON[@adp-button='secondary']//span[@class='ng-binding ng-scope'][.='exit']");
}
