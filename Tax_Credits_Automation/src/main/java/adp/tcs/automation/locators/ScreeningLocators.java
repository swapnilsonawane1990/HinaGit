package adp.tcs.automation.locators;

import org.openqa.selenium.By;

/**
 * Created by Thorasa on 7/22/2016.
 */
public class ScreeningLocators {

    // Unit Page Locators
    public static final By unitState = By.xpath("//div[@class='question required' and contains(.,'State')]/select");
    public static final By unitCity = By.xpath("//div[@class='question required' and contains(.,'City')]/select");
    public static final By unitLocation = By.xpath("//div[@class='question required' and contains(.,'Location')]/select");
    public static final By unitContinueBtn = By.xpath("//*[@id='btnUnitContinue']");

    // Welcome Page Locators
    public static final By welcomeContinueBtn = By.xpath("//BUTTON[@id='continuebutton']");

    // Personal Information Page Locators
    public static final By socialSecurityNumber = By.xpath("(//INPUT[@type='text'])[1]");
    public static final By confirmSocialSecurityNumber = By.xpath("(//INPUT[@type='text'])[2]");
    public static final By firstName = By.xpath("//*[@id='question']/div[2]/div[16]/input");
    public static final By middleName = By.xpath("//*[@id='question']/div[2]/div[23]/input");
    public static final By lastName = By.xpath("//*[@id='question']/div[2]/div[30]/input");
    public static final By telephone = By.xpath("//*[@id='question']/div[2]/div[37]/input");
    public static final By emailAddress = By.xpath("//*[@id='question']/div[2]/div[44]/input");
    public static final By continueButton = By.xpath("//*[@id='continuebutton']");

    // Age Verification Page Locators
    public static final By ageVerificationYesButton = By.xpath("//INPUT[@id='AgeCheck_YES']");
    public static final By ageVerificationNoButton = By.xpath("//INPUT[@id='AgeCheck_NO']");
    public static final By ageVerificationDOB = By.xpath("//*[@id='question']/div[2]/div[9]/input[1]");
    public static final By ageVerificationContinueBtn = By.xpath("//*[@id='continuebutton']");

    // Address Page Locators
    public static final By homeStreetAddress = By.xpath("(//INPUT[@type='text'])[1]");
    public static final By city = By.xpath("(//INPUT[@type='text'])[2]");
    public static final By state = By.xpath("//*[@id='question']/div[2]/div[16]/div[4]/div/select");
    public static final By zipCode = By.xpath("(//INPUT[@type='text'])[3]");
    public static final By addressContinueBtn = By.xpath("//*[@id='continuebutton']");
    public static final By invalidAddressNote = By.xpath("//div[@class='alert-box secondary']//div[contains(text(),'The address you have entered does not appear to be valid')]");
    
    // Previous Employement Locactors
    public static final By previousEmpYesBtn = By.xpath("//*[@id='PreviousEmployed_YES']");
    public static final By previousEmpNoBtn = By.xpath("//*[@id='PreviousEmployed_NO']");

    // Conditional Certificate page Locactors
    public static final By conditionalCertYesBtn = By.xpath("//*[@id='CCWOTC_YES']");
    public static final By conditionalCertNoBtn = By.xpath("//*[@id='CCWOTC_NO']");

    // Military Service page Locactors
    public static final By servedUSMilitry_YesBtn = By.xpath("//INPUT[@id='Veteran_YES']");
    public static final By servedUSMilitry_NoBtn = By.xpath("//INPUT[@id='Veteran_NO']");
    public static final By veternDisability_YesBtn = By.xpath("//*[@id='Veteran_Disability_YES']");
    public static final By veternDisability_NoBtn = By.xpath("//*[@id='Veteran_Disability_NO']");
    public static final By veternDischaredReleased_YesBtn = By.xpath("//*[@id='Veteran_Discharged_Released_YES']");
    public static final By veternDischaredReleased_NoBtn = By.xpath("//*[@id='Veteran_Discharged_Released_NO']");
    public static final By veternUnemployment4_YesBtn = By.xpath("//*[@id='Veteran_Unemployment4_YES']");
    public static final By veternUnemployment4_NoBtn = By.xpath("//*[@id='Veteran_Unemployment4_NO']");
    public static final By branchOfService = By.xpath("(//SELECT[@tabindex=''])[1]");
    public static final By stateReceiveBenefits = By.xpath("(//SELECT[@tabindex=''])[2]");
    public static final By militryContinueButton = By.xpath("//*[@id='continuebutton']");
    public static final By veternUnemployment6_YesBtn = By.xpath("//*[@id='Veteran_Unemployment6_YES']");
    public static final By veternUnemployment6_NoBtn = By.xpath("//*[@id='Veteran_Unemployment6_NO']");


