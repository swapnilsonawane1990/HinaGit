package adp.tcs.automation.stepsfiles;

import adp.tcs.automation.locators.SearchSSNHub;
import adp.tcs.automation.pages.MonitoringPages;
import adp.tcs.automation.pages.SearchSSNthroughHub;
import adp.tcs.automation.utilities.OracleCon;
import adp.tcs.automation.utilities.ServiceCallResponse;
import adp.tcs.automation.utilities.TakeScreenshotAction;
import adp.tcs.automation.utilities.WndowAction;

import java.sql.CallableStatement;

import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;

/**
 * Created by Thorasa on 09/29/2016.
 */
public class DcoufreeSteps extends BaseTempletSteps{

	private String requestMethodType = "POST";
    private String requestContentType = "application/xml";
    private String responseContentType = "";
    private final ServiceCallResponse callResponse = new ServiceCallResponse();
    private final DocufreeRequests docufreeRequests = new DocufreeRequests();
    private final SearchSSNthroughHub hub = new SearchSSNthroughHub();
    private final WndowAction windowAct = new WndowAction();
    private final MonitoringPages monitorElements = new MonitoringPages();
    private final HubValidationsSteps hubValidation = new HubValidationsSteps();
	private TakeScreenshotAction screenshot = new TakeScreenshotAction();
    
