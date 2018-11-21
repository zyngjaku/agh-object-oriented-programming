package com.company;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.omg.CORBA.DynAnyPackage.Invalid;
import sun.plugin2.message.Message;
import sun.plugin2.message.transport.Transport;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.jms.Session;
import java.util.LinkedList;
import java.util.Properties;

public class EmailMessage {

    private String from; //required (must be e-mail)
    private LinkedList<String> to; //required at least one (must be e-mail)
    private String subject; //optional
    private String content; //optional
    private String mimeType;  // optional
    private LinkedList<String> cc; //optional
    private LinkedList<String> bcc; // optional

    public EmailMessage(){
        from = null;
        to = new LinkedList<String>();
        subject = null;
        content = null;
        mimeType = null;
        cc = new LinkedList<String>();
        bcc = new LinkedList<String>();
    }

    public EmailMessage(String from, LinkedList<String> to) {
        if(!isEmailValid(from)) throw new IllegalArgumentException("Wrong mail format: " + from);
        else this.from = from;

        this.to = new LinkedList<String>();
        for(String it : to) {
            System.out.println(it);
            if(!isEmailValid(it)) throw new IllegalArgumentException("Wrong mail format: " + it);
            else this.to.add(it);
        }
    }

    public EmailMessage(String from,
                        LinkedList<String> to,
                        String subject,
                        String content,
                        String mimeType,
                        LinkedList<String> cc,
                        LinkedList<String> bcc){

        this.from = from;

        this.to = new LinkedList<String>();
        for(String it : to) {
            System.out.println(it);
            if(!isEmailValid(it)) throw new IllegalArgumentException("Wrong mail format: " + it);
            else this.to.add(it);
        }

        this.subject = subject;
        this.content = content;
        this.mimeType = mimeType;

        this.cc = new LinkedList<String>();
        for(String it : cc) {
            System.out.println(it);
            if(!isEmailValid(it)) throw new IllegalArgumentException("Wrong mail format: " + it);
            else this.cc.add(it);
        }

        this.bcc = new LinkedList<String>();
        for(String it : bcc) {
            System.out.println(it);
            if(!isEmailValid(it)) throw new IllegalArgumentException("Wrong mail format: " + it);
            else this.bcc.add(it);
        }
    }

    public boolean isEmailValid(String mail){
        boolean at = false;
        boolean dot = false;
        boolean flag = true;

        for(int i=0; i<mail.length(); i++){
            if(i!=0 && i!=mail.length()-1){
                if(mail.charAt(i) == '@') at = true;
                if(mail.charAt(i) == '.' && mail.charAt(i-1) != '@') dot = true;
            }
        }

        if(at && dot && flag) return true;

        return false;
    }

    public void SendMail() {
        String host = "localhost";

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage mm = new MimeMessage(session);
            mm.setFrom(new InternetAddress(from));
            mm.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mm.setSubject(subject);
            mm.setText(message);
            Transport.send(mm);

            System.out.println("Mail has been sent successfully!");

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
