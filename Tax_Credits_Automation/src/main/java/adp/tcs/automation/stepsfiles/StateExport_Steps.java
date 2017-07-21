package adp.tcs.automation.stepsfiles;

import adp.tcs.automation.pages.MassProcessingPage;
import adp.tcs.automation.pages.StateExportPage;
import adp.tcs.automation.utilities.*;
import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by BhuteSac on 7/26/2016.
 */
public class StateExport_Steps extends BaseTempletSteps {

	private TakeScreenshotAction screenshot = new TakeScreenshotAction();
	private MassProcessingPage massProcess = new MassProcessingPage();
	private StateExportPage stateExportObj = new StateExportPage();
	private UserAction userAcct = new UserAction();
	private DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmssZ");
	private DateFormat fsuDate = new SimpleDateFormat("mm/dd/yy");

	private UnzipUtility unzipper = new UnzipUtility();
	private PDFfilesValidation pdfObject = new PDFfilesValidation();
	private TextFilesValidation textFileObj = new TextFilesValidation();
	private XlsFileValidation excelObject = new XlsFileValidation();
	private Manager_Hire_Steps mgr_Hre = new Manager_Hire_Steps();
	private CSVfilesValidation csvfiles = new CSVfilesValidation();
	private XMLvalidation xmlVal = new XMLvalidation();
	private XlsFileValidation xlsfileValid = new XlsFileValidation();
	private Date date = new Date();
	String actualSSN;
	/*
This method is used to create and export the state File through State Export functinality.
	 */
	@Given("Enter All the Details With PSN Date and State and click on Export Button")
	public void stateExport() throws Exception {
		try {
			verifyTest("Enter All the Details With PSN Date and State and click on Export Button");
			String currentDate = this.dateFormat.format(this.date);
			String fromD = currentDate.substring(4,6);
			System.out.println("Value for Date : " + fromD);
			sleep(2000);
			this.massProcess.operations_Tab().click();
			sleep(1000);
			this.stateExportObj.state_Export_SubTab().click();
			Thread.sleep(2000);

			Actions action = new Actions(driver);
			//  WebElement mainMenu = driver.findElement(By.linkText("MainMenu"));
			action.moveToElement(massProcess.operations_Tab()).moveToElement(stateExportObj.state_Export_SubTab()).click().build().perform();
			Thread.sleep(2000);

			this.stateExportObj.state_Export_Give_Info_Date().click();
			this.stateExportObj.state_Export_State_Dropdown().click();
			this.userAcct.selectStateDropdownStateExportPage(getExcelData().get("UNIT_STATE"));
			sleep(2000);
			this.stateExportObj.state_Export_Give_Info_Date().click();
			mgr_Hre.selectDateCurrentMonth(fromD);
			sleep(2000);
			this.stateExportObj.state_Export_PSN_From_Date().click();
			//  this.userAcct.selectCurrentMonthDate(fromD);
			mgr_Hre.selectDateCurrentMonth(fromD);
			sleep(2000);
			this.stateExportObj.state_Export_PSN_To_Date().click();
			//this.userAcct.selectCurrentMonthDate(fromD);
			mgr_Hre.selectDateCurrentMonth(fromD);
			this.stateExportObj.state_Export_Export_Button().click();
			waitForLoad();
			Thread.sleep(20000);
			this.stateExportObj.state_Export_Process_Id_Link().click();
			sleep(2000);

			try{
			WebElement refrsshButton = stateExportObj.state_Export_Refesh_Button();
			WebElement processingElement = stateExportObj.state_Export_Processing_Sign();
				if(isDisplayed(processingElement)) {
					for (int i = 1; i <= 100; i++) {
						userClick(refrsshButton);
						sleep(5000);
						if (!refrsshButton.isEnabled()) {
							break;
						}
					}
				}
			} catch (Exception e) {
				System.out.println("Refresh button is not displayed");
			}

			Thread.sleep(2000);
			this.stateExportObj.state_Export_Action_Download().click();
			Thread.sleep(3000);
			this.stateExportObj.state_Export_Zip_File_Download_Link().click();
			Thread.sleep(2000);

		} catch (Exception e) {
			this.screenshot.getScreenshot("stateExport");
			verifyTest("Enter All the Details With PSN Date and State and click on Export Button", false);
			e.printStackTrace();
		}

	}
	/*
This Method is used to validate the PSNUPDATEREPORT, FSU, WOTC and DOL forms for the given records.
	 */
	public void verifyDOLfsuPSNupdateFiles() throws Exception {

		try {
			String fsuDatef = this.fsuDate.format(this.date);
			String actualSSN = getExcelData().get("SSN");
			unzipFiles();

			//PSN Update Reports Validation
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("FNAME"));
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("COMPANY_NAME"));
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("UNIT_STATE"));
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("HIRE_UNIT_CODE"));
			System.out.println("PSN Update Report SSN is : -" + hyperSeparatedSSN());
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", currentdateMmDdYyFormat());
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", "U");


			//  FSU Files Validation
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("FNAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("LNAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("HIRE_UNIT_CODE"));
			verifypdfFileTextDowloadFolder("FSU", FSUdateMmDdYyFormat());
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("COMPANY_NAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("SSN"));
			System.out.println("WOTC Report SSN is : -" + hyperSeparatedSSN());


			//WOTC Forms Validations
			verifypdfFileTextUnzipFolder("WOTC","Pre-Screening Notice and Certification Request for");
			verifypdfFileTextUnzipFolder("WOTC","the Work Opportunity Credit");

			verifypdfFileTextUnzipFolder("WOTC", getExcelData().get("FNAME"));
			verifypdfFileTextUnzipFolder("WOTC", getExcelData().get("LNAME"));
			verifypdfFileTextUnzipFolder("WOTC", getExcelData().get("CITY"));
			verifypdfFileTextUnzipFolder("WOTC", "8850");
			verifypdfFileTextUnzipFolder("WOTC", getExcelData().get("DOB"));
			verifypdfFileTextUnzipFolder("WOTC", getExcelData().get("HOME_STREET_ADDRESS"));
			// verifypdfFileTextUnzipFolder("WOTC", wotc_Telephone_Number_Format());
			System.out.println("WOTC Report SSN is : -" + hyperSeparatedSSN());


			//DOL Forms Validations
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("FNAME"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("LNAME"));
			//verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_UNIT_NAME").toUpperCase());
			
			// *Updated Unit Name Function Vikas Verma 
			 
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_UNIT_CODE"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("UNIT_CITY"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("UNIT_STATE"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_WAGE"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_WAGE"));

		} catch (Exception e) {            
			e.printStackTrace();
			verifyTest("User should be able to see all the correct details on DOLfsuPSNupdate Files", false);
		}
	}

	@Then("User should be able to see all the correct details on Exported Files SC Files")
	public void verifyStateSCExport() throws Exception {

		try {
			String fsuDatef = this.fsuDate.format(this.date);
			String actualSSN = getExcelData().get("SSN");
			unzipFiles();

			//PSN Update Reports Validation
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("FNAME"));
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("COMPANY_NAME"));
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("UNIT_STATE"));
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("HIRE_UNIT_NAME"));
			System.out.println("PSN Update Report SSN is : -" + hyperSeparatedSSN());
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", currentdateMmDdYyFormat());
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", "U");


			//FSU Files Validation
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("FNAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("LNAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("HIRE_UNIT_NAME"));
			verifypdfFileTextDowloadFolder("FSU", currentdateMmDdYyFormat());
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("COMPANY_NAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("SSN"));
			System.out.println("WOTC Report SSN is : -" + hyperSeparatedSSN());


			//WOTC Forms Validations
			verifypdfFileTextUnzipFolder("WOTC","Pre-Screening Notice and Certification Request for");
			verifypdfFileTextUnzipFolder("WOTC","the Work Opportunity Credit");

			verifypdfFileTextUnzipFolder("WOTC", getExcelData().get("FNAME"));
			verifypdfFileTextUnzipFolder("WOTC", getExcelData().get("LNAME"));
			verifypdfFileTextUnzipFolder("WOTC", getExcelData().get("CITY"));
			verifypdfFileTextUnzipFolder("WOTC", "8850");
			verifypdfFileTextUnzipFolder("WOTC", getExcelData().get("DOB"));
			verifypdfFileTextUnzipFolder("WOTC", getExcelData().get("HOME_STREET_ADDRESS"));
			// verifypdfFileTextUnzipFolder("WOTC", wotc_Telephone_Number_Format());
			System.out.println("WOTC Report SSN is : -" + hyperSeparatedSSN());


			//DOL Forms Validations
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("FNAME"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("LNAME"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("SCFIP_CITY_NAME"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("UNIT_STATE"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_WAGE"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_WAGE"));

		} catch (Exception e) {            
			e.printStackTrace();
			verifyTest("User should be able to see all the correct details on DOLfsuPSNupdate Files for SC", false);
		}
	}

	/*
This method is used for validation of all files related to state CA.
	 */
	@Then("User should be able to see all the correct details on Exported Files CA Files")
	public void verifyStateCAExport() throws Exception {

		try {
			verifyDOLfsuPSNupdateFiles();

			//CA xml format
			verifyXmlFile("export", getExcelData().get("FNAME"), "firstName", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("SSN"), "ssn", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("LNAME"), "lastName", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("HOME_STREET_ADDRESS"), "street", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("CITY"), "city", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("STATE"), "state", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("ZIP"), "zipCode", "wotcApplication");
			verifyXmlFile("export", dateFormatCG(getExcelData().get("DOB")), "birthDate", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("FEIN_NUMBER"), "fein", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("COMPANY_NAME").toUpperCase(), "name", "wotcApplication");
			verifyXmlFile("export", dateFormatCG(currentdate()), "infoDate", "wotcApplication");
			verifyXmlFile("export", dateFormatCG(currentdate()), "offerDate", "wotcApplication");
			verifyXmlFile("export", dateFormatCG(currentdate()), "hireDate", "wotcApplication");
			verifyXmlFile("export", "N", "previousEmployer", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("HIRE_WAGE"), "startingWage", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("OCCUPATION_CODE"), "occupationCode", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("AGE").replace("YES", "Y"), "ageUnder40", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("Are you a member of a family that has received food stamps anytime since 04/23/2015 (15 months ago)").replace("YES", "Y"), "veteran", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("Are you a member of a family that has received food stamps anytime since 04/23/2015 (15 months ago)").replace("YES", "Y"), "veteranReceivedSnap", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("Are you entitled to receive monthly payments for a service-connected disability?").replace("YES", "Y"), "veteranDisability", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("FOOD_STAMPS_RECIPIENT"), "veteranSnapPrimaryRecipient", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("Were you unemployed at least 6 months in the past year?").replace("YES", "Y"), "snap6Months", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("TEMP_ASSISTANCE_QUE_A").replace("YES", "Y"), "tanf18Months", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("TEMP_ASSISTANCE_QUE_B").replace("YES", "Y"), "tanfAny9Months", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("SSI").replace("YES", "Y"), "receivedSSI", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("LONG_TERM_UNEMP_QUE_2").replace("YES", "Y"), "unemployedVeteran4Weeks", "wotcApplication");


		} catch (IOException e) {
			verifyTest("User should be able to see all the correct details on verifyStateCAExport Files", false);
			e.printStackTrace();
		}

	}



	/*
This method is used for validation of all files related to state CA.
	 */
	@Then("User should be able to see all the correct details on Exported Files IL Files")
	public void verifyStateILExport() throws Exception {

		try {
			String fsuDatef = this.fsuDate.format(this.date);
			String actualSSN = getExcelData().get("SSN");
			unzipFiles();

			//PSN Update Reports Validation
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("FNAME"));
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("COMPANY_NAME"));
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("UNIT_STATE"));
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("HIRE_UNIT_NAME"));
			System.out.println("PSN Update Report SSN is : -" + hyperSeparatedSSN());
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", currentdateMmDdYyFormat());
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", "U");


			//FSU Files Validation
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("FNAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("LNAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("HIRE_UNIT_NAME"));
			verifypdfFileTextDowloadFolder("FSU", currentdateMmDdYyFormat());
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("COMPANY_NAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("SSN"));
			System.out.println("WOTC Report SSN is : -" + hyperSeparatedSSN());

			//DOL Forms Validations
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("FNAME"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("LNAME"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_UNIT_NAME"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("UNIT_CITY"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("UNIT_STATE"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_WAGE"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_WAGE"));

			//IL State Validation

			verifyTextWithPipeSep("il8850", actualSSN, 2 , "1");
			verifyTextWithPipeSep("il8850", dateFormatmmddyyyy(currentdate()), 13 , "1");
			verifyTextWithPipeSep("il8850", dateFormatmmddyyyy(currentdate()), 14 , "1");
			verifyTextWithPipeSep("il8850", dateFormatmmddyyyy(currentdate()), 15 , "1");
			verifyTextWithPipeSep("il8850", dateFormatmmddyyyy(currentdate()), 18 , "1");
			verifyTextWithPipeSep("il8850", getExcelData().get("HIRE_WAGE"), 15 , "1");
			verifyTextWithPipeSep("il8850", getExcelData().get("HIRE_POSITION"), 18 , "1");

		} catch (IOException e) {
			verifyTest("User should be able to see all the correct details on verifyStateCAExport Files", false);
			e.printStackTrace();
		}

	}
	/*
This methos is used for Validation of Manual Key in State Exprot files(FL)
	 */
	@Then("User should be able to see all the correct details on Exported Files for FL State")
	public void verifyStateManualKeyInExport() throws Exception {

		try {
			String fsuDatef = this.fsuDate.format(this.date);
			String actualSSN = getExcelData().get("SSN");
			unzipFiles();

			//PSN Update Reports Validation
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("FNAME"));
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("COMPANY_NAME"));
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("UNIT_STATE"));
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("HIRE_UNIT_NAME"));
			System.out.println("PSN Update Report SSN is : -" + hyperSeparatedSSN());
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", currentdateMmDdYyFormat());
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", "U");


			//FSU Files Validation
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("FNAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("LNAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("HIRE_UNIT_NAME"));
			verifypdfFileTextDowloadFolder("FSU", currentdateMmDdYyFormat());

			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("COMPANY_NAME"));

			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("SSN"));
			System.out.println("WOTC Report SSN is : -" + hyperSeparatedSSN());

			//DOL Forms Validations
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("FNAME"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("LNAME"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_UNIT_NAME"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("UNIT_CITY"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("UNIT_STATE"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_WAGE"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_WAGE"));

			//CA xml format
			verifyXmlFile("export", getExcelData().get("FNAME"), "firstName", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("SSN"), "ssn", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("LNAME"), "lastName", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("HOME_STREET_ADDRESS"), "street", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("CITY"), "city", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("STATE"), "state", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("ZIP"), "zipCode", "wotcApplication");
			verifyXmlFile("export", dateFormatCG(getExcelData().get("DOB")), "birthDate", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("FEIN_NUMBER"), "fein", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("COMPANY_NAME").toUpperCase(), "name", "wotcApplication");
			verifyXmlFile("export", dateFormatCG(currentdate()), "infoDate", "wotcApplication");
			verifyXmlFile("export", dateFormatCG(currentdate()), "offerDate", "wotcApplication");
			verifyXmlFile("export", dateFormatCG(currentdate()), "hireDate", "wotcApplication");
			verifyXmlFile("export", "N", "previousEmployer", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("HIRE_WAGE"), "startingWage", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("OCCUPATION_CODE"), "occupationCode", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("AGE").replace("YES", "Y"), "ageUnder40", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("Are you a member of a family that has received food stamps anytime since 04/23/2015 (15 months ago)").replace("YES", "Y"), "veteran", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("Are you a member of a family that has received food stamps anytime since 04/23/2015 (15 months ago)").replace("YES", "Y"), "veteranReceivedSnap", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("Are you entitled to receive monthly payments for a service-connected disability?").replace("YES", "Y"), "veteranDisability", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("FOOD_STAMPS_RECIPIENT"), "veteranSnapPrimaryRecipient", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("Were you unemployed at least 6 months in the past year?").replace("YES", "Y"), "snap6Months", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("TEMP_ASSISTANCE_QUE_A").replace("YES", "Y"), "tanf18Months", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("TEMP_ASSISTANCE_QUE_B").replace("YES", "Y"), "tanfAny9Months", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("SSI").replace("YES", "Y"), "receivedSSI", "wotcApplication");
			verifyXmlFile("export", getExcelData().get("LONG_TERM_UNEMP_QUE_2").replace("YES", "Y"), "unemployedVeteran4Weeks", "wotcApplication");

			//Write State Export for FL State
			textwithCommaFilesValidation("FL8850");

		} catch (IOException e) {
			verifyTest("User should be able to see all the correct details on verifyState FL Export Files", false);
			e.printStackTrace();
		}

	}

	/*
This methos is used for Validation of Manual Key in State Exprot files(MI)
	 */
	@Then("User should be able to see all the correct details on Exported Files for MI State")
	public void verifyMIStateManualKeyInExport() throws Exception {

		try {
			String fsuDatef = this.fsuDate.format(this.date);
			String actualSSN = getExcelData().get("SSN");
			unzipFiles();

			//PSN Update Reports Validation
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("FNAME"));
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("COMPANY_NAME"));
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("UNIT_STATE"));
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("HIRE_UNIT_NAME"));
			System.out.println("PSN Update Report SSN is : -" + hyperSeparatedSSN());
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", currentdateMmDdYyFormat());
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", "U");


			//FSU Files Validation
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("FNAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("LNAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("HIRE_UNIT_NAME"));
			verifypdfFileTextDowloadFolder("FSU", currentdateMmDdYyFormat());
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("COMPANY_NAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("SSN"));
			System.out.println("WOTC Report SSN is : -" + hyperSeparatedSSN());

			//DOL Forms Validations
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("FNAME"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("LNAME"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_UNIT_NAME"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("UNIT_CITY"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("UNIT_STATE"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_WAGE"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_WAGE"));


			//Write State Export for MI State
			// textwithCommaFilesValidation("mi8850");
			verifyTextFile("mi8850", getExcelData().get("FEIN_NUMBER"), 0 , 9);
			verifyTextFile("mi8850", getExcelData().get("FNAME"), 19 , 49);
			verifyTextFile("mi8850", getExcelData().get("LNAME"), 79 , 109);
			verifyTextFile("mi8850", getExcelData().get("SSN"), 109 , 118);
			verifyTextFile("mi8850", getExcelData().get("HOME_STREET_ADDRESS").toUpperCase(), 121 , 247);
			verifyTextFile("mi8850", getExcelData().get("CITY").toUpperCase(), 247 , 277);
			verifyTextFile("mi8850", getExcelData().get("STATE").toUpperCase(), 277 , 279);
			verifyTextFile("mi8850", getExcelData().get("ZIP").toUpperCase(), 279 , 284);
			verifyTextFile("mi8850", getExcelData().get("DOB"), 304 , 314);
			verifyTextFile("mi8850", getExcelData().get("COMPANY_NAME").toUpperCase(), 320 , 380);
			verifyTextFile("mi8850", dateFormatmmddyyyySlash(currentdate()), 501 , 512);
			verifyTextFile("mi8850", dateFormatmmddyyyySlash(currentdate()), 512 , 522);
			verifyTextFile("mi8850", dateFormatmmddyyyySlash(currentdate()), 522 , 532);
			verifyTextFile("mi8850", dateFormatmmddyyyySlash(currentdate()), 532 , 542);
			verifyTextFile("mi8850", getExcelData().get("HIRE_JOB_POSITION").toUpperCase(), 559 , 562);
			verifyTextFile("mi8850", getExcelData().get("HIRE_WAGE"), 554 , 559);

		} catch (IOException e) {
			verifyTest("User should be able to see all the correct details on verifyState MI Export Files", false);
			e.printStackTrace();
		}

	}

	/*
    This function is used to validate the FL STATE FIELS FOR Manual Key In Screening Records.
	 */
	public void textwithCommaFilesValidation(String fileName)
	{
		verifyTextWithCommaSeparated(fileName, getExcelData().get("LNAME").toUpperCase(), 1);
		verifyTextWithCommaSeparated(fileName, getExcelData().get("FNAME").toUpperCase(), 2);
		verifyTextWithCommaSeparated(fileName, getExcelData().get("MNAME").toUpperCase(), 3);
		verifyTextWithCommaSeparated(fileName, getExcelData().get("SSN"), 4);
		verifyTextWithCommaSeparated(fileName, getExcelData().get("HOME_STREET_ADDRESS").toUpperCase(), 5);
		verifyTextWithCommaSeparated(fileName, getExcelData().get("CITY").toUpperCase(), 7);
		verifyTextWithCommaSeparated(fileName, getExcelData().get("STATE").toUpperCase(), 8);
		verifyTextWithCommaSeparated(fileName, getExcelData().get("ZIP"), 9);
		verifyTextWithCommaSeparated(fileName, getExcelData().get("DOB"), 10);
		verifyTextWithCommaSeparated(fileName, getExcelData().get("PREVIOUS_EMPLOYEMENT").replace("NO","N"), 11);
		verifyTextWithCommaSeparated(fileName,"BCYTGHIWMXZL" , 12);
		verifyTextWithCommaSeparated(fileName, getExcelData().get("WOTC_F_CONVICTION").replace("FEDERAL","F").toUpperCase(), 13);
		verifyTextWithCommaSeparated(fileName, getExcelData().get("WOTC_W_PRIMARY_RECIPIENT_NAME").toUpperCase(), 16);
		verifyTextWithCommaSeparated(fileName, getExcelData().get("WOTC_W_STATE").toUpperCase(), 17);
		verifyTextWithCommaSeparated(fileName, currentdate(), 19);
		verifyTextWithCommaSeparated(fileName, currentdate(), 20);
		verifyTextWithCommaSeparated(fileName, currentdate(), 21);
		verifyTextWithCommaSeparated(fileName, currentdate(), 22);
		verifyTextWithCommaSeparated(fileName, getExcelData().get("HIRE_WAGE"), 23);
		verifyTextWithCommaSeparated(fileName, getExcelData().get("HIRE_JOB_POSITION").toUpperCase(), 24);
	}

	@Then("User should be able to see all the correct details on Exported Files")
	public void verifyStateExport() throws Exception {
		try {
			verifyDOLfsuPSNupdateFiles();
			verifyTextFile("tx8850", getExcelData().get("FEIN_NUMBER"), 0 , 9);
			verifyTextFile("tx8850", getExcelData().get("EMPLOYEER_FEIN"), 9 , 18);

			verifyTextFile("tx8850", getExcelData().get("COMPANY_NAME").toUpperCase(), 18 , 53);
			verifyTextFile("tx8850", getExcelData().get("EMPLOYEER_ZIP_CODE").toUpperCase(), 53 , 58);
			verifyTextFile("tx8850", getExcelData().get("SSN").toUpperCase(), 58 , 67);

			verifyTextFile("tx8850", dateFormatForTextFile(getExcelData().get("DOB")), 67 , 75);
			verifyTextFile("tx8850", dateFormatForTextFile(currentdate()), 75 , 83);
			verifyTextFile("tx8850", dateFormatForTextFile(currentdate()), 83 , 91);
			verifyTextFile("tx8850", getExcelData().get("LNAME"), 91 , 104);
			verifyTextFile("tx8850", getExcelData().get("FNAME").substring(0,9), 104 , 114);

			verifyTextFile("tx8850", getExcelData().get("HOME_STREET_ADDRESS").toUpperCase(), 114 , 144);
			verifyTextFile("tx8850", getExcelData().get("CITY").toUpperCase(), 144 , 163);
			verifyTextFile("tx8850", getExcelData().get("STATE").toUpperCase(), 163 , 165);
			verifyTextFile("tx8850", getExcelData().get("HIRE_JOB_POSITION").toUpperCase(), 169 , 205);

			verifyTextFile("tx8850", getExcelData().get("HIRE_WAGE").replace(".",""), 208 , 212);
			verifyTextFile("tx8850", getExcelData().get("TG_AFDC"), 213 , 214);
			verifyTextFile("tx8850", getExcelData().get("TG_VET"), 214 , 215);
			verifyTextFile("tx8850", getExcelData().get("TG_Ex_Offender"), 215 , 216);
			verifyTextFile("tx8850", getExcelData().get("TG_DCR"), 216 , 217);
			verifyTextFile("tx8850", getExcelData().get("TG_VREHAB"), 217 , 218);
			verifyTextFile("tx8850", getExcelData().get("TG_SUMMER_YOUTH"), 218 , 219);
			verifyTextFile("tx8850", getExcelData().get("Are you a member of a family that has received food stamps anytime since 04/23/2015 (15 months ago)").replace("YES", "Y"), 219 , 220);
			verifyTextFile("tx8850", getExcelData().get("SSI").replace("YES", "Y"), 220 , 221);
			verifyTextFile("tx8850", getExcelData().get("TG_DISSCONNECTED_YOUTH"), 221, 222);
		} catch (Exception e) {
			verifyTest("User should be able to see all the correct details on TX Exported Files", false);
			e.printStackTrace();
		}
	}


	@Then("User should be able to see all the correct details on Exported Files for CO Family")
	public void verifyStateExport_CO() throws Exception{
		try {
			String fsuDatef = this.fsuDate.format(this.date);
			String actualSSN = getExcelData().get("SSN");
			unzipFiles();
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("FNAME"));

			System.out.println("PSN Update Report SSN is : -" + hyperSeparatedSSN());
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", currentdateMmDdYyFormat());
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", "U");

			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("FNAME").toUpperCase());
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("LNAME").toUpperCase());

			System.out.println("PSN Date is : -" + fsuDatef);
			verifypdfFileTextDowloadFolder("FSU", currentdateMmDdYyFormat());


			verifypdfFileTextUnzipFolder("WOTC", getExcelData().get("FNAME"));
			verifypdfFileTextUnzipFolder("WOTC", getExcelData().get("LNAME"));
			verifypdfFileTextUnzipFolder("WOTC", getExcelData().get("CITY"));

			verifypdfFileTextUnzipFolder("WOTC", "8850");
			verifypdfFileTextUnzipFolder("WOTC", getExcelData().get("DOB"));

			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("FNAME"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("LNAME"));
			verifypdfFileTextUnzipFolder("DOL", currentdateMmDdYyFormat());
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("DOB"));

		} catch (IOException e) {
			verifyTest("User should be able to see all the correct details on Exported Files", false);
			e.printStackTrace();
		}
	}


	public String dateFormatCG(String date)
	{
		// 07/14/1988
		String mnth = date.substring(0, 2);
		String ddt = date.substring(3, 5);
		String yyyy = date.substring(6, 10);
		String dateFormatcg = yyyy + "-" + mnth + "-" + ddt;
		System.out.println(dateFormatcg);
		return dateFormatcg;

	}

	public String dateFormatmmddyyyy(String date)
	{
		// 07/14/1988
		String mnth = date.substring(0, 2);
		String ddt = date.substring(3, 5);
		String yyyy = date.substring(6, 10);
		String dateFormatcg = mnth + "-" + ddt + "-" + yyyy;
		System.out.println(dateFormatcg);
		return dateFormatcg;

	}
	
	public String dateFormatmmddyyyywithoutslash(String date)
	{
		// 07/14/1988
		String mnth = date.substring(0, 2);
		String ddt = date.substring(3, 5);
		String yyyy = date.substring(6, 10);
		String dateFormatcg = mnth + "" + ddt + "" + yyyy;
		System.out.println(dateFormatcg);
		return dateFormatcg;

	}

	public String dateFormatForTextFile(String date)
	{
		// 07/14/1988
		String mnth = date.substring(0, 2);
		String ddt = date.substring(3, 5);
		String yyyy = date.substring(6, 10);
		String dateFormatcg = yyyy + "" + mnth + "" + ddt;
		System.out.println(dateFormatcg);
		return dateFormatcg;
	}

	@Then("Verify State Export Data file for state WV")
	public void VerifyStateExport_WV(){
		//getExcelData().put("SSN", "659630081");
		VerifyStateExport_TextFile("WV880");
	}


    public String dateFormatmmddyyyySlash(String date)
    {
        // 07/14/1988
        String mnth = date.substring(0, 2);
        String ddt = date.substring(3, 5);
        String yyyy = date.substring(6, 10);
        String dateFormatcg = mnth + "/" + ddt + "/" + yyyy;
        System.out.println(dateFormatcg);
        return dateFormatcg;

    }

	@Then("Verify State Export Data file for state OK")
	public void VerifyStateExport_OK(){
		VerifyStateExport_TextFile("OK8850");
	}



	@Then("Verify State Export Data file for state CA")
	public void VerifyStateExport_CA() throws Exception
	{

		unzipFiles();
		String fileName ="export";
		String tagValue ="wotcApplication";
		verifyXmlFile( fileName, getExcelData().get("SSN"), "ssn", tagValue);
		verifyXmlFile( fileName, getExcelData().get("FNAME"), "firstName", tagValue);
		verifyXmlFile( fileName, getExcelData().get("LNAME"), "lastName", tagValue);
		verifyXmlFile( fileName, getExcelData().get("HOME_STREET_ADDRESS"), "street", tagValue);
		verifyXmlFile( fileName, getExcelData().get("CITY"), "city",tagValue);
		verifyXmlFile( fileName, getExcelData().get("STATE"), "state",tagValue);
		verifyXmlFile( fileName, getExcelData().get("ZIP"), "zipCode",tagValue);

		verifyXmlFile( fileName, getExcelData().get("FEIN_NUMBER"), "fein",tagValue);
		verifyXmlFile( fileName, getExcelData().get("COMPANY_NAME").toUpperCase(), "name",tagValue);

		verifyXmlFile( fileName, currentdateYyyyMmDdFormat().replaceAll("/","-"), "infoDate", tagValue);
		verifyXmlFile( fileName, currentdateYyyyMmDdFormat().replaceAll("/","-"), "offerDate", tagValue);
		verifyXmlFile( fileName, currentdateYyyyMmDdFormat().replaceAll("/","-"), "hireDate", tagValue);
		verifyXmlFile( fileName, currentdateYyyyMmDdFormat().replaceAll("/","-"), "startDate", tagValue);

		verifyXmlFile( fileName, getExcelData().get("HIRE_WAGE"), "startingWage", tagValue);
		verifyXmlFile( fileName, getExcelData().get("FOOD_STAMPS_RECIPIENT"), "veteranSnapPrimaryRecipient", tagValue);
		verifyXmlFile( fileName, getExcelData().get("TEMP_ASSISTANCE_RELATION").toUpperCase(), "tanfPrimaryRecipient", tagValue);



	}


	@Then("Verify State Export Data file for state SC")
	public void VerifyStateExport_SC(){
		VerifyStateExport_TextFile("SC8850");
	}

	@Then("Verify State Export Data file for state CO")
	public void VerifyStateExport_CO(){
		VerifyStateExport_TextFile("CO8850");
	}

	@Then("Verify State Export Data file for state DC")
	public void VerifyStateExport_DC(){
		VerifyStateExport_TextFile("DC8850");
	}

	@Then("Verify State Export Data file for state AR")
	public void VerifyStateExport_AR() throws Exception
	{
		try {

			verifyStateExport_CO();
			VerifyStateExport_TextFile("AR8850");
		}catch (IOException e) {

			verifyTest("User should be able to see all the correct details on Exported Files", false);
			e.printStackTrace();
		}
	}

	public void VerifyStateExport_TextFile(String FileName)
	{
		
		verifyTextFile(FileName, getExcelData().get("CONSULTANT_ID"), 0 , 11);
		verifyTextFile(FileName, getExcelData().get("FEIN_NUMBER"), 12 , 21);
		verifyTextFile(FileName, getExcelData().get("SSN"), 21 , 30);
		verifyTextFile(FileName, getExcelData().get("FNAME"), 30 , 40);
		
		
		verifyTextFile(FileName, getExcelData().get("MNAME"), 40 , 41);
		verifyTextFile(FileName, getExcelData().get("LNAME"), 41 , 60);
		verifyTextFile(FileName, getExcelData().get("HOME_STREET_ADDRESS"), 60 , 90);
		verifyTextFile(FileName, getExcelData().get("CITY"), 90 , 110);
		verifyTextFile(FileName, getExcelData().get("STATE"), 110 ,112);
		verifyTextFile(FileName, getExcelData().get("ZIP"), 112, 117);
			
		/* -------------------------------------------------------------ADDED BY VIKAS VERMA -------------------------------------------------------------------*/
		System.out.println("********Verification of Telephone Number********");
		verifyTextFile(FileName, wotc_Telephone_Number_Format_PlainNos(), 117, 127);
		System.out.println("********Verification of Date Of Birth********");
		verifyTextFile(FileName, getExcelData().get("DOB").replaceAll("/", ""), 127, 135);         
		verifyTextFile(FileName, getExcelData().get("KATRINA_EMPLOYEE"), 135 , 136);
		System.out.println("********Verification of Esignature********");
		verifyTextFile(FileName, getExcelData().get("ESIGN").substring(0, 1), 237 , 238);
		
		System.out.println("********Signature on file (Y/N)********");
		verifyTextFile(FileName, currentdate().replaceAll("/",""), 238, 246);      
		
		System.out.println("********Verification of GAVE INFO DATE, JOB OFFER DATE, HIRE DATE, START DATE********");
		if (getExcelData().get("HIRE_CURRENT_DATE").equalsIgnoreCase("YES"))
		{
			   
			verifyTextFile(FileName, currentdate().replaceAll("/",""), 247, 255); 
			verifyTextFile(FileName, currentdate().replaceAll("/",""), 255, 263); 
			verifyTextFile(FileName, currentdate().replaceAll("/",""), 263, 271);
			verifyTextFile(FileName, currentdate().replaceAll("/",""), 271, 279); 
						
			/*verifyTextFile(FileName, currentdateYyyyMmDdFormat().replaceAll("/",""), 247 , 255);
			verifyTextFile(FileName, currentdateYyyyMmDdFormat().replaceAll("/",""), 255 , 263);
			verifyTextFile(FileName, currentdateYyyyMmDdFormat().replaceAll("/",""), 263 , 271);
			verifyTextFile(FileName, currentdateYyyyMmDdFormat().replaceAll("/",""), 271 , 279);*/
		}else
		{
			verifyTextFile(FileName, dateFormatmmddyyyywithoutslash(getExcelData().get("HIRE_GAVE_INFO_DATE")), 247 , 255);
			verifyTextFile(FileName, dateFormatmmddyyyywithoutslash(getExcelData().get("HIRE_JOB_OFFER_DATE")), 255 , 263);
			verifyTextFile(FileName, dateFormatmmddyyyywithoutslash(getExcelData().get("HIRE_DATE")), 263 , 271);
			verifyTextFile(FileName, dateFormatmmddyyyywithoutslash(getExcelData().get("HIRE_START_DATE")), 271 , 279);
		}
		
		System.out.println("********New employee (Katrina) Y/N********");
		verifyTextFile(FileName, currentdate().replaceAll("/",""), 302, 310);    
		System.out.println("********Verification of HIRE WAGE********");
		verifyTextFile(FileName, getExcelData().get("HIRE_WAGE").replace(".",""), 310 , 314);
		System.out.println("********Verification of ONET CODE********");
		verifyTextFile(FileName, getExcelData().get("ONET_CODE"), 314, 316);
		
		System.out.println("********Verification of 9061_TARGET GROUPS VET FS,VET DISA, DV UNEMPLOYED ETC********");
		verifyTextFile(FileName, getExcelData().get("9061_VALIDATION"), 316, 330);
		
			
		System.out.println("*********9061 DOL FORM VALIDATION*********************");
		verifyTextFile(FileName, getExcelData().get("TEMP_ASSISTANCE_RELATION").toUpperCase(), 330, 360);   
		System.out.println("********Verification of TEMP ASSISTANCE CITY********");
		verifyTextFile(FileName, getExcelData().get("TEMP_ASSISTANCE_CITY"), 360, 380);
		System.out.println("********Verification of TEMP ASSISTANCE STATE********");
		verifyTextFile(FileName, getExcelData().get("TEMP_ASSISTANCE_STATE").substring(0, 2), 380, 382);
		verifyTextFile(FileName, getExcelData().get("FELONY_QUE_1").substring(0, 1), 382, 383);
		
		System.out.println("********Verification of EMPOWERMENT ZONE AND RENEWAL RURAL COUNTY********");
		verifyTextFile(FileName, getExcelData().get("9061_EZ_RRC"), 399, 401);
		
		System.out.println("********Verification of SSI********");
		verifyTextFile(FileName, getExcelData().get("SSI").substring(0, 1), 421, 422);
		verifyTextFile(FileName, getExcelData().get("SSI").substring(0, 1), 421, 422);
		verifyTextFile(FileName, getExcelData().get("ESIGNER_TYPE").substring(0, 1), 742, 743);
		
		System.out.println("*********ESIGNER TYPE*********************");
		verifyTextFile(FileName, currentdate().replaceAll("/",""), 743, 751);
		System.out.println("********Verification of VETERAN CITY********");
		verifyTextFile(FileName, getExcelData().get("VETERN_CITY").toUpperCase(), 751, 771);
		
		System.out.println("********Verification of VETERAN STATE********");
		verifyTextFile(FileName, getExcelData().get("VERTERN_STATE").substring(0, 2), 771, 773);
		
		System.out.println("********Verification of ESIGNER FULL NAME********");
		verifyTextFile(FileName, getExcelData().get("ESIGNER_FULLNAME"), 773, 785);
		
		
		verifyTextFile(FileName, getExcelData().get("ARRA_VET_CATEGORY").substring(0, 1), 785, 786);
		verifyTextFile(FileName, getExcelData().get("8850_ICF_VERSION"), 788, 792);
		
		System.out.println("********Verification of 9061 QUEST 1- 7 ALL VALDATIONS AND CHECKS***************");
		verifyTextFile(FileName, getExcelData().get("8850_9061_QUE_VALIDATION"), 792, 804);
		
		System.out.println("*********9061 Category F (question 19)*********************");
		verifyTextFile(FileName, currentdate().replaceAll("/",""), 804, 812);
		
		System.out.println("********Verification of LONG TERM UNEMPLOYMENT VALIDATION********");
		verifyTextFile(FileName, getExcelData().get("LTUE_VALIDATION"), 812 , 815);
		
		System.out.println("********Verification of COMPANY NAME********");
		verifyTextFile(FileName, getExcelData().get("COMPANY_NAME").toUpperCase(), 900 , 950);
		
		System.out.println("********Verification of EMPLOYER ADDRESS********");
		verifyTextFile(FileName, getExcelData().get("EMPLOYER_ADDRESS"), 950 , 980);
		
		System.out.println("********Verification of EMPLOYER CITY********");
		verifyTextFile(FileName, getExcelData().get("EMPLOYER_CITY"), 1010 , 1030);
		
		System.out.println("********Verification of EMPLOYER STATE********");
		verifyTextFile(FileName, getExcelData().get("EMPLOYER_STATE"), 1030 , 1032);
		
		System.out.println("********Verification of EMPLOYER ZIP********");
		verifyTextFile(FileName, getExcelData().get("EMPLOYER_ZIP"), 1032 , 1037);
		
		System.out.println("********Verification of EMPLOYER PHONE********");
		verifyTextFile(FileName, getExcelData().get("EMPLOYER_PHONE"), 1037 , 1047);
		
		System.out.println("********Verification of JOB APPLICANT FIRST NAME********");
		verifyTextFile(FileName, getExcelData().get("FNAME").toUpperCase(), 30 , 40);
		
		System.out.println("********Verification of JOB APPLICANT MIDDLE NAME********");
		verifyTextFile(FileName, getExcelData().get("MNAME").toUpperCase(), 40 , 41);
		
		System.out.println("********Verification of JOB APPLICANT LAST NAME********");
		verifyTextFile(FileName, getExcelData().get("LNAME").toUpperCase(), 41 , 60);
		
		System.out.println("********Verification of JOB APPLICANT HOME ADDRESS********");
		verifyTextFile(FileName, getExcelData().get("HOME_STREET_ADDRESS").toUpperCase(), 60 , 90);
		
		System.out.println("********Verification of JOB APPLICANT CITY********");
		verifyTextFile(FileName, getExcelData().get("CITY").toUpperCase(), 90 , 110);
		
		System.out.println("********Verification of JOB APPLICANT STATE********");
		verifyTextFile(FileName, getExcelData().get("STATE").toUpperCase(), 110 ,112);
		verifyTextFile(FileName, currentdate().replaceAll("/",""), 247, 255);
		verifyTextFile(FileName, currentdate().replaceAll("/",""), 255, 263);
		verifyTextFile(FileName, currentdate().replaceAll("/",""), 263, 271);
		verifyTextFile(FileName, currentdate().replaceAll("/",""), 271, 279);

	}

	@Then("User should be able to see all the correct details on NY Exported Files")
	public void verifyStateExportNY() throws Exception {

		try {
			Thread.sleep(3000);
			String fsuDatef = this.fsuDate.format(this.date);
			String actualSSN = getExcelData().get("SSN");
			unzipFiles();
			Thread.sleep(6000);

			// ***********PSN Validation***************
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("COMPANY_NAME"));
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("UNIT_CODE"));
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("FNAME"));
			System.out.println("PSN Update Report SSN is : -" + hyperSeparatedSSN());
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", "U");

			// FSU Files Validation

			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("FNAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("LNAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("HIRE_UNIT_NAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("COMPANY_NAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("SSN"));
			System.out.println("WOTC Report SSN is : -" + hyperSeparatedSSN());

			// WOTC Forms Validations
			verifypdfFileTextUnzipFolder("WOTC", "Pre-Screening Notice and Certification Request for");
			verifypdfFileTextUnzipFolder("WOTC", "the Work Opportunity Credit");
			verifypdfFileTextUnzipFolder("WOTC", getExcelData().get("FNAME"));
			verifypdfFileTextUnzipFolder("WOTC", getExcelData().get("LNAME"));
			verifypdfFileTextUnzipFolder("WOTC", getExcelData().get("CITY"));
			verifypdfFileTextUnzipFolder("WOTC", "8850");
			verifypdfFileTextUnzipFolder("WOTC", getExcelData().get("DOB"));
			verifypdfFileTextUnzipFolder("WOTC", getExcelData().get("HOME_STREET_ADDRESS"));

			//DOL Forms Validations
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("FNAME"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("LNAME"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_UNIT_NAME"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("UNIT_CITY"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("UNIT_STATE"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_WAGE"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_WAGE"));  


			//STATE EXPORT FILE
			verifyxlsValues("ny8850", actualSSN, "D");
			verifyxlsValues("ny8850", getExcelData().get("LNAME"), "A");
			verifyxlsValues("ny8850", getExcelData().get("FNAME"), "B");
			verifyxlsValues("ny8850", getExcelData().get("MNAME"), "C");
			verifyxlsValues("ny8850", getExcelData().get("HOME_STREET_ADDRESS"), "E");
			verifyxlsValues("ny8850", getExcelData().get("CITY"), "G");
			verifyxlsValues("ny8850", getExcelData().get("STATE"), "H");
			verifyxlsValues("ny8850", getExcelData().get("ZIP"), "I");
			verifyxlsValues("ny8850", getExcelData().get("COMPANY_URL").toUpperCase(), "L");
			verifyxlsValues("ny8850", getExcelData().get("FEIN_NUMBER"), "N");
			verifyxlsValues("ny8850", getExcelData().get("HOME_STREET_ADDRESS"), "O");
			verifyxlsValues("ny8850", getExcelData().get("CITY"), "Q");
			verifyxlsValues("ny8850", getExcelData().get("STATE"), "R");
			verifyxlsValues("ny8850", getExcelData().get("ZIP"), "S");
			//			
			//			verifyxlsValues("ny8850", getExcelData().get("HIRE_DATE"), "T");
			//			verifyxlsValues("ny8850", getExcelData().get("HIRE_START_DATE"), "U");
			verifyxlsValues("ny8850", getExcelData().get("HIRE_WAGE"), "V");

		} 

		catch (IOException e) {
			verifyTest("User should be able to see all the correct details on Exported Files", false);
			e.printStackTrace();
		}

	}

	@Then("User should be able to see all the correct details on MO Exported Files")
	public void verifyStateExportMOState() throws Exception {
		verifyStateExportMO("mo8850");
	}

	@Then("User should be able to see all the correct details on MS Exported Files")
	public void verifyStateExportMSState() throws Exception {
		verifyStateExportMO("ms8850");
	}

	@Then("User should be able to see all the correct details on KY Exported Files")
	public void verifyStateExportMO(String strFIleName) throws Exception {

		try {
			Thread.sleep(3000);
			String fsuDatef = this.fsuDate.format(this.date);
			String actualSSN = getExcelData().get("SSN");
			unzipFiles();
			Thread.sleep(6000);

			verifyDOLfsuPSNupdateFiles();
			//STATE EXPORT FILE
			verifyTextFile(strFIleName, actualSSN, 192, 201);
			verifyTextFile(strFIleName, getExcelData().get("LNAME"), 0 , 64);
			verifyTextFile(strFIleName, getExcelData().get("FNAME"), 64 , 128);
			verifyTextFile(strFIleName, getExcelData().get("SSN"), 192 , 201);
			verifyTextFile(strFIleName, getExcelData().get("MNAME"), 128 , 192);
			verifyTextFile(strFIleName, dateFormatForTextFile(getExcelData().get("DOB")), 201 , 209);
			verifyTextFile(strFIleName, getExcelData().get("HOME_STREET_ADDRESS").toUpperCase(), 209 , 337);

			verifyTextFile(strFIleName, getExcelData().get("CITY").toUpperCase(), 337 , 369);
			verifyTextFile(strFIleName, getExcelData().get("STATE").toUpperCase(), 369 , 371);

			verifyTextFile(strFIleName, getExcelData().get("HIRE_JOB_POSITION").toUpperCase(), 477 , 509);
			verifyTextFile(strFIleName, getExcelData().get("HIRE_WAGE"), 471 , 477);
			verifyTextFile(strFIleName, getExcelData().get("ZIP"), 371 , 376);
///
		if (getExcelData().get("HIRE_CURRENT_DATE").equalsIgnoreCase("YES"))
		{
			verifyTextFile(strFIleName, currentdateYyyyMmDdFormat().replaceAll("/",""), 430 , 438);
			verifyTextFile(strFIleName, currentdateYyyyMmDdFormat().replaceAll("/",""), 438 , 446);
			verifyTextFile(strFIleName, currentdateYyyyMmDdFormat().replaceAll("/",""), 446 , 454);

			verifyTextFile(strFIleName, currentdateYyyyMmDdFormat().replaceAll("/",""), 454 , 462);
		}else
		{
			verifyTextFile(strFIleName, dateFormatForTextFile(getExcelData().get("HIRE_GAVE_INFO_DATE")), 430 , 438);
			verifyTextFile(strFIleName, dateFormatForTextFile(getExcelData().get("HIRE_JOB_OFFER_DATE")), 438 , 446);
			verifyTextFile(strFIleName, dateFormatForTextFile(getExcelData().get("HIRE_DATE")), 446 , 454);

			verifyTextFile(strFIleName, dateFormatForTextFile(getExcelData().get("HIRE_START_DATE")), 454 , 462);
		}

	}

		catch (IOException e) {
			verifyTest("User should be able to see all the correct details on Exported Files", false);
			e.printStackTrace();
		}

	}


	@Then("User should be able to see all the correct details on ND Exported Files")
	public void verifyStateExportNDState() throws Exception {

		Thread.sleep(3000);
		String fsuDatef = this.fsuDate.format(this.date);
		String actualSSN = getExcelData().get("SSN");
		unzipFiles();
		Thread.sleep(6000);

		// ***********PSN Validation***************
		verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("COMPANY_NAME"));
		verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("UNIT_CODE"));
		verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("FNAME"));
		System.out.println("PSN Update Report SSN is : -" + hyperSeparatedSSN());
		verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", "U");

		// FSU Files Validation

		verifypdfFileTextDowloadFolder("FSU", getExcelData().get("FNAME"));
		verifypdfFileTextDowloadFolder("FSU", getExcelData().get("LNAME"));
		verifypdfFileTextDowloadFolder("FSU", getExcelData().get("HIRE_UNIT_NAME"));
		verifypdfFileTextDowloadFolder("FSU", getExcelData().get("COMPANY_NAME"));
		verifypdfFileTextDowloadFolder("FSU", getExcelData().get("SSN"));
		System.out.println("WOTC Report SSN is : -" + getExcelData().get("SSN"));

		//DOL Forms Validations
		verifypdfFileTextUnzipFolder("DOL", getExcelData().get("FNAME"));
		verifypdfFileTextUnzipFolder("DOL", getExcelData().get("LNAME"));
		verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_UNIT_NAME"));
		verifypdfFileTextUnzipFolder("DOL", getExcelData().get("UNIT_CITY"));
		verifypdfFileTextUnzipFolder("DOL", getExcelData().get("UNIT_STATE"));
		verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_WAGE"));
		verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_WAGE"));

		//
		verifycsvValues("ADP",	getExcelData().get("FNAME"),1);
	}

	@Then("User should be able to see all the correct details on PA Exported Files")
	public void verifyStateExportPA() throws Exception {

		try {
			Thread.sleep(3000);
			String fsuDatef = this.fsuDate.format(this.date);
			String actualSSN = getExcelData().get("SSN");
			unzipFiles();
			Thread.sleep(6000);

			// ***********PSN Validation***************
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("COMPANY_NAME"));
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("UNIT_CODE"));
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("FNAME"));
			System.out.println("PSN Update Report SSN is : -" + hyperSeparatedSSN());
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", "U");

			// FSU Files Validation

			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("FNAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("LNAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("HIRE_UNIT_NAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("COMPANY_NAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("SSN"));
			System.out.println("WOTC Report SSN is : -" + hyperSeparatedSSN());

			// WOTC Forms Validations
			verifypdfFileTextUnzipFolder("WOTC", "Pre-Screening Notice and Certification Request for");
			verifypdfFileTextUnzipFolder("WOTC", "the Work Opportunity Credit");
			verifypdfFileTextUnzipFolder("WOTC", getExcelData().get("FNAME"));
			verifypdfFileTextUnzipFolder("WOTC", getExcelData().get("LNAME"));
			verifypdfFileTextUnzipFolder("WOTC", getExcelData().get("CITY"));
			verifypdfFileTextUnzipFolder("WOTC", "8850");
			verifypdfFileTextUnzipFolder("WOTC", getExcelData().get("DOB"));
			verifypdfFileTextUnzipFolder("WOTC", getExcelData().get("HOME_STREET_ADDRESS"));

			//DOL Forms Validations
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("FNAME"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("LNAME"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_UNIT_NAME"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("UNIT_CITY"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("UNIT_STATE"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_WAGE"));



			//STATE EXPORT FILE
			
verifycsvValues("PA", getExcelData().get("FEIN_NUMBER"), 0);
			verifycsvValues("PA", getExcelData().get("COMPANY_URL").toUpperCase(), 1);
			verifycsvValues("PA", getExcelData().get("HOME_STREET_ADDRESS"), 2);
			verifycsvValues("PA", "ABINGTON", 4);
			verifycsvValues("PA", "PA", 5);
			verifycsvValues("PA", "19001", 6);
			verifycsvValues("PA", actualSSN, 7);
			verifycsvValues("PA", getExcelData().get("FNAME"), 8);
			verifycsvValues("PA", getExcelData().get("LNAME"), 9);
			verifycsvValues("PA", getExcelData().get("DOB"), 12);
			verifycsvValues("PA", getExcelData().get("HOME_STREET_ADDRESS"), 13);
			verifycsvValues("PA", getExcelData().get("CITY"), 15);
			verifycsvValues("PA", getExcelData().get("STATE"), 16);
			verifycsvValues("PA", getExcelData().get("ZIP"), 17);
			verifycsvValues("PA", "91",18);
			
			verifycsvValues("PA", currentdate(), 20);
			verifycsvValues("PA", currentdate(), 21);
			verifycsvValues("PA", currentdate(), 22);
			verifycsvValues("PA", currentdate(), 23);
			verifycsvValues("PA", getExcelData().get("HIRE_WAGE"), 24);
			verifycsvValues("PA", "43", 25);
			
			verifycsvValues("PA", "0",26);
			verifycsvValues("PA", "1",27);
			verifycsvValues("PA", "0",28);
			verifycsvValues("PA", "0",29);
			verifycsvValues("PA", "0",30);
			verifycsvValues("PA", "1",31);
			verifycsvValues("PA", "1",32);
			verifycsvValues("PA", "0",33);
			verifycsvValues("PA", "1",35);
			verifycsvValues("PA", "1",36);
			verifycsvValues("PA", "1",37);
			verifycsvValues("PA", "1",38);
			
			verifycsvValues("PA", "0",39);
			verifycsvValues("PA", "0",40);
			verifycsvValues("PA", "1",41);
			verifycsvValues("PA", "1",42);
			

			verifycsvValues("PA", "0",43);
			verifycsvValues("PA", "0",44);
			verifycsvValues("PA", "1",45);
			verifycsvValues("PA", "1",46);
			

			verifycsvValues("PA", "1",47);
			verifycsvValues("PA", "1",48);
			verifycsvValues("PA", "1",49);
			verifycsvValues("PA", "0",50);
			verifycsvValues("PA", "0",54);
			
			verifycsvValues("PA", "0",56);
			verifycsvValues("PA", "1",57);
			verifycsvValues("PA", "0",58);
			verifycsvValues("PA", "1",59);
			verifycsvValues("PA", "1",60);
			
			verifycsvValues("PA", "1",61);
			verifycsvValues("PA", "1",63);
			verifycsvValues("PA", "FL",64);
			
			verifycsvValues("PA", "PRIMARY RECEIPENT TANF",65);
			verifycsvValues("PA", currentdate(), 66);
			verifycsvValues("PA", currentdate(), 67);

		}

		catch (IOException e) {
			verifyTest("User should be able to see all the correct details on Exported Files", false);
			e.printStackTrace();
		}

	}


	public static void main(String[] args) throws Exception {
		StateExport_Steps statexp = new StateExport_Steps();
		ScreeningSteps scresteps = new ScreeningSteps();
		scresteps.invokeEnvSpecificURLForScreening("Manual_Key_JUNE_2015_RFV_Qulify","test1","test2");
		statexp.verifyMIStateManualKeyInExport();
	}

	public String wotc_Telephone_Number_Format() {
		actualSSN = getExcelData().get("TELEPHONE");
		//          String firstHyper = actualSSN.substring(0,3);
		String firstHyper = actualSSN.substring(0, 3);
		String secondHyper = actualSSN.substring(3, 5);
		String thirdHyper = actualSSN.substring(5, 9);
		String telformat = "("+firstHyper + ") " + secondHyper + "-" + thirdHyper;
		System.out.println(telformat);
		return telformat;
	}

	public String wotc_Telephone_Number_Format_PlainNos() {
		actualSSN = getExcelData().get("TELEPHONE");
		//          String firstHyper = actualSSN.substring(0,3);
		String firstHyper = actualSSN.substring(1, 4);
		String secondHyper = actualSSN.substring(6, 9);
		String thirdHyper = actualSSN.substring(10, 14);
		String telformat = firstHyper + secondHyper + thirdHyper;
		System.out.println(telformat);
		return telformat;
	}

	
	public void verifyExcelFileDowloadFolder(String workSheetName,String cellreferance ,String fileName, String textToVerify)  throws Exception {
		excelObject.setSheetName(workSheetName);
		boolean pdfFlag = false;
		int j;
		ArrayList<String> allExcelFiels = this.unzipper.listxlsFiles(zippedFileLocation);

		int pdffilesCnt = allExcelFiels.size();
		for (j = 0; pdffilesCnt > j; j++) {
			if (allExcelFiels.get(j).contains(fileName)) {
				String actualFileLoc = zippedFileLocation + allExcelFiels.get(j);
				pdfFlag =excelObject.verifyExcelText(cellreferance ,actualFileLoc, textToVerify);
				break;
			}
		}
		Assert.assertTrue(textToVerify + " Text is present on the PDF File : " + allExcelFiels.get(j), pdfFlag);
	}


	public void verifypdfFileTextDowloadFolder(String fileName, String textToVerify) throws IOException {
		boolean pdfFlag = false;
		int j;
		ArrayList<String> allpdfFiels = this.unzipper.listPdfFiles(zippedFileLocation);

		int pdffilesCnt = allpdfFiels.size();

		for (j = 0; pdffilesCnt > j; j++) {
			if (allpdfFiels.get(j).contains(fileName)) {
				String actualFileLoc = zippedFileLocation + allpdfFiels.get(j);
				pdfFlag = pdfObject.verifyPDFContent(actualFileLoc, textToVerify);
				break;
			}
		}

		// Assert.assertTrue(textToVerify + " Text is not present on the PDF File : " + allpdfFiels.get(j), pdfFlag);
		verifyTest(textToVerify + " Text is present on the PDF File : " + allpdfFiels.get(j), pdfFlag);
	}


	public void verifypdfFileTextUnzipFolder(String fileName, String textToVerify) throws IOException{
		boolean pdfFlag = false;
		int k;
		ArrayList<String> allpdfFiels = this.unzipper.listPdfFiles(unzipFilesLoc);

		int pdffilesCnt = allpdfFiels.size();

		for (k = 0; pdffilesCnt > k; k++) {
			if (allpdfFiels.get(k).contains(fileName)) {
				String actualFileLoc = unzipFilesLoc + "//" + allpdfFiels.get(k);
				pdfFlag = pdfObject.verifyPDFContent(actualFileLoc, textToVerify);
				break;
			}
		}

		//  Assert.assertTrue(textToVerify + " Text is not present on the PDF File : " + allpdfFiels.get(k), pdfFlag);
		verifyTest(textToVerify + " Text is not present on the PDF File : " + allpdfFiels.get(k), pdfFlag);
	}


	public void unzipFiles() {
		ArrayList<String> allZipFiels = this.unzipper.listZipFiles(zippedFileLocation);
		try {
			int zipfilesCnt = allZipFiels.size();
			for (int i = 0; zipfilesCnt > i; i++) {
				this.unzipper.unzip(zippedFileLocation + allZipFiels.get(i), unzipFilesLoc);
			}
		} catch (Exception e) {
			System.out.println("Issues got while performing Unzip Operations, Please see the Stack Trace");
			e.printStackTrace();
		}

	}

	public String hyperSeparatedSSN() {
		actualSSN = getExcelData().get("SSN");
		//          String firstHyper = actualSSN.substring(0,3);
		String firstHyper = actualSSN.substring(0, 3);
		String secondHyper = actualSSN.substring(3, 5);
		String thirdHyper = actualSSN.substring(5, 9);
		String hySSN = firstHyper + "-" + secondHyper + "-" + thirdHyper;
		System.out.println(hySSN);
		return hySSN;
	}

	//---------------------------------------------------------------------------------
	//-----------This method is used to validate the Text file content(State Export)

	/**
	 *
	 * @param fileName : Partial Name of the file
	 * @param textToVerify : Text/Number which you want to verify
	 * @param location : Location for text Start
	 * @param to : location of Text End
	 */
	public void verifyTextFile(String fileName, String textToVerify, int location , int to) {
		boolean textFlag = false;
		int l;

		ArrayList<String> allpdfFiels = this.unzipper.listTextFiles(unzipFilesLoc);

		int pdffilesCnt = allpdfFiels.size();

		for (l = 0; pdffilesCnt > l; l++) {
			if (allpdfFiels.get(l).contains(fileName)) {
				String actualFileLoc = unzipFilesLoc + "//" + allpdfFiels.get(l);
				textFlag = textFileObj.verifytextfilewithloc(actualFileLoc, textToVerify, location, to);
				break;
			}
		}
		// Assert.assertTrue(textToVerify + " Text is not present on the txt File : " + allpdfFiels.get(l), textFlag);
		verifyTest(textToVerify + " Text is present on the txt File : " + allpdfFiels.get(l), textFlag);

	}

	//---------------------------------------------------------------------------------
	//-----------This method is used ti validate the xml file content(State Export)

	/**
	 *
	 * @param fileName : Partial Name of the file
	 * @param textToVerify : Text/Number which you want to verify
	 * @param Attribute : Attribute Name, First Name & Last Name, Attribute Name in XML
	 * @param node : Node Name in XML
	 */
	public void verifyXmlFile(String fileName, String textToVerify, String Attribute, String node) {
		boolean textFlag = false;
		int l;

		ArrayList<String> allxmlFiels = this.unzipper.listXmlFiles(unzipFilesLoc);

		int pdffilesCnt = allxmlFiels.size();

		for (l = 0; pdffilesCnt > l; l++) {
			if (allxmlFiels.get(l).contains(fileName)) {
				String actualFileLoc = unzipFilesLoc + "//" + allxmlFiels.get(l);
				textFlag = xmlVal.xmlvalidate(actualFileLoc,textToVerify,Attribute,node);
				break;
			}
		}
		// Assert.assertTrue(textToVerify + " Text is not present on the txt File : " + allpdfFiels.get(l), textFlag);
		verifyTest(textToVerify + " Text is present on the xml File : " + allxmlFiels.get(l), textFlag);

	}
	//----------------------------------------------------------------------------
	//----------------This method is used to Validate text file values separated by pipe ()
	//Indexing start from 0

	/**
	 *
	 * @param fileName : Partial Name of the file
	 * @param textToVerify : Text/Number which you want to verify
	 * @param pipeLocStart : Pipe location, if you want to test 1st value put it 0
	 * @param formValue : Form Name 8850 or 8061 else keep blank if you dont have form.
	 */
	public void verifyTextWithPipeSep(String fileName, String textToVerify, int pipeLocStart , String formValue) {
		boolean textFlag = false;
		int l;

		ArrayList<String> allpdfFiels = this.unzipper.listTextFiles(unzipFilesLoc);

		int pdffilesCnt = allpdfFiels.size();

		for (l = 0; pdffilesCnt > l; l++) {
			if (allpdfFiels.get(l).contains(fileName)) {
				String actualFileLoc = unzipFilesLoc + "//" + allpdfFiels.get(l);
				textFlag = textFileObj.verifytextfilewitPipeSep(actualFileLoc, textToVerify, pipeLocStart,formValue);
				break;
			}
		}
		// Assert.assertTrue(textToVerify + " Text is not present on the txt File : " + allpdfFiels.get(l), textFlag);
		verifyTest(textToVerify + " Text is present on the txt File : " + allpdfFiels.get(l), textFlag);
	}

	//----------------------------------------------------------------------------
	//----------------This method is used to Validate text file content Comma values()
	//Indexing start from 0 for pipeLocStart
	//Indexing start from 1 for pipeLocStart

	/**
	 *
	 * @param fileName : Partial Name of the file
	 * @param textToVerify : Text/Number which you want to verify
	 * @param start : Location for starting of files
	 */
	public void verifyTextWithCommaSeparated(String fileName, String textToVerify, int start) {
		boolean textFlag = false;
		int l;
		ArrayList<String> allpdfFiels = this.unzipper.listTextFiles(unzipFilesLoc);

		int pdffilesCnt = allpdfFiels.size();

		for (l = 0; pdffilesCnt > l; l++) {
			if (allpdfFiels.get(l).contains(fileName)) {
				String actualFileLoc = unzipFilesLoc + "//" + allpdfFiels.get(l);
				textFlag = textFileObj.verifytextfilewithCommaSeparated(actualFileLoc, textToVerify, start);
				break;
			}
		}
		// Assert.assertTrue(textToVerify + " Text is not present on the txt File : " + allpdfFiels.get(l), textFlag);
		verifyTest(textToVerify + "Text is present on the txt File : " + allpdfFiels.get(l), textFlag);
	}

	//----------------------------------------------------------------------------
	//----------------This method is used to Validate csv file content comma values separated()
	//Indexing start from 0

	/**
	 *
	 * @param fileName : Partial Name of the file
	 * @param textToVerify  : Text/Number which you want to verify
	 * @param textLoc : Location of text
	 * @throws IOException : Exception Type
	 */
	public void verifycsvValues(String fileName, String textToVerify, int textLoc) throws IOException {
		boolean textFlag = false;
		int l;
		ArrayList<String> allpdfFiels = this.unzipper.listcsvFiles(unzipFilesLoc);
		int pdffilesCnt = allpdfFiels.size();
		for (l = 0; pdffilesCnt > l; l++) {
			if (allpdfFiels.get(l).contains(fileName)) {
				String actualFileLoc = unzipFilesLoc + "//" + allpdfFiels.get(l);
				textFlag = csvfiles.csvValidate(actualFileLoc,textToVerify, textLoc);
				break;
			}
		}
		// Assert.assertTrue(textToVerify + " Text is not present on the txt File : " + allpdfFiels.get(l), textFlag);
		verifyTest(textToVerify + "Text is present on the txt File : " + allpdfFiels.get(l), textFlag);
	}

	/**
	 *
	 * @param fileName : Partial Name of the file
	 * @param textToVerify  : Text/Number which you want to verify
	 * @throws IOException : Exception Type
	 */
	public void verifyxlsValues(String fileName, String textToVerify, String cellReferance) throws IOException {
		boolean textFlag = false;
		int l;
		ArrayList<String> allpdfFiels = this.unzipper.listxlsFiles(unzipFilesLoc);
		int pdffilesCnt = allpdfFiels.size();
		for (l = 0; pdffilesCnt > l; l++) {
			if (allpdfFiels.get(l).contains(fileName)) {
				String actualFileLoc = unzipFilesLoc + "//" + allpdfFiels.get(l);
				textFlag = xlsfileValid.xlsValidate(actualFileLoc,cellReferance,textToVerify);
				break;
			}
		}
		// Assert.assertTrue(textToVerify + " Text is not present on the txt File : " + allpdfFiels.get(l), textFlag);
		verifyTest(textToVerify + "Text is present on the txt File : " + allpdfFiels.get(l), textFlag);
	}



	public void test(String fsuDates ){

		System.out.println(fsuDates);

	}

	public String currentdateMmDdYyFormat()
	{
		/**
		 * create SimpleDateFormat Object to convert the date in particular string format
		 */
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date dt = new Date();

		/**
		 * format method is used to convert the date in MM/dd/yyyy format
		 */
		System.out.println("Date in MM/dd/yyyy format: "+df.format(dt));
		String currentDate = String.valueOf(df.format(dt));
		String lasttwovalues=currentDate.substring(currentDate.length() - 2);
		currentDate = currentDate.substring(0, currentDate.length() - 4);
		currentDate=currentDate+lasttwovalues;
		System.out.println(currentDate);
		return currentDate;

	}

	public String currentdatemmddyyyy() {
		/**
		 * create SimpleDateFormat Object to convert the date in particular string format
		 */
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date dt = new Date();

		/**
		 * format method is used to convert the date in MM/dd/yyyy format
		 */
		System.out.println("Date in MM/dd/yyyy format: " + df.format(dt));
		String currentDate = String.valueOf(df.format(dt));
		return currentDate;
	}

	public String FSUdateMmDdYyFormat()
	{
		/**
		 * Object to convert the date in particular string format
		 */
		String FSUhireDate=null;
		if (getExcelData().get("HIRE_CURRENT_DATE").equalsIgnoreCase("NO")) 
		{
			FSUhireDate= getExcelData().get("HIRE_DATE");
			String lasttwovalues=FSUhireDate.substring(FSUhireDate.length() - 2);
			FSUhireDate = FSUhireDate.substring(0, FSUhireDate.length() - 4);
			FSUhireDate=FSUhireDate+lasttwovalues;
			System.out.println(FSUhireDate);
		}
		else
		{
			FSUhireDate=currentdateMmDdYyFormat();
		}


		return FSUhireDate;

	}

	public String currentdateYyyyMmDdFormat()
	{
		/**
		 * create SimpleDateFormat Object to convert the date in particular string format
		 */
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		Date dt = new Date();

		/**
		 * format method is used to convert the date in yyyy/MM/dd format
		 */
		System.out.println("Date in yyyy/MM/dd format: "+df.format(dt));
		String currentDate = String.valueOf(df.format(dt));

		System.out.println("Date after: "+currentDate);
		return currentDate;

	}
	public void renameFiletoTXT(String filename)
	{
		File directory = new File(unzipFilesLoc);
		//get all the files from a directory
		File[] fList = directory.listFiles();
		for (File file : fList) {
			if (file.isFile() && file.getName().contains(filename)) {	
				Date myDate = new Date();	
				String currDate=new SimpleDateFormat("MM-dd-yyyy").format(myDate);
				filename=filename+".txt."+currDate;
				File f = new File(unzipFilesLoc + "//" +filename); 

				f.renameTo(new File(unzipFilesLoc + "//" +filename+".txt"));
				System.out.println("conversion is done");
				break;
			}
		}

	}

	@Then("User should be able to see all the correct details on Exported Files for OK State")
	@Aliases(values={"User should be able to see all the correct details on Exported Files for NC State",
			"User should be able to see all the correct details on Exported Files for VI State",
			"User should be able to see all the correct details on Exported Files for WV State",
			"User should be able to see all the correct details on Exported Files for VA State",
			"User should be able to see all the correct details on Exported Files for UT State",
			"User should be able to see all the correct details on Exported Files for SC State",			
			"User should be able to see all the correct details on Exported Files for IA State",
			"User should be able to see all the correct details on Exported Files for AL State",
			"User should be able to see all the correct details on Exported Files for TN State",
			"User should be able to see all the correct details on Exported Files for GA State",
			"User should be able to see all the correct details on Exported Files for OH State1",
			"User should be able to see all the correct details on Exported Files for MS State",
            "User should be able to see all the correct details on Exported Files for DC State",
            "User should be able to see all the correct details on Exported Files for AZ State"})
	public void verifyPsnDolFiles() throws Exception{
		try {
			//String inputSSN = "222770018";
			//getExcelData().put("SSN", inputSSN);
			verifyDOLfsuPSNupdateFiles();
		} catch (IOException e) {            
			e.printStackTrace();
			verifyTest("User should be able to see all the correct details on Exported Files", false);
		}
	}

	public void VerifyStateExportTextFileForKYFamily(String FileName){

		verifyTextFile(FileName, getExcelData().get("KY_FAMILY_VERSION"), 0 , 6);
		verifyTextFile(FileName, getExcelData().get("FEIN_NUMBER"), 12 , 21);
		verifyTextFile(FileName, getExcelData().get("KY_FAMILY_FILENAME"), 12 , 21);
		verifyTextFile(FileName, getExcelData().get("KY_FAMILY_NUMBER_RECORDS"), 12 , 21);        


		verifyTextFile(FileName, getExcelData().get("LNAME").toUpperCase(), 41 , 60);
		verifyTextFile(FileName, getExcelData().get("FNAME").toUpperCase(), 30 , 40);
		verifyTextFile(FileName, getExcelData().get("MNAME").toUpperCase(), 40 , 41);
		verifyTextFile(FileName, getExcelData().get("SSN"), 21 , 30);

		//verifyTextFile(FileName, getExcelData().get("DOB"), 60 , 90);

		verifyTextFile(FileName, getExcelData().get("HOME_STREET_ADDRESS").toUpperCase(), 60 , 90);
		verifyTextFile(FileName, getExcelData().get("CITY").toUpperCase(), 90 , 110);
		verifyTextFile(FileName, getExcelData().get("STATE").toUpperCase(), 110 ,112);
		verifyTextFile(FileName, getExcelData().get("ZIP"), 112, 117);

		/*verifyTextFile(FileName, getExcelData().get("COMPANY_NAME").toUpperCase(), 900 , 950);
        verifyTextFile(FileName, getExcelData().get("EMPLOYER_ADDRESS").toUpperCase(), 950 , 980);
        verifyTextFile(FileName, getExcelData().get("EMPLOYER_CITY").toUpperCase(), 1010 , 1030);
        verifyTextFile(FileName, getExcelData().get("EMPLOYER_STATE").toUpperCase(), 1030 , 1032);
        verifyTextFile(FileName, getExcelData().get("EMPLOYER_ZIP"), 1032 , 1037);*/

	}

	@Then("Verify State Export Data file for state NC")
	public void VerifyStateExport_NC(){
		VerifyStateExportTextFileForKYFamily("nc8850");
	}


    @Then("User should be able to see all the correct details on MD Exported Files")
	public void verifyStateExportMD() throws Exception {
		verifyStateExportMO("md8850");
	}

	@Then("User should be able to see all the correct details on MA Exported Files")
	public void verifyStateExportMA() throws Exception {
		verifyStateExportMO("ma8850");
	}


	@Then("Verify State Export Data file for state VA")
	public void VerifyStateExport_VA(){
		VerifyStateExportTextFileForKYFamily("va8850");
	}
	@Then("Verify State Export Data file for state IA")
	public void VerifyStateExport_IA(){
		renameFiletoTXT("ia8850");
		//		VerifyStateExport_TextFilefor_MD_Family("ia8850");
	}
	@Then("Verify State Export Data file for state GA")
	public void VerifyStateExport_GA(){
		//	VerifyStateExport_TextFilefor_MD_Family("ga8850");
	}
	@Then("Verify State Export Data file for state AL")
	public void VerifyStateExport_AL(){
		VerifyStateExport_TextFile("AL8850");
	}
	@Then("Verify State Export Data file for state TN")
	public void VerifyStateExport_TN(){
		VerifyStateExport_TextFile("TN8850");
	}
	
	@Then("User should be able to see all the correct details on Exported Files for KS State")
	public void verifyDOLfsuPSNFileForManualKeyIn() throws Exception {
		try {
			unzipFiles();
			//PSN Update Reports Validation
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("FNAME"));
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("COMPANY_NAME"));
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("UNIT_STATE"));
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("HIRE_UNIT_NAME"));
			System.out.println("PSN Update Report SSN is : -" + hyperSeparatedSSN());
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", currentdateMmDdYyFormat());
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", "U");


			//  FSU Files Validation
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("FNAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("LNAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("HIRE_UNIT_NAME"));
			verifypdfFileTextDowloadFolder("FSU", FSUdateMmDdYyFormat());
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("COMPANY_NAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("SSN"));
			System.out.println("WOTC Report SSN is : -" + hyperSeparatedSSN());	


			//DOL Forms Validations
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("FNAME"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("LNAME"));
			//verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_UNIT_NAME").toUpperCase());			
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_UNIT_NAME"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("UNIT_CITY"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("UNIT_STATE"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_WAGE"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_WAGE"));

		} catch (Exception e) {            
			e.printStackTrace();
			verifyTest("User should be able to see all the correct details on DOLfsuPSNupdate Files verifyDOLfsuPSNFileForManualKeyIn()", false);
		}
	}

	@Then("User should be able to see all the correct details on Exported Files for LA State")
	public void verifyLAStateManualKeyInExport() throws Exception {
		String FileName="la8850";
		try {
			String fsuDatef = this.fsuDate.format(this.date);
			String actualSSN = getExcelData().get("SSN");
			unzipFiles();

			//PSN Update Reports Validation
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("FNAME"));
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("COMPANY_NAME"));
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("UNIT_STATE"));
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("HIRE_UNIT_NAME"));
			System.out.println("PSN Update Report SSN is : -" + hyperSeparatedSSN());
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", currentdateMmDdYyFormat());
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", "U");


			//FSU Files Validation
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("FNAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("LNAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("HIRE_UNIT_NAME"));
			verifypdfFileTextDowloadFolder("FSU", currentdateMmDdYyFormat());
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("COMPANY_NAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("SSN"));
			System.out.println("WOTC Report SSN is : -" + hyperSeparatedSSN());

			//DOL Forms Validations
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("FNAME"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("LNAME"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_UNIT_NAME"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("UNIT_CITY"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("UNIT_STATE"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_WAGE"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_WAGE"));


			//Write State Export for LA State
			verifyTextFile(FileName, getExcelData().get("SSN"), 192 , 201);
			verifyTextFile(FileName, getExcelData().get("FNAME"), 64 , 128);
			verifyTextFile(FileName, getExcelData().get("MNAME"), 128 , 192);
			verifyTextFile(FileName, getExcelData().get("LNAME"), 0 , 63);

			verifyTextFile(FileName, getExcelData().get("HOME_STREET_ADDRESS"), 209 , 337);
			verifyTextFile(FileName, getExcelData().get("CITY"), 337 , 369);
			verifyTextFile(FileName, getExcelData().get("STATE"), 369 ,371);

			verifyTextFile(FileName, getExcelData().get("FNAME").toUpperCase(), 64 , 128);
			verifyTextFile(FileName, getExcelData().get("MNAME").toUpperCase(), 128 , 192);
			verifyTextFile(FileName, getExcelData().get("LNAME").toUpperCase(), 0 , 63);

			verifyTextFile(FileName, getExcelData().get("HOME_STREET_ADDRESS").toUpperCase(), 209 , 337);
			verifyTextFile(FileName, getExcelData().get("CITY").toUpperCase(), 337 , 369);
			verifyTextFile(FileName, getExcelData().get("STATE").toUpperCase(), 369 ,371);

			verifyTextFile(FileName, getExcelData().get("ZIP"), 371, 376);
			String dateformat = currentdateYyyyMmDdFormat();

			verifyTextFile(FileName, dateformat.replace("/",""), 430, 438);
			verifyTextFile(FileName, dateformat.replace("/",""), 438, 446);
			verifyTextFile(FileName,dateformat.replace("/",""), 446, 454);
			verifyTextFile(FileName, dateformat.replace("/",""), 454, 462);


            verifyTextFile(FileName, getExcelData().get("COMPANY_NAME").toUpperCase(), 519 , 583);
			verifyTextFile(FileName, getExcelData().get("EMPLOYER_ADDRESS"), 593 , 721);
			verifyTextFile(FileName, getExcelData().get("EMPLOYER_CITY"), 721 , 753);
			verifyTextFile(FileName, getExcelData().get("EMPLOYER_STATE"), 753 , 755);
			verifyTextFile(FileName, getExcelData().get("EMPLOYER_ZIP"), 755 , 760);

		} catch (IOException e) {
			verifyTest("User should be able to see all the correct details on verifyState LA Export Files", false);
			e.printStackTrace();
		}

	}

					/*
This methos is used for Validation of Manual Key in State Exprot files(FL)
	 */
		@Then("User should be able to see all the correct Values on Exported Files for Florida State")
		public void verifyStateFLstate() throws Exception {

			try {
				String fsuDatef = this.fsuDate.format(this.date);
				String actualSSN = getExcelData().get("SSN");
				unzipFiles();
			//PSN Update Reports Validation
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("FNAME"));
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("COMPANY_NAME"));
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("UNIT_STATE"));
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("HIRE_UNIT_NAME"));
			System.out.println("PSN Update Report SSN is : -" + hyperSeparatedSSN());
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", currentdateMmDdYyFormat());
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", "U");


			//FSU Files Validation
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("FNAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("LNAME"));
			verifypdfFileTextDowloadFolder("FSU", currentdateMmDdYyFormat());

			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("COMPANY_NAME"));

			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("SSN"));
			System.out.println("WOTC Report SSN is : -" + hyperSeparatedSSN());

			//DOL Forms Validations
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("FNAME"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("LNAME"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_UNIT_NAME"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("UNIT_CITY"));
		//	verifypdfFileTextUnzipFolder("DOL", getExcelData().get("UNIT_STATE"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_WAGE"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_WAGE"));

			//STATE Export
verifyTextWithCommaSeparated("FL8850", getExcelData().get("FEIN_NUMBER"),0);
			verifyTextWithCommaSeparated("FL8850", getExcelData().get("LNAME"),1);
			verifyTextWithCommaSeparated("FL8850", getExcelData().get("FNAME"),2);
			verifyTextWithCommaSeparated("FL8850", getExcelData().get("SSN"),4);
			verifyTextWithCommaSeparated("FL8850", getExcelData().get("HOME_STREET_ADDRESS"),5);
			verifyTextWithCommaSeparated("FL8850", getExcelData().get("CITY"),7);
			verifyTextWithCommaSeparated("FL8850", getExcelData().get("STATE"),8);
			verifyTextWithCommaSeparated("FL8850", getExcelData().get("ZIP"),9);
			verifyTextWithCommaSeparated("FL8850", getExcelData().get("DOB"),10);
			verifyTextWithCommaSeparated("FL8850", "N",11);
			verifyTextWithCommaSeparated("FL8850", "BYEGHIWKAL",12);
			verifyTextWithCommaSeparated("FL8850", "Miami-dade",14);
			verifyTextWithCommaSeparated("FL8850", "RECEIPENT TANF",15);
			verifyTextWithCommaSeparated("FL8850", "PRIMARY",16);
			
			
			
			verifyTextWithCommaSeparated("FL8850", currentdatemmddyyyy(),19);
			verifyTextWithCommaSeparated("FL8850", currentdatemmddyyyy(),20);
			verifyTextWithCommaSeparated("FL8850", currentdatemmddyyyy(),21);
			verifyTextWithCommaSeparated("FL8850", currentdatemmddyyyy(),22);
			verifyTextWithCommaSeparated("FL8850", getExcelData().get("HIRE_WAGE"),23);
			verifyTextWithCommaSeparated("FL8850", getExcelData().get("HIRE_JOB_POSITION"),24);
			
			verifyTextWithCommaSeparated("FL8850", "118",25);
			

		} catch (Exception e) {
			e.printStackTrace();
			verifyTest("User should be able to see all the correct Values on Exported Files for Florida State", false);
		}
	}

	@Then("User should be able to see all the correct details on Exported Files for MN State")
	public void verifyStateExportMN() throws Exception {
		try {

			String fsuDatef = this.fsuDate.format(this.date);
			String actualSSN = getExcelData().get("SSN");
			unzipFiles();

			//PSN Update Reports Validation
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("FNAME"));
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("COMPANY_NAME"));
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("UNIT_STATE"));
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", getExcelData().get("HIRE_UNIT_CODE"));
			System.out.println("PSN Update Report SSN is : -" + hyperSeparatedSSN());
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", currentdateMmDdYyFormat());
			verifypdfFileTextDowloadFolder("PSNUPDATEREPORT", "U");


			//  FSU Files Validation
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("FNAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("LNAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("HIRE_UNIT_CODE"));
			verifypdfFileTextDowloadFolder("FSU", FSUdateMmDdYyFormat());
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("COMPANY_NAME"));
			verifypdfFileTextDowloadFolder("FSU", getExcelData().get("SSN"));
			System.out.println("WOTC Report SSN is : -" + hyperSeparatedSSN());


			//WOTC Forms Validations
			verifypdfFileTextUnzipFolder("WOTC","Pre-Screening Notice and Certification Request for");
			verifypdfFileTextUnzipFolder("WOTC","the Work Opportunity Credit");

			verifypdfFileTextUnzipFolder("WOTC", getExcelData().get("FNAME"));
			verifypdfFileTextUnzipFolder("WOTC", getExcelData().get("LNAME"));
			verifypdfFileTextUnzipFolder("WOTC", getExcelData().get("CITY"));
			verifypdfFileTextUnzipFolder("WOTC", "8850");
			verifypdfFileTextUnzipFolder("WOTC", getExcelData().get("DOB"));
			verifypdfFileTextUnzipFolder("WOTC", getExcelData().get("HOME_STREET_ADDRESS"));
			// verifypdfFileTextUnzipFolder("WOTC", wotc_Telephone_Number_Format());
			System.out.println("WOTC Report SSN is : -" + hyperSeparatedSSN());


			//DOL Forms Validations
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("FNAME"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("LNAME"));
			//verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_UNIT_NAME").toUpperCase());
			/*
			 *Updated Unit Name Function Vikas Verma
			 */
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_UNIT_CODE"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("UNIT_CITY"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("UNIT_STATE"));
			verifypdfFileTextUnzipFolder("DOL", getExcelData().get("HIRE_WAGE"));

