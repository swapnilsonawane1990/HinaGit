package adp.tcs.automation.stepsfiles;


import adp.tcs.automation.locators.EditPersonalInfo;
import adp.tcs.automation.locators.SearchSSNHub;
import adp.tcs.automation.pages.BackOfficActions;
import adp.tcs.automation.pages.EditPersonalInformation;
import adp.tcs.automation.pages.SearchSSNthroughHub;
import adp.tcs.automation.utilities.WndowAction;
import adp.tcs.automation.utilities.randomSSNgenrater;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Created by Thorasa on 9/12/2016.
 */
public class HubValidationsSteps extends BaseTempletSteps{
	SearchSSNthroughHub searchSSN = new SearchSSNthroughHub();
	EditPersonalInformation editPersonalInformation = new EditPersonalInformation();
	EditPersonalInfo editPersonalInfo = new EditPersonalInfo();
	BackOfficActions bcAct = new BackOfficActions();
	HashMap<String, String> requestIds = new HashMap<String, String>();
	private final SearchSSNthroughHub hub = new SearchSSNthroughHub();
	private final WndowAction windowAct = new WndowAction();
	private randomSSNgenrater ssnGenerator = new randomSSNgenrater();
	boolean isCreditPresent;
	boolean isStatusPresent;
	SearchSSNthroughHub search = new SearchSSNthroughHub();
	
	@Given("User Search SSN in Hub")
	public void performHubSearch(){		
		searchSSN.Search_SSN_The_InputBox().clear();
		sleep(2000);
        searchSSN.Search_SSN_The_InputBox().sendKeys(getExcelData().get("SSN"));
        searchSSN.Search_SSN_The_SearchButton().click();        
		if (loadPropValues("envName").equalsIgnoreCase("Fit2")) {			
			String checkResult = SearchSSNHub.HUB_SEARCH_RESULT_CONST_PATH + "[1]/td";		
			for (int i = 0; i < 40; i++) {
				if (!getText(checkResult).equals("No records available.")) {
					break;
				} else {
					searchSSN.Search_SSN_The_SearchButton().click();
					sleep(4000);
				}
			}
		}
	}

	//@Then("Verify the result on hub search page")
	public void verifyHubeSearchResult(){
	       try {
	           //performHubSearch();
	           String[] credits = getExcelData().get("CREDIT").split("#");
	           String[] status = getExcelData().get("STATUS").split("#");
	      for(int i=0; i<credits.length;i++){
	           int count = getCount(SearchSSNHub.HUB_SEARCH_RESULT_CONST_PATH);
	           isCreditPresent = false;
	           isStatusPresent = false;
	           for(int row = 1; row<=count; row++) {
	         String hubResultPathRow = SearchSSNHub.HUB_SEARCH_RESULT_CONST_PATH + "[" + row + "]/td";
	         int columnCount = getCount(hubResultPathRow);
	         sleep(2000);
	         for (int column = 2; column <= columnCount; column++) {
	            String hubResultPathColumn = hubResultPathRow + "[" + column + "]";	            
	            switch (column) {	            
	               case 2:
	                  String ssn = getExcelData().get("SSN").substring(0, 3) + "-" + getExcelData().get("SSN").substring(3, getExcelData().get("SSN").length());
	                  String formatedSSN = ssn.substring(0, 6) + "-" + ssn.substring(6, ssn.length());
	                  if (!getText(hubResultPathColumn).equals(formatedSSN)) {
	                     verifyTest("SSN is not matched on hub search result page", false);
	                  }
	                  break;
	               case 3:
	                  String personalInfoName = getExcelData().get("FNAME") + " " + getExcelData().get("LNAME");
	                  String personalInfoAddress = getExcelData().get("HOME_STREET_ADDRESS") + " " + getExcelData().get("CITY");
	                  if (!getText(hubResultPathColumn).split("[\r\n]+")[0].trim().equals(personalInfoName.trim()) && !getText(hubResultPathColumn).split("[\r\n]+")[1].trim().equals(personalInfoAddress.trim())) {
	                     verifyTest("Personal Info is not matched on hub search result page", false);
	                  }
	                  break;
	               case 4:
	            	   System.out.println("-----------"+getText(hubResultPathColumn));
	            	   System.out.println("-----------"+getExcelData().get("STATE"));
	                  if (!getText(hubResultPathColumn).equals(getExcelData().get("STATE"))) {
	                     verifyTest("State is not matched on hub search result page", false);
	                  }
	                  break;
	               case 5:
	                  if (!getExcelData().get("COMPANY_NAME").equalsIgnoreCase(getText(hubResultPathColumn))) {
	                     verifyTest("Company name is not matched on hub search result page", false);
	                  }
	                  break;
	               case 6:
	                  break;
	               case 7:
	                  break;
	               case 8:
	                  if (getText(hubResultPathColumn).equals(credits[i])) {
	                     isCreditPresent = true;
	                  }
	                  break;
	               case 9:
	                  if (getText(hubResultPathColumn).equals(status[i])) {
	                	  isStatusPresent = true;
	                  }
	                  break;
	            }
	         }
	      }
	           if(isCreditPresent == false || isStatusPresent == false){
		            verifyTest("Credits and Status are not matched", false);
		         }
	   }
	      
	   } catch (Exception e) {
	      e.printStackTrace();
	      verifyTest("Faliure in verifyHubeSearchResult page",false);          
	   }
	   }
	
	@Then("Verify hub search result data")
	public void verifyHubeSearchResultData(){
        try {
        	//performHubSearch();
        	String[] credits = getExcelData().get("CREDIT").split("#");
        	String[] status = getExcelData().get("STATUS").split("#");
        	int count = getCount(SearchSSNHub.HUB_SEARCH_RESULT_CONST_PATH);        	
        	for(int row = 1; row<=count; row++){
        		String hubResultPathRow = SearchSSNHub.HUB_SEARCH_RESULT_CONST_PATH + "[" + row + "]/td";
        		int columnCount = getCount(hubResultPathRow);        		
        		for(int column = 2; column<=columnCount; column++){
        			String hubResultPathColumn = hubResultPathRow + "["+ column + "]";
        			
        			 switch (column) {
                     case 2:
                    	 String ssn = getExcelData().get("SSN").substring(0, 3) + "-" + getExcelData().get("SSN").substring(3, getExcelData().get("SSN").length());                   	 
                    	 String formatedSSN = ssn.substring(0, 6) + "-" + ssn.substring(6,ssn.length());                    	 
                    	 if(!getText(hubResultPathColumn).equals(formatedSSN)){                    		 
                    		 verifyTest("SSN is not matched on hub search result page",false);
                    	 }
                         break;
                     case 3 :
                    	 String personalInfoName = getExcelData().get("FNAME") + " "+ getExcelData().get("LNAME");
                    	 String personalInfoAddress = getExcelData().get("HOME_STREET_ADDRESS") + " "+ getExcelData().get("CITY");                   	                    	 
                    	 if(!getText(hubResultPathColumn).split("[\r\n]+")[0].trim().equals(personalInfoName.trim()) && !getText(hubResultPathColumn).split("[\r\n]+")[1].trim().equals(personalInfoAddress.trim())){                    		 
                    		 verifyTest("Personal Info is not matched on hub search result page",false);
                    	 }           
                         break;
                     case 4 :
                    	 if(!getText(hubResultPathColumn).equals(getExcelData().get("STATE"))){
                    		 verifyTest("State is not matched on hub search result page",false);
                    	 }
                         break;
                     case 5 :                    	
                    	 if(!getExcelData().get("COMPANY_NAME").equalsIgnoreCase(getText(hubResultPathColumn))){                    		 
                    		 verifyTest("Company name is not matched on hub search result page",false);
                    	 }
                         break;
                     case 6 :                    	 
                         break;
                     case 7 :                         
                         break;
                     case 8 :
                    	 if(!getText(hubResultPathColumn).equals(credits[row-1])){                    		 
                    		 verifyTest("Credit is not matched on hub search result page",false);
                    	 }
                         break;
                     case 9 :
                    	 if(!getText(hubResultPathColumn).equals(status[row-1])){                    		 
                    		 verifyTest("Status is not matched on hub search result page",false);
                    	 }
                         break;                   
        			 }
        		}        		
        	}       	
		} catch (Exception e) {
			e.printStackTrace();
			verifyTest("Faliure in verifyHubeSearchResult page",false);			
		}
    }

