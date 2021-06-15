/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author yassine
 */
public class MailUtil {
    
    public static String customMessage = null;
    
    public static void sendMail(String recepient) throws Exception {
        System.out.println("Preparing to send email");
        Properties properties = new Properties();

        //Enable authentication
        properties.put("mail.smtp.auth", "true");
        //Set TLS encryption enabled
        properties.put("mail.smtp.starttls.enable", "true");
        //Set SMTP host
        properties.put("mail.smtp.host", "smtp.gmail.com");
        //Set smtp port
        properties.put("mail.smtp.port", "587");

        //Your gmail address
        String myAccountEmail = "bouzianeyassine112@gmail.com";
        //Your gmail password
        String password = "Ilyas1998&";

        //Create a session with account credentials
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        //Prepare email message
        Message message = prepareMessage(session, myAccountEmail, recepient, customMessage);

        //Send mail
        Transport.send(message);
        System.out.println("Message sent successfully");
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient, String m) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Nouvelle demande");
            String htmlCode = m;
            message.setContent(htmlCode, "text/html");
            return message;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static String ueMessage(Demande d){
        
        return "Une nouvelle Demande a ete ajouté, consulter l'application pour la traiter\n"
                + "Informations demande : " 
               
                +
                ", nom=" + d.getNom() +
                ", prenom=" + d.getPrenom() +
                ", cnie=" + d.getCnie() +
                ", dateB=" + d.getDateB() +
                ", dateE=" + d.getDateE() +
                ", time=" + d.getTime() + 
                ", ue=" + d.getUe() + 
                ", entreprise=" 
                + d.getEntreprise() + 
                ", etat=" + 
                d.isEtat() + '}';
    }
}
