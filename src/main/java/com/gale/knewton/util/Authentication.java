package com.gale.knewton.util;

import javax.mail.PasswordAuthentication;

public class Authentication extends javax.mail.Authenticator
{
	
private PasswordAuthentication authentication;

public Authentication(String from, String password) 
{
authentication = new PasswordAuthentication(from, password);
}

protected PasswordAuthentication getPasswordAuthentication()
{
return authentication;
}
}

