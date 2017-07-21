package adp.tcs.automation.pages;


import adp.tcs.automation.locators.UserLogin;
import adp.tcs.automation.stepsfiles.BaseTempletSteps;
import adp.tcs.automation.utilities.UserAction;
import adp.tcs.automation.utilities.WndowAction;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

/**
 * Created by BhuteSac on 4/3/2016.
 */
public class Login extends BaseTempletSteps {

        private WebElement element = null;    
        //private UserAction userAct = new UserAction();
        private UserAction userAct = new UserAction();
    WndowAction windowAct = new WndowAction();

        public WebElement select_set_Cookie(){

            element = getDriver().findElement(UserLogin.SELECT_SET_COOKIES_BUTTON);
            return element;
        }

        public  WebElement caps_Fit_Portal_Login(){
            element = getDriver().findElement(UserLogin.CAPS_FIT_PORTAL_LOGIN_LINK);
            return element;
        }

        public WebElement caps_Fit_Portal_UserName(){

            element = getDriver().findElement(UserLogin.CAPS_FIT_PORTAL_USER_NAME);
            return element;
        }

        public WebElement caps_Fit_Portal_Submit_Button(){

            element = getDriver().findElement(UserLogin.CAPS_FIT_PORTAL_SUBMIT_BUTTON);
            return element;
        }

        public WebElement caps_Fit_Portal_Activation_Code_Text(){

            element = getDriver().findElement(UserLogin.CAPS_FIT_PORTAL_ACTIVATION_CODE_TEXT);
            return element;
        }

        public WebElement caps_Fit_Portal_ActivationCode_Input(){

            element = getDriver().findElement(UserLogin.CAPS_FIT_PORTAL_ACTIVATION_CODE_INPUTBOX);
            return element;

        }

        public WebElement caps_Fit_Portal_ActivationCode_NextButton(){

            element = getDriver().findElement(UserLogin.CAPS_FIT_PORTAL_ACTIVATION_CODE_NEXTBUTTON);
            return element;

        }

        public WebElement caps_Fit_Portal_QuestionOne_Text(){

            element = getDriver().findElement(UserLogin.CAPS_FIT_PORTAL_QUESTIONONE_TEXT);
            return element;

        }

        public WebElement caps_Fit_Portal_QuestionTwo_Text(){

            element = getDriver().findElement(UserLogin.CAPS_FIT_PORTAL_QUESTIONTWO_TEXT);
            return element;

        }

        public WebElement caps_Fit_Portal_QuestionThree_Text(){

            element = getDriver().findElement(UserLogin.CAPS_FIT_PORTAL_QUESTIONTHREE_TEXT);
            return element;
        }

        public WebElement caps_Fit_Portal_QuestionOne_Answer(){

            element = getDriver().findElement(UserLogin.CAPS_FIT_PORTAL_QUESTIONONE_ANSWER_INPUT);
            return element;
        }

        public WebElement caps_Fit_Portal_QuestionTwo_Answer(){

            element = getDriver().findElement(UserLogin.CAPS_FIT_PORTAL_QUESTIONTWO_ANSWER_INPUT);
            return element;
        }

        public WebElement caps_Portal_Logout_Icon(){

            element = getDriver().findElement(UserLogin.PORTAL_LOGOUT_ICON);
            return element;
        }

        public WebElement caps_Portal_Logout_Button(){

            element = getDriver().findElement(UserLogin.PORTAL_LOGOUT_BUTTON);
            return element;
        }
 
        public WebElement caps_Fit_Portal_QuestionThree_Answer(){

            element = getDriver().findElement(UserLogin.CAPS_FIT_PORTAL_QUESTIONTHREE_ANSWER_INPUT);
            return element;
        }

        public WebElement caps_Fit_Portal_Question_Submit(){

            element = getDriver().findElement(UserLogin.CAPS_FIT_PORTAL_QUESTION_SUBMIT_BUTTON);
            return element;
        }
        public WebElement caps_Fit_Portal_Password_Input(){

            element = getDriver().findElement(UserLogin.CAPS_FIT_PORTAL_PASSWORD_INPUT);
            return element;
        }

        public WebElement caps_Fit_Portal_Password_Submit(){

            element = getDriver().findElement(UserLogin.CAPS_FIT_PORTAL_PASSWORD_SUBMIT_BUTTON);
            return element;
        }

