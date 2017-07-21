package adp.tcs.automation.pages;

import adp.tcs.automation.locators.ScreeningLocators;
import adp.tcs.automation.stepsfiles.BaseTempletSteps;
import org.openqa.selenium.WebElement;

/**
 * Created by Thorasa on 7/22/2016.
 */
public class ScreeningPages extends BaseTempletSteps {

    // Unit Page WebElemnt methods

    public WebElement unit_State_Dropdown(){
        WebElement element = getDriver().findElement(ScreeningLocators.unitState);
        return element;
    }

    public WebElement unit_City_Dropdown(){
        WebElement element = getDriver().findElement(ScreeningLocators.unitCity);
        return element;
    }

    public WebElement unit_Location_Dropdown(){
        WebElement element = getDriver().findElement(ScreeningLocators.unitLocation);
        return element;
    }

    public WebElement unit_Continue_Button(){
        WebElement element = getDriver().findElement(ScreeningLocators.unitContinueBtn);
        return element;
    }

    // Welcome Page WebElemnt methods

    public WebElement welcome_Continue_Button(){
        WebElement element = getDriver().findElement(ScreeningLocators.welcomeContinueBtn);
        return element;
    }

    // Personal Information Page WebElement Methods

    public WebElement personalInfo_SSN_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.socialSecurityNumber);
        return element;
    }

    public WebElement personalInfo_ConfirmSSN_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.confirmSocialSecurityNumber);
        return element;
    }

    public WebElement personalInfo_FirstName_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.firstName);
        return element;
    }

    public WebElement personalInfo_MiddleName_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.middleName);
        return element;
    }

    public WebElement personalInfo_LastName_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.lastName);
        return element;
    }

    public WebElement personalInfo_Telephone_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.telephone);
        return element;
    }

    public WebElement personalInfo_Email_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.emailAddress);
        return element;
    }

    public WebElement personalInfo_Continue_Button(){
        WebElement element = getDriver().findElement(ScreeningLocators.continueButton);
        return element;
    }

    // Age Verification Page WebElement Methods

    public WebElement ageVerification_Yes_Button(){
        WebElement element = getDriver().findElement(ScreeningLocators.ageVerificationYesButton);
        return element;
    }

    public WebElement ageVerification_No_Button(){
        WebElement element = getDriver().findElement(ScreeningLocators.ageVerificationNoButton);
        return element;
    }

    public WebElement ageVerification_DOB_TextBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.ageVerificationDOB);
        return element;
    }

    public WebElement ageVerification_Continue_Button(){
        WebElement element = getDriver().findElement(ScreeningLocators.ageVerificationContinueBtn);
        return element;
    }

    // Address Page WebElement Methods

    public WebElement address_StreetAddress_TextBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.homeStreetAddress);
        return element;
    }

    public WebElement address_City_TextBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.city);
        return element;
    }

    public WebElement address_State_Dropdown(){
        WebElement element = getDriver().findElement(ScreeningLocators.state);
        return element;
    }

    public WebElement address_Zip_TextBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.zipCode);
        return element;
    }

    public WebElement address_Continue_Button(){
        WebElement element = getDriver().findElement(ScreeningLocators.addressContinueBtn);
        return element;
    }
    
    public WebElement address_Invalid_Address_Note(){
        WebElement element = getDriver().findElement(ScreeningLocators.addressContinueBtn);
        return element;
    }

    // Previous Employement WebElement Methods

    public WebElement previousEmp_Yes_Button(){
        WebElement element = getDriver().findElement(ScreeningLocators.previousEmpYesBtn);
        return element;
    }

    public WebElement previousEmp_No_Button(){
        WebElement element = getDriver().findElement(ScreeningLocators.previousEmpNoBtn);
        return element;
    }

    // Conditional Certificate WebElement Methods

    public WebElement conditionalCert_Yes_Button(){
        WebElement element = getDriver().findElement(ScreeningLocators.conditionalCertYesBtn);
        return element;
    }

    public WebElement conditionalCert_No_Button(){
        WebElement element = getDriver().findElement(ScreeningLocators.conditionalCertNoBtn);
        return element;
    }

    // Military Service WebElement Methods

    public WebElement militaryService_ServedUSMilitary_Yes_Button(){
        WebElement element = getDriver().findElement(ScreeningLocators.servedUSMilitry_YesBtn);
        return element;
    }

    public WebElement militaryService_ServedUSMilitary_No_Button(){
        WebElement element = getDriver().findElement(ScreeningLocators.servedUSMilitry_NoBtn);
        return element;
    }

    public WebElement militaryService_VeternDisability_Yes_Button(){
        WebElement element = getDriver().findElement(ScreeningLocators.veternDisability_YesBtn);
        return element;
    }

    public WebElement militaryService_VeternDisability_No_Button(){
        WebElement element = getDriver().findElement(ScreeningLocators.veternDisability_NoBtn);
        return element;
    }

    public WebElement militaryService_VeternDischaredReleased_Yes_Button(){
        WebElement element = getDriver().findElement(ScreeningLocators.veternDischaredReleased_YesBtn);
        return element;
    }

    public WebElement militaryService_VeternDischaredReleased_No_Button(){
        WebElement element = getDriver().findElement(ScreeningLocators.veternDischaredReleased_NoBtn);
        return element;
    }

    public WebElement militaryService_VeternUnemployment4_Yes_Button(){
        WebElement element = getDriver().findElement(ScreeningLocators.veternUnemployment4_YesBtn);
        return element;
    }

    public WebElement militaryService_VeternUnemployment4_No_Button(){
        WebElement element = getDriver().findElement(ScreeningLocators.veternUnemployment4_NoBtn);
        return element;
    }

    public WebElement militaryService_branchOfService_Dropdown(){
        WebElement element = getDriver().findElement(ScreeningLocators.branchOfService);
        return element;
    }

    public WebElement militaryService_StateReceiveBenefits_Dropdown(){
        WebElement element = getDriver().findElement(ScreeningLocators.stateReceiveBenefits);
        return element;
    }

    public WebElement militaryService_militryContinueButton_Button(){
        WebElement element = getDriver().findElement(ScreeningLocators.militryContinueButton);
        return element;
    }

    public WebElement militaryService_VeternUnemployment6_Yes_Button(){
        WebElement element = getDriver().findElement(ScreeningLocators.veternUnemployment6_YesBtn);
        return element;
    }

    public WebElement militaryService_VeternUnemployment6_No_Button(){
        WebElement element = getDriver().findElement(ScreeningLocators.veternUnemployment6_NoBtn);
        return element;
    }

    // Vetern Food Stamps Web Elements

    public WebElement veternFoodStamps_VerternFoodStamps_Yes_Button(){
        WebElement element = getDriver().findElement(ScreeningLocators.veternFoodStamps_YesBtn);
        return element;
    }

    public WebElement veternFoodStamps_VerternFoodStamps_No_Button(){
        WebElement element = getDriver().findElement(ScreeningLocators.veternFoodStamps_NoBtn);
        return element;
    }

    public WebElement veternFoodStamps_BranchService_Dropdown(){
        WebElement element = getDriver().findElement(ScreeningLocators.veternFoodStampsBranchServiceDropdown);
        return element;
    }

    public WebElement veternFoodStamps_State_Dropdown(){
        WebElement element = getDriver().findElement(ScreeningLocators.veternFoodStampsStateDropdown);
        return element;
    }

    public WebElement veternFoodStamps_StartDate_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.veternFoodStampsStartDateTxtBox);
        return element;
    }

    public WebElement veternFoodStamps_EndDate_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.veternFoodStampsEndDateTxtBox);
        return element;
    }

    public WebElement veternFoodStamps_Recipient_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.veternFoodStampsRecipientTxtBox);
        return element;
    }

    public WebElement veternFoodStamps_Relation_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.veternFoodStampsRelationTxtBox);
        return element;
    }

    public WebElement veternFoodStamps_City_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.veternFoodStampsCityTxtBox);
        return element;
    }

    public WebElement veternFoodStamps_Notes_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.veternFoodStampsNotesTxtBox);
        return element;
    }

    public WebElement veternFoodStamps_Continue_Button(){
        WebElement element = getDriver().findElement(ScreeningLocators.veternFoodStampsContinueBtn);
        return element;
    }

    // Temporary Assistance Page Locators

    public WebElement tempAssistance_Que_A_YesButton(){
        WebElement element = getDriver().findElement(ScreeningLocators.tempAssistanceQue_A_YesBtn);
        return element;
    }

    public WebElement tempAssistance_Que_A_NoButton(){
        WebElement element = getDriver().findElement(ScreeningLocators.tempAssistanceQue_A_NoBtn);
        return element;
    }

    public WebElement tempAssistance_Que_B_YesButton(){
        WebElement element = getDriver().findElement(ScreeningLocators.tempAssistanceQue_B_YesBtn);
        return element;
    }

    public WebElement tempAssistance_Que_B_NoButton(){
        WebElement element = getDriver().findElement(ScreeningLocators.tempAssistanceQue_B_NoBtn);
        return element;
    }

    public WebElement tempAssistance_Que_C_YesButton(){
        WebElement element = getDriver().findElement(ScreeningLocators.tempAssistanceQue_C_YesBtn);
        return element;
    }

    public WebElement tempAssistance_Que_C_NoButton(){
        WebElement element = getDriver().findElement(ScreeningLocators.tempAssistanceQue_C_NoBtn);
        return element;
    }

    public WebElement tempAssistance_Relation_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.tempAssistanceRelationTxtBox);
        return element;
    }

    public WebElement tempAssistance_Recipient_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.tempAssistanceRecipientTxtBox);
        return element;
    }

    public WebElement tempAssistance_City_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.tempAssistanceCityTxtBox);
        return element;
    }

    public WebElement tempAssistance_State_Dropdown(){
        WebElement element = getDriver().findElement(ScreeningLocators.tempAssistanceStateDropdown);
        return element;
    }

    public WebElement tempAssistance_Continue_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.tempAssistanceContinueBtn);
        return element;
    }

    // Vocational Rehabilitation Web Elements

    public WebElement vocationalRehab_YesAgency_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.vocationalRehab_Que_YesAgency);
        return element;
    }

    public WebElement vocationalRehab_YesTW_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.vocationalRehab_Que_YesTW);
        return element;
    }

    public WebElement vocationalRehab_YesVA_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.vocationalRehab_Que_YesVA);
        return element;
    }

    public WebElement vocationalRehab_No_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.vocationalRehab_Que_No);
        return element;
    }

    // SSI Web Eelements

    public WebElement ssi_Yes_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.ssi_Yes_Btn);
        return element;
    }

    public WebElement ssi_No_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.ssi_No_Btn);
        return element;
    }

    // Food Stamps Web Elements

    public WebElement foodStamps_Yes_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.foodStamps_Yes_Btn);
        return element;
    }
    public WebElement foodStamps_No_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.foodStamps_No_Btn);
        return element;
    }

    public WebElement foodStamps_Relation_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.foodStampsRelationTxtBox);
        return element;
    }

    public WebElement foodStamps_Recipient_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.foodStampsRecipientTxtBox);
        return element;
    }

    public WebElement foodStamps_City_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.foodStampsCityTxtBox);
        return element;
    }

    public WebElement foodStamps_State_Dropdown(){
        WebElement element = getDriver().findElement(ScreeningLocators.foodStampsStateDropdown);
        return element;
    }

    public WebElement foodStamps_Continue_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.foodStampsContinueBtn);
        return element;
    }

    // Long Term Unemployed Web Elements

    public WebElement longTermUnemp_QueA_Yes_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.longTermUnemp_Yes_Btn);
        return element;
    }

    public WebElement longTermUnemp_QueA_No_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.longTermUnemp_No_Btn);
        return element;
    }

    public WebElement longTermUnemp_QueB_Yes_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.longTermUnemp_Benefit_Yes_Btn);
        return element;
    }

    public WebElement longTermUnemp_QueB_No_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.longTermUnemp_Benefit_No_Btn);
        return element;
    }

    public WebElement longTermUnemp_State_Dropdown(){
        WebElement element = getDriver().findElement(ScreeningLocators.longTermUnemp_State_Dropdown);
        return element;
    }
    
    public WebElement longTermUnemp_Benefit_Start_Date(){
        WebElement element = getDriver().findElement(ScreeningLocators.longTermUnemp_Benefit_Start_Date);
        return element;
    }

    public WebElement longTermUnemp_Continue_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.longTermUnemp_Continue_Btn);
        return element;
    }

    // WOTC eSign Pages Locators

    public WebElement eSign_acknowledge_CheckBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.eSign_acknowledge_CheckBox);
        return element;
    }
    public WebElement eSign_PIN_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.eSign_PIN_TxtBox);
        return element;
    }
    public WebElement eSign_Continue_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.eSign_Continue_Btn);
        return element;
    }
    public WebElement eSign_optout_CheckBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.eSign_optout_Checkbox);
        return element;
    }

    // IEC Pages Locators

    public WebElement IEC_FED_IEC_Native_American_YES_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.IEC_FED_IEC_Native_American_YES_TxtBox);
        return element;
    }
    public WebElement IEC_FED_IEC_Native_American_No_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.IEC_FED_IEC_Native_American_No_TxtBox);
        return element;
    }
    public WebElement IEC_NameOfTribe_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.IEC_NameOfTribe_TxtBox);
        return element;
    }

    public WebElement IEC_CityOfTribe_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.IEC_CityOfTribe_TxtBox);
        return element;
    }

    public WebElement IEC_StateOfTribe_dropdown(){
        WebElement element = getDriver().findElement(ScreeningLocators.IEC_StateOfTribe_dropdown);
        return element;
    }

    public WebElement IEC_DOB_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.IEC_DOB_TxtBox);
        return element;
    }

    public WebElement IEC_Maiden_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.IEC_Maiden_TxtBox);
        return element;
    }

    public WebElement IEC_Continue_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.IEC_Continue_Btn);
        return element;
    }

    // IEC SP Page Locators

    public WebElement IEC_SP_FED_Native_Spouse_YES_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.IEC_FED_Native_Spouse_YES_TxtBox);
        return element;
    }

    public WebElement IEC_SP_FED_Native_Spouse_No_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.IEC_FED_Native_Spouse_No_TxtBox);
        return element;
    }

    public WebElement IEC_SP_SpouseName_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.IEC_SP_SpouseName_TxtBox);
        return element;
    }

    public WebElement IEC_SP_SpouseSSN_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.IEC_SP_SpouseSSN_TxtBox);
        return element;
    }

    public WebElement IEC_SP_SpouseDOB_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.IEC_SP_SpouseDOB_TxtBox);
        return element;
    }

    public WebElement IEC_SP_SpouseMaidenName_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.IEC_SP_SpouseMaidenName_TxtBox);
        return element;
    }

    public WebElement IEC_SP_NameOfTribe_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.IEC_SP_NameOfTribe_TxtBox);
        return element;
    }

    public WebElement IEC_SP_CityOfTribe_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.IEC_SP_CityOfTribe_TxtBox);
        return element;
    }

    public WebElement IEC_SP_StateOfTribe_Dropdown(){
        WebElement element = getDriver().findElement(ScreeningLocators.IEC_SP_StateOfTribe_Dropdown);
        return element;
    }

    public WebElement IEC_SP_Continue_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.IEC_SP_Continue_Btn);
        return element;
    }

    // Screening Page Heading locators

    public WebElement unitPageTitle(){
        WebElement element = getDriver().findElement(ScreeningLocators.unitPageTitle);
        return element;
    }

    public WebElement screeningPageTitle(){
        WebElement element = getDriver().findElement(ScreeningLocators.screeningPageTitle);
        return element;
    }
    
    // File upload web elements
    
    public WebElement fileUpload_Continue_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.fileUpload_Continue_Btn);
        return element;
    }
    
    public WebElement fileUpload_Address_btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.ADDRESS_FILE_UPLOAD_BTN);
        return element;
    }
    
    public WebElement fileUpload_Address_SelectBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.ADDRESS_SELECT_BOX);
        return element;
    }
    
    // Confirmation Page web elements
    
    public WebElement confirmationPage_ConfirmationNumber_Text(){
        WebElement element = getDriver().findElement(ScreeningLocators.confirmationPage_ConfirmationNumber_Text);
        return element;
    }
    
    public WebElement screening_Completion_Text(){
        WebElement element = getDriver().findElement(ScreeningLocators.SCREENING_COMPLETION_MESSAGE);
        return element;
    }
    
    public WebElement done_Btn_On_Screening_Compeletion_Page(){
        WebElement element = getDriver().findElement(ScreeningLocators.DONE_BTN_SCREENING_COMPLETION_PAGE);
        return element;
    }
    
    public WebElement google_Search_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.GOOGLE_SEARCH_BUTTON);
        return element;
    }
    
    // Felony Page web elements
    
    public WebElement Felony_General_NO_BTN(){
        WebElement element = getDriver().findElement(ScreeningLocators.Felony_General_NO_BTN);
        return element;
    }
    
    public WebElement Felony_General_YES_BTN(){
        WebElement element = getDriver().findElement(ScreeningLocators.Felony_General_YES_BTN);
        return element;
    }

    // SSDI Page Web Elements
    public WebElement SSDI_NO_BTN(){
        WebElement element = getDriver().findElement(ScreeningLocators.SSDI_General_NO_BTN);
        return element;
    }

    public WebElement SSDI_YES_BTN(){
        WebElement element = getDriver().findElement(ScreeningLocators.SSDI_General_YES_BTN);
        return element;
    }

    //PHILADELPHIA Page Web ELEMENT
    public WebElement philadelphia_Que1_YES_BTN(){
        WebElement element = getDriver().findElement(ScreeningLocators.Phil_Veteran_QUE1_YES_BTN);
        return element;
    }

    public WebElement philadelphia_Que1_NO_BTN(){
        WebElement element = getDriver().findElement(ScreeningLocators.Phil_Veteran_QUE1_NO_BTN);
        return element;
    }

    public WebElement philadelphia_Que2_YES_BTN(){
        WebElement element = getDriver().findElement(ScreeningLocators.Phil_Veteran_QUE2_YES_BTN);
        return element;
    }

    public WebElement philadelphia_Que2_NO_BTN(){
        WebElement element = getDriver().findElement(ScreeningLocators.Phil_Veteran_QUE2_NO_BTN);
        return element;
    }

    public WebElement continue_Button_Loading(){
        WebElement element = getDriver().findElement(ScreeningLocators.CONTINUE_BUTTON_LOADING);
        return element;
    }

    // CA Militry Service Page Heading locators
    public WebElement CAMilitrary_QueA_Yes_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.CALL_CA_VETERAN_YES_RADIO_BUTTON);
        return element;
    }

    public WebElement CAMilitrary_QueA_NO_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.CALL_CA_VETERAN_NO_RADIO_BUTTON);
        return element;
    }
    public WebElement CAMilitrary_QueB_Yes_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.CALL_CA_VETERAN_12M_YES_RADIO_BUTTON);
        return element;
    }

    public WebElement CAMilitrary_QueB_NO_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.CALL_CA_VETERAN__12M_NO_RADIO_BUTTON);
        return element;
    }

  //Hire Info Web Elements
    
    public WebElement hire_Info_Gave_Info_Date(){
        WebElement element = getDriver().findElement(ScreeningLocators.HIRE_INFO_GAVE_INFO_DATE);
        element.clear();
        return element;
    }
    
    public WebElement hire_Info_Job_Offer_Date(){
        WebElement element = getDriver().findElement(ScreeningLocators.HIRE_INFO_JOB_OFFFER_DATE);
        element.clear();
        return element;
    }
    
    public WebElement hire_Info_Hire_Date(){
        WebElement element = getDriver().findElement(ScreeningLocators.HIRE_INFO_HIRE_DATE);
        element.clear();
        return element;
    }
    
    public WebElement hire_Info_Start_Date(){
        WebElement element = getDriver().findElement(ScreeningLocators.HIRE_INFO_START_DATE);
        element.clear();
        return element;
    }
    
    public WebElement hire_Info_Job_Position(){
        WebElement element = getDriver().findElement(ScreeningLocators.HIRE_INFO_JOB_POSITION);
        return element;
    }
    
    public WebElement hire_Info_Wage(){
        WebElement element = getDriver().findElement(ScreeningLocators.HIRE_INFO_WAGE);
        element.clear();
        return element;
    }
    
    public WebElement hire_Info_Wage_Type(){
        WebElement element = getDriver().findElement(ScreeningLocators.HIRE_INFO_WAGE_TYPE);
        return element;
    }
    
    public WebElement confirmModal_popUp_Yes_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.COFIRMMODEL_POPUP_YES_BUTTON);
        return element;
    }
    public WebElement confirmModal_popUp_NO_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.COFIRMMODEL_POPUP_NO_BUTTON);
        return element;
    }
    


    // CA Earned Income Credit Page Heading locators
    public WebElement CAEarnedIncome_Yes_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.CALL_CA_EIC_YES_RADIO_BUTTON);
        return element;
    }
    public WebElement CAEarnedIncome_NO_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.CALL_CA_EIC_NO_RADIO_BUTTON);
        return element;
    }

    //CA Felony Page Heading Locators
    public WebElement CAFelony_Que_Yes_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.CALL_CA_FELONY_YES_RADIO_BUTTON);
        return element;
    }
    public WebElement CAFelony_Que_No_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.CALL_CA_FELONY_NO_RADIO_BUTTON);
        return element;
    }

    //CA General Assistance Page Locators
    public WebElement CA_GA_CalWorksCash_Yes_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.CALL_CA_CALWORK_YES_RADIO_BUTTON);
        return element;
    }
    public WebElement CA_GA_CalWorksCash_No_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.CALL_CA_CALWORK_NO_RADIO_BUTTON);
        return element;
    }

    public WebElement CA_GeneralAssistance_Yes_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.CALL_CA_GENERALASSIS_YES_RADIO_BUTTON);
        return element;
    }
    public WebElement CA_GeneralAssistance_No_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.CALL_CA_GENERALASSIS_NO_RADIO_BUTTON);
        return element;
    }
    public WebElement CA_GeneralRelief_Yes_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.CALL_CA_GENERALRELIF_YES_RADIO_BUTTON);
        return element;
    }
    public WebElement CA_GeneralRelief_No_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.CALL_CA_GENERALRELIF_NO_RADIO_BUTTON);
        return element;
    }

    //CA Unemployed full time student Page Locators
    public WebElement CA_Unemployed6Month_Yes_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.CALL_CA_UNEMPLOYED_YES_RADIO_BUTTON);
        return element;
    }
    public WebElement CA_Unemployed6Month_No_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.CALL_CA_UNEMPLOYED_NO_RADIO_BUTTON);
        return element;
    }
    public WebElement CA_Selfemployed_Yes_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.CALL_CA_SELF_EMPLOYED_YES_RADIO_BUTTON);
        return element;
    }
    public WebElement CA_Selfemployed_No_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.CALL_CA_SELF_EMPLOYED_NO_RADIO_BUTTON);
        return element;
    }
    public WebElement CA_FullTimeStudent_Yes_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.CALL_CA_FULL_TIME_STUDENT_YES_RADIO_BUTTON);
        return element;
    }
    public WebElement CA_FullTimeStudent_No_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.CALL_CA_FULL_TIME_STUDENT_NO_RADIO_BUTTON);
        return element;
    }
    public WebElement CA_BachelorsDegree12Mon_Yes_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.CALL_CA_DEGREE_12M_YES_RADIO_BUTTON);
        return element;
    }
    public WebElement CA_BachelorsDegree12Mon_No_Btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.CALL_CA_DEGREE_12M_NO_RADIO_BUTTON);
        return element;
    }
    // military service SF page
    public WebElement militaryService_SF_ActiveComp_Dropdown(){
        WebElement element = getDriver().findElement(ScreeningLocators.MILITARY_SERVICE_SF_ACTIVE_COMPONENT);
        return element;
    }
    public WebElement militaryService_SF_ReserveComp_Dropdown(){
        WebElement element = getDriver().findElement(ScreeningLocators.MILITARY_SERVICE_SF_RESERVE_COMPONENT);
        return element;
    }
    public WebElement militaryService_SF_NationalGuard_Dropdown(){
        WebElement element = getDriver().findElement(ScreeningLocators.MILITARY_SERVICE_SF_NATIONAL_GUARD);
        return element;
    }

    //Colorado WP Page
    public WebElement CO_Family_Receiving_TANF_Yes_btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.CO_FAMILY_RECEIVING_TANF_YES_BTN);
        return element;
    }
    
  
    public WebElement CO_Family_Receiving_TANF_NO_btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.CO_FAMILY_RECEIVING_TANF_NO_BTN);
        return element;
    }
    public WebElement CO_TANF_Primary_Receipient_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.CO_TANF_PRIMARY_RECEIPIENT);
        return element;
    }

    public WebElement CO_TANF_Primary_Receipient_City_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.CO_TANF_RECEIPIENT_CITY);
        return element;
    }

    public WebElement CO_TANF_Primary_Receipient_State_Dropdown(){
        WebElement element = getDriver().findElement(ScreeningLocators.CO_TANF_RECEIPIENT_STATE);
        return element;
    }

    //UT Military Service Page
    public WebElement UTVetranYesBtn(){
        WebElement element = getDriver().findElement(ScreeningLocators.UT_VETERAN_YES_BTN);
        return element;
    }
    public WebElement UTVetranNoBtn(){
        WebElement element = getDriver().findElement(ScreeningLocators.UT_VETERAN_NO_BTN);
        return element;
    }    
    public WebElement UTVetranDischargedYesBtn(){
        WebElement element = getDriver().findElement(ScreeningLocators.UT_VETERAN_DISCHARGED_YES_BTN);
        return element;
    }
    public WebElement UTVetranDischargedNoBtn(){
        WebElement element = getDriver().findElement(ScreeningLocators.UT_VETERAN_DISCHARGED_NO_BTN);
        return element;
    }
    public WebElement UTVetranUnEmplYesBtn(){
        WebElement element = getDriver().findElement(ScreeningLocators.UT_VETERAN_UNEMPLOYED_YES_BTN);
        return element;
    }
    public WebElement UTVetranUnEmplNoBtn(){
        WebElement element = getDriver().findElement(ScreeningLocators.UT_VETERAN_UNEMPLOYED_NO_BTN);
        return element;
    }
    

  //South Carolina FIP Page
    public WebElement SCFIP_Family_Receiving_TANF_Yes_btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.SC_FAMILY_RECEIVING_TANF_YES_BTN);
        return element;
    }
    
    public WebElement SCFIP_County_Name_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.SCFIP_COUNTY_NAME);
        return element;
    }
    
    public WebElement SCFIP_Family_Receiving_TANF_No_btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.SC_FAMILY_RECEIVING_TANF_NO_BTN);
        return element;
    }
    
  // Arizona TANF Page
    public WebElement AZ_Family_Receiving_TANF_Yes_btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.AZ_FAMILY_RECEIVING_TANF_YES_BTN);
        return element;
    }
    
  
    public WebElement AZ_Family_Receiving_TANF_NO_btn(){
        WebElement element = getDriver().findElement(ScreeningLocators.AZ_FAMILY_RECEIVING_TANF_NO_BTN);
        return element;
    }
    public WebElement AZ_TANF_Primary_Receipient_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.AZ_TANF_PRIMARY_RECEIPIENT);
        return element;
    }

    public WebElement AZ_TANF_Primary_Receipient_City_TxtBox(){
        WebElement element = getDriver().findElement(ScreeningLocators.AZ_TANF_RECEIPIENT_CITY);
        return element;
    }

    public WebElement AZ_TANF_Primary_Receipient_State_Dropdown(){
        WebElement element = getDriver().findElement(ScreeningLocators.AZ_TANF_RECEIPIENT_STATE);
        return element;
    }
    
  //AK Military Service Page
    public WebElement AK_AKVETC_VETERAN_YES_BTN(){
        WebElement element = getDriver().findElement(ScreeningLocators.AK_AKVETC_VETERAN_YES_BTN);
        return element;
    }
    
    public WebElement AK_AKVETC_VETERAN_NO_BTN(){
        WebElement element = getDriver().findElement(ScreeningLocators.AK_AKVETC_VETERAN_NO_BTN);
        return element;
    }

    public WebElement AK_AKVETC_VETERAN_DISCHARGED_YES_BTN(){
        WebElement element = getDriver().findElement(ScreeningLocators.AK_AKVETC_VETERAN_DISCHARGED_YES_BTN);
        return element;
    }
    
    public WebElement AK_AKVETC_VETERAN_DISCHARGED_NO_BTN(){
        WebElement element = getDriver().findElement(ScreeningLocators.AK_AKVETC_VETERAN_DISCHARGED_NO_BTN);
        return element;
    }
    
    public WebElement AK_AKVETC_VETERAN_UNEMPL_4W_YES_BTN(){
        WebElement element = getDriver().findElement(ScreeningLocators.AK_AKVETC_VETERAN_UNEMPL_4W_YES_BTN);
        return element;
    }
    
    public WebElement AK_AKVETC_VETERAN_UNEMPL_4W_NO_BTN(){
        WebElement element = getDriver().findElement(ScreeningLocators.AK_AKVETC_VETERAN_UNEMPL_4W_NO_BTN);
        return element;
    }
    
    public WebElement AK_AKVETC_VETERAN_COMPENSATION_YES_BTN(){
        WebElement element = getDriver().findElement(ScreeningLocators.AK_AKVETC_VETERAN_COMPENSATION_YES_BTN);
        return element;
    }
    
    public WebElement AK_AKVETC_VETERAN_COMPENSATION_NO_BTN(){
        WebElement element = getDriver().findElement(ScreeningLocators.AK_AKVETC_VETERAN_COMPENSATION_NO_BTN);
        return element;
    }
    
    public WebElement AK_AKVETC_VETERAN_DISABILITY_YES_BTN(){
        WebElement element = getDriver().findElement(ScreeningLocators.AK_AKVETC_VETERAN_DISABILITY_YES_BTN);
        return element;
    }
    
    public WebElement AK_AKVETC_VETERAN_DISABILITY_NO_BTN(){
        WebElement element = getDriver().findElement(ScreeningLocators.AK_AKVETC_VETERAN_DISABILITY_NO_BTN);
        return element;
    }
    
    public WebElement AK_AKVETC_VETERAN_DISABILITY_DUTY_YES_BTN(){
        WebElement element = getDriver().findElement(ScreeningLocators.AK_AKVETC_VETERAN_DISABILITY_DUTY_YES_BTN);
        return element;
    }
    
    public WebElement AK_AKVETC_VETERAN_DISABILITY_DUTY_NO_BTN(){
        WebElement element = getDriver().findElement(ScreeningLocators.AK_AKVETC_VETERAN_DISABILITY_DUTY_NO_BTN);
        return element;
    }
}
