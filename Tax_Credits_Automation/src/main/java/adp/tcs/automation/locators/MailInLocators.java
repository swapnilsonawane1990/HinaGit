package adp.tcs.automation.locators;

import org.openqa.selenium.By;

import adp.tcs.automation.stepsfiles.BaseTempletSteps;
/**
 * Created by Thorasa on 10/12/2016.
 */
public class MailInLocators extends BaseTempletSteps{

	public static final By MAIL_IN_LINK_ON_DATA_ENTRY_POPUP = By.xpath("//a[text()='Mail-In Key In']");
	
	public static final By QUEUES_DROPDOWN_BTN = By.xpath("//button[@class='adp-dropdown-button']");
	public static final String QUEUES_DROPDOWN_VALUES_CONST = "//ul[@class='adp-dropdown-menu adp-dropdown-open']/li/a";
	public static final By COMPANY_INPUT_BOX = By.xpath("//div[@class='form-group'][2]/input");
	public static final By START_SCREENING_BTN = By.xpath("//span[text()='Start Screening']");
	
	// Personal Information Page Locators	
	public static final By PERSONAL_INFO_SSN_TEXT_BOX = By.xpath("//div[@class='question_title'][1]//span[2][text()='SSN']/ancestor::div[1]/following::input[1]");
	public static final By PERSONAL_INFO_FIRST_NAME_TEXT_BOX = By.xpath("//div[@class='question_title'][1]//span[2][text()='First Name']/ancestor::div[1]/following::input[1]");
	public static final By PERSONAL_INFO_MIDDLE_NAME_TEXT_BOX = By.xpath("//div[@class='question_title'][1]//span[2][text()='Middle Initial']/ancestor::div[1]/following::input[1]");
	public static final By PERSONAL_INFO_LAST_NAME_TEXT_BOX = By.xpath("//div[@class='question_title'][1]//span[2][text()='Last Name']/ancestor::div[1]/following::input[1]");
	public static final By PERSONAL_INFO_HIRE_DATE_TEXT_BOX = By.xpath("//*[@id=\"question\"]/div[2]/div[23]/input");
	public static final By PERSONAL_INFO_START_DATE_TEXT_BOX = By.xpath("//*[@id=\"question\"]/div[2]/div[30]/input");
	public static final By PERSONAL_INFO_CONTINUE_BTN = By.xpath("//div[@class='question_title'][1]//span[2][text()='Start Date (MM/DD/YYYY)']/ancestor::div[1]/following::input[1]");	
	
	public static final By PERSONAL_INFO_SOCIAL_SECURITY_NUMBER_TEXT_BOX = By.xpath("//div[@class='question_title'][1]//span[2][text()='Social Security Number']/ancestor::div[1]/following::input[1]");
	public static final By PERSONAL_INFO_MIDDLE_NAME_INITIAL_TEXT_BOX = By.xpath("//div[@class='question_title'][1]//span[2][text()='Middle Name/Initial']/ancestor::div[1]/following::input[1]");
	public static final By PERSONAL_INFO_STREET_ADDRESS_TEXT_BOX = By.xpath("//div[@class='question_title'][1]//span[2][text()='Street Address (Preferably not PO box)']/ancestor::div[1]/following::input[1]");
	public static final By PERSONAL_INFO_ZIP_TEXT_BOX = By.xpath("//div[@class='question_title'][1]//span[2][text()='Zip']/ancestor::div[1]/following::input[1]");
	public static final By PERSONAL_INFO_CITY_TEXT_BOX = By.xpath("//div[@class='question_title'][1]//span[2][text()='City']/ancestor::div[1]/following::input[1]");
	public static final By PERSONAL_INFO_STATE_TEXT_BOX = By.xpath("//div[@class='question_title'][1]//span[2][text()='State']/../following-sibling::div[@class='row']//select");	
	public static final By PERSONAL_INFO_TELEPHONE_TEXT_BOX = By.xpath("//div[@class='question_title'][1]//span[2][text()='Telephone']/ancestor::div[1]/following::input[1]");
	public static final By PERSONAL_INFO_DOB_TEXT_BOX = By.xpath("//div[@class='question_title'][1]//span[2][text()='Date of Birth']/ancestor::div[1]/following::input[1]");
	
	
	
	// 8850 Form Revision Page Locators
	
