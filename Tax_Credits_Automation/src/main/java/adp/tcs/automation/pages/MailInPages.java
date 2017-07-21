package adp.tcs.automation.pages;

import adp.tcs.automation.locators.MailInLocators;
import adp.tcs.automation.stepsfiles.BaseTempletSteps;
import org.openqa.selenium.WebElement;

/**
 * Created by Thorasa on 10/12/2016.
 */
public class MailInPages extends BaseTempletSteps{

	public WebElement mailInLinkOnDataEntry(){
        WebElement element = getDriver().findElement(MailInLocators.MAIL_IN_LINK_ON_DATA_ENTRY_POPUP);
        return element;
    }
	public WebElement queuesDropdownBtn(){
        WebElement element = getDriver().findElement(MailInLocators.QUEUES_DROPDOWN_BTN);
        return element;
    }
	
	public WebElement cmpInputBox(){
        WebElement element = getDriver().findElement(MailInLocators.COMPANY_INPUT_BOX);
        return element;
    }
	public WebElement startScreeningBtn(){
        WebElement element = getDriver().findElement(MailInLocators.START_SCREENING_BTN);
        return element;
	}
	
	
	// Personal Info Web Elements
	
	public WebElement personalInfoSSNTxtBox(){
        WebElement element = getDriver().findElement(MailInLocators.PERSONAL_INFO_SSN_TEXT_BOX);
        return element;
    }
	public WebElement personalInfoFirstNameTxtBox(){
        WebElement element = getDriver().findElement(MailInLocators.PERSONAL_INFO_FIRST_NAME_TEXT_BOX);
        return element;
    }
	
	public WebElement personalInfoMiddleNameTxtBox(){
        WebElement element = getDriver().findElement(MailInLocators.PERSONAL_INFO_MIDDLE_NAME_TEXT_BOX);
        return element;
    }
	public WebElement personalInfoLastNameTxtBox(){
        WebElement element = getDriver().findElement(MailInLocators.PERSONAL_INFO_LAST_NAME_TEXT_BOX);
        return element;
	}
	public WebElement personalInfoHireDateTxtBox(){
        WebElement element = getDriver().findElement(MailInLocators.PERSONAL_INFO_HIRE_DATE_TEXT_BOX);
        return element;
    }	
	public WebElement personalInfoStartDateTxtBox(){
        WebElement element = getDriver().findElement(MailInLocators.PERSONAL_INFO_START_DATE_TEXT_BOX);
        return element;
    }
	public WebElement comtinueBtn(){
        WebElement element = getDriver().findElement(MailInLocators.PERSONAL_INFO_CONTINUE_BTN);
        return element;
	}
	
	public WebElement personalInfoSocialSecurityNumber(){
        WebElement element = getDriver().findElement(MailInLocators.PERSONAL_INFO_SOCIAL_SECURITY_NUMBER_TEXT_BOX);
        return element;
	}
	public WebElement personalInfoMiddleInitialTxtBox(){
        WebElement element = getDriver().findElement(MailInLocators.PERSONAL_INFO_MIDDLE_NAME_INITIAL_TEXT_BOX);
        return element;
    }	
	public WebElement personalInfoStreetAddressTxtBox(){
        WebElement element = getDriver().findElement(MailInLocators.PERSONAL_INFO_STREET_ADDRESS_TEXT_BOX);
        return element;
    }
	public WebElement personalInfoZipTxtBox(){
        WebElement element = getDriver().findElement(MailInLocators.PERSONAL_INFO_ZIP_TEXT_BOX);
        return element;
	}public WebElement personalInfoCityTxtBox(){
        WebElement element = getDriver().findElement(MailInLocators.PERSONAL_INFO_CITY_TEXT_BOX);
        return element;
	}
	public WebElement personalInfoStateTxtBox(){
        WebElement element = getDriver().findElement(MailInLocators.PERSONAL_INFO_STATE_TEXT_BOX);
        return element;
    }	
	public WebElement personalInfoTelephoneTxtBox(){
        WebElement element = getDriver().findElement(MailInLocators.PERSONAL_INFO_TELEPHONE_TEXT_BOX);
        return element;
    }
	public WebElement personalInfoDOBTxtBox(){
        WebElement element = getDriver().findElement(MailInLocators.PERSONAL_INFO_DOB_TEXT_BOX);
        return element;
	}
	
