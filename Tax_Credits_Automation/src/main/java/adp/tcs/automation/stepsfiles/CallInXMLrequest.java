package adp.tcs.automation.stepsfiles;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bhutesac on 9/30/2016.
 */
public class CallInXMLrequest extends BaseTempletSteps{


    //new String[]
    // Dictionary.get("IVR_CODE"), Dictionary.get("YOUR_ID"), Dictionary.get("EXT")

    private String dateRef = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
    private String timeRef = new SimpleDateFormat("HH:mm:ss").format(new Date());
   // private String timeRef = new SimpleDateFormat("HH:mm:ss").format(new Date());

    // call in IVR Xml Request
    public String callInScreeningXmlRequest() {
        final String confirmationScreeningXmlRequest = "<?xml version='1.0' encoding='UTF-8'?><ivrcall><method>CallTransfer</method><dateref>"+dateRef+"</dateref><timeref>"+timeRef+"</timeref><din>109375</din><yourid>3453400343</yourid><extension>0081</extension><why>CompanyNotFound/Press0</why></ivrcall>";
        System.out.println("Request for Call Transfer ivr : " + confirmationScreeningXmlRequest);
        return confirmationScreeningXmlRequest;
    }

    //CALL IN FULL IVR

    // call in IVR Xml Request
    public String callInFullIVRXmlRequest() {
        final String confirmationScreeningXmlRequest = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><ivrcall>\n" +
                "  <method>CallTransfer</method>\n" +
                "  <dateref>"+dateRef+"</dateref>\n" +
                "  <timeref>"+timeRef+"</timeref>\n" +
                "  <din>109375</din>\n" +
                "  <yourid>"+getExcelData().get("YOUR_ID")+"+</yourid>\n" +
                "  <compcode>"+getExcelData().get("COMP_CODE")+"</compcode>\n" +
                "  <zipcode>"+getExcelData().get("ZIP_CODE")+"</zipcode>\n" +
                "  <ssn>"+getExcelData().get("SSN")+"</ssn>\n" +
                "  <extension>"+getExcelData().get("EXTENSION_NUMBER")+"</extension>\n" +
                "  <under25>NO</under25>\n" +
                "  <Q1>"+getExcelData().get("Q1_CALLIN")+"</Q1>\n" +
                "  <Q2>"+getExcelData().get("Q2_CALLIN")+"</Q2>\n" +
                "  <Q3>"+getExcelData().get("Q3_CALLIN")+"</Q3>\n" +
                "  <Q4>"+getExcelData().get("Q4_CALLIN")+"</Q4>\n" +
                "  <Q5>"+getExcelData().get("Q5_CALLIN")+"</Q5>\n" +
                " <Q6>"+getExcelData().get("Q6_CALLIN")+"</Q6>\n" +
                "  <why>Q4YES</why>\n" +
                "  <DISYOUTH_DIPLOMA>"+getExcelData().get("EXTENSION_NUMBER")+"</DISYOUTH_DIPLOMA>\n" +
                "  <DISYOUTH_SCHOOL>"+getExcelData().get("EXTENSION_NUMBER")+"</DISYOUTH_SCHOOL>\n" +
                "  <DY_DIPLOMA_WHEN/>\n" +
                "  <QualifyReason/>\n" +
                "</ivrcall>";

        System.out.println("Request for full ivr : " + confirmationScreeningXmlRequest);
        return confirmationScreeningXmlRequest;
    }

    // call in IVR Xml Request
    public String callInSetEsign() {
        final String confirmationScreeningXmlRequest = "<?xml version=\"1.0\" encoding=\"iso-8859-1\" ?>\n" +
                "<ivrcall>\n" +
                "   <method>setEsignResponse</method>\n" +
                "   <dateref>"+dateRef+"</dateref>\n" +
                "   <timeref>"+timeRef+"</timeref>\n" +
                "   <din>109375</din>\n" +
                "   <yourid>"+getExcelData().get("YOUR_ID")+"</yourid>\n" +
                "   <extension>"+getExcelData().get("EXTENSION_NUMBER")+"</extension>\n" +
                "   <interactionid>1607306101481</interactionid>\n" +
                "   <esign>"+getExcelData().get("ESIGN")+"</esign>\n" +
                "   <esign_pin>"+getExcelData().get("WOTC_PIN")+"</esign_pin>\n" +
                "</ivrcall>";

        System.out.println("Request for full ivr : " + confirmationScreeningXmlRequest);
        return confirmationScreeningXmlRequest;
    }
}
