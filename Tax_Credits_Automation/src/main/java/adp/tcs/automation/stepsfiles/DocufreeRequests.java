package adp.tcs.automation.stepsfiles;

import adp.tcs.automation.utilities.randomSSNgenrater;

/**
 * Created by Thorasa on 09/29/2016.
 */
public class DocufreeRequests extends BaseTempletSteps{

	randomSSNgenrater ssnGenerator = new randomSSNgenrater();
	
	// Docufree Eligible Request
    public String docufreeEligibleRequest() {
    	String SSN = String.valueOf(ssnGenerator.generateSSN());
    	String uniqueId = String.valueOf(ssnGenerator.generateUniqueIdForDocufree());
		final String request;
    	getExcelData().put("SSN", SSN);
    	getExcelData().put("CSSN", SSN);
    	getExcelData().put("UNIQUE_ID", uniqueId);
    	unqiueIds.add(uniqueId);
		if(getExcelData().get("HIRE_CURRENT_DATE").equals("YES")){
			request = "<?xml version='1.0' encoding='ISO-8859-1' ?><DocuFree><identification><client>" + getExcelData().get("CLIENT_ID") + "</client><company>" + getExcelData().get("COMPANY_ID") + "</company><UniqueID>" + getExcelData().get("UNIQUE_ID") + "</UniqueID><ImagePath>DOCUFREE_URL_TO_IMAGE</ImagePath><queue>Docufree</queue></identification><data><stepinf id='SSN'>" + getExcelData().get("SSN") + "</stepinf><stepinf id='First Name'>" + getExcelData().get("FNAME") + "</stepinf><stepinf id='Last Name'>" + getExcelData().get("LNAME") + "</stepinf><stepinf id='Hire Date'>" + currentdate() + "</stepinf><stepinf id='Start Date'>" + currentdate() + "</stepinf><stepinf id='Street Address'>" + getExcelData().get("HOME_STREET_ADDRESS") + "</stepinf><stepinf id='Zip'>" + getExcelData().get("ZIP") + "</stepinf><stepinf id='City'>" + getExcelData().get("CITY") + "</stepinf><stepinf id='State'>" + getExcelData().get("STATE") + "</stepinf><stepinf id='Date of Birth'>" + getExcelData().get("DOB") + "</stepinf><stepinf id='Veteran'>" + getExcelData().get("VETERAN") + "</stepinf>   <stepinf id='Military_Disable'>" + getExcelData().get("MILITARY_DISABLE") + "</stepinf>   <stepinf id='Military_DR'>" + getExcelData().get("MILITARY_DR") + "</stepinf>  <stepinf id='UVET_COMP_4W'>" + getExcelData().get("UVET_COMP_4W") + "</stepinf>   <stepinf id='UVET_COMP_6M'>" + getExcelData().get("UVET_COMP_6M") + "</stepinf>   <stepinf id='Vet Food Stamps'>" + getExcelData().get("VET_FOOD_STAMPS") + "</stepinf>   <stepinf id='Vocation Rehab Question'>" + getExcelData().get("VOCATION_REHAB_QUESTION") + "</stepinf><stepinf id='WOTC Not Eligible'>" + getExcelData().get("WOTC_NOT_ELIGIBLE") + "</stepinf><stepinf id='SSI'>" + getExcelData().get("SSI_QUE") + "</stepinf><stepinf id='SSDI'>" + getExcelData().get("SSDI_QUE") + "</stepinf><stepinf id='FELONY GENERAL'>" + getExcelData().get("FELONY_GENERAL") + "</stepinf>   <stepinf id='FELONY REL'>" + getExcelData().get("FELONY_REL") + "</stepinf><stepinf id='unemp_6_month'>" + getExcelData().get("UNEMP_6_MONTH") + "</stepinf><stepinf id='unemp_benefic'>" + getExcelData().get("UNEMP_BENEFIC") + "</stepinf></data></DocuFree>";
		}else {
			request = "<?xml version='1.0' encoding='ISO-8859-1' ?><DocuFree><identification><client>" + getExcelData().get("CLIENT_ID") + "</client><company>" + getExcelData().get("COMPANY_ID") + "</company><UniqueID>" + getExcelData().get("UNIQUE_ID") + "</UniqueID><ImagePath>DOCUFREE_URL_TO_IMAGE</ImagePath><queue>Docufree</queue></identification><data><stepinf id='SSN'>" + getExcelData().get("SSN") + "</stepinf><stepinf id='First Name'>" + getExcelData().get("FNAME") + "</stepinf><stepinf id='Last Name'>" + getExcelData().get("LNAME") + "</stepinf><stepinf id='Hire Date'>" + getExcelData().get("HIRE_DATE") + "</stepinf><stepinf id='Start Date'>" + getExcelData().get("HIRE_START_DATE") + "</stepinf><stepinf id='Street Address'>" + getExcelData().get("HOME_STREET_ADDRESS") + "</stepinf><stepinf id='Zip'>" + getExcelData().get("ZIP") + "</stepinf><stepinf id='City'>" + getExcelData().get("CITY") + "</stepinf><stepinf id='State'>" + getExcelData().get("STATE") + "</stepinf><stepinf id='Date of Birth'>" + getExcelData().get("DOB") + "</stepinf><stepinf id='Veteran'>" + getExcelData().get("VETERAN") + "</stepinf>   <stepinf id='Military_Disable'>" + getExcelData().get("MILITARY_DISABLE") + "</stepinf>   <stepinf id='Military_DR'>" + getExcelData().get("MILITARY_DR") + "</stepinf>  <stepinf id='UVET_COMP_4W'>" + getExcelData().get("UVET_COMP_4W") + "</stepinf>   <stepinf id='UVET_COMP_6M'>" + getExcelData().get("UVET_COMP_6M") + "</stepinf>   <stepinf id='Vet Food Stamps'>" + getExcelData().get("VET_FOOD_STAMPS") + "</stepinf>   <stepinf id='Vocation Rehab Question'>" + getExcelData().get("VOCATION_REHAB_QUESTION") + "</stepinf><stepinf id='WOTC Not Eligible'>" + getExcelData().get("WOTC_NOT_ELIGIBLE") + "</stepinf><stepinf id='SSI'>" + getExcelData().get("SSI_QUE") + "</stepinf><stepinf id='SSDI'>" + getExcelData().get("SSDI_QUE") + "</stepinf><stepinf id='FELONY GENERAL'>" + getExcelData().get("FELONY_GENERAL") + "</stepinf>   <stepinf id='FELONY REL'>" + getExcelData().get("FELONY_REL") + "</stepinf><stepinf id='unemp_6_month'>" + getExcelData().get("UNEMP_6_MONTH") + "</stepinf><stepinf id='unemp_benefic'>" + getExcelData().get("UNEMP_BENEFIC") + "</stepinf></data></DocuFree>";
		}
		return request;
    }       
	
