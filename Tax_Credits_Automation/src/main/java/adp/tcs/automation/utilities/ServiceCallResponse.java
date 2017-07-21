package adp.tcs.automation.utilities;

import adp.tcs.automation.stepsfiles.BaseTempletSteps;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import org.w3c.dom.CharacterData;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MultivaluedMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.List;

public class ServiceCallResponse extends BaseTempletSteps {

    private static String sResponse;
    private WebResource baseResourceFull;
    private Client restClient;

    private static final String GET_METHOD = "GET";
    private static final String POST_METHOD = "POST";
    private static final String PUT_METHOD = "PUT";
    private static final String DELETE_METHOD = "DELETE";
    private ClientResponse clientResponse;

    /**
     * Default constractor.
     */
    public ServiceCallResponse() {
        super();
        this.restClient = Client.create();
    }

    /**
     * Get the response.
     *
     * @return response
     */
    public static String getsResponse() {
        return sResponse;
    }

    /**
     * set the response.
     *
     * @param sResponse response
     */
    public static void setsResponse(String sResponse) {
        ServiceCallResponse.sResponse = sResponse;
    }


    public String getResponse(String baseUrl,String methodType, String requestMediaType, String responseMediaType, String cookies, String postData) {
        String tempResponse = null;
        WebResource.Builder builder;
        baseResourceFull = restClient.resource(baseUrl);

        if(cookies != ""){
            builder = baseResourceFull.getRequestBuilder().cookie(new Cookie(cookies.split("=")[0], cookies.split("=")[1]));
        }else{
            builder = baseResourceFull.getRequestBuilder();
        }
        switch (methodType) {

            case GET_METHOD:
                clientResponse = builder.accept(responseMediaType).get(ClientResponse.class);
                System.out.println("GET Request: {}"+ baseResourceFull.getURI());
                break;

            case PUT_METHOD:
                clientResponse = builder.type(requestMediaType).accept(responseMediaType)
                        .put(ClientResponse.class, postData);
                System.out.println("PUT Request: {}"+ baseResourceFull.getURI());
                System.out.println("PUT Data: {}"+ postData);
                break;

            case POST_METHOD:
                clientResponse = builder.type(requestMediaType).accept(responseMediaType)
                        .post(ClientResponse.class, postData);
                System.out.println("POST Request URL:  "+ baseResourceFull.getURI());
                System.out.println("POST Request Data: "+ postData);
                break;

            case DELETE_METHOD:
                clientResponse = builder.type(requestMediaType).accept(responseMediaType)
                        .delete(ClientResponse.class);
                System.out.println("DELETE Request: "+ baseResourceFull.getURI());

                break;

            default:
                tempResponse = "BAD METHOD";
        }

        tempResponse = clientResponse.getEntity(String.class);
        setsResponse(tempResponse);
        String responseInfo = "POST Response Data: " + getsResponse().toString();
        System.out.println(responseInfo);
        return tempResponse;

    }

    public String getResponseForDocufree(String baseUrl,String methodType, String requestMediaType, String responseMediaType, String cookies, String autorization, String postData) {
        String tempResponse = null;
        WebResource.Builder builder;
        baseResourceFull = restClient.resource(baseUrl);

        if(cookies != ""){
            builder = baseResourceFull.getRequestBuilder().cookie(new Cookie(cookies.split("=")[0], cookies.split("=")[1]));
        }else{
            builder = baseResourceFull.getRequestBuilder();
        }
        switch (methodType) {

            case GET_METHOD:
                clientResponse = builder.accept(responseMediaType).header("Authorization",autorization).get(ClientResponse.class);
                System.out.println("GET Request: {}"+ baseResourceFull.getURI());
                break;

            case PUT_METHOD:
                clientResponse = builder.type(requestMediaType).accept(responseMediaType).header("Authorization",autorization)
                        .put(ClientResponse.class, postData);
                System.out.println("PUT Request: {}"+ baseResourceFull.getURI());
                System.out.println("PUT Data: {}"+ postData);
                break;

            case POST_METHOD:
                clientResponse = builder.type(requestMediaType).accept(responseMediaType).header("Authorization",autorization)
                        .post(ClientResponse.class, postData);
                System.out.println("POST Request URL:  "+ baseResourceFull.getURI());
                System.out.println("POST Request Data: "+ postData);
                break;

            case DELETE_METHOD:
                clientResponse = builder.type(requestMediaType).accept(responseMediaType).header("Authorization",autorization)
                        .delete(ClientResponse.class);
                System.out.println("DELETE Request: "+ baseResourceFull.getURI());

                break;

            default:
                tempResponse = "BAD METHOD";
        }

        tempResponse = clientResponse.getEntity(String.class);
        setsResponse(tempResponse);
        String responseInfo = "POST Response Data: " + getsResponse().toString();
        System.out.println(responseInfo);
        return tempResponse;

    }


