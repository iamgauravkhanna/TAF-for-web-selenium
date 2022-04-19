package email;

import logger.TestLogger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailUtil {

    public static void sendEmail(String a, String b, String c, Float percentage, String environment, String subject, String reportLink) {

        String toList = EmailConfig.TO[0];
        String from = EmailConfig.FROM;
        String host = EmailConfig.SERVER;

        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EmailConfig.FROM, EmailConfig.PASSWORD);
            }
        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(toList));

            StringBuilder sb = new StringBuilder();
            sb.append("<html>" +
                    "<body>" +
                    "<table border=\"1\">" +
                    "<tr>" +
                    "<td><strong> No. of TCs Passed </strong></td><td>" + a + "</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td><strong> No. of TCs Failed </strong></td><td>" + b + "</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td><strong> Time Taken (secs) </strong></td><td>" + c + "</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td><strong> Dashboard Link </strong></td><td>" + "http://localhost:8063/" + "</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td><strong> Report Link </strong></td><td>" + reportLink + "</td>" +
                    "</tr>" +
                    "</table></body></html>");

            message.setContent(sb.toString(), "text/html");
            message.setSubject("Test Project" + " : " + environment + " : " + subject + " : " + "TCs - " + (Integer.valueOf(a) + Integer.valueOf(b)) + " : PASS % " + percentage);

            Transport.send(message);

            TestLogger.INFO("Email sent successfully.");

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
