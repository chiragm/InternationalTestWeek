package ConnectionManager;

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.net.URL;

	import org.apache.http.HttpResponse;
	import org.apache.http.client.HttpClient;
	import org.apache.http.client.methods.HttpGet;
	import org.apache.http.impl.client.DefaultHttpClient;


	import com.sun.xml.rpc.client.http.handler.HttpURLConnection;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.InputStream;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.ArrayList;
	import java.util.Date;
	import java.util.Iterator;
	import java.util.List;
	import java.util.Locale;

	import javax.xml.stream.XMLEventReader;
	import javax.xml.stream.XMLInputFactory;
	import javax.xml.stream.XMLStreamException;
	import javax.xml.stream.events.Attribute;
	import javax.xml.stream.events.EndElement;
	import javax.xml.stream.events.StartElement;
	import javax.xml.stream.events.XMLEvent;
	public class ApproveCharityRequests {
		
		  static final String REGISTRATION_NO = "registrationNo";
		  static final String CHARITY_NAME = "charityName";
		  static final String CHARITY_DESCRIPTION = "charityDescription";
		  static final String EMAIL = "email";
		  static final String PHONE = "phone";
		  static final String CHARITY_ID = "charityID"; 
		  static final String ISVERIFIED = "isVerified";
		  static final String CHARITY = "charity";
		  static final String USERID = "userId";
		  static final String ACCOUNTNO = "accountNo";
		  static final String CONNECTIONSTRING = "connectionString";
		  static final String ISACTIVE = "isActive";
		  static final String TIMESTAMP = "timestamp";
		  static final String ADDRESSLine1 = "addressLine1";
		  static final String ADDRESSLine2 = "addressLine2";
		  static final String LOCATION = "location";
		  static final String POSTCODE = "postcode";

		
		public static List<Charity> httpGet(String urlStr) throws IOException, ParseException {
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet(urlStr);
			HttpResponse response = client.execute(request);
			List<Charity> charities = new ArrayList<Charity>();
			    try {
			      // First create a new XMLInputFactory
			      XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			      // Setup a new eventReader
			      InputStream in = response.getEntity().getContent();
			       //response.getEntity().getContent()
			      //conn.getInputStream();
			      XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			      // Read the XML document
			      Charity charity = null;

			      while (eventReader.hasNext()) {
			        XMLEvent event = eventReader.nextEvent();

			        if (event.isStartElement()) {
			          StartElement startElement = event.asStartElement();
			          // If we have a item element we create a new item
			          if (startElement.getName().getLocalPart() == (CHARITY)) {
			            charity = new Charity();
			          }

			          if (event.isStartElement()) {
			            if (event.asStartElement().getName().getLocalPart()
			                .equals(CHARITY_NAME)) {
			              event = eventReader.nextEvent();
			              charity.setCharityName(event.asCharacters().getData());
			              continue;
			            }
			          }
			          if (event.asStartElement().getName().getLocalPart()
			              .equals(CHARITY_DESCRIPTION)) {
			            event = eventReader.nextEvent();
			            charity.setCharityDescription(event.asCharacters().getData());
			            continue;
			          }

			          if (event.asStartElement().getName().getLocalPart()
			              .equals(EMAIL)) {
			            event = eventReader.nextEvent();
			            charity.setEmail(event.asCharacters().getData());
			            continue;
			          }

			          if (event.asStartElement().getName().getLocalPart()
			              .equals(PHONE)) {
			            event = eventReader.nextEvent();
			            charity.setPhone(event.asCharacters().getData());
			            continue;
			          }
			          
				            if (event.asStartElement().getName().getLocalPart()
				                .equals(CHARITY_ID)) {
				              event = eventReader.nextEvent();
				              charity.setCharityID(Integer.parseInt(event.asCharacters().getData()));
				              continue;
				            }
				          
			          
			          
				            if (event.asStartElement().getName().getLocalPart()
				                .equals(USERID)) {
				              event = eventReader.nextEvent();
				              charity.setUserId(Integer.parseInt(event.asCharacters().getData()));
				              continue;
				            }
				          
			          
			          
				            if (event.asStartElement().getName().getLocalPart()
				                .equals(ACCOUNTNO)) {
				              event = eventReader.nextEvent();
				              charity.setAccountNo((event.asCharacters().getData()));
				              continue;
				            }
				          
			          
			          
				            if (event.asStartElement().getName().getLocalPart()
				                .equals(CONNECTIONSTRING)) {
				              event = eventReader.nextEvent();
				              //charity.setConnectionString((event.asCharacters().getData()));
				              continue;
				            }
				            
				            if (event.asStartElement().getName().getLocalPart()
					                .equals(REGISTRATION_NO)) {
					              event = eventReader.nextEvent();
					              charity.setRegistrationNo((event.asCharacters().getData()));
					              continue;
					            }
			          
			          if (event.asStartElement().getName().getLocalPart()
				              .equals(ISVERIFIED)) {
			        	  	
			        	  		event = eventReader.nextEvent();
				              charity.setIsVerified(Boolean.valueOf(event.asCharacters().getData()));
			        	  		continue;
			        	  	
				          }
			          
			          
			        }
			        // If we reach the end of an item element we add it to the list
			        if (event.isEndElement()) {
			          EndElement endElement = event.asEndElement();
			          if (endElement.getName().getLocalPart() == (CHARITY) && charity.getIsVerified()==false) {
			            charities.add(charity);
			          }
			        }

			      }
			    } catch (FileNotFoundException e) {
			      e.printStackTrace();
			    } catch (XMLStreamException e) {
			      e.printStackTrace();
			    }
			    return charities;
			    
			  
			  
			  
			  
			  
			  
			}	
		
		  

		  

		  
		  
		  
		  
		} 
		
		
		






