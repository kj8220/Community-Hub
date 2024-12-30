package io.github.roopan.rc.email;

public interface EmailService 
{
	String mailContentBuilder(String mailContent);
	
	void sendMail(Email notificationEmail);
}