    public String getResponseResponceICIMS(String baseUrl,String methodType, String requestMediaType, String responseMediaType, String cookies, String autorization, String postData) throws Exception{
        String tempResponse = null;


        WebResource.Builder builder;
        // baseResourceFull = restClient.resource(baseUrl);

        ClientConfig config = new DefaultClientConfig();
        config.getProperties().put(ClientConfig.PROPERTY_FOLLOW_REDIRECTS, false);
        com.sun.jersey.api.client.Client restClient = Client.create(config);
        restClient.setFollowRedirects(false);
        baseResourceFull = restClient.resource(baseUrl);


        if(!cookies.equalsIgnoreCase("")){
            builder = baseResourceFull.getRequestBuilder().cookie(new Cookie(cookies.split("=")[0], cookies.split("=")[1]));
        }else{
            builder = baseResourceFull.getRequestBuilder();
        }
        switch (methodType) {

            case GET_METHOD:
                clientResponse = builder.accept(responseMediaType).header("Authorization",autorization).get(ClientResponse.class);
                System.out.println("GET Request: {}"+ baseResourceFull.getURI());
                break;

            case PUT_METHOD:
                clientResponse = builder.type(requestMediaType).accept(responseMediaType).header("Authorization",autorization)
                        .put(ClientResponse.class, postData);
                System.out.println("PUT Request: {}"+ baseResourceFull.getURI());
                System.out.println("PUT Data: {}"+ postData);
                break;

            case POST_METHOD:
                clientResponse = builder.type(requestMediaType).accept(responseMediaType).header("Authorization",autorization).post(ClientResponse.class, postData);
                System.out.println("clientResponse.getClient().getProperties:  "+ clientResponse.getClient().getProperties());
                System.out.println("clientResponse.getClient().getProperties:  "+ clientResponse.getMetadata());
                String redirectResponce = clientResponse.getMetadata().toString();
                List redirectResponc = clientResponse.getMetadata().get("Location");
                String screeningUrl = redirectResponc.toString().replace("[","").replace("]","");
                if (screeningUrl.equals("")) {
                    verifyTest("Invalid evo xml resonse : evoXmlSccreening() ", false);
                }
                getDriver().navigate().to(screeningUrl);
                sleep(2000);

                System.out.println("Extracted Screening URL is :  "+ screeningUrl);


                break;

            case DELETE_METHOD:
                clientResponse = builder.type(requestMediaType).accept(responseMediaType).header("Authorization",autorization)
                        .delete(ClientResponse.class);
                System.out.println("DELETE Request: "+ baseResourceFull.getURI());

                break;

            default:
                tempResponse = "BAD METHOD";
        }
        tempResponse = clientResponse.getEntity(String.class);
        setsResponse(tempResponse);
        String responseInfo = "POST Response Data: " + getsResponse().toString();
        System.out.println(responseInfo);

        return tempResponse;

    }

    public static String getCharacterDataFromElement(Element e) {
        Node child = e.getFirstChild();
        if (child instanceof CharacterData) {
            CharacterData cd = (CharacterData) child;
            return cd.getData();
        }
        return "";
    }


