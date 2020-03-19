package com.ms.board.Dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ms.board.Vo.BoardVo;

@Repository("BoardDao")
public class BoardDao {

	@Inject
	private SqlSession sqlSession;
	
	private String Namespace = "com.ms.board.Dao.BoardDao";
	
	public List<BoardVo> getBoardList() throws Exception{
		
		return sqlSession.selectList(Namespace + ".boardList");
	}
	
	public void insertPosts(BoardVo posts) throws Exception{
		
		sqlSession.insert(Namespace + ".write", posts);
	}
	
	public BoardVo detailPosts(int bno) throws Exception{
		
		return sqlSession.selectOne(Namespace + ".detail", bno);
	}
	
	public void deletePosts(int bno) throws Exception{
		
		sqlSession.delete(Namespace + ".delete", bno);
	}
	
	public void updatePosts(BoardVo posts) throws Exception{
		
		sqlSession.update(Namespace + ".update", posts);
	}
}
