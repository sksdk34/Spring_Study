package com.ms.board.Controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.board.Service.BoardService;
import com.ms.board.Vo.BoardVo;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ApiController {

	@Inject
	BoardService boardService;
	
	@GetMapping("/hello")
	public String hello() {
		
		System.out.println("test");
		
		return "SEOP";
	}
	
	@GetMapping("/test")
	public List<BoardVo> list(Model model) throws Exception {
		
		List<BoardVo> list = boardService.getBoardList();
		
		return list;
	}
}