 // Docufree InEligible Request
    public String docufreeIneligibleRequest() {
    	String SSN = String.valueOf(ssnGenerator.generateSSN());
    	String uniqueId = String.valueOf(ssnGenerator.generateUniqueIdForDocufree());
    	getExcelData().put("SSN", SSN);
    	getExcelData().put("CSSN", SSN);
    	getExcelData().put("UNIQUE_ID", uniqueId);
    	unqiueIds.add(uniqueId);
    	final String request = "<?xml version='1.0' encoding='ISO-8859-1' ?><DocuFree><identification><client>"+getExcelData().get("CLIENT_ID")+"</client><company>"+getExcelData().get("COMPANY_ID")+"</company><UniqueID>"+getExcelData().get("UNIQUE_ID")+"</UniqueID><ImagePath>DOCUFREE_URL_TO_IMAGE</ImagePath><queue>Docufree</queue></identification><data><stepinf id='SSN'>"+getExcelData().get("SSN")+"</stepinf><stepinf id='First Name'>"+getExcelData().get("FNAME")+"</stepinf><stepinf id='Last Name'>"+getExcelData().get("LNAME")+"</stepinf><stepinf id='Hire Date'>"+getExcelData().get("HIRE_DATE")+"</stepinf><stepinf id='Start Date'>"+getExcelData().get("HIRE_START_DATE")+"</stepinf></data></DocuFree>";
        return request;
    }
    
