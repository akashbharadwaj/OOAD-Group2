package notifications;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
 
public class sendMail extends HttpServlet {

   public void send(String email, String message)
      throws ServletException, IOException {
      
	   final String fromEmail = "urec.utd@gmail.com"; //requires valid gmail id
		final String password = "urecutdemail"; // correct password for gmail id
		final String toEmail = email; // can be any email id 
		
		System.out.println("TLSEmail Start "+ message);
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.port", "587"); //TLS Port
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
               //create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);
		String body = "Hello,\n" +
	               "UREC Anouncement - " + message +"\n\n" +
	               "Regards\n UREC Staff";
		EmailUtil.sendEmail(session, toEmail,"UREC Anouncement", body);
		return;
   }
} 
