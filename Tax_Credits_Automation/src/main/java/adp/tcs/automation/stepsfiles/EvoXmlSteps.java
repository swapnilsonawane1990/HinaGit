package adp.tcs.automation.stepsfiles;

import org.jbehave.core.annotations.When;

import adp.tcs.automation.pages.ScreeningPages;
import adp.tcs.automation.utilities.ServiceCallResponse;

/**
 * Created by Thorasa on 10/03/2016.
 */
public class EvoXmlSteps extends BaseTempletSteps{

	private String requestMethodType = "POST";
    private String requestContentType = "application/xml";
    private String responseContentType = "";
    private final ServiceCallResponse callResponse = new ServiceCallResponse();
    private final EvoXmlRequests evoXmlRequests = new EvoXmlRequests();
    private String evoUrl = "";
    private ScreeningPages screeningPages = new ScreeningPages();
	
	@When("Perform Evo Xml Handshake through API")
	public void evoXmlSccreening() {
		try {
			verifyTest("Perform Evo Xml Handshake through API");
			String hireResponse = callResponse.getResponseForDocufree(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), getExcelData().get("AUTHORIZATION_CODE"), evoXmlRequests.evoXmlRequest());
			evoUrl = getTagValue(hireResponse, "/Response/info[4]/@value");
			if (evoUrl.equals("")) {
				verifyTest("Invalid evo xml resonse : evoXmlSccreening() ", false);
			}
			getDriver().navigate().to(evoUrl);
			sleep(2000);			
		} catch (Exception e) {			
			e.printStackTrace();
			verifyTest("Perform Evo Xml Handshake through API : evoXmlSccreening() ", false);
		}
	}
	
	public void verifyPersonalInfoAutoPopulatedFields(){
    	try {			
			String SSN = screeningPages.personalInfo_SSN_TxtBox().getAttribute("value");  
			String CSSN = screeningPages.personalInfo_ConfirmSSN_TxtBox().getAttribute("value");
			String fName = screeningPages.personalInfo_FirstName_TxtBox().getAttribute("value");
			String mName = screeningPages.personalInfo_MiddleName_TxtBox().getAttribute("value");
			String lName = screeningPages.personalInfo_LastName_TxtBox().getAttribute("value");
			String telephone = screeningPages.personalInfo_Telephone_TxtBox().getAttribute("value");
			String email = screeningPages.personalInfo_Email_TxtBox().getAttribute("value");			
			
			if(!SSN.equals(getExcelData().get("SSN")) && !CSSN.equals(getExcelData().get("CSSN")) && !fName.equals(getExcelData().get("FNAME")) && !mName.equals(getExcelData().get("MNAME"))
					&& !lName.equals(getExcelData().get("LNAME")) && !telephone.equals(getExcelData().get("TELEPHONE")) && !email.equals(getExcelData().get("EMAIL"))){
				verifyTest("Auto populated fields on personal info page are not matching : verifyPersonalInfoAutoPopulatedFields()",false);
			}			
			screeningPages.personalInfo_Continue_Button().click();
		} catch (Exception e) {
			verifyTest("Faliure in verifyPersonalInfoAutoPopulatedFields page",false);
			e.printStackTrace();
		}
    }
	
	
	
	public void verifyAddressPageAutoPopulatedFields(){
        try {
			String address = screeningPages.address_StreetAddress_TextBox().getAttribute("value");
			String city = screeningPages.address_City_TextBox().getAttribute("value");
			String state = screeningPages.address_State_Dropdown().getAttribute("value");
			String zip = screeningPages.address_Zip_TextBox().getAttribute("value");
			
			
			if(!address.equals(getExcelData().get("HOME_STREET_ADDRESS")) && !city.equals(getExcelData().get("CITY")) && !state.equals(getExcelData().get("STATE")) && !zip.equals(getExcelData().get("ZIP"))){
				verifyTest("Auto populated fields on personal info page are not matching : verifyAddressPageAutoPopulatedFields()",false);
			}
			
			screeningPages.address_Continue_Button().click();
		} catch (Exception e) {
			verifyTest("Faliure in performAddressPageActions page",false);
			e.printStackTrace();
		}
}
	
}
