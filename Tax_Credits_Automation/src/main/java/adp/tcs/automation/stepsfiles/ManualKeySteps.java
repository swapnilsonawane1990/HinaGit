package adp.tcs.automation.stepsfiles;

import adp.tcs.automation.locators.ManualKeyLocators;
import adp.tcs.automation.pages.EditPersonalInformation;
import adp.tcs.automation.pages.ManualKeyPages;
import adp.tcs.automation.pages.MonitoringPages;
import adp.tcs.automation.pages.SearchSSNthroughHub;
import adp.tcs.automation.utilities.ExcelReaderWriter;
import adp.tcs.automation.utilities.WndowAction;
import adp.tcs.automation.utilities.randomSSNgenrater;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ManualKeySteps extends BaseTempletSteps{	
	
	private final SearchSSNthroughHub hub = new SearchSSNthroughHub();
    private final WndowAction windowAct = new WndowAction();
    private final MonitoringPages monitorElements = new MonitoringPages();
    private final ManualKeyPages manualKeyElements= new ManualKeyPages();
    private final HubValidationsSteps hubValidationsSteps = new HubValidationsSteps();
    private final EditPersonalInformation editPersonalInformation = new EditPersonalInformation();
    private randomSSNgenrater ssnGenerator = new randomSSNgenrater();
	private ExcelReaderWriter excelReaderWriter = new ExcelReaderWriter();
	private Manager_Hire_Steps mgrHire = new Manager_Hire_Steps();
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	Date date = new Date();
    
	public void gotoManualKeyFromPaperPage() {
		try {			
			hub.navigateBackOffice();
	        monitorElements.data_Entry_Link().click();
	        sleep(2000);
	        manualKeyElements.manulKeyLinkOnDataEntry().click();

			sleep(3000);
			userClick(monitorElements.data_Entry_Link());
			sleep(2000);
			userClick(manualKeyElements.manulKeyLinkOnDataEntry());
			sleep(2000);
			if(!isDisplayed(manualKeyElements.companyNameInputFieldsOnManualKeyPage())) {
				for (int i = 1; i <= 10; i++) {
					userClick(monitorElements.data_Entry_Link());
					sleep(2000);
					userClick(manualKeyElements.manulKeyLinkOnDataEntry());
					sleep(2000);
					if (isDisplayed(manualKeyElements.companyNameInputFieldsOnManualKeyPage())) {
						break;
					}
				}
			}
             getDriver().findElement(By.xpath("//div[@class=\"form-data-container ng-scope\"]")).click();
			//Actions action = new Actions(driver);
			//  WebElement mainMenu = driver.findElement(By.linkText("MainMenu"));
			//action.moveToElement( monitorElements.data_Entry_Link()).moveToElement(manualKeyElements.manulKeyLinkOnDataEntry()).click().build().perform();
	        sleep(2000);
		} catch (Exception e) {			
			e.printStackTrace();
			verifyTest("User is on hub page -- gotoManualKeyFromPaperPage() ", false);
		}
	}
	/*
	This method is used for Performing Manual Key In from Paper.
	 */
	@When("Perform manaul Key from paper screening")
	public void manaulKeyFromPaperScreening(@Named("CurrentDate") String currentDate) {
		try {
			verifyTest("Perform manaul Key from paper screening");
			sleep(10000);
			waitForLoad();
			gotoManualKeyFromPaperPage();			
			manualKeyElements.companyNameInputFieldsOnManualKeyPage().sendKeys(getExcelData().get("COMPANY_NAME"));
			editPersonalInformation.edit_Company_Select().click();			
			hubValidationsSteps.unitNameSelection(getExcelData().get("UNIT_LOCATION"));
			sleep(2000);
			waitForLoad();
			//manualKeyElements.startScreeningBtnOnManualKeyPage().click();
			sleep(4000);
			waitForLoad();			
		//	windowAct.switchtoMultiChildWindow(manualKeyElements.startScreeningBtnOnManualKeyPage());
			windowAct.switchtoWindowForManualKey(manualKeyElements.startScreeningBtnOnManualKeyPage());
			sleep(5000);
			waitForLoad();
			performFormRevisionPageActions();
			sleep(2000);
			waitForLoad();
			performPersonalInfoPageActions(currentDate);
			sleep(2000);
			waitForLoad();
			performConfirmSsnPageActions();
			sleep(2000);
			waitForLoad();
			if(getExcelData().get("VERSION_FORM_8850_RFV").equals("AUGUST 2009 (2010 RFV)")) {
				performManaulForm8850Aug2009RFVPageActions();
				waitForLoad();
			}
			if(getExcelData().get("VERSION_FORM_8850_RFV").equals("JANUARY 2012 (2012 RFV)")) {
				performManaulForm8850Jan2012RFVPageActions();
				waitForLoad();
			}
			if(getExcelData().get("VERSION_FORM_8850_RFV").equals("JUNE 2015 (2015 RFV)")) {
				performManaulForm8850June2015RFVPageActions();
				waitForLoad();
			}
			sleep(2000);
			verifyThankYouPage();
			//getConfirmationNumber();
			excelReaderWriter.writeSSNAndConfirmationNumber();
			System.out.println("Screening Completed!!!  SSN : "+ getExcelData().get("SSN"));
		} catch (Exception e) {			
			e.printStackTrace();
			verifyTest("Perform manaul Key from paper screening : manaulKeyFromPaperScreening()", false);
		}
	}
	
	public void performFormRevisionPageActions(){
        try {
        	sleep(2000);
			if(getExcelData().get("VERSION_FORM_8850_RFV").equals("AUGUST 2009 (2010 RFV)")) {
				manualKeyElements.formRevisionQuestion_August_2009().click();
			}
			if(getExcelData().get("VERSION_FORM_8850_RFV").equals("JANUARY 2012 (2012 RFV)")) {
				manualKeyElements.formRevisionQuestion_January_2012().click();
			}
			if(getExcelData().get("VERSION_FORM_8850_RFV").equals("JUNE 2015 (2015 RFV)")) {
				manualKeyElements.formRevisionQuestion_June_2015().click();
			}
			
		} catch (Exception e) {			
			e.printStackTrace();
			verifyTest("Faliure in performFormRevisionPageActions page",false);
		}
    }
	
	public void performPersonalInfoPageActions(String currentDate){
        try {

			String currentDatet = String.valueOf(dateFormat.format(date));
			System.out.println(currentDatet);
        	String ssn = String.valueOf(ssnGenerator.generateSSN());
			getExcelData().put("SSN", ssn);
			getExcelData().put("CSSN", ssn);			
			manualKeyElements.personalInfoFirstName().sendKeys(getExcelData().get("FNAME"));
			manualKeyElements.personalInfoMiddleName().sendKeys(getExcelData().get("MNAME"));
			manualKeyElements.personalInfoLastName().sendKeys(getExcelData().get("LNAME"));
			manualKeyElements.personalInfoSsn().sendKeys(getExcelData().get("SSN"));
			manualKeyElements.personalInfoStreetAddress().sendKeys(getExcelData().get("HOME_STREET_ADDRESS"));
			manualKeyElements.personalInfoZip().sendKeys(getExcelData().get("ZIP"));
			//manualKeyElements.personalInfoCity().sendKeys(getExcelData().get("CITY"));
			//selectDropdown(manualKeyElements.personalInfoState(),getExcelData().get("STATE"));
			manualKeyElements.personalInfoTelephone().sendKeys(getExcelData().get("TELEPHONE"));			
			manualKeyElements.personalInfoDOB().sendKeys(getExcelData().get("DOB"));
			if(currentDate.equalsIgnoreCase("Y")){
				manualKeyElements.personalInfoGaveInfoDate().sendKeys(currentDatet);
				manualKeyElements.personalInfoJobOfferDate().sendKeys(currentDatet);
				manualKeyElements.personalInfoHireDate().sendKeys(currentDatet);
				manualKeyElements.personalInfoStartDate().sendKeys(currentDatet);
			}else {
				manualKeyElements.personalInfoGaveInfoDate().sendKeys(getExcelData().get("HIRE_GAVE_INFO_DATE"));
				manualKeyElements.personalInfoJobOfferDate().sendKeys(getExcelData().get("HIRE_JOB_OFFER_DATE"));
				manualKeyElements.personalInfoHireDate().sendKeys(getExcelData().get("HIRE_DATE"));
				manualKeyElements.personalInfoStartDate().sendKeys(getExcelData().get("HIRE_START_DATE"));
			}
			if(!getExcelData().get("MISSING_HIRE_START_DATE_CHECK").equals("NO")) {
				manualKeyElements.personalInfoMissingDate().click();
			}			
			selectDropdown(manualKeyElements.personalInfoJobPosition(),getExcelData().get("HIRE_JOB_POSITION"));
			manualKeyElements.personalInfoStartWage().sendKeys(getExcelData().get("HIRE_WAGE"));			
			manualKeyElements.form_Revision_Continue_Button().click();
			waitForLoad();
		} catch (Exception e) {
			e.printStackTrace();
			verifyTest("Faliure in performPersonalInfoPageActions page",false);			
		}
    }
	
	public void performConfirmSsnPageActions(){
        try {        	
			manualKeyElements.confirmSSNAgain().sendKeys(getExcelData().get("SSN"));
			manualKeyElements.confirmSSNConfirmationNumber().sendKeys(getExcelData().get("CSSN"));
			manualKeyElements.confirmSSNOperatorName().sendKeys(getExcelData().get("OPERATOR_NAME"));
			manualKeyElements.confirmSSNTodaysDate().sendKeys(currentdate());				
			manualKeyElements.form_Revision_Continue_Button().click();
			sleep(3000);
			waitForLoad();
			
		} catch (Exception e) {			
			e.printStackTrace();
			verifyTest("Faliure in performConfirmSsnPageActions page",false);
		}
    }
	
	public void performManaulForm8850June2015RFVPageActions(){
        try {        	
        	boolean isWOTCCvEnabled = false;
        	boolean isWOTCFsEnabled = false;
        	boolean isWOTCVrEnabled = false;
        	boolean isWOTCWEnabled = false;
        	boolean isWOTCFEnabled = false;
        	boolean isWOTCLTUEEnabled = false;
        	boolean isWOTCLTUEBothEnabled = false;  
        	
        	if(getExcelData().get("Have you previously worked for Motox?").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ1().click();
        	}
        	if(getExcelData().get("1a- Are you a veteran of the US Armed Forces?").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ2().click();
        		isWOTCCvEnabled = true;       		
        		
        	}
        	if(getExcelData().get("1b- Are you entitled to receive compensation for a service connected disability?").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ3().click();
        	}
        	if(getExcelData().get("Were you discharged or released from active duty from the armed forces in the past year?").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ4().click();
        	}
        	if(getExcelData().get("Were you unemployed for a combined total of at least 4 weeks but less than 6 months in the past year?").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ5().click();
        	}
        	if(getExcelData().get("Were you unemployed for a combined total of 6 months or more in the past year?").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ6().click();
        	}
        	if(getExcelData().get("2a- Have you or a family member (while living in your houseland) received Food Stamps anytime within the last 15 months?").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ7().click();        		
        		isWOTCFsEnabled = true;        		
        	}
        	if(getExcelData().get("3a - Have you participated in a vocational rehabilitation program?").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ8().click();      		
        		isWOTCVrEnabled = true;       		
        	}
        	
        	if(getExcelData().get("4a - Are you a member or a family that received Welfare (AFDC or TANF)").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ9().click();
        		isWOTCWEnabled = true;       		
        	}
        	if(getExcelData().get("5a - Did you receive Supplemental Security Income (SSI) within the last 90 days?").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ10().click();
        	}
        	if(getExcelData().get("6a - Are you currently receiving Social Security Administration disability benefits (SSDI)?").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ11().click();
        	}
        	
        	if(getExcelData().get("7a - Have you been convicted of a felony or have you received deferred adjudication for a felony?").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ12().click();
        		isWOTCFEnabled = true;
        	}
        	if(getExcelData().get("7b - Were you released, or did you start a work release program or transition center within the past 12 months?").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ13().click();
        	}        	
        	
        	if(getExcelData().get("Have you been continuously unemployed for the last 27 weeks (since at least 03/29/2016)?").equals("YES") &&
        			getExcelData().get("During your period of unemployment, did you, at any time, receive State or Federal unemployment compensation?").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ14().click();
        		manualKeyElements.form8850June2015RFVQ15().click();
        		isWOTCLTUEBothEnabled = true;        		
        	}else{
        	if(getExcelData().get("Have you been continuously unemployed for the last 27 weeks (since at least 03/29/2016)?").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ14().click();
        		isWOTCLTUEEnabled = true;
        	}
        	
        	if(getExcelData().get("During your period of unemployment, did you, at any time, receive State or Federal unemployment compensation?").equals("YES")){        		
        		manualKeyElements.form8850June2015RFVQ15().click();
        		isWOTCLTUEEnabled = true;
        	}        	
        	}
        	
        	if(isWOTCCvEnabled){
    			if(isDisplayed(ManualKeyLocators.WOTC_CV_WOTC_DV_WOTC_UV_BRANCH)){		
    				wotc_CV_PageActions();
    			}else{
    				manualKeyElements.form_Revision_Continue_Button().click();
    				sleep(2000);
    				wotc_CV_PageActions();
    			}    			
    		}
        	
        	if(isWOTCFsEnabled){        		
        		if(isDisplayed(ManualKeyLocators.WOTC_FS_PRIMARY_RECIPIENT_NAME)){	
        			wotc_FS_PageActions();
        		}else{
        			manualKeyElements.form_Revision_Continue_Button().click();
        			sleep(2000);
        			wotc_FS_PageActions();
        		}
    		}
        	
        	if(isWOTCVrEnabled){        		
        		if(isDisplayed(ManualKeyLocators.WOTC_VR_STATE_LOCAL_AGENCY)){        			
        			wotc_VR_PageActions();
        		}else{
        			manualKeyElements.form_Revision_Continue_Button().click();
        			sleep(2000);
    			wotc_VR_PageActions();
        		}
    		}
        	
        	if(isWOTCWEnabled){
        		if(isDisplayed(ManualKeyLocators.WOTC_W_PRIMARY_RECIPIENT_NAME)){        			
        			wotc_W_PageActions();
        		}else{
        			manualKeyElements.form_Revision_Continue_Button().click();
        			sleep(2000);
        			wotc_W_PageActions();
        		}        		
    		}
        	
        	if(isWOTCFEnabled){
        		if(isDisplayed(ManualKeyLocators.WOTC_F_FEDERAL_YES)){        			
        			wotc_F_PageActions();
        		}else{
        			manualKeyElements.form_Revision_Continue_Button().click();
        			sleep(2000);
        			wotc_F_PageActions();
        			
        		}        		
    		}
        	
        	if(isWOTCLTUEEnabled){
        		if(isDisplayed(ManualKeyLocators.WOTC_LTUE_START_DATE_UNEMPL)){        			
        			wotc_LTUE_PageActions();
        		}else{
        			manualKeyElements.form_Revision_Continue_Button().click();
        			sleep(2000);
        			wotc_LTUE_PageActions();
        		}        		
    		}
        	
        	if(isWOTCLTUEBothEnabled){
        		if(isDisplayed(ManualKeyLocators.WOTC_LTUE_START_DATE_UNEMPL)){        			
        			wotc_LTUE_PageActions();
        		}else{ 
        			manualKeyElements.form_Revision_Continue_Button().click();
        			sleep(2000);
        			wotc_LTUE_PageActions();
        		}  
    		}
        	
			if(isDisplayed(ManualKeyLocators.continueButton)){
			manualKeyElements.form_Revision_Continue_Button().click();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			verifyTest("Faliure in performManaulForm8850June2015RFVPageActions page",false);			
		}
    }
	
	public void wotc_CV_PageActions() {
		try {
			manualKeyElements.wotcCVBranch().sendKeys(getExcelData().get("WOTC_CV/WOTC_DV/WOTC_UV_BRANCH"));			
			if(isDisplayed(ManualKeyLocators.WOTC_CV_WOTC_DV_WOTC_UV_STATE)){
				selectDropdownByValue(manualKeyElements.wotcCVState(),getExcelData().get("WOTC_FS_STATE"));
			}
			
		} catch (Exception e) {			
			verifyTest("Manual Form 8850 Jun2015 RFV 2015 Page -- wotc_CV_PageActions() ", false);
			e.printStackTrace();
		}
	}
	
	public void wotc_FS_PageActions() {
		try {
			manualKeyElements.wotcFsPrimaryRecipientName().sendKeys(getExcelData().get("WOTC_FS_PRIMARY_RECIPIENT_NAME"));
    		manualKeyElements.wotcFsCity().sendKeys(getExcelData().get("WOTC_FS_CITY"));
    		selectDropdownByValue(manualKeyElements.wotcFsState(),getExcelData().get("WOTC_FS_STATE"));
		} catch (Exception e) {			
			e.printStackTrace();
			verifyTest("Manual Form 8850 Jun2015 RFV 2015 Page -- wotc_FS_PageActions() ", false);
		}
	}
	
	public void wotc_VR_PageActions() {
		try {
			if(getExcelData().get("WOTC_VR_IF_YES").equals("STATE/LOCAL AGENCY")) {
    			manualKeyElements.wotcVrStateLocalAgency().click();
			}
			if(getExcelData().get("WOTC_VR_IF_YES").equals("VETERAN ADMINISTRATION")) {
				manualKeyElements.wotcVrVeteranAdministration().click();
			}
			if(getExcelData().get("WOTC_VR_IF_YES").equals("TICKET TO WORK")) {
				manualKeyElements.wotcVrTicketToWork().click();
			}
    		
			manualKeyElements.wotcVrCounslerName().sendKeys(getExcelData().get("WOTC_VR_COUNSLER_NAME"));
			manualKeyElements.wotcVrCity().sendKeys(getExcelData().get("WOTC_VR_CITY"));
			selectDropdownByValue(manualKeyElements.wotcVrState(),getExcelData().get("WOTC_VR_STATE"));
		} catch (Exception e) {	
			e.printStackTrace();
			verifyTest("Manual Form 8850 Jun2015 RFV 2015 Page -- wotc_VR_PageActions() ", false);
			
		}
	}
	
	public void wotc_W_PageActions() {
		try {
			manualKeyElements.wotWPrimarryRecipientName().sendKeys(getExcelData().get("WOTC_W_PRIMARY_RECIPIENT_NAME"));
    		manualKeyElements.wotcWCity().sendKeys(getExcelData().get("WOTC_W_CITY"));
    		selectDropdownByValue(manualKeyElements.wotcWState(),getExcelData().get("WOTC_W_STATE"));
		} catch (Exception e) {	
			e.printStackTrace();
			verifyTest("Manual Form 8850 Jun2015 RFV 2015 Page -- wotc_W_PageActions() ", false);
			
		}
	}
	
	public void wotc_F_PageActions() {
		try {
			if(getExcelData().get("WOTC_F_CONVICTION").equals("FEDERAL")) {
    			manualKeyElements.wotcFFederalYes().click();
			}
			if(getExcelData().get("WOTC_F_CONVICTION").equals("STATE")) {
				manualKeyElements.wotcFStateYes().click();
			}
			if(getExcelData().get("WOTC_F_CONVICTION").equals("NONE (DEFERRED ADJUDICATION)")) {
				manualKeyElements.wotcFNoneYes().click();
			}
			manualKeyElements.wotcFConvictionMonthYear().sendKeys(getExcelData().get("WOTC_F_CONVICTION_MONTH_YEAR"));
			manualKeyElements.wotcFReleaseMonthYear().sendKeys(getExcelData().get("WOTC_F_RELEASE_MONTH_YEAR"));
			manualKeyElements.wotcFInmate().sendKeys(getExcelData().get("WOTC_F_INMATE"));
			manualKeyElements.wotcFCity().sendKeys(getExcelData().get("WOTC_F_CITY"));
			selectDropdownByValue(manualKeyElements.wotcFState(),getExcelData().get("WOTC_F_STATE"));
			manualKeyElements.wotcFProbationOfficer().sendKeys(getExcelData().get("WOTC_F_PROBATION_OFFICER"));
			manualKeyElements.wotcFProbationOfficerPhone().sendKeys(getExcelData().get("WOTC_F_PROBATION_OFFICER_PHONE"));
		} catch (Exception e) {			
			e.printStackTrace();
			verifyTest("Manual Form 8850 Jun2015 RFV 2015 Page -- wotc_F_PageActions() ", false);
		}
	}
	
	public void wotc_LTUE_PageActions() {
		try {
			manualKeyElements.wotcLtueStartDateUnempl().sendKeys(getExcelData().get("WOTC_LTUE_START_DATE_UNEMPL"));
			selectDropdownByValue(manualKeyElements.wotcLtueState(),getExcelData().get("WOTC_LTUE_STATE")); 
		} catch (Exception e) {			
			e.printStackTrace();
			verifyTest("Manual Form 8850 Jun2015 RFV 2015 Page -- wotc_LTUE_PageActions() ", false);
		}
	}

	
	public void verifyThankYouPage() {
		try {			
			String thankText = manualKeyElements.thankYouPageTitle().getText();
			String empQulify = manualKeyElements.emplQulifyText().getText();
			String screeningCompleted = manualKeyElements.screeningCompletedText().getText();			
			if(!thankText.equals("Thank You Page") || !empQulify.equals(getExcelData().get("QULIFY_TEXT")) || 
					!screeningCompleted.equals("Screening completed - thank you! You can safely close this window/tab now.")){
				verifyTest("Thank you page from manual key is not matching", false);
			}			
		} catch (Exception e) {			
			e.printStackTrace();
			verifyTest("Manual Form 8850 Jun2015 RFV 2015 Page -- wotc_LTUE_PageActions() ", false);
		}
	}
	
	public void performManaulForm8850Jan2012RFVPageActions(){
        try {        	
        	boolean isWOTCCvEnabled = false;
        	boolean isWOTCFsEnabled = false;
        	boolean isWOTCVrEnabled = false;
        	boolean isWOTCWEnabled = false;
        	boolean isWOTCFEnabled = false;        	
        	
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q1").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ1().click();
        		isWOTCCvEnabled = true;       		
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q2").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ2().click();
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q3").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ3().click();
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q4").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ4().click();
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q5").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ5().click();
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q6").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ6().click();        		
        		isWOTCFsEnabled = true;        		
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q7").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ7().click();      		
        		isWOTCVrEnabled = true;       		
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q8").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ8().click();
        		isWOTCWEnabled = true;       		
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q9").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ9().click();
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q10").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ10().click();
        	}
        	
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q11").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ11().click();
        		isWOTCFEnabled = true;
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q12").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ12().click();
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q13").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ13().click();
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q14").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ14().click();
        	}
        	
        	if(isWOTCCvEnabled){
    			if(isDisplayed(ManualKeyLocators.WOTC_CV_WOTC_DV_WOTC_UV_BRANCH)){		
    				wotc_CV_PageActions();
    			}else{
    				manualKeyElements.form_Revision_Continue_Button().click();
    				sleep(2000);
    				wotc_CV_PageActions();
    			}    			
    		}
        	
        	if(isWOTCFsEnabled){        		
        		if(isDisplayed(ManualKeyLocators.WOTC_FS_PRIMARY_RECIPIENT_NAME)){	
        			wotc_FS_PageActions();
        		}else{
        			manualKeyElements.form_Revision_Continue_Button().click();
        			sleep(2000);
        			wotc_FS_PageActions();
        		}
    		}
        	
        	if(isWOTCVrEnabled){        		
        		if(isDisplayed(ManualKeyLocators.WOTC_VR_STATE_LOCAL_AGENCY)){        			
        			wotc_VR_PageActions();
        		}else{
        			manualKeyElements.form_Revision_Continue_Button().click();
        			sleep(2000);
    			wotc_VR_PageActions();
        		}
    		}
        	
        	if(isWOTCWEnabled){
        		if(isDisplayed(ManualKeyLocators.WOTC_W_PRIMARY_RECIPIENT_NAME)){        			
        			wotc_W_PageActions();
        		}else{
        			manualKeyElements.form_Revision_Continue_Button().click();
        			sleep(2000);
        			wotc_W_PageActions();
        		}        		
    		}
        	
        	if(isWOTCFEnabled){
        		if(isDisplayed(ManualKeyLocators.WOTC_F_FEDERAL_YES)){        			
        			wotc_F_PageActions();
        		}else{
        			manualKeyElements.form_Revision_Continue_Button().click();
        			sleep(2000);
        			wotc_F_PageActions();
        			
        		}        		
    		}
        	
			if(isDisplayed(ManualKeyLocators.continueButton)){
			manualKeyElements.form_Revision_Continue_Button().click();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			verifyTest("Faliure in performManaulForm8850Jan2012RFVPageActions page",false);			
		}
    }
	
	
	
	public void performManaulForm8850Aug2009RFVPageActions(){
        try {        	
        	boolean isWOTCCvAug2009FormEnabled = false;
        	boolean isWOTCCvAug2009FormStateEnabled = false;
        	boolean isWOTCFsAug2009FormEnabled = false;
        	boolean isWOTCVrAug2009FormEnabled = false;
        	boolean isWOTCWAug2009FormEnabled = false;
        	boolean isWOTCFAug2009FormEnabled = false;     	
        	boolean isWOTCFs25Aug2009FormEnabled = false; 
        	boolean isStateQuestionsAug2009FormEnabled = true;
        	
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q1").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ1().click();
        		//isStateQuestionsAug2009FormEnabled = true;
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q2").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ2().click();
        		isWOTCCvAug2009FormEnabled = true;
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q3").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ3().click();
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q4").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ4().click();
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q5").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ5().click();
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q6").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ6().click();       		
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q7").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ7().click();
        		if(!isWOTCCvAug2009FormEnabled){
        			isWOTCCvAug2009FormStateEnabled = true;
        		}        		
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q8").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ8().click();
        		isWOTCFsAug2009FormEnabled = true;
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q9").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ9().click();
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q10").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ10().click();
        	}
        	
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q11").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ11().click();
        		isWOTCWAug2009FormEnabled = true;
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q12").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ12().click();
        		isWOTCFAug2009FormEnabled= true;
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q13").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ13().click();
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q14").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ14().click();
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q15").equals("YES")){
        		manualKeyElements.form8850June2015RFVQ15().click();
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q16").equals("YES")){
        		manualKeyElements.form8850Aug2009RFVQ16().click();
        		isWOTCVrAug2009FormEnabled = true;
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q17").equals("YES")){
        		manualKeyElements.form8850Aug2009RFVQ17().click();
        		isWOTCFs25Aug2009FormEnabled = true;
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q18").equals("YES")){
        		manualKeyElements.form8850Aug2009RFVQ18().click();
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q19").equals("YES")){
        		manualKeyElements.form8850Aug2009RFVQ19().click();
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q20").equals("YES")){
        		manualKeyElements.form8850Aug2009RFVQ20().click();
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q21").equals("YES")){
        		manualKeyElements.form8850Aug2009RFVQ21().click();
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q22").equals("YES")){
        		manualKeyElements.form8850Aug2009RFVQ22().click();
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q23").equals("YES")){
        		manualKeyElements.form8850Aug2009RFVQ23().click();
        	}
        	if(getExcelData().get("FORM_8850_JAN_2012_RFV_Q24").equals("YES")){
        		manualKeyElements.form8850Aug2009RFVQ24().click();
        	}
        	
        	
        	if(isWOTCCvAug2009FormEnabled || isWOTCCvAug2009FormStateEnabled){
    			if(isDisplayed(ManualKeyLocators.WOTC_CV_WOTC_DV_WOTC_UV_BRANCH_SERVICE)){		
    				wotcCVAug2009FormPageActions();
    			}else{
    				manualKeyElements.form_Revision_Continue_Button().click();
    				sleep(2000);
    				wotcCVAug2009FormPageActions();
    			}    			
    		}
        	
        	if(isWOTCFsAug2009FormEnabled){
    			if(isDisplayed(ManualKeyLocators.WOTC_FS_PRIMARY_FOOD_STAMPS_RECIPIENT)){		
    				wotcFSAug2009FormPageActions();
    			}else{
    				manualKeyElements.form_Revision_Continue_Button().click();
    				sleep(2000);
    				wotcFSAug2009FormPageActions();
    			}    			
    		}        	
        	
        	if(isWOTCWAug2009FormEnabled){
    			if(isDisplayed(ManualKeyLocators.WOTC_W_PRIMARY_RECIPIENT_CHILD_NAME)){		
    				wotcWAug2009FormPageActions();
    			}else{
    				manualKeyElements.form_Revision_Continue_Button().click();
    				sleep(2000);
    				wotcWAug2009FormPageActions();
    			}    			
    		}
        	
        	
        	if(isWOTCFAug2009FormEnabled){
    			if(isDisplayed(ManualKeyLocators.WOTC_F_AUG_2009_CONVICTION_DATE)){		
    				wotcFAug2009FormPageActions();
    			}else{
    				manualKeyElements.form_Revision_Continue_Button().click();
    				sleep(2000);
    				wotcFAug2009FormPageActions();
    			}    			
    		}
        	
        	if(isWOTCVrAug2009FormEnabled){
    			if(isDisplayed(ManualKeyLocators.WOTC_VR_AUG_2009_COUNSLER_NAME)){		
    				wotcVrAug2009FormPageActions();
    			}else{
    				manualKeyElements.form_Revision_Continue_Button().click();
    				sleep(2000);
    				wotcVrAug2009FormPageActions();
    			}    			
    		}        	
        	
        	if(isWOTCFs25Aug2009FormEnabled){
    			if(isDisplayed(ManualKeyLocators.WOTC_FS25_AUG_2009_FOOD_RECIPIENT)){		
    				wotcFs25Aug2009FormPageActions();
    			}else{
    				manualKeyElements.form_Revision_Continue_Button().click();
    				sleep(2000);
    				wotcFs25Aug2009FormPageActions();
    			}    			
    		}
        	
        	if(isStateQuestionsAug2009FormEnabled){
    			if(isDisplayed(ManualKeyLocators.STATE_QUESTIONS_TEXT)){		
    				stateQuestions();
    			}else{
    				manualKeyElements.form_Revision_Continue_Button().click();
    				sleep(2000);
    				stateQuestions();
    			}    			
    		}
        	
			if(isDisplayed(ManualKeyLocators.continueButton)){
			manualKeyElements.form_Revision_Continue_Button().click();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			verifyTest("Faliure in performManaulForm8850Aug2009RFVPageActions page",false);			
		}
    }
	
	
	public void stateQuestions() {
		try {
			String stateQuestionText = manualKeyElements.stateQuestionText().getText();
			if(!stateQuestionText.equals("State Questions")){
				verifyTest("State Question Text not matched", false);
			}  
		} catch (Exception e) {			
			e.printStackTrace();
			verifyTest("Manual Form 8850 Jun2015 RFV 2015 Page -- stateQuestions() ", false);
		}
	}
	
	public void wotcFs25Aug2009FormPageActions() {
		try {
			manualKeyElements.wotcFs25FoodRecipient().sendKeys(getExcelData().get("WOTC_FS25_AUG_2009_FOOD_RECIPIENT"));
			manualKeyElements.wotcFs25Relation().sendKeys(getExcelData().get("WOTC_FS25_AUG_2009_RELATION"));
    		manualKeyElements.wotcFs25City().sendKeys(getExcelData().get("WOTC_FS25_AUG_2009_CITY"));
    		selectDropdownByValue(manualKeyElements.wotcFs25State(),getExcelData().get("WOTC_FS25_AUG_2009_STATE"));
		} catch (Exception e) {			
			e.printStackTrace();
			verifyTest("Manual Form 8850 Jun2015 RFV 2015 Page -- wotcFs25Aug2009FormPageActions() ", false);
		}
	}
	
	public void wotcVrAug2009FormPageActions() {
		try {
			if(getExcelData().get("WOTC_VR_IF_YES").equals("STATE/LOCAL AGENCY")) {
    			manualKeyElements.wotcVrStateLocalAgency().click();
			}
			if(getExcelData().get("WOTC_VR_IF_YES").equals("VETERAN ADMINISTRATION")) {
				manualKeyElements.wotcVrVeteranAdministration().click();
			}
			if(getExcelData().get("WOTC_VR_IF_YES").equals("TICKET TO WORK")) {
				manualKeyElements.wotcVrTicketToWork().click();
			}
    		
			manualKeyElements.wotcVrAug2009City().sendKeys(getExcelData().get("WOTC_VR_AUG_2009_CITY"));
			selectDropdownByValue(manualKeyElements.wotcVrAug2009State(),getExcelData().get("WOTC_VR_AUG_2009_STATE"));
			manualKeyElements.wotcVrAug2009CounslerName().sendKeys(getExcelData().get("WOTC_VR_AUG_2009_COUNSLER_NAME"));
			manualKeyElements.wotcVrAug2009CounslerPhone().sendKeys(getExcelData().get("WOTC_VR_AUG_2009_COUNSLER_PHONE"));
			
		} catch (Exception e) {			
			e.printStackTrace();
			verifyTest("Manual Form 8850 Jun2015 RFV 2015 Page -- wotcVrAug2009FormPageActions() ", false);
		}
	}
	
	public void wotcFAug2009FormPageActions() {
		try {
			
			manualKeyElements.wotcFConvictionDate().sendKeys(getExcelData().get("WOTC_F_AUG_2009_CONVICTION_DATE"));
			if(getExcelData().get("WOTC_F_CONVICTION").equals("FEDERAL")) {
    			manualKeyElements.wotcFFederalYes().click();
			}
			if(getExcelData().get("WOTC_F_CONVICTION").equals("STATE")) {
				manualKeyElements.wotcFStateYes().click();
			}
			if(getExcelData().get("WOTC_F_CONVICTION").equals("NONE (DEFERRED ADJUDICATION)")) {
				manualKeyElements.wotcFNoneYes().click();
			}
			manualKeyElements.wotcFFormAug2009ReleaseMonthYear().sendKeys(getExcelData().get("WOTC_F_AUG_2009_RELEASE_MONTH_YEAR"));
			manualKeyElements.wotcFWorkReleaseProg().sendKeys(getExcelData().get("WOTC_F_AUG_2009_WORK_RELEASE_PROG"));
			manualKeyElements.wotcFFromAug2009City().sendKeys(getExcelData().get("WOTC_F_AUG_2009_CITY"));
			manualKeyElements.wotcFFormAug2009ProbationOfficer().sendKeys(getExcelData().get("WOTC_F_AUG_2009_PROBATION_OFFICER"));
			manualKeyElements.wotcFFormAug2009ProbationOfficerPhone().sendKeys(getExcelData().get("WOTC_F_AUG_2009_PROBATION_OFFICER_PHONE"));
		} catch (Exception e) {			
			e.printStackTrace();
			verifyTest("Manual Form 8850 Jun2015 RFV 2015 Page -- wotcFAug2009FormPageActions() ", false);
		}
	}
	
	public void wotcWAug2009FormPageActions() {
		try {
			manualKeyElements.wotcWChildName().sendKeys(getExcelData().get("WOTC_W_PRIMARY_RECIPIENT_CHILD_NAME"));
			manualKeyElements.wotcWRelation().sendKeys(getExcelData().get("WOTC_W_RELATION_TO_YOU"));
    		manualKeyElements.wotcWFormAug2009City().sendKeys(getExcelData().get("WOTC_W_AUG_2009_CITY"));
    		selectDropdownByValue(manualKeyElements.wotcWFormAug2009State(),getExcelData().get("WOTC_W_AUG_2009_STATE"));
		} catch (Exception e) {			
			e.printStackTrace();
			verifyTest("Manual Form 8850 Jun2015 RFV 2015 Page -- wotcWAug2009FormPageActions() ", false);
		}
	}
	
	public void wotcFSAug2009FormPageActions() {
		try {
			manualKeyElements.wotcFsFoodStampsRecipients().sendKeys(getExcelData().get("WOTC_FS_PRIMARY_FOOD_STAMPS_RECIPIENT"));
    		manualKeyElements.wotcFsCity().sendKeys(getExcelData().get("WOTC_FS_CITY"));
    		selectDropdownByValue(manualKeyElements.wotcFsState(),getExcelData().get("WOTC_FS_STATE"));
		} catch (Exception e) {			
			e.printStackTrace();
			verifyTest("Manual Form 8850 Jun2015 RFV 2015 Page -- wotcFSAug2009FormPageActions() ", false);
		}
	}
	
	public void wotcCVAug2009FormPageActions() {
		try {
			manualKeyElements.wotcVBranchService().sendKeys(getExcelData().get("WOTC_CV_WOTC_DV_WOTC_UV_BRANCH_SERVICE"));
			manualKeyElements.wotcVStartMonthYear().sendKeys(getExcelData().get("WOTC_CV_WOTC_DV_WOTC_UV_START_MONTH_YEAR"));
			manualKeyElements.wotcVServiceEndMonthYear().sendKeys(getExcelData().get("WOTC_CV_WOTC_DV_WOTC_UV_SERVICE_END_MONTH_YEAR"));			
			if(isDisplayed(ManualKeyLocators.WOTC_CV_WOTC_DV_WOTC_UV_STATE_BENIFITS)){
				selectDropdownByValue(manualKeyElements.wotcVStateBenifits(),getExcelData().get("WOTC_CV_WOTC_DV_WOTC_UV_STATE_BENIFITS"));
			}			
		} catch (Exception e) {			
			e.printStackTrace();
			verifyTest("Manual Form 8850 Jun2015 RFV 2015 Page -- wotcCVAug2009FormPageActions() ", false);
		}
	}
	
	
}
