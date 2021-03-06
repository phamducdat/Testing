package com.infybuzz.app;

import java.io.File;
import java.io.IOException;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.ui.Model;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.ResourceUtils;

@Service
public class EmailService {
	
	@Autowired
	JavaMailSender javaMailSender;

	@Autowired
	private Configuration config;

	public String sendEmail() {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom("phamducdat2402@gmail.com");
		message.setTo("phamducdat2402@gmail.com");
		message.setSubject("Test Subject");
		message.setText("Test Body");
		
		javaMailSender.send(message);
		
		return "Mail sent successfully";
	}
	
	public String sendEmailwithAttachment() {
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			
			MimeMessageHelper messageHelper = 
					new MimeMessageHelper(message, true);
			
			messageHelper.setFrom("");
			messageHelper.setTo("");
			messageHelper.setSubject("Test Subject");
			messageHelper.setText("Test Body");
			
			File file = new File("Path To File");
			
			messageHelper.addAttachment(file.getName(), file);
			
			javaMailSender.send(message);
			
			return "Mail sent successfully";
			
		} catch (Exception e) {
			return "Mail sent failed";
		}
	}

	public String sendEmailWithTemplate() {
		try {
//			int year = Calendar.getInstance().get(Calendar.YEAR);
			Year year = Year.now();
			MimeMessage message = javaMailSender.createMimeMessage();

			MimeMessageHelper messageHelper =
					new MimeMessageHelper(message, true);
			//model c?? th??? ?????t b???ng null n???u nh?? kh??ng c?? thu???c t??nh n??o c???n thay th???
			Map<String, Object> model = new HashMap<>();

			model.put("name", "L?? Tu???n Anh");
			model.put("username", "tuanlatuan");
			//Qua trinh chuyen doi template sang string
			Template t = config.getTemplate("email-template.html");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(t,model);
			//Thay the logo
//			FileSystemResource resource = new FileSystemResource(new File("logo.png"));
			File resource = ResourceUtils.getFile("classpath:logo.png");
			messageHelper.setFrom("phamducdat2402@gmail.com");
			messageHelper.setTo("dat.pd183704@sis.hust.edu.vn");
//			messageHelper.setTo("phamducdat2402@gmail.com");
			messageHelper.setSubject("Test Subject");
			messageHelper.setText(html, true);
			//B???t bu???c addInline ph???i sau setText, s??? thay th??? contentld b???ng file,bla,bla,... tuy nhi??n
			//kh??ng thay ???????c b???ng m???i string
			messageHelper.addInline("logo", resource);
			javaMailSender.send(message);

			return "Mail sent successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "Failed";
		}

	}
}
