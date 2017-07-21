package adp.tcs.automation.locators;

import org.openqa.selenium.By;

/**
 * Created by BhuteSac on 10/6/2016.
 */
public class StandAloneSreening {

    public static By STAND_ALONE_NAME_DURING_SERIVE = By.xpath("//*[@id=\"question\"]/div[2]/div[9]/input");
    public static By STAND_ALONE_BIRTH_PLACE = By.xpath("//*[@id=\"question\"]/div[2]/div[16]/input");
    public static By STAND_ALONE_BRANCH_SERVICE = By.xpath("//*[@id=\"question\"]/div[2]/div[37]/div[4]/div/select");
    //AIR FORCE

    public static By STAND_ALONE_DATE_ENTERED = By.xpath("//*[@id=\"dp1475749361586\"]");
    public static By STAND_ALONE_DATE_RESEASED = By.xpath("//*[@id=\"dp1475749361587\"]");
    public static By STAND_ALONE_SERVICE_STATUS_SELECT = By.xpath("//*[@id=\"question\"]/div[2]/div[58]/div[4]/div/select");
    //OFFICER
    public static By STAND_ALONE_SERVICE_NUMBER = By.xpath("//*[@id=\"question\"]/div[2]/div[65]/input");

    //*[@id="question"]/div[2]/div[79]/div[4]/div/select
    public static By STAND_ALONE_RESERVE_COMPONAME = By.xpath("//*[@id=\"question\"]/div[2]/div[79]/div[4]/div/select");

    public static By STAND_ALONE_NATIONAL_GUARD = By.xpath("//*[@id=\"question\"]/div[2]/div[121]/div[4]/div/select");

    public static By STAND_ALONE_RETIRED_FROM_MILITORY = By.xpath("//*[@id=\"Retired_From_Military_Service_YES\"]");
    public static By STAND_ALONE_SF150_CONTINUE_BUTTON = By.xpath("//*[@id=\"continuebutton\"]");








}
