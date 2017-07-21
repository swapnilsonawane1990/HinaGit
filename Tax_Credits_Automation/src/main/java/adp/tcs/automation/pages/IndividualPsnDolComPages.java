package adp.tcs.automation.pages;

import adp.tcs.automation.locators.IndividualPsnDolCom;
import adp.tcs.automation.locators.MassProcessHub;
import adp.tcs.automation.stepsfiles.BaseTempletSteps;
import adp.tcs.automation.stepsfiles.Manager_Hire_Steps;
import adp.tcs.automation.utilities.WndowAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bhutesac on 9/28/2016.
 */
public class IndividualPsnDolComPages  extends BaseTempletSteps {

    private WebElement element = null;
    private WndowAction windowAct = new WndowAction();
    private MassProcessingPage massProcessing = new MassProcessingPage();
    private Dol_generate dolgenerate = new Dol_generate();
    private Manager_Hire_Steps mangr_Hire = new Manager_Hire_Steps();
    public String fromDate;
    public String todate;
    public String hireDt;
    public String workSrtDate;
    public String workEdDate;
    DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmssZ");
    Date date = new Date();
    MassProcessingPage massProcessingPage = new MassProcessingPage();
    
    public WebElement psn_Update_Sub_Menu_Tab(){

        this.element = this.getDriver().findElement(IndividualPsnDolCom.PSN_UPDATE_SUB_MENU);
        return this.element;
    }
    public WebElement psn_Update_Number_Of_Records_Textbox(){

        this.element = this.getDriver().findElement(IndividualPsnDolCom.PSN_UPDATE_NUMBER_OF_RECORDS_TOPROCEED_TEXTBOX);
        return this.element;
    }

    public WebElement Dol_Form_Number_Of_Records_Textbox(){

        this.element = this.getDriver().findElement(IndividualPsnDolCom.DOL_FORM_NUMBER_OF_RECORDS_TEXTBOX);
        return this.element;
    }
    public WebElement dol_Form_Com_Form_PDF_Link_Textbox(){

        this.element = this.getDriver().findElement(IndividualPsnDolCom.DOL_FORM_COM_FORM_PDF_REPORT);
        return this.element;
    }

    public WebElement genarate_DOL_SubMenu_Textbox(){

        this.element = this.getDriver().findElement(IndividualPsnDolCom.GENERATE_DOL_SUB_MENU);
        return this.element;
    }
    public WebElement generate_COM_Sub_Menu_Textbox(){

        this.element = this.getDriver().findElement(IndividualPsnDolCom.GENERATE_COM_SUB_MENU);
        return this.element;
    }


    public void indivitualPSN(String numberOfRecords) throws Exception
    {
        String currentDate = dateFormat.format(date);
        String currentDt = currentDate.substring(4,6);
        sleep(3000);
       /* Actions builder = new Actions(this.getDriver());
        // move the mouse to the earlier identified menu option
        builder.moveToElement(massProcessing.operations_Tab()).build().perform();
        this.sleep(2000);
        psn_Update_Sub_Menu_Tab().click();*/
        massProcessing.operations_Tab().click();
        sleep(2000);
        psn_Update_Sub_Menu_Tab().click();
        sleep(2000);
        if(!isDisplayed(massProcessing.operations_Esign_Mass_Print_SSN_field())){
            for(int i = 1; i <= 10; i++){
                massProcessing.operations_Tab().click();
                sleep(2000);
                psn_Update_Sub_Menu_Tab().click();
                sleep(2000);
                if(isDisplayed(massProcessing.operations_Esign_Mass_Print_SSN_field())){
                    break;
                }
            }
        }
        sleep(2000);
        massProcessing.operations_Esign_Mass_Print_SSN_field().sendKeys(getExcelData().get("SSN"));
        System.out.println("Maas Processing for SSN is in Progress : " + getExcelData().get("SSN"));
        sleep(2000);
        massProcessing.operations_Esign_Mass_Count_Button().click();
        sleep(5000);
        waitForLoad();
        dolgenerate.edit_PSN_DOL_COM_Combo_Page_PSN_Date_On_Hub().click();
        sleep(2000);
        mangr_Hire.selectDateCurrentMonth(currentDt);
        sleep(2000);
        psn_Update_Number_Of_Records_Textbox().sendKeys(numberOfRecords);
        massProcessing.operations_Esign_Mass_Print_Update_Button().click();
        sleep(20000);
        massProcessing.operations_Esign_Mass_Print_Request().click();
        sleep(2000);
        massProcessing.operations_Esign_Mass_Print_Action_Download().click();
        sleep(2000);
        dolgenerate.click_PSN_DOL_COM_Combo_Page_Download_PSN_XLS_Report_Link_On_Hub().click();
        Thread.sleep(5000);
        if(!isDisplayed(MassProcessHub.POPOVER_POPUP)){
        	massProcessing.operations_Esign_Mass_Print_Action_Download().click();
        }
        dolgenerate.click_PSN_DOL_COM_Combo_Page_Download_PSN_PDF_Report_Link_On_Hub().click();
        Thread.sleep(5000);
        if(!isDisplayed(MassProcessHub.POPOVER_POPUP)){
        	massProcessing.operations_Esign_Mass_Print_Action_Download().click();
        }
        dolgenerate.click_PSN_DOL_COM_Combo_Page_Download_Free_State_PDF_Report_Link_On_Hub().click();
        Thread.sleep(5000);
        massProcessingPage.operations_Esign_Mass_Print_PopUp_Close().click();
        
    }

