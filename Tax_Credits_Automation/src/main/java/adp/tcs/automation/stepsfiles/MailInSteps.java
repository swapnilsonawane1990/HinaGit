package adp.tcs.automation.stepsfiles;

import adp.tcs.automation.locators.MailInLocators;
import adp.tcs.automation.pages.MailInPages;
import adp.tcs.automation.pages.MonitoringPages;
import adp.tcs.automation.pages.ScreeningPages;
import adp.tcs.automation.pages.SearchSSNthroughHub;
import adp.tcs.automation.utilities.TakeScreenshotAction;
import adp.tcs.automation.utilities.WndowAction;
import adp.tcs.automation.utilities.randomSSNgenrater;
import org.jbehave.core.annotations.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Thorasa on 10/12/2016.
 */
public class  MailInSteps extends BaseTempletSteps{

	private final SearchSSNthroughHub hub = new SearchSSNthroughHub();
	private final WndowAction windowAct = new WndowAction();
	private final MailInPages mailInElements = new MailInPages();
	private final MonitoringPages monitorElements = new MonitoringPages();
	private final HubValidationsSteps hubValidationsSteps = new HubValidationsSteps();
	private ScreeningPages screeningPages = new ScreeningPages();
	private randomSSNgenrater ssnGenerator = new randomSSNgenrater();
	private ScreeningPages scrningPages = new ScreeningPages();
	private TakeScreenshotAction screenshot = new TakeScreenshotAction();
	
	public void gotoMailInScreeningPage() throws Exception {
		try {
			/*hub.Search_SSN_Process_Tab().click();
			hub.Search_SSN_Process_Tax_Credit_Tab().click();
			hub.Search_SSN_Process_Tax_Credit_Operation_Tab().click();
	        explicitWaitForElement(SearchSSNHub.SEARCH_SSN_THE_HUB_LINK,65);
	        WebElement hubLink = hub.Search_SSN_The_Hub_Link();
	        sleep(2000);
	        windowAct.switchtoMultiChildWindow(hubLink);
	        explicitWaitForElement(SearchSSNHub.SEARCH_SSN_INPUTBOX,65);*/
			hub.navigateBackOffice();

			Actions action = new Actions(driver);
			//  WebElement mainMenu = driver.findElement(By.linkText("MainMenu"));
			action.moveToElement( monitorElements.data_Entry_Link()).moveToElement(mailInElements.mailInLinkOnDataEntry()).click().build().perform();
			Thread.sleep(2000);
	        sleep(2000);
		} catch (Exception e) {			
			e.printStackTrace();
			screenshot.getScreenshot("gotoMailInScreeningPage");
			verifyTest("User is on mail in page -- gotoMailInScreeningPage()", false);
		}
	}
	
	public void selectMailInCriteria(String companyName) throws Exception {
		try {
			mailInElements.mailInSearch().click();
			mailInElements.queuesDropdownBtn().click();
			selectDropdownValue(MailInLocators.QUEUES_DROPDOWN_VALUES_CONST, "Eligible");
			sleep(8000);
			waitForLoad();
			mailInElements.cmpInputBox().clear();
			mailInElements.cmpInputBox().sendKeys(companyName);
			sleep(3000);
			getDriver().findElement(By.xpath("//a[@class='ng-scope ng-binding'][.='"+companyName+"']")).click();
			hubValidationsSteps.unitNameSelection("IL_Unit1");
			sleep(2000);
			mailInElements.startScreeningBtn().click();
			sleep(15000);
			waitForLoad();
			//windowAct.switchtoChildWindow();
			windowAct.switchtoChildWindowOpen();
			sleep(2000);
		} catch (Exception e) {
			screenshot.getScreenshot("selectMailInCriteria");
			e.printStackTrace();
			verifyTest("User is on Mail In page -- selectMailInCriteria() ", false);
		}
	}
	
