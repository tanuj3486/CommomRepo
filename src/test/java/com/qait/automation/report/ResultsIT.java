package com.qait.automation.report;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.Multipart;
import javax.mail.internet.MimeMessage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qait.Domestic.automation.util.Utilities;

public class ResultsIT {

    String testdata;
    Date today = new Date();
    String host = "smtp.gmail.com";
    String from = "automation.resultsqait@gmail.com";
    String password = "Q@INFOTECH";
    String port = "465";
    Message message;
    public String textFile1;
    

    @BeforeClass
    void setupMailConfig() {
    	Utilities.setYamlFilePath("testData/integration_testData_Domestic.yml");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%");
    }

    @Test
    public void sendResultsMail() throws Exception {
    	try{
        if (Utilities.getYamlValue("results.sendEmail").equalsIgnoreCase("yes")) {
            message = new MimeMessage(getSession());
            message.setFrom(new InternetAddress(from));
            setMailRecipient(message);
            message.setSubject(setMailSubject());
            message.setContent(setAttachement());
            Properties properties = System.getProperties();
            Session session = Session.getDefaultInstance(properties);
            message.setContent(setAttachement());
            Transport transport = session.getTransport("smtps");
            transport.connect(host, from, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } else {
            System.out.println("enteredElse");
        }
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

    private Session getSession() {
        Authenticator authenticator = new Authenticator(from, password);

        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtps");
        properties.put("mail.smtps.auth", "true");
        //properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.submitter", authenticator.getPasswordAuthentication().getUserName());
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", port.toString());
        return Session.getInstance(properties, authenticator);
    }

    public String setBodyText() throws IOException {
        String mailtext = "";
        mailtext = "Hi,<br>";
        mailtext = mailtext + "</br><br>The automated functional test were performed</br><br>";
        mailtext = mailtext + "<br><b><font style= Courier, color = green>Test Name: </font></b>" + getTestName();
        mailtext = mailtext + "<br><b><font color = green>Test Date: </font></b>" + today;
        mailtext = mailtext + "<br><b><font color = green>Test Browser: </font></b>" + Utilities.getYamlValue("browser");
        mailtext = mailtext + "<br><b><font color = green>Test Environment: </font></b>" + Utilities.getYamlValue("appurl");
        
        mailtext = mailtext + "<br><b><font color = green>Test Case Executed By: </font></b>" + System.getProperty("user.name");
        mailtext = mailtext + "<b>" + testSetResult() + "</b>";
        
        if (getTestName().contains("AllCourse")){
            mailtext = mailtext + "<br><br>The detailed test results for All available courses are given in the attached <i>Result.xls</i> </br></br>";
        }else{
        	mailtext = mailtext + "<br><br>The detailed test results are given in the attached <i>emailable-report.html</i> </br></br>";
      	
        }
        
        mailtext = mailtext + "<br><br>Best Regards" + "</br></br>";
        mailtext = mailtext + "<br>PennFoster Automation QA Team" + "</br>";
        mailtext = mailtext + "<br><br>Note: This is a system generated mail. Please do not reply." + "</br></br>";
        mailtext = mailtext + "<br>If you have any queries mail to <a href=mailto:PennFosterQA@qainfotech.net?Subject=Reply of Automation Status>PennFosterQA</a></br>";
        return mailtext;
    }

    private String setMailSubject() {
        return ("PennFoster Automated EOL Test Report - " + today);
    }

    private void setMailRecipient(Message message) {
        // System.out.println("EnteredsetMailRecipient");
        try {
            for (Object recipient : Utilities.getYamlNodesArray("results.recipients").values()) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient.toString()));
                message.addRecipient(Message.RecipientType.BCC, new InternetAddress(recipient.toString()));
            }
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("tanujkumarvishnoi@qainfotech.net"));
            message.addRecipient(Message.RecipientType.BCC, new InternetAddress("tanujkumarvishnoi@qainfotech.net"));
        } catch (MessagingException me) {
            System.out.println("Exception in Results mail sending:-" + me.getStackTrace());
        }

    }

    private Multipart setAttachement() throws Exception {
// Create the message part 
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        //BodyPart messageBodyPart = new MimeBodyPart();

// Fill the message
        //messageBodyPart.setText(setBodyText());
        messageBodyPart.setContent(setBodyText(), "text/html");
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

// Part two is attachment
        messageBodyPart = new MimeBodyPart();
        
        
        
        if (getTestName().contains("AllCourse")){
        	messageBodyPart.attachFile("./LastRunReport/ExcelMail/Result.xls");
            multipart.addBodyPart(messageBodyPart);

        }else{
        	messageBodyPart.attachFile("./target/surefire-reports/emailable-report.html");
        	multipart.addBodyPart(messageBodyPart);
        	 	
        }
        return multipart;
    }

    private String getTestName() {
        String test = System.getProperty("test", "null");
        String testsuite = System.getProperty("testsuite", "null");
        String testName;
        if (test != "null") {
            testName = test + " was executed";
            return testName;
        } else if (testsuite != "null") {
            testName = testsuite + "were executed";
            return testName;
        } else {
            testName = "complete automation test suite or TestNg xml was executed";
            return testName;
        }
    }

    public void getFilePath() {
        File folder = new File("./target/surefire-reports");
        String[] fileNames = folder.list();

        int total = 0;
        for (int i = 0; i < fileNames.length; i++) {
            if (fileNames[i].contains(".txt")) {
                total++;
                // System.out.println("total is" + total);
                assert total == 1;

                textFile1 = fileNames[i];
                //System.out.println("The filename is:" + textFile1);

            }

        }

    }

    public String testSetResult() throws IOException {
        String messageToBeSent = ("");
        getFilePath();//calling method getFilepath()
        String textFilePath = "./target/surefire-reports/" + textFile1;
        FileInputStream fstream = new FileInputStream(textFilePath);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        int num = 4;
        //Read File Line By Line
        String[] strLine = new String[num];
        for (int i = 0; i < num; i++) {
            strLine[i] = br.readLine();
            messageToBeSent = messageToBeSent + "<br>" + strLine[i] + "</br>";
        }
        return messageToBeSent;
    }
}