	public static final By FORM_8850_REVISION_MARCH2016 = By.xpath("//input[@id='8850RevisionQuestion_Mar16']");
	public static final By FORM_8850_REVISION_JUNE2015 = By.xpath("//input[@id='8850RevisionQuestion_Jun15']");
	public static final By FORM_8850_REVISION_JAN2012 = By.xpath("//input[@id='8850RevisionQuestion_Jan12']");
	public static final By FORM_8850_REVISION_JUNE2007 = By.xpath("//input[@id='8850RevisionQuestion_Jun07']");
	public static final By FORM_8850_REVISION_OTHER = By.xpath("//input[@id='8850RevisionQuestion_Oct02']");
	
	
	// Confirm SSN Page Locators
	public static final By CONFIRM_SSN_AGAIN = By.xpath("//div[@class='question_title'][1]//span[2][contains(text(),'SSN again')]/ancestor::div[1]/following::input[1]");
	
	// Hire Information page Locators
	public static final By HIRE_INFO_GAVE_INFORMATION_DATE = By.xpath("//div[@class='question_title'][1]//span[2][text()='Gave Information Date']/ancestor::div[1]/following::input[1]");
	public static final By HIRE_INFO_JOB_OFFER_DATE = By.xpath("//div[@class='question_title'][1]//span[2][text()='Job Offer Date']/ancestor::div[1]/following::input[1]");
	public static final By HIRE_INFO_GAVE_OFFER_DATE_NOT_AVILABLE = By.xpath("//*[@id='question']/div[2]/div[16]/div[3]/input");
	public static final By HIRE_INFO_HIRE_DATE = By.xpath("//div[@class='question_title'][1]//span[2][text()='Hire Date']/ancestor::div[1]/following::input[1]");
	public static final By HIRE_INFO_START_DATE = By.xpath("//div[@class='question_title'][1]//span[2][text()='Start Date']/ancestor::div[1]/following::input[1]");
	public static final By HIRE_INFO_HIRE_START_DATE_NOT_AVILABLE = By.xpath("//*[@id='question']/div[2]/div[37]/div[3]/input");
	public static final By HIRE_INFO_CALL_DATE = By.xpath("//div[@class='question_title'][1]//span[2][text()='Call Date']/ancestor::div[1]/following::input[1]");
	public static final By HIRE_INFO_JOB_POSITION = By.xpath("//div[@class='question_title'][1]//span[2][text()='Job Position']/../following-sibling::div[@class='row']//select");
	public static final By HIRE_INFO_START_WAGE = By.xpath("//div[@class='question_title'][1]//span[2][text()='Start Wage']/ancestor::div[1]/following::input[1]");
	
	// Jan 12/Jun 15/Mar 16 Revision Checks page locators
	
	public static final By REVISION_CHECK_Q1 = By.xpath("//*[@id='question']/div[2]/div[2]/div[3]/input");
	public static final By REVISION_CHECK_Q2 = By.xpath("//*[@id='question']/div[2]/div[9]/div[3]/input");
	public static final By REVISION_CHECK_Q3 = By.xpath("//*[@id='question']/div[2]/div[16]/div[3]/input");
	public static final By REVISION_CHECK_Q4 = By.xpath("//*[@id='question']/div[2]/div[23]/div[3]/input");

	public static final By REVISION_CHECK_Q5 = By.xpath("//*[@id='question']/div[2]/div[30]/div[3]/input");
	public static final By REVISION_CHECK_Q6 = By.xpath("//*[@id='question']/div[2]/div[37]/div[3]/input");
	public static final By REVISION_CHECK_Q7 = By.xpath("//*[@id='question']/div[2]/div[44]/div[3]/input");

	
	public static final By APPLICANT_SIGN_YES = By.xpath("//*[@id='8850_1_Jan12_Signature_YES']");
	public static final By APPLICANT_SIGN_NO = By.xpath("//*[@id='8850_1_Jan12_Signature_NO']");
	
	// Previous Employment page locators	
	public static final By PREVIOUS_EMPL_YES = By.xpath("//*[@id='PreviousEmployed_YES']");
	public static final By PREVIOUS_EMPL_NO = By.xpath("//*[@id='PreviousEmployed_NO']");
	public static final By PREVIOUS_EMPL_NO_ANS = By.xpath("//*[@id='PreviousEmployed_NULL']");
	