        public WebElement caps_Fit_Portal_Password_Fit_Submit(){

        element = getDriver().findElement(UserLogin.CAPS_FIT_PORTAL_PASSWORD_FIT_INPUT);
        return element;
    }
        public WebElement FIT2_SCREENING_URL_CLICK(){
        WebElement element = getDriver().findElement(UserLogin.FIT2_SCREENING_URL_CLICK);
        return element;
    }
    public WebElement CAPS_QA_ENVIRONEMT_SELECT_COOKIES(){
        WebElement element = getDriver().findElement(UserLogin.CAPS_QA_ENVIRONEMT_SELECT_COOKIES);
        return element;
    }
    public WebElement CAPS_QA_ENVIRONEMT_SELECT_COOKIES_SUBMIT_BUTTON(){
        WebElement element = getDriver().findElement(UserLogin.CAPS_QA_ENVIRONEMT_SELECT_COOKIES_SUBMIT_BUTTON);
        return element;
    }



    public void backOffLogin(String userName, String passWord) throws InterruptedException {
        try {
            String screeningURL = (loadPropValues("applicationUrl"));
            getDriver().get(screeningURL);
            Thread.sleep(3000);
            if(loadPropValues("envName").equals("production") || loadPropValues("envName").equals("iat") || loadPropValues("envName").equals("fit1") || loadPropValues("envName").equals("fit2") || loadPropValues("envName").equals("test")|| loadPropValues("envName").equals("QA2")) {
                if (loadPropValues("envName").equals("fit2") || loadPropValues("envName").equals("test")) {
                    /*waitForLoad();
                    select_set_Cookie().click();
                    windowAct.switchtoMultiChildWindow(caps_Fit_Portal_Login());
                    waitForLoad();*/
                	
                	waitForLoad();
                    select_set_Cookie().click();
                    String qaURL = (loadPropValues("qaEnvironment"));
                    getDriver().get(qaURL);
                    loginSignleAnswer(userName, passWord);
                    selectDropdownByValue(CAPS_QA_ENVIRONEMT_SELECT_COOKIES(),"QA2");
                    CAPS_QA_ENVIRONEMT_SELECT_COOKIES_SUBMIT_BUTTON().click();
                    getDriver().get(loadPropValues("launchAppUrl"));
                    select_set_Cookie().click();
                    windowAct.switchtoMultiChildWindow(caps_Fit_Portal_Login());
                    sleep(15000);
                    waitForLoad();
                }
                if (loadPropValues("envName").equals("fit1")) {
                    windowAct.switchtoMultiChildWindow(caps_Fit_Portal_Login());
                    Thread.sleep(5000);
                    waitForLoad();
                }
                //SCP Environments
                if (loadPropValues("envName").equals("QA2")) {
                    waitForLoad();
                    select_set_Cookie().click();
                    String qaURL = (loadPropValues("qaEnvironment"));
                    getDriver().get(qaURL);
                    loginSignleAnswer(userName, passWord);
                    selectDropdownByValue(CAPS_QA_ENVIRONEMT_SELECT_COOKIES(),"QA2");
                    CAPS_QA_ENVIRONEMT_SELECT_COOKIES_SUBMIT_BUTTON().click();
                    getDriver().get(loadPropValues("launchAppUrl"));
                    select_set_Cookie().click();
                    windowAct.switchtoMultiChildWindow(caps_Fit_Portal_Login());
                    sleep(15000);
                    waitForLoad();
                }
                if (!loadPropValues("envName").equals("QA2")) {
                    caps_Fit_Portal_UserName().sendKeys(userName);
                    Thread.sleep(5000);
                    caps_Fit_Portal_Submit_Button().click();
                    waitForLoad();
                    Thread.sleep(2000);
                    String activecode = caps_Fit_Portal_Activation_Code_Text().getText();
                    caps_Fit_Portal_ActivationCode_Input().sendKeys(activecode);
                    caps_Fit_Portal_ActivationCode_NextButton().click();
                    Thread.sleep(2000);
                    String firstQues = caps_Fit_Portal_QuestionOne_Text().getText();
                    String SecondQues = caps_Fit_Portal_QuestionTwo_Text().getText();
                    String thirdQues = caps_Fit_Portal_QuestionThree_Text().getText();
                    String answerOne = firstQues.substring(firstQues.lastIndexOf(' ') + 1, firstQues.lastIndexOf('?'));
                    System.out.println("LOGGER ANSWER : - " + answerOne);
                    if (answerOne.equalsIgnoreCase("girlfriend/boyfriend")) {
                        caps_Fit_Portal_QuestionOne_Answer().sendKeys("boyfriendboyfriend");
                    } else {
                        caps_Fit_Portal_QuestionOne_Answer().sendKeys(answerOne + answerOne);
                    }
                    String answerSecond = SecondQues.substring(SecondQues.lastIndexOf(' ') + 1, SecondQues.lastIndexOf('?'));
                    System.out.println(answerSecond);
                    if (answerSecond.equalsIgnoreCase("girlfriend/boyfriend")) {
                        caps_Fit_Portal_QuestionTwo_Answer().sendKeys("boyfriendboyfriend");
                    } else {
                        caps_Fit_Portal_QuestionTwo_Answer().sendKeys(answerSecond + answerSecond);
                    }
                    String answerThird = thirdQues.substring(thirdQues.lastIndexOf(' ') + 1, thirdQues.lastIndexOf('?'));
                    System.out.println(answerThird);
                    if (answerThird.equalsIgnoreCase("girlfriend/boyfriend")) {
                        caps_Fit_Portal_QuestionThree_Answer().sendKeys("boyfriendboyfriend");
                    } else {
                        caps_Fit_Portal_QuestionThree_Answer().sendKeys(answerThird + answerThird);
                    }
                    caps_Fit_Portal_Question_Submit().click();
                    caps_Fit_Portal_Password_Input().sendKeys(passWord);
                    Thread.sleep(2000);
                    caps_Fit_Portal_Password_Submit().click();
                }
            }else{
                caps_Fit_Portal_Password_Fit_Submit().sendKeys(passWord);
                Thread.sleep(2000);
                caps_Fit_Portal_Submit_Button().click();
                waitForLoad();
            }
        }catch(Exception e)
        {
            sleep(5000);
            caps_Fit_Portal_Password_Fit_Submit().sendKeys(passWord);
            sleep(5000);
            caps_Fit_Portal_Submit_Button().click();
            waitForLoad();
            e.printStackTrace();
        }

    }