    public void indivitualDol(String numberOfRecords) throws Exception
    {
        String currentDate = dateFormat.format(date);
        String currentDt = currentDate.substring(4,6);
        sleep(2000);
        /*Actions builder = new Actions(this.getDriver());
        // move the mouse to the earlier identified menu option
        builder.moveToElement(massProcessing.operations_Tab()).build().perform();
        this.sleep(2000);
        genarate_DOL_SubMenu_Textbox().click();*/
        massProcessing.operations_Tab().click();
        sleep(2000);
        genarate_DOL_SubMenu_Textbox().click();
        sleep(2000);
        if(!isDisplayed(massProcessing.operations_Esign_Mass_Print_SSN_field())){
            for(int i = 1; i <= 10; i++){
                massProcessing.operations_Tab().click();
                sleep(2000);
                genarate_DOL_SubMenu_Textbox().click();
                sleep(2000);
                if(isDisplayed(massProcessing.operations_Esign_Mass_Print_SSN_field())){
                    break;
                }
            }
        }
        sleep(2000);
        massProcessing.operations_Esign_Mass_Print_SSN_field().sendKeys(getExcelData().get("SSN"));
        System.out.println("Maas Processing for SSN is in Progress : " + getExcelData().get("SSN"));
        sleep(2000);
        massProcessing.operations_Esign_Mass_Count_Button().click();
        sleep(5000);
        waitForLoad();
        dolgenerate.edit_PSN_DOL_COM_Combo_Page_DOL_FORM_DATE_On_Hub().click();
        sleep(2000);
        mangr_Hire.selectDateCurrentMonth(currentDt);
        sleep(1000);
        Dol_Form_Number_Of_Records_Textbox().sendKeys(numberOfRecords);
        massProcessing.operations_Esign_Mass_Print_Update_Button().click();
        sleep(20000);
        massProcessing.operations_Esign_Mass_Print_Request().click();
        sleep(2000);
        massProcessing.operations_Esign_Mass_Print_Action_Download().click();
        sleep(2000);
        massProcessing.operations_Esign_Mass_Print_Download_Zip_File_SINGLE().click();
        sleep(5000);
        massProcessingPage.operations_Esign_Mass_Print_PopUp_Close().click();
    }

    public void indivitualCom(String numberOfRecords) throws Exception
    {
    	String currentDate = dateFormat.format(date);
        String currentDt = currentDate.substring(4,6);
        sleep(2000);
       /* Actions builder = new Actions(this.getDriver());
        // move the mouse to the earlier identified menu option
        builder.moveToElement(massProcessing.operations_Tab()).build().perform();
        sleep(2000);
        generate_COM_Sub_Menu_Textbox().click();*/
        massProcessing.operations_Tab().click();
        sleep(2000);
        generate_COM_Sub_Menu_Textbox().click();
        sleep(2000);
        if(!isDisplayed(massProcessing.operations_Esign_Mass_Print_SSN_field())){
            for(int i = 1; i <= 10; i++){
                massProcessing.operations_Tab().click();
                sleep(2000);
                generate_COM_Sub_Menu_Textbox().click();
                sleep(2000);
                if(isDisplayed(massProcessing.operations_Esign_Mass_Print_SSN_field())){
                    break;
                }
            }
        }
        sleep(2000);
        massProcessing.operations_Esign_Mass_Print_SSN_field().sendKeys(getExcelData().get("SSN"));
        System.out.println("Maas Processing for SSN is in Progress : " + getExcelData().get("SSN"));
        sleep(2000);
        massProcessing.operations_Esign_Mass_Count_Button().click();
        sleep(5000);
        waitForLoad();
        //dolgenerate.edit_PSN_DOL_COM_Combo_Page_DOL_FORM_DATE_On_Hub().click();
        //sleep(2000);
        //mangr_Hire.selectDateCurrentMonth(currentDt);
        //sleep(1000);
        massProcessing.operations_Esign_Mass_Number_Of_Records_Field().sendKeys(numberOfRecords);
        massProcessing.operations_Esign_Mass_Print_Update_Button().click();
        sleep(20000);
        massProcessing.operations_Esign_Mass_Print_Request().click();
        sleep(2000);
        massProcessing.operations_Esign_Mass_Print_Action_Download().click();
        sleep(2000);
        massProcessing.operations_Esign_Mass_Print_Download_Zip_File_SINGLE().click();
        sleep(5000);
        massProcessingPage.operations_Esign_Mass_Print_PopUp_Close().click();
    }

}
