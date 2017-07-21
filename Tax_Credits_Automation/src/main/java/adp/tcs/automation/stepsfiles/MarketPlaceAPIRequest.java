package adp.tcs.automation.stepsfiles;

import adp.tcs.automation.utilities.randomSSNgenrater;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MarketPlaceAPIRequest extends BaseTempletSteps
{
	randomSSNgenrater ssnGenerator = new randomSSNgenrater();
	
	
	public String getTokenAPI()
	{
		String Client_ID="71f5eab0-86d1-4f66-9bae-9c6b2a2b8222";
		String Client_Secret="3c6ed38c-0fb3-4782-b0c3-40aad8e981f8";

		String credential="client_id="+Client_ID+"&client_secret="+Client_Secret+"&grant_type=client_credentials";
		return credential;
		
	}
	public String handshakeAPI()
	{
		
		String newSSN = String.valueOf(ssnGenerator.generateSSN());
    	getExcelData().put("SSN", newSSN);
    	getExcelData().put("CSSN", newSSN);
    	
    	
    	
		String urlSuffix="jmcompiat";

		String fName="ABC";//getExcelData().get("FNAME");
		String mName="A";//getExcelData().get("MNAME");
		String lName="SS";//getExcelData().get("LNAME");
		String dateOfBirth="07/14/1988";//getExcelData().get("DOB");
		
		//Function to change the format of date
		try {
		DateFormat fromFormat = new SimpleDateFormat("MM/dd/yyyy");
		fromFormat.setLenient(false);
		DateFormat toFormat = new SimpleDateFormat("yyyy-MM-dd");
		toFormat.setLenient(false);
		Date date;
			date = fromFormat.parse(dateOfBirth);
			dateOfBirth=toFormat.format(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String addressLine="asd";//getExcelData().get("HOME_STREET_ADDRESS");
		String state="asd";//getExcelData().get("STATE");
		String city="asd";//getExcelData().get("CITY");
		String zipCode="12323";//getExcelData().get("ZIP");
		String areaDialing="333"; 
		String dialNumber="333-3333";
		String eMailID="asd@adp.com";//getExcelData().get("EMAIL");
		
		    String firstRequest = "{\n" +
		            "                \"events\": [{\n" +
		            "                                \"serviceCategoryCode\": {\n" +
		            "                                                \"codeValue\": \"tax\",\n" +
		            "                                                \"shortName\": \"tax\"\n" +
		            "                                },\n" +
		            "                                \"eventNameCode\": {\n" +
		            "                                                \"codeValue\": \"tax-credit-screening.initiate\",\n" +
		            "                                                \"shortName\": \"Initiate Tax Credit Screening\"\n" +
		            "                                },\n" +
		            "                                \"eventStatusCode\": {\n" +
		            "                                                \"codeValue\": \"Complete\",\n" +
		            "                                                \"shortName\": \"Complete\"\n" +
		            "                                },\n" +
		            "                                \"permissibleStateCodes\": [ {\n" +
		            "                                                \"codeValue\":\"submit\",\n" +
		            "                                                \"shortName\":\"submit\"\n" +
		            "                                                \n" +
		            "                                }],\n" +
		            "                                \"originator\": {\n" +
		            "                                                \"associateOID\": \"\",\n" +
		            "                                                \"orginatorFormattedName\": \"\",\n" +
		            "                                                \"deviceID\": \"\",\n" +
		            "                                                \"eventID\": \"\"\n" +
		            "                                },\n" +
		            "                                \"actor\": {\n" +
		            "                                                \"associateOID\": \"\",\n" +
		            "                                                \"orginatorFormattedName\": \"\",\n" +
		            "                                                \"deviceID\": \"\",\n" +
		            "                                                \"eventID\": \"\"\n" +
		            "                                },\n" +
		            "                                \"data\": {\n" +
		            "                                                \"eventContext\": {\n" +
		            "                                                                \"contextExpressionID\": \"test context Expression ID\",\n" +
		            "                                                            \"organizationID\": {\n" +
		            "                                                                        \"idValue\": \""+urlSuffix+"\",\n" +
		            "                                                                        \"schemeCode\": {\n" +
		            "                                                                                    \"codeValue\": \"TaxCredits\"\n" +
		            "                                                                        }\n" +
		            "                                                            }\n" +
		            "                                                },\n" +
		            "                                                \"transform\": {\n" +
		            "                                                                \"eventStatusCode\": {\n" +
		            "                                                                                \"codeValue\": \"Created\",\n" +
		            "                                                                                \"shortName\": \"Created\"\n" +
		            "                                                                },\n" +
		            "                                                                \"effectiveDateTime\": \"2014-05-23T13:16:58-0600\",\n" +
		            "                                                                \"taxCreditScreening\":\n" +
		            "                                                                                {                                                                                              \n" +
		            "                                                                                                \"screeningSubject\": {\n" +
		            "                                                                                                                \"taxID\": {\n" +
		            "                                                                                                                                \"idValue\": \""+newSSN+"\",\n" +
		            "                                                                                                                                \"nameCode\": {\n" +
		            "                                                                                                                                                \"codeValue\": \"SSN\",\n" +
		            "                                                                                                                                                \"shortName\": \"Social Security Number\"\n" +
		            "                                                                                                                                },\n" +
		            "                                                                                                                                \"countryCode\": \"US\"\n" +
		            "                                                                                                                },\n" +
		            "                                                                                                                \"legalName\": {\n" +
		            "                                                                                                                                \"givenName\": \""+fName+"\",\n" +
		            "                                                                                                                                \"middleName\": \""+mName+"\",\n" +
		            "                                                                                                                                \"familyName1\": \""+lName+"\"\n" +
		            "                                                                                                                },\n" +
		            "                                                                                                                \"birthDate\": \""+dateOfBirth+"\",\n" +
		            "                                                                                                                \"legalAddress\": {\n" +
		            "                                                                                                                                \"lineOne\": \""+addressLine+"\",\n" +
		            "                                                                                                                                \"cityName\": \""+city+"\",\n" +
		            "                                                                                                                                \"countrySubdivisionLevel1\": {\n" +
		            "                                                                                                                                                \"codeValue\": \""+state+"\",\n" +
		            "                                                                                                                                                \"shortName\": \"Georgia\",\n" +
		            "                                                                                                                                                \"subdivisionType\": \"State\"\n" +
		            "                                                                                                                                },\n" +
		            "                                                                                                                                \"countryCode\": \"US\",\n" +
		            "                                                                                                                                \"postalCode\": \""+zipCode+"\"\n" +
		            "                                                                                                                },\n" +
		            "                                                                                                                \"communication\": {\n" +
		            "                                                                                                                                \"landlines\": [\n" +
		            "                                                                                                                                                {\n" +
		            "                                                                                                                                                                \"areaDialing\": \""+areaDialing+"\",\n" +
		            "                                                                                                                                                                \"dialNumber\": \""+dialNumber+"\",\n" +
		            "                                                                                                                                                                \"itemID\": \"A1616458-B00B-4D0B-B14C-6DFD44420CC9\"\n" +
		            "                                                                                                                                                }\n" +
		            "                                                                                                                                ],\n" +
		            "                                                                                                                                \"mobiles\": [\n" +
		            "                                                                                                                                                {\n" +
		            "                                                                                                                                                                \"areaDialing\": \"973\",\n" +
		            "                                                                                                                                                                \"dialNumber\": \"9745000\",\n" +
		            "                                                                                                                                                                \"itemID\": \"AB34887A-892B-4C3F-9A1A-879CAE72365B\"\n" +
		            "                                                                                                                                                }\n" +
		            "                                                                                                                                ],\n" +
		            "                                                                                                                                \"emails\": [\n" +
		            "                                                                                                                                                {\n" +
		            "                                                                                                                                                                \"emailUri\": \""+eMailID+"\",\n" +
		            "                                                                                                                                                                \"itemID\": \"A20533EF-FD46-4615-AA05-A686CF5BBB41\"\n" +
		            "                                                                                                                                                }\n" +
		            "                                                                                                                                ]\n" +
		            "                                                                                                                },\n" +
		            "                                                                                                                \"workAssignment\": {\n" +
		            "                                                                                                                                \"itemID\": \"73D228E5-8E28-4213-8A67-4287AAB9C900\",\n" +
		            "                                                                                                                                \"offerExtensionDate\": \"2014-07-04\",\n" +
		            "                                                                                                                                \"hireDate\": \"2014-07-15\",\n" +
		            "                                                                                                                                \"actualStartDate\": \"2014-08-01\",\n" +
		            "                                                                                                                                \"jobTitle\": \"Program Lead\",                                                                                                                         \n" +
		            "                                                                                                                                \"baseRemuneration\": {\n" +
		            "                                                                                                                                                \"hourlyRateAmount\": {\n" +
		            "                                                                                                                                                                \"amountValue\": 300.00,\n" +
		            "                                                                                                                                                                \"currencyCode\": \"USD\"\n" +
		            "                                                                                                                                                }\n" +
		            "                                                                                                                              },\n" +
		            "                                                                                                                                \"assignedWorkLocation\": {\n" +
		            "                                                                                                                                                \"nameCode\": {\n" +
		            "                                                                                                                                                                \"codeValue\": \"Corporate\",\n" +
		            "                                                                                                                                                                \"shortName\": \"Corporate\"\n" +
		            "                                                                                                                                                }\n" +
		            "                                                                                                                                }\n" +
		            "                                                                                                                }\n" +
		            "                                                                                                }\n" +
		            "                                                                                }\n" +
		            "                                                                \n" +
		            "                                                }\n" +
		            "                                }\n" +
		            "                }]\n" +
		            "}\n";
	


		return firstRequest;
		
	}


	public String handshakeICIMS()
	{
		String firstRequest = "{\n" +
				"  \"returnUrl\": \"https://jobs-preview5test.icims.com/jobs/2039/test-adp-job-wotc/assessment?i=1\",\n" +
				"  \"customerId\": \"2187\",\n" +
				"  \"userId\": \"11219\",\n" +
				"  \"links\": [\n" +
				"    {\n" +
				"      \"title\": \"Applicant Workflow\",\n" +
				"      \"rel\": \"applicantWorkflow\",\n" +
				"      \"url\": \"https://api.icims.com/customers/2187/applicantworkflows/13820\"\n" +
				"    }, {\n" +
				"      \"title\": \"Job Profile\",\n" +
				"      \"rel\": \"job\",\n" +
				"      \"url\": \"https://api.icims.com/customers/2187/jobs/2039\"\n" +
				"    }, {\n" +
				"      \"title\": \"Person Profile\",\n" +
				"      \"rel\": \"person\",\n" +
				"      \"url\": \"https://api.icims.com/customers/2187/people/11219\"\n" +
				"    }, {\n" +
				"      \"title\": \"Posting User\",\n" +
				"      \"rel\": \"user\",\n" +
				"      \"url\": \"https://api.icims.com/customers/2187/people/11219\"\n" +
				"    }\n" +
				"  ],\n" +
				"  \"eventType\": \"ApplicationCompletedEvent\",\n" +
				"  \"systemId\": \"13820\"\n" +
				"}";



		return firstRequest;

	}

	public String handshakeTaleo()
	{
		String firstRequest = "";
		return firstRequest;

	}

	public String handshakeKronos()
	{
		String firstRequest = "<?xml version=\"1.0\" ?>\n" +
				"<AssessmentOrderRequest xmlns=\"http://ns.hr-xml.org/2007-04-15\"\n" +
				"                xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
				"                <ClientId idOwner=\"ADP\">\n" +
				"                                <IdValue name=\"Username\">coffeexmlapi1</IdValue>\n" +
				"                                <IdValue name=\"Password\">ljhujhflpnBFfbhj</IdValue>\n" +
				"                </ClientId>\n" +
				"                <ClientOrderId idOwner=\"Kronos\">\n" +
				"                                <IdValue name=\"OrderID\">"+ssnGenerator.generateSSN()+"</IdValue>\n" +
				"                                <IdValue name=\"XferID\">82024</IdValue>\n" +
				"                </ClientOrderId>\n" +
				"                <AssessmentSubject>\n" +
				"                                <PersonName>\n" +
				"                                                <GivenName>test</GivenName>\n" +
				"                                                <FamilyName>test</FamilyName>\n" +
				"                                </PersonName>\n" +
				"                                <ContactMethod>\n" +
				"                                                <InternetEmailAddress>test111@yahoo.com</InternetEmailAddress>\n" +
				"                                                <Telephone>\n" +
				"                                                                <FormattedNumber>732-999-9999</FormattedNumber>\n" +
				"                                                </Telephone>\n" +
				"                                </ContactMethod>\n" +
				"                                <PostalAddress>\n" +
				"                                                <CountryCode>USA</CountryCode>\n" +
				"                                                <PostalCode>60660</PostalCode>\n" +
				"                                                <Region>IL</Region>\n" +
				"                                                <Municipality>Chicago</Municipality>\n" +
				"                                                <DeliveryAddress>\n" +
				"                                                                <AddressLine>9999 W. test Ave</AddressLine>\n" +
				"                                                </DeliveryAddress>\n" +
				"                                </PostalAddress>\n" +
				"                </AssessmentSubject>\n" +
				"                <AssessmentLanguage>en_US</AssessmentLanguage>\n" +
				"                <UserArea>\n" +
				"                                <AdditionalItems>\n" +
				"                                                <AdditionalItem qualifier=\"JobBidId\" type=\"OriginatorInfo\">\n" +
				"                                                                <Text>3340001</Text>\n" +
				"                                                </AdditionalItem>\n" +
				"                                                <AdditionalItem qualifier=\"reportRecipient\" type=\"OriginatorInfo\">\n" +
				"                                                                <Text>http://vista-dit.adplabs.com.br/scripts/dev/testing_endpoint?email=huifeng.yu@adp.com</Text>\n" +
				"                                                </AdditionalItem>\n" +
				"                                                <AdditionalItem qualifier=\"redirectURL\" type=\"OriginatorInfo\">\n" +
				"                                                                <Text>https://wfa.kronostm.com/index.jsp?applicationName=SixFlagsNonReqExt&amp;locale=en_US&amp;seq=returnToken&amp;returnToken=43ebd77d-8574-4a87-8936-42c31b46c2a9</Text>\n" +
				"                                                </AdditionalItem>\n" +
				"                                                <AdditionalItem qualifier=\"ScreeningLocation\" type=\"OriginatorInfo\">\n" +
				"                                                                <LocationNumber>VB1</LocationNumber>\n" +
				"                                                                <Description>Six Flags Great America</Description>\n" +
				"                                                </AdditionalItem>\n" +
				"                                </AdditionalItems>\n" +
				"                </UserArea>\n" +
				"</AssessmentOrderRequest>";
		return firstRequest;

	}


	public String handshakeKronosfit2()
	{
		String firstRequest = "<AssessmentOrderRequest xmlns=\"http://ns.hr-xml.org/2007-04-15\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
				"    <ClientId idOwner=\"VendorName\">\n" +
				"        <IdValue name=\"UserName\">motox</IdValue>\n" +
				"        <IdValue name=\"Password\">aiMGlhjcdOlljikD</IdValue>\n" +
				"    </ClientId>\n" +
				"    <ClientOrderId idOwner=\"Kronos\">\n" +
				"        <IdValue name=\"OrderID\">"+ssnGenerator.generateSSN()+"</IdValue>\n" +
				"        <IdValue name=\"XferID\">82024</IdValue>\n" +
				"    </ClientOrderId>\n" +
				"    <AssessmentSubject>\n" +
				"        <PersonName>\n" +
				"            <GivenName>Leo</GivenName>\n" +
				"            <FamilyName>TestHire2</FamilyName>\n" +
				"        </PersonName>\n" +
				"        <ContactMethod>\n" +
				"            <InternetEmailAddress>LnbgTestJiraFnameA@foo.com</InternetEmailAddress>\n" +
				"            <Telephone>\n" +
				"                <FormattedNumber>(123) 456-7890</FormattedNumber>\n" +
				"            </Telephone>\n" +
				"        </ContactMethod>\n" +
				"        <PostalAddress>\n" +
				"            <CountryCode>USA</CountryCode>\n" +
				"            <PostalCode>82382</PostalCode>\n" +
				"            <Region>UT</Region>\n" +
				"            <Municipality>Park City</Municipality>\n" +
				"            <DeliveryAddress>\n" +
				"               <AddressLine>123 NW 1st Street</AddressLine>\n" +
				"                <AddressLine>Suite 200</AddressLine>\n" +
				"            </DeliveryAddress>\n" +
				"        </PostalAddress>\n" +
				"    </AssessmentSubject>\n" +
				"    <AssessmentLanguage>en_US</AssessmentLanguage>\n" +
				"    <UserArea>\n" +
				"        <AdditionalItems>\n" +
				"            <AdditionalItem type=\"OriginatorInfo\" qualifier=\"JobBidId\">\n" +
				"                <Text>1935</Text>\n" +
				"            </AdditionalItem>\n" +
				"                                                <AdditionalItem qualifier=\"reportRecipient\" type=\"OriginatorInfo\">\n" +
				"                                                                <Text>http://vista-dit.adplabs.com.br/scripts/dev/testing_endpoint?email=leonardo.santos@adp.com</Text>\n" +
				"                                                </AdditionalItem>\n" +
				"                                                <AdditionalItem qualifier=\"redirectURL\" type=\"OriginatorInfo\">\n" +
				"                                                                <Text>https://wfa.kronostm.com/index.jsp?applicationName=SixFlagsNonReqExt&amp;locale=en_US&amp;seq=returnToken&amp;returnToken=43ebd77d-8574-4a87-8936-42c31b46c2a9</Text>\n" +
				"                                                </AdditionalItem>\n" +
				"\n" +
				"            <AdditionalItem type=\"OriginatorInfo\" qualifier=\"ScreeningLocation\">\n" +
				"                <LocationNumber>97239</LocationNumber>\n" +
				"                <Description>Portland Store</Description>\n" +
				"            </AdditionalItem>\n" +
				"            <AdditionalItem type=\"OriginatorInfo\" qualifier=\"ScreeningLocation\">\n" +
				"                <LocationNumber>97223</LocationNumber>\n" +
				"                <Description>Tigard Store</Description>\n" +
				"            </AdditionalItem>\n" +
				"        </AdditionalItems>\n" +
				"    </UserArea>\n" +
				"</AssessmentOrderRequest>";
		return firstRequest;

	}



	public String handshakeKronosProd()
	{
		String firstRequest = "<?xml version=\"1.0\" ?>\n" +
				"<AssessmentOrderRequest xmlns=\"http://ns.hr-xml.org/2007-04-15\"\n" +
				"                xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
				"                <ClientId idOwner=\"ADP\">\n" +
				"                                <IdValue name=\"Username\">jmcomp</IdValue>\n" +
				"                                <IdValue name=\"Password\">hcikhalphriwdakO</IdValue>\n" +
				"                </ClientId>\n" +
				"                <ClientOrderId idOwner=\"Kronos\">\n" +
				"                                <IdValue name=\"OrderID\">"+ssnGenerator.generateSSN()+"</IdValue>\n" +
				"                                <IdValue name=\"XferID\">82024</IdValue>\n" +
				"                </ClientOrderId>\n" +
				"                <AssessmentSubject>\n" +
				"                                <PersonName>\n" +
				"                                                <GivenName>test</GivenName>\n" +
				"                                                <FamilyName>test</FamilyName>\n" +
				"                                </PersonName>\n" +
				"                                <ContactMethod>\n" +
				"                                                <InternetEmailAddress>test111@yahoo.com</InternetEmailAddress>\n" +
				"                                                <Telephone>\n" +
				"                                                                <FormattedNumber>732-999-9999</FormattedNumber>\n" +
				"                                                </Telephone>\n" +
				"                                </ContactMethod>\n" +
				"                                <PostalAddress>\n" +
				"                                                <CountryCode>USA</CountryCode>\n" +
				"                                                <PostalCode>60660</PostalCode>\n" +
				"                                                <Region>IL</Region>\n" +
				"                                                <Municipality>Chicago</Municipality>\n" +
				"                                                <DeliveryAddress>\n" +
				"                                                                <AddressLine>9999 W. test Ave</AddressLine>\n" +
				"                                                </DeliveryAddress>\n" +
				"                                </PostalAddress>\n" +
				"                </AssessmentSubject>\n" +
				"                <AssessmentLanguage>en_US</AssessmentLanguage>\n" +
				"                <UserArea>\n" +
				"                                <AdditionalItems>\n" +
				"                                                <AdditionalItem qualifier=\"JobBidId\" type=\"OriginatorInfo\">\n" +
				"                                                                <Text>3340001</Text>\n" +
				"                                                </AdditionalItem>\n" +
				"                                                <AdditionalItem qualifier=\"reportRecipient\" type=\"OriginatorInfo\">\n" +
				"                                                                <Text>http://vista-dit.adplabs.com.br/scripts/dev/testing_endpoint?email=huifeng.yu@adp.com</Text>\n" +
				"                                                </AdditionalItem>\n" +
				"                                                <AdditionalItem qualifier=\"redirectURL\" type=\"OriginatorInfo\">\n" +
				"                                                                <Text>https://wfa.kronostm.com/index.jsp?applicationName=SixFlagsNonReqExt&amp;locale=en_US&amp;seq=returnToken&amp;returnToken=43ebd77d-8574-4a87-8936-42c31b46c2a9\n" +
				"                                                                </Text>\n" +
				"                                                </AdditionalItem>\n" +
				"                                                <AdditionalItem qualifier=\"ScreeningLocation\" type=\"OriginatorInfo\">\n" +
				"                                                                <LocationNumber>VB1</LocationNumber>\n" +
				"                                                                <Description>Six Flags Great America</Description>\n" +
				"                                                </AdditionalItem>\n" +
				"                                </AdditionalItems>\n" +
				"                </UserArea>\n" +
				"</AssessmentOrderRequest>";
		return firstRequest;

	}



}
