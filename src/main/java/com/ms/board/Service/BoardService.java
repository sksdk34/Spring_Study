package com.ms.board.Service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ms.board.Dao.BoardDao;
import com.ms.board.Vo.BoardVo;

@Service
public class BoardService {
	
	@Inject
	private BoardDao boardDao;
	
	public List<BoardVo> getBoardList() throws Exception{
		
		return boardDao.getBoardList();
	}
	
	public void insertPosts(BoardVo posts) throws Exception{
		
		boardDao.insertPosts(posts);
	}
	
	public BoardVo detailPosts(int bno) throws Exception{
		
		return boardDao.detailPosts(bno);
	}
	
	public void deletePosts(int bno) throws Exception{
		
		boardDao.deletePosts(bno);
	}
	
	public void updatePosts(BoardVo posts) throws Exception{
		
		boardDao.updatePosts(posts);
	}
}
