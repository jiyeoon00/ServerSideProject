package com.example.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.user.app.data.dto.CustDto;
import com.example.user.app.service.CustService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/cust")
@RequiredArgsConstructor
public class CustController {
	String dir= "cust/";

	private final CustService custService;

	@RequestMapping("/")
	public String main(Model model){
		model.addAttribute("left", dir+"left");
		model.addAttribute("center",dir+"center");
		return "index";
	}

	@RequestMapping("/add")
	public String add(Model model){
		model.addAttribute("left", dir+"left");
		model.addAttribute("center",dir+"add");
		return "index";
	}

	@RequestMapping("/addimpl")
	public String addimpl(Model model, CustDto custDto){
		try {
			custService.add(custDto);
		} catch (Exception e) {
			//throw new RuntimeException(e);
			model.addAttribute("center","registerfail");
			return "index";
		}

		return "redirect:/cust/get";
	}

	@RequestMapping("/get")
	public String get(Model model){
		List<CustDto> list = null;
		try {
			list = custService.get();
			model.addAttribute("custs", list);
			model.addAttribute("left", dir+"left");
			model.addAttribute("center",dir+"get");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return "index";
	}

	@RequestMapping("/detail")
	public String detail(Model model,@RequestParam("id") String id){
		CustDto custDto = null;
		try {
			custDto = custService.get(id);
			model.addAttribute("cust", custDto);
			model.addAttribute("left", dir+"left");
			model.addAttribute("center",dir+"detail");
		} catch (Exception e) {
			//throw new RuntimeException(e);
			model.addAttribute("left", dir+"left");
			model.addAttribute("center","registerfail");
		}
		return "index";
	}
}