 // Docufree Incomplete Request
    public String docufreeIncompleteRequest() {    	
    	String uniqueId = String.valueOf(ssnGenerator.generateUniqueIdForDocufree());
    	if(getExcelData().get("SSN").equals("")){
    		String SSN = String.valueOf(ssnGenerator.generateSSN());
    		getExcelData().put("SSN", SSN);
        	getExcelData().put("CSSN", SSN);
    	}    	
    	getExcelData().put("UNIQUE_ID", uniqueId);
    	unqiueIds.add(uniqueId);
    	final String request = "<?xml version='1.0' encoding='ISO-8859-1' ?><DocuFree><identification><client>"+getExcelData().get("CLIENT_ID")+"</client><company>"+getExcelData().get("COMPANY_ID")+"</company><UniqueID>"+getExcelData().get("UNIQUE_ID")+"</UniqueID><ImagePath>DOCUFREE_URL_TO_IMAGE</ImagePath><queue>Docufree</queue></identification><data><stepinf id='SSN'>"+getExcelData().get("SSN")+"</stepinf><stepinf id='First Name'>"+getExcelData().get("FNAME")+"</stepinf><stepinf id='Last Name'>"+getExcelData().get("LNAME")+"</stepinf><stepinf id='Hire Date'>"+getExcelData().get("HIRE_DATE")+"</stepinf><stepinf id='Start Date'>"+getExcelData().get("HIRE_START_DATE")+"</stepinf><stepinf id='Street Address'>"+getExcelData().get("HOME_STREET_ADDRESS")+"</stepinf><stepinf id='Zip'>"+getExcelData().get("ZIP")+"</stepinf><stepinf id='City'>"+getExcelData().get("CITY")+"</stepinf><stepinf id='State'>"+getExcelData().get("STATE")+"</stepinf><stepinf id='Date of Birth'>"+getExcelData().get("DOB")+"</stepinf></data></DocuFree>";
        return request;
    }
    
 // Docufree Support Request
    public String docufreeSupportingDocRequest() {    	
    	String uniqueId = String.valueOf(ssnGenerator.generateUniqueIdForDocufree());    	   	
    	getExcelData().put("UNIQUE_ID", uniqueId);
    	unqiueIds.add(uniqueId);
    	String imagePath = getExcelData().get("IMAGE_PATH");    	
    	System.out.println(imagePath);
    	final String request = "<?xml version='1.0' encoding='ISO-8859-1' ?><supportingdoc><identification><uniqueid>" + getExcelData().get("UNIQUE_ID") + "</uniqueid><imagepath> " +  imagePath + " </imagepath></identification><data><field id='ClientCode'>" + getExcelData().get("CLIENT_ID") + "</field><field id='CompanyCode'>" + getExcelData().get("COMPANY_ID") + "</field><field id='FirstName'>" + getExcelData().get("FNAME") + "</field><field id='LastName'>" + getExcelData().get("LNAME") + "</field><field id='SSN'>" + getExcelData().get("SSN") + "</field><field id='DOB'>" + getExcelData().get("DOB") + "</field><field id='StreetAddress'>" + getExcelData().get("HOME_STREET_ADDRESS") + "</field><field id='City'>" + getExcelData().get("CITY") + "</field><field id='State'>" + getExcelData().get("STATE") + "</field><field id='Zip'>" + getExcelData().get("ZIP") + "</field><field id='Signature'>" + getExcelData().get("ESIGN") + "</field></data><type><doc id='" + getExcelData().get("DOC_ID") + "'/></type></supportingdoc>";
        return request;
    }
    
