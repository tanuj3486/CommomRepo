package com.qait.automation.utils;
import java.util.Date;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.search.AndTerm;
import javax.mail.search.ComparisonTerm;
import javax.mail.search.FromTerm;
import javax.mail.search.ReceivedDateTerm;
import javax.mail.search.SearchTerm;

import org.testng.Assert;
import org.testng.Reporter;

public class MailReader {

	public static String getMail(String userEmail, String password,String senderEmailAddress, String emailSubject, Date emailDate){
		
		String content=null;
	   	Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        props.setProperty("mail.imaps.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.imaps.socketFactory.fallback", "false");
        props.setProperty("mail.imaps.ssl.enable","true");
        props.setProperty("mail.imaps.connectiontimeout", "300000");
        props.setProperty("mail.imaps.timeout", "900000");
        props.setProperty("mail.imaps.connectiontimeout", "300000");
        props.setProperty("mail.imaps.statuscachetimeout", "3000000");
        props.setProperty("mail.imaps.connectionpooltimeout", "3000000");
        
       // mail.imap.connectiontimeout
        try {
        	 Thread.sleep(5000);
		      Session session = Session.getDefaultInstance(props, null);
		     
		      Store store = session.getStore("imaps");
		      store.connect("smtp.gmail.com", userEmail,password);
		      Folder inbox = store.getFolder("inbox");
		      inbox.open(Folder.READ_ONLY);
		      SearchTerm searchCondition = new FromTerm(new InternetAddress(senderEmailAddress));
		      SearchTerm newerThan = new ReceivedDateTerm(ComparisonTerm.GT,emailDate);		      
		      SearchTerm andTerm = new AndTerm(newerThan, searchCondition);
		      Message messages[] = inbox.search(andTerm) ;
		      final int totalMessages = messages.length;
		      Reporter.log("Total messages present in Inbox : "+totalMessages,true);
		      
		      if(totalMessages!=0){
		    	  int count=0;
		    	  Message m = null;
			      for (int i = (totalMessages-1); i >= 0; i--) {
			    	/*  Reporter.log("mail date "+messages[i].getReceivedDate().toString(),true);
			    	  Reporter.log(messages[i].getSubject(),true);*/
			    	//  Reporter.log("Total mesages present in Inbox : "+totalMessages,true);
		    	  if(emailDate.compareTo(messages[i].getReceivedDate())<1){
				    	   if(messages[i].getSubject().equals(emailSubject)){
					    		 count++;
					    	   	 m = messages[i];
				    	   }
			    	  }
			      }
			      
			      if(count==1){
		    		   	Reporter.log("Assertion Passed : Meessage Is Present In INBOX",true);
	    		   		Reporter.log("Message Content Type : "+m.getContentType(),true);
	    		   		Reporter.log("Mail Recieved Time : " +m.getReceivedDate(),true);
		        		content = (String) m.getContent();
		    	   }
		    	   else
		    		   Assert.fail("Assertion Failed : There are "+count+" mails found in Inbox having same Subject line : "+emailSubject);
		    }	    	  
		      else
		    	  Assert.fail("Assertion Failed  : No Message is Found in Inbox");
	         } catch (Exception e) {
	        	 	System.out.println("Something wrong in reading email");
	        	 	e.printStackTrace();
	         	}
        return content;
	}
}
