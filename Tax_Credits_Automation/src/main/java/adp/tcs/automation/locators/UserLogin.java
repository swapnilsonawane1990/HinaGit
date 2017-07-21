package adp.tcs.automation.locators;

import org.openqa.selenium.By;

/**
 * Created by bhutesac on 4/1/2016.
 */
public class UserLogin {

    public static By SELECT_SET_COOKIES_BUTTON = By.xpath(" html/body/p[2]/input[2]");
    public static By CAPS_FIT_PORTAL_LOGIN_LINK = By.xpath("//tbody/tr[1]/td[2]/a");
    public static By CAPS_FIT_PORTAL_USER_NAME = By.xpath("//input[@id='USER']");
    public static By CAPS_FIT_PORTAL_SUBMIT_BUTTON = By.xpath("//div[@class='buttonMid'][.='Submit']");
    public static By CAPS_FIT_PORTAL_ACTIVATION_CODE_TEXT = By.xpath("//*[@id='activationCodeForm']/table/tbody/tr[1]/td");
    public static By CAPS_FIT_PORTAL_ACTIVATION_CODE_INPUTBOX = By.xpath("//*[@id='acCode']");
    public static By CAPS_FIT_PORTAL_ACTIVATION_CODE_NEXTBUTTON = By.xpath("//*[@id='revit_form_Button_3_label']");
    public static By CAPS_FIT_PORTAL_QUESTIONONE_TEXT = By.xpath("//*[@id='question1']");
    public static By CAPS_FIT_PORTAL_QUESTIONTWO_TEXT = By.xpath("//*[@id='question2']");
    public static By CAPS_FIT_PORTAL_QUESTIONTHREE_TEXT = By.xpath("//*[@id='question3']");
    public static By CAPS_FIT_PORTAL_QUESTIONONE_ANSWER_INPUT = By.xpath(".//*[@id='answer1']");
    public static By CAPS_FIT_PORTAL_QUESTIONTWO_ANSWER_INPUT = By.xpath(".//*[@id='answer2']");
    public static By CAPS_FIT_PORTAL_QUESTIONTHREE_ANSWER_INPUT = By.xpath(".//*[@id='answer3']");
    public static By CAPS_FIT_PORTAL_QUESTION_SUBMIT_BUTTON = By.xpath("//*[@id='revit_form_Button_3_label']");
    public static By CAPS_FIT_PORTAL_PASSWORD_INPUT = By.xpath("//*[@id='password']");
    public static By CAPS_FIT_PORTAL_PASSWORD_SUBMIT_BUTTON = By.xpath("//span[@class='dijitButtonText'][.='Done']");
    public static By CAPS_FIT_PORTAL_PASSWORD_FIT_INPUT = By.xpath("//*[@id='passwordForm:password']");
    public static final By FIT2_SCREENING_URL_CLICK = By.xpath("//A[@href='https://tcs-fit.nj.adp.com/screen/index.html?cc=motox'][text()='https://tcs-fit.nj.adp.com/screen/index.html?cc=motox']");

    public static By CAPS_QA_ENVIRONEMT_SELECT_COOKIES = By.xpath("//SELECT[@name='selCookie']");
    public static By CAPS_QA_ENVIRONEMT_SELECT_COOKIES_SUBMIT_BUTTON = By.xpath("//INPUT[@type='submit']");
    public static By PORTAL_LOGOUT_ICON = By.xpath("//div[@class='image-editor image-editor__cursor--default']");
    public static By PORTAL_LOGOUT_BUTTON = By.xpath("//a[contains(text(),'Log Out')]");

}