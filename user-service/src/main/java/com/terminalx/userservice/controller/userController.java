package com.terminalx.userservice.controller;

import com.terminalx.userservice.client.mailClient;
import com.terminalx.userservice.dto.userResponce;
import com.terminalx.userservice.loger.Log;
import com.terminalx.userservice.model.Role;
import com.terminalx.userservice.model.fileData;
import com.terminalx.userservice.model.user;
import com.terminalx.userservice.repository.userRepository;
import com.terminalx.userservice.service.fileUploadService;
import com.terminalx.userservice.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class userController {

	Log log = new Log("user","controller","userController");
	static HashMap<String, user> accounts = new HashMap<>();
	static HashMap<String, Integer> otps = new HashMap<>();

	@Autowired
	userService service;
	@Autowired
	userRepository userrepo;
	@Autowired
	fileUploadService fus;

	@Autowired
	private WebClient webClient;


	@GetMapping("/temp")
	public String temp(){
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("http://localhost:8082/mail")
				.queryParam("name", "Arqham");

		return webClient.get()
				.uri(builder.toUriString())
				.retrieve()
				.bodyToMono(String.class)
				.block();
	}

	@GetMapping("/getById/{id}")
	public user getById(@PathVariable String id) {
		return service.getOne(id);
	}

	@GetMapping("/getAll")
	public List<userResponce> getAll() {

		return service.getAll();
	}

	@PostMapping("/addUser")
	public String addUser(@RequestBody user d) {

		return service.addOneUser(d);
	}

	@PostMapping("/addOneFormData")
	public String addOneFormData(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("fullname")String fullname,
			@RequestParam("location")String location,
			@RequestParam("email") String email,
			@RequestParam("phoneNo")long phoneNo,
			@RequestParam("about") String about ,
			@RequestParam("role") String role,
			@RequestParam("image") MultipartFile image) throws IOException
	{

		log.log("inside addOneForm");
		fileData filedata = new fileData();
		filedata= fus.fileUpload(image);
		String imgPath = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/user/download/")
				.path(filedata.getId()).toUriString();
		Role selectedRole = Role.valueOf(role.toUpperCase());
		user item = new user(username,password,fullname,location,email,phoneNo,selectedRole, LocalDate.now(),about ,imgPath);


			//generate 6-digit random number for otp
		Random random = new Random();
		int randomNumber = random.nextInt(900000) + 100000;
		otps.put(email, randomNumber);

		//mail otp to given email
	//	mailservice.sendMail(email, "verify otp", "please enter this otp to proceed\n"+ String.valueOf(randomNumber));

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("http://localhost:8082/mail/sendMail")
				.queryParam("to", email)
				.queryParam("subject", "verify otp")
				.queryParam("body", String.valueOf(randomNumber));

		webClient.get()
				.uri(builder.toUriString())
				.retrieve()
				.bodyToMono(String.class)
				.block();


		accounts.put(email, item);
		System.out.println("----------------------------------------------request recived...");
		return "An otp has been sent ot your email ...!";
	}

	@PostMapping("/verfyOTP")
	public boolean verifyOTP(@RequestParam("otp") Integer otp, @RequestParam("email") String email ) {

		log.log("inside verifyOTP");


		Integer originalOTP = otps.get(email);
		System.out.println(otp+"-----"+originalOTP);
		if(otp.equals(originalOTP)) {
			service.addOneUser(accounts.get(email));

			otps.remove(email);
			accounts.remove(email);
			return true;
		}
		else {

			Random random = new Random();
			int randomNumber = random.nextInt(900000) + 100000;
			otps.put(email, randomNumber);

			UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("http://localhost:8082/mail/sendMail")
					.queryParam("to", email)
					.queryParam("subject", "verify otp")
					.queryParam("body", String.valueOf(randomNumber));

			webClient.get()
					.uri(builder.toUriString())
					.retrieve()
					.bodyToMono(String.class)
					.block();

			return false;
		}
	}

	@PostMapping("/authenticate")
	public String authenticate(@RequestParam("username") String username,@RequestParam("password") String password){
		return service.authenticate(username,password);
	}


	@GetMapping("/download/{fileId}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception {
		fileData attachment = null;
		attachment = fus.fileDowload(fileId);
		return  ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(attachment.getType()))
				.header(HttpHeaders.CONTENT_DISPOSITION,
						"attachment; filename=\"" + attachment.getName()
								+ "\"")
				.body(new ByteArrayResource(attachment.getData()));
	}
}


