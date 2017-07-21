package adp.tcs.automation.pages;

import org.openqa.selenium.WebElement;

import adp.tcs.automation.locators.ManualKeyLocators;
import adp.tcs.automation.locators.ScreeningLocators;
import adp.tcs.automation.stepsfiles.BaseTempletSteps;

/**
 * Created by Thorasa on 10/04/2016.
 */
public class ManualKeyPages extends BaseTempletSteps{

	public WebElement manulKeyLinkOnDataEntry(){
        WebElement element = getDriver().findElement(ManualKeyLocators.MANUAL_KEY_LINK_ON_DATA_ENTRY_POPUP);
        return element;
    }
	
	public WebElement companyNameInputFieldsOnManualKeyPage(){
        WebElement element = getDriver().findElement(ManualKeyLocators.COMPANY_NAME_INPUT_FIELD_ON_MANUAL_KEY_PAGE);
        return element;
    }
	
	public WebElement startScreeningBtnOnManualKeyPage(){
        WebElement element = getDriver().findElement(ManualKeyLocators.START_SCREENING_BTN_ON_MANUAL_KEY_PAGE);
        return element;
    }
	
	
	
	// Form Revision Page Web Elements
	
	public WebElement formRevisionQuestion_August_2009(){
        WebElement element = getDriver().findElement(ManualKeyLocators.FORM_REVISION_QUE_August_2009_RADIO_BTN);
        return element;
    }
	
	public WebElement formRevisionQuestion_January_2012(){
        WebElement element = getDriver().findElement(ManualKeyLocators.FORM_REVISION_QUE_JANUARY_2009_RADIO_BTN);
        return element;
    }
	
	public WebElement formRevisionQuestion_June_2015(){
        WebElement element = getDriver().findElement(ManualKeyLocators.FORM_REVISION_QUE_JUNE_2009_RADIO_BTN);
        return element;
    }
	
	public WebElement form_Revision_Continue_Button(){
        WebElement element = getDriver().findElement(ManualKeyLocators.continueButton);
        return element;
    }
	
	// Personal Information Page Web Elements
	
	public WebElement personalInfoFirstName(){
        WebElement element = getDriver().findElement(ManualKeyLocators.PERSONAL_INFO_FIRST_NAME);
        return element;
    }
	
	public WebElement personalInfoMiddleName(){
        WebElement element = getDriver().findElement(ManualKeyLocators.PERSONAL_INFO_MIDDLE_NAME);
        return element;
    }
	
	public WebElement personalInfoLastName(){
        WebElement element = getDriver().findElement(ManualKeyLocators.PERSONAL_INFO_LAST_NAME);
        return element;
    }
	
	public WebElement personalInfoSsn(){
        WebElement element = getDriver().findElement(ManualKeyLocators.PERSONAL_INFO_SSN);
        return element;
    }
	
	public WebElement personalInfoStreetAddress(){
        WebElement element = getDriver().findElement(ManualKeyLocators.PERSONAL_INFO_STREET_ADDRESS);
        return element;
    }
	
	public WebElement personalInfoZip(){
        WebElement element = getDriver().findElement(ManualKeyLocators.PERSONAL_INFO_ZIP);
        return element;
    }
	
	public WebElement personalInfoCity(){
        WebElement element = getDriver().findElement(ManualKeyLocators.PERSONAL_INFO_CITY);
        return element;
    }
	
	public WebElement personalInfoState(){
        WebElement element = getDriver().findElement(ManualKeyLocators.PERSONAL_INFO_STATE);
        return element;
    }
	
	public WebElement personalInfoTelephone(){
        WebElement element = getDriver().findElement(ManualKeyLocators.PERSONAL_INFO_TELEPHONE);
        return element;
    }
	
	public WebElement personalInfoDOB(){
        WebElement element = getDriver().findElement(ManualKeyLocators.PERSONAL_INFO_DOB);
        return element;
    }
	
	public WebElement personalInfoGaveInfoDate(){
        WebElement element = getDriver().findElement(ManualKeyLocators.PERSONAL_INFO_GAVE_INFO_DATE);
        return element;
    }
	
	public WebElement personalInfoJobOfferDate(){
        WebElement element = getDriver().findElement(ManualKeyLocators.PERSONAL_INFO_JOB_OFFER_DATE);
        return element;
    }
	
	public WebElement personalInfoHireDate(){
        WebElement element = getDriver().findElement(ManualKeyLocators.PERSONAL_INFO_HIRE_DATE);
        return element;
    }
	
