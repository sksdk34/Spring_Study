package com.ms.board.Dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.ms.board.Vo.BoardVo;

@Repository("MongoDao")
public class MongoDao {

	@Inject
	private MongoTemplate mongoTemplate;
	
	public List<BoardVo> boardList() {
		
		return mongoTemplate.findAll(BoardVo.class, "board");
	}
	
	public BoardVo getPost(String id) {
		
		Criteria criteria = new Criteria("_id")
				.is(id);
		Query query = new Query(criteria);
		
		return mongoTemplate.findOne(query, BoardVo.class, "board");
	}
	
	public void insertPost(BoardVo post) {
		
		mongoTemplate.insert(post, "board");
	}
	
	public void updatePost(BoardVo post) {
		
		Criteria criteria = new Criteria("_id")
				.is(post.getId());
		Query query = new Query(criteria);
		Update update = new Update()
				.set("title", post.getTitle())
				.set("content", post.getContent());
		
		mongoTemplate.updateFirst(query, update, "board");
	}

	public void deletePost(String id) {
		
		Criteria criteria = new Criteria("_id")
				.is(id);
		Query query = new Query(criteria);
		
		mongoTemplate.remove(query, BoardVo.class, "board");
	}
}
