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
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


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
	private mailClient mailservice;


	@GetMapping("/getById/{id}")
	public userResponce getById(@PathVariable String id) {
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
			@RequestParam("role") Role role,
			@RequestParam("image") MultipartFile image) throws IOException
	{

		log.log("inside addOneForm");
		String imgId = fus.uploadFile("profileImages/", image);
		user item = new user(username,password,fullname,location,email,phoneNo,role,null,about ,new fileData(imgId));

		//generate 6-digit random number for otp
		Random random = new Random();
		int randomNumber = random.nextInt(900000) + 100000;
		otps.put(email, randomNumber);

		//mail otp to given email
		mailservice.sendMail(email, "verify otp", "please enter this otp to proceed\n"+ String.valueOf(randomNumber));
		accounts.put(email, item);
		System.out.println("----------------------------------------------request recived...");
		return "An otp has been sent ot your email ...!";
	}

	@PostMapping("/verfyOTP")
	public String verifyOTP(@RequestParam("otp") Integer otp, @RequestParam("email") String email ) {

		log.log("inside verifyOTP");

		System.out.println("\nMethod 2: Using keySet()");
		for (String key : otps.keySet()) {
			Integer value = otps.get(key);
			System.out.println(key + ": " + value);
		}
		Integer originalOTP = otps.get(email);
		System.out.println(otp+"-----"+originalOTP);
		if(otp.equals(originalOTP)) {
			service.addOneUser(accounts.get(email));

			otps.remove(email);
			accounts.remove(email);
			return "account verified...!";
		}
		else {

			Random random = new Random();
			int randomNumber = random.nextInt(900000) + 100000;
			otps.put(email, randomNumber);
			mailservice.sendMail(email, "verify otp", "please enter this otp to proceed\n"+ String.valueOf(randomNumber));
			return "invalid otp,\n another otp has been sent to your email please verify..!";
		}
	}


	@GetMapping("/downloadImage/{imgID}")
	public ResponseEntity<byte[]> downloadFile(@PathVariable String imgID) throws IOException{

		System.out.println("----> imgId --->"+imgID);

		return fus.downloadFile(imgID);
	}


}