	@Then("Verify Hub Search Result in Grid")
	public void verifyHubSearchResultGrid() {
		try {
			verifyHubeSearchResult();
		} catch (Exception e) {
			e.printStackTrace();
			verifyTest("Faliure in verifyHubSearchResultGrid page", false);
		}
	}


	@Then("Verify all hub fields")
	public void verifyHubeSearchResultDetails(){
        try {
        	verifyHubeSearchResultData();
			//exportToExcel();
			//sleep(2000);
			//sendFormByEmail_Fax();        	
        	String[] status = getExcelData().get("STATUS").split("#");
        	String[] targetIcon = getExcelData().get("TARGET_ICON").split("#");
        	String[] targets = getExcelData().get("TARGET").split("#");
        	String[] targetGroups = getExcelData().get("HUB_TARGET_GROUPS").split("#");
        	String[] documents = getExcelData().get("HUB_DOCUMENTS").split("#");
        	int count = getCount(SearchSSNHub.HUB_SEARCH_RESULT_CONST_PATH);
        	for(int row = 1; row<=count; row++){
        		sleep(2000);
        		String hubResultPathRow = SearchSSNHub.HUB_SEARCH_RESULT_CONST_PATH + "[" + row + "]/td[2]";        		
        		String credit = SearchSSNHub.HUB_SEARCH_RESULT_CONST_PATH + "[" + row + "]/td[8]";
				if(getText(credit).equals("WOTC")) {        		
            	doubleClick(hubResultPathRow);
            	sleep(5000);
        		verifyHubeSearchPersonalDetails();
        		vefifyEmployerDetails();
        		//verifyFaxAndMailEntryInSavedNotes();
        		verifyTargetGroups(targets[row-1]);
        		changeTargetGroups(targetGroups[row-1]);
        		verifyTargetGroups(targetGroups[row-1]);
        		verifySelectedDropdownValues(status[row - 1]);
        		verifyTargetGroupIcon(targetIcon[row - 1]);
        		verifyAddedNotesTextArea();
        		verifyDocuments(documents[row-1]);
        		verifyAllFieldsPopulatedInEditRacordPage();
        		editAllFields();
        		verifyHubeSearchPersonalDetails();
        		vefifyEmployerDetails();
        		searchSSN.search_SSN_Home_Menu().click();
        		sleep(5000);        		
				}
        	}
        	sleep(5000);
        //	verifyProcessingIds();
		} catch (Exception e) {
			e.printStackTrace();
			verifyTest("Faliure in verifyHubeSearchResultDetails page",false);
		}
    }

	public void verifyHubeSearchPersonalDetails(){
        try {
        	String name = searchSSN.HUB_SEARCH_DEATILS_NAME().getText();
        	String personalInfoName = getExcelData().get("LNAME") + " "+ getExcelData().get("FNAME");
        	if(!personalInfoName.equalsIgnoreCase(name)){
          		 verifyTest("Name is not matched on hub search result detail page",false);
          	 }

        	int count = getCount(SearchSSNHub.HUB_SEARCH_DEATILS_INFO);
        	for(int field = 1; field<=count; field++){
        		String hubResultPathRow = SearchSSNHub.HUB_SEARCH_DEATILS_INFO + "[" + field + "]/span";

        		switch (field) {
                case 1:
               	 String ssn = getExcelData().get("SSN").substring(0, 3) + "-" + getExcelData().get("SSN").substring(3, getExcelData().get("SSN").length());
               	 String formatedSSN = ssn.substring(0, 6) + "-" + ssn.substring(6,ssn.length());
               	 if(!getText(hubResultPathRow).equals(formatedSSN)){
               		 verifyTest("SSN is not matched on hub search result detail page",false);
               	 }
                    break;
                case 2 :
               	 if(!getText(hubResultPathRow).equals(getExcelData().get("DOB"))){
               		 verifyTest("DOB is not matched on hub search result detail page, Expected : "+getExcelData().get("DOB") +"= Actual : "+getText(hubResultPathRow), false);
               	 }
                    break;
                case 3 :
                	String personalInfoAddress = getExcelData().get("HOME_STREET_ADDRESS") + ", "+ getExcelData().get("CITY") + ", "+ getExcelData().get("STATE") + ", "+ getExcelData().get("ZIP");
                	if(!getText(hubResultPathRow).equalsIgnoreCase(personalInfoAddress)){
               		 verifyTest("Personal info is not matched on hub search result detail page, Expected : "+personalInfoAddress +"= Actual : "+getText(hubResultPathRow) ,false);
               	 }
                    break;
                case 4 :
               	 if(!getExcelData().get("TELEPHONE").trim().equals(getText(hubResultPathRow).trim())){
               		 verifyTest("Telephone name is not matched on hub search result detail page, Expected : "+ getExcelData().get("TELEPHONE").trim() +"= Actual : "+getText(hubResultPathRow).trim(),false);
               	 }
                    break;

                case 5 :
                  	 if(!getExcelData().get("EMAIL").trim().equalsIgnoreCase(getText(hubResultPathRow).trim())){
                  		 verifyTest("Email name is not matched on hub search result detail page, Expected : "+ getExcelData().get("EMAIL").trim() +"= Actual : "+getText(hubResultPathRow).trim(),false);
                  	 }
                       break;
        		}
        	}
		} catch (Exception e) {
			e.printStackTrace();
			verifyTest("Faliure in verifyHubeSearchPersonalDetails page",false);
		}
        }

	public void vefifyEmployerDetails(){
        try {
        	int count = getCount(SearchSSNHub.HUB_SEARCH_COMPANY_DEATILS_INFO);
        	for(int row = 1; row<count; row++){
        		String hubResultPathRow = SearchSSNHub.HUB_SEARCH_COMPANY_DEATILS_INFO + "[" + row + "]/td";
        		int colCount = getCount(hubResultPathRow);
        		for(int column = 1; column<=colCount; column++){
        			String hubResultPathColHeader = hubResultPathRow+ "["+column +"]/div[1]";
        			String hubResultPathColValue = hubResultPathRow+ "["+column +"]/div[2]";
        			if(column != 6){
        				sleep(2000);
        			 switch (getText(hubResultPathColHeader)){

                     case "COMPANY_NAME":                    	 
                    	 if(!getExcelData().get("COMPANY_NAME").trim().equalsIgnoreCase(getText(hubResultPathColValue).trim())){
                      		 verifyTest("Company name is not matched on hub search result detail page, Expected : "+ getExcelData().get("COMPANY_NAME").trim() +"= Actual : "+getText(hubResultPathColValue).trim(),false);
                      	 }
                         break;

                     case "Employer Address":

                         break;

                     case "Screening Method":
                         break;

                     case "Starting Wage":
                    	 String wage = "$"+getExcelData().get("HIRE_WAGE");
                    	 if(! wage.trim().equalsIgnoreCase(getText(hubResultPathColValue).trim())){
                      		 verifyTest("Starting Wage is not matched on hub search result detail page, Expected : "+ wage +"= Actual : "+getText(hubResultPathColValue).trim(),false);
                      	 }
                         break;

                     case "Unit":
                    	 break;

                     case "Position":
                    	 if(!getExcelData().get("HIRE_JOB_POSITION").trim().equalsIgnoreCase(getText(hubResultPathColValue).trim())){
                      		 verifyTest("Position is not matched on hub search result detail page, Expected : "+ getExcelData().get("HIRE_JOB_POSITION").trim() +"= Actual : "+getText(hubResultPathColValue).trim(),false);
                      	 }
                         break;

                     case "Corp Conf No":
                         break;

                     case "Screening Date":
                    	 if(!currentdate().equalsIgnoreCase(getText(hubResultPathColValue).trim())){
                      		 verifyTest("Screening Date is not matched on hub search result detail page, Expected : "+ currentdate().trim() +"= Actual : "+getText(hubResultPathColValue).trim(),false);
                      	 }
                         break;

                     case "eSign Date":

                         break;

                     case "Gave Information Date":
                    	 if(!currentdate().trim().equals(getText(hubResultPathColValue).trim())){
                      		 verifyTest("Gave info date is not matched on hub search result detail page, Expected : "+ currentdate() +"= Actual : "+getText(hubResultPathColValue).trim(),false);
                      	 }
                         break;

                     case "Offer Date":
                    	 if(!currentdate().trim().equals(getText(hubResultPathColValue).trim())){
                    		 verifyTest("Job Offer Date is not matched on hub search result detail page, Expected : "+ currentdate() +"= Actual : "+getText(hubResultPathColValue).trim(),false);
                      	 }

                    	/* if(!getExcelData().get("HIRE_JOB_OFFER_DATE").trim().equalsIgnoreCase(getText(hubResultPathColValue).trim())){
                      		 verifyTest("Job Offer Date is not matched on hub search result detail page, Expected : "+ getExcelData().get("HIRE_JOB_OFFER_DATE").trim() +"= Actual : "+getText(hubResultPathColValue).trim(),false);
                      	 } */
                         break;

                     case "Hire Date":
                    	 if(!currentdate().trim().equals(getText(hubResultPathColValue).trim())){
                    		 verifyTest("Hire date is not matched on hub search result detail page, Expected : "+ currentdate() +"= Actual : "+getText(hubResultPathColValue).trim(),false);
                      	 }

                    	/* if(!getExcelData().get("HIRE_DATE").trim().equalsIgnoreCase(getText(hubResultPathColValue).trim())){
                      		 verifyTest("Hire date is not matched on hub search result detail page, Expected : "+ getExcelData().get("HIRE_DATE").trim() +"= Actual : "+getText(hubResultPathColValue).trim(),false);
                      	 } */
                         break;

                     case "Start Date":
                    	 if(!currentdate().trim().equals(getText(hubResultPathColValue).trim())){
                    		 verifyTest("Start Date is not matched on hub search result detail page, Expected : "+ getExcelData().get("HIRE_START_DATE").trim() +"= Actual : "+getText(hubResultPathColValue).trim(),false);
                      	 }

                    	 /*if(!getExcelData().get("HIRE_START_DATE").trim().equalsIgnoreCase(getText(hubResultPathColValue).trim())){
                      		 verifyTest("Start Date is not matched on hub search result detail page, Expected : "+ getExcelData().get("HIRE_START_DATE").trim() +"= Actual : "+getText(hubResultPathColValue).trim(),false);
                      	 }*/
                         break;
        			 }
        			}

        		}
        	}
		} catch (Exception e) {
			e.printStackTrace();
			verifyTest("Faliure in vefifyEmployerDetails page",false);
		}
    }