    // Docufree Support Request DL Age
    public String dlAge() {    	
    	String uniqueId = String.valueOf(ssnGenerator.generateUniqueIdForDocufree());    	   	
    	getExcelData().put("UNIQUE_ID", uniqueId);
    	unqiueIds.add(uniqueId);
    	String imagePath = getExcelData().get("IMAGE_PATH");    	
    	System.out.println(imagePath);
    	final String dlAge = "<?xml version='1.0' encoding='ISO-8859-1' ?><supportingdoc><identification><uniqueid>" + getExcelData().get("UNIQUE_ID") + "</uniqueid><imagepath> " +  imagePath + " </imagepath></identification><data><field id='ClientCode'>" + getExcelData().get("CLIENT_ID") + "</field><field id='CompanyCode'>" + getExcelData().get("COMPANY_ID") + "</field><field id='FirstName'>" + getExcelData().get("FNAME") + "</field><field id='LastName'>" + getExcelData().get("LNAME") + "</field><field id='DOB'>" + getExcelData().get("DOB") + "</field></data><type><doc id='DL'/></type></supportingdoc>";
        return dlAge;
    }
    
    // Docufree Support Request DL Address
    public String dlAddress() {    	
    	String uniqueId = String.valueOf(ssnGenerator.generateUniqueIdForDocufree());    	   	
    	getExcelData().put("UNIQUE_ID", uniqueId);
    	unqiueIds.add(uniqueId);
    	String imagePath = getExcelData().get("IMAGE_PATH");    	
    	System.out.println(imagePath);
    	final String dlAddress = "<?xml version='1.0' encoding='ISO-8859-1' ?><supportingdoc><identification><uniqueid>" + getExcelData().get("UNIQUE_ID") + "</uniqueid><imagepath> " +  imagePath + " </imagepath></identification><data><field id='ClientCode'>" + getExcelData().get("CLIENT_ID") + "</field><field id='CompanyCode'>" + getExcelData().get("COMPANY_ID") + "</field><field id='FirstName'>" + getExcelData().get("FNAME") + "</field><field id='LastName'>" + getExcelData().get("LNAME") + "</field><field id='StreetAddress'>" + getExcelData().get("HOME_STREET_ADDRESS") + "</field><field id='City'>" + getExcelData().get("CITY") + "</field><field id='State'>" + getExcelData().get("STATE") + "</field><field id='Zip'>" + getExcelData().get("ZIP") + "</field></data><type><doc id='DL'/></type></supportingdoc>";
        return dlAddress;
    }
    
    // Docufree Support Request DL Age Address
    public String dlAgeAddress() {    	
    	String uniqueId = String.valueOf(ssnGenerator.generateUniqueIdForDocufree());    	   	
    	getExcelData().put("UNIQUE_ID", uniqueId);
    	unqiueIds.add(uniqueId);
    	String imagePath = getExcelData().get("IMAGE_PATH");    	
    	System.out.println(imagePath);
    	final String dlAgeAddress = "<?xml version='1.0' encoding='ISO-8859-1' ?><supportingdoc><identification><uniqueid>" + getExcelData().get("UNIQUE_ID") + "</uniqueid><imagepath> " +  imagePath + " </imagepath></identification><data><field id='ClientCode'>" + getExcelData().get("CLIENT_ID") + "</field><field id='CompanyCode'>" + getExcelData().get("COMPANY_ID") + "</field><field id='FirstName'>" + getExcelData().get("FNAME") + "</field><field id='LastName'>" + getExcelData().get("LNAME") + "</field><field id='DOB'>" + getExcelData().get("DOB") + "</field><field id='StreetAddress'>" + getExcelData().get("HOME_STREET_ADDRESS") + "</field><field id='City'>" + getExcelData().get("CITY") + "</field><field id='State'>" + getExcelData().get("STATE") + "</field><field id='Zip'>" + getExcelData().get("ZIP") + "</field></data><type><doc id='DL'/></type></supportingdoc>";
        return dlAgeAddress;
    }
    
    // Docufree Support Request Birthcert Address
    public String birthCertAge() {    	
    	String uniqueId = String.valueOf(ssnGenerator.generateUniqueIdForDocufree());    	   	
    	getExcelData().put("UNIQUE_ID", uniqueId);
    	unqiueIds.add(uniqueId);
    	String imagePath = getExcelData().get("IMAGE_PATH");    	
    	System.out.println(imagePath);
    	final String birthCertAge = "<?xml version='1.0' encoding='ISO-8859-1' ?><supportingdoc><identification><uniqueid>" + getExcelData().get("UNIQUE_ID") + "</uniqueid><imagepath> " +  imagePath + " </imagepath></identification><data><field id='ClientCode'>" + getExcelData().get("CLIENT_ID") + "</field><field id='CompanyCode'>" + getExcelData().get("COMPANY_ID") + "</field><field id='FirstName'>" + getExcelData().get("FNAME") + "</field><field id='LastName'>" + getExcelData().get("LNAME") + "</field><field id='DOB'>" + getExcelData().get("DOB") + "</field></data><type><doc id='BirthCert'/></type></supportingdoc>";
        return birthCertAge;
    }
    
