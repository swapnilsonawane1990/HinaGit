package adp.tcs.automation.stepsfiles;


import adp.tcs.automation.utilities.ReportMapping;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by bhutesac on 4/1/2016.
 */
public class BaseTempletSteps extends Steps{
    public String workingDir = System.getProperty("user.dir");
    public String screenShotPath = workingDir + "//test//All-Screenshot";
    public String jbehaveReportPath = workingDir + "//target//jbehave//view";
    public String jbehaveReport = workingDir + "//target//jbehave";
    public static HashMap<String, String> excelData = new HashMap<String, String>();
    public static WebDriver driver = null;
    public static String envName = null;
    public static String scenarioName = null;
    public String unzipFilesLoc = this.workingDir + "//test//UnzipFiles";
    public String zippedFileLocation = this.workingDir + "//test//DownloadedFiles//";
    public String deleteDownlaodFileLoc = this.workingDir + "//test//DownloadedFiles";
    public String movedFilesLoc = this.workingDir + "//test//MovedFiles//";
    public static ExtentReports report;
    public static String startTime;
    public static String endTime;
    public static ReportMapping reportMapping = null;
    public static ArrayList<ReportMapping> comprehensiveMap = new ArrayList<ReportMapping>();
    public String fileUploadScripts = workingDir + "\\fileuploadscripts\\";
    public String docufreeUploadImages = workingDir;
    public static ArrayList<String> unqiueIds = new ArrayList<String>();
    
   
	public static int SSN = 0;
    
    
   
    
    public static int getSSN() {
		return SSN;
	}

	public static void setSSN(int sSN) {
		SSN = sSN;
	}

	public static String getStartTime() {
		return startTime;
	}

	public static void setStartTime(String startTime) {
		BaseTempletSteps.startTime = startTime;
	}   
    
	public static String getEndTime() {
		return endTime;
	}

	public static void setEndTime(String endTime) {
		BaseTempletSteps.endTime = endTime;
	}

	public static ExtentReports getReport() {
		return report;
	}

	public static void setReport(ExtentReports report) {
		BaseTempletSteps.report = report;
	}

	public static ExtentTest getLogger() {
		return logger;
	}

	public static void setLogger(ExtentTest logger) {
		BaseTempletSteps.logger = logger;
	}

	public static ExtentTest logger;
	
	
	public void log(String logText){
		getLogger().log(LogStatus.INFO, logText);
	}
	
	public void verifyTest(String testName){
		getLogger().log(LogStatus.PASS, testName);
		//reportMapping.setStatus("PASS");
	}
	
	public void verifyTest(String testName, boolean isChecked){	
		if(isChecked){
			getLogger().log(LogStatus.PASS, testName);
			reportMapping.setStatus("PASS");
		}else{
			getLogger().log(LogStatus.FAIL, testName);
			reportMapping.setStatus("FAIL");
		}
		Assert.assertTrue("Assertion Failure", isChecked);
		getReport().endTest(getLogger());		
	}
	
	public void startTest(String testName, String storyDescription){
		logger=report.startTest(testName,storyDescription);
		setLogger(logger);
	}
	    
    public void cleanExecelData() {
    	excelData.clear();
	}
    
    public String getScenarioName() {
		return scenarioName;
	}

	public void setScenarioName(String scenarioName) {
		BaseTempletSteps.scenarioName = scenarioName;
	}

	public HashMap<String, String> getExcelData() {
        return excelData;
    }

    public void setExcelData(HashMap<String, String> excelData) {
        BaseTempletSteps.excelData = excelData;
    }

    public static void setDriver(WebDriver driver) {
        BaseTempletSteps.driver = driver;
    }

    public WebDriver getDriver()
    {
       return driver;
    }

    public String getEnvName() {
		return envName;
	}

	public void setEnvName(String envName) {
		BaseTempletSteps.envName = envName;
	}