	public void editPersonalInformation(){
        try {
        	//editPersonalInformation.edit_Personal_Info_Button().click();
        	String personalInfoPathColValue = null;
        	int count = getCount(editPersonalInfo.PERSONAL_INFO_FIELDS_CONST);
        	for(int row = 1; row<count; row++){
        		String personalInfoPath = editPersonalInfo.PERSONAL_INFO_FIELDS_CONST + "[" + row + "]/div";
        		int colCount = getCount(personalInfoPath);
        		for(int column = 1; column<=colCount; column++){
        			String personalInfoPathColHeader = personalInfoPath+ "["+column +"]/label";
        			sleep(1000);
        			if(column == 4 && row == 2){
            			personalInfoPathColValue = personalInfoPath+ "["+column +"]/div/div/span";
            			}else{
            				personalInfoPathColValue = personalInfoPath+ "["+column +"]/input";
            			}
        			sleep(1000);
        			switch (getText(personalInfoPathColHeader)){
        			case "First Name":
        				if(!getExcelData().get("HUB_EDIT_FIRST_NAME").equals("NO")){
        				userClear(personalInfoPathColValue);
        				userTypes(personalInfoPathColValue, getExcelData().get("HUB_EDIT_FIRST_NAME"));
        				getExcelData().put("FNAME", getExcelData().get("HUB_EDIT_FIRST_NAME"));

        				}
        				break;
        			case "Middle Name":
        				if(!getExcelData().get("HUB_EDIT_MIDDLE_NAME").equals("NO")){
        				userClear(personalInfoPathColValue);
        				userTypes(personalInfoPathColValue, getExcelData().get("HUB_EDIT_MIDDLE_NAME"));
        				getExcelData().put("MNAME", getExcelData().get("HUB_EDIT_MIDDLE_NAME"));
        				}
        				break;
        			case "Last Name":
        				if(!getExcelData().get("HUB_EDIT_LAST_NAME").equals("NO")){
        				userClear(personalInfoPathColValue);
        				userTypes(personalInfoPathColValue, getExcelData().get("HUB_EDIT_LAST_NAME"));
        				getExcelData().put("LNAME", getExcelData().get("HUB_EDIT_LAST_NAME"));
        				}
        				break;

        			case "SSN":        				
        				if(!getExcelData().get("HUB_EDIT_SSN").equals("NO")){
        				String ssn = String.valueOf(ssnGenerator.generateSSN());
        				getExcelData().put("SSN", ssn);
        				userClear(personalInfoPathColValue);
        				userTypes(personalInfoPathColValue, getExcelData().get("SSN"));
        				}
        				break;
        			case "Date of Birth":
        				if(!getExcelData().get("HUB_EDIT_DOB").equals("NO")){
        				userClear(personalInfoPathColValue);       				
        	        	selectCalenderDate(getExcelData().get("HUB_EDIT_DOB"));
        				getExcelData().put("DOB", getExcelData().get("HUB_EDIT_DOB"));
        				sleep(2000);
        				}
        				break;
        			case "Phone":
        				if(!getExcelData().get("HUB_EDIT_PHONE_NUMBER").equals("NO")){
        				userClear(personalInfoPathColValue);
        				userTypes(personalInfoPathColValue, getExcelData().get("HUB_EDIT_PHONE_NUMBER"));
        				getExcelData().put("TELEPHONE", getExcelData().get("HUB_EDIT_PHONE_NUMBER"));
        				}
        				break;
        			case "Email":
        				if(!getExcelData().get("HUB_EDIT_EMAIL_ADDRESS").equals("NO") ){
        				userClear(personalInfoPathColValue);
        				userTypes(personalInfoPathColValue, getExcelData().get("HUB_EDIT_EMAIL_ADDRESS"));
        				getExcelData().put("EMAIL", getExcelData().get("HUB_EDIT_EMAIL_ADDRESS"));
        				}
        				break;
        			case "Address Line1":
        				if(!getExcelData().get("HUB_EDIT_ADDRESS_LINE").equals("NO") ){
        				userClear(personalInfoPathColValue);
        				userTypes(personalInfoPathColValue, getExcelData().get("HUB_EDIT_ADDRESS_LINE"));
        				getExcelData().put("HOME_STREET_ADDRESS", getExcelData().get("HUB_EDIT_ADDRESS_LINE"));
        				}
        				break;
        			case "City":
        				if(!getExcelData().get("HUB_EDIT_CITY").equals("NO")){
        				userClear(personalInfoPathColValue);
        				userTypes(personalInfoPathColValue, getExcelData().get("HUB_EDIT_CITY"));
        				getExcelData().put("CITY", getExcelData().get("HUB_EDIT_CITY"));
        				}
        				break;

        			case "State":        				
        				if(!getExcelData().get("HUB_EDIT_STATE").equals("NO")){
        					userClick(personalInfoPathColValue);
            				selectDropdownValue(editPersonalInfo.PERSONAL_INFO_STATE_FIELD_LIST, getExcelData().get("HUB_EDIT_STATE"));
        				getExcelData().put("STATE", getExcelData().get("HUB_EDIT_STATE"));
        				}
        				break;
        			case "County":
        				if(!getExcelData().get("HUB_EDIT_COUNTRY_NAME").equals("NO")){
        				userClear(personalInfoPathColValue);
        				userTypes(personalInfoPathColValue, getExcelData().get("HUB_EDIT_COUNTRY_NAME"));
        				getExcelData().put("COUNTRY", getExcelData().get("HUB_EDIT_CITY"));
        				}
        				break;
        			case "Zip Code":
        				if(!getExcelData().get("HUB_EDIT_ZIP_CODE").equals("NO")){
        				userClear(personalInfoPathColValue);
        				userTypes(personalInfoPathColValue, getExcelData().get("HUB_EDIT_ZIP_CODE"));
        				getExcelData().put("ZIP", getExcelData().get("HUB_EDIT_ZIP_CODE"));
        				}
        				break;
        			}
        		}
        	}
		} catch (Exception e) {
			e.printStackTrace();
			verifyTest("Faliure in editPersonalInformation page",false);
		}
    }