    // Docufree Support Request USPassport Address
    public String usPassportAge() {    	
    	String uniqueId = String.valueOf(ssnGenerator.generateUniqueIdForDocufree());    	   	
    	getExcelData().put("UNIQUE_ID", uniqueId);
    	unqiueIds.add(uniqueId);
    	String imagePath = getExcelData().get("IMAGE_PATH");    	
    	System.out.println(imagePath);
    	final String usPassportAge = "<?xml version='1.0' encoding='ISO-8859-1' ?><supportingdoc><identification><uniqueid>" + getExcelData().get("UNIQUE_ID") + "</uniqueid><imagepath> " +  imagePath + " </imagepath></identification><data><field id='ClientCode'>" + getExcelData().get("CLIENT_ID") + "</field><field id='CompanyCode'>" + getExcelData().get("COMPANY_ID") + "</field><field id='FirstName'>" + getExcelData().get("FNAME") + "</field><field id='LastName'>" + getExcelData().get("LNAME") + "</field><field id='DOB'>" + getExcelData().get("DOB") + "</field></data><type><doc id='USPassport'/></type></supportingdoc>";
        return usPassportAge;
    }
    
    // Docufree Support Request VoterReg Age
    public String voterRegAge() {    	
    	String uniqueId = String.valueOf(ssnGenerator.generateUniqueIdForDocufree());    	   	
    	getExcelData().put("UNIQUE_ID", uniqueId);
    	unqiueIds.add(uniqueId);
    	String imagePath = getExcelData().get("IMAGE_PATH");    	
    	System.out.println(imagePath);
    	final String voterRegAgeAddress = "<?xml version='1.0' encoding='ISO-8859-1' ?><supportingdoc><identification><uniqueid>" + getExcelData().get("UNIQUE_ID") + "</uniqueid><imagepath> " +  imagePath + " </imagepath></identification><data><field id='ClientCode'>" + getExcelData().get("CLIENT_ID") + "</field><field id='CompanyCode'>" + getExcelData().get("COMPANY_ID") + "</field><field id='FirstName'>" + getExcelData().get("FNAME") + "</field><field id='LastName'>" + getExcelData().get("LNAME") + "</field><field id='DOB'>" + getExcelData().get("DOB") + "</field></data><type><doc id='VoterReg'/></type></supportingdoc>";
        return voterRegAgeAddress;
    }
    
    // Docufree Support Request VoterReg Address
    public String voterRegAddress() {    	
    	String uniqueId = String.valueOf(ssnGenerator.generateUniqueIdForDocufree());    	   	
    	getExcelData().put("UNIQUE_ID", uniqueId);
    	unqiueIds.add(uniqueId);
    	String imagePath = getExcelData().get("IMAGE_PATH");    	
    	System.out.println(imagePath);
    	final String voterRegAddress = "<?xml version='1.0' encoding='ISO-8859-1' ?><supportingdoc><identification><uniqueid>" + getExcelData().get("UNIQUE_ID") + "</uniqueid><imagepath> " +  imagePath + " </imagepath></identification><data><field id='ClientCode'>" + getExcelData().get("CLIENT_ID") + "</field><field id='CompanyCode'>" + getExcelData().get("COMPANY_ID") + "</field><field id='FirstName'>" + getExcelData().get("FNAME") + "</field><field id='LastName'>" + getExcelData().get("LNAME") + "</field><field id='StreetAddress'>" + getExcelData().get("HOME_STREET_ADDRESS") + "</field><field id='City'>" + getExcelData().get("CITY") + "</field><field id='State'>" + getExcelData().get("STATE") + "</field><field id='Zip'>" + getExcelData().get("ZIP") + "</field></data><type><doc id='VoterReg'/></type></supportingdoc>";
        return voterRegAddress;
    }
    
