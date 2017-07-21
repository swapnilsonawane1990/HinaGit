package adp.tcs.automation.locators;

import org.openqa.selenium.By;

/**
 * Created by Thorasa on 10/04/2016.
 */
public class ManualKeyLocators {
	public static final By MANUAL_KEY_LINK_ON_DATA_ENTRY_POPUP = By.xpath("//a[text()='WOTC Manual Key From Paper']");
	
	public static final By COMPANY_NAME_INPUT_FIELD_ON_MANUAL_KEY_PAGE = By.xpath("//input[@id='companySearch']");
	
	public static final By UNIT_SEARCH_ICON_ON_MANUAL_KEY_PAGE = By.xpath("//i[@class='fa fa-search popup_help']");
	
	public static final By START_SCREENING_BTN_ON_MANUAL_KEY_PAGE = By.xpath("//div[@class='table-data-container']//div[2]/button[1]");
	
	
	// Form Revision Page	
	public static final By FORM_REVISION_QUE_August_2009_RADIO_BTN = By.xpath("//input[@id='FormRevisionQuestion_August_2009_(2010_RFV)']");
	public static final By FORM_REVISION_QUE_JANUARY_2009_RADIO_BTN = By.xpath("//input[@id='FormRevisionQuestion_January_2012_(2012_RFV)']");
	public static final By FORM_REVISION_QUE_JUNE_2009_RADIO_BTN = By.xpath("//input[@id='FormRevisionQuestion_June_2015_(2015_RFV)']");
	public static final By continueButton = By.xpath("//*[@id='continuebutton']");
	
	// Personal Information Page
	public static final By PERSONAL_INFO_FIRST_NAME= By.xpath("//*[@id='question']//div[9]/input");
	public static final By PERSONAL_INFO_MIDDLE_NAME= By.xpath("//*[@id='question']//div[16]/input");
	public static final By PERSONAL_INFO_LAST_NAME= By.xpath("//*[@id='question']//div[23]/input");
	public static final By PERSONAL_INFO_SSN= By.xpath("//*[@id='question']//div[30]/input");
	
	public static final By PERSONAL_INFO_STREET_ADDRESS = By.xpath("//*[@id='question']//div[37]/input");
	public static final By PERSONAL_INFO_ZIP = By.xpath("//*[@id='question']//div[44]/input");
	public static final By PERSONAL_INFO_CITY = By.xpath("//*[@id='question']//div[72]/input");
	public static final By PERSONAL_INFO_STATE = By.xpath("//*[@id='question']/div[2]/div[58]/div[4]/div/select");
	public static final By PERSONAL_INFO_TELEPHONE = By.xpath("//*[@id='question']//div[65]/input");
	
	public static final By PERSONAL_INFO_DOB = By.xpath("//*[@id='question']//div[72]/input");
	
	public static final By PERSONAL_INFO_GAVE_INFO_DATE = By.xpath("//*[@id='question']//div[79]/input");
	public static final By PERSONAL_INFO_JOB_OFFER_DATE = By.xpath("//*[@id='question']//div[86]/input");
	public static final By PERSONAL_INFO_HIRE_DATE = By.xpath("//*[@id='question']//div[93]/input");
	public static final By PERSONAL_INFO_START_DATE = By.xpath("//*[@id='question']//div[100]/input");
	
	public static final By PERSONAL_INFO_MISSING_DATE = By.xpath("//*[@id='question']//div[107]/div[3]/input");
	
	public static final By PERSONAL_INFO_JOB_POSITION = By.xpath("//*[@id='question']/div[2]/div[114]/div[4]/div/select");
	public static final By PERSONAL_INFO_START_WAGE = By.xpath("//*[@id='question']//div[121]/input");
	
	// Confirm SSN Page
	public static final By CONFIRM_SSN_SSN_AGAIN = By.xpath("//*[@id='question']//div[2]/input");
	public static final By CONFIRM_SSN_CONFIRMATION_NUMBER = By.xpath("//*[@id='question']//div[9]/input");
	public static final By CONFIRM_SSN_OPERATOR_NAME = By.xpath("//*[@id='question']//div[16]/input");
	public static final By CONFIRM_SSN_TODAYS_DATE = By.xpath("//*[@id='question']//div[23]/input");
	
	// Manual Form 8850 Jun2015 RFV 2015
	
	public static final By FORM_8850_JUNE_2015_RFV_Q1 = By.xpath("//*[@id='question']//div[9]//input");
	