    // Vetern Food Stamps Page Locators

    public static final By veternFoodStamps_YesBtn = By.xpath("//*[@id='Veteran_Food_Stamps_YES']");
    public static final By veternFoodStamps_NoBtn = By.xpath("//*[@id='Veteran_Food_Stamps_NO']");
    public static final By veternFoodStampsBranchServiceDropdown = By.xpath("(//SELECT[@tabindex=''])[1]");
    public static final By veternFoodStampsStateDropdown = By.xpath("(//SELECT[@tabindex=''])[2]");
    public static final By veternFoodStampsStartDateTxtBox = By.xpath("(//INPUT[@type='text'])[1]");
    public static final By veternFoodStampsEndDateTxtBox = By.xpath("(//INPUT[@type='text'])[2]");
    public static final By veternFoodStampsRecipientTxtBox = By.xpath("(//INPUT[@type='text'])[3]");
    public static final By veternFoodStampsRelationTxtBox = By.xpath("(//INPUT[@type='text'])[4]");
    public static final By veternFoodStampsCityTxtBox = By.xpath("(//INPUT[@type='text'])[5]");
    public static final By veternFoodStampsNotesTxtBox = By.xpath("(//INPUT[@type='text'])[6]");
    public static final By veternFoodStampsContinueBtn = By.xpath("//*[@id='continuebutton']");

    // Temporary Assistance Page Locators

    public static final By tempAssistanceQue_A_YesBtn = By.xpath("//*[@id='TANF_WOTC2Years_YES']");
    public static final By tempAssistanceQue_A_NoBtn = By.xpath("//*[@id='TANF_WOTC2Years_NO']");
    public static final By tempAssistanceQue_B_YesBtn = By.xpath("//*[@id='TANF_WOTCNotEligible_YES']");
    public static final By tempAssistanceQue_B_NoBtn = By.xpath("//*[@id='TANF_WOTCNotEligible_NO']");
    public static final By tempAssistanceQue_C_YesBtn = By.xpath("//*[@id='TANF_WOTCAsst18M_YES']");
    public static final By tempAssistanceQue_C_NoBtn = By.xpath("//*[@id='TANF_WOTCAsst18M_NO']");
    public static final By tempAssistanceRelationTxtBox = By.xpath("(//INPUT[@type='text'])[1]");
    public static final By tempAssistanceRecipientTxtBox = By.xpath("(//INPUT[@type='text'])[2]");
    public static final By tempAssistanceCityTxtBox = By.xpath("(//INPUT[@type='text'])[3]");
    public static final By tempAssistanceStateDropdown = By.xpath("(//SELECT[@tabindex=''])[1]");
    public static final By tempAssistanceContinueBtn = By.xpath("//*[@id='continuebutton']");

    // Vocational Rehabilitation Page Locators

    public static final By vocationalRehab_Que_YesAgency = By.xpath("//*[@id='VocationalRehab_VocRehab_YESSA']");
    public static final By vocationalRehab_Que_YesTW = By.xpath("//*[@id='VocationalRehab_VocRehab_YESTW']");
    public static final By vocationalRehab_Que_YesVA= By.xpath("//*[@id='VocationalRehab_VocRehab_YESVA']");
    public static final By vocationalRehab_Que_No = By.xpath("//*[@id='VocationalRehab_VocRehab_NO']");

    // Supplemental Security Income

    public static final By ssi_Yes_Btn = By.xpath("//*[@id='SSI_YES']");
    public static final By ssi_No_Btn = By.xpath("//*[@id='SSI_NO']");