	public WebElement personalInfoStartDate(){
        WebElement element = getDriver().findElement(ManualKeyLocators.PERSONAL_INFO_START_DATE);
        return element;
    }
	
	public WebElement personalInfoMissingDate(){
        WebElement element = getDriver().findElement(ManualKeyLocators.PERSONAL_INFO_MISSING_DATE);
        return element;
    }
	
	public WebElement personalInfoJobPosition(){
        WebElement element = getDriver().findElement(ManualKeyLocators.PERSONAL_INFO_JOB_POSITION);
        return element;
    }
	
	public WebElement personalInfoStartWage(){
        WebElement element = getDriver().findElement(ManualKeyLocators.PERSONAL_INFO_START_WAGE);
        return element;
    }
	
	
	// Conmfirm SSN page Web Elements	
	
	public WebElement confirmSSNAgain(){
        WebElement element = getDriver().findElement(ManualKeyLocators.CONFIRM_SSN_SSN_AGAIN);
        return element;
    }
	
	public WebElement confirmSSNConfirmationNumber(){
        WebElement element = getDriver().findElement(ManualKeyLocators.CONFIRM_SSN_CONFIRMATION_NUMBER);
        return element;
    }
	
	public WebElement confirmSSNOperatorName(){
        WebElement element = getDriver().findElement(ManualKeyLocators.CONFIRM_SSN_OPERATOR_NAME);
        return element;
    }
	
	public WebElement confirmSSNTodaysDate(){
        WebElement element = getDriver().findElement(ManualKeyLocators.CONFIRM_SSN_TODAYS_DATE);
        return element;
    }
	
	
	// Manual Form 8850 Jun2015 RFV 2015
	
	public WebElement form8850June2015RFVQ1(){
        WebElement element = getDriver().findElement(ManualKeyLocators.FORM_8850_JUNE_2015_RFV_Q1);
        return element;
    }
	
	public WebElement form8850June2015RFVQ2(){
        WebElement element = getDriver().findElement(ManualKeyLocators.FORM_8850_JUNE_2015_RFV_Q2);
        return element;
    }
	
