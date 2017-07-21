package adp.tcs.automation.pages;

import adp.tcs.automation.locators.MassProcessing;
import adp.tcs.automation.stepsfiles.BaseTempletSteps;
import adp.tcs.automation.utilities.UserAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by BhuteSac on 7/25/2016.
 */
public class MassProcessingPage extends BaseTempletSteps {

	private WebElement element;
	EditPersonalInformation editPerInfor = new EditPersonalInformation();
	SearchSSNthroughHub searchSSNumber = new SearchSSNthroughHub();
	UserAction userAct = new UserAction();
	String workSrtDate;
	String workSrtToDate;

	public WebElement operations_Tab() {

		this.element = this.getDriver().findElement(MassProcessing.OPERATION_TAB);
		return this.element;
	}

	public WebElement operations_Esign_Mass_Print_Queue_Tab() {

		this.element = this.getDriver().findElement(MassProcessing.OPERATION_ESIGN_MASS_PRINT_QUEUE_TAB);
		return this.element;
	}

	public WebElement operations_Esign_Mass_Print_Start_From_Date_field() {

		this.element = this.getDriver().findElement(MassProcessing.ESIGN_MASS_PRINT_START_FROM_DATE_FIELD);
		return this.element;
	}

	public WebElement operations_Esign_Mass_Print_Start_To_Date_field() {

		this.element = this.getDriver().findElement(MassProcessing.ESIGN_MASS_PRINT_START_TO_DATE_FIELD);
		return this.element;
	}

	public WebElement operations_Esign_Mass_Print_SSN_field() {

		this.element = this.getDriver().findElement(MassProcessing.ESIGN_MASS_PRINT_SSN_FIELD);
		return this.element;
	}

	public WebElement operations_Esign_Mass_Print_Client_ID_field() {

		this.element = this.getDriver().findElement(MassProcessing.ESIGN_MASS_PRINT_CLIENT_ID_FIELD);
		return this.element;
	}

	public WebElement operations_Esign_Mass_Print_Company_ID_field() {

		this.element = this.getDriver().findElement(MassProcessing.ESIGN_MASS_PRINT_COMPANY_ID_FIELD);
		return this.element;
	}

	public WebElement operations_Esign_Mass_Print_State_Dropdown() {

		this.element = this.getDriver().findElement(MassProcessing.ESIGN_MASS_PRINT_STATE_FIELD);
		return this.element;
	}

	public WebElement operations_Esign_Mass_Count_Button() {

		this.element = this.getDriver().findElement(MassProcessing.ESIGN_MASS_PRINT_COUNT_BUTTON);
		return this.element;
	}

	public WebElement operations_Esign_Mass_Number_Of_Records_Field() {

		this.element = this.getDriver().findElement(MassProcessing.ESIGN_MASS_PRINT_NUMBER_OF_RECORDS_PROCEED_FIELD);
		return this.element;
	}

	public WebElement operations_Esign_Mass_Print_Request() {

		this.element = this.getDriver().findElement(MassProcessing.ESIGN_MASS_PRINT_REQUEST_ID_LINK);
		return this.element;
	}

	public WebElement operations_Esign_Mass_Print_Update_Button() {

		this.element = this.getDriver().findElement(MassProcessing.ESIGN_MASS_PRINT_UPDATE_BUTTON);
		return this.element;
	}

	public WebElement operations_Esign_Mass_Print_Action_Download() {

		this.element = this.getDriver().findElement(MassProcessing.ESIGN_MASS_PRINT_ACTION_DOWNLOAD);
		return this.element;
	}

	public WebElement operations_Esign_Mass_Print_Download_Zip_File() {

		this.element = this.getDriver().findElement(MassProcessing.ESIGN_MASS_PRINT_ACTION_DOWNLOAD_ZIP_FILE);
		return this.element;
	}
	public WebElement operations_Esign_Mass_Print_Download_Zip_File_SINGLE() {

		this.element = this.getDriver().findElement(MassProcessing.ESIGN_MASS_PRINT_ACTION_DOWNLOAD_ZIP_FILE_SINGLE);
		return this.element;
	}
	  