    //Food Stamps Page Locators

    public static final By foodStamps_Yes_Btn = By.xpath("//*[@id='FoodStamps6_YES']");
    public static final By foodStamps_No_Btn = By.xpath("//*[@id='FoodStamps6_NO']");
    public static final By foodStampsRelationTxtBox = By.xpath("(//INPUT[@type='text'])[2]");
    public static final By foodStampsRecipientTxtBox = By.xpath("(//INPUT[@type='text'])[1]");
    public static final By foodStampsCityTxtBox = By.xpath("(//INPUT[@type='text'])[3]");
    public static final By foodStampsStateDropdown = By.xpath("(//SELECT[@tabindex=''])[1]");
    public static final By foodStampsContinueBtn = By.xpath("//*[@id='continuebutton']");

    // Long Term Unemployed Page Locators

    public static final By longTermUnemp_Yes_Btn = By.xpath("//*[@id='LongTermUnemployed_Period_YES']");
    public static final By longTermUnemp_No_Btn = By.xpath("//*[@id='LongTermUnemployed_Period_NO']");
    public static final By longTermUnemp_Benefit_Yes_Btn = By.xpath("//*[@id='LongTermUnemployed_Benefit_YES']");
    public static final By longTermUnemp_Benefit_No_Btn = By.xpath("//*[@id='LongTermUnemployed_Benefit_NO']");
    public static final By longTermUnemp_Benefit_Start_Date = By.xpath("//*[@id='question']/div[2]/div[16]/input[1]");
    public static final By longTermUnemp_State_Dropdown = By.xpath("(//SELECT[@tabindex=''])[1]");
    public static final By longTermUnemp_Continue_Btn = By.xpath("//*[@id='continuebutton']");

    // WOTC esign Page Locators

    public static final By eSign_acknowledge_CheckBox = By.xpath("//*[@id='read_checkbox']/input");
    public static final By eSign_PIN_TxtBox = By.xpath("//*[@id='pin_number']/input");
    public static final By eSign_Continue_Btn = By.xpath("//*[@id='option1']/button");
    public static final By eSign_optout_Checkbox = By.xpath("//*[@id=\"e-sign-optout\"]/input");

    // IEC Page Locators

    public static final By IEC_FED_IEC_Native_American_YES_TxtBox = By.xpath("//*[@id='FED_IEC_Native_American_YES']");
    public static final By IEC_FED_IEC_Native_American_No_TxtBox = By.xpath("//*[@id='FED_IEC_Native_American_NO']");
    public static final By IEC_NameOfTribe_TxtBox = By.xpath("(//INPUT[@type='text'])[1]");
    public static final By IEC_CityOfTribe_TxtBox = By.xpath("(//INPUT[@type='text'])[2]");
    public static final By IEC_StateOfTribe_dropdown = By.xpath("(//SELECT[@tabindex=''])[1]");
    public static final By IEC_DOB_TxtBox = By.xpath("(//INPUT[@type='text'])[3]");
    public static final By IEC_Maiden_TxtBox = By.xpath("(//INPUT[@type='text'])[4]");
    public static final By IEC_Continue_Btn = By.xpath("//*[@id='continuebutton']");

    // IEC_SP Page Locators

    public static final By IEC_FED_Native_Spouse_YES_TxtBox = By.xpath("//INPUT[@id='FED_IEC_Native_Spouse_YES']");
    public static final By IEC_FED_Native_Spouse_No_TxtBox = By.xpath("//INPUT[@id='FED_IEC_Native_Spouse_NO']");
    public static final By IEC_SP_SpouseName_TxtBox = By.xpath("(//INPUT[@type='text'])[1]");
    public static final By IEC_SP_SpouseSSN_TxtBox = By.xpath("(//INPUT[@type='text'])[2]");
    public static final By IEC_SP_SpouseDOB_TxtBox = By.xpath("(//INPUT[@type='text'])[3]");
    public static final By IEC_SP_SpouseMaidenName_TxtBox = By.xpath("(//INPUT[@type='text'])[4]");
    public static final By IEC_SP_NameOfTribe_TxtBox = By.xpath("(//INPUT[@type='text'])[5]");
    public static final By IEC_SP_CityOfTribe_TxtBox = By.xpath("(//INPUT[@type='text'])[6]");
    public static final By IEC_SP_StateOfTribe_Dropdown = By.xpath("(//SELECT[@tabindex=''])[1]");
    public static final By IEC_SP_Continue_Btn = By.xpath("//*[@id='continuebutton']");

