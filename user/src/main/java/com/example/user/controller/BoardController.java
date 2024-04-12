package com.example.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.user.app.data.dto.BoardDto;
import com.example.user.app.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
	String dir= "board/";

	private final BoardService boardService;

	@RequestMapping("/add")
	public String add(Model model){
		model.addAttribute("center",dir+"add");
		return "index";
	}

	@RequestMapping("/addimpl")
	public String addimpl(Model model, BoardDto boardDto){

		try {
			boardService.add(boardDto);
		} catch (Exception e) {
			//throw new RuntimeException(e);
			model.addAttribute("center",dir+"registerfail");
			return "index";
		}

		return "redirect:/board/get";
	}

	@RequestMapping("/get")
	public String get(Model model) throws Exception {
		List<BoardDto> list = null;
		list = boardService.get();

		model.addAttribute("boards",list);

		model.addAttribute("center",dir+"get");
		return "index";
	}
}
