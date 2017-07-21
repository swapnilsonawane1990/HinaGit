package adp.tcs.automation.pages;

import adp.tcs.automation.stepsfiles.BaseTempletSteps;
import adp.tcs.automation.utilities.UserAction;
import adp.tcs.automation.utilities.WndowAction;
import adp.tcs.automation.locators.EditPersonalInfo;
import org.openqa.selenium.WebElement;

/**
 * Created by BhuteSac on 4/14/2016.
 */
public class EditPersonalInformation extends BaseTempletSteps {

    private WebElement element = null;
   
    WndowAction windowAct = new WndowAction();
    SearchSSNthroughHub searchSSNhub = new SearchSSNthroughHub();
    UserAction userAct = new UserAction();

    public WebElement edit_Personal_Info_Button(){

        element = getDriver().findElement(EditPersonalInfo.EDIT_BUTTON_ON_PERSONAL_INFO);
        return element;
    }

    public WebElement edit_First_Name_TextBox(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_FIRST_NAME_TEXTBOX);
        return element;
    }
    public WebElement edit_Middle_Name_TextBox(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_MIDDLE_NAME_TEXTBOX);
        return element;
    }
    public WebElement edit_Last_Name_TextBox(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_LAST_NAME_TEXTBOX);
        return element;
    }
    public WebElement edit_Personal_SSN_Number_TextBox(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_SSN_TEXTBOX);
        return element;
    }
    public WebElement edit_Date_Of_Birth_TextBox(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_BIRTH_DATE_TEXTBOX);
        return element;
    }public WebElement edit_Phone_Number_Box(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_PHONE_NUMBER_TEXTBOX);
        return element;
    }public WebElement edit_Email_Address_TextBox(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_EMAIL_TEXTBOX);
        return element;
    }
    public WebElement edit_Address_Line_TextBox(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_ADDRESS_LINE_TEXTBOX);
        return element;
    }
    public WebElement edit_City_TextBox(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_EMPLOYEE_CITY_TEXTBOX);
        return element;
    }
    public WebElement edit_State_Dropdown_Arrow(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_EMPLOYEE_EMPLYOEE_STATE_DROPDOWN);
        return element;
    }

    public WebElement edit_State_Dropdown_Const(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_EMPLOYEE_EMPLYOEE_STATE_DROPDOWN_ARROW);
        return element;
    }
    public WebElement edit_Country_TextBox(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_EMPLOYEE_COUNTRY_TEXTBOX);
        return element;
    }
    public WebElement edit_Zip_code_TextBox(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_EMPLOYEE_ZIPCODE_TEXTBOX);
        return element;
    }
    public WebElement edit_Company_Name_TextBox(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_EMPLOYEE_COMPANYNAME_TEXTBOX);
        return element;
    }

    public WebElement edit_Unit_TextBox(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_EMPLOYEE_UNIT_TEXTBOX);
        return element;
    }

    public WebElement edit_Zip_Code_Start_Date(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_EMPLOYEE_STARTDATE_TEXTBOX);
        return element;
    }

    public WebElement edit_Hire_Date(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_HIREDATE_TEXTBOX);
        return element;
    }


    public WebElement edit_Position_Dropdown_Arrow(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_EMPLOYEE_POSITION_DROPDOWN_ARROW);
        return element;
    }
    
    public WebElement edit_Position_Dropdown(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_EMPLOYEE_POSITION_DROPDOWN);
        return element;
    }
    
    public WebElement edit_Screenin_Method(){

        element = getDriver().findElement(EditPersonalInfo.SCREENING_METHOD);
        return element;
    }
    
    public WebElement edit_Employee_Signature(){

        element = getDriver().findElement(EditPersonalInfo.EMPL_SIGNATURE);
        return element;
    }

    public WebElement edit_Position_Dropdown_Values(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_EMPLOYEE_POSITION_DROPDOWN_CONST);
        return element;
    }

    public WebElement edit_Starting_Wages_TextBox(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_EMPLOYEE_WAGES_TEXTBOX);
        return element;
    }

    public WebElement edit_Wages_Gave_Information_Date(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_EMPLOYEE_GIVEINFODATS_TEXTBOX);
        return element;
    }

    public WebElement edit_Offer_Date_TextBox(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_EMPLOYEE_OFFERDATE_TEXTBOX);
        return element;
    }
    public WebElement edit_esign_Date_TextBox(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_ESIGN_TEXTBOX);
        return element;
    }
    public WebElement edit_Employee_Signature_Date(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_EMPLOYEE_SIGNATUREDATE_DATE);
        return element;
    }

    public WebElement edit_Save_Button(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_EMPLOYEE_SAVE_BUTTON);
        return element;
    }

    public WebElement edit_Back_Button(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_EMPLOYEE_BACK_BUTTON);
        return element;
    }
    public WebElement edit_Company_Select(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_EMPLOYEE_COMPANY_NAME_SELECT);
        return element;
    }

    public WebElement edit_Save_Successfully_Msg(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_EMPLOYEE_RECORD_SAVE_SUCCESS_MSG);
        return element;
    }

    public WebElement edit_Position_Employee_Dropdown_Arrow(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_EMPLOYEE_EMPLYOEE_POSITION_DROPDOWN_ARROW);
        return element;
    }

    public WebElement edit_Position_Employee_Hire_Date(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_EMPLOYEE_HIRE_DATE_INPUT);
        return element;
    }

    public WebElement edit_Position_Employee_Start_Date(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_EMPLOYEE_START_DATE_INPUT);
        return element;
    }

    public WebElement edit_Position_Employee_State_Text(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_EMPLOYEE_STATE_TEXT);
        return element;
    }

    public WebElement edit_Position_Employee_Job_Title_Text(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_EMPLOYEE_JOB_TITLE);
        return element;
    }

    public WebElement edit_Start_Date(){

        element = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_EMPLOYEE_STARTDATE_TEXTBOX);
        return element;
    }
    
    public WebElement emp_Info_Unit_Search_Icon(){
        element = getDriver().findElement(EditPersonalInfo.EMPLOYEE_INFO_UNIT_SEARCH_ICON);
        return element;
    }
    
    public WebElement unit_Search_Popup_Unit_Name(){
        element = getDriver().findElement(EditPersonalInfo.UNIT_SEARCH_POPUP_UNIT_NAME);
        return element;
    }
    
    public WebElement unit_Search_Popup_Zip_Code(){
        element = getDriver().findElement(EditPersonalInfo.UNIT_SEARCH_POPUP_ZIP_CODE);
        return element;
    }
    
    public WebElement unit_Search_Popup_City(){
        element = getDriver().findElement(EditPersonalInfo.UNIT_SEARCH_POPUP_CITY);
        return element;
    }
    
    public WebElement unit_Search_Popup_Unit_Code(){
        element = getDriver().findElement(EditPersonalInfo.UNIT_SEARCH_POPUP_UNIT_CODE);
        return element;
    }
    
    public WebElement unit_Search_Popup_Address(){
        element = getDriver().findElement(EditPersonalInfo.UNIT_SEARCH_POPUP_ADDRESS);
        return element;
    }
    
    public WebElement unit_Search_Popup_State(){
        element = getDriver().findElement(EditPersonalInfo.UNIT_SEARCH_POPUP_STATE);
        return element;
    }
    
    public WebElement unit_Search_Popup_Search_Btn(){
        element = getDriver().findElement(EditPersonalInfo.UNIT_SEARCH_POPUP_SEARCH_BTN);
        return element;
    }
    
    public WebElement unit_Search_Popup_Reset_Btn(){
        element = getDriver().findElement(EditPersonalInfo.UNIT_SEARCH_POPUP_RESET_BTN);
        return element;
    }
    
    public WebElement unit_Search_Popup_Result_First_Row(){
        element = getDriver().findElement(EditPersonalInfo.UNIT_SEARCH_POPUP_RESULT_FIRST_ROW);
        return element;
    }
    
    public WebElement recordStatusDropdownBtn(){
        element = getDriver().findElement(EditPersonalInfo.RECORD_STATUS_DROPDOWN_BTN);
        return element;
    }
    
    public WebElement recordStatusDropdownSelectedValue(){
        element = getDriver().findElement(EditPersonalInfo.RECORD_STATUS_DROPDOWN_SELECTED_VALUE);
        return element;
    }
    
    public WebElement saveBtnOnRecordDetailsPage(){
        element = getDriver().findElement(EditPersonalInfo.SAVE_BTN_RECORD_DETAILS_PAGE);
        return element;
    }
    
    public WebElement targetGroupIcon(){
        element = getDriver().findElement(EditPersonalInfo.TARGET_GROUP_ICON);
        return element;
    }
    
    public WebElement addNotesTextArea(){
        element = getDriver().findElement(EditPersonalInfo.ADD_NOTES_TEXT_AREA);
        return element;
    }
    
    public WebElement addNotesUser(){
        element = getDriver().findElement(EditPersonalInfo.ADD_NOTES_USER);
        return element;
    }
    
    public WebElement addNotesDate(){
        element = getDriver().findElement(EditPersonalInfo.ADD_NOTES_DATE);
        return element;
    }
    
    public WebElement addNotesText(){
        element = getDriver().findElement(EditPersonalInfo.ADD_NOTES_TEXT);
        return element;
    }
    
    public WebElement moreDetailsLinkOnTargetGroup(){
        element = getDriver().findElement(EditPersonalInfo.MORE_DETAILS_LINK_ON_TARGET_GROUP);
        return element;
    }
    
    public WebElement saveBtnOnTargetGroupMoreDetails(){
        element = getDriver().findElement(EditPersonalInfo.SAVE_BTN_ON_TARGET_GROUP_MORE_DETAILS);
        return element;
    }
    
    public WebElement confirmationPopUpText(){
        element = getDriver().findElement(EditPersonalInfo.CONFIRMATION_POP_UP_TEXT);
        return element;
    }
    
    public WebElement confirmationPopUpSaveBtn(){

        element = getDriver().findElement(EditPersonalInfo.CONFIRMATION_POP_UP_SAVE_BTN);

        return element;
    }
    
    public WebElement confirmationPopUpYesBtn(){
    	
    	        element = getDriver().findElement(EditPersonalInfo.CONFIRMATION_POP_UP_YES_BTN);
    	
    	        return element;
    	    }
    
    public WebElement dataSavedSuccessfullyText(){
        element = getDriver().findElement(EditPersonalInfo.DATA_SAVED_TEXT_ON_MORE_DETAILS);
        return element;
    }
    
    public WebElement backBtn(){
        element = getDriver().findElement(EditPersonalInfo.BACK_ON_MORE_DETAILS);
        return element;
    }
    public WebElement successfulMsgText(){
        element = getDriver().findElement(EditPersonalInfo.SUCCESSFUL_MSG_TEXT);
        return element;
    }
    public WebElement informationMsgText(){
        element = getDriver().findElement(EditPersonalInfo.INFORMATION_MSG_TEXT);
        return element;
    }
    
    public WebElement massMailSendBtn(){
        element = getDriver().findElement(EditPersonalInfo.MASS_SEND_MAIL_BTN_ON_HUB_SEARCH_PAGE);
        return element;
    }
	public WebElement selectAllRedioBtnOnHubResult(){
	        element = getDriver().findElement(EditPersonalInfo.SELECT_ALL_RECORD_HUB_SEARCH_PAGE);
	        return element;
	    }
	public WebElement enterMAilAddressOnMassForSend(){
	        element = getDriver().findElement(EditPersonalInfo.ENTER_EMAIL_ADDRESS_ON_MASS_FORM_SEND);
	        return element;
	    }
	public WebElement enterMsgOnMassForSend(){
	        element = getDriver().findElement(EditPersonalInfo.ENTER_MSG_ON_MASS_FORM_SEND);
	        return element;
	    }
	public WebElement sendFormByFaxRedioBtn(){
	        element = getDriver().findElement(EditPersonalInfo.SEND_FORM_BY_FAX_REDIO_BTN_ON_MASS_FORM_SEND);
	        return element;
	    }
	public WebElement sendToFieldOnMassForm(){
	        element = getDriver().findElement(EditPersonalInfo.SEND_TO_FIELD_ON_MASS_FORM_SEND);
	        return element;
	    }
	public WebElement areaCodeFieldOnMassForm(){
	        element = getDriver().findElement(EditPersonalInfo.AREA_CODE_ON_MASS_FORM_SEND);
	        return element;
	    }	
	public WebElement faxNumberFieldOnMassForm(){
	        element = getDriver().findElement(EditPersonalInfo.FAX_NUMBER_ON_MASS_FORM_SEND);
	        return element;
	    }
	public WebElement sendFormBtnOnMassForm(){
	        element = getDriver().findElement(EditPersonalInfo.SEND_FORM_BTN_ON_MASS_FORM_SEND);
	        return element;
	    }
	
	public WebElement exportToExcelBtn(){
	        element = getDriver().findElement(EditPersonalInfo.EXPORT_TO_EXCEL_BTN_ON_HUB_SEARCH_PAGE);
	        return element;
	    }
	public WebElement exportToExcelPopMsg(){
	        element = getDriver().findElement(EditPersonalInfo.EXPORT_TO_EXCEL_POP_MSG);
	        return element;
	    }
	public WebElement exportToExcelPopUpSubmitBtn(){
	        element = getDriver().findElement(EditPersonalInfo.EXPORT_TO_EXCEL_POP_SUBMIT_BTN);
	        return element;
	    }
	public WebElement exportToExcelPopUpRequestId(){
	        element = getDriver().findElement(EditPersonalInfo.EXPORT_TO_EXCEL_POP_REQUEST_ID_MSG);
	        return element;
	    }
	
	public WebElement exportToExcelPopUpCloseBtn(){
        element = getDriver().findElement(EditPersonalInfo.EXPORT_TO_EXCEL_POP_UP_CLOSE_BTN);
        return element;
    }
	public WebElement massFormRequestIdMsg(){
        element = getDriver().findElement(EditPersonalInfo.MASS_FORM_REQUEST_ID_MSG);
        return element;
    }
	public WebElement processingQueueLink(){
        element = getDriver().findElement(EditPersonalInfo.PROCESSING_QUEUE_lINK);
        return element;
    }