	public void editAllFields(){
        try {
        	editPersonalInformation.edit_Personal_Info_Button().click();
        	editPersonalInformation();
        	editEmpInfo();
        	editPersonalInformation.edit_Save_Button().click();
        	emplDataUpdatedSuccessfullyMsg();
        	editPersonalInformation.backBtnEditDetailsPage().click();

        } catch (Exception e) {
        	e.printStackTrace();
			verifyTest("Faliure in emplDataUpdatedSuccessfullyMsg page",false);
		}
    }

	public void emplDataUpdatedSuccessfullyMsg(){
        try {
        	String editedFildsSuccessfullMsg = editPersonalInformation.emplDataUpdatedSuccessfullyMsg().getText();
        	if(!editedFildsSuccessfullMsg.contains("Employee details updated successfully")){
        		verifyTest("Empl Data Not Updated",false);
        	}
        	sleep(2000);
        } catch (Exception e) {
        	e.printStackTrace();
			verifyTest("Faliure in emplDataUpdatedSuccessfullyMsg page",false);
		}
    }
	
	public void editEmpInfo(){
	       try {	          
	           sleep(2000);         
	           if(!getExcelData().get("HUB_EDIT_COMPANY_NAME").equals("NO")){
	           editPersonalInformation.edit_Company_Name_TextBox().clear();         
	           editPersonalInformation.edit_Company_Name_TextBox().sendKeys(getExcelData().get("HUB_EDIT_COMPANY_NAME"));
	           sleep(3000);
	           editPersonalInformation.edit_Company_Select().click();
	           getExcelData().put("COMPANY_NAME", getExcelData().get("HUB_EDIT_COMPANY_NAME"));
	           }
	           if(!getExcelData().get("HUB_EDIT_UNIT_NAME").equals("NO")){
	           sleep(1000);
	           unitNameSelection(getExcelData().get("HUB_EDIT_UNIT_NAME"));
	           getExcelData().put("UNIT_LOCATION", getExcelData().get("HUB_EDIT_UNIT_NAME"));
	           }

	           if(!getExcelData().get("HUB_EDIT_HIRE_DATE").equals("NO")){
	           sleep(1000);
	           editPersonalInformation.edit_Hire_Date().clear();
	           selectCalenderDate(currentdate());
	           getExcelData().put("HIRE_DATE", currentdate());
	           }

	           if(!getExcelData().get("HUB_EDIT_START_DATE").equals("NO")){
	           sleep(1000);
	           editPersonalInformation.edit_Start_Date().clear();
	           selectCalenderDate(currentdate());
	           getExcelData().put("HIRE_START_DATE", currentdate());
	           }

	          if(!getExcelData().get("HUB_EDIT_POSITION").equals("NO")){
	           sleep(1000);
	           editPersonalInformation.edit_Position_Dropdown_Arrow().click();
	           selectDropdownValue(editPersonalInfo.EMPLOYEE_POSITION_DROPDOWN_CONST, getExcelData().get("HUB_EDIT_POSITION"));
	           getExcelData().put("HIRE_JOB_POSITION", getExcelData().get("HUB_EDIT_POSITION"));
	           }

	           if(!getExcelData().get("HUB_EDIT_STARTING_WAGE").equals("NO")){
	           editPersonalInformation.edit_Starting_Wages_TextBox().clear();
	           editPersonalInformation.edit_Starting_Wages_TextBox().sendKeys(getExcelData().get("HUB_EDIT_STARTING_WAGE"));
	           getExcelData().put("HIRE_WAGE", getExcelData().get("HUB_EDIT_STARTING_WAGE"));
	           }

	           if(!getExcelData().get("HUB_EDIT_GAVE_INFO_DATE").equals("NO")){
	           sleep(1000);
	           editPersonalInformation.edit_Wages_Gave_Information_Date().clear();
	           selectCalenderDate(currentdate());
	           getExcelData().put("HIRE_GAVE_INFO_DATE", currentdate());
	           }
	           if(!getExcelData().get("HUB_EDIT_OFFER_DATE").equals("NO")){
	           sleep(1000);
	           editPersonalInformation.edit_Offer_Date_TextBox().clear();
	           selectCalenderDate(currentdate());
	           getExcelData().put("HIRE_JOB_OFFER_DATE", currentdate());
	           }

	      if(!getExcelData().get("HUB_EDIT_ESIGN_DATE").equals("NO")){
	         sleep(1000);
	         //editPersonalInformation.edit_esign_Date_TextBox().clear();
	         editPersonalInformation.edit_Employee_Signature_Date().clear();
	         selectCalenderDate(currentdate());
	         getExcelData().put("HUB_EDIT_ESIGN_DATE", currentdate());
	      }
	   } catch (Exception e) {
	      e.printStackTrace();
	      verifyTest("Faliure in editEmpInfo page",false);
	   }
	   }

	public void unitNameSelection(String unitName){
        try {
        	editPersonalInformation.emp_Info_Unit_Search_Icon().click();
			sleep(1000);
        	editPersonalInformation.unit_Search_Popup_Unit_Name().sendKeys(unitName);
			sleep(1000);
        	editPersonalInformation.unit_Search_Popup_Search_Btn().click();
			sleep(1000);
        	editPersonalInformation.unit_Search_Popup_Result_First_Row().click();
			sleep(1000);

        } catch (Exception e) {
			verifyTest("Faliure in unitNameSelection page",false);
			e.printStackTrace();
		}
    }

	public void selectDropdownStatusValue(String statusValue){
        try {
        	editPersonalInformation.recordStatusDropdownBtn().click();
        	selectDropdownValueByContains(EditPersonalInfo.RECORD_STATUS_DROPDOWN_lIST_CONST, statusValue);
        	editPersonalInformation.saveBtnOnRecordDetailsPage().click();
        	sleep(2000);
        } catch (Exception e) {
			verifyTest("Faliure in unitNameSelection page",false);
			e.printStackTrace();
		}
    }

	public void verifySelectedDropdownValues(String statusValue){
        try {
        	String selectedDropDownValues = editPersonalInformation.recordStatusDropdownSelectedValue().getText();
        	if(!getStatusName(statusValue).equals(selectedDropDownValues)){
        		verifyTest("Dropdown status value is not matched",false);
        	}
        	sleep(2000);
        } catch (Exception e) {
			verifyTest("Faliure in verifySelectedDropdownValues page",false);
			e.printStackTrace();
		}
    }


	public String getStatusName(String statusValue){
		String status = null;
        try {
        	switch (statusValue){
			case "E":
				status = "eSign";
				break;
	        case "P":
				status = "Pending";
				break;
			case "I":
				status = "InEligible";
				break;
			case "K":
				status = "Keyed/Received";
				break;
			case "M":
				status = "Miss 8850 Sign/POH/CA Info";
				break;
			case "S":
				status = "State";
				break;
			case "A":
				status = "Agency";
				break;
			case "F":
				status = "New Form 8850 Required";
				break;
			default :
					status = statusValue;
					break;
			}
        } catch (Exception e) {
			verifyTest("Faliure in getStatusName()",false);
			e.printStackTrace();
		}
		return status;
    }



	

	public void verifyTargetGroupIcon(String targetGroupValue){
        try {
        	String targetGroupText = editPersonalInformation.targetGroupIcon().getText();
        	if(!targetGroupValue.equals(targetGroupText)){
        		verifyTest("Target Group Icon is not matched",false);
        	}
        } catch (Exception e) {

			verifyTest("Faliure in verifyTargetGroupIcon page",false);
			e.printStackTrace();
		}
    }

	public void verifyAddedNotesTextArea(){
		String noteText = "Text added for testing notes text by Selenium BDD framework";
        try {
        	editPersonalInformation.addNotesTextArea().sendKeys(noteText);
        	editPersonalInformation.saveBtnOnRecordDetailsPage().click();
        	sleep(2000);
        	String user = editPersonalInformation.addNotesUser().getText();
        	String date = editPersonalInformation.addNotesDate().getText();
        	String notes = editPersonalInformation.addNotesText().getText();
        	if(!loadPropValues("userFullName").equals(user)){
        		verifyTest("Note user not matched",false);
        	}
        	if(!currentdate().trim().contains(date.split(" ")[0].trim())){
        		verifyTest("Note date not matched",false);
        	}
        	if(!noteText.equals(notes)){
        		verifyTest("Note text not matched",false);
        	}
        	verifyRecordsUpdatedMSg();
        } catch (Exception e) {
        	e.printStackTrace();
			verifyTest("Faliure in verifyAddedTextArea page",false);

		}
    }