    // CA Military Service Page Locators
    public static final By CA_ServedMilitary_Yes_Btn = By.xpath("//*[@id='CANEC_Veteran_YES']");
    public static final By CA_ServedMilitary_No_Btn = By.xpath("//*[@id='CANEC_Veteran_NO']");
    public static final By CA_SeperatedfromArmed_Yes_Btn = By.xpath("//*[@id='CANEC_Veteran_12m_YES']");
    public static final By CA_SeperatedfromArmed_No_Btn = By.xpath("//*[@id='CANEC_Veteran_12m_NO']");
    public static final By CA_BranchOfService_dropdown = By.xpath("(//SELECT[@tabindex=''])[1]");


    // Screening Pages common Heading locator
    public static final By screeningPageTitle = By.xpath("//*[@id='questions']/h2");
    public static final By unitPageTitle = By.xpath("//*[@id='wss-statement']/h3");
    
    // File upload Page Locators
    
    public static final By fileUpload_Continue_Btn = By.xpath("//*[@id='continuebutton']");
    public static final By 	ADDRESS_FILE_UPLOAD_BTN = By.xpath("//div[@class='row fileUploadRow']//span[text()='Proof of Address']/ancestor::div[1]/following::a[1]/input");
    public static final By 	ADDRESS_SELECT_BOX = By.xpath("//div[@class='row fileUploadRow']//span[text()='Proof of Address']/ancestor::div[1]/following::select[1]");
    
    // Confirmation Number Page Locator    
    public static final By confirmationPage_ConfirmationNumber_Text = By.xpath("//*[@id='question']/div[2]/div[9]/div[1]/span[2]");
    public static final By SCREENING_COMPLETION_MESSAGE = By.xpath("//*[@id='question']//span[2]");
    public static final By DONE_BTN_SCREENING_COMPLETION_PAGE = By.xpath("//div[@class='question']/button[contains(text(),'Continue') or contains(text(),'Done')]");
    public static final By GOOGLE_SEARCH_BUTTON = By.xpath("//input[@name='btnK']");
    
    // Felony Page Locators
    
    public static final By Felony_General_NO_BTN = By.xpath("//INPUT[@id='Felony_General_NO']");
    public static final By Felony_General_YES_BTN = By.xpath("//INPUT[@id='Felony_General_YES']");

    //SSDI Page Locators
    public static final By SSDI_General_NO_BTN = By.xpath("//INPUT[@id='SSDInsurance_NO']");
    public static final By SSDI_General_YES_BTN = By.xpath("//INPUT[@id='SSDInsurance_YES']");

    //PHIL Veteran Locators

    public static final By Phil_Veteran_QUE1_NO_BTN = By.xpath("//INPUT[@id='Phil_Veteran_NO']");
    public static final By Phil_Veteran_QUE1_YES_BTN = By.xpath("//INPUT[@id='Phil_Veteran_YES']");
    public static final By Phil_Veteran_QUE2_NO_BTN = By.xpath("//INPUT[@id='Phil_Discharged_NO']");
    public static final By Phil_Veteran_QUE2_YES_BTN = By.xpath("//INPUT[@id='Phil_Discharged_YES']");

    //continue button while loading page

    public static final By CONTINUE_BUTTON_LOADING = By.xpath("//DIV[@id='total_cover']");
    
    // Hire Infomation page
    
