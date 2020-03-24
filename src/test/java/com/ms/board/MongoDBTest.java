package com.ms.board;

import java.util.List;

import javax.inject.Inject;

import org.bson.Document;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ms.board.Dao.MongoDao;
import com.ms.board.Vo.BoardVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
		"classpath:spring/root-context.xml",
		"classpath:spring/dataSource-context.xml"
		})
public class MongoDBTest {

	private static final Logger logger = LoggerFactory.getLogger(boardDaoTest.class);
	
	@Inject
	private MongoDao mongoDao;
	
	@Test
	@Ignore
	public void ConnectTest() {
		
		Document document = new Document("item", "canvas")
				.append("qty", 100)
				.append("tags", "cotton");
		mongoDao.insertOne(document);
	}
	
	@Test
	@Ignore
	public void boardListTest() {
		
		List<BoardVo> list = mongoDao.boardList();
		for(BoardVo post : list) {
			logger.info("title : " + post.getTitle());
			logger.info("content : " + post.getContent());
		}
	}
	
	@Test
	public void postTest() {
		
		BoardVo post = mongoDao.getPost("5e79a218ee8dacd24c9939ac");
		logger.info("title : " + post.getTitle());
		logger.info("content : " + post.getContent());
	}
}
