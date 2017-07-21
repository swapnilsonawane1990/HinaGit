package adp.tcs.automation.stepsfiles;

import adp.tcs.automation.utilities.ServiceCallResponse;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Iterator;

public class MarketPlaceAPIRestSteps extends BaseTempletSteps {
	private final ServiceCallResponse callResponse = new ServiceCallResponse();
	private final MarketPlaceAPIRequest inRequests= new MarketPlaceAPIRequest();
	private String requestContentType = "application/json";
	private String responseContentType = "";

	private String response = null;
	private String webINScreeningURL = null;
	private String APIScreeningURL = null;
	private String accessToken=null;
	public static void main(String[] args)
	{
		MarketPlaceAPIRestSteps ref =new MarketPlaceAPIRestSteps();
		ref.marketPlaceAPI_Get_Token();
		ref.marketPlaceAPIHandshake();
		//ref.marketPlaceAPI_webInScreening();
		//ref.marketPlaceAPI_APIScreening();


	}


	public void marketPlaceAPIHandshakeUsingDiffrentHost()
	{ 	String baseUrl="http://apimpiat.gslb.es.oneadp.com/events/tax/v1/tax-credit-screening.initiate";
		String requestMethodType="POST";

		String cookies="";
		String associateoid="G3Z2W40JVCVR83NV";
		String orgoid="G3Z2W40JVCVRPXWC";
		String realm="ISI";

		String env="iat";

		if (env.equalsIgnoreCase("prod")) {
			//response=callResponse.getResponseForDocufree(baseUrl, requestMethodType, requestContentType, responseContentType, cookies, associateoid,orgoid,realm, inRequests.handshakeAPI());
		} else {
			response=callResponse.getResponseForMarketPlaceAPIUsingDifferentHost(baseUrl, requestMethodType, requestContentType, responseContentType, cookies, associateoid,orgoid,realm, inRequests.handshakeAPI());


			webINScreeningURL=(getJsonValue("events.links.href"));
			System.out.println(webINScreeningURL);


			APIScreeningURL=(getJsonValue("events.actions.links.href"));
			System.out.println(APIScreeningURL);
		}



	}

	public void marketPlaceAPI_Get_Token()
	{ 	String baseUrl="https://iat-api.adp.com/auth/oauth/v2/token";
		String requestMethodType="POST";
		requestContentType="application/x-www-form-urlencoded";

		String authorization="";
		String env="iat";


		response=callResponse.getResponseForMarketPlaceAPIGetCall(baseUrl, requestMethodType, requestContentType, responseContentType,authorization, inRequests.getTokenAPI());

		accessToken=(getJsonValue("access_token"));
		System.out.println(accessToken);


	}
	public void marketPlaceAPIHandshake()
	{ 	String baseUrl="https://iat-api.adp.com/tax/v1/tax-credit-screening.initiate";
		String requestMethodType="POST";

		String authorization="Bearer "+accessToken;

		String env="iat";


		response=callResponse.getResponseForMarketPlaceAPI(baseUrl, requestMethodType, requestContentType, responseContentType, authorization, inRequests.handshakeAPI());


		webINScreeningURL=(getJsonValue("events.links.href"));
		System.out.println(webINScreeningURL);


		APIScreeningURL=(getJsonValue("events.actions.links.href"));
		System.out.println(APIScreeningURL);

	}

	public String getJsonValue(String path)
	{

		String[] elements =path.split("\\.");
		for (int m = 0; m < elements.length; m++) {

			JSONParser parser = new JSONParser();

			try{
				Object obj = parser.parse(response);
				JSONObject jsonObject = (JSONObject) obj;
				if (m+1 < elements.length)
				{
					JSONArray events = (JSONArray) jsonObject.get(elements[m]);
					Iterator i = events.iterator();
					while (i.hasNext())
					{
						JSONObject properties = (JSONObject) i.next();
						if (m+2 < elements.length)
						{
							JSONArray Content = (JSONArray) properties.get(elements[m+1]);
							Iterator j = Content.iterator();
							while (j.hasNext())
							{
								JSONObject sub_properties = (JSONObject) j.next();

								if (m+3 < elements.length)
								{
									JSONArray insideContent = (JSONArray) sub_properties.get(elements[m+2]);
									Iterator k = insideContent.iterator();
									while (k.hasNext())
									{
										JSONObject sub_insideContent = (JSONObject) k.next();
										return (String) sub_insideContent.get(elements[m+3]);
									}
								}

								return (String) sub_properties.get(elements[m+2]);
							}
						}
						return (String) properties.get(elements[m+1]);
					}

				}
				return (String) jsonObject.get(elements[m]);
			}
			catch(ParseException pe){

				System.out.println("position: " + pe.getPosition());
				System.out.println(pe);
			}

		}
		return null;


	}

	@When ("User perform screening for Mareket Place API using Webin")
	public void marketPlaceAPI_webInScreening()
	{
		System.out.println("Started screening form Mareket Place API using Webin");

		try {
			//verifyTest("Perform Market Place API Handshake through API");
			marketPlaceAPIHandshake();

			if (webINScreeningURL.equals("")) {
				verifyTest("Invalid Market Place API Resonse : marketPlaceAPI_webInScreening() ", false);
			}
			getDriver().navigate().to(webINScreeningURL);
			sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
			verifyTest("Perform Market Place API Handshake through API: marketPlaceAPI_webInScreening() ", false);
		}

	}
	@Given("User perform screening for Mareket Place API using Screening API")
	public void marketPlaceAPI_APIScreening()
	{
		System.out.println("Started screening form Mareket Place API using Screening API");
		try {
			//verifyTest("Perform Market Place API Handshake through API");
			marketPlaceAPIHandshake();

			if (APIScreeningURL.equals("")) {
				verifyTest("Invalid Market Place API Resonse : marketPlaceAPI_APIScreening() ", false);
			}
			getDriver().navigate().to(APIScreeningURL);
			sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
			verifyTest("Perform Market Place API Handshake through API: marketPlaceAPI_APIScreening() ", false);
		}
	}


}