	public static final By FORM_8850_JUNE_2015_RFV_Q2 = By.xpath("//*[@id='question']//div[16]//input");
	public static final By WOTC_CV_WOTC_DV_WOTC_UV_BRANCH = By.xpath("//div[@class='question_title']/span/b[text()='WOTC V/WOTC DV/WOTC UV']/ancestor::div[1]/following::div[@class='question_title']//span[2][text()='Branch']/ancestor::div[1]/following::input[1]");
	public static final By WOTC_CV_WOTC_DV_WOTC_UV_STATE = By.xpath("//div[@class='question_title']/span/b[text()='WOTC V/WOTC DV/WOTC UV']/ancestor::div[1]/following::div[@class='question_title'][2]//span[2][text()='In what State did you receive the benefits']/../following-sibling::div[@class='row']//select");
	
	public static final By FORM_8850_JUNE_2015_RFV_Q3 = By.xpath("//*[@id='question']//div[23]//input");
	public static final By FORM_8850_JUNE_2015_RFV_Q4 = By.xpath("//*[@id='question']//div[30]//input");
	public static final By FORM_8850_JUNE_2015_RFV_Q5 = By.xpath("//*[@id='question']//div[37]//input");
	public static final By FORM_8850_JUNE_2015_RFV_Q6 = By.xpath("//*[@id='question']//div[44]//input");
	
	public static final By FORM_8850_JUNE_2015_RFV_Q7 = By.xpath("//*[@id='question']//div[51]//input");	
	public static final By WOTC_FS_PRIMARY_RECIPIENT_NAME = By.xpath("//div[@class='question_title']/span/b[text()='WOTC FS']/ancestor::div[1]/following::div[@class='question_title'][1]//span[2][text()='Primary Recipient']/ancestor::div[1]/following::input[1]");
	public static final By WOTC_FS_CITY = By.xpath("//div[@class='question_title']/span/b[text()='WOTC FS']/ancestor::div[1]/following::div[@class='question_title'][2]//span[2][text()='City']/ancestor::div[1]/following::input[1]");
	public static final By WOTC_FS_STATE = By.xpath("//div[@class='question_title']/span/b[text()='WOTC FS']/ancestor::div[1]/following::div[@class='question_title'][3]//span[2][text()='State']/../following-sibling::div[@class='row']//select");	
	
	public static final By FORM_8850_JUNE_2015_RFV_Q8 = By.xpath("//*[@id='question']//div[58]//input");
	public static final By WOTC_VR_STATE_LOCAL_AGENCY = By.xpath("//*[@id='VocationalRehab_VocRehab_YESSA']");
	public static final By WOTC_VR_VETERAN_ADMINISTRATION = By.xpath("//*[@id='VocationalRehab_VocRehab_YESVA']");
	public static final By WOTC_VR_TICKET_TO_WORK = By.xpath("//*[@id='VocationalRehab_VocRehab_YESTW']");	
	public static final By WOTC_VR_COUNSLER_NAME = By.xpath("//div[@class='question_title']/span/b[text()='WOTC VR']/ancestor::div[1]/following::div[@class='question_title'][2]//span[2][contains(text(),'Counselor')]/ancestor::div[1]/following::input[1]");
	public static final By WOTC_VR_CITY = By.xpath("//div[@class='question_title']/span/b[text()='WOTC VR']/ancestor::div[1]/following::div[@class='question_title'][3]//span[2][text()='City']/ancestor::div[1]/following::input[1]");
	public static final By WOTC_VR_STATE = By.xpath("//div[@class='question_title']/span/b[text()='WOTC VR']/ancestor::div[1]/following::div[@class='question_title'][4]//span[2][text()='State']/../following-sibling::div[@class='row']//select");	
	
	public static final By FORM_8850_JUNE_2015_RFV_Q9 = By.xpath("//*[@id='question']//div[65]//input");
	public static final By WOTC_W_PRIMARY_RECIPIENT_NAME = By.xpath("//div[@class='question_title']/span/b[text()='WOTC W']/ancestor::div[1]/following::div[@class='question_title'][1]//span[2][text()='Primary Recipient']/ancestor::div[1]/following::input[1]");
	public static final By WOTC_W_CITY = By.xpath("//div[@class='question_title']/span/b[text()='WOTC W']/ancestor::div[1]/following::div[@class='question_title'][2]//span[2][text()='City']/ancestor::div[1]/following::input[1]");
	public static final By WOTC_W_STATE = By.xpath("//div[@class='question_title']/span/b[text()='WOTC W']/ancestor::div[1]/following::div[@class='question_title'][3]//span[2][text()='State']/../following-sibling::div[@class='row']//select");	
	
