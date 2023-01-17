package com.example.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.Repository.userDeatilsModelRepository;
import com.example.entity.EmailDetails;
import com.example.entity.UserDetailsModel;

@Service
public class userService {

	@Autowired
	private userDeatilsModelRepository userDetailsrepo;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	 @Value("${spring.mail.username}")
	 private String sender;
	//private String sender="suhelafghan@gmail.com";

	public Map<String, Object> saveUserDetails(UserDetailsModel userDetailsModel) {

		Optional<UserDetailsModel> data = userDetailsrepo.findByemail(userDetailsModel.getEmail());
		Map<String, Object> responseMap = new HashMap<>();
		if (!data.isPresent()) {
			userDetailsrepo.save(userDetailsModel);
			EmailDetails details=new EmailDetails();
			
			
			details.setRecipient("sumiyaagri0215@gmail.com");
			details.setSubject("Test Mail From swapna");
			details.setMsgBody("Hi this is for testing prupose");
			String response = sendSimpleMail(details);
			responseMap.put("data", userDetailsModel);
			responseMap.put("mailStatus", response);
		} else {
			responseMap.put("data", "Email already Exists");
		}

		return responseMap;

	}

	public String sendSimpleMail(EmailDetails details) {

		// Try block to check for exceptions
		try {

			// Creating a simple mail message
			SimpleMailMessage mailMessage = new SimpleMailMessage();

			
			// Setting up necessary details
			mailMessage.setTo(details.getRecipient());
			mailMessage.setText(details.getMsgBody());
			mailMessage.setSubject(details.getSubject());

			// Sending the mail
			javaMailSender.send(mailMessage);
			return "Mail Sent Successfully...";
		}
		// Catch block to handle the exceptions
		catch (Exception e) {
			e.printStackTrace();
			return "Error while Sending Mail";
		}
	}

	public Iterable<UserDetailsModel> getUserDetails() {
		// TODO Auto-generated method stub
	
		return userDetailsrepo.findAll();
	}

}
