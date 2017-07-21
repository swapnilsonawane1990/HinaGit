package adp.tcs.automation.stepsfiles;

import adp.tcs.automation.utilities.ServiceCallResponse;
import org.jbehave.core.annotations.Given;

/**
 * Created by BhuteSac on 2/2/2017.
 */
public class PartnerScreeening extends BaseTempletSteps{
    final ServiceCallResponse callResponse = new ServiceCallResponse();
    final MarketPlaceAPIRequest inRequests = new MarketPlaceAPIRequest();
    String requestContentType = "application/json";
    String responseContentType = "";

    private String response = null;
    private String webINScreeningURL = null;
    private String APIScreeningURL = null;
    private String accessToken = null;

    public static void main(String[] args) {
        PartnerScreeening ref = new PartnerScreeening();
        //ref.partnerscreeningKronos();

    }
@Given("Verify iCIMIS Partner screening")
    public void partnerscreeningICIMS() throws Exception {
    String requestMethodType= "POST";

        response = callResponse.getResponseResponceICIMS(loadPropValues("icimsBaseUrl"), requestMethodType, "application/xml", responseContentType, loadPropValues("cookies"), loadPropValues("icimisauthorization"), inRequests.handshakeICIMS());
}

    @Given("Verify Taleo TBE Partner screening")
    public void partnerscreeningTele0TBE() throws Exception {
        String requestMethodType = "GET";
        response = callResponse.getResponseResponceTaleo(loadPropValues("taleoBaseUrl"), requestMethodType, requestContentType, responseContentType, loadPropValues("cookies"), loadPropValues("taleoauthorization"), "");
       // response = callResponse.getResponseResponceTaleo("https://stage.tcs.adp.com/xml/handshake_json?candidate_id=132&authCode=YWRwdGF4OmxqaHVqaGZscG5CRmZiaGo7dGFsZW86RmR1ZmJibkhhY29rbXRobQ==&baseUrl=taleo", "GET", "", "", "", "", "");
System.out.println("Responce is : "+response);
    }

    @Given("Verify Kronos Partner screening")
    public void partnerscreeningKronos() throws Exception{
        String requestMethodType= "POST";
        if(getEnvName().equalsIgnoreCase("production"))
        {
            response = callResponse.getResponseResponceKronos(loadPropValues("KronosBaseUrl"), requestMethodType, "application/xml", responseContentType, loadPropValues("cookies"), loadPropValues("Kronosauthorization"), inRequests.handshakeKronosProd());
            System.out.println("Responce is :" + response.toString());
        }else {
            if (getEnvName().equalsIgnoreCase("iat")){
//iat request
                response = callResponse.getResponseResponceKronos(loadPropValues("KronosBaseUrl"), requestMethodType, "application/xml", responseContentType, loadPropValues("cookies"), loadPropValues("Kronosauthorization"), inRequests.handshakeKronos());
                System.out.println("Responce is :" + response.toString());
        }
            else{
                response = callResponse.getResponseResponceKronos(loadPropValues("KronosBaseUrl"), requestMethodType, "application/xml", responseContentType, loadPropValues("cookies"), loadPropValues("Kronosauthorization"), inRequests.handshakeKronosfit2());
                System.out.println("Responce is :" + response.toString());
            }
    }}


    @Given("Verify iCIMIS Partner screening TLS")
    public void partnerscreeningtestingTLS() throws Exception {
        String requestMethodType= "POST";

        response = callResponse.getResponseResponceTLS("https://stage.tcs.adp.com/xml/handshake_xml", requestMethodType, "application/xml", responseContentType, loadPropValues("cookies"), loadPropValues("Kronosauthorization"), handshakeTLS());
        System.out.println("Responce is :" + response.toString());
    }


    public String handshakeTLS()
    {
        String firstRequest = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<Handshake  company=\"jmcompiat\" auth=\"ljhujhflpnBFfbhj\" partner_auth=\"wpfhiwVExefluvdl\" partner_id=\"avionte\">\n" +
                "               <PartnerInfo>\n" +
                "                              <info id=\"transaction_id\" value=\"745\"/>\n" +
                "                              <info id=\"redirect_url\" value=\"\"/>\n" +
                "                              <info id=\"recipient_url\" value=\"https://ems.aviontego.com/portals/portals/applicant/WOTCComplete.aspx?status=completed\"/>\n" +
                "                              <info id=\"partner_uid\" value=\"partner_uid_test\"/>\n" +
                "               </PartnerInfo>\n" +
                "               <PersonalInfo>\n" +
                "                              <info id=\"zip\" value=\"37920\"/>\n" +
                "                              <info id=\"street address\" value=\"2334 Peachtree St\"/>\n" +
                "                              <info id=\"city\" value=\"KNOXVILLE\"/>\n" +
                "                              <info id=\"state\" value=\"TN\"/>\n" +
                "                              <info id=\"unit\" value=\"Unit 1\"/>\n" +
                "                              <info id=\"ssn\" value=\"\"/>\n" +
                "                              <info id=\"prev empl\" value=\"NO\"/>\n" +
                "                              <info id=\"first name\" value=\"Mary\"/>\n" +
                "                              <info id=\"middle name\" value=\"H\"/>\n" +
                "                              <info id=\"last name\" value=\"Smith\"/>\n" +
                "                              <info id=\"SSI_IWP_esign_email\" value=\"mary.smith@dummycompany.com\"/>\n" +
                "                              <info id=\"telephone\" value=\"7324567890\"/>\n" +
                "               </PersonalInfo>\n" +
                "</Handshake>\n";

        return firstRequest;

    }
}