	public static final By FORM_8850_JUNE_2015_RFV_Q10 = By.xpath("//*[@id='question']//div[72]//input");
	public static final By FORM_8850_JUNE_2015_RFV_Q11 = By.xpath("//*[@id='question']//div[79]//input");
	
	public static final By FORM_8850_JUNE_2015_RFV_Q12 = By.xpath("//*[@id='question']//div[86]//input");
	public static final By WOTC_F_FEDERAL_YES = By.xpath("//*[@id='Felony_ConvType_YESFED']");
	public static final By WOTC_F_STATE_YES = By.xpath("//*[@id='Felony_ConvType_YESSTA']");
	public static final By WOTC_F_NONE_YES = By.xpath("//*[@id='Felony_ConvType_NONE']");
	public static final By WOTC_F_CONVICTION_MONTH_YEAR = By.xpath("//div[@class='question_title']/span/b[text()='WOTC F']/ancestor::div[1]/following::div[@class='question_title'][2]//span[2][text()='Conviction month/year (ex. 10/1990)']/ancestor::div[1]/following::input[1]");
	public static final By WOTC_F_RELEASE_MONTH_YEAR = By.xpath("//div[@class='question_title']/span/b[text()='WOTC F']/ancestor::div[1]/following::div[@class='question_title'][3]//span[2][text()='Release month/year (ex. 10/1990)']/ancestor::div[1]/following::input[1]");
	public static final By WOTC_F_INMATE = By.xpath("//div[@class='question_title']/span/b[text()='WOTC F']/ancestor::div[1]/following::div[@class='question_title'][4]//span[2][text()='Inmate #']/ancestor::div[1]/following::input[1]");
	public static final By WOTC_F_CITY = By.xpath("//div[@class='question_title']/span/b[text()='WOTC F']/ancestor::div[1]/following::div[@class='question_title'][5]//span[2][text()='City']/ancestor::div[1]/following::input[1]");
	public static final By WOTC_F_STATE = By.xpath("//div[@class='question_title']/span/b[text()='WOTC F']/ancestor::div[1]/following::div[@class='question_title'][6]//span[2][text()='State']/../following-sibling::div[@class='row']//select");
	public static final By WOTC_F_PROBATION_OFFICER = By.xpath("//div[@class='question_title']/span/b[text()='WOTC F']/ancestor::div[1]/following::div[@class='question_title'][7]//span[2][text()='Probation Officer']/ancestor::div[1]/following::input[1]");
	public static final By WOTC_F_PROBATION_OFFICER_PHONE = By.xpath("//div[@class='question_title']/span/b[text()='WOTC F']/ancestor::div[1]/following::div[@class='question_title'][8]//span[2][text()='Probation Officer Phone #']/ancestor::div[1]/following::input[1]");	
	
	public static final By FORM_8850_JUNE_2015_RFV_Q13 = By.xpath("//*[@id='question']//div[93]//input");
	
	public static final By FORM_8850_JUNE_2015_RFV_Q14 = By.xpath("//*[@id='question']//div[100]//input");
	public static final By FORM_8850_JUNE_2015_RFV_Q15 = By.xpath("//*[@id='question']//div[107]//input");
	public static final By WOTC_LTUE_START_DATE_UNEMPL = By.xpath("//div[@class='question_title']/span/b[text()='WOTC LTUE']/ancestor::div[1]/following::div[@class='question_title'][1]//span[2][text()='What was the start date of your unemployment?']/ancestor::div[1]/following::input[1]");
	public static final By WOTC_LTUE_STATE = By.xpath("//div[@class='question_title']/span/b[text()='WOTC LTUE']/ancestor::div[1]/following::div[@class='question_title'][2]//span[2][text()='State']/../following-sibling::div[@class='row']//select");
	
	// Thank You page
	
	public static final By THANK_YOU_PAGE_TITLE = By.xpath("//*[@id='questions']/h2");
	public static final By EMPL_QULIFY_TEXT = By.xpath("//*[@id='question']/div[2]/div[2]/div[1]/span[2]");
	public static final By SCREENING_COMPLETED_TEXT = By.xpath("//*[@id='question']//div[9]//span[2]/b");
	