	public void verifyTargetGroups(String targetGroups){
		boolean isPresent;

        try {
        	if(targetGroups != "" || targetGroups != null){
        		String[] targets = targetGroups.split("@");
	        	if(!isDisplayed(EditPersonalInfo.TARGET_GROUPS_IS_PRESENT)){
	        		verifyTest("targets Group are not dispalyed for this credits", false);
	        	}
        		int count = getCount(EditPersonalInfo.TARGET_GROUPS_CONST_VALUES);
        		for(int j = 0; j<targets.length; j++){
        			isPresent = false;
            	for(int i = 1; i<=count; i++){
            		String tragetGroupsValues = EditPersonalInfo.TARGET_GROUPS_CONST_VALUES + "[" + i + "]/span";
            		if(getText(tragetGroupsValues).trim().equals(targets[j])){
            			isPresent = true;
            			break;

                	}
            	}
            	if(isPresent == false){
            		verifyTest("targets Group not matched", false);
            		break;
            	}
        	}
        	}else{
        		System.out.println("Target groups not avialble for this credits");
        	}
		} catch (Exception e) {
			e.printStackTrace();
			verifyTest("Faliure in verifyTargetGroups page",false);
		}
    }

	public void changeTargetGroups(String targetGroups){
        try {
        	sleep(2000);
        	editPersonalInformation.moreDetailsLinkOnTargetGroup().click();
        	sleep(2000);
        	if(targetGroups != "" || targetGroups != null){
        		String[] targets = targetGroups.split("@");

        	if(!isDisplayed(EditPersonalInfo.ALL_TARGET_GROUPS_CONST_VALUES_ON_MORE_DETAILS_PRESENT)){
        		verifyTest("Target groups are not dispalyed ",false);
        	}
            	for(int i = 0; i<targets.length; i++){
            		if(!bcAct.updateForTargetResult(targets[i]).isSelected()) {
                        bcAct.updateForTargetResult(targets[i]).click();

                    }	
            	}            	

            	javaScriptClick(editPersonalInformation.saveBtnOnTargetGroupMoreDetails());
            	sleep(2000);
            	if(editPersonalInformation.confirmationPopUpText().getText().equals("Target group eligibility is calculated based on screening information."
            			+ " Are you sure you want to directly update the Target Groups?")){
            		editPersonalInformation.confirmationPopUpSaveBtn().click();
            		sleep(3000);
            		if(editPersonalInformation.dataSavedSuccessfullyText().getText().equals("Status details updated successfully.")){
            		editPersonalInformation.backBtn().click();
	            	}
	            }else{
	            		verifyTest("Confirmation Pop up is not dispalyed after saving target groups",false);
	            	}

        	}else{
        		System.out.println("Target groups not avialble for this credits");
        		editPersonalInformation.backBtn().click();
        	}
		} catch (Exception e) {
			e.printStackTrace();
			verifyTest("Faliure in changeTargetGroups page",false);
		}
    }

	public void verifyRecordsUpdatedMSg(){
		String savedRecordMsg = "Record details updated successfully.";
		try{
        	String msg = editPersonalInformation.successfulMsgText().getText();
        	if(!msg.equals(savedRecordMsg)){
        		verifyTest("Record details are not updated successfully. , Expected : "+ savedRecordMsg + " , Actual : "+msg ,false);
        	}
        } catch (Exception e) {
        	e.printStackTrace();
			verifyTest("Faliure in verifyRecordsUpdatedMSg page",false);
		}
    }
	@Then("edit Employment Information from Details page")
	public void setEditEmploymentInformation()
	{
		try{
			int count = getCount(SearchSSNHub.HUB_SEARCH_RESULT_CONST_PATH);
			for(int row = 1; row<=count; row++) {
				sleep(2000);
				String hubResultPathRow = SearchSSNHub.HUB_SEARCH_RESULT_CONST_PATH + "[" + row + "]/td[2]";
				String credit = SearchSSNHub.HUB_SEARCH_RESULT_CONST_PATH + "[" + row + "]/td[8]";
				if (getText(credit).equals("WOTC")) {
					sleep(2000);
					doubleClick(hubResultPathRow);
					sleep(4000);
					editPersonalInformation.edit_Personal_Info_Button().click();
					sleep(4000);
					editEmpInfo();
					sleep(2000);
					editPersonalInformation.edit_Save_Button().click();
					emplDataUpdatedSuccessfullyMsg();
					editPersonalInformation.backBtnEditDetailsPage().click();
					sleep(2000);
					searchSSN.search_SSN_Home_Menu().click();
					sleep(5000);
				}
			}

		}catch (Exception e)
		{
			e.printStackTrace();
			verifyTest("Faliure in setEditEmploymentInformation page",false);
		}


	}

	@Then("edit Status of Screening Record to Status")
	public void changeStatus(@Named("changedStatus") String changedStatus){
        try { 
        	int count = getCount(SearchSSNHub.HUB_SEARCH_RESULT_CONST_PATH);           
              for(int row = 1; row<=count; row++){
                    sleep(2000);
                    String hubResultPathRow = SearchSSNHub.HUB_SEARCH_RESULT_CONST_PATH + "[" + row + "]/td[2]";
                    String credit = SearchSSNHub.HUB_SEARCH_RESULT_CONST_PATH + "[" + row + "]/td[8]";
                    sleep(2000);
                    if(getText(credit).equals("WOTC")){
                          sleep(2000);
                          doubleClick(hubResultPathRow);
                          sleep(2000);
                          if (changedStatus.equalsIgnoreCase("eSign")) {
                                try {
                                      editEmployeeSignatureDateFieldsforChangingStatusfromPtoE();
                                } catch (Exception e) {
                                      verifyTest("Failed to edit Employee Signature Date Fields for Changing Status from PtoE in verifyHubeSearchResultDetails page",false);
                                      e.printStackTrace();
                                }
                          }
                          sleep(2000);
                          selectDropdownStatusValue(changedStatus);
                          verifyRecordsUpdatedMSg();
                          verifySelectedDropdownValues(changedStatus);                         
                          searchSSN.search_SSN_Home_Menu().click();
                          sleep(5000);
                    }                    
              }
        } catch (Exception e) {
              verifyTest("Faliure in verifyHubeSearchResultDetails page",false);
              e.printStackTrace();
        }
  }




		public void exportToExcel(){
			requestIds.remove("EXPOERT_TO_EXCEL_REQUEST_ID");
			String msg = "A maximum of 15000 records matching the search criteria will be exported to excel. Do you want to continue?";
			try {
				sleep(2000);
	        	editPersonalInformation.exportToExcelBtn().click();
	        	sleep(2000);
	        	String text = editPersonalInformation.exportToExcelPopMsg().getText();
	        	if(!msg.equals(text)){
	        		verifyTest("Record details are not updated successfully. , Expected : "+ text + " , Actual : "+msg ,false);
	        	}else{
	        		editPersonalInformation.exportToExcelPopUpSubmitBtn().click();
	        		sleep(3000);
	        		String requestIdMsg = editPersonalInformation.exportToExcelPopUpRequestId().getText();
	        		String requestId = requestIdMsg.substring(requestIdMsg.lastIndexOf(" ")+1);
	        		requestIds.put("EXPOERT_TO_EXCEL_REQUEST_ID", requestId);
	        		editPersonalInformation.exportToExcelPopUpCloseBtn().click();
	        	}
	        } catch (Exception e) {
	        	e.printStackTrace();
				verifyTest("Faliure in exportToExcel page",false);
			}
	    }

		public void sendFormByEmail_Fax(){
			try {
				editPersonalInformation.selectAllRedioBtnOnHubResult().click();
				sendFormByEmail();
				sleep(2000);
				sendFormByFax();
				editPersonalInformation.selectAllRedioBtnOnHubResult().click();
	        } catch (Exception e) {
	        	e.printStackTrace();
				verifyTest("Faliure in sendFormByEmail_Fax page",false);
			}
	    }