	public WebElement operations_Esign_Mass_Print_PopUp_Close(){

	        this.element = this.getDriver().findElement(MassProcessing.ESIGN_MASS_PRINT_PROCESS_REQUEST_POPUP_CLOSE);
	        return this.element;
	    } 
	
	
	public void EsignMassWithSpecifiedDate(String numberOfRecords) throws Exception {		

		//Actions builder = new Actions(this.getDriver());

		// move the mouse to the earlier identified menu option
		//Thread.sleep(2000);
//		javaScriptClick(this.operations_Tab());
		//Thread.sleep(2000);
//		javaScriptClick(this.operations_Esign_Mass_Print_Queue_Tab());
		Thread.sleep(3000);
		/*builder.moveToElement(this.operations_Tab()).build().perform();
		this.sleep(2000);
//		//
		this.operations_Esign_Mass_Print_Queue_Tab().click();		
		
				
		
		Thread.sleep(5000);
		actionClick(operations_Tab(),operations_Esign_Mass_Print_Queue_Tab());*/
		
	//  WebElement mainMenu = driver.findElement(By.linkText("MainMenu"));

		//builder.moveToElement(this.operations_Tab()).moveToElement(operations_Esign_Mass_Print_Queue_Tab()).click().build().perform();


		operations_Tab().click();
		sleep(2000);
		operations_Esign_Mass_Print_Queue_Tab().click();
		sleep(5000);
		if (!isDisplayed(operations_Esign_Mass_Print_SSN_field())) {
			for (int i = 1; i <= 20; i++) {
				operations_Tab().click();
				sleep(2000);
				operations_Esign_Mass_Print_Queue_Tab().click();
				sleep(2000);
				if (isDisplayed(operations_Esign_Mass_Print_SSN_field())) {
					break;
				}
			}
		}
		sleep(5000);

		// need to integrate SSN Input

		this.operations_Esign_Mass_Print_SSN_field().sendKeys(getExcelData().get("SSN"));
		System.out.println("Maas Processing for SSN is in Progress : " + getExcelData().get("SSN"));

		//
		String strStartDate = getExcelData().get("HIRE_START_DATE");
		Thread.sleep(2000);
		operations_Esign_Mass_Print_Start_From_Date_field().click();
		// dolgenerate.edit_PSN_DOL_COM_Combo_Page_From_Start_Date_On_Hub().click();
		Thread.sleep(2000);
		selectCalenderDate(strStartDate);

		Thread.sleep(2000);

		sleep(2000);
		this.operations_Esign_Mass_Count_Button().click();
		sleep(5000);
		waitForLoad();
		this.operations_Esign_Mass_Number_Of_Records_Field().sendKeys(numberOfRecords);
		this.operations_Esign_Mass_Print_Update_Button().click();
		Thread.sleep(20000);
		this.operations_Esign_Mass_Print_Request().click();
		Thread.sleep(2000);
		this.operations_Esign_Mass_Print_Action_Download().click();
		Thread.sleep(2000);
		this.operations_Esign_Mass_Print_Download_Zip_File().click();
		Thread.sleep(5000);
		operations_Esign_Mass_Print_PopUp_Close().click();
        sleep(5000);
	}



