package com.ms.board.Controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ms.board.Service.MongoService;
import com.ms.board.Vo.BoardVo;

@Controller
@RequestMapping("/mongo")
public class MongoController {

	@Inject
	MongoService mongoService;
	
	//게시판 리스트
	@RequestMapping(value="/boardList", method=RequestMethod.GET)
	public ModelAndView boardList() {
		
		List<BoardVo> list = mongoService.boardList(); //게시글 리스트
		
		ModelAndView model = new ModelAndView();
		model.setViewName("mongo/index");
		model.addObject("list", list);
		
		return model;
	}
	
	//상세보기
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView detail(@PathVariable String id) {
		
		BoardVo post = mongoService.detail(id); //게시글 상세 정보
		
		ModelAndView model = new ModelAndView();
		model.setViewName("mongo/detail");
		model.addObject("post", post);
		
		return model;
	}
	
	//게시글 작성 페이지
	@RequestMapping(value="/post", method=RequestMethod.GET)
	public String write() {
		
		return "mongo/write";
	}
	
	//게시글 작성 처리
	@RequestMapping(value="/post", method=RequestMethod.POST)
	public String write(BoardVo post) {
		
		mongoService.insertPost(post);
		
		return "redirect:/mongo/boardList";
	}
	
	//게시글 수정 페이지
	@RequestMapping(value="/post/{id}", method=RequestMethod.GET)
	public ModelAndView update(@PathVariable String id) {

		BoardVo post = mongoService.detail(id);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("mongo/update");
		model.addObject("post", post);
		
		return model;
	}
	
	//게시글 수정 처리
	@RequestMapping(value="/post/{id}", method=RequestMethod.PUT)
	public String update(@PathVariable String id, BoardVo updatePost) {
		
		BoardVo post = mongoService.updatePost(updatePost);
		
		return "redirect:/mongo/" + post.getId();
	}
	
	//게시글 삭제 처리
	@RequestMapping(value="/post/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable String id) {
		
		mongoService.deletePost(id);
		
		return "redirect:/mongo/boardList";
	}
}
