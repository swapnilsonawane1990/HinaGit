package adp.tcs.automation.runner;


import adp.tcs.automation.stepsfiles.BaseTempletSteps;
import adp.tcs.automation.stepsfiles.ReportSend;
import adp.tcs.automation.utilities.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.commons.lang.StringUtils;
import org.jbehave.core.io.StoryFinder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class AutomationRunnerJenkins {

    private static final String RUNTIME_ENV_PROPS_PARAM = "RUNTIME_ENVIRONMENT_PROPERTIES_FILE_PARAM";
    private static final String workingDir = System.getProperty("user.dir");
    private static final String stepsPath = workingDir + "\\src\\main\\java\\adp\\tcs\\automation\\StepsFiles\\";
    private static final String storyPath = workingDir + "\\src\\test\\resources\\stories\\";
    private static final String suitePath = workingDir + "\\src\\test\\resources\\suites\\";
    public static final String extendsReportPath = workingDir + "\\target\\ExtendsReport\\AutmationReport.html";
    private static final String customReportPath = workingDir + "\\test\\CustomReport\\AutmationReport.html";
    private static final String DEFAULT_ENV_PROPS = "iat";

    private static final BaseTempletSteps baseTempletSteps= new BaseTempletSteps();
    private static final DriverUtilities driverutil = new DriverUtilities();

    private static ExtentReports report;
    private static ExtentTest logger;

    /**
     * Non-public, non-default constructor, because this is considered a utility class.
     */
    protected AutomationRunnerJenkins() {
        super();
    }


    public static void main(String[] args) {

        System.out.println("Welcome to Jenkins AutomationRunner!!!");
        

        try {
            report=new ExtentReports(extendsReportPath);
            baseTempletSteps.setReport(report);
            
            String envPropertiesFile = getEnvarOrDefault(RUNTIME_ENV_PROPS_PARAM, DEFAULT_ENV_PROPS);

            baseTempletSteps.setEnvName(envPropertiesFile);
            String browser = (PropertiesUtilities.loadKeyValue("browserType"));
            BaseTempletSteps.setDriver(driverutil.setBrowser(browser));

            maximizeBrowser();           
           
            List<String> executableStoryFilePaths = null;
            if("SMOKE".equalsIgnoreCase(args[0]) || "SANITY".equalsIgnoreCase(args[0]) || "REGRESSION".equalsIgnoreCase(args[0])){
            	executableStoryFilePaths = readSuiteValues(storyPath, args[0]);
            }else{
            	executableStoryFilePaths = getStoryFilePathsPerArgList(storyPath, args);
            }

            List<String> fullyDelimitedStepsClassNames = getDelimitedClassNamesInSubDirectory(stepsPath, "");

            executeStories(executableStoryFilePaths, fullyDelimitedStepsClassNames);

        } catch (Exception e) {
            System.out.println("Exception in Runner"+ e);
        } finally {
            System.out.println("Automation run completed.");
            tearDown();
            System.exit(0);
        }
    }

    public static void maximizeBrowser() {
        baseTempletSteps.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        baseTempletSteps.getDriver().manage().deleteAllCookies();
        baseTempletSteps.getDriver().manage().window().maximize();
    }

    public static List<String> getPathsForUrl(String baseUrl, String pattern) {
        List<String> paths = new ArrayList<String>();
        paths = new StoryFinder().findPaths(baseUrl, pattern,"");
        return paths;
    }

    public static List<String> getDelimitedClassNamesInSubDirectory(String baseUrl, String subDirPattern) {
        List<String> delimitedClassNames = new ArrayList<String>();
        List<String> filePaths = getPathsForUrl(baseUrl, subDirPattern + "/*");
        for (String currentFilePath : filePaths) {
            String path = StringUtils.removeEnd(currentFilePath, ".java");
            delimitedClassNames.add(path.replace("/", "."));
        }
        return delimitedClassNames;
    }

    public static List<String> getStoryFilePathsPerArgList(String baseUrl, String... argList) {
        List<String> storyFileNames = getListPerDelimitedArray(argList);

        List<String> storyFilePaths = new ArrayList<String>();
        for (String currentStoryFileName : storyFileNames) {
            List<String> fullFileNameBasedStoryPaths = getPathsForUrl(baseUrl, "**/" + currentStoryFileName);
            storyFilePaths.addAll(fullFileNameBasedStoryPaths);

            List<String> partialFileNameBasedStoryPaths = getPathsForUrl(baseUrl, "**/*"
                    + currentStoryFileName + "*.story");
            storyFilePaths.addAll(partialFileNameBasedStoryPaths);

            List<String> directoryBasedStoryPaths = getPathsForUrl(baseUrl, "**/" + currentStoryFileName
                    + "/*");
            storyFilePaths.addAll(directoryBasedStoryPaths);
        }

        for (int i = 0; i < storyFilePaths.size(); i++) {
            if (!storyFilePaths.get(i).endsWith(".story")) {
                storyFilePaths.remove(i);
            }
            HashSet<String> hs = new HashSet<String>(storyFilePaths);
            List<String> deduplicatedList = new ArrayList<String>(hs);
            storyFilePaths = deduplicatedList;
        }
        return storyFilePaths;
    }

    private static List<String> getListPerDelimitedArray(String... stringArray) {
        List<String> splitList = new ArrayList<String>();
        for (String currentArg : stringArray) {
            String[] splitArgs;
            String[] splitNames = null;
            if (currentArg.contains(";")) {
                splitArgs = currentArg.split(";");
                splitNames =  new String[splitArgs.length];
                for(int i=0; i<splitArgs.length;i++){
                    String name = baseTempletSteps.getEnvName()+"/"+ splitArgs[i];
                    splitNames[i] = name;
                }
                splitList.addAll(Arrays.asList(splitNames));
            } else if (currentArg.contains(",")) {
                splitArgs = currentArg.split(",");

                splitNames =  new String[splitArgs.length];
                for(int i=0; i<splitArgs.length;i++){
                    String name = baseTempletSteps.getEnvName()+"/"+ splitArgs[i];
                    splitNames[i] = name;
                }
                splitList.addAll(Arrays.asList(splitNames));

            } else if (currentArg.contains(" ")) {
                splitArgs = currentArg.split(" ");
                splitNames =  new String[splitArgs.length];
                for(int i=0; i<splitArgs.length;i++){
                    String name = baseTempletSteps.getEnvName()+"/"+ splitArgs[i];
                    splitNames[i] = name;
                }
                splitList.addAll(Arrays.asList(splitNames));
            } else {
                splitList.add(baseTempletSteps.getEnvName()+"/"+currentArg);
            }
        }
        return splitList;
    }

    protected static void executeStories(List<String> stories, List<String> stepsClasses) {
        StoryEmbedder embedder = new StoryEmbedder();
        cleanupReportsFromPreviousRun();
        embedder.run(stories, stepsClasses);
    }


    public static String getEnvarOrDefault(String envarKey, String defaultValue) {
        Map<String, String> envars = System.getenv();
        String retrievedValue = envars.get(envarKey);
        if (retrievedValue != null && !("").equals(retrievedValue)) {
            return retrievedValue;
        } else {
            return defaultValue;
        }
    }

    public static String getEnvar(String envarKey, String defaultValue) {
        Map<String, String> envars = System.getenv();
        String retrievedValue = envars.get(envarKey);
        if (retrievedValue != null && !("").equals(retrievedValue)) {
            return retrievedValue;
        } else {
            return defaultValue;
        }
    }

    /**
     * Removes old report files, to avoid the presence of outdated, residual reports after a subsequent test
     * execution.
     */
    public static void cleanupReportsFromPreviousRun() {
        try {
            DeleteFilesAction.deleteScreenShot(baseTempletSteps.screenShotPath);
            DeleteFilesAction.deleteScreenShot(baseTempletSteps.deleteDownlaodFileLoc);
            DeleteFilesAction.deleteScreenShot(baseTempletSteps.unzipFilesLoc);
            DeleteFilesAction.deleteScreenShot(baseTempletSteps.jbehaveReportPath);
            DeleteFilesAction.deleteScreenShot(baseTempletSteps.jbehaveReport);
            DeleteFilesAction.deleteScreenShot(baseTempletSteps.movedFilesLoc);
            
            System.out.println("Deleted old reports");
        } catch (Exception e) {
            System.out.println("Unable to delete old reports" + e);
        }
    }

   protected static void tearDown() {   	
		report.flush();
    	baseTempletSteps.getDriver().quit();
    	GenerateTabularReport generateTabularReport = new GenerateTabularReport();
		generateTabularReport.generateReportFile(generateTabularReport.getReportData(),customReportPath);
    	ReportSend reportSend= new ReportSend();
		reportSend.send();
    }
   
   public static ArrayList<String> readSuiteValues(String filePath, String suiteName) {
   	List<String> storyList = new ArrayList<String>();
       
   	 try {
   		    FileReader reader = new FileReader(suitePath +"/"+suiteName);
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
 
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                storyList.add(baseTempletSteps.getEnvName()+"/"+line);
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }    
       
       return (ArrayList<String>) storyList;
   }
}