    // Docufree Support Request VoterReg Age Address
    public String voterRegAgeAddress() {    	
    	String uniqueId = String.valueOf(ssnGenerator.generateUniqueIdForDocufree());    	   	
    	getExcelData().put("UNIQUE_ID", uniqueId);
    	unqiueIds.add(uniqueId);
    	String imagePath = getExcelData().get("IMAGE_PATH");    	
    	System.out.println(imagePath);
    	final String voterRegAgeAddress = "<?xml version='1.0' encoding='ISO-8859-1' ?><supportingdoc><identification><uniqueid>" + getExcelData().get("UNIQUE_ID") + "</uniqueid><imagepath> " +  imagePath + " </imagepath></identification><data><field id='ClientCode'>" + getExcelData().get("CLIENT_ID") + "</field><field id='CompanyCode'>" + getExcelData().get("COMPANY_ID") + "</field><field id='FirstName'>" + getExcelData().get("FNAME") + "</field><field id='LastName'>" + getExcelData().get("LNAME") + "</field><field id='DOB'>" + getExcelData().get("DOB") + "</field><field id='StreetAddress'>" + getExcelData().get("HOME_STREET_ADDRESS") + "</field><field id='City'>" + getExcelData().get("CITY") + "</field><field id='State'>" + getExcelData().get("STATE") + "</field><field id='Zip'>" + getExcelData().get("ZIP") + "</field></data><type><doc id='VoterReg'/></type></supportingdoc>";
        return voterRegAgeAddress;
    }
    
    // Docufree Support Request W4 Address
    public String w4Address() {    	
    	String uniqueId = String.valueOf(ssnGenerator.generateUniqueIdForDocufree());    	   	
    	getExcelData().put("UNIQUE_ID", uniqueId);
    	unqiueIds.add(uniqueId);
    	String imagePath = getExcelData().get("IMAGE_PATH");    	
    	System.out.println(imagePath);
    	final String w4Address = "<?xml version='1.0' encoding='ISO-8859-1' ?><supportingdoc><identification><uniqueid>" + getExcelData().get("UNIQUE_ID") + "</uniqueid><imagepath> " +  imagePath + " </imagepath></identification><data><field id='ClientCode'>" + getExcelData().get("CLIENT_ID") + "</field><field id='CompanyCode'>" + getExcelData().get("COMPANY_ID") + "</field><field id='FirstName'>" + getExcelData().get("FNAME") + "</field><field id='LastName'>" + getExcelData().get("LNAME") + "</field><field id='StreetAddress'>" + getExcelData().get("HOME_STREET_ADDRESS") + "</field><field id='City'>" + getExcelData().get("CITY") + "</field><field id='State'>" + getExcelData().get("STATE") + "</field><field id='Zip'>" + getExcelData().get("ZIP") + "</field></data><type><doc id='W4'/></type></supportingdoc>";
        return w4Address;
    }
    
    // Docufree Support Request RFV
    public String rfv() {    	
    	String uniqueId = String.valueOf(ssnGenerator.generateUniqueIdForDocufree());    	   	
    	getExcelData().put("UNIQUE_ID", uniqueId);
    	unqiueIds.add(uniqueId);
    	String imagePath = getExcelData().get("IMAGE_PATH");    	
    	System.out.println(imagePath);
    	final String rfv = "<?xml version='1.0' encoding='ISO-8859-1' ?><supportingdoc><identification><uniqueid>" + getExcelData().get("UNIQUE_ID") + "</uniqueid><imagepath> " +  imagePath + " </imagepath></identification><data><field id='ClientCode'>" + getExcelData().get("CLIENT_ID") + "</field><field id='CompanyCode'>" + getExcelData().get("COMPANY_ID") + "</field><field id='FirstName'>" + getExcelData().get("FNAME") + "</field><field id='LastName'>" + getExcelData().get("LNAME") + "</field><field id='SSN'>" + getExcelData().get("SSN") + "</field><field id='Signature'>" + getExcelData().get("ESIGN") + "</field></data><type><doc id='RFV'/></type></supportingdoc>";
        return rfv;
    }
    
