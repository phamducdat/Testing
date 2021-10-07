package com.infybuzz.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmailController {
	
	@Autowired
	EmailService emailService;

	@GetMapping("/sendEmail")
	public String sendEmail() {

		System.out.println("Test for email");
		return emailService.sendEmail();
	}
	
	@GetMapping("/sendEmailwithAttachment")
	public String sendEmailwithAttachment() {

		return emailService.sendEmailwithAttachment();
	}

	@PostMapping("/sendEmailWithTemplate")
	public String sendEmailWithTemplate() {
		return emailService.sendEmailWithTemplate();
	}
	
}