	// Military Service page locators	
	public static final By MILITARY_SERVICE_YES = By.xpath("//*[@id='Veteran_YES']");
	public static final By MILITARY_SERVICE_NO = By.xpath("//*[@id='Veteran_NO']");
	public static final By MILITARY_SERVICE_NO_ANS = By.xpath("//*[@id='Veteran_NULL']");
	
	public static final By MILITARY_SERVICE_BRANCH_SERVICE = By.xpath("//div[@class='question_title'][1]//span[2][text()='Branch of Service']/ancestor::div[1]/following::input[1]");
	
	public static final By MILITARY_SERVICE_VETERAN_DISABILITY_YES = By.xpath("//*[@id='Veteran_Disability_YES']");
	public static final By MILITARY_SERVICE_VETERAN_DISABILITY_NO = By.xpath("//*[@id='Veteran_Disability_NO']");
	public static final By MILITARY_SERVICE_VETERAN_DISABILITY_NO_ANS = By.xpath("//*[@id='Veteran_Disability_NULL']");
	
	public static final By MILITARY_SERVICE_VETERAN_DISCHARGED_YES = By.xpath("//*[@id='Veteran_Discharged_Released_YES']");
	public static final By MILITARY_SERVICE_VETERAN_DISCHARGED_NO = By.xpath("//*[@id='Veteran_Discharged_Released_NO']");
	public static final By MILITARY_SERVICE_VETERAN_DISCHARGED_NO_ANS = By.xpath("//*[@id='Veteran_Discharged_Released_NULL']");
	
	public static final By MILITARY_SERVICE_VETERAN_UNEMPL4_YES = By.xpath("//*[@id='Veteran_Unemployment4_YES']");
	public static final By MILITARY_SERVICE_VETERAN_UNEMPL4_NO = By.xpath("//*[@id='Veteran_Unemployment4_NO']");
	public static final By MILITARY_SERVICE_VETERAN_UNEMPL4_NO_ANS = By.xpath("//*[@id='Veteran_Unemployment4_NULL']");
	
	public static final By MILITARY_SERVICE_VETERAN_UNEMPL6_YES = By.xpath("//*[@id='Veteran_Unemployment6_YES']");
	public static final By MILITARY_SERVICE_VETERAN_UNEMPL6_NO = By.xpath("//*[@id='Veteran_Unemployment6_NO']");
	public static final By MILITARY_SERVICE_VETERAN_UNEMPL6_NO_ANS = By.xpath("//*[@id='Veteran_Unemployment6_NULL']");

	// Food Stamps page locators	
	public static final By FOOD_STAMPS_YES = By.xpath("//*[@id='Veteran_Food_Stamps_YES']");
	public static final By FOOD_STAMPS_NO = By.xpath("//*[@id='Veteran_Food_Stamps_NO']");
	public static final By FOOD_STAMPS_NO_ANS = By.xpath("//*[@id='Veteran_Food_Stamps_NULL']");
		
	public static final By FOOD_STAMPS_PRIMARY_RECIPIENT = By.xpath("//div[@class='question_title'][1]//span[2][text()='Primary Recipient']/ancestor::div[1]/following::input[1]");
	public static final By FOOD_STAMPS_CITY = By.xpath("//div[@class='question_title'][1]//span[2][text()='City']/ancestor::div[1]/following::input[1]");
	public static final By FOOD_STAMPS_STATE = By.xpath("//div[@class='question_title'][1]//span[2][text()='State']/../following-sibling::div[@class='row']//select");

	//Vocational Rehabilitation page locators	
	public static final By VOCATIONAL_REHAB_YES = By.xpath("//*[@id='VocationRehab_Question_YES']");
	public static final By VOCATIONAL_REHAB_NO = By.xpath("//*[@id='VocationRehab_Question_NO']");
	public static final By VOCATIONAL_REHAB_NO_ANS = By.xpath("//*[@id='VocationRehab_Question_NULL']");
	
	public static final By VOCATIONAL_REHAB_YES_SA = By.xpath("//*[@id='VocationalRehab_VocRehab_YesSA']");
	public static final By VOCATIONAL_REHAB_YES_VA = By.xpath("//*[@id='VocationalRehab_VocRehab_YesVA']");
	public static final By VOCATIONAL_REHAB_YES_TW = By.xpath("//*[@id='VocationalRehab_VocRehab_YesTW']");
	public static final By VOCATIONAL_REHAB_NOT_SPECIFIED = By.xpath("//*[@id='VocationalRehab_VocRehab_No']");
	
