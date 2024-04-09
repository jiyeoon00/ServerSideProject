package com.example.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@RequestMapping("/")
	public String main() {
		return "index";
	}

	@RequestMapping("/login")
	public String login(Model model){
		model.addAttribute("center","login");
		return "index";
	}

	@RequestMapping("/logout")
	public String logout(Model model, HttpSession httpSession){
		if(httpSession != null){
			httpSession.invalidate();
		}
		return "index";
	}

	@RequestMapping("/loginimpl")
	public String loginimpl(
		Model model,
		@RequestParam("id") String id,
		@RequestParam("pwd") String pwd,
		HttpSession httpSession)
	{
		if(id.equals("qqq") && pwd.equals("111")) {
			httpSession.setAttribute("id", id);
		} else {
			model.addAttribute("center","loginfail");
		}
		return "index";
	}

	@RequestMapping("/register")
	public String register(Model model){
		model.addAttribute("center","register");
		return "index";
	}
}