	// 8850 form revision Web Elements
	
		public WebElement form8850RevisionMarch2016(){
	        WebElement element = getDriver().findElement(MailInLocators.FORM_8850_REVISION_MARCH2016);
	        return element;
	    }
		public WebElement form8850RevisionJune2015(){
	        WebElement element = getDriver().findElement(MailInLocators.FORM_8850_REVISION_JUNE2015);
	        return element;
	    }
		
		public WebElement form8850RevisionJan2012(){
	        WebElement element = getDriver().findElement(MailInLocators.FORM_8850_REVISION_JAN2012);
	        return element;
	    }
		public WebElement form8850RevisionJune2007(){
	        WebElement element = getDriver().findElement(MailInLocators.FORM_8850_REVISION_JUNE2007);
	        return element;
		}
		public WebElement form8850RevisionOther(){
	        WebElement element = getDriver().findElement(MailInLocators.FORM_8850_REVISION_OTHER);
	        return element;
	    }
		
		// Confirm SSN Web Elements
		
		public WebElement confirmSSNAgain(){
	        WebElement element = getDriver().findElement(MailInLocators.CONFIRM_SSN_AGAIN);
	        return element;
	    }
	
		// Hire Information page Web Elements
		
			public WebElement hireInfoGaveInfoDate(){
		        WebElement element = getDriver().findElement(MailInLocators.HIRE_INFO_GAVE_INFORMATION_DATE);
		        return element;
		    }
			public WebElement hireInfoJobOfferDate(){
		        WebElement element = getDriver().findElement(MailInLocators.HIRE_INFO_JOB_OFFER_DATE);
		        return element;
		    }
			
			public WebElement hireInfoGaveOfferDateNotAvialble(){
		        WebElement element = getDriver().findElement(MailInLocators.HIRE_INFO_GAVE_OFFER_DATE_NOT_AVILABLE);
		        return element;
		    }
			public WebElement hireInfoHireDate(){
		        WebElement element = getDriver().findElement(MailInLocators.HIRE_INFO_HIRE_DATE);
		        return element;
			}
			public WebElement hireInfoStartDate(){
		        WebElement element = getDriver().findElement(MailInLocators.HIRE_INFO_START_DATE);
		        return element;
		    }
			public WebElement hireInfoHireStartDateNotAvialble(){
		        WebElement element = getDriver().findElement(MailInLocators.HIRE_INFO_HIRE_START_DATE_NOT_AVILABLE);
		        return element;
		    }
			public WebElement hireInfoCallDate(){
		        WebElement element = getDriver().findElement(MailInLocators.HIRE_INFO_CALL_DATE);
		        return element;
		    }
			public WebElement hireInfoJobPosition(){
		        WebElement element = getDriver().findElement(MailInLocators.HIRE_INFO_JOB_POSITION);
		        return element;
		    }
			public WebElement hireInfoStartWage(){
		        WebElement element = getDriver().findElement(MailInLocators.HIRE_INFO_START_WAGE);
		        return element;
		    }
			
			
			// Jan 12/Jun 15/Mar 16 Revision Checks page Web Elements
			
				public WebElement revisionCheckQ1(){
			        WebElement element = getDriver().findElement(MailInLocators.REVISION_CHECK_Q1);
			        return element;
			    }
				public WebElement revisionCheckQ2(){
			        WebElement element = getDriver().findElement(MailInLocators.REVISION_CHECK_Q2);
			        return element;
			    }
				
				public WebElement revisionCheckQ3(){
			        WebElement element = getDriver().findElement(MailInLocators.REVISION_CHECK_Q3);
			        return element;
			    }
				public WebElement revisionCheckQ4(){
			        WebElement element = getDriver().findElement(MailInLocators.REVISION_CHECK_Q4);
			        return element;
				}
				public WebElement revisionCheckQ5(){
			        WebElement element = getDriver().findElement(MailInLocators.REVISION_CHECK_Q5);
			        return element;
			    }
				public WebElement revisionCheckQ6(){
			        WebElement element = getDriver().findElement(MailInLocators.REVISION_CHECK_Q6);
			        return element;
			    }
				public WebElement revisionCheckQ7(){
			        WebElement element = getDriver().findElement(MailInLocators.REVISION_CHECK_Q7);
			        return element;
			    }
				public WebElement applicantSignatureYes(){
			        WebElement element = getDriver().findElement(MailInLocators.APPLICANT_SIGN_YES);
			        return element;
			    }
				public WebElement applicantSignatureNo(){
			        WebElement element = getDriver().findElement(MailInLocators.APPLICANT_SIGN_NO);
			        return element;
			    }
				
