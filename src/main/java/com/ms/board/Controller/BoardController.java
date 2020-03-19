package com.ms.board.Controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ms.board.Service.BoardService;
import com.ms.board.Vo.BoardVo;

@Controller
public class BoardController {

	@Inject
	private BoardService boardService;
	
	//게시판 초기페이지 (글 리스트)
	@RequestMapping(value="/boardList", method=RequestMethod.GET)
	public ModelAndView boardList() throws Exception{
		
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		
		List<BoardVo> boardList = boardService.getBoardList();
		model.addObject("boardList", boardList);
		
		return model;
	}
	
	//게시글 작성
	@RequestMapping(value="/posts", method=RequestMethod.GET)
	public ModelAndView posts() throws Exception{
		
		ModelAndView model = new ModelAndView();
		model.setViewName("write");
				
		return model;
	}
	
	//게시글 작성 처리
	@RequestMapping(value="/posts", method=RequestMethod.POST)
	public String createPosts(BoardVo posts) throws Exception{
		
		boardService.insertPosts(posts);
				
		return "redirect:/boardList";
	}
	
	//게시글 조회
	@RequestMapping(value="/{bno}", method=RequestMethod.GET)
	public ModelAndView detail(@PathVariable int bno) throws Exception{
		
		BoardVo post = boardService.detailPosts(bno);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("detail");
		model.addObject("post", post);
		
		return model;
	}
	
	//게시글 삭제
	@RequestMapping(value="/posts/{bno}", method=RequestMethod.DELETE)
	public String delete(@PathVariable int bno) throws Exception{
		
		boardService.deletePosts(bno);
		
		return "redirect:/boardList";
	}
	
	//게시글 수정
	@RequestMapping(value="/posts/{bno}", method=RequestMethod.GET)
	public ModelAndView update(@PathVariable int bno) throws Exception{
		
		BoardVo posts = boardService.detailPosts(bno);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("update");
		model.addObject("posts", posts);
		
		return model;
	}
	
	//게시글 수정 처리
	@RequestMapping(value="/posts/{bno}", method=RequestMethod.PUT)
	public String updatePosts(@PathVariable int bno, BoardVo posts) throws Exception{
		
		boardService.updatePosts(posts);
		
		return "redirect:/" + bno;
	}
}