	public WebElement wotcCVBranch(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_CV_WOTC_DV_WOTC_UV_BRANCH);
        return element;
    }
	
	public WebElement wotcCVState(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_CV_WOTC_DV_WOTC_UV_STATE);
        return element;
    }
	
	public WebElement form8850June2015RFVQ3(){
        WebElement element = getDriver().findElement(ManualKeyLocators.FORM_8850_JUNE_2015_RFV_Q3);
        return element;
    }
	
	public WebElement form8850June2015RFVQ4(){
        WebElement element = getDriver().findElement(ManualKeyLocators.FORM_8850_JUNE_2015_RFV_Q4);
        return element;
    }
	
	public WebElement form8850June2015RFVQ5(){
        WebElement element = getDriver().findElement(ManualKeyLocators.FORM_8850_JUNE_2015_RFV_Q5);
        return element;
    }
	
	public WebElement form8850June2015RFVQ6(){
        WebElement element = getDriver().findElement(ManualKeyLocators.FORM_8850_JUNE_2015_RFV_Q6);
        return element;
    }
	
	public WebElement form8850June2015RFVQ7(){
        WebElement element = getDriver().findElement(ManualKeyLocators.FORM_8850_JUNE_2015_RFV_Q7);
        return element;
    }
	
	public WebElement wotcFsPrimaryRecipientName(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_FS_PRIMARY_RECIPIENT_NAME);
        return element;
    }
	
	public WebElement wotcFsCity(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_FS_CITY);
        return element;
    }
	
	public WebElement wotcFsState(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_FS_STATE);
        return element;
    }
	
	public WebElement form8850June2015RFVQ8(){
        WebElement element = getDriver().findElement(ManualKeyLocators.FORM_8850_JUNE_2015_RFV_Q8);
        return element;
    }
	
	public WebElement wotcVrStateLocalAgency(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_VR_STATE_LOCAL_AGENCY);
        return element;
    }
	
	public WebElement wotcVrVeteranAdministration(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_VR_VETERAN_ADMINISTRATION);
        return element;
    }
	
	public WebElement wotcVrTicketToWork(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_VR_TICKET_TO_WORK);
        return element;
    }
	
	public WebElement wotcVrCounslerName(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_VR_COUNSLER_NAME);
        return element;
    }
	
	public WebElement wotcVrCity(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_VR_CITY);
        return element;
    }
	
	public WebElement wotcVrState(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_VR_STATE);
        return element;
    }
	
	public WebElement form8850June2015RFVQ9(){
        WebElement element = getDriver().findElement(ManualKeyLocators.FORM_8850_JUNE_2015_RFV_Q9);
        return element;
    }
	
	public WebElement wotWPrimarryRecipientName(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_W_PRIMARY_RECIPIENT_NAME);
        return element;
    }
	
	public WebElement wotcWCity(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_W_CITY);
        return element;
    }
	
	public WebElement wotcWState(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_W_STATE);
        return element;
    }
	
	public WebElement form8850June2015RFVQ10(){
        WebElement element = getDriver().findElement(ManualKeyLocators.FORM_8850_JUNE_2015_RFV_Q10);
        return element;
    }
	
	public WebElement form8850June2015RFVQ11(){
        WebElement element = getDriver().findElement(ManualKeyLocators.FORM_8850_JUNE_2015_RFV_Q11);
        return element;
    }
	
	public WebElement form8850June2015RFVQ12(){
        WebElement element = getDriver().findElement(ManualKeyLocators.FORM_8850_JUNE_2015_RFV_Q12);
        return element;
    }
	
	public WebElement wotcFFederalYes(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_F_FEDERAL_YES);
        return element;
    }
	
	public WebElement wotcFStateYes(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_F_STATE_YES);
        return element;
    }
	
	public WebElement wotcFNoneYes(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_F_NONE_YES);
        return element;
    }
	
	public WebElement wotcFConvictionMonthYear(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_F_CONVICTION_MONTH_YEAR);
        return element;
    }
	
	public WebElement wotcFReleaseMonthYear(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_F_RELEASE_MONTH_YEAR);
        return element;
    }
	
	public WebElement wotcFInmate(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_F_INMATE);
        return element;
    }
	
	public WebElement wotcFCity(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_F_CITY);
        return element;
    }
	
	public WebElement wotcFState(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_F_STATE);
        return element;
    }
	
	public WebElement wotcFProbationOfficer(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_F_PROBATION_OFFICER);
        return element;
    }
	
	public WebElement wotcFProbationOfficerPhone(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_F_PROBATION_OFFICER_PHONE);
        return element;
    }
	
	public WebElement form8850June2015RFVQ13(){
        WebElement element = getDriver().findElement(ManualKeyLocators.FORM_8850_JUNE_2015_RFV_Q13);
        return element;
    }
	
	public WebElement form8850June2015RFVQ14(){
        WebElement element = getDriver().findElement(ManualKeyLocators.FORM_8850_JUNE_2015_RFV_Q14);
        return element;
    }
	
	public WebElement form8850June2015RFVQ15(){
        WebElement element = getDriver().findElement(ManualKeyLocators.FORM_8850_JUNE_2015_RFV_Q15);
        return element;
    }
	
	public WebElement wotcLtueStartDateUnempl(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_LTUE_START_DATE_UNEMPL);
        return element;
    }
	
	public WebElement wotcLtueState(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_LTUE_STATE);
        return element;
    }
	
	
	// Thank you page Web Elements
	
	public WebElement thankYouPageTitle(){
        WebElement element = getDriver().findElement(ManualKeyLocators.THANK_YOU_PAGE_TITLE);
        return element;
    }
	
	public WebElement emplQulifyText(){
        WebElement element = getDriver().findElement(ManualKeyLocators.EMPL_QULIFY_TEXT);
        return element;
    }
	
	public WebElement screeningCompletedText(){
        WebElement element = getDriver().findElement(ManualKeyLocators.SCREENING_COMPLETED_TEXT);
        return element;
    }
	
	// Manual Form 8850 Aug2009 RFV 2009
	
	public WebElement form8850Aug2009RFVQ16(){
        WebElement element = getDriver().findElement(ManualKeyLocators.FORM_8850_Aug_2009_RFV_Q16);
        return element;
    }
	
	public WebElement form8850Aug2009RFVQ17(){
        WebElement element = getDriver().findElement(ManualKeyLocators.FORM_8850_Aug_2009_RFV_Q17);
        return element;
    }
	public WebElement form8850Aug2009RFVQ18(){
        WebElement element = getDriver().findElement(ManualKeyLocators.FORM_8850_Aug_2009_RFV_Q18);
        return element;
    }
	public WebElement form8850Aug2009RFVQ19(){
        WebElement element = getDriver().findElement(ManualKeyLocators.FORM_8850_Aug_2009_RFV_Q19);
        return element;
    }
	public WebElement form8850Aug2009RFVQ20(){
        WebElement element = getDriver().findElement(ManualKeyLocators.FORM_8850_Aug_2009_RFV_Q20);
        return element;
    }
	public WebElement form8850Aug2009RFVQ21(){
        WebElement element = getDriver().findElement(ManualKeyLocators.FORM_8850_Aug_2009_RFV_Q21);
        return element;
    }
	public WebElement form8850Aug2009RFVQ22(){
        WebElement element = getDriver().findElement(ManualKeyLocators.FORM_8850_Aug_2009_RFV_Q22);
        return element;
    }
	public WebElement form8850Aug2009RFVQ23(){
        WebElement element = getDriver().findElement(ManualKeyLocators.FORM_8850_Aug_2009_RFV_Q23);
        return element;
    }
	public WebElement form8850Aug2009RFVQ24(){
        WebElement element = getDriver().findElement(ManualKeyLocators.FORM_8850_Aug_2009_RFV_Q24);
        return element;
    }
	
	
	public WebElement wotcVBranchService(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_CV_WOTC_DV_WOTC_UV_BRANCH_SERVICE);
        return element;
    }
	public WebElement wotcVStartMonthYear(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_CV_WOTC_DV_WOTC_UV_START_MONTH_YEAR);
        return element;
    }
	public WebElement wotcVServiceEndMonthYear(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_CV_WOTC_DV_WOTC_UV_SERVICE_END_MONTH_YEAR);
        return element;
    }
	public WebElement wotcVStateBenifits(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_CV_WOTC_DV_WOTC_UV_STATE_BENIFITS);
        return element;
    }
	
	
	public WebElement wotcFsFoodStampsRecipients(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_FS_PRIMARY_FOOD_STAMPS_RECIPIENT);
        return element;
    }
	
	
	public WebElement wotcWChildName(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_W_PRIMARY_RECIPIENT_CHILD_NAME);
        return element;
    }
	public WebElement wotcWRelation(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_W_RELATION_TO_YOU);
        return element;
    }
	public WebElement wotcWFormAug2009City(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_W_AUG_2009_CITY);
        return element;
    }
	public WebElement wotcWFormAug2009State(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_W_AUG_2009_STATE);
        return element;
    }
	
	
	public WebElement wotcFConvictionDate(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_F_AUG_2009_CONVICTION_DATE);
        return element;
    }
	
	public WebElement wotcFFormAug2009ReleaseMonthYear(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_F_AUG_2009_RELEASE_MONTH_YEAR);
        return element;
    }
	public WebElement wotcFWorkReleaseProg(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_F_AUG_2009_WORK_RELEASE_PROG);
        return element;
    }
	public WebElement wotcFFromAug2009City(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_F_AUG_2009_CITY);
        return element;
    }
	public WebElement wotcFFormAug2009ProbationOfficer(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_F_AUG_2009_PROBATION_OFFICER);
        return element;
    }
	public WebElement wotcFFormAug2009ProbationOfficerPhone(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_F_AUG_2009_PROBATION_OFFICER_PHONE);
        return element;
    }
	
	public WebElement wotcVrAug2009CounslerName(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_VR_AUG_2009_COUNSLER_NAME);
        return element;
    }
	public WebElement wotcVrAug2009CounslerPhone(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_VR_AUG_2009_COUNSLER_PHONE);
        return element;
    }
	public WebElement wotcVrAug2009City(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_VR_AUG_2009_CITY);
        return element;
    }
	public WebElement wotcVrAug2009State(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_VR_AUG_2009_STATE);
        return element;
    }
	
	
	public WebElement wotcFs25FoodRecipient(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_FS25_AUG_2009_FOOD_RECIPIENT);
        return element;
    }
	public WebElement wotcFs25Relation(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_FS25_AUG_2009_RELATION);
        return element;
    }
	public WebElement wotcFs25City(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_FS25_AUG_2009_CITY);
        return element;
    }
	public WebElement wotcFs25State(){
        WebElement element = getDriver().findElement(ManualKeyLocators.WOTC_FS25_AUG_2009_STATE);
        return element;
    }	
	
	public WebElement stateQuestionText(){
        WebElement element = getDriver().findElement(ManualKeyLocators.STATE_QUESTIONS_TEXT);
        return element;
    }
	
	
}