    public String getResponseResponceKronos(String baseUrl,String methodType, String requestMediaType, String responseMediaType, String cookies, String autorization, String postData) throws Exception{
        String tempResponse = null;


        WebResource.Builder builder;
        baseResourceFull = restClient.resource(baseUrl);


        if(!cookies.equalsIgnoreCase("")){
            builder = baseResourceFull.getRequestBuilder().cookie(new Cookie(cookies.split("=")[0], cookies.split("=")[1]));
        }else{
            builder = baseResourceFull.getRequestBuilder();
        }
        switch (methodType) {

            case GET_METHOD:
                clientResponse = builder.accept(responseMediaType).header("Authorization",autorization).get(ClientResponse.class);
                System.out.println("GET Request: {}"+ baseResourceFull.getURI());
                break;

            case PUT_METHOD:
                clientResponse = builder.type(requestMediaType).accept(responseMediaType).header("Authorization",autorization)
                        .put(ClientResponse.class, postData);
                System.out.println("PUT Request: {}"+ baseResourceFull.getURI());
                System.out.println("PUT Data: {}"+ postData);
                break;

            case POST_METHOD:
                clientResponse = builder.type(requestMediaType).accept(responseMediaType).header("Authorization",autorization).post(ClientResponse.class, postData);
                System.out.println("POST Request URL:  "+ baseResourceFull.getURI());
                System.out.println("POST Request Data: "+ postData);

                break;

            case DELETE_METHOD:
                clientResponse = builder.type(requestMediaType).accept(responseMediaType).header("Authorization",autorization)
                        .delete(ClientResponse.class);
                System.out.println("DELETE Request: "+ baseResourceFull.getURI());

                break;

            default:
                tempResponse = "BAD METHOD";
        }
        tempResponse = clientResponse.getEntity(String.class);
        setsResponse(tempResponse);
        String responseInfo = getsResponse().toString();
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(responseInfo));

        Document doc = db.parse(is);
        NodeList nodes = doc.getElementsByTagName("AccessPoint");

