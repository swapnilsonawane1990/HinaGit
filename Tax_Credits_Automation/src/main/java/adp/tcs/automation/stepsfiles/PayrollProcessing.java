package adp.tcs.automation.stepsfiles;

import adp.tcs.automation.utilities.OracleCon;
import org.apache.poi.ss.usermodel.Row;
import adp.tcs.automation.utilities.ExcelReaderWriter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import adp.tcs.automation.utilities.randomSSNgenrater;

import java.io.*;
import java.sql.CallableStatement;

import  java.sql.Statement;
import  java.sql.ResultSet;

/**
 * Created by DalviSid on 5/22/2017.
 */
public class PayrollProcessing extends BaseTempletSteps {
    public String workingDir = System.getProperty("user.dir");
    private randomSSNgenrater ssnGenerator = new randomSSNgenrater();
    private ExcelReaderWriter excelReaderWriter = new ExcelReaderWriter();

    public PayrollProcessing() throws IOException {
    }


    @Given("Insert hire record in DWHNEWHIRE table and execute ETL PLSQL")
    public void insertIntoDWH_NEWHIRE(@Named("ClientCode") String ClientCode,@Named("CompanyCode") String CompCode,@Named("UnitCode") String Unit ,@Named("Gave") String GaveDate,@Named("Offer") String OfferDate,@Named("Hire") String HireDate,@Named("Start") String StartDate )throws Exception
    {
        try{
            OracleCon con= new OracleCon();
           Statement stmt = con.getConnectionEvoApp().createStatement();
            String SSN = String.valueOf(ssnGenerator.generateSSN());
            String Query;

            getExcelData().put("SSN", SSN);
            getExcelData().put("CSSN", SSN);

            Query = "Insert into DWH_NEWHIRE (DWH_NEWHIRE_ID,NEW_HIRE_ID,CLIENT_CODE,COMPANY_CODE,UNIT_CODE,HIRE_SOURCE,SSN,WAGE,TITLE,GAVE_INFORMATION_DATE,JOB_OFFER_DATE,HIRE_DATE, START_DATE, EFFECTIVE_DATE, TRANSACTION_DATE) values (" ;
            Query = Query + "DWH_NEWHIRE_SEQ.NEXTVAL ,DWH_NEWHIRE_SEQ.NEXTVAL,'" +ClientCode +"','"+CompCode +"','"+Unit+"','Payroll','"+SSN+"','12','CSR'" ;


            if (GaveDate.equalsIgnoreCase("null"))
            {   Query = Query + ",null";
            }else
            {   String GaveDt = addSubtractfromCurrentDateNewFormat(Integer.valueOf(GaveDate));
                Query = Query + ",to_date('"+GaveDt+"','DD-MON-YY')";       }


            if (OfferDate.equalsIgnoreCase("null"))
            {   Query = Query + ",null";
            }else
            {   String OfferDt = addSubtractfromCurrentDateNewFormat(Integer.valueOf(OfferDate));
                Query = Query + ",to_date('"+OfferDt+"','DD-MON-YY')";       }

            if (HireDate.equalsIgnoreCase("null"))
            {   Query = Query + ",null";
            }else
            {   String HireDt = addSubtractfromCurrentDateNewFormat(Integer.valueOf(HireDate));
                Query = Query + ",to_date('"+HireDt+"','DD-MON-YY')";       }


            if (StartDate.equalsIgnoreCase("null"))
            {   Query = Query + ",null,SYSDATE,SYSDATE)";
            }else
            {   String StartDt = addSubtractfromCurrentDateNewFormat(Integer.valueOf(StartDate));
                Query = Query + ",to_date('"+StartDt+"','DD-MON-YY'),SYSDATE,SYSDATE)";    }

            stmt.executeUpdate(Query);
            con.getConnectionEvoApp().commit();

            CallableStatement cs =  con.getConnectionEvoApp().prepareCall("{call payroll_etl.run}");
            cs.execute();
            con.getConnectionEvoApp().commit();
            System.out.println("Payroll Data inserted for SSN  : " +SSN);
            System.out.println(Query);

            sleep(20000);

            FileInputStream fis = new FileInputStream(workingDir + "\\src\\test\\resources\\prerequisitecreation\\ScenarioToAutomateTest.xlsx" );
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheet("payroll");
            int RowCount = sheet.getLastRowNum();
            Row row = sheet.getRow(0);
            row.getCell(1).setCellValue(SSN);
            fis.close();
            FileOutputStream outFile =new FileOutputStream(new File(workingDir + "\\src\\test\\resources\\prerequisitecreation\\ScenarioToAutomateTest.xlsx"));
            wb.write(outFile);
            outFile.close();

        }catch (Exception e)
        {
            System.out.println("failed to insert into DWH_NEWHIRE");
            e.printStackTrace();
        }

    }

    @Given("Insert payroll for screening")
    public void insertPayroll() throws Exception {

        OracleCon con= new OracleCon();

        Statement stmt = con.getConnection().createStatement();
        FileInputStream fis = new FileInputStream(workingDir + "\\src\\test\\resources\\prerequisitecreation\\ScenarioToAutomateTest.xlsx" );
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet("payroll");
        int RowCount = sheet.getLastRowNum();
        String query;

        String SSN = String.valueOf(ssnGenerator.generateSSN());

        getExcelData().put("SSN", SSN);
        getExcelData().put("CSSN", SSN);

        query = "Insert into DWH_NEWHIRE (DWH_NEWHIRE_ID,NEW_HIRE_ID,CLIENT_CODE,COMPANY_CODE,UNIT_CODE,HIRE_SOURCE,SSN,WAGE,TITLE,GAVE_INFORMATION_DATE,JOB_OFFER_DATE,HIRE_DATE, START_DATE, EFFECTIVE_DATE, TRANSACTION_DATE) values (20,82,'" ;
        for(int i = 1 ;i < RowCount+1;i++)
        {
            Row row = sheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {

                //Print Excel data in console
                if (row.getCell(j).getCellType()==1)
                {
                    if (j==0)
                    {
                        query = query + row.getCell(j).getStringCellValue();
                    }
                    else {
                        query =query+ "','" + row.getCell(j).getStringCellValue();;
                    }

                }
                if (j == 6)
                {
                    query = query +"'";
                }
                if (j > 6)
                {
                    query = query +"," + "SYSDATE";
                }

            }

        }

        query = query +",SYSDATE,SYSDATE)";
        System. out.println("This is my query \n" +query);
        stmt.executeUpdate(query);
        con.getConnection().commit();

    }
    public void SelectQuery()throws Exception
    {
        OracleCon con= new OracleCon();

        String query = "select * from DWH_NEWHIRE";
        Statement stmt = con.getConnection().createStatement();

        // Execute the SQL Query. Store results in ResultSet
        ResultSet rs= stmt.executeQuery(query);

        // While Loop to iterate through all data and print results
        while (rs.next()){
            String myName = rs.getString(1);
            String myAge = rs.getString(2);
            System. out.println(myName+"  "+myAge);
        }
        // closing DB Connection
        con.getConnection().close();
        //con.getConnection().commit();
    }

}
