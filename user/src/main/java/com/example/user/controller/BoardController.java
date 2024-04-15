package com.example.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.user.app.data.dto.BoardDto;
import com.example.user.app.service.BoardService;

import jakarta.servlet.http.HttpSession;
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

	@RequestMapping("/detail")
	public String detail(Model model, @RequestParam("id") int id, HttpSession httpSession) throws Exception {
		BoardDto boardDto = null;
		try {
			boardDto = boardService.get(id);

			if(httpSession != null &&
				!boardDto.getCustId().equals(httpSession.getAttribute("id"))){
				boardService.cntUpdate(id);
			}

			model.addAttribute("board", boardDto);
			model.addAttribute("center", dir+"detail");
		} catch (Exception exception) {
			throw exception;
		}
		return "index";

	}

	@RequestMapping("/delete")
	public String delete(Model model,@RequestParam("id") int id){

		try {
			boardService.del(id);
			return "redirect:/board/get";
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@RequestMapping("/update")
	public String update(Model model,BoardDto boardDto){

		try {
			boardService.modify(boardDto);
			return "redirect:/board/detail?id="+boardDto.getBoardId();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
