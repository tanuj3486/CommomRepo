package com.qait.automation.report;

/**
 *
 * @author QAIT
 */

import javax.mail.PasswordAuthentication;

class Authenticator extends javax.mail.Authenticator {
        
    private PasswordAuthentication authentication;

    public Authenticator(String username, String password) {
        authentication = new PasswordAuthentication(username, password);
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return authentication;
    }
}

