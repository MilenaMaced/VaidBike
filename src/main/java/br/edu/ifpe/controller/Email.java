/*MIT License

Copyright (c) 2018 Milena dos Santos Macedo, Carlos André Cordeiro da Silva,
Adrielly Calado Sales, Lucas Mendes Cavalcanti. 

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

package br.edu.ifpe.controller;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Milena Macedo  <milenasantosmcd@gmail.com>
 */
public class Email {
    
    
    	public void postMail(String recipient, String subject, String message, String from){
		boolean debug = false;

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Authenticator auth = new SMTPAuthenticator();
		Session session = Session.getDefaultInstance(props, auth);

		session.setDebug(debug);

		Message msg = new MimeMessage(session);

		InternetAddress addressFrom;
		try {
			addressFrom = new InternetAddress(from);

			msg.setFrom(addressFrom);

			InternetAddress[] addressTo = new InternetAddress[1];
			addressTo[0] = new InternetAddress(recipient);
			msg.setRecipients(Message.RecipientType.TO, addressTo);

			msg.setSubject(subject);
			msg.setContent(message, "text/plain");
			Transport.send(msg);
		} catch (AddressException e) {
			//LoggerPTD.getLoggerInstance().logError(e.getMessage());
		} catch (MessagingException e) {
			//LoggerPTD.getLoggerInstance().logError(e.getMessage());
		}
	}

	private class SMTPAuthenticator extends javax.mail.Authenticator {

		public PasswordAuthentication getPasswordAuthentication() {
			
			return new PasswordAuthentication("vaidbikegus@gmail.com", "vaidbike2018");
		}
    
        }
}
