package com.kh.test.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.test.user.model.service.UserService;
import com.kh.test.user.model.vo.User;

@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/home")
	public String home(){
		
		return "/index";
	}
	
	
	@PostMapping("/searchSuccess")
	public String searchSuccess(@RequestParam(value="userId") String userId, Model model,RedirectAttributes ra,User user) {
		
		User userList =  service.searchUser(userId);
		model.addAttribute("userList", userList);
		
		
		if(userList !=null) {
			
			ra.addFlashAttribute("message","성공");
			return "/searchSuccess";
			
		
		}else {
			
			ra.addFlashAttribute("message","실패");
			return "/searchFail";
		}
	
	}
	
}
