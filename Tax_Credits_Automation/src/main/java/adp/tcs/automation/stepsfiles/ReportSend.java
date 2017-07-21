package adp.tcs.automation.stepsfiles;

import adp.tcs.automation.utilities.GenerateTabularReport;
import adp.tcs.automation.utilities.PropertiesUtilities;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

public class ReportSend extends BaseTempletSteps{

	public void send() {
		String workingDir = System.getProperty("user.dir");
		String extendsReportPath = workingDir + "\\target\\ExtendsReport\\AutmationReport.html";
		
		GenerateTabularReport generateTabularReport = new GenerateTabularReport();		
		String Message = generateTabularReport.getReportData();
		
		//String To = "akash.shivhare@adp.com;sachin.bhute@adp.com;sahil.thorat@adp.com;saurab.dey@adp.com;manish.virat@adp.com";
		//String To = "sahil.thorat@adp.com";
		
		ArrayList<String> emailList = PropertiesUtilities.getAllEmailList();
		String To = "";
		for(String email : emailList){
			To +=  email +";";
		}
		
		 
		 String cc = "";
		 String bcc = "";
			
			Date date = new Date();
		    String modifiedDate= new SimpleDateFormat("MM/dd/yyyy").format(date);
		    
			
			String to = To;	
			String from = "TCSAutomation@adp.com";
			String host = "mailrelay.nj.adp.com";
		
			Properties properties = System.getProperties();
			properties.setProperty("mail.smtp.host", host);
			Session session = Session.getDefaultInstance(properties);
		
			try{
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));
				
				if(!to.trim().equals("")){
		            for (int i = 0; i < to.split(";").length; i++)
		            {
		            	if(!to.split(";")[i].trim().equals("")){
		            		message.addRecipient(RecipientType.TO, new InternetAddress(to.split(";")[i]));
		            	}
		            }
				}
				if(!cc.trim().equals("")){
		            for (int i = 0; i < cc.split(";").length; i++)
		            {
		            	if(!cc.split(";")[i].trim().equals("")){
		            		message.addRecipient(RecipientType.CC, new InternetAddress(cc.split(";")[i]));
		            	}
		            }
				}
				if(!bcc.trim().equals("")){
		            for (int i = 0; i < bcc.split(";").length; i++)
		            {
		            	if(!bcc.split(";")[i].trim().equals("")){
		            		message.addRecipient(RecipientType.BCC, new InternetAddress(bcc.split(";")[i]));
		            	}
		            }
				}
				
				message.setSubject("Sanity Result, "+currentdate()+ ", Env : "+loadPropValues("envName").toUpperCase());
				
				// Create the message part
	            BodyPart messageBodyPart = new MimeBodyPart();
	            messageBodyPart.setContent(Message, "text/html");
				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(messageBodyPart);
				
			
					messageBodyPart = new MimeBodyPart();
		            String filename = extendsReportPath;
		            DataSource source = new FileDataSource(filename);
		            messageBodyPart.setDataHandler(new DataHandler(source));
		            modifiedDate = modifiedDate.replace("/", "");
		            messageBodyPart.setFileName("AutomationReport.html");
		            multipart.addBodyPart(messageBodyPart);
				

	            message.setContent(multipart);
	            
				Transport.send(message);
				System.out.println("Sent message successfully....");
			}catch (MessagingException mex) {
			     mex.printStackTrace();			    
			}
		}
	}
