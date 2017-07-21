package adp.tcs.automation.stepsfiles;

import adp.tcs.automation.locators.ScreeningLocators;
import adp.tcs.automation.pages.CallInScreeningPages;
import adp.tcs.automation.pages.ScreeningPages;
import adp.tcs.automation.pages.SearchSSNthroughHub;
import adp.tcs.automation.utilities.ExcelReaderWriter;
import adp.tcs.automation.utilities.UserAction;
import adp.tcs.automation.utilities.WndowAction;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;

/**
 * Created by bhutesac on 9/30/2016.
 */
public class CallInScreening_Steps extends BaseTempletSteps{


    private ExcelReaderWriter excelReaderWriter = new ExcelReaderWriter();
    private ScreeningLocators screeningLoc = new ScreeningLocators();
    private CallInScreeningPages callinPage = new CallInScreeningPages();
    private ScreeningPages screeningPage = new ScreeningPages();
    private XmlInRestSteps callInScren = new XmlInRestSteps();
    private UserAction userAct = new UserAction();
    private ScreeningSteps screeningSTP = new ScreeningSteps();
    private SearchSSNthroughHub searchSSN = new SearchSSNthroughHub();
    private HubValidationsSteps hubValid = new HubValidationsSteps();
    private String SSN = null;
    WndowAction windows = new WndowAction();
    @Given("User Post the call In Request")
    public void callInxmlRequest(){
        callInScren.callInScreeningIVRcall();
    }

    @Given("User Perform Call In Screening for Company <companyName>")
    public void callInScreening(@Named("companyName") String companyName) {
        try{
            boolean flag = false;
            boolean noMethodFlag = false;
         //   callInScren.callInScreeningIVRcall();
            callinPage.callInManualStart();

          //  callin.callInScreeningStart();
            userAct.switchToFrame("call_in_screening");
            while (true) {
                String pageToCall = null;
                waitForLoad();
              //  explicitWaitForElementDisappears(screeningLoc.CONTINUE_BUTTON_LOADING, 30);
                sleep(2000);

//                if(!callin.callIn_CALL_UNIT_PERSONAL_INFO_TITLE().isDisplayed()){
//                    pageToCall = screeningPage.screeningPageTitle().getText();
//                }else{
//                    pageToCall = callin.callIn_CALL_UNIT_PERSONAL_INFO_TITLE().getText();
//                }
//                sleep(1000);
               // userAct.switchToFrame("call_in_screening");
               pageToCall = screeningPage.screeningPageTitle().getText();
                System.out.println("Screening started for "+ pageToCall);

                switch (pageToCall) {
                    case "Welcome":
                     //   callin.personalinforCallIn();

                        break;
                    case "Personal Info":
                        callinPage.personalinforCallIn();

                        break;
                    case "Age Verification":
                      //  performAgeVerificationPageActions();

                        break;
                    case "Previous Employment":
                        callinPage.callInpreviousEmployment();

                        break;
                    case "Conditional Certification":
                      //  performConditionalCertPageActions();

                        break;
                    case "Military Service":
                        screeningSTP.performMilitaryServicePageActions();

                        break;
                    case "Veteran Food Stamps":
                      //  performVeternFoodStampsPageActions();
                        callinPage.performVeternFoodStampsPage();
                        break;
                    case "Temporary Assistance":
                        callinPage.callInperformTemporaryAssistancePageActions();

                        break;
                    case "Vocational Rehabilitation":
                        callinPage.callInVocationalPage();

                        break;
                    case "Supplemental Security Income":
                        callinPage.callInperformSSIPage();

                        break;
                    case "Food Stamps":
                       // performFoodStampsPageActions();
                        callinPage.performFoodStampsPage();
                        break;
                    case "Long Term Unemployed":
                        callinPage.performLongTermUnemplymentPageActions();

                        break;
                    case "Esign":
                        callinPage.callInEsign();

                        break;
                    case "IEC":
                        callinPage.callInIEC();

                        break;
                    case "IEC (SP)":
                        screeningSTP.performIECSPPageActions();

                        break;
                    case "Upload Documents":
                      //  performFileUploadPageActions();

                        flag = true;
                        break;
                    case "Please provide your prospective worksite location:":
                     //   performUnitPageActions();

                        break;
                    case "Felony":
                        callinPage.callInFelonyPage();

                        break;
                    case "Pennsylvania EIP":
                        //Pennsylvania page
                        callinPage.callInPennsylvaniaEIP();

                        break;
                    case "SSDI":
                        screeningSTP.performSSDIPageActions();

                        break;
                    case "Philadelphia Military Service":
                        screeningSTP.philadelphiaMServicePageActions();
                        break;

                    case "CA Military Service":
                        callinPage.callInCAMilitary();

                        break;

                    case "CA Earned Income Credit":
                        callinPage.callInCAEarnIncome();

                        break;
                    case "CA Felony":
                        callinPage.callInCAFelony();

                        break;
                    case "CA General Assistance":
                        callinPage.callInCAGeneralAssistance();

                        break;
                    case "CA Unemployed Full Time Student":
                        callinPage.callInCAUnemployedFullTimeStudent();

                        break;
                    case "Address":
                        callinPage.callInAdress();

                        break;
                    case "Instructions":
                        callinPage.callInInstruction();

                        break;
                    case "Hire Information":
                        callinPage.performHireInfomationPageActions();

                        break;

                    default:
                    		String pageSource = getDriver().getPageSource();
                        if (pageSource.contains("Thank you") || pageSource.contains("Confirmation Number") || pageSource.contains("Screening Completed")|| pageSource.contains("Thank You")) {
                            flag = true;
                            getDriver().switchTo().defaultContent();
                            callinPage.callIn_Exit_Button().click();
                            sleep(5000);
                            System.out.println("Screening complted for Confirmation Page");
                            searchSSN.search_SSN_Home_Menu().click();
                            sleep(2000);
                        }else{
                            getDriver().switchTo().defaultContent();

                            callinPage.callIn_Exit_Button().click();
                            sleep(4000);
                            searchSSN.search_SSN_Home_Menu().click();
                            sleep(4000);
                            System.out.println("Page is not developed for Call In Page :- " + pageToCall);

                        }

                        break;
                   }
                
                System.out.println(" Call In Screening complted for "+ pageToCall);
                if(flag == true){
                    System.out.println(" Call In Screening is completed!!!  With SSN : " + getExcelData().get("SSN"));
                    break;
                }
                if(noMethodFlag == true){
                    verifyTest("Expected page method is not developed",false);
                    break;
                }
            }
            verifyTest("User Perform Call In Screening for Company <companyName>");
          //  windows.switchtoChildWindowReturnParent();
        }catch(Exception e){
            verifyTest("Faliure in Screening",false);
            System.out.println(e);
        }
    }

}