	public void performPersonalInfoPageActions() throws Exception{
    	try {
			String SSN = String.valueOf(ssnGenerator.generateSSN());			
			getExcelData().put("SSN", SSN);
			getExcelData().put("CSSN", SSN);
			screeningPages.personalInfo_SSN_TxtBox().clear();
			screeningPages.personalInfo_SSN_TxtBox().sendKeys(getExcelData().get("SSN"));// user input in SSN text field.
			sleep(2000);
			scrningPages.personalInfo_Continue_Button().click();
			sleep(5000);
			//screeningPages.personalInfo_ConfirmSSN_TxtBox().sendKeys(getExcelData().get("CSSN"));  // user input in Confirm SSN text field.
			mailInElements.personalInfoFirstNameTxtBox().clear();
			mailInElements.personalInfoFirstNameTxtBox().sendKeys(getExcelData().get("FNAME"));  // user input in First Name text field.
			mailInElements.personalInfoMiddleInitialTxtBox().clear();
			mailInElements.personalInfoMiddleInitialTxtBox().sendKeys(getExcelData().get("MNAME"));  // user input in Middle Name text field.
			mailInElements.personalInfoLastNameTxtBox().clear();
			mailInElements.personalInfoLastNameTxtBox().sendKeys(getExcelData().get("LNAME"));// user input in Last Name text field.
			mailInElements.personalInfoStreetAddressTxtBox().clear();
			mailInElements.personalInfoStreetAddressTxtBox().sendKeys(getExcelData().get("HOME_STREET_ADDRESS"));

			mailInElements.personalInfoCityTxtBox().clear();
			mailInElements.personalInfoCityTxtBox().sendKeys(getExcelData().get("CITY"));
			mailInElements.personalInfoZipTxtBox().clear();
			mailInElements.personalInfoZipTxtBox().sendKeys(getExcelData().get("ZIP"));  // user input in Telephone text field.
			mailInElements.personalInfoTelephoneTxtBox().clear();
			mailInElements.personalInfoTelephoneTxtBox().sendKeys(getExcelData().get("TELEPHONE"));  // user input in email address text field.
			mailInElements.personalInfoDOBTxtBox().clear();
			mailInElements.personalInfoDOBTxtBox().sendKeys("BOD");
			screeningPages.personalInfo_Continue_Button().click();  // Click on Personal info continue button.
		} catch (Exception e) {
			screenshot.getScreenshot("performPersonalInfoPageActions_MailIn");
			verifyTest("Faliure in performPersonalInfoPageActions page",false);
			e.printStackTrace();
		}
    }

	@Given("User Navigate to Mail In Screening Page")
	public void navigatToMailInKeyPage() throws Exception {
		String companyName = "Lockheed Martin Corp";
		getWait();
		sleep(5000);
		gotoMailInScreeningPage();
		//reset button click
	//	getDriver().findElement(By.xpath("//span[.='Reset']"));
		sleep(1000);
		selectMailInCriteria(companyName);
		try{
		}catch(Exception e){
			screenshot.getScreenshot("navigatToMailInKeyPage");
			System.out.println(e);
			verifyTest("Faliure in Mail In Screening",false);
		}
		}
	
