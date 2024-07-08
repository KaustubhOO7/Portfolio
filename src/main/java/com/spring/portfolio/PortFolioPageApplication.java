package com.spring.portfolio;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@SpringBootApplication
public class PortFolioPageApplication {
		
	@Value("${spring.mail.username}")
	String username;
	
	@Value("${spring.mail.password}")
	String password;
	
	@Autowired
	private JavaMailSender javaMailSender;

	public static void main(String[] args) {
		SpringApplication.run(PortFolioPageApplication.class, args);
	}
	
	@GetMapping("/")
	public String getPage()
	{
		return "Home";
	}
	
	@GetMapping("/res")
	public String getResume()
	{
		return "Resume";
	}
	
	@GetMapping("/projects")
	public String getProjects()
	{
		return "Projects";
	}
	
	@GetMapping("/contact")
	public String getCOntatc()
	{
		return "Contact";
	}
	
	@PostMapping("/sendMail")
	@ResponseBody
	public String send(@RequestBody Map<String,String> map)
	{
		SimpleMailMessage message = new SimpleMailMessage();
		
		 try {
		        message.setFrom(map.get("email1"));
		        message.setTo(username);
		        message.setSubject("Message from "+map.get("email1"));
		        message.setText(map.get("details1"));
		        javaMailSender.send(message);
		        
		        return "mail sent";  
		    } catch (Exception e) {
		        return "Error";  
		    }
	}
	
	

}