	public void portalBackOffLogout() {
		try {
			boolean flag = false;
			Thread.sleep(3000);
			userAct.switchToDefaultFrame();
			Thread.sleep(3000);
			if (caps_Portal_Logout_Icon().isEnabled()) {
				flag = true;
			}
			caps_Portal_Logout_Icon().click();
			waitForLoad();
			Thread.sleep(3000);
			caps_Portal_Logout_Button().click();
			Assert.assertTrue("No Logout Button is Displayed on Page", flag);
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    public void loginSignleAnswer(String userName, String passWord)
    {
        caps_Fit_Portal_UserName().sendKeys(userName);
        sleep(5000);
        caps_Fit_Portal_Submit_Button().click();
        waitForLoad();
        sleep(2000);
        
        if(isDisplayed(UserLogin.CAPS_FIT_PORTAL_ACTIVATION_CODE_TEXT)){
        String activecode = caps_Fit_Portal_Activation_Code_Text().getText();
        caps_Fit_Portal_ActivationCode_Input().sendKeys(activecode);
        caps_Fit_Portal_ActivationCode_NextButton().click();
        sleep(2000);
        String firstQues = caps_Fit_Portal_QuestionOne_Text().getText();
        String SecondQues = caps_Fit_Portal_QuestionTwo_Text().getText();
        String thirdQues = caps_Fit_Portal_QuestionThree_Text().getText();
        String answerOne = firstQues.substring(firstQues.lastIndexOf(' ') + 1, firstQues.lastIndexOf('?'));
        System.out.println("LOGGER ANSWER : - " + answerOne);
        if (answerOne.equalsIgnoreCase("girlfriend/boyfriend")) {
            caps_Fit_Portal_QuestionOne_Answer().sendKeys("boyfriendboyfriend");
        } else {
            caps_Fit_Portal_QuestionOne_Answer().sendKeys(answerOne);
        }
        String answerSecond = SecondQues.substring(SecondQues.lastIndexOf(' ') + 1, SecondQues.lastIndexOf('?'));
        System.out.println(answerSecond);
        if (answerSecond.equalsIgnoreCase("girlfriend/boyfriend")) {
            caps_Fit_Portal_QuestionTwo_Answer().sendKeys("boyfriendboyfriend");
        } else {
            caps_Fit_Portal_QuestionTwo_Answer().sendKeys(answerSecond);
        }
        String answerThird = thirdQues.substring(thirdQues.lastIndexOf(' ') + 1, thirdQues.lastIndexOf('?'));
        System.out.println(answerThird);
        if (answerThird.equalsIgnoreCase("girlfriend/boyfriend")) {
            caps_Fit_Portal_QuestionThree_Answer().sendKeys("boyfriendboyfriend");
        } else {
            caps_Fit_Portal_QuestionThree_Answer().sendKeys(answerThird);
        }
        caps_Fit_Portal_Question_Submit().click();
        }
        
        caps_Fit_Portal_Password_Fit_Submit().sendKeys(passWord);
        sleep(5000);
        caps_Fit_Portal_Submit_Button().click();
        waitForLoad();
    }
}