				// Previous Employment page Web Elements
				
				public WebElement previousEmplYes(){
			        WebElement element = getDriver().findElement(MailInLocators.PREVIOUS_EMPL_YES);
			        return element;
			    }
				public WebElement previousEmplNo(){
			        WebElement element = getDriver().findElement(MailInLocators.PREVIOUS_EMPL_NO);
			        return element;
			    }
				
				public WebElement previousEmplNoAns(){
			        WebElement element = getDriver().findElement(MailInLocators.PREVIOUS_EMPL_NO_ANS);
			        return element;
			    }

				// Military Service pag Web Elements
				
				public WebElement militaryServiceYes(){
			        WebElement element = getDriver().findElement(MailInLocators.MILITARY_SERVICE_YES);
			        return element;
			    }
				public WebElement militaryServiceNo(){
			        WebElement element = getDriver().findElement(MailInLocators.MILITARY_SERVICE_NO);
			        return element;
			    }
				
				public WebElement militaryServiceNoAns(){
			        WebElement element = getDriver().findElement(MailInLocators.MILITARY_SERVICE_NO_ANS);
			        return element;
			    }
				
				public WebElement militaryServiceBranchService(){
			        WebElement element = getDriver().findElement(MailInLocators.MILITARY_SERVICE_BRANCH_SERVICE);
			        return element;
			    }
				
				public WebElement militaryServiceVeteranDisabilityYes(){
			        WebElement element = getDriver().findElement(MailInLocators.MILITARY_SERVICE_VETERAN_DISABILITY_YES);
			        return element;
			    }
				public WebElement militaryServiceVeteranDisabilityNo(){
			        WebElement element = getDriver().findElement(MailInLocators.MILITARY_SERVICE_VETERAN_DISABILITY_NO);
			        return element;
			    }
				
				public WebElement militaryServiceVeteranDisabilityNoAns(){
			        WebElement element = getDriver().findElement(MailInLocators.MILITARY_SERVICE_VETERAN_DISABILITY_NO_ANS);
			        return element;
			    }
				
				public WebElement militaryServiceVeteranDischargedYes(){
			        WebElement element = getDriver().findElement(MailInLocators.MILITARY_SERVICE_VETERAN_DISCHARGED_YES);
			        return element;
			    }
				public WebElement militaryServiceVeteranDischargedNo(){
			        WebElement element = getDriver().findElement(MailInLocators.MILITARY_SERVICE_VETERAN_DISCHARGED_NO);
			        return element;
			    }
				
				public WebElement militaryServiceVeteranDischargedNoAns(){
			        WebElement element = getDriver().findElement(MailInLocators.MILITARY_SERVICE_VETERAN_DISCHARGED_NO_ANS);
			        return element;
			    }
				
				
				public WebElement militaryServiceVeteranUnempl4Yes(){
			        WebElement element = getDriver().findElement(MailInLocators.MILITARY_SERVICE_VETERAN_UNEMPL4_YES);
			        return element;
			    }
				public WebElement militaryServiceVeteranUnempl4No(){
			        WebElement element = getDriver().findElement(MailInLocators.MILITARY_SERVICE_VETERAN_UNEMPL4_NO);
			        return element;
			    }
				
				public WebElement militaryServiceVeteranUnempl4NoAns(){
			        WebElement element = getDriver().findElement(MailInLocators.MILITARY_SERVICE_VETERAN_UNEMPL4_NO_ANS);
			        return element;
			    }
				
