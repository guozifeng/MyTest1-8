package com.guo.offer.testmail;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sun.mail.util.MailSSLSocketFactory;

public class SendEmail {
	public static void main(String[] args) {

		// 收件人电子邮箱
		String to = "guozifengjian@qq.com";

		// 发件人电子邮箱
		String from = "602394902@qq.com";

		// 指定发送邮件的主机为 smtp.qq.com
		String host = "smtp.qq.com"; // QQ 邮件服务器

		// 获取系统属性
		Properties properties = System.getProperties();

		// 设置邮件服务器
		properties.setProperty("mail.smtp.host", host);

		properties.put("mail.smtp.auth", "true");
		MailSSLSocketFactory sf = null;
		try {
			sf = new MailSSLSocketFactory();
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sf.setTrustAllHosts(true);

		properties.put("mail.smtp.auth", "true");
		properties.setProperty("mail.user", "guozifengjian@qq.com");
		properties.setProperty("mail.password", "abcd1234++");

		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.ssl.socketFactory", sf);
		// 获取默认session对象
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("602394902@qq.com", "fvzmostizjlsbebi"); // 发件人邮件用户名、密码
			}
		});

		Address[] aa = new InternetAddress[2];
		try {
			aa[0] = new InternetAddress(to);
			aa[1] = new InternetAddress(from);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			// 创建默认的 MimeMessage 对象。
			MimeMessage message = new MimeMessage(session);

			// Set From: 头部头字段
			message.setFrom(new InternetAddress(from));

			// Set To: 头部头字段
			/*
			 * message.addRecipient(Message.RecipientType.TO, new
			 * InternetAddress(to));
			 */

			message.addRecipients(Message.RecipientType.TO, aa);

			// Set Subject: 头字段
			message.setSubject("This is the Subject Line!");

			// 创建消息部分
			BodyPart messageBodyPart = new MimeBodyPart();

			// 消息
			messageBodyPart.setText("This is message body");

			// 创建多重消息
			Multipart multipart = new MimeMultipart();

			// 设置文本消息部分
			multipart.addBodyPart(messageBodyPart);

			// 附件部分
			messageBodyPart = new MimeBodyPart();
			String filename = "E:/tmp/employee.ser";
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);

			// 发送完整消息
			message.setContent(multipart);

			// 发送消息
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}