    public static final By HIRE_INFO_GAVE_INFO_DATE = By.xpath("//*[@id='question']//div[2]/input");
    public static final By HIRE_INFO_JOB_OFFFER_DATE = By.xpath("//*[@id='question']//div[9]/input");
    public static final By HIRE_INFO_HIRE_DATE = By.xpath("//*[@id='question']//div[16]/input");
    public static final By HIRE_INFO_START_DATE = By.xpath("//*[@id='question']//div[23]/input");
    public static final By HIRE_INFO_JOB_POSITION = By.xpath("//*[@id='question']//div[30]//select");
    public static final By HIRE_INFO_WAGE = By.xpath("//input[@id='txtWage']");
    public static final By HIRE_INFO_WAGE_TYPE = By.xpath("//*[@id='wage-frequencies']/select");
    public static final By HIRE_INFO_Continue_Btn = By.xpath("//*[@id='continuebutton']");
    public static final By COFIRMMODEL_POPUP_YES_BUTTON = By.xpath("//*[@id='confirm_modal_yes']");
    public static final By COFIRMMODEL_POPUP_NO_BUTTON = By.xpath("//*[@id='confirm_modal_no']");
    public static final By QUESTION_DISPLAYED = By.xpath("//div[@class='question']/div[@class='question_title']");

    //CA Veteran Page

    public static By CALL_CA_VETERAN_YES_RADIO_BUTTON = By.xpath("//*[@id=\"CANEC_Veteran_YES\"]");
    public static By CALL_CA_VETERAN_NO_RADIO_BUTTON = By.xpath("//*[@id=\"CANEC_Veteran_NO\"]");

    public static By CALL_CA_VETERAN_12M_YES_RADIO_BUTTON = By.xpath("//*[@id=\"CANEC_Veteran_12m_YES\"]");
    public static By CALL_CA_VETERAN__12M_NO_RADIO_BUTTON = By.xpath("//*[@id=\"CANEC_Veteran_12m_NO\"]");

    //CA Earn Income Page
    public static By CALL_CA_EIC_YES_RADIO_BUTTON = By.xpath("//*[@id=\"CANEC_EIC_YES\"]");
    public static By CALL_CA_EIC_NO_RADIO_BUTTON = By.xpath("//*[@id=\"CANEC_EIC_NO\"]");
    //IF YES CONTINUE BUTTON ELSE NO.

    //*[@id="question"]/div[2]/div[9]/input

    //CA Felony

    public static By CALL_CA_FELONY_YES_RADIO_BUTTON = By.xpath("//*[@id=\"CANEC_Felony_YES\"]");
    public static By CALL_CA_FELONY_NO_RADIO_BUTTON = By.xpath("//*[@id=\"CANEC_Felony_NO\"]");

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

    //CA Military Service SF Page locators
    public static By MILITARY_SERVICE_SF_ACTIVE_COMPONENT = By.xpath("//*[@id=\"question\"]/div[2]/div[37]/div[4]/div/select");
    public static By MILITARY_SERVICE_SF_RESERVE_COMPONENT =By.xpath("//*[@id=\"question\"]/div[2]/div[79]/div[4]/div/select");
    public static By MILITARY_SERVICE_SF_NATIONAL_GUARD = By.xpath("//*[@id=\"question\"]/div[2]/div[121]/div[4]/div/select");

    //Colorado WP
    public static By CO_FAMILY_RECEIVING_TANF_YES_BTN =By.xpath("//*[@id=\"COWP_TANF_YES\"]");
    public static By CO_FAMILY_RECEIVING_TANF_NO_BTN =By.xpath("//*[@id=\"COWP_TANF_NO\"]");
    public static By CO_TANF_PRIMARY_RECEIPIENT = By.xpath("//div[@class='question_title'][1]//span[2][text()='Name of primary recipient']/ancestor::div[1]/following::input[1]");
    public static By CO_TANF_RECEIPIENT_STATE = By.xpath("//div[@class='question_title'][1]//span[2][text()='State']/../following-sibling::div[@class='row']//select");
    public static By CO_TANF_RECEIPIENT_CITY = By.xpath("//div[@class='question_title'][1]//span[2][text()='City']/ancestor::div[1]/following::input[1]");
    
    //UT Military Service Locators
    public static By UT_VETERAN_YES_BTN =By.xpath("//input[@id='UT_Veteran_YES']");
    public static By UT_VETERAN_NO_BTN =By.xpath("//input[@id='UT_Veteran_NO']");
    
    public static By UT_VETERAN_DISCHARGED_YES_BTN =By.xpath("//input[@id='UT_Veteran_Discharged_YES']");
    public static By UT_VETERAN_DISCHARGED_NO_BTN =By.xpath("//input[@id='UT_Veteran_Discharged_NO']");
    
    public static By UT_VETERAN_UNEMPLOYED_YES_BTN =By.xpath("//input[@id='UT_Veteran_Unemployed_YES']");
    public static By UT_VETERAN_UNEMPLOYED_NO_BTN =By.xpath("//input[@id='UT_Veteran_Unemployed_NO']");

  //South Carolina FIP Page
    public static By SC_FAMILY_RECEIVING_TANF_YES_BTN =By.xpath("//*[@id='SC_FIP_TANF_SouthCarolina_YES']");
    public static By SC_FAMILY_RECEIVING_TANF_NO_BTN =By.xpath("//*[@id='SC_FIP_TANF_SouthCarolina_NO']");
    public static By SCFIP_COUNTY_NAME =By.xpath("//div[@class='question_title'][1]//span[2][text()='County in which you live']/ancestor::div[1]/following::input[1]");
    
  //ARIZONA TANF Page
    public static By AZ_FAMILY_RECEIVING_TANF_YES_BTN =By.xpath("//*[@id='AZ_TANF_FamilyMember_TANF_YES']");
    public static By AZ_FAMILY_RECEIVING_TANF_NO_BTN =By.xpath("//*[@id='AZ_TANF_FamilyMember_TANF_NO']");
    public static By AZ_TANF_PRIMARY_RECEIPIENT = By.xpath("//div[@class='question_title'][1]//span[2][text()='Name of primary recipient']/ancestor::div[1]/following::input[1]");
    public static By AZ_TANF_RECEIPIENT_STATE = By.xpath("//div[@class='question_title'][1]//span[2][text()='State']/../following-sibling::div[@class='row']//select");
    public static By AZ_TANF_RECEIPIENT_CITY = By.xpath("//div[@class='question_title'][1]//span[2][text()='City']/ancestor::div[1]/following::input[1]");
    
    //AK Military Service
    
    public static By AK_AKVETC_VETERAN_YES_BTN =By.xpath("//label[@for='AKVETC_Veteran_YES']/input");
    public static By AK_AKVETC_VETERAN_NO_BTN =By.xpath("//label[@for='AKVETC_Veteran_NO']/input");
    
    public static By AK_AKVETC_VETERAN_DISCHARGED_YES_BTN =By.xpath("//label[@for='AKVETC_Veteran_discharged_YES']/input");
    public static By AK_AKVETC_VETERAN_DISCHARGED_NO_BTN =By.xpath("//label[@for='AKVETC_Veteran_discharged_NO']/input");

    public static By AK_AKVETC_VETERAN_UNEMPL_4W_YES_BTN =By.xpath("//label[@for='AKVETC_Veteran_unemployed_4W_YES']/input");
    public static By AK_AKVETC_VETERAN_UNEMPL_4W_NO_BTN =By.xpath("//label[@for='AKVETC_Veteran_unemployed_4W_NO']/input");
    
    public static By AK_AKVETC_VETERAN_COMPENSATION_YES_BTN =By.xpath("//label[@for='AKVETC_Veteran_compensation_YES']/input");
    public static By AK_AKVETC_VETERAN_COMPENSATION_NO_BTN =By.xpath("//label[@for='AKVETC_Veteran_compensation_NO']/input");
    
    public static By AK_AKVETC_VETERAN_DISABILITY_YES_BTN =By.xpath("//label[@for='AKVETC_Veteran_disability_YES']/input");
    public static By AK_AKVETC_VETERAN_DISABILITY_NO_BTN =By.xpath("//label[@for='AKVETC_Veteran_disability_NO']/input");
    
    public static By AK_AKVETC_VETERAN_DISABILITY_DUTY_YES_BTN =By.xpath("//label[@for='AKVETC_Veteran_disabled_duty_YES']/input");
    public static By AK_AKVETC_VETERAN_DISABILITY_DUTY_NO_BTN =By.xpath("//label[@for='AKVETC_Veteran_disabled_duty_NO']/input");
}
