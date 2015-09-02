package com.gale.knewton.util;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.gale.knewton.base.BaseWebComponent;

public class Emailer extends BaseWebComponent {
	
	 final String host = "smtp.gmail.com";
	    final int port = 25;
	    final String from = "automation.resultsqait@gmail.com";
	    final String password = "QaitAutomation";
	    String mailType;
	    String recepenientType;
	    
	    public Emailer(String mailType, String recepientType) {
	        this.mailType = mailType;
	        this.recepenientType = recepientType;
	    }
	    
	    public void sendResultsMail() throws AddressException, MessagingException, IOException  {

	        Message message = new MimeMessage(getSession());
	        message.addFrom(new InternetAddress[]{(new InternetAddress(from))});
	        setMailRecipient(message);
	        message.setSubject(setMailSubject());
	        message.setContent("Automail", "text/html");
	        message.setContent(setAttachment());
	        Session session = getSession();
	        Transport transport = session.getTransport("smtps");
	        System.out.println("get transport");
	        transport.connect(host, from, password);
	        System.out.println("connected");
	        transport.sendMessage(message, message.getAllRecipients());
	        System.out.println("In message");
	        transport.close();
	    }
	    
	    private String setMailSubject() {
	        String returnSubject = "Knweton Test Results";
	     
	        return returnSubject;
	    }
	    
	    private Session getSession() {
	        Authentication authenticator = new Authentication(this.from,
	                this.password);
	        System.out.println("password from");
	        Properties properties = new Properties();
	        properties.setProperty("mail.transport.protocol", "smtps");
	        properties.put("mail.smtps.auth", "true");
	        properties.setProperty("mail.smtp.submitter", authenticator
	                .getPasswordAuthentication().getUserName());
	        properties.setProperty("mail.smtp.auth", "true");
	        properties.setProperty("mail.smtp.host", host);
	        properties.setProperty("mail.smtp.port", String.valueOf(port));
	        System.out.println("get session");
	        return Session.getInstance(properties, authenticator);
	    }

	    private Message setMailRecipient(Message message) throws AddressException,
        MessagingException, IOException {

	    	String recipientlist =YamlReader.getYamlValue("recepient");
	    	 message.addRecipient(Message.RecipientType.TO, new InternetAddress(
	    			 recipientlist.trim()));
	    	 System.out.println(recipientlist+""+message);
	        return message;
   
}   
	    
	    private Multipart setAttachment() throws MessagingException, IOException {
	        // Create the message part
	        MimeBodyPart messageBodyPart = new MimeBodyPart();

	        MimeMultipart multipart = new MimeMultipart();
	        multipart.addBodyPart(messageBodyPart);
	        System.out.println("In Set A");
	        // Part two is attachment
	        messageBodyPart = new MimeBodyPart();
	        addAttachment(multipart, messageBodyPart,
	                "./Knewton/target/cucumber");

	        return multipart;
	    }

	    private static void addAttachment(Multipart multipart,
	            MimeBodyPart messageBodyPart, String filename)
	            throws MessagingException {
	        messageBodyPart = new MimeBodyPart();
	        System.out.println("In Add A");
	        File f = new File(filename);
	        DataSource source = new FileDataSource(f);
	        messageBodyPart.setDataHandler(new DataHandler(source));
	        messageBodyPart.setFileName(f.getName());
	        multipart.addBodyPart(messageBodyPart);
	    }
	    
	    

}