public WebElement processingIdFieldOnProcessingQueue(){
        element = getDriver().findElement(EditPersonalInfo.PROCESSING_ID_FIELD_ON_PROCESSING_QUEUE);
        return element;
    }

public WebElement searchBtnOnProcessingQueue(){
    element = getDriver().findElement(EditPersonalInfo.SEARCH_BTN_ON_PROCESSING_QUEUE);
    return element;
}
public WebElement statusColOnProcessingQueueReult(){
    element = getDriver().findElement(EditPersonalInfo.STATUS_COL_ON_PROCESSING_QUEUE_RESULT);
    return element;
}
 
public WebElement emplDataUpdatedSuccessfullyMsg(){
    element = getDriver().findElement(EditPersonalInfo.EMPL_DATA_UPDATED_SUCCESSFULLY_MSG);
    return element;
}

public WebElement backBtnEditDetailsPage(){
    element = getDriver().findElement(EditPersonalInfo.BACK_BTN_EDIT_DETAILS_PAGE);
    return element;
}
    public WebElement home_page_link(){
        element = getDriver().findElement(EditPersonalInfo.HOME_PAGE_LINK);
        return element;
    }
    public WebElement home_PAGE_STATUS(){
        element = getDriver().findElement(EditPersonalInfo.HOME_PAGE_STATUS);
        return element;
    }

    
    public WebElement docufreeReceivedDate(){
        element = getDriver().findElement(EditPersonalInfo.DOCUFREE_RECEIVED_DATE);
        return element;
    }
    
    public WebElement docufreeMatchDate(){
        element = getDriver().findElement(EditPersonalInfo.DOCUFREE_MATCH_DATE);
        return element;
    }
    
    public WebElement docufreeUniqueId(){
        element = getDriver().findElement(EditPersonalInfo.DOCUFREE_UNIQUE_ID);
        return element;
    }
    public WebElement docufreeImagePath(){
        element = getDriver().findElement(EditPersonalInfo.DOCUFREE_IMAGE_PATH);
        return element;
    }
    public WebElement docufreeDocumentsStatus(){
        element = getDriver().findElement(EditPersonalInfo.DOCUFREE_DOCUMENT_STATUS);
        return element;
    }

    
    public WebElement docufreeReceivedDateValue(){
        element = getDriver().findElement(EditPersonalInfo.DOCUFREE_RECEIVED_DATE_VALUE);
        return element;
    }
    
    public WebElement docufreeMatchDateValue(){
        element = getDriver().findElement(EditPersonalInfo.DOCUFREE_MATCH_DATE_VALUE);
        return element;
    }
    
    public WebElement docufreeUniqueIdValue(){
        element = getDriver().findElement(EditPersonalInfo.DOCUFREE_UNIQUE_ID_VALUE);
        return element;
    }
    public WebElement docufreeImagePathValue(){
        element = getDriver().findElement(EditPersonalInfo.DOCUFREE_IMAGE_PATH_VALUE);
        return element;
    }
    public WebElement docufreeDocumentsStatusValue(){
        element = getDriver().findElement(EditPersonalInfo.DOCUFREE_DOCUMENT_STATUS_VALUE);
        return element;
    }