        for (int i = 0; i < nodes.getLength(); i++) {
            Element element = (Element) nodes.item(i);

            NodeList name = element.getElementsByTagName("InternetWebAddress");
            Element line = (Element) name.item(0);
            System.out.println("Internet Web Address : " + getCharacterDataFromElement(line));

            if (getCharacterDataFromElement(line).equals("")) {
                verifyTest("Invalid evo xml resonse : evoXmlSccreening() ", false);
            }
            getDriver().navigate().to(getCharacterDataFromElement(line));
            sleep(2000);
//            NodeList title = element.getElementsByTagName("title");
//            line = (Element) title.item(0);
//            System.out.println("Title: " + getCharacterDataFromElement(line));
            System.out.println("POST Response Data: " + responseInfo);
        }
        return tempResponse;

    }

    public String getResponseResponceTaleo(String baseUrl,String methodType, String requestMediaType, String responseMediaType, String cookies, String autorization, String postData) {
        String tempResponse = null;


        WebResource.Builder builder;
        baseResourceFull = restClient.resource(baseUrl);

        ClientConfig config = new DefaultClientConfig();
        config.getProperties().put(ClientConfig.PROPERTY_FOLLOW_REDIRECTS, false);
        restClient = Client.create(config);
        restClient.setFollowRedirects(false);
        baseResourceFull = restClient.resource(baseUrl);


        if(!cookies.equalsIgnoreCase("")){
            builder = baseResourceFull.getRequestBuilder().cookie(new Cookie(cookies.split("=")[0], cookies.split("=")[1]));
        }else{
            builder = baseResourceFull.getRequestBuilder();
        }
        switch (methodType) {

            case GET_METHOD:
//                clientResponse = builder.accept(responseMediaType).header("Authorization",autorization).get(ClientResponse.class);
//                System.out.println("GET Request: {}"+ baseResourceFull.getURI());
//                System.out.println("clientResponse.getClient().getProperties:  "+ clientResponse.getClient().getProperties());
//                System.out.println("clientResponse.getClient().getProperties:  "+ clientResponse.getMetadata());
//                String gredirectResponce = clientResponse.getMetadata().toString();
//                List gredirectResponc = clientResponse.getMetadata().get("Location");
//                String gscreeningUrl = gredirectResponc.toString().replace("[","").replace("]","");
//                if (gscreeningUrl.equals("")) {
//                    verifyTest("Invalid Taleo response : TaleoSccreening() ", false);
//                }
//                getDriver().navigate().to(gscreeningUrl);
//                sleep(2000);
//
//                System.out.println("Extracted Screening URL is :  "+ gscreeningUrl);



                //    restClient = Client.create();
                //  baseResourceFull = restClient.resource(baseUrl);
                MultivaluedMap<String, String> queryParams;
                queryParams = new MultivaluedMapImpl();
                //queryParams.add("{filters","keyword:abc");
                clientResponse = baseResourceFull.queryParams(queryParams).header("Content-Type", "application/json;charset=UTF-8").get(ClientResponse.class);
                System.out.println("Response Code = "+clientResponse.getStatus());
                String outputFilter = clientResponse.getEntity(String.class);
                System.out.println("Response Code = " + outputFilter);

                System.out.println("clientResponse.getClient().getProperties:  "+ clientResponse.getClient().getProperties());
                System.out.println("clientResponse.getClient().getProperties:  "+ clientResponse.getMetadata());
                String redirectResponceOne = clientResponse.getMetadata().toString();
                List redirectResponcOne = clientResponse.getMetadata().get("Location");
                String screeningUrlOne = redirectResponcOne.toString().replace("[","").replace("]","");
                if (screeningUrlOne.equals("")) {
                    verifyTest("Invalid Taleo response : TaleoSccreening() ", false);
                }
                getDriver().navigate().to(screeningUrlOne);
                sleep(2000);

                System.out.println("Extracted Screening URL is :  "+ screeningUrlOne);




                break;

            case PUT_METHOD:
                clientResponse = builder.type(requestMediaType).accept(responseMediaType).header("Authorization",autorization)
                        .put(ClientResponse.class, postData);
                System.out.println("PUT Request: {}"+ baseResourceFull.getURI());
                System.out.println("PUT Data: {}"+ postData);
                break;

            case POST_METHOD:
                clientResponse = builder.type(requestMediaType).accept(responseMediaType).header("Authorization",autorization).post(ClientResponse.class, postData);
                System.out.println("clientResponse.getClient().getProperties:  "+ clientResponse.getClient().getProperties());
                System.out.println("clientResponse.getClient().getProperties:  "+ clientResponse.getMetadata());
                String redirectResponce = clientResponse.getMetadata().toString();
                List redirectResponc = clientResponse.getMetadata().get("Location");
                String screeningUrl = redirectResponc.toString().replace("[","").replace("]","");
                if (screeningUrl.equals("")) {
                    verifyTest("Invalid evo xml resonse : evoXmlSccreening() ", false);
                }
                getDriver().navigate().to(screeningUrl);
                sleep(2000);

                System.out.println("Extracted Screening URL is :  "+ screeningUrl);

                break;

            case DELETE_METHOD:
                clientResponse = builder.type(requestMediaType).accept(responseMediaType).header("Authorization",autorization)
                        .delete(ClientResponse.class);
                System.out.println("DELETE Request: "+ baseResourceFull.getURI());

                break;

            default:
                tempResponse = "BAD METHOD";
        }
        tempResponse = clientResponse.getEntity(String.class);
        setsResponse(tempResponse);
        String responseInfo = "POST Response Data: " + getsResponse().toString();
        System.out.println(responseInfo);

        return tempResponse;

    }

    public String getResponseForMarketPlaceAPIUsingDifferentHost(String baseUrl,String methodType, String requestMediaType, String responseMediaType, String cookies, String associateoid,String orgoid,String realm, String postData)
    {

        String tempResponse = null;
        WebResource.Builder builder;
        baseResourceFull = restClient.resource(baseUrl);

        if(cookies != ""){
            builder = baseResourceFull.getRequestBuilder().cookie(new Cookie(cookies.split("=")[0], cookies.split("=")[1]));
        }else{
            builder = baseResourceFull.getRequestBuilder();
        }


        switch (methodType) {

            case GET_METHOD:
                clientResponse = builder.accept(responseMediaType).header("associateoid",associateoid).header("orgoid", orgoid).header("realm", realm)
                        .get(ClientResponse.class);
                System.out.println("GET Request: {}"+ baseResourceFull.getURI());
                break;

            case PUT_METHOD:
                clientResponse = builder.type(requestMediaType).accept(responseMediaType).header("associateoid",associateoid).header("orgoid", orgoid).header("realm", realm)
                        .put(ClientResponse.class, postData);
                System.out.println("PUT Request: {}"+ baseResourceFull.getURI());
                System.out.println("PUT Data: {}"+ postData);
                break;

            case POST_METHOD:
                clientResponse = builder.type(requestMediaType).accept(responseMediaType).header("associateoid",associateoid).header("orgoid", orgoid).header("realm", realm)
                        .post(ClientResponse.class, postData);
                System.out.println("POST Request URL:  "+ baseResourceFull.getURI());
                System.out.println("POST Request Data: "+ postData);
                break;

            case DELETE_METHOD:
                clientResponse = builder.type(requestMediaType).accept(responseMediaType).header("associateoid",associateoid).header("orgoid", orgoid).header("realm", realm)
                        .delete(ClientResponse.class);
                System.out.println("DELETE Request: "+ baseResourceFull.getURI());

                break;

            default:
                tempResponse = "BAD METHOD";
        }

        tempResponse = clientResponse.getEntity(String.class);
        setsResponse(tempResponse);
        String responseInfo = "POST Response Data: " + getsResponse().toString();
        System.out.println(responseInfo);
        return tempResponse;
    }



    public String getResponseForMarketPlaceAPI(String baseUrl,String methodType, String requestMediaType, String responseMediaType,String authorization, String postData) {

//				TrustManager[] trustAllCerts = new TrustManager[][]{new X509TrustManager(){
//					public X509Certificate[] getAcceptedIssuers(){return null;}
//					public void checkClientTrusted(X509Certificate[] certs, String authType){}
//					public void checkServerTrusted(X509Certificate[] certs, String authType){}
//				}};

        // Install the all-trusting trust manager
//				try {
//					SSLContext sc = SSLContext.getInstance("SSL");
//					sc.init(null, trustAllCerts, new SecureRandom());
//					HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
//				} catch (Exception e) {
//					;
//				}

//        		System.setProperty("javax.net.ssl.trustStore", "taxcredits_cdl_auth.pfx");
//        		System.setProperty("javax.net.ssl.trustStorePassword", "welcom1");

//
//        System.setProperty("javax.net.ssl.keyStore", "taxcredits_cdl_auth.pem");
//        System.setProperty("javax.net.ssl.keyStorePassword", "welcom1");
//        System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");


//        System.setProperty("javax.net.ssl.trustStore", "C:\\Program Files\\Java\\jre7\\lib\\security\\cacerts");
//        System.setProperty("javax.net.ssl.trustStorePassword", "bhutesac");
//        System.setProperty("javax.net.ssl.trustStoreType", "JKS");
//
        //my certificate and password
        System.setProperty("javax.net.ssl.keyStore", "C:\\Users\\bhutesac\\clientcert.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "welcom1");
        System.setProperty("javax.net.ssl.keyStoreType", "JKS");

        System.setProperty("javax.net.ssl.trustStore", "C:\\Users\\bhutesac\\clientcert.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "welcom1");




        String tempResponse = null;
        WebResource.Builder builder = null;
        baseResourceFull = restClient.resource(baseUrl);

        //if(cookies != ""){
        //	builder = baseResourceFull.getRequestBuilder().cookie(new Cookie(cookies.split("=")[0], cookies.split("=")[1]));
        //}else{
        builder = baseResourceFull.getRequestBuilder();
        //}


        switch (methodType) {

            case GET_METHOD:
                clientResponse = builder.accept(responseMediaType).header("Authorization",authorization)
                        .get(ClientResponse.class);
                System.out.println("GET Request: {}"+ baseResourceFull.getURI());
                break;

            case PUT_METHOD:
                clientResponse = builder.type(requestMediaType).accept(responseMediaType).header("Authorization",authorization)
                        .put(ClientResponse.class, postData);
                System.out.println("PUT Request: {}"+ baseResourceFull.getURI());
                System.out.println("PUT Data: {}"+ postData);
                break;

            case POST_METHOD:
                clientResponse = builder.type(requestMediaType).accept(responseMediaType).header("Authorization",authorization)
                        .post(ClientResponse.class, postData);
                System.out.println("POST Request URL:  "+ baseResourceFull.getURI());
                System.out.println("POST Request Data: "+ postData);
                break;

            case DELETE_METHOD:
                clientResponse = builder.type(requestMediaType).accept(responseMediaType).header("Authorization",authorization)
                        .delete(ClientResponse.class);
                System.out.println("DELETE Request: "+ baseResourceFull.getURI());

                break;

            default:
                tempResponse = "BAD METHOD";
        }

        tempResponse = clientResponse.getEntity(String.class);
        setsResponse(tempResponse);
        String responseInfo = "POST Response Data: " + getsResponse().toString();
        System.out.println(responseInfo);
        return tempResponse;
    }


    public String getResponseForMarketPlaceAPIGetCall(String baseUrl,String methodType, String requestMediaType, String responseMediaType,String authorization, String postData)
    {
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
            public X509Certificate[] getAcceptedIssuers(){return null;}
            public void checkClientTrusted(X509Certificate[] certs, String authType){}
            public void checkServerTrusted(X509Certificate[] certs, String authType){}
        }};

        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            ;
        }

        String tempResponse = null;
        WebResource.Builder builder = null;
        baseResourceFull = restClient.resource(baseUrl);

        builder = baseResourceFull.getRequestBuilder();



        switch (methodType) {

            case GET_METHOD:
                clientResponse = builder.accept(responseMediaType).header("Authorization",authorization)
                        .get(ClientResponse.class);
                System.out.println("GET Request: {}"+ baseResourceFull.getURI());
                break;

            case PUT_METHOD:
                clientResponse = builder.type(requestMediaType).accept(responseMediaType).header("Authorization",authorization)
                        .put(ClientResponse.class, postData);
                System.out.println("PUT Request: {}"+ baseResourceFull.getURI());
                System.out.println("PUT Data: {}"+ postData);
                break;

            case POST_METHOD:
                clientResponse = builder.type(requestMediaType).accept(responseMediaType).header("Authorization",authorization)
                        .post(ClientResponse.class, postData);
                System.out.println("POST Request URL:  "+ baseResourceFull.getURI());
                System.out.println("POST Request Data: "+ postData);
                break;

            case DELETE_METHOD:
                clientResponse = builder.type(requestMediaType).accept(responseMediaType).header("Authorization",authorization)
                        .delete(ClientResponse.class);
                System.out.println("DELETE Request: "+ baseResourceFull.getURI());

                break;

            default:
                tempResponse = "BAD METHOD";
        }

        tempResponse = clientResponse.getEntity(String.class);
        setsResponse(tempResponse);
        String responseInfo = "POST Response Data: " + getsResponse().toString();
        System.out.println(responseInfo);
        return tempResponse;
    }



    public String getResponseResponceTLS(String baseUrl,String methodType, String requestMediaType, String responseMediaType, String cookies, String autorization, String postData) throws Exception{
        String tempResponse = null;


        WebResource.Builder builder;
        baseResourceFull = restClient.resource(baseUrl);


        if(!cookies.equalsIgnoreCase("")){
            builder = baseResourceFull.getRequestBuilder().cookie(new Cookie(cookies.split("=")[0], cookies.split("=")[1]));
        }else{
            builder = baseResourceFull.getRequestBuilder();
        }
        switch (methodType) {

            case GET_METHOD:
                clientResponse = builder.accept(responseMediaType).header("Authorization",autorization).get(ClientResponse.class);
                System.out.println("GET Request: {}"+ baseResourceFull.getURI());
                break;

            case PUT_METHOD:
                clientResponse = builder.type(requestMediaType).accept(responseMediaType).header("Authorization",autorization)
                        .put(ClientResponse.class, postData);
                System.out.println("PUT Request: {}"+ baseResourceFull.getURI());
                System.out.println("PUT Data: {}"+ postData);
                break;

            case POST_METHOD:
                clientResponse = builder.type(requestMediaType).accept(responseMediaType).header("Authorization",autorization).post(ClientResponse.class, postData);
                System.out.println("POST Request URL:  "+ baseResourceFull.getURI());
                System.out.println("POST Request Data: "+ postData);

                break;

            case DELETE_METHOD:
                clientResponse = builder.type(requestMediaType).accept(responseMediaType).header("Authorization",autorization)
                        .delete(ClientResponse.class);
                System.out.println("DELETE Request: "+ baseResourceFull.getURI());

                break;

            default:
                tempResponse = "BAD METHOD";
        }
        tempResponse = clientResponse.getEntity(String.class);
        setsResponse(tempResponse);
        String responseInfo = getsResponse().toString();
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(responseInfo));

        Document doc = db.parse(is);
        NodeList nodes = doc.getElementsByTagName("id");
        System.out.println("TEST1 "+ nodes);

        for (int i = 0; i < nodes.getLength(); i++) {
            Element element = (Element) nodes.item(i);

            NodeList name = element.getElementsByTagName("url");
            System.out.println("TEST2 "+ name);
            Element line = (Element) name.item(0);
            System.out.println("Internet Web Address : " + getCharacterDataFromElement(line));

            if (getCharacterDataFromElement(line).equals("")) {
                verifyTest("Invalid evo xml resonse : evoXmlSccreening() ", false);
            }
            getDriver().navigate().to(getCharacterDataFromElement(line));
            sleep(2000);
//            NodeList title = element.getElementsByTagName("title");
//            line = (Element) title.item(0);
//            System.out.println("Title: " + getCharacterDataFromElement(line));
            System.out.println("POST Response Data: " + responseInfo);
        }
        return tempResponse;

    }

}