		public void sendFormByEmail(){
			requestIds.remove("SEND_BY_MAIL_REQUEST_ID");
			try {
	        	editPersonalInformation.massMailSendBtn().click();
	        	sleep(2000);
	        	editPersonalInformation.enterMsgOnMassForSend().sendKeys("automation testing using selenium BDD framework");
	        	sleep(2000);
	        	editPersonalInformation.enterMAilAddressOnMassForSend().sendKeys("sahil.thorat@adp.com");
	        	sleep(2000);
	        	editPersonalInformation.sendFormBtnOnMassForm().click();
	        	sleep(4000);
	        	String requestIdMsg = editPersonalInformation.massFormRequestIdMsg().getText();
	        	String requestId = requestIdMsg.substring(requestIdMsg.lastIndexOf(" ")+1);
	        	requestIds.put("SEND_BY_MAIL_REQUEST_ID", requestId);
	        } catch (Exception e) {
	        	e.printStackTrace();
				verifyTest("Faliure in sendFormByEmail page",false);
			}
	    }

		public void sendFormByFax(){
			requestIds.remove("SEND_BY_FAX_REQUEST_ID");
			try {
				sleep(1000);
	        	editPersonalInformation.massMailSendBtn().click();
	        	sleep(1000);
	        	editPersonalInformation.sendFormByFaxRedioBtn().click();
	        	sleep(2000);
	        	editPersonalInformation.areaCodeFieldOnMassForm().sendKeys("843");
	        	sleep(2000);
	        	editPersonalInformation.faxNumberFieldOnMassForm().sendKeys("6792321");

	        	sleep(2000);
	        	editPersonalInformation.sendToFieldOnMassForm().sendKeys("sahil.thorat@adp.com");
	        	sleep(1000);
	        	editPersonalInformation.sendFormBtnOnMassForm().click();
	        	sleep(4000);
	        	String requestIdMsg = editPersonalInformation.massFormRequestIdMsg().getText();
	        	String requestId = requestIdMsg.substring(requestIdMsg.lastIndexOf(" ")+1);
	        	requestIds.put("SEND_BY_FAX_REQUEST_ID", requestId);
	        } catch (Exception e) {
	        	e.printStackTrace();
				verifyTest("Faliure in sendFormByFax page",false);
			}
	    }

		public void verifyProcessingIds(){
			try {
				String screeningURL = (loadPropValues("SCPHome"));
	            getDriver().get(screeningURL);
	            sleep(3000);
	            hub.Search_SSN_Process_Tab().click();
				hub.Search_SSN_Process_Tax_Credit_Tab().click();
				hub.Search_SSN_Process_Tax_Credit_Operation_Tab().click();
		        explicitWaitForElement(SearchSSNHub.SEARCH_SSN_THE_HUB_LINK,65);
		        //editPersonalInformation.processingQueueLink().click();
		        javaScriptClick(editPersonalInformation.processingQueueLink());
		        sleep(2000);
		        Set<Map.Entry<String, String>> entrySet = requestIds.entrySet();
		        for (Entry entry : entrySet) {
		           System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
		           editPersonalInformation.processingIdFieldOnProcessingQueue();
		           sleep(2000);
		           editPersonalInformation.processingIdFieldOnProcessingQueue().sendKeys(String.valueOf(entry.getValue()));
		           sleep(1000);
			        editPersonalInformation.searchBtnOnProcessingQueue().click();
			        sleep(4000);
					String status = editPersonalInformation.statusColOnProcessingQueueReult().getText();
					if(!status.equals("Completed")){
						verifyTest("Processing Id status is not matching, Expected : Completed, Actual : Processing",false);
					}
		        }
		        hub.Search_SSN_Process_Tab().click();
				hub.Search_SSN_Process_Tax_Credit_Tab().click();
				hub.Search_SSN_Process_Tax_Credit_Operation_Tab().click();
		        explicitWaitForElement(SearchSSNHub.SEARCH_SSN_THE_HUB_LINK,65);
		        WebElement hubLink = hub.Search_SSN_The_Hub_Link();
		        Thread.sleep(2000);
		        windowAct.switchtoMultiChildWindow(hubLink);
		        explicitWaitForElement(SearchSSNHub.SEARCH_SSN_INPUTBOX,65);
	        } catch (Exception e) {
	        	e.printStackTrace();
				verifyTest("Faliure in verifyProcessingIds page",false);
			}
	    }

		public void verifyDocuments(String docNameValue){
			//String[] docsNameValues = docNameValue.split("@");
			boolean isPresent;
		     try {
		    	 if(docNameValue != "" || docNameValue != null){
		    		 String[] docsNameValues = docNameValue.split("@");
		    		 if(!isDisplayed(EditPersonalInfo.DOCUMENTS_lIST_CONST)){
		    			 verifyTest("targets Group are not avialble", false);
		    		 }
		           int count = getCount(EditPersonalInfo.DOCUMENTS_lIST_CONST);
		           for(int j = 0; j<docsNameValues.length; j++){
		        	   isPresent = false;
		        	   String[] docsStatusCheck = docsNameValues[j].split("=");
		           for(int row = 1; row<=count; row++){
		                  String documentsName = EditPersonalInfo.DOCUMENTS_lIST_CONST+ "[" + row + "]//div[@class='document-tile-text']/span";
		                  String documentsValue = EditPersonalInfo.DOCUMENTS_lIST_CONST+ "[" + row + "]//button/span[1]";
		                  System.out.println(getText(documentsName) + "#" + getText(documentsValue));
		                  if(getText(documentsName).equals(docsStatusCheck[0]) && getText(documentsValue).equals(docsStatusCheck[1])){
		                	  isPresent = true;
		                	  break;
		                  }
		           }
		           if(isPresent == false){
		        	   verifyTest("targets Group not matched", false);
		        	   break;
		           }

		           }
		    	 }
		           } catch (Exception e) {
		        	   e.printStackTrace();
		               verifyTest("Faliure in verifyHubeSearchResultDetails page",false);
		           }
				}

		public void verifyPopulatedValuesInPersonalInfoEditRecordPage(){
	        try {
	        	String personalInfoPathColValue = null;
	        	int count = getCount(editPersonalInfo.PERSONAL_INFO_FIELDS_CONST);
	        	for(int row = 1; row<count; row++){
	        		String personalInfoPath = editPersonalInfo.PERSONAL_INFO_FIELDS_CONST + "[" + row + "]/div";
	        		int colCount = getCount(personalInfoPath);
	        		for(int column = 1; column<=colCount; column++){
	        			String personalInfoPathColHeader = personalInfoPath+ "["+column +"]/label";
	        			sleep(1000);
	        			if(column == 4 && row == 2){
	            			personalInfoPathColValue = personalInfoPath+ "["+column +"]/div/div/span";
	            			}else{
	            				personalInfoPathColValue = personalInfoPath+ "["+column +"]/input";
	            			}
	        			sleep(1000);
	        			switch (getText(personalInfoPathColHeader)){
	        			case "First Name":
	        				if(!getAttributeValue(personalInfoPathColValue,"value").equals(getExcelData().get("FNAME"))){
	        					verifyTest("First Name field is not matched on edit record page, Expected : "+getExcelData().get("FNAME") + " , Actual : "+getAttributeValue(personalInfoPathColValue,"value") ,false);
	        				}
	        				break;
	        			case "Middle Name":
	        				if(!getAttributeValue(personalInfoPathColValue,"value").equals(getExcelData().get("MNAME"))){
	        					verifyTest("Middle Name field is not matched on edit record page, Expected : "+getExcelData().get("MNAME") + " , Actual : "+getAttributeValue(personalInfoPathColValue,"value") ,false);
	        				}
	        				break;
	        			case "Last Name":
	        				if(!getAttributeValue(personalInfoPathColValue,"value").equals(getExcelData().get("LNAME"))){
	        					verifyTest("Last Name field is not matched on edit record page, Expected : "+getExcelData().get("LNAME") + " , Actual : "+getAttributeValue(personalInfoPathColValue,"value") ,false);
	        				}

	        				break;
	        			case "SSN":
	        				String ssn = getExcelData().get("SSN").substring(0, 3) + "-" + getExcelData().get("SSN").substring(3, getExcelData().get("SSN").length());
	                    	 String formatedSSN = ssn.substring(0, 6) + "-" + ssn.substring(6,ssn.length());
	        				if(!getAttributeValue(personalInfoPathColValue,"value").equals(formatedSSN)){
	        					verifyTest("SSN field is not matched on edit record page, Expected : "+formatedSSN + " , Actual : "+getAttributeValue(personalInfoPathColValue,"value") ,false);
	        				}
	        				break;
	        			case "Date of Birth":
	        				if(!getAttributeValue(personalInfoPathColValue,"value").equals(getExcelData().get("DOB"))){
	        					verifyTest("DOB field is not matched on edit record page, Expected : "+getExcelData().get("DOB") + " , Actual : "+getAttributeValue(personalInfoPathColValue,"value") ,false);
	        				}
	        				break;
	        			case "Phone":
	        				String phone = getExcelData().get("TELEPHONE").replace(" ", "");
	        				if(!getAttributeValue(personalInfoPathColValue,"value").trim().equals(phone)){
	        					verifyTest("Phone field is not matched on edit record page, Expected : "+phone + " , Actual : "+getAttributeValue(personalInfoPathColValue,"value") ,false);
	        				}
	        				break;
	        			case "Email":
	        				if(!getAttributeValue(personalInfoPathColValue,"value").trim().equalsIgnoreCase(getExcelData().get("EMAIL").trim())){
	        					verifyTest("Email field is not matched on edit record page, Expected : "+getExcelData().get("EMAIL") + " , Actual : "+getAttributeValue(personalInfoPathColValue,"value") ,false);
	        				}
	        				break;
	        			case "Address Line1":
	        				if(!getAttributeValue(personalInfoPathColValue,"value").trim().equalsIgnoreCase(getExcelData().get("HOME_STREET_ADDRESS").trim())){
	        					verifyTest("Address Line1 field is not matched on edit record page, Expected : "+getExcelData().get("HOME_STREET_ADDRESS") + " , Actual : "+getAttributeValue(personalInfoPathColValue,"value") ,false);
	        				}
	        				break;
	        			case "City":
	        				if(!getAttributeValue(personalInfoPathColValue,"value").trim().equalsIgnoreCase(getExcelData().get("CITY").trim())){
	        					verifyTest("City field is not matched on edit record page, Expected : "+getExcelData().get("CITY") + " , Actual : "+getAttributeValue(personalInfoPathColValue,"value") ,false);
	        				}
	        				break;
	        			case "State":
	        				if(!getText(personalInfoPathColValue).trim().equals(getExcelData().get("STATE").trim())){
	        					verifyTest("State field is not matched on edit record page, Expected : "+getExcelData().get("CITY") + " , Actual : "+getText(personalInfoPathColValue) ,false);
	        				}

	        				break;
	        			case "County":
	        				break;
	        			case "Zip Code":
	        				if(!getAttributeValue(personalInfoPathColValue,"value").trim().equals(getExcelData().get("ZIP").trim())){
	        					verifyTest("Zip Code field is not matched on edit record page, Expected : "+getExcelData().get("ZIP") + " , Actual : "+getAttributeValue(personalInfoPathColValue,"value") ,false);
	        				}
	        				break;
	        			}
	        		}
	        	}
			} catch (Exception e) {
				e.printStackTrace();
				verifyTest("Faliure in verifyPopulatedValuesInPersonalInfoEditRecordPage page",false);
			}
	    }