    // Docufree Support Request SSA
    public String ssa() {    	
    	String uniqueId = String.valueOf(ssnGenerator.generateUniqueIdForDocufree());    	   	
    	getExcelData().put("UNIQUE_ID", uniqueId);
    	unqiueIds.add(uniqueId);
    	String imagePath = getExcelData().get("IMAGE_PATH");    	
    	System.out.println(imagePath);
    	final String ssa = "<?xml version='1.0' encoding='ISO-8859-1' ?><supportingdoc><identification><uniqueid>" + getExcelData().get("UNIQUE_ID") + "</uniqueid><imagepath> " +  imagePath + " </imagepath></identification><data><field id='ClientCode'>" + getExcelData().get("CLIENT_ID") + "</field><field id='CompanyCode'>" + getExcelData().get("COMPANY_ID") + "</field><field id='FirstName'>" + getExcelData().get("FNAME") + "</field><field id='LastName'>" + getExcelData().get("LNAME") + "</field><field id='SSN'>" + getExcelData().get("SSN") + "</field><field id='Signature'>" + getExcelData().get("ESIGN") + "</field></data><type><doc id='SSARel'/></type></supportingdoc>";
        return ssa;
    }
    
    // Docufree Support Request DD214
    public String dd214() {    	
    	String uniqueId = String.valueOf(ssnGenerator.generateUniqueIdForDocufree());    	   	
    	getExcelData().put("UNIQUE_ID", uniqueId);
    	unqiueIds.add(uniqueId);
    	String imagePath = getExcelData().get("IMAGE_PATH");    	
    	System.out.println(imagePath);
    	final String dd214 = "<?xml version='1.0' encoding='ISO-8859-1' ?><supportingdoc><identification><uniqueid>" + getExcelData().get("UNIQUE_ID") + "</uniqueid><imagepath> " +  imagePath + " </imagepath></identification><data><field id='ClientCode'>" + getExcelData().get("CLIENT_ID") + "</field><field id='CompanyCode'>" + getExcelData().get("COMPANY_ID") + "</field><field id='FirstName'>" + getExcelData().get("FNAME") + "</field><field id='LastName'>" + getExcelData().get("LNAME") + "</field><field id='SSN'>" + getExcelData().get("SSN") + "</field></data><type><doc id='DD214'/></type></supportingdoc>";
        return dd214;
    }
    
    // Docufree Support Request MilitarySPD
    public String militarySPD() {    	
    	String uniqueId = String.valueOf(ssnGenerator.generateUniqueIdForDocufree());    	   	
    	getExcelData().put("UNIQUE_ID", uniqueId);
    	unqiueIds.add(uniqueId);
    	String imagePath = getExcelData().get("IMAGE_PATH");    	
    	System.out.println(imagePath);
    	final String militarySPD = "<?xml version='1.0' encoding='ISO-8859-1' ?><supportingdoc><identification><uniqueid>" + getExcelData().get("UNIQUE_ID") + "</uniqueid><imagepath> " +  imagePath + " </imagepath></identification><data><field id='ClientCode'>" + getExcelData().get("CLIENT_ID") + "</field><field id='CompanyCode'>" + getExcelData().get("COMPANY_ID") + "</field><field id='FirstName'>" + getExcelData().get("FNAME") + "</field><field id='LastName'>" + getExcelData().get("LNAME") + "</field><field id='SSN'>" + getExcelData().get("SSN") + "</field><field id='DOB'>" + getExcelData().get("DOB") + "</field><type><doc id='MilitarySPD'/></type></supportingdoc>";
        return militarySPD;
    }
    
    // Docufree Support Request SF180
    public String sf180() {    	
    	String uniqueId = String.valueOf(ssnGenerator.generateUniqueIdForDocufree());    	   	
    	getExcelData().put("UNIQUE_ID", uniqueId);
    	unqiueIds.add(uniqueId);
    	String imagePath = getExcelData().get("IMAGE_PATH");    	
    	System.out.println(imagePath);
    	final String sf180 = "<?xml version='1.0' encoding='ISO-8859-1' ?><supportingdoc><identification><uniqueid>" + getExcelData().get("UNIQUE_ID") + "</uniqueid><imagepath> " +  imagePath + " </imagepath></identification><data><field id='ClientCode'>" + getExcelData().get("CLIENT_ID") + "</field><field id='CompanyCode'>" + getExcelData().get("COMPANY_ID") + "</field><field id='FirstName'>" + getExcelData().get("FNAME") + "</field><field id='LastName'>" + getExcelData().get("LNAME") + "</field><field id='SSN'>" + getExcelData().get("SSN") + "</field></data><type><doc id='SF180'/></type></supportingdoc>";
        return sf180;
    }
    