	@Given("User perform Mail-In screening test")
    public void verifyPageActons() throws Exception{
    	try{
    	boolean flag = false;
    	boolean noMethodFlag = false;    	
        while (true) {        	
        	String pageToCall = null;
        	waitForLoad();
        	
        	sleep(2000);        	
        	pageToCall = screeningPages.screeningPageTitle().getText();        	     	
        	sleep(1000);        	
        	System.out.println("Screening started for "+ pageToCall);        	
            switch (pageToCall) {                
                case "Personal Information":
					performPersonalInfoPageActions();
                    break;
                    
                case "8850 Form Revision":
					mailInElements.form8850RevisionMarch2016().click();
                    break;

				case "Jan 12/Jun 15/Mar 16 Revision Checks":
					mailInElements.revisionCheckQ1().click();
					sleep(3000);
					scrningPages.personalInfo_Continue_Button().click();
					sleep(3000);
					scrningPages.personalInfo_Continue_Button().click();
					sleep(3000);
					mailInElements.revisionCheckQ5().click();
					sleep(3000);

					sleep(2000);
					mailInElements.applicantSignatureYes().click();
					sleep(2000);
					scrningPages.personalInfo_Continue_Button().click();
					sleep(2000);

					break;
				case "Confirm SSN":
					screeningPages.personalInfo_ConfirmSSN_TxtBox().sendKeys(getExcelData().get("CSSN"));
					break;

				case "Hire Information":
					mailInElements.hireInfoGaveInfoDate().sendKeys(getExcelData().get("HIRE_GAVE_INFO_DATE"));
					mailInElements.hireInfoJobOfferDate().sendKeys(getExcelData().get("HIRE_JOB_OFFER_DATE"));
					mailInElements.personalInfoHireDateTxtBox().clear();
					mailInElements.personalInfoHireDateTxtBox().sendKeys(getExcelData().get("HIRE_DATE"));
					mailInElements.personalInfoStartDateTxtBox().clear();
					mailInElements.personalInfoStartDateTxtBox().sendKeys(getExcelData().get("HIRE_START_DATE"));
					selectDropdown(mailInElements.hireInfoJobPosition(),getExcelData().get("HIRE_JOB_POSITION"));
					mailInElements.hireInfoStartWage().sendKeys(getExcelData().get("HIRE_WAGE"));
					sleep(2000);
					scrningPages.personalInfo_Continue_Button().click();
					break;

				case "8850 1 WOTC A":

					getDriver().findElement(By.xpath("(//INPUT[@type='checkbox'])[1]")).click();
					getDriver().findElement(By.xpath("(//INPUT[@type='checkbox'])[2]")).click();
					getDriver().findElement(By.xpath("(//INPUT[@type='checkbox'])[3]")).click();
					getDriver().findElement(By.xpath("(//INPUT[@type='checkbox'])[4]")).click();
					break;
				case "8850 1 WOTC B":

					getDriver().findElement(By.xpath("(//INPUT[@type='checkbox'])[1]")).click();
					getDriver().findElement(By.xpath("(//INPUT[@type='checkbox'])[2]")).click();
					getDriver().findElement(By.xpath("(//INPUT[@type='checkbox'])[3]")).click();
					getDriver().findElement(By.xpath("(//INPUT[@type='checkbox'])[4]")).click();
					break;

				case "8850 1 WTW":

					getDriver().findElement(By.xpath("(//INPUT[@type='checkbox'])[1]")).click();
					getDriver().findElement(By.xpath("(//INPUT[@type='checkbox'])[2]")).click();
					break;


				case "Signature":

					getDriver().findElement(By.xpath("//INPUT[@id='8850_1_SIGNATURE_Signature_YES']")).click();
					break;

				case "Military Service":

					getDriver().findElement(By.xpath("//INPUT[@id='Veteran_YES']")).click();
					sleep(2000);
					scrningPages.personalInfo_Continue_Button().click();
					break;

				case "Food Stamps":

					getDriver().findElement(By.xpath("//INPUT[@id='Veteran_Food_Stamps_YES']")).click();
					sleep(2000);
					scrningPages.personalInfo_Continue_Button().click();
					break;

				case "Vocational Rehabilitation":

					getDriver().findElement(By.xpath("//INPUT[@id='VocationRehab_Question_YES']")).click();
					sleep(2000);
					getDriver().findElement(By.xpath("//INPUT[@id='VocationalRehab_VocRehab_YesSA']")).click();
					sleep(2000);
					scrningPages.personalInfo_Continue_Button().click();
					break;

				case "Supplemental Security Income":

					getDriver().findElement(By.xpath("//INPUT[@id='SSI_YES']")).click();
					sleep(2000);
					scrningPages.personalInfo_Continue_Button().click();
					break;

				case "Felony Questions":

					getDriver().findElement(By.xpath("//INPUT[@id='Felony_Convicted_YES']")).click();
					sleep(2000);
					scrningPages.personalInfo_Continue_Button().click();
					break;

				case "Thank You Page":
					flag=true;
					System.out.println("Screening completed for mailIn type");
					break;
                default:
                    	
            }
            System.out.println("Screening complted for "+ pageToCall);
            if(flag == true){            	
        		System.out.println("Screening is completed!!!  for SSN : " + getExcelData().get("SSN"));
        		break;
            }
            if(noMethodFlag == true){
            	verifyTest("Expected page method is not developed",false);
        		break;
            }
        }
        verifyTest("User perform screening test");
    }catch(Exception e){
			screenshot.getScreenshot("verifyPageActons_MailIn_Step");
    	System.out.println(e);
    	verifyTest("Faliure in Mail-In Screening",false);
    }
    }
	
	
	
	
	
	
}