		public void verifyPopulatedValuesInEmplInfoEditRecordPage(){
	        try {
	        	if(!getAttributeValue(editPersonalInformation.edit_Company_Name_TextBox(),"value").equalsIgnoreCase(getExcelData().get("COMPANY_NAME"))){
					verifyTest("Company Name field is not matched on edit record page, Expected : "+getExcelData().get("COMPANY_NAME") + " , Actual : "+getAttributeValue(editPersonalInformation.edit_Company_Name_TextBox(),"value") ,false);
				}
	        	

	        	if(!getAttributeValue(editPersonalInformation.edit_Hire_Date(),"value").equals(currentdate())){
	        		if(!getAttributeValue(editPersonalInformation.edit_Hire_Date(),"value").equals(getExcelData().get("HIRE_DATE"))){
	        			verifyTest("Hire date field is not matched on edit record page, Expected : "+getExcelData().get("HIRE_DATE") + " , Actual : "+getAttributeValue(editPersonalInformation.edit_Hire_Date(),"value") ,false);
	        		}
				}

	        	if(!getAttributeValue(editPersonalInformation.edit_Start_Date(),"value").equals(currentdate())){
	        		if(!getAttributeValue(editPersonalInformation.edit_Hire_Date(),"value").equals(getExcelData().get("HIRE_START_DATE"))){
	        			//verifyTest("Start Date field is not matched on edit record page, Expected : "+getExcelData().get("HIRE_START_DATE") + " , Actual : "+getAttributeValue(editPersonalInformation.edit_Start_Date(),"value") ,false);
	        			System.out.println("Start Date field is not matched on edit record page, Expected : "+getExcelData().get("HIRE_START_DATE") + " , Actual : "+getAttributeValue(editPersonalInformation.edit_Start_Date(),"value"));
	        		}
				}

	        	if(!getText(editPersonalInformation.edit_Position_Dropdown()).equals(getExcelData().get("HIRE_JOB_POSITION"))){
					verifyTest("Job Position field is not matched on edit record page, Expected : "+getExcelData().get("HIRE_JOB_POSITION") + " , Actual : "+getText(editPersonalInformation.edit_Position_Dropdown()) ,false);
				}

	        	if(!getAttributeValue(editPersonalInformation.edit_Starting_Wages_TextBox(),"value").equals(getExcelData().get("HIRE_WAGE"))){
					verifyTest("Hire Wage field is not matched on edit record page, Expected : "+getExcelData().get("HIRE_WAGE") + " , Actual : "+getAttributeValue(editPersonalInformation.edit_Starting_Wages_TextBox(),"value") ,false);

				}

	        	if(!getAttributeValue(editPersonalInformation.edit_Wages_Gave_Information_Date(),"value").equals(currentdate())){
	        		if(!getAttributeValue(editPersonalInformation.edit_Hire_Date(),"value").equals(getExcelData().get("HIRE_GAVE_INFO_DATE"))){
	        			verifyTest("Gave Info Date field is not matched on edit record page, Expected : "+getExcelData().get("HIRE_GAVE_INFO_DATE") + " , Actual : "+getAttributeValue(editPersonalInformation.edit_Wages_Gave_Information_Date(),"value") ,false);
	        		}
				}

	        	if(!getAttributeValue(editPersonalInformation.edit_Offer_Date_TextBox(),"value").equals(currentdate())){
	        		if(!getAttributeValue(editPersonalInformation.edit_Hire_Date(),"value").equals(getExcelData().get("HIRE_JOB_OFFER_DATE"))){
	        			verifyTest("Job Offer Date field is not matched on edit record page, Expected : "+getExcelData().get("HIRE_JOB_OFFER_DATE") + " , Actual : "+getAttributeValue(editPersonalInformation.edit_Offer_Date_TextBox(),"value") ,false);
	        		}
				}

	        	if(!getAttributeValue(editPersonalInformation.edit_Screenin_Method(),"value").equals(getExcelData().get("SCREENING_METHOD"))){
					verifyTest("Screening MEthod field is not matched on edit record page, Expected : "+getExcelData().get("SCREENING_METHOD")+", Actual : "+getAttributeValue(editPersonalInformation.edit_Screenin_Method(),"value") ,false);
				}

	        	if(getExcelData().get("ESIGN").equals("YES")){
	        		if(!getAttributeValue(editPersonalInformation.edit_Employee_Signature(),"value").equals(currentdate())){
						verifyTest("Employee Signature field is not matched on edit record page, Expected : "+currentdate() + " , Actual : "+getAttributeValue(editPersonalInformation.edit_Employee_Signature(),"value") ,false);
					}
	        	}
			} catch (Exception e) {
				e.printStackTrace();
				verifyTest("Faliure in verifyPopulatedValuesInEmplInfoEditRecordPage page",false);
			}
	    }

		public void verifyAllFieldsPopulatedInEditRacordPage(){
	        try {
	        	editPersonalInformation.edit_Personal_Info_Button().click();
	        	sleep(1000);
	        	waitForLoad();
	        	verifyPopulatedValuesInPersonalInfoEditRecordPage();
	        	verifyPopulatedValuesInEmplInfoEditRecordPage();
	        	editPersonalInformation.backBtnEditDetailsPage().click();
	        	sleep(1000);
	        } catch (Exception e) {
	        	e.printStackTrace();
				verifyTest("Faliure in verifyAllFieldsPopulatedInEditRacordPage page",false);
			}
	    }
		