				public WebElement militaryServiceVeteranUnempl6Yes(){
			        WebElement element = getDriver().findElement(MailInLocators.MILITARY_SERVICE_VETERAN_UNEMPL6_YES);
			        return element;
			    }
				public WebElement militaryServiceVeteranUnempl6No(){
			        WebElement element = getDriver().findElement(MailInLocators.MILITARY_SERVICE_VETERAN_UNEMPL6_NO);
			        return element;
			    }
				
				public WebElement militaryServiceVeteranUnempl6NoAns(){
			        WebElement element = getDriver().findElement(MailInLocators.MILITARY_SERVICE_VETERAN_UNEMPL6_NO_ANS);
			        return element;
			    }
				
				// Food Stamps page locators web Elements
				
				public WebElement foodStampsYes(){
			        WebElement element = getDriver().findElement(MailInLocators.FOOD_STAMPS_YES);
			        return element;
			    }
				public WebElement foodStampsNo(){
			        WebElement element = getDriver().findElement(MailInLocators.FOOD_STAMPS_NO);
			        return element;
			    }
				
				public WebElement foodStampsNoAns(){
			        WebElement element = getDriver().findElement(MailInLocators.FOOD_STAMPS_NO_ANS);
			        return element;
			    }
				
				public WebElement foodStampsPrimaryRecipient(){
			        WebElement element = getDriver().findElement(MailInLocators.FOOD_STAMPS_PRIMARY_RECIPIENT);
			        return element;
			    }
				public WebElement foodStampsCity(){
			        WebElement element = getDriver().findElement(MailInLocators.FOOD_STAMPS_CITY);
			        return element;
			    }
				
				public WebElement foodStampsState(){
			        WebElement element = getDriver().findElement(MailInLocators.FOOD_STAMPS_STATE);
			        return element;
			    }
				
				//Vocational Rehabilitation page web Elements
				
				public WebElement VocationRehab_Question_YES(){
			        WebElement element = getDriver().findElement(MailInLocators.VOCATIONAL_REHAB_YES);
			        return element;
			    }
				public WebElement VocationRehab_Question_NO(){
			        WebElement element = getDriver().findElement(MailInLocators.VOCATIONAL_REHAB_NO);
			        return element;
			    }
				
				public WebElement VocationRehab_Question_NO_ANS(){
			        WebElement element = getDriver().findElement(MailInLocators.VOCATIONAL_REHAB_NO_ANS);
			        return element;
			    }
				
				public WebElement VocationalRehab_VocRehab_YesSA(){
			        WebElement element = getDriver().findElement(MailInLocators.VOCATIONAL_REHAB_YES_SA);
			        return element;
			    }
				public WebElement VocationalRehab_VocRehab_YesVA(){
			        WebElement element = getDriver().findElement(MailInLocators.VOCATIONAL_REHAB_YES_VA);
			        return element;
			    }
				
				public WebElement VocationalRehab_VocRehab_YesTW(){
			        WebElement element = getDriver().findElement(MailInLocators.VOCATIONAL_REHAB_YES_TW);
			        return element;
			    }
				public WebElement VocationalRehab_VocRehab_No(){
			        WebElement element = getDriver().findElement(MailInLocators.VOCATIONAL_REHAB_NOT_SPECIFIED);
			        return element;
			    }
				
				public WebElement VocationalRehab_City(){
			        WebElement element = getDriver().findElement(MailInLocators.FOOD_STAMPS_CITY_NAME);
			        return element;
			    }
				
				public WebElement VocationalRehab_State(){
			        WebElement element = getDriver().findElement(MailInLocators.FOOD_STAMPS_STATE_NAME);
			        return element;
			    }
				public WebElement VocationalRehab_CunslerName(){
			        WebElement element = getDriver().findElement(MailInLocators.FOOD_STAMPS_COUNSLER_NAME);
			        return element;
			    }
				
				// Welfare ( AFDC or TANF) page web Elements
				
				public WebElement welfareTanfWotcYes(){
			        WebElement element = getDriver().findElement(MailInLocators.TANF_WOTC_YES);
			        return element;
			    }
				public WebElement welfareTanfWotcNo(){
			        WebElement element = getDriver().findElement(MailInLocators.TANF_WOTC_NO);
			        return element;
			    }
				
