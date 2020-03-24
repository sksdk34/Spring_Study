package com.ms.board.Dao;

import java.util.List;

import javax.inject.Inject;

import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
	
	public void insertOne(Document document) {
		
//		Map<String, Object> map = new HashMap<>();
//		map.put("title", data.getTitle());
//		map.put("contents", data.getContent());
//		mongoTemplate.insert(map, "inventory");
		mongoTemplate.insert(document, "inventory");
	}
	
	public List<BoardVo> find(String item){
		
		Criteria criteria = new Criteria("title").is(item);
		Query query = new Query(criteria);
		
		return mongoTemplate.find(query, BoardVo.class, "inventory");
//		return mongoTemplate.findAll(BoardVo.class, "inventory");
	}
}