    @When("Perform Docufree screening for eligible record")
	public void docufreeEligible() throws Exception{
		try {
			verifyTest("Perform Docufree screening for eligible record");
			String hireResponse = callResponse.getResponseForDocufree(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), getExcelData().get("AUTHORIZATION_CODE"), docufreeRequests.docufreeEligibleRequest());
			String confNumber = getTagValue(hireResponse, "/DocuFree/@status");
			if (!confNumber.equals("OK")) {
				verifyTest("Invalid docufree resonse ", false);
			}
		} catch (Exception e) {
			screenshot.getScreenshot("docufreeEligible");
			e.printStackTrace();
			verifyTest("Perform Docufree screening for eligible record : docufreeEligible() ", false);
		}
	}
    
    @When("Perform Docufree screening for Ineligible record")
	public void docufreeIneligible() throws Exception {
		try {
			verifyTest("Perform Docufree screening for Ineligible record");
			String hireResponse = callResponse.getResponseForDocufree(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), getExcelData().get("AUTHORIZATION_CODE"), docufreeRequests.docufreeIneligibleRequest());
			String confNumber = getTagValue(hireResponse, "/DocuFree/@status");
			if (!confNumber.equals("OK")) {
				verifyTest("Invalid docufree resonse", false);
			}
		} catch (Exception e) {
			screenshot.getScreenshot("docufreeIneligible");
			e.printStackTrace();
			verifyTest("Perform Docufree screening for Ineligible record : docufreeIneligible()", false);
		}
	}
    
    @When("Perform Docufree screening for Invalid Start Date")
    @Aliases(values={"Perform Docufree screening for Invalid Hire Date",
    		"Perform Docufree screening for Invalid SSN",
    		"Perform Docufree screening for Invalid Client Id",
    		"Perform Docufree screening for Invalid Company Id"})
	public void docufreeInvalidRequest() throws Exception{
		try {
			verifyTest("Perform Docufree screening for invalid request");
			String hireResponse = callResponse.getResponseForDocufree(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), getExcelData().get("AUTHORIZATION_CODE"), docufreeRequests.docufreeIncompleteRequest());
			String confNumber = getTagValue(hireResponse, "/DocuFree/@status");
			if (!confNumber.equals("OK")) {
				verifyTest("Invalid docufree resonse", false);
			}
		} catch (Exception e) {
			screenshot.getScreenshot("docufreeIneligible");
			e.printStackTrace();
			verifyTest("Perform Docufree screening : docufreeInvalidRequest() ", false);
		}
	}
    
    
    
    @When("Verify the record in monitoring section")
    public void verifyRecordInMonitoring(@Named("errorDescription") String errorDescriptionExpected) throws Exception{
		try {
			verifyTest("Verify the record in monitoring section");
			gotoHubPage();
			monitorElements.data_Entry_Link().click();
			monitorElements.monitoring_Link().click();		
			monitorElements.unique_Id_Text_Field_Monitoring().sendKeys(getExcelData().get("UNIQUE_ID"));
			monitorElements.search_Btn_Monitoring().click();			
			String errorDiscription = monitorElements.search_Result_Error_Desc_Field().getText();			
			if (!errorDiscription.equals(errorDescriptionExpected)) {
				verifyTest("Error Desciption is not matching : ACTUAL = " + errorDiscription + ", EXPECTED = "+ errorDescriptionExpected, false);
			}
		} catch (Exception e) {
			screenshot.getScreenshot("docufreeIneligible");
			e.printStackTrace();
			verifyTest("Verify the record in monitoring section : verifyRecordInMonitoring()", false);
		}
	}
    
    public void gotoHubPage() throws Exception{
		try {
//			hub.Search_SSN_Process_Tab().click();
//			hub.Search_SSN_Process_Tax_Credit_Tab().click();
//			hub.Search_SSN_Process_Tax_Credit_Operation_Tab().click();
//	        explicitWaitForElement(SearchSSNHub.SEARCH_SSN_THE_HUB_LINK,65);
//	        WebElement hubLink = hub.Search_SSN_The_Hub_Link();
//	        Thread.sleep(2000);
//	        windowAct.switchtoMultiChildWindow(hubLink);
//	        explicitWaitForElement(SearchSSNHub.SEARCH_SSN_INPUTBOX,65);
			 	sleep(2000);
		        waitForLoad();
		        explicitWaitForElement(SearchSSNHub.SELECT_OPERATION_TAB,65);
		        hub.CAPS_QA_ENVIRONEMT_Operation_Tab_Chg().click();
		        sleep(2000);
		        explicitWaitForElement(SearchSSNHub.THE_HUB_LINK,65);        
		        Thread.sleep(2000);
		        windowAct.switchtoMultiChildWindow(hub.CAPS_QA_Hub_New_Link());
		        explicitWaitForElement(SearchSSNHub.SEARCH_SSN_INPUTBOX,65);
		        sleep(2000);
		} catch (Exception e) {
			screenshot.getScreenshot("gotoHubPage");
			e.printStackTrace();
			verifyTest("User is in hub page -- gotoHubPage() ", false);
		}
	}
    
    @When("Verify the Record in hub search page")
    public void verifyRecordInHubSearchWithStatus() throws Exception {
		try {
			verifyTest("Verify the Record in hub search page");
			gotoHubPage();
			hubValidation.performHubSearch();
			sleep(2000);
			hubValidation.verifyHubeSearchResult();
		} catch (Exception e) {
			screenshot.getScreenshot("verifyRecordInHubSearchWithStatus");
			e.printStackTrace();
			verifyTest("User is in hub page -- gotoHubPage() ", false);
		}
	}
    
    @When("Perform docufree support docs request")
	public void docufreeSupportDocs() throws Exception{
		try {
			verifyTest("Perform docufree support docs request");
			String hireResponse = callResponse.getResponseForDocufree(getExcelData().get("DOCUFREE_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), getExcelData().get("AUTHORIZATION_CODE"), docufreeRequests.docufreeSupportingDocRequest());
			String confNumber = getTagValue(hireResponse, "/DocuFree/@status");
			if (!confNumber.equals("OK")) {
				verifyTest("Invalid docufree resonse for support docs ", false);
			}
		} catch (Exception e) {
			screenshot.getScreenshot("docufreeSupportDocs");
			e.printStackTrace();
			verifyTest("Perform Docufree screening for eligible record : docufreeSupportDocs() ", false);
		}
	}
    
    @When("Execute docufree job for status change")
	public void executeDocufreeJob() throws Exception{
		try {
			verifyTest("Execute docufree job for status change");
			OracleCon con= new OracleCon();
			CallableStatement cs =  con.getConnection().prepareCall("{call daily_scr_snapshot_etl.run}");
            cs.execute();
            con.getConnection().commit();
            sleep(180000);
		} catch (Exception e) {			
			e.printStackTrace();
			verifyTest("Execute docufree job for status change : executeDocufreeJob() ", false);
		}
	}
    
    @When("Perform docufree support docs request for driving lisence age and address")
	public void dlAgeAddress() throws Exception{
		try {
			verifyTest("Perform docufree support docs request for driving lisence age and address");			
			String hireResponse = callResponse.getResponseForDocufree(getExcelData().get("DOCUFREE_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), getExcelData().get("AUTHORIZATION_CODE"), docufreeRequests.dlAgeAddress());
			String confNumber = getTagValue(hireResponse, "/DocuFree/@status");
			if (!confNumber.equals("OK")) {
				verifyTest("Invalid docufree resonse for support docs ", false);
			}
		} catch (Exception e) {
			screenshot.getScreenshot("dlAgeAddress");
			e.printStackTrace();
			verifyTest("Perform Docufree support docs : dlAgeAddress() ", false);
		}
	}
    
    @When("Perform docufree support docs request for BirthCert Age")
	public void birthCertAge() throws Exception{
		try {
			verifyTest("Perform docufree support docs request for driving lisence age and address");			
			String hireResponse = callResponse.getResponseForDocufree(getExcelData().get("DOCUFREE_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), getExcelData().get("AUTHORIZATION_CODE"), docufreeRequests.birthCertAge());
			String confNumber = getTagValue(hireResponse, "/DocuFree/@status");
			if (!confNumber.equals("OK")) {
				verifyTest("Invalid docufree resonse for support docs ", false);
			}
		} catch (Exception e) {
			screenshot.getScreenshot("birthCertAge");
			e.printStackTrace();
			verifyTest("Perform Docufree support docs: birthCertAge() ", false);
		}
	}
    
    @When("Perform docufree support docs request for USPassport Age")
	public void usPassportAge() throws Exception{
		try {
			verifyTest("Perform docufree support docs request for driving lisence age and address");			
			String hireResponse = callResponse.getResponseForDocufree(getExcelData().get("DOCUFREE_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), getExcelData().get("AUTHORIZATION_CODE"), docufreeRequests.usPassportAge());
			String confNumber = getTagValue(hireResponse, "/DocuFree/@status");
			if (!confNumber.equals("OK")) {
				verifyTest("Invalid docufree resonse for support docs ", false);
			}
		} catch (Exception e) {
			screenshot.getScreenshot("usPassportAge");
			e.printStackTrace();
			verifyTest("Perform Docufree support docs: usPassportAge() ", false);
		}
	}
    
    @When("Perform docufree support docs request for VoterReg Age Address")
   	public void voterRegAgeAddress() throws Exception{
   		try {
   			verifyTest("Perform docufree support docs request for driving lisence age and address");   			
   			String hireResponse = callResponse.getResponseForDocufree(getExcelData().get("DOCUFREE_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), getExcelData().get("AUTHORIZATION_CODE"), docufreeRequests.voterRegAgeAddress());
   			String confNumber = getTagValue(hireResponse, "/DocuFree/@status");
   			if (!confNumber.equals("OK")) {
   				verifyTest("Invalid docufree resonse for support docs ", false);
   			}
   		} catch (Exception e) {
   			screenshot.getScreenshot("voterRegAgeAddress");
   			e.printStackTrace();
   			verifyTest("Perform Docufree support docs: voterRegAgeAddress() ", false);
   		}
   	}
    
    @When("Perform docufree support docs request for W4 Address")
   	public void w4Address() throws Exception{
   		try {
   			verifyTest("Perform docufree support docs request for driving lisence age and address");   			
   			String hireResponse = callResponse.getResponseForDocufree(getExcelData().get("DOCUFREE_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), getExcelData().get("AUTHORIZATION_CODE"), docufreeRequests.w4Address());
   			String confNumber = getTagValue(hireResponse, "/DocuFree/@status");
   			if (!confNumber.equals("OK")) {
   				verifyTest("Invalid docufree resonse for support docs ", false);
   			}
   		} catch (Exception e) {
   			screenshot.getScreenshot("w4Address");
   			e.printStackTrace();
   			verifyTest("Perform Docufree support docs: w4Address() ", false);
   		}
   	}
    
    @When("Perform docufree support docs request for RFV")
   	public void rfv() throws Exception{
   		try {
   			verifyTest("Perform docufree support docs request for driving lisence age and address");   			
   			String hireResponse = callResponse.getResponseForDocufree(getExcelData().get("DOCUFREE_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), getExcelData().get("AUTHORIZATION_CODE"), docufreeRequests.rfv());
   			String confNumber = getTagValue(hireResponse, "/DocuFree/@status");
   			if (!confNumber.equals("OK")) {
   				verifyTest("Invalid docufree resonse for support docs ", false);
   			}
   		} catch (Exception e) {
   			screenshot.getScreenshot("rfv");
   			e.printStackTrace();
   			verifyTest("Perform Docufree support docs: rfv() ", false);
   		}
   	}
    
    @When("Perform docufree support docs request for SSARel")
   	public void ssa() throws Exception{
   		try {
   			verifyTest("Perform docufree support docs request for driving lisence age and address");   			
   			String hireResponse = callResponse.getResponseForDocufree(getExcelData().get("DOCUFREE_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), getExcelData().get("AUTHORIZATION_CODE"), docufreeRequests.ssa());
   			String confNumber = getTagValue(hireResponse, "/DocuFree/@status");
   			if (!confNumber.equals("OK")) {
   				verifyTest("Invalid docufree resonse for support docs ", false);
   			}
   		} catch (Exception e) {
   			screenshot.getScreenshot("ssa");
   			e.printStackTrace();
   			verifyTest("Perform Docufree support docs: ssa() ", false);
   		}
   	}
    
    @When("Perform docufree support docs request for DD214")
   	public void dd214() throws Exception{
   		try {
   			verifyTest("Perform docufree support docs request for driving lisence age and address");   			
   			String hireResponse = callResponse.getResponseForDocufree(getExcelData().get("DOCUFREE_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), getExcelData().get("AUTHORIZATION_CODE"), docufreeRequests.dd214());
   			String confNumber = getTagValue(hireResponse, "/DocuFree/@status");
   			if (!confNumber.equals("OK")) {
   				verifyTest("Invalid docufree resonse for support docs ", false);
   			}
   		} catch (Exception e) {
   			screenshot.getScreenshot("dd214");
   			e.printStackTrace();
   			verifyTest("Perform Docufree support docs: dd214() ", false);
   		}
   	}
    
    @When("Perform docufree support docs request for MilitarySPD")
   	public void militarySPD() throws Exception{
   		try {
   			verifyTest("Perform docufree support docs request for driving lisence age and address");   			
   			String hireResponse = callResponse.getResponseForDocufree(getExcelData().get("DOCUFREE_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), getExcelData().get("AUTHORIZATION_CODE"), docufreeRequests.militarySPD());
   			String confNumber = getTagValue(hireResponse, "/DocuFree/@status");
   			if (!confNumber.equals("OK")) {
   				verifyTest("Invalid docufree resonse for support docs ", false);
   			}
   		} catch (Exception e) {
   			screenshot.getScreenshot("militarySPD");
   			e.printStackTrace();
   			verifyTest("Perform Docufree support docs: militarySPD() ", false);
   		}
   	}
    
    @When("Perform docufree support docs request for SF180")
   	public void sf180() throws Exception{
   		try {
   			verifyTest("Perform docufree support docs request for driving lisence age and address");   			
   			String hireResponse = callResponse.getResponseForDocufree(getExcelData().get("DOCUFREE_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), getExcelData().get("AUTHORIZATION_CODE"), docufreeRequests.sf180());
   			String confNumber = getTagValue(hireResponse, "/DocuFree/@status");
   			if (!confNumber.equals("OK")) {
   				verifyTest("Invalid docufree resonse for support docs ", false);
   			}
   		} catch (Exception e) {
   			screenshot.getScreenshot("sf180");
   			e.printStackTrace();
   			verifyTest("Perform Docufree support docs: sf180() ", false);
   		}
   	}
    
    @When("Perform docufree support docs request for SSNCard")
   	public void SSNCard() throws Exception{
   		try {
   			verifyTest("Perform docufree support docs request for driving lisence age and address");   			
   			String hireResponse = callResponse.getResponseForDocufree(getExcelData().get("DOCUFREE_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), getExcelData().get("AUTHORIZATION_CODE"), docufreeRequests.SSNCard());
   			String confNumber = getTagValue(hireResponse, "/DocuFree/@status");
   			if (!confNumber.equals("OK")) {
   				verifyTest("Invalid docufree resonse for support docs ", false);
   			}
   		} catch (Exception e) {
   			screenshot.getScreenshot("SSNCard");
   			e.printStackTrace();
   			verifyTest("Perform Docufree support docs: SSNCard() ", false);
   		}
   	}
    
    @When("Perform docufree support docs request for VetRel")
   	public void vetRel() throws Exception{
   		try {
   			verifyTest("Perform docufree support docs request for driving lisence age and address");   			
   			String hireResponse = callResponse.getResponseForDocufree(getExcelData().get("DOCUFREE_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), getExcelData().get("AUTHORIZATION_CODE"), docufreeRequests.vetRel());
   			String confNumber = getTagValue(hireResponse, "/DocuFree/@status");
   			if (!confNumber.equals("OK")) {
   				verifyTest("Invalid docufree resonse for support docs ", false);
   			}
   		} catch (Exception e) {
   			screenshot.getScreenshot("VetRel");
   			e.printStackTrace();
   			verifyTest("Perform Docufree support docs: VetRel() ", false);
   		}
   	}
    
    @When("Perform docufree support docs request for LTUE")
   	public void ltue() throws Exception{
   		try {
   			verifyTest("Perform docufree support docs request for driving lisence age and address");   			
   			String hireResponse = callResponse.getResponseForDocufree(getExcelData().get("DOCUFREE_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), getExcelData().get("AUTHORIZATION_CODE"), docufreeRequests.ltue());
   			String confNumber = getTagValue(hireResponse, "/DocuFree/@status");
   			if (!confNumber.equals("OK")) {
   				verifyTest("Invalid docufree resonse for support docs ", false);
   			}
   		} catch (Exception e) {
   			screenshot.getScreenshot("ltue");
   			e.printStackTrace();
   			verifyTest("Perform Docufree support docs: ltue() ", false);
   		}
   	}
    
   	
}