				public WebElement welfareTanfWotcNoAns(){
			        WebElement element = getDriver().findElement(MailInLocators.TANF_WOTC_NO_ANS);
			        return element;
			    }
				
				public WebElement welfarePrimaryRecipient(){
			        WebElement element = getDriver().findElement(MailInLocators.WELFARE_PRIMARY_RECIPIENT);
			        return element;
			    }
				public WebElement welfareStampsCity(){
			        WebElement element = getDriver().findElement(MailInLocators.WELFARE_CITY);
			        return element;
			    }
				
				public WebElement welfareState(){
			        WebElement element = getDriver().findElement(MailInLocators.WELFARE_STATE);
			        return element;
			    }
				
				//Supplemental Security Income page web Elements
				
				public WebElement ssiYes(){
			        WebElement element = getDriver().findElement(MailInLocators.SSI_YES);
			        return element;
			    }
				public WebElement ssiNo(){
			        WebElement element = getDriver().findElement(MailInLocators.SSI_NO);
			        return element;
			    }
				
				public WebElement ssiNoAns(){
			        WebElement element = getDriver().findElement(MailInLocators.SSI_NO_ANS);
			        return element;
			    }

				//Felony page web Elements
				
				public WebElement felonyConvictedYes(){
			        WebElement element = getDriver().findElement(MailInLocators.FELONY_CONVICTAED_YES);
			        return element;
			    }
				public WebElement felonyConvictedNo(){
			        WebElement element = getDriver().findElement(MailInLocators.FELONY_CONVICTAED_NO);
			        return element;
			    }
				
				public WebElement felonyConvictedNoAns(){
			        WebElement element = getDriver().findElement(MailInLocators.FELONY_CONVICTAED_NO_ANS);
			        return element;
			    }
				
				public WebElement felonyReleaseProgYes(){
			        WebElement element = getDriver().findElement(MailInLocators.FELONY_RELEASE_PROG_YES);
			        return element;
			    }
				public WebElement felonyReleaseProgNo(){
			        WebElement element = getDriver().findElement(MailInLocators.FELONY_RELEASE_PROG_NO);
			        return element;
			    }
				
				public WebElement felonyReleaseProgNoAns(){
			        WebElement element = getDriver().findElement(MailInLocators.FELONY_RELEASE_PROG_NO_ANS);
			        return element;
			    }
				
				public WebElement felonyConvTypeYesED(){
			        WebElement element = getDriver().findElement(MailInLocators.FELONY_CONV_TYPE_YESFED);
			        return element;
			    }
				public WebElement felonyConvTypeYesTA(){
			        WebElement element = getDriver().findElement(MailInLocators.FELONY_CONV_TYPE_YESFTA);
			        return element;
			    }
				
				public WebElement felonyConvTypeYesNone(){
			        WebElement element = getDriver().findElement(MailInLocators.FELONY_CONV_TYPE_NONE);
			        return element;
			    }
				
				
				public WebElement felonyConvictionDate(){
			        WebElement element = getDriver().findElement(MailInLocators.FELONY_COVICTION_DATE);
			        return element;
			    }
				
				public WebElement felonyReleaseDate(){
			        WebElement element = getDriver().findElement(MailInLocators.FELONY_RELEASE_DATE);
			        return element;
			    }
				public WebElement felonyInmateNo(){
			        WebElement element = getDriver().findElement(MailInLocators.FELONY_INMATE);
			        return element;
			    }
				
				public WebElement felonyCity(){
			        WebElement element = getDriver().findElement(MailInLocators.FELONY_CITY);
			        return element;
			    }
				
				public WebElement felonyState(){
			        WebElement element = getDriver().findElement(MailInLocators.FELONY_STATE);
			        return element;
			    }
				public WebElement felonyProbationOfficer(){
			        WebElement element = getDriver().findElement(MailInLocators.FELONY_PROBATION_OFFICER);
			        return element;
			    }
				
				public WebElement felonyProbationOfficerPhone(){
			        WebElement element = getDriver().findElement(MailInLocators.FELONY_PROBATION_OFFICER_PHONE);
			        return element;
			    }

	public WebElement mailInSearch(){
		WebElement element = getDriver().findElement(MailInLocators.MAIL_IN_SERCH_CLICK);
		return element;
	}


				
				
				
}
