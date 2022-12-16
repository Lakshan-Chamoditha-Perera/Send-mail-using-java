package mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mail implements Runnable {
    private String msg;
    private String to;
    private String subject;
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void outMail() throws MessagingException {
        String from = "softwareengineeringIJSE@gmail.com"; //sender's email address
        String host = "localhost";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("softwareengineeringIJSE@gmail.com", "boetfzbejjithdve");  // have to change some settings in SMTP
            }
        });

        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress(from));
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        mimeMessage.setSubject(this.subject);
        mimeMessage.setText(this.msg);
        Transport.send(mimeMessage);

        System.out.println("sent");
    }

    @Override
    public void run() {
        if (msg != null) {
            try {
                outMail();
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("not sent. empty msg!");
        }
    }
}