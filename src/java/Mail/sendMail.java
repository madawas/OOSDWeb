package Mail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class sendMail {

    private static Message setUp() {
        final String username = "slomfoundation@gmail.com";

        final String password = "mathcat@slomf";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("slomfoundation@gmail.com"));
            
            return message;

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    
    public static void sendmail(String email, String title, String text) {
        Message message = setUp();        
        try {
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject(title);
            message.setText(text);
            Transport.send(message);
        } catch (MessagingException ex) {   
            ex.printStackTrace();
        }
    }
    public static void sendmail(String emailTo, String emailReplyTo, String title, String text) {
        Message message = setUp();
        try {
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(emailTo));
            message.setSubject(title);
            message.setText(text);
            message.setReplyTo(InternetAddress.parse(emailReplyTo));
            Transport.send(message);
        } catch (MessagingException ex) {   
            ex.printStackTrace();
        }
    }
    public static void sendUs(String name,String address,String email,String message){
        String eAddress="slomfoundation@gmail.com";
        message = "Name : "+name+"   "+"Home address : "+address+"   "+"Email : "+email+"    "+"Message : "+message;
        sendmail(eAddress,"Contact SLMO",message);
    }    
}