	public static final By FOOD_STAMPS_CITY_NAME = By.xpath("//div[@class='question_title'][1]//span[2][text()='City']/ancestor::div[1]/following::input[1]");
	public static final By FOOD_STAMPS_STATE_NAME = By.xpath("//div[@class='question_title'][1]//span[2][text()='State']/../following-sibling::div[@class='row']//select");
	public static final By FOOD_STAMPS_COUNSLER_NAME = By.xpath("//div[@class='question_title'][1]//span[2][contains(text(),'Counselor')]/ancestor::div[1]/following::input[1]");

	
	// Welfare ( AFDC or TANF) page locators	
	public static final By TANF_WOTC_YES = By.xpath("//*[@id='TANF_WOTCAsst18M_YES']");
	public static final By TANF_WOTC_NO = By.xpath("//*[@id='TANF_WOTCAsst18M_NO']");
	public static final By TANF_WOTC_NO_ANS = By.xpath("//*[@id='TANF_WOTCAsst18M_NULL']");
			
	public static final By WELFARE_PRIMARY_RECIPIENT = By.xpath("//div[@class='question_title'][1]//span[2][text()='Primary Recipient']/ancestor::div[1]/following::input[1]");
	public static final By WELFARE_CITY = By.xpath("//div[@class='question_title'][1]//span[2][text()='City']/ancestor::div[1]/following::input[1]");
	public static final By WELFARE_STATE = By.xpath("//div[@class='question_title'][1]//span[2][text()='State']/../following-sibling::div[@class='row']//select");

	//Supplemental Security Income page locators	
	public static final By SSI_YES = By.xpath("//*[@id='SSI_YES']");
	public static final By SSI_NO = By.xpath("//*[@id='SSI_NO']");
	public static final By SSI_NO_ANS = By.xpath("//*[@id='SSI_NULL']");
	
	//Felony page locators	
	public static final By FELONY_CONVICTAED_YES = By.xpath("//*[@id='Felony_Convicted_YES']");
	public static final By FELONY_CONVICTAED_NO = By.xpath("//*[@id='Felony_Convicted_NO']");
	public static final By FELONY_CONVICTAED_NO_ANS = By.xpath("//*[@id='Felony_Convicted_NULL']");
	
	public static final By FELONY_RELEASE_PROG_YES = By.xpath("//*[@id='Felony_ReleaseProgram_YES']");
	public static final By FELONY_RELEASE_PROG_NO = By.xpath("//*[@id='Felony_ReleaseProgram_YES']");
	public static final By FELONY_RELEASE_PROG_NO_ANS = By.xpath("//*[@id='Felony_ReleaseProgram_YES']");
	
	public static final By FELONY_CONV_TYPE_YESFED = By.xpath("//*[@id='Felony_ConvType_YESFED']");
	public static final By FELONY_CONV_TYPE_YESFTA = By.xpath("//*[@id='Felony_ConvType_YESSTA']");
	public static final By FELONY_CONV_TYPE_NONE = By.xpath("//*[@id='Felony_ConvType_NONE']");
	
	public static final By FELONY_COVICTION_DATE = By.xpath("//div[@class='question_title'][1]//span[2][text()='Conviction Date (MM/YYYY)']/ancestor::div[1]/following::input[1]");
	public static final By FELONY_RELEASE_DATE = By.xpath("//div[@class='question_title'][1]//span[2][text()='Release Date (MM/YYYY)']/ancestor::div[1]/following::input[1]");
	public static final By FELONY_INMATE = By.xpath("//div[@class='question_title'][1]//span[2][text()='Inmate#']/ancestor::div[1]/following::input[1]");
	public static final By FELONY_CITY = By.xpath("//div[@class='question_title'][1]//span[2][text()='City']/ancestor::div[1]/following::input[1]");
	public static final By FELONY_STATE = By.xpath("//div[@class='question_title'][1]//span[2][text()='State']/../following-sibling::div[@class='row']//select");
	public static final By FELONY_PROBATION_OFFICER = By.xpath("//div[@class='question_title'][1]//span[2][text()='Probation Officer']/ancestor::div[1]/following::input[1]");
	public static final By FELONY_PROBATION_OFFICER_PHONE = By.xpath("//div[@class='question_title'][1]//span[2][text()='Probation Officer Phone']/ancestor::div[1]/following::input[1]");

	//click

	public static final By MAIL_IN_SERCH_CLICK= By.xpath("(//INPUT[@type='text'])[1]");
}
