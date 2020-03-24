package com.ms.board.Service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ms.board.Dao.MongoDao;
import com.ms.board.Vo.BoardVo;

@Service
public class MongoService {

	@Inject
	MongoDao mongoDao;
	
	public List<BoardVo> boardList(){
		
		return mongoDao.boardList();
	}
	
	public BoardVo detail(String id) {
		
		return mongoDao.getPost(id);
	}
}