	// Manual Form 8850 August 2009 RFV 2009
	
	
	public static final By FORM_8850_Aug_2009_RFV_Q16 = By.xpath("//*[@id='question']//div[114]//input");
	public static final By FORM_8850_Aug_2009_RFV_Q17 = By.xpath("//*[@id='question']//div[121]//input");
	public static final By FORM_8850_Aug_2009_RFV_Q18 = By.xpath("//*[@id='question']//div[128]//input");
	public static final By FORM_8850_Aug_2009_RFV_Q19 = By.xpath("//*[@id='question']//div[135]//input");
	public static final By FORM_8850_Aug_2009_RFV_Q20 = By.xpath("//*[@id='question']//div[142]//input");
	public static final By FORM_8850_Aug_2009_RFV_Q21 = By.xpath("//*[@id='question']//div[149]//input");
	public static final By FORM_8850_Aug_2009_RFV_Q22 = By.xpath("//*[@id='question']//div[156]//input");
	public static final By FORM_8850_Aug_2009_RFV_Q23 = By.xpath("//*[@id='question']//div[163]//input");
	public static final By FORM_8850_Aug_2009_RFV_Q24 = By.xpath("//*[@id='question']//div[170]//input");
	
	
	public static final By WOTC_CV_WOTC_DV_WOTC_UV_BRANCH_SERVICE = By.xpath("//div[@class='question_title']/span/b[text()='WOTC V/WOTC DV/WOTC UV']/ancestor::div[1]/following::div[@class='question_title']//span[2][text()='Branch of Service']/ancestor::div[1]/following::input[1]");
	public static final By WOTC_CV_WOTC_DV_WOTC_UV_START_MONTH_YEAR = By.xpath("//div[@class='question_title']/span/b[text()='WOTC V/WOTC DV/WOTC UV']/ancestor::div[1]/following::div[@class='question_title']//span[2][text()='Service start month/year (ex. 10/1990)']/ancestor::div[1]/following::input[1]");
	public static final By WOTC_CV_WOTC_DV_WOTC_UV_SERVICE_END_MONTH_YEAR = By.xpath("//div[@class='question_title']/span/b[text()='WOTC V/WOTC DV/WOTC UV']/ancestor::div[1]/following::div[@class='question_title']//span[2][text()='Service end month/year (ex. 10/1990)']/ancestor::div[1]/following::input[1]");
	public static final By WOTC_CV_WOTC_DV_WOTC_UV_STATE_BENIFITS = By.xpath("//div[@class='question_title']/span/b[text()='WOTC V/WOTC DV/WOTC UV']/ancestor::div[1]/following::div[@class='question_title'][4]//span[2][text()='In what State did you receive the benefits']/../following-sibling::div[@class='row']//select");

	public static final By WOTC_FS_PRIMARY_FOOD_STAMPS_RECIPIENT = By.xpath("//div[@class='question_title']/span/b[text()='WOTC FS']/ancestor::div[1]/following::div[@class='question_title'][1]//span[2][text()='Name of primary food stamp recipient']/ancestor::div[1]/following::input[1]");
	
	public static final By STATE_QUESTIONS_TEXT = By.xpath("//div[@class='question_title']/span/b[text()='State Questions']");


	public static final By WOTC_W_PRIMARY_RECIPIENT_CHILD_NAME = By.xpath("//div[@class='question_title']/span/b[text()='WOTC W']/ancestor::div[1]/following::div[@class='question_title'][1]//span[2][contains(text(),'housing or transportation assistance')]/ancestor::div[1]/following::input[1]");
	public static final By WOTC_W_RELATION_TO_YOU = By.xpath("//div[@class='question_title']/span/b[text()='WOTC W']/ancestor::div[1]/following::div[@class='question_title'][2]//span[2][text()='Relation to you']/ancestor::div[1]/following::input[1]");
	public static final By WOTC_W_AUG_2009_CITY = By.xpath("//div[@class='question_title']/span/b[text()='WOTC W']/ancestor::div[1]/following::div[@class='question_title'][3]//span[2][text()='City']/ancestor::div[1]/following::input[1]");
	public static final By WOTC_W_AUG_2009_STATE = By.xpath("//div[@class='question_title']/span/b[text()='WOTC W']/ancestor::div[1]/following::div[@class='question_title'][4]//span[2][text()='State']/../following-sibling::div[@class='row']//select");	