// State Export validation
			verifyTextFile("mn8850", getExcelData().get("FEIN_NUMBER"), 0 , 9);
			verifyTextFile("mn8850", getExcelData().get("SSN"), 10 , 20);
			verifyTextFile("mn8850", getExcelData().get("FNAME"), 20 , 32);
			verifyTextFile("mn8850", getExcelData().get("LNAME").trim(), 33 , 45);
			//verifyTextFile("mn8850", dateFormatForTextFile(getExcelData().get("DOB")), 46 , 56);
			//verifyTextFile("mn8850", getExcelData().get("HOME_STREET_ADDRESS").toUpperCase(), 57 , 87);
			//verifyTextFile("mn8850", getExcelData().get("CITY").toUpperCase(), 88 , 93);
//			verifyTextFile("mn8850", getExcelData().get("STATE").toUpperCase(), 100 , 103);
//			verifyTextFile("mn8850", getExcelData().get("EMPLOYEER_ZIP_CODE").toUpperCase(), 104 , 109);
//			verifyTextFile("mn8850", dateFormatForTextFile(currentdate()), 111 , 122);
//			verifyTextFile("mn8850", dateFormatForTextFile(currentdate()), 123 , 134);
//			verifyTextFile("mn8850", dateFormatForTextFile(currentdate()), 135 , 146);
//			verifyTextFile("mn8850", dateFormatForTextFile(currentdate()), 147 , 158);
//			verifyTextFile("mn8850", getExcelData().get("HIRE_WAGE"), 161 , 167);

		} catch (Exception e) {
			verifyTest("User should be able to see all the correct details on Exported Files for MN State", false);
			e.printStackTrace();
		}
	}
	
	@Then("User should be able to see all the correct Values on Exported Files for UT State")
	public void verifyStateUTstate() throws Exception {

		try {
			String fsuDatef = this.fsuDate.format(this.date);
			String actualSSN = getExcelData().get("SSN");
			unzipFiles();
			
			
			//verifyTextWithCommaSeparated("UT 04132017", getExcelData().get("FEIN_NUMBER"),0);
			//verifyTextWithCommaSeparated("UT", getExcelData().get("LNAME"),1);
			
			
			verifyTextWithCommaSeparated("UT", getExcelData().get("FNAME"),1);
			verifyTextWithCommaSeparated("UT", getExcelData().get("SSN"),2);
			//verifyTextWithCommaSeparated("UT", getExcelData().get("DOB").trim(),3);
			verifyTextWithCommaSeparated("UT", getExcelData().get("HOME_STREET_ADDRESS"),4);
			verifyTextWithCommaSeparated("UT", getExcelData().get("CITY"),5);
			verifyTextWithCommaSeparated("UT", getExcelData().get("STATE"),6);
			verifyTextWithCommaSeparated("UT", getExcelData().get("ZIP"),7);
			
			//verifyTextWithCommaSeparated("UT", currentdate().trim(),9);
		//	verifyTextWithCommaSeparated("UT", currentdate().trim(),10);
			verifyTextWithCommaSeparated("UT", "N",11);
			verifyTextWithCommaSeparated("UT", getExcelData().get("HIRE_WAGE"),12);
			verifyTextWithCommaSeparated("UT", "430000",13);
			verifyTextWithCommaSeparated("UT",  getExcelData().get("FEIN_NUMBER"),14);
			
			verifyTextWithCommaSeparated("UT", "Y",15);
			verifyTextWithCommaSeparated("UT", "Y",16);
			verifyTextWithCommaSeparated("UT", "UT",17);
			verifyTextWithCommaSeparated("UT", "Y",18);
			verifyTextWithCommaSeparated("UT", "N",19);
			
			verifyTextWithCommaSeparated("UT", "N",20);
			verifyTextWithCommaSeparated("UT", "Y",21);
			verifyTextWithCommaSeparated("UT", "Y",22);
			verifyTextWithCommaSeparated("UT", "UT",23);
			verifyTextWithCommaSeparated("UT", "N",24);
			
			verifyTextWithCommaSeparated("UT", "N",25);
			verifyTextWithCommaSeparated("UT", "Y",26);
			verifyTextWithCommaSeparated("UT", "Y",27);
			verifyTextWithCommaSeparated("UT", "Y",28);
			verifyTextWithCommaSeparated("UT", "Y",29);
			
			verifyTextWithCommaSeparated("UT", "Y",30);
			verifyTextWithCommaSeparated("UT", "UT",31);
			verifyTextWithCommaSeparated("UT", "N",32);
			verifyTextWithCommaSeparated("UT", "N",33);
			verifyTextWithCommaSeparated("UT", "N",34);
			verifyTextWithCommaSeparated("UT", "N",35);
			
			verifyTextWithCommaSeparated("UT", "N",36);
			verifyTextWithCommaSeparated("UT", "Y",37);
			verifyTextWithCommaSeparated("UT", "N",38);
			verifyTextWithCommaSeparated("UT", "Y",39);
			
			
			
		}catch (Exception e) {
			verifyTest("User should be able to see all the correct details on Exported Files for MN State", false);
			e.printStackTrace();
		}
	}

	@Then("User should be able to see all the correct details on state Exported Files for OH State")
	public void verifyStateOHstate() throws Exception {

		try {
			String fsuDatef = this.fsuDate.format(this.date);
			String actualSSN = getExcelData().get("SSN");
			unzipFiles();
			//System.out.println(getExcelData().get("FEIN_NUMBER"));
			
			verifyTextFile("oh8850", "432993792", 0 , 9);
			verifyTextFile("oh8850", getExcelData().get("COMPANY_NAME").toUpperCase(), 10 , 16);
			verifyTextFile("oh8850", "3529 WEST KEMPER RD", 16 ,35);
			verifyTextFile("oh8850", "CINCINNATI", 35 ,47);
			
			verifyTextFile("oh8850", "OH", 47 ,50);
			verifyTextFile("oh8850", "45251", 50 ,56);
			verifyTextFile("oh8850", "4444444444", 56 ,67);
			
			
			verifyTextFile("oh8850", "VIKAS.VERMA@ADP.COM", 67 ,87);
			verifyTextFile("oh8850", getExcelData().get("SSN"), 87 ,97);
			verifyTextFile("oh8850", getExcelData().get("FNAME"), 97 ,103);
			verifyTextFile("oh8850", "M", 103 ,105);
			verifyTextFile("oh8850", getExcelData().get("LNAME"),105, 111);
			//verifyTextFile("oh8850", "19980808", 111 ,120);
			verifyTextFile("oh8850", "3529 W KEMPER RD", 120 ,137);
			
			verifyTextFile("oh8850", "CINCINNATI", 137 ,149);
			verifyTextFile("oh8850", "OH", 149 ,152);			
			
			
		}catch (Exception e) {
			verifyTest("User should be able to see all the correct details on Exported Files for MN State", false);
			e.printStackTrace();
		}
	}

}
