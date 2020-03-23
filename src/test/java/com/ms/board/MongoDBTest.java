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
	public void QueryTest() {
		
		List<BoardVo> documents = mongoDao.find("test1");
		for(int i=0; i<documents.size(); i++) {
			logger.info("result : " + documents.get(i).getContent());
		}
	}
}