	public static final By WOTC_F_AUG_2009_CONVICTION_DATE = By.xpath("//div[@class='question_title']/span/b[text()='WOTC F']/ancestor::div[1]/following::div[@class='question_title'][1]//span[2][text()='Conviction date']/ancestor::div[1]/following::input[1]");
	public static final By WOTC_F_AUG_2009_RELEASE_MONTH_YEAR = By.xpath("//div[@class='question_title']/span/b[text()='WOTC F']/ancestor::div[1]/following::div[@class='question_title'][3]//span[2][text()='Release month/year (ex. 10/1990)']/ancestor::div[1]/following::input[1]");
	public static final By WOTC_F_AUG_2009_WORK_RELEASE_PROG = By.xpath("//div[@class='question_title']/span/b[text()='WOTC F']/ancestor::div[1]/following::div[@class='question_title'][4]//span[2][text()='Work Release Program Start']/ancestor::div[1]/following::input[1]");
	public static final By WOTC_F_AUG_2009_CITY = By.xpath("//div[@class='question_title']/span/b[text()='WOTC F']/ancestor::div[1]/following::div[@class='question_title'][5]//span[2][text()='City']/ancestor::div[1]/following::input[1]");
	public static final By WOTC_F_AUG_2009_PROBATION_OFFICER = By.xpath("//div[@class='question_title']/span/b[text()='WOTC F']/ancestor::div[1]/following::div[@class='question_title'][6]//span[2][contains(text(),'Probation/Parole')]/ancestor::div[1]/following::input[1]");
	public static final By WOTC_F_AUG_2009_PROBATION_OFFICER_PHONE = By.xpath("//div[@class='question_title']/span/b[text()='WOTC F']/ancestor::div[1]/following::div[@class='question_title'][7]//span[2][contains(text(),'PO')]/ancestor::div[1]/following::input[1]");
	
	
	public static final By WOTC_VR_AUG_2009_COUNSLER_NAME = By.xpath("//div[@class='question_title']/span/b[text()='WOTC VR']/ancestor::div[1]/following::div[@class='question_title'][4]//span[2][contains(text(),'Counselor')]/ancestor::div[1]/following::input[1]");
	public static final By WOTC_VR_AUG_2009_COUNSLER_PHONE = By.xpath("//div[@class='question_title']/span/b[text()='WOTC VR']/ancestor::div[1]/following::div[@class='question_title'][5]//span[2][contains(text(),'Phone #')]/ancestor::div[1]/following::input[1]");
	public static final By WOTC_VR_AUG_2009_CITY = By.xpath("//div[@class='question_title']/span/b[text()='WOTC VR']/ancestor::div[1]/following::div[@class='question_title'][2]//span[2][text()='Vocational rehabilitation services location: City']/ancestor::div[1]/following::input[1]");
	public static final By WOTC_VR_AUG_2009_STATE = By.xpath("//div[@class='question_title']/span/b[text()='WOTC VR']/ancestor::div[1]/following::div[@class='question_title'][3]//span[2][text()='State']/../following-sibling::div[@class='row']//select");	
	
	public static final By WOTC_FS25_AUG_2009_FOOD_RECIPIENT = By.xpath("//div[@class='question_title']/span/b[text()='WOTC FS25']/ancestor::div[1]/following::div[@class='question_title'][1]//span[2][contains(text(),'Name of primary Food Stamps recipient')]/ancestor::div[1]/following::input[1]");
	public static final By WOTC_FS25_AUG_2009_RELATION = By.xpath("//div[@class='question_title']/span/b[text()='WOTC VR']/ancestor::div[1]/following::div[@class='question_title'][5]//span[2][contains(text(),'Phone #')]/ancestor::div[1]/following::input[1]");
	public static final By WOTC_FS25_AUG_2009_CITY = By.xpath("//div[@class='question_title']/span/b[text()='WOTC FS25']/ancestor::div[1]/following::div[@class='question_title'][3]//span[2][contains(text(),'City where benefits were received')]/ancestor::div[1]/following::input[1]");
	public static final By WOTC_FS25_AUG_2009_STATE = By.xpath("//div[@class='question_title']/span/b[text()='WOTC FS25']/ancestor::div[1]/following::div[@class='question_title'][4]//span[2][text()='State where benefits were received']/../following-sibling::div[@class='row']//select");	
	
}