    // Docufree Support Request SSNCard
    public String SSNCard() {    	
    	String uniqueId = String.valueOf(ssnGenerator.generateUniqueIdForDocufree());    	   	
    	getExcelData().put("UNIQUE_ID", uniqueId);
    	unqiueIds.add(uniqueId);
    	String imagePath = getExcelData().get("IMAGE_PATH");    	
    	System.out.println(imagePath);
    	final String SSNCard = "<?xml version='1.0' encoding='ISO-8859-1' ?><supportingdoc><identification><uniqueid>" + getExcelData().get("UNIQUE_ID") + "</uniqueid><imagepath> " +  imagePath + " </imagepath></identification><data><field id='ClientCode'>" + getExcelData().get("CLIENT_ID") + "</field><field id='CompanyCode'>" + getExcelData().get("COMPANY_ID") + "</field><field id='FirstName'>" + getExcelData().get("FNAME") + "</field><field id='LastName'>" + getExcelData().get("LNAME") + "</field><field id='SSN'>" + getExcelData().get("SSN") + "</field></data><type><doc id='SSNCard'/></type></supportingdoc>";
        return SSNCard;
    }
    
    // Docufree Support Request VetRel
    public String vetRel() {    	
    	String uniqueId = String.valueOf(ssnGenerator.generateUniqueIdForDocufree());    	   	
    	getExcelData().put("UNIQUE_ID", uniqueId);
    	unqiueIds.add(uniqueId);
    	String imagePath = getExcelData().get("IMAGE_PATH");    	
    	System.out.println(imagePath);
    	final String vetRel = "<?xml version='1.0' encoding='ISO-8859-1' ?><supportingdoc><identification><uniqueid>" + getExcelData().get("UNIQUE_ID") + "</uniqueid><imagepath> " +  imagePath + " </imagepath></identification><data><field id='ClientCode'>" + getExcelData().get("CLIENT_ID") + "</field><field id='CompanyCode'>" + getExcelData().get("COMPANY_ID") + "</field><field id='FirstName'>" + getExcelData().get("FNAME") + "</field><field id='LastName'>" + getExcelData().get("LNAME") + "</field><field id='DOB'>" + getExcelData().get("DOB") + "</field><field id='Signature'>" + getExcelData().get("ESIGN") + "</field></data><type><doc id='VetRel'/></type></supportingdoc>";
        return vetRel;
    }
    
    // Docufree Support Request LTUE
    public String ltue() {    	
    	String uniqueId = String.valueOf(ssnGenerator.generateUniqueIdForDocufree());    	   	
    	getExcelData().put("UNIQUE_ID", uniqueId);
    	unqiueIds.add(uniqueId);
    	String imagePath = getExcelData().get("IMAGE_PATH");    	
    	System.out.println(imagePath);
    	final String ltue = "<?xml version='1.0' encoding='ISO-8859-1' ?><supportingdoc><identification><uniqueid>" + getExcelData().get("UNIQUE_ID") + "</uniqueid><imagepath> " +  imagePath + " </imagepath></identification><data><field id='ClientCode'>" + getExcelData().get("CLIENT_ID") + "</field><field id='CompanyCode'>" + getExcelData().get("COMPANY_ID") + "</field><field id='FirstName'>" + getExcelData().get("FNAME") + "</field><field id='LastName'>" + getExcelData().get("LNAME") + "</field><field id='SSN'>" + getExcelData().get("SSN") + "</field><field id='Signature'>" + getExcelData().get("ESIGN") + "</field></data><type><doc id='LTUE'/></type></supportingdoc>";
        return ltue;
    }
}