public void editPersonalDetails(String firstName, String middleName, String lastName,
                                String updatedSSN, String phoneNumber, String addressLine,
                                String cityName, String countryName, String zipCode, String companyName,
                                String unit, String emailAddress, String startingWages, String stateName,
                                String position, String startDateInput, String hireDateInput) throws InterruptedException {
    WebElement empInfo =searchSSNhub.Search_SSN_The_SearchResult();
    userAct.doubleClick(empInfo);
    Thread.sleep(5000);
    explicitWaitForElement(EditPersonalInfo.EDIT_BUTTON_ON_PERSONAL_INFO,10);
    edit_Personal_Info_Button().click();
    edit_First_Name_TextBox().clear();
    edit_First_Name_TextBox().sendKeys(firstName);
    edit_Middle_Name_TextBox().clear();
    edit_Middle_Name_TextBox().sendKeys(middleName);
    edit_Last_Name_TextBox().clear();
    edit_Last_Name_TextBox().sendKeys(lastName);
    edit_Personal_SSN_Number_TextBox().clear();
    edit_Personal_SSN_Number_TextBox().sendKeys(updatedSSN);
    edit_Phone_Number_Box().clear();
    edit_Phone_Number_Box().sendKeys(phoneNumber);
    edit_Address_Line_TextBox().clear();
    edit_Address_Line_TextBox().sendKeys(addressLine);
    edit_City_TextBox().clear();
    edit_City_TextBox().sendKeys(cityName);
   edit_State_Dropdown_Const().click();
    Thread.sleep(2000);
   WebElement selectState = edit_State_Dropdown_Arrow();
    userAct.selectDropdownValues(stateName);
    edit_Position_Employee_Dropdown_Arrow().click();
    userAct.selectDropdownValues(position);
    edit_Email_Address_TextBox().clear();
    edit_Email_Address_TextBox().sendKeys(emailAddress);
    edit_Country_TextBox().clear();
    edit_Country_TextBox().sendKeys(countryName);
    edit_Zip_code_TextBox().clear();
    edit_Zip_code_TextBox().sendKeys(zipCode);
    edit_Company_Name_TextBox().clear();
    edit_Company_Name_TextBox().sendKeys(companyName);
    Thread.sleep(3000);
    edit_Company_Select().click();
    edit_Unit_TextBox().clear();
    edit_Unit_TextBox().sendKeys(unit);

    edit_Starting_Wages_TextBox().clear();
    edit_Starting_Wages_TextBox().sendKeys(startingWages);
    WebElement hireDate = edit_Position_Employee_Hire_Date();
    userAct.selectDate(hireDateInput, hireDate);
    WebElement startDate = edit_Position_Employee_Start_Date();
    userAct.selectDate(startDateInput, startDate);
    edit_Save_Button().click();
    Thread.sleep(10000);

}


}
