package eg.net;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtility {

	private final String host = "smtp.gmail.com";
	private final int port = 587;
	private String username = "contactus@lan-nansahom.org";
	private String password = "collectivepass";

	public EmailUtility() {
		super();
	}

	public EmailUtility(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public void sendEmail(String pTo, String pSubject, String pMessage) {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.transport.protocol", "tls");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {

			final Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(pTo));
			message.setSubject(pSubject);
			message.setText(pMessage);

			final Transport transport = session.getTransport("smtp");
			transport.connect(username, password);
			Transport.send(message);
			transport.close();

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
