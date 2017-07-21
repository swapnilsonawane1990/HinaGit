package adp.tcs.automation.stepsfiles;

import adp.tcs.automation.utilities.randomSSNgenrater;

public class EvoXmlRequests extends BaseTempletSteps{

	randomSSNgenrater ssnGenerator = new randomSSNgenrater();
	
    public String evoXmlRequest() {
    	String SSN = String.valueOf(ssnGenerator.generateSSN());
    	String uniqueId = String.valueOf(ssnGenerator.generateUniqueIdForDocufree());
    	getExcelData().put("SSN", SSN);
    	getExcelData().put("CSSN", SSN);
    	getExcelData().put("TRANSACTION_ID", uniqueId);
    	final String request = "<?xml version='1.0' encoding='UTF-8'?><Handshake company='"+getExcelData().get("COMPANY_URL")+"' auth='"+getExcelData().get("Auth")+"' partner_id='"+getExcelData().get("PARTNER_ID")+"' partner_auth='"+getExcelData().get("PARTNER_AUTH")+"'>   <PartnerInfo>      <info id='transaction_id' value='"+getExcelData().get("TRANSACTION_ID")+"' />      <info id='redirect_url' value='https://www.google.com' />       <info id='recipient_url' value='https://boomi8-salesdemo.successfactors.com/ws/simple/getWOTCResponse' />      <info id='partner_uid' value='' />   </PartnerInfo>   <PersonalInfo>        <info id='first name' value='"+getExcelData().get("FNAME")+"'/>     <info id='middle name' value='"+getExcelData().get("MNAME")+"'/>     <info id='last name' value='"+getExcelData().get("LNAME")+"'/>	      <info id='SSI_IWP_esign_email' value='"+getExcelData().get("EMAIL")+"'/>     <info id='telephone' value='"+getExcelData().get("TELEPHONE")+"'/>	        <info id='street address' value='"+getExcelData().get("HOME_STREET_ADDRESS")+"' />      <info id='city' value='"+getExcelData().get("CITY")+"' />      <info id='state' value='"+getExcelData().get("STATE")+"' />	  <info id='zip' value='"+getExcelData().get("ZIP")+"' />	        <info id='unit' value='"+getExcelData().get("EvoXMl_Unit")+"' />      <info id='ssn' value='"+getExcelData().get("SSN")+"'/>      <info id='prev empl' value='"+getExcelData().get("PREV_EMPL")+"' /></PersonalInfo></Handshake>";
        return request;
    }  
}