	public void sleep(int miliseconds){
    	try {
    		System.out.println("Sleeping for "+ miliseconds + " miliseconds");
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
	
	public void selectDropdown(WebElement element, String dropdownValue) {
        Select seldrp = new Select(element);
        seldrp.selectByVisibleText(dropdownValue);
    } 
	
	public void selectDropdownByValue(WebElement element, String dropdownValue) {
        Select seldrp = new Select(element);
        seldrp.selectByValue(dropdownValue);
    }
	
	/**
     * overloaded function to pass browser instance
     */
    public void waitForLoad() {
        waitForLoad(getDriver());
    }

    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        Boolean pageReady=((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                        if(pageReady){
                            try {
                                Thread.sleep(2000);
                            }catch (Exception ex){
                                ex.printStackTrace();
                            }
                        }
                        return pageReady;
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(pageLoadCondition);
    }

    WebDriverWait wait;
    public void explicitWaitForElement(By by, int timeout) {
        try {
            setWait(getDriver(), timeout);

            System.out.println("In explicitWaitForElement Function");
            getWait().until(
                    ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            System.out.println("Exception is occurs in explicitWaitForElement" + e);
        }
    }

    public void explicitWaitForElementDisappears(By by, int timeout) {
        try {
            setWait(getDriver(), timeout);

            System.out.println("In explicitWaitForElement Function");
            getWait().until(
                    ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (Exception e) {
            System.out.println("Exception is occurs in explicitWaitForElement" + e);
        }
    }
    
    public void setWait(WebDriver wd, int timeOut) {
        this.wait = new WebDriverWait(getDriver(), timeOut);
        this.wait.ignoring(StaleElementReferenceException.class, WebDriverException.class);
    }

    public WebDriverWait getWait()
    { return wait; }
    
    
    public String loadPropValues(String Key) {
        String workingDir = System.getProperty("user.dir");        
        File file = new File(workingDir +"\\src\\test\\resources\\env_properties\\"+getEnvName()+".properties");

        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();
        
        try {
            prop.load(fileInput);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(Key);
    }
    
    public String currentdate(){
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date dt = new Date();        
        System.out.println("Date in MM/dd/yyyy format: "+df.format(dt));
        String currentDate = String.valueOf(df.format(dt));
        return currentDate;
    }
    
    public String calcTime() {
    	
    	SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
	       Date date1 = null;
	       Date date2 = null;
		try {
			date1 = format.parse(getStartTime());
			date2 = format.parse(getEndTime());
		} catch (ParseException e) {			
			e.printStackTrace();
		}	       
	       long diff = date2.getTime() - date1.getTime();	       
	       
	       long diffSeconds = diff / 1000 % 60;
	       long diffMinutes = diff / (60 * 1000) % 60;
	       long diffHours = diff / (60 * 60 * 1000) % 24;
	       long diffDays = diff / (24 * 60 * 60 * 1000);
	       
	       String totalDuration = diffDays + "D, "+diffHours+ "Hr, "+diffMinutes+ "Min, "+diffSeconds+ "Sec";       
	       System.out.print("Total Time "+totalDuration);
	       
    	return totalDuration;
    }
    
    public String getBrwoserName(){
    	String browserName = "";
    	Capabilities cap = ((RemoteWebDriver) getDriver()).getCapabilities();
	    browserName = cap.getBrowserName().toLowerCase();	    
	    String v = cap.getVersion().toString();
    	return browserName;    			
    }
    
    public String getBrwoserVersion(){
    	String browserVersion = "";
    	Capabilities cap = ((RemoteWebDriver) getDriver()).getCapabilities();	    
	    browserVersion = cap.getVersion().toString();
    	return browserVersion;    			
    }
    
    public String getIPAddress() {
    	InetAddress IP = null;
		try {
			IP = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  	 
    	 return String.valueOf(IP).split("/")[1];
    }
    
    public int getCount(String xpath){
    	int count = 0;
    	try{
    		count = getDriver().findElements(By.xpath(xpath)).size();
    	}catch(Exception e){
    		verifyTest("Faliure in getCount() -- count not calculated.",false);
			e.printStackTrace();
    	}
    	return count;
    }    
    
    
    public String getText(String xpath){
    	String text = null;
    	try{
    		text = getDriver().findElement(By.xpath(xpath)).getText();
    	}catch(Exception e){
    		
			e.printStackTrace();
    	}
    	return text;
    }
    
    public String getText(WebElement xpath){
    	String text = null;
    	try{
    		text = xpath.getText();
    	}catch(Exception e){
    		
			e.printStackTrace();
    	}
    	return text;
    }
    
    public String getAttributeValue(String xpath, String attributeName){
    	String text = null;
    	try{
    		text = getDriver().findElement(By.xpath(xpath)).getAttribute(attributeName);
    	}catch(Exception e){
    		
			e.printStackTrace();
    	}
    	return text;
    }
    
    public String getAttributeValue(WebElement xpath, String attributeName){
    	String text = null;
    	try{
    		text = xpath.getAttribute(attributeName);
    	}catch(Exception e){
    		
			e.printStackTrace();
    	}
    	return text;
    }
    
    public void userClick(String xpath){    
    	try{
    		getDriver().findElement(By.xpath(xpath)).click();
    	}catch(Exception e){    		
			e.printStackTrace();
    	}    	
    }
    
    public void userClick(WebElement element){    
    	try{
    		element.click();
    	}catch(Exception e){ 		
			
    	}    	
    }
    
    public void doubleClick(String xpath){    
    	try{   		
    		Actions action = new Actions(getDriver());
    		WebElement element=driver.findElement(By.xpath(xpath));
    		action.doubleClick(element).perform();    		
    	}catch(Exception e){    		
			e.printStackTrace();
    	}    	
    }
    
    public void javaScriptClick(WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click");

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
	}
    
    

    public void actionClick(WebElement mainMenuClick,WebElement subMenuLink) throws Exception {
		try {
			Actions actions = new Actions(getDriver());
			WebElement mainMenu = mainMenuClick;
			actions.moveToElement(mainMenu);
			WebElement subMenu = subMenuLink;
			actions.moveToElement(subMenu);
			sleep(2000);
			actions.click().build().perform();
		} catch (Exception e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		}
	}

		
    
    public void userTypes(String xpath, String inputString){    
    	try{
    		getDriver().findElement(By.xpath(xpath)).sendKeys(inputString);
    	}catch(Exception e){    		
			
    	}    	
    }
    
    public void userClear(String xpath){    
    	try{
    		getDriver().findElement(By.xpath(xpath)).clear();
    	}catch(Exception e){    		
			e.printStackTrace();
    	}    	
    }
    
    public void selectDropdownValue(String xpath, String selectValue) throws InterruptedException {
         String dropValues = xpath + "[.='" + selectValue + "']";
         getDriver().findElement(By.xpath(dropValues)).click();
         sleep(1000);
     }
    
    public void selectDropdownValueByContains(String xpath, String selectValue) throws InterruptedException {
        String dropValues = xpath + "[contains(text(),'" + selectValue + "')]";
        getDriver().findElement(By.xpath(dropValues)).click();
        sleep(1000);
    }
    
    public boolean isDisplayed(By xpath){
    	boolean isDisplayed = false;
    	try{
    		WebElement element = getDriver().findElement(xpath);
    		isDisplayed = true;
    	}catch(Exception e){    		
    		isDisplayed = false;    		
    	}
    	return isDisplayed;
    }
    
    public boolean isDisplayed(String xpath){
    	boolean isDisplayed = false;
    	try{
    		WebElement element = getDriver().findElement(By.xpath(xpath));
    		isDisplayed = true;
    	}catch(Exception e){    		
    		isDisplayed = false;    		
    	}
    	return isDisplayed;
    }

	public boolean isDisplayed(WebElement element){
		boolean isDisplayed = false;
		try{
			element.isDisplayed();
			isDisplayed = true;
		}catch(Exception e){
			isDisplayed = false;
		}
		return isDisplayed;
	}
    
    public void selectCalenderDate(String date){   	
       // WebElement selectDate = getDriver().findElement(By.xpath("//form/div[2]/div[1]/div[5]/input"));
       // selectDate.click();
        
    	sleep(5000);
        //button to click in center of calendar header
        WebElement midLink = getDriver().findElement(By.xpath("//div[@class='datepick']//a[@class='datepick-cmd datepick-cmd-today ']"));

        //Split the date time to get only the date part
        String date_dd_MM_yyyy[] = (date.split(" ")[0]).split("/");
        sleep(5000);
        midLink.click();
        sleep(5000);
        WebElement yearDropdown = getDriver().findElement(By.xpath("//div[@class='datepick']//select[@class='datepick-month-year'][2]"));       
        yearDropdown.click();
        sleep(5000);
        List<WebElement> list_AllYears = driver.findElements(By.xpath("//div[@class='datepick']//select[@class='datepick-month-year'][2]/option"));
        
        
        for(int i=list_AllYears.size();i>=1;i--){
        	WebElement year = getDriver().findElement(By.xpath("//div[@class='datepick']//select[@class='datepick-month-year'][2]/option["+i+"]"));
        	//System.out.println(year.getText() + "----------"+ date_dd_MM_yyyy[2]);
        	if(year.getText().equals(date_dd_MM_yyyy[2])){
        		year.click();
        		break;
        	}
        }
        
        sleep(5000);
        
        WebElement monthDropdown = getDriver().findElement(By.xpath("//div[@class='datepick']//select[@class='datepick-month-year'][1]"));       
        monthDropdown.click();
        
        List<WebElement> list_AllMonths = driver.findElements(By.xpath("//div[@class='datepick']//select[@class='datepick-month-year'][1]/option"));
        
        
        for(int i=1;i<=list_AllMonths.size();i++){
        	WebElement month = getDriver().findElement(By.xpath("//div[@class='datepick']//select[@class='datepick-month-year'][1]/option["+i+"]"));        	
        	//System.out.println(String.valueOf(i) + "----------"+ Integer.valueOf(date_dd_MM_yyyy[0]).toString());        	
        	if(String.valueOf(i).equals(Integer.valueOf(date_dd_MM_yyyy[0]).toString())){
        		
        		month.click();
        	
        		break;
        	}
        }  

        sleep(2000);

        //get all dates from calendar to select correct one
        List<WebElement> list_AllMonthsRows = driver.findElements(By.xpath("//div[@class='datepick']//table//tbody/tr"));       
        boolean isBreak = false;
        for(int i=1;i<=list_AllMonthsRows.size();i++){
        	List<WebElement> list_AllMonthsCols = getDriver().findElements(By.xpath("//div[@class='datepick']//table//tbody/tr["+i+"]/td"));
        	
        	for(int j=1;j<=list_AllMonthsCols.size();j++){
            	WebElement dates = getDriver().findElement(By.xpath("//div[@class='datepick']//table//tbody/tr["+i+"]/td["+j+"]"));
            	
            	String dateValue = dates.getText();            	
            	if(dateValue.equals(" ") || dateValue.equals(null)){            	
            	
            	}else{
            		if(Integer.parseInt(dates.getText()) == Integer.parseInt(Integer.valueOf(date_dd_MM_yyyy[1]).toString())){
                		dates.click();
                		isBreak = true;
                		break;
                		
                	}
            	}          	
        	}
        	if(isBreak == true){
        		break;
        	}
        }        
        sleep(2000);
     }
   
    
    
    public String getTagValue(String xml, String tagName) {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        String valueReturns = null;
        try {
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            Document dDoc = builder.parse(new InputSource(new StringReader(xml)));

            XPath xPath = XPathFactory.newInstance().newXPath();
            NodeList nl = (NodeList) xPath.evaluate(tagName, dDoc, XPathConstants.NODESET);

            for (int i = 0; i < nl.getLength(); i++) {                
                valueReturns = nl.item(i).getFirstChild().getNodeValue();
            }
        } catch (Exception e) {
        	verifyTest("Faliure in getTagValue method",false);
            e.printStackTrace();
        }
        return valueReturns;
    }

	public String currentdateMmDdYyFormat()
	{
		/**
		 * create SimpleDateFormat Object to convert the date in particular string format
		 */
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date dt = new Date();

		/**
		 * format method is used to convert the date in MM/dd/yyyy format
		 */
		System.out.println("Date in MM/dd/yyyy format: "+df.format(dt));
		String currentDate = String.valueOf(df.format(dt));
		System.out.println("Date after: "+currentDate);
		return currentDate;

	}
	
	public String generateRandomNumber(int charLength) {
        return String.valueOf(charLength < 1 ? 0 : new Random()
                .nextInt((9 * (int) Math.pow(10, charLength - 1)) - 1)
                + (int) Math.pow(10, charLength - 1));
    }
	
	public void randomNameGenerator(){
   		try {
   			String fName = getExcelData().get("FNAME") + generateRandomNumber(3);
   			String lName = getExcelData().get("LNAME") + generateRandomNumber(3);
   			getExcelData().put("FNAME", fName);
   			getExcelData().put("LNAME", lName);   			
   		} catch (Exception e) {
   			e.printStackTrace();
   			verifyTest("Perform Docufree support docs: ltue() ", false);
   		}
   	}

	/**
	 * function to add or subtract no of days from current date
	 * @param noOfDays
	 * @return
	 * Example : String currentDt = addSubtractfromCurrentDate(-30);
     */

	public String addSubtractfromCurrentDate(int noOfDays)
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE,noOfDays);
		String currentDt = df.format(cal.getTime());
		return currentDt;

	}
	public String addSubtractfromCurrentDateNewFormat(int noOfDays) throws ParseException {
		DateFormat df = new SimpleDateFormat("dd-MMM-yy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE,noOfDays);
		String currentDt = df.format(cal.getTime());
		return currentDt;
	}

}
