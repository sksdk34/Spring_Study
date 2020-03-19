package com.ms.board;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.board.Dao.BoardDao;
import com.ms.board.Vo.BoardVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
		"classpath:spring/root-context.xml",
		"classpath:spring/dataSource-context.xml"
		})
public class JsonTest {

	private static final Logger logger = LoggerFactory.getLogger(boardDaoTest.class);
	
	@Inject
	private BoardDao boardDao;
	
	@Test
	public void testJson() throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		String testJson = "{\"title\" : \"test title\", \"content\" : \"test content\"}";
		BoardVo convertJson = new BoardVo();
		convertJson = mapper.readValue(testJson, BoardVo.class);
		logger.info(convertJson.getTitle());
		logger.info(convertJson.getContent());
	}
}