		public void verifyFaxAndMailEntryInSavedNotes(){
			boolean isPresent = false;
		     try {  
		           int count = getCount(EditPersonalInfo.SAVED_NOTES_CONST_PATH);           
		           for(int row = 2; row<count; row++){
		                  sleep(2000);
		                  String savedResultRow = EditPersonalInfo.SAVED_NOTES_CONST_PATH + "[" + row + "]/td";
		                  int colCount = getCount(savedResultRow);		                  
		                  for(int col = 1; col<=colCount; col++){
		                	  String value = savedResultRow + "[" + col + "]";
		                	  
		                	  if(col == 1){
		                		  System.out.println(getText(value)+"---"+loadPropValues("userFullName").trim());
		                		  if(!loadPropValues("userFullName").trim().equals(getText(value).trim())){
		                			  if(!getText(value).trim().contains("DEFAULT_USER")){
		                				  verifyTest("Note user not matched",false);
		                			  }		                			  	
				                  	}		                		  
		                	  }		                	
		                	  if(col == 2){
		                		  System.out.println(getText(value));
		                		  if(!currentdate().trim().contains(getText(value).split(" ")[0].trim())){
				                  		verifyTest("Note date not matched",false);
				                  	}
		                	  }
		                	  if(col == 3){
		                		  System.out.println(getText(value));
		                		  if(requestIds.containsKey("SEND_BY_FAX_REQUEST_ID") || requestIds.containsKey("SEND_BY_MAIL_REQUEST_ID")){		                			  
		                		  if(getText(value).contains("Fax Request Initiated at") || getText(value).contains("Smart package sent to client at")){
		                			  isPresent = true;
				                  	}else{
				                  		verifyTest("Fax Request is not Initiated and Smart package is not sent to client",false);
				                  	}
		                		  }                		 
		                	  }	                	  
		                  	}                            
		           		}
		           
		           if(isPresent == false){
		        	   verifyTest("Fax and Send mail msg is not displaying in Saved Notes",false);
		           }
		           } catch (Exception e) {
		                  verifyTest("Faliure in verifyFaxAndMailEntryInSavedNotes page",false);
		                  e.printStackTrace();
		           }
		     }
		
				public void editEmployeeSignatureDateFieldsforChangingStatusfromPtoE(){
		            try {
		            	sleep(2000);
		                  editPersonalInformation.edit_Personal_Info_Button().click();
						sleep(2000);
		                  editESigndate();
		                  editPersonalInformation.edit_Save_Button().click();
						sleep(3000);
		                  emplDataUpdatedSuccessfullyMsg();
						sleep(2000);
		                  editPersonalInformation.backBtnEditDetailsPage().click();
						sleep(2000);
		                  
		            } catch (Exception e) {
		                  e.printStackTrace();
		                  verifyTest("Faliure in emplDataUpdatedSuccessfullyMsg page",false);                 
		            }
		      }

				public void editESigndate()
			      {
			            try
			            {
			                  if(getExcelData().get("HUB_EDIT_ESIGN_DATE") == "" || !getExcelData().get("HUB_EDIT_ESIGN_DATE").equals("NO")){
			                        sleep(2000);
			                        editPersonalInformation.edit_Employee_Signature_Date().clear();
			                        selectCalenderDate(currentdate());
			                        getExcelData().put("HUB_EDIT_ESIGN_DATE", currentdate());
			                  }        
			                  
			            } catch (Exception e) {
			                  e.printStackTrace();
			                  verifyTest("Faliure in editEmpInfo page",false);                  
			            }
			      }

	@Then("Edit Employment Unit for Specific User On Edit Details Page")
	public void editUnitAtEditDetailsPage()
	{
		try{
			sleep(2000);
			int count = getCount(SearchSSNHub.HUB_SEARCH_RESULT_CONST_PATH);
			for(int row = 1; row<=count; row++) {
				String hubResultPathRow = SearchSSNHub.HUB_SEARCH_RESULT_CONST_PATH + "[" + row + "]/td[2]";
				String credit = SearchSSNHub.HUB_SEARCH_RESULT_CONST_PATH + "[" + row + "]/td[8]";
				if (getText(credit).equals("WOTC")) {
					sleep(2000);
					doubleClick(hubResultPathRow);
					sleep(2000);
					editPersonalInformation.edit_Personal_Info_Button().click();
					sleep(2000);
					if(!getExcelData().get("HUB_EDIT_UNIT_NAME").equals("NO")){
						sleep(2000);
						unitNameSelection(getExcelData().get("HUB_EDIT_UNIT_NAME"));
						sleep(2000);
						getExcelData().put("UNIT_LOCATION", getExcelData().get("HUB_EDIT_UNIT_NAME"));
					}
					editPersonalInformation.edit_Save_Button().click();
					sleep(3000);
					WebElement selctdrp = getDriver().findElement(By.xpath("//*[@id=\"addressVerifyModal\"]/div/div/div[2]/select"));
					selectDropdownByValue(selctdrp,"0");
					sleep(3000);
					getDriver().findElement(By.xpath("//*[@id=\"addressVerifyModal\"]/div/div/div[3]/button[1]/span")).click();
					sleep(3000);
					editPersonalInformation.edit_Save_Button().click();
					sleep(3000);
					emplDataUpdatedSuccessfullyMsg();
					editPersonalInformation.backBtnEditDetailsPage().click();
					sleep(2000);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			verifyTest("Faliure in editUnitAtEditDetailsPage page",false);
		}
	}
	
	@Then("Verify updated documents status in document tab")
	public void verifyDocufreeSupportDocsTab(){
        try {
        	verifyHubeSearchResultData();
        	String[] documents = getExcelData().get("DOCUMENTS_STATUS").split("#");
        	int count = getCount(SearchSSNHub.HUB_SEARCH_RESULT_CONST_PATH);
        	for(int row = 1; row<=count; row++){
        		sleep(2000);
        		String hubResultPathRow = SearchSSNHub.HUB_SEARCH_RESULT_CONST_PATH + "[" + row + "]/td[2]";        		
        		String credit = SearchSSNHub.HUB_SEARCH_RESULT_CONST_PATH + "[" + row + "]/td[8]";
				if(getText(credit).equals("WOTC")) {        		
            	doubleClick(hubResultPathRow);
            	sleep(5000);        		
        		verifyDocuments(documents[row-1]);        		
        		sleep(5000);
        		verifySelectedDropdownValues(getExcelData().get("RECORD_STATUS_AFTER_DOC_UPLOAD"));
        		sleep(5000);
				}
        	}        	
		} catch (Exception e) {
			e.printStackTrace();
			verifyTest("Faliure in verifyHubeSearchResultDetails page",false);
		}
    }
	
	
	
	@Then("Verify docufree request in hub")
	public void verifyDocufreeRequestInHub() {
		try {
			System.out.println(getExcelData().get("DOCUFREE_REQ_DOCS_STATUS"));
			String[] documentsReqStatus = getExcelData().get("DOCUFREE_REQ_DOCS_STATUS").split("#");
			int count = getCount(EditPersonalInfo.DOCUFREE_TABLE_CONST);
			for (int row = 1; row <= count; row++) {
				String docufreeColumn = EditPersonalInfo.DOCUFREE_TABLE_CONST + "[" + row + "]/td";
				int colCount = getCount(docufreeColumn);
				for (int col = 1; col <= colCount; col++) {
					String docufreeColumnValue = docufreeColumn + "[" + col + "]";
					switch (col) {
					case 1:
						if (!getText(docufreeColumnValue).equals(currentdate())) {
							verifyTest("Received Date is not matched", false);
						}
						break;						
					case 2:
						if (!getScenarioName().contains("Docufree")) {
							if (!getText(docufreeColumnValue).equals(currentdate())) {
								verifyTest("Matched Date is not matched", false);
							}
						}
						break;
					case 3:						
						if (!getText(docufreeColumnValue).equals(unqiueIds.get(row - 1))) {						
							verifyTest("Unique ID is not matched", false);
						}
						break;
					case 4:					
						if (!getText(docufreeColumnValue).equals(getExcelData().get("IMAGE_PATH"))) {
							verifyTest("Image is not matched", false);
						}
						break;
					case 5:						
						if (!getText(docufreeColumnValue).trim().equals(documentsReqStatus[row - 1])) {
							verifyTest("Documents is not matched", false);
						}
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			verifyTest("Faliure in verifyDocufreeRequestInHub page",false);
		}finally {
			unqiueIds.clear();
		}
	}
	
	@When("User navigate to back office operation")
    public void navigateBackOffice() throws InterruptedException {
		search.navigateBackOffice();
    }
}
