package adp.tcs.automation.stepsfiles;

import adp.tcs.automation.utilities.ExcelReaderWriter;
import adp.tcs.automation.utilities.ServiceCallResponse;
import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;

/**
 * Created by Thorasa on 8/4/2016.
 */
public class XmlInRestSteps extends BaseTempletSteps{
	
	private final ServiceCallResponse callResponse = new ServiceCallResponse();
	private final XmlInRequests inRequests = new XmlInRequests();
	private ExcelReaderWriter excelReaderWriter = new ExcelReaderWriter();
	private CallInXMLrequest callinXML = new CallInXMLrequest();
    private String requestMethodType = "POST";
    private String requestContentType = "application/xml";
    private String responseContentType = "";
    //private String getExcelData().get("COOKIES") = getExcelData().get("COOKIES");
    //private String requestToCall = null;
    private String response = null;
    

    XmlInRequests xmlInRequests = new XmlInRequests();
    
    
    public void firstXmlInRequest() {
    	try {
			response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.firstXmlRequest());       
			inRequests.setScreeningIds(getTagValue(response, "/interaction/@id"));
			inRequests.setiCodeIds(getTagValue(response, "/interaction/@icode"));
		} catch (Exception e) {
			verifyTest("Faliure in firstXmlInRequest ",false);
			e.printStackTrace();
		}        
    }
    
    public void personalInfoXmlInRequest() {
    	try {
			response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.personalInfoXmlRequest());
		} catch (Exception e) {
			verifyTest("Faliure in personalInfoXmlInRequest ",false);
			e.printStackTrace();
		}
    }
    
    public void welcomeXmlInRequest() {
    	try {
			response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.welcomeScreeningXmlRequest());
		} catch (Exception e) {
			verifyTest("Faliure in welcomeXmlInRequest ",false);
			e.printStackTrace();
		}
    }
    
    public void ageVerificationXmlInRequest() {
    	try {
			if(getExcelData().get("AGE").equals("YES")) {
				response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.ageVerificationQueScreeningXmlRequest());
				response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.ageVerificationDateInputScreeningXmlRequest());
				}else {
					response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.ageVerificationQueScreeningXmlRequest());
				}
		} catch (Exception e) {
			verifyTest("Faliure in ageVerificationXmlInRequest ",false);
			e.printStackTrace();
		}
    }
    
    public void previousEmpXmlInRequest() {
    	try {
			response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.prevEmploymentScreeningXmlRequest());
		} catch (Exception e) {
			verifyTest("Faliure in previousEmpXmlInRequest ",false);
			e.printStackTrace();
		}
    }
    
    public void conditionalCertXmlInRequest() {
    	try {
			response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.condCertificateScreeningXmlRequest());
		} catch (Exception e) {
			verifyTest("Faliure in conditionalCertXmlInRequest ",false);
			e.printStackTrace();
		}
    }
    
    public void militaryServiceXmlInRequest() {
    	try {
			response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.militrySerQue1ScreeningXmlRequest());
			response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.militrySerQue2ScreeningXmlRequest());
			response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.militrySerQue3ScreeningXmlRequest());
			response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.militrySerQue4ScreeningXmlRequest());
			response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.militrySerFieldsScreeningXmlRequest());
			response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.veteran_Unemployment6_TextXmlRequest());
			//response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.veteran_Discharged_Released());
    	} catch (Exception e) {
			verifyTest("Faliure in veternFoodStampsXmlInRequest ",false);
			e.printStackTrace();
		}
    }
    
    public void veternFoodStampsXmlInRequest() {
    	try {
			response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.verternQue1ScreeningXmlRequest());
			response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.verternFieldsScreeningXmlRequest());
		} catch (Exception e) {
			verifyTest("Faliure in veternFoodStampsXmlInRequest ",false);
			e.printStackTrace();
		}
    }

    
    public void temporaryAssistanceXmlInRequest() {
    	try {
			response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.tanfQuesScreeningXmlRequest());
			response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.tanfFieldsScreeningXmlRequest());
		} catch (Exception e) {
			verifyTest("Faliure in temporaryAssistanceXmlInRequest ",false);
			e.printStackTrace();
		}
    }

    public void felonyXmlInRequest() {
    	try {
			response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.felonyQuesScreeningXmlRequest());
		} catch (Exception e) {
			verifyTest("Faliure in felonyXmlInRequest ",false);
			e.printStackTrace();
		}
    }
    
    public void vocationalRehabXmlInRequest() {
    	try {
			response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.vocationalRehabScreeningXmlRequest());
		} catch (Exception e) {
			verifyTest("Faliure in vocationalRehabXmlInRequest ",false);
			e.printStackTrace();
		}
    }
    
    public void ssiXmlInRequest() {
    	try {
			response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.ssiScreeningXmlRequest());
		} catch (Exception e) {
			verifyTest("Faliure in ssiXmlInRequest ",false);
			e.printStackTrace();
		}
    }
    
    public void foodStampXmlInRequest() {
    	try {
			if(getExcelData().get("FOOD_STAMPS_QUE").equals("YES")) {
				response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.foodStampsScreeningXmlRequest());
				response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.foodStampsFieldsScreeningXmlRequest());
			    
			}else{
				response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.foodStampsScreeningXmlRequest());
			}
		} catch (Exception e) {
			verifyTest("Faliure in foodStampXmlInRequest ",false);
			e.printStackTrace();
		}   
    }
    
    public void longTermUnemplymentXmlInRequest() {
    	try {
			if(getExcelData().get("LONG_TERM_UNEMP_QUE_1").equals("YES")) {
				response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.longTermUnEmpQue1ScreeningXmlRequest());

			        if(getExcelData().get("LONG_TERM_UNEMP_QUE_2").equals("YES")){
			        	response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.longTermUnEmpQue2ScreeningXmlRequest());
			        	response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.longTermUnEmpQue2FieldsScreeningXmlRequest());
			        	response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.LongTermUnemployedStartDateXmlInRequest());
			        	//response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.longTermUnEmpQue2FieldsScreeningXmlRequest());
			        }else{
			        	response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.longTermUnEmpQue2ScreeningXmlRequest());
			        }
			}else{
				response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.longTermUnEmpQue1ScreeningXmlRequest());
			}
		} catch (Exception e) {
			verifyTest("Faliure in longTermUnemplymentXmlInRequest ",false);
			e.printStackTrace();
		}  
    }
    
    public void eSignXmlInRequest() {
    	try {
			response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.eSignFieldsScreeningXmlRequest());
			
    	} catch (Exception e) {
			verifyTest("Faliure in eSignXmlInRequest ",false);
			e.printStackTrace();
		}
    }
    
    public void cogratulationXmlInRequest() {
    	try {
			response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.congratulationsScreeningXmlRequest());
		} catch (Exception e) {
			verifyTest("Faliure in cogratulationXmlInRequest ",false);
			e.printStackTrace();
		}
    }
    
    public void ssdiXmlInRequest() {
    	try {
			response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.ssdiScreeningXmlRequest());
		} catch (Exception e) {
			verifyTest("Faliure in ssdiXmlInRequest ",false);
			e.printStackTrace();
		}
    }
    
    public void SC_FIP_TANF_SouthCarolinaXmlRequest() {
    	try {
			response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.SC_FIP_TANF_SouthCarolinaXmlRequest());
		} catch (Exception e) {
			verifyTest("Faliure in SC_FIP_TANF_SouthCarolinaXmlRequest ",false);
			e.printStackTrace();
		}
    }

    public void unitXmlRequest() {
        try {
			response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.unitScreeningXmlRequest());
		} catch (Exception e) {
			verifyTest("Faliure in unitXmlRequest ",false);
			e.printStackTrace();
		}

    }

    public void philVeteranXmlRequest() {
        try {
			response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.philVeteranXmlRequest());
		} catch (Exception e) {
			verifyTest("Faliure in philVeteranXmlRequest ",false);
			e.printStackTrace();
		}

    }


    public void phil_VeteranXmlRequest() {
        try {
			response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.Phil_Veeran_XmlRequest());
		} catch (Exception e) {
			verifyTest("Faliure in phil_VeteranXmlRequest",false);
			e.printStackTrace();
		}

    }


	public void callInScreeningIVRcall() {
		try {
			response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), callinXML.callInScreeningXmlRequest());
			System.out.println("response for Request : " +response);
		} catch (Exception e) {
			System.out.println("response for Request : " +response);
			verifyTest("Faliure in callInScreeningIVRcall ",false);
			e.printStackTrace();
		}
	}


    public void WOTCeSign_8850_esigndisclaimer() {
        try {
			response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.WOTCeSign_8850_esigndisclaimer());
			//response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.NYVETC_Veteran());
		} catch (Exception e) {
			verifyTest("Faliure in WOTCeSign_8850_esigndisclaimer",false);
			e.printStackTrace();
		}

    }
    
   public void NYVETC_Veteran() {
        try {
        	response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.NYVETC_Veteran());
        	response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.NYVETC_Veteran_Discharged());
        	response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.NYVETC_Veteran_Discharged_Honor());
        	response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.NYVETC_Veteran_employed());
		} catch (Exception e) {
			verifyTest("Faliure in WOTCeSign_8850_esigndisclaimer",false);
			e.printStackTrace();
		}

    }
   
   public void HouseholdMember() {
       try {
       	response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.HouseholdMember());
      	response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.HouseholdIncome());
       	response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.MedAgeRange());
       //	response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.NYVETC_Veteran_employed());
		} catch (Exception e) {
			verifyTest("Faliure in WOTCeSign_8850_esigndisclaimer",false);
			e.printStackTrace();
		}

   }
   
   public void NYMW_Student() {
		try {
			response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.NYMW_Student());
		} catch (Exception e) {
			verifyTest("Faliure in MD_Rehire_Request",false);
			e.printStackTrace();
		}

	}

	public void MD_Rehire_Request() {
		try {
			response = callResponse.getResponse(getExcelData().get("REST_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.MD_Rehire_Request());
		} catch (Exception e) {
			verifyTest("Faliure in MD_Rehire_Request",false);
			e.printStackTrace();
		}

	}



	@Given("User perform screening test for Xml In")
    public void xmlInAPI() {
		try {
			boolean flag = false;
			boolean noMethodFlag = false;

			firstXmlInRequest();

			while (true) {
				String requestToCall = null;

				requestToCall = getTagValue(response, "/interaction/step[1]/stepinf[1]/@id");

				System.out.println("Screening started for -------------------------------" + requestToCall);
				switch (requestToCall) {

					case "SSN":
						personalInfoXmlInRequest();
						break;
					case "Welcome1":
						welcomeXmlInRequest();
						break;
					case "AgeCheck":
						ageVerificationXmlInRequest();
						break;
					case "PreviousEmployed":
						previousEmpXmlInRequest();
						break;

					case "CCWOTC":
						conditionalCertXmlInRequest();
						break;

					case "Veteran":
						militaryServiceXmlInRequest();
						break;

					case "Veteran_Food_Stamps":
						veternFoodStampsXmlInRequest();
						break;

					case "TANF_WOTC2Years":
						temporaryAssistanceXmlInRequest();
						break;

					case "Felony_General":
						felonyXmlInRequest();
						break;

					case "ID_VocationalRehab_VocRehab":
						vocationalRehabXmlInRequest();
						break;

					case "SSI":
						ssiXmlInRequest();
						break;

					case "FoodStamps6":
						foodStampXmlInRequest();
						break;

					case "LongTermUnemployed_Period":
						longTermUnemplymentXmlInRequest();
						break;

					case "WOTC_esign_Review_Text":
						eSignXmlInRequest();
						break;

					case "Confidentiality":
						cogratulationXmlInRequest();
						flag = true;
						break;

					case "SSDInsurance":
						ssdiXmlInRequest();
						break;

					case "SC_FIP_TANF_SouthCarolina":
						SC_FIP_TANF_SouthCarolinaXmlRequest();
						break;
					case "Unit":
						unitXmlRequest();
						//flag = true;
						break;
					case "Phil_Veteran":
						philVeteranXmlRequest();
						//  flag = true;
						break;

					case "WOTCeSign_8850_esigndisclaimer":
						WOTCeSign_8850_esigndisclaimer();
						//  flag = true;
						break;
					case "NYVETC_Veteran":
						NYVETC_Veteran();
						//  flag = true;
						break;						
						
					case "HouseholdMember":
						HouseholdMember();
						//  flag = true;
						break;
						
					case "NYMW_Student":
						NYMW_Student();
						//  flag = true;
						break;
						
					case "MDEOC_Rehire":
						MD_Rehire_Request();
						break;				
			
                /*        
                 case "LongTermUnemployed_StartDate":
                        LongTermUnemployedStartDateXmlInRequest();
                        break;
*/
						
					default:
						noMethodFlag = true;
						break;
				}

				System.out.println("Screening complted for -------------------------------" + requestToCall);
				if (flag == true) {
					System.out.println("Screening is completed!!! " + getExcelData().get("SSN"));
					excelReaderWriter.writeSSNAndConfirmationNumber();
					break;
				}
				if (noMethodFlag == true) {
					System.out.println("Screening method for this request is not developed!!!");
					verifyTest("Screening method for this request is not developed!!!", false);
					break;
				}

			}
			verifyTest("User perform screening test for Xml In");
		} catch (Exception e) {
			verifyTest("User perform screening test for Xml In", false);
			e.printStackTrace();
		}


		}


		@Given("Manager hire through rest API")
		@Aliases(values={"Hire through rest API","Hire Using REST API"})
		public void managerAPIHire() {
			try {
				verifyTest("Manager hire through rest API");
				sleep(5000);
				String hireResponse = callResponse.getResponse(getExcelData().get("HIRE_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.managerHireAPIXmlRequest());
				String confNumber = getTagValue(hireResponse, "/hired/@confnumber");
				String formAttributeCheck = getTagValue(hireResponse, "/hired/@forms");

				if (confNumber == null && formAttributeCheck == null) {
					verifyTest("Exception in hired response", false);
				} else {
					getExcelData().put("Confirmation_Number", confNumber);
					excelReaderWriter.writeSSNAndConfirmationNumber();

				}
			} catch (Exception e) {				
				e.printStackTrace();
				verifyTest("Manager hire through rest API", false);
			}
		}   
		
		
		@Given("hire through XML rest API for Retro")
		public void hireWithXMLAPIRetro() {
			try {
				verifyTest("Manager hire through rest API");
				sleep(5000);
				String hireResponse = callResponse.getResponse(getExcelData().get("HIRE_URL"), requestMethodType, requestContentType, responseContentType, getExcelData().get("COOKIES"), xmlInRequests.managerHireAPIXmlRequestRetro());
				String confNumber = getTagValue(hireResponse, "/hired/@confnumber");
				//String formAttributeCheck = getTagValue(hireResponse, "/hired/@forms");
				String hiredTagCheck = getTagValue(hireResponse, "/hired/credits");
				
				
				if (hiredTagCheck == " " || hiredTagCheck != null){
					if (confNumber != null) {
						getExcelData().put("Confirmation_Number", confNumber);
						excelReaderWriter.writeSSNAndConfirmationNumber();
					}
				}else{
					verifyTest("Exception in hired response", false);
				}
			} catch (Exception e) {
				verifyTest("Manager hire through rest API", false);
				e.printStackTrace();
			}
		}   
		

}