    public void EsignMassPrint(String numberOfRecords) throws Exception
    {
        sleep(4000);
        /*userAct.doubleClick(operations_Tab());
        */
        
//        Actions builder = new Actions(this.getDriver());
//
//    	builder.moveToElement(this.operations_Tab()).build().perform();
//        this.sleep(2000);

		/*javaScriptClick(operations_Tab());
		sleep(2000);
		javaScriptClick(operations_Esign_Mass_Print_Queue_Tab());*/
//		Actions action = new Actions(driver);
//		operations_Tab().click();

//		sleep(2000);
//		operations_Esign_Mass_Print_Queue_Tab().click();*/

//		action.moveToElement(this.operations_Tab()).moveToElement(operations_Esign_Mass_Print_Queue_Tab()).click().build().perform();

		
		userClick(operations_Tab());
		sleep(3000);
		userClick(operations_Esign_Mass_Print_Queue_Tab());
		sleep(2000);
		if(!isDisplayed(operations_Esign_Mass_Print_SSN_field())){
		for(int i = 1; i <= 10; i++){
				userClick(operations_Tab());
				sleep(2000);
				userClick(operations_Esign_Mass_Print_Queue_Tab());
				sleep(2000);
				if(isDisplayed(operations_Esign_Mass_Print_SSN_field())){
					break;
				}
		}
	}

		//actionClick(operations_Tab(),operations_Esign_Mass_Print_Queue_Tab());
        //action class mouse hover

       // Actions action = new Actions(driver);
      //  WebElement mainMenu = driver.findElement(By.linkText("MainMenu"));
       // action.moveToElement(this.operations_Tab()).moveToElement(operations_Esign_Mass_Print_Queue_Tab()).click().build().perform();
    	//operations_Tab().click();
       // userAct.doubleClick(operations_Tab());
       // if(!operations_Esign_Mass_Print_Queue_Tab().isDisplayed())
       // {
       //     operations_Tab().click();
       // }
       // operations_Tab().click();
      //  Thread.sleep(1000);
       // this.operations_Esign_Mass_Print_Queue_Tab().click();
        //userAct.doubleClick(operations_Esign_Mass_Print_Queue_Tab());
        Thread.sleep(5000);
       // operations_Esign_Mass_Print_Start_From_Date_field().click();
       // calender.selectDateOnMassProcessing(startDate, "startFromDate");


        // Start date from select
//        operations_Esign_Mass_Print_Start_From_Date_field().click();
//        Thread.sleep(2000);
//        ArrayList<WebElement> fromdate = searchSSNumber.search_SSN_Screened_Date_From();
//         int dte_count = fromdate.size();
//          for(int i=0; i<dte_count;i++){
//              if(startDate.equalsIgnoreCase(fromdate.get(i).getText())){
//                  fromdate.get(i).click();
//                 workSrtDate = operations_Esign_Mass_Print_Start_From_Date_field().getAttribute("value");
//                  System.out.println("Work start Date : " + workSrtDate);
//                 break;
//             }
//          }

        //START dATE TO DATE
//        Thread.sleep(2000);
//        operations_Esign_Mass_Print_Start_To_Date_field().click();
//        Thread.sleep(1000);
//        ArrayList<WebElement> todate = searchSSNumber.search_SSN_Screened_Date_From();
//        int dte_cnt = todate.size();
//        for(int i=0; i<dte_cnt;i++){
//            if(toDate.equalsIgnoreCase(fromdate.get(i).getText())){
//                fromdate.get(i).click();
//                workSrtToDate = operations_Esign_Mass_Print_Start_From_Date_field().getAttribute("value");
//                System.out.println("Work start Date : " + workSrtToDate);
//                break;
//            }
//        }
       // calender.selectDateOnMassProcessing(toDate, "startToDate");

        //need to integrate SSN Input
        
        if (getExcelData().get("HIRE_CURRENT_DATE").equalsIgnoreCase("YES")) 
        {
        	//Calendar will have the by-default current dates 
		}
        else
        { 
        	if(getExcelData().get("HIRE_START_DATE") != ""){
        		//this.operations_Esign_Mass_Print_Start_From_Date_field().clear();
        		userClear(MassProcessing.startFromDate);       				
				selectCalenderDate(getExcelData().get("HIRE_START_DATE"));
        	}
        	
        }

        this.operations_Esign_Mass_Print_SSN_field().sendKeys(getExcelData().get("SSN"));
        System.out.println("Maas Processing for SSN is in Progress : " + getExcelData().get("SSN"));

        //Mass print Dropdown values select
       // WebElement drpvalue = operations_Esign_Mass_Print_State_Dropdown();
      //  userAct.selectDropDown(drpvalue,stateValue);
       // operations_Esign_Mass_Print_Client_ID_field().sendKeys(clientName);
       // editPerInfor.edit_Company_Select().click();
      //  operations_Esign_Mass_Print_Company_ID_field().sendKeys(companyId);
      //  editPerInfor.edit_Company_Select().click();
        sleep(2000);
        this.operations_Esign_Mass_Count_Button().click();
        sleep(10000);
        waitForLoad();
        this.operations_Esign_Mass_Number_Of_Records_Field().sendKeys(numberOfRecords);
        this.operations_Esign_Mass_Print_Update_Button().click();
        Thread.sleep(20000);
        this.operations_Esign_Mass_Print_Request().click();
        Thread.sleep(2000);
        this.operations_Esign_Mass_Print_Action_Download().click();
        Thread.sleep(2000);
        this.operations_Esign_Mass_Print_Download_Zip_File().click();
        Thread.sleep(5000);
        operations_Esign_Mass_Print_PopUp_Close().click();
        sleep(2000);

    }
}
