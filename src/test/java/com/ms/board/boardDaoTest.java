package com.ms.board;

import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ms.board.Dao.BoardDao;
import com.ms.board.Vo.BoardVo;
import com.ms.board.Vo.Orders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
		"classpath:spring/root-context.xml",
		"classpath:spring/dataSource-context.xml"
		})
public class boardDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(boardDaoTest.class);
	
	
	@Inject
	private BoardDao boardDao;
	
	@Test
	public void testJoin() throws Exception{
		
		List<Orders> list = boardDao.testJoin(1);
		for(Orders item : list) {
			logger.info("ono : " + item.getOno());
			logger.info("cno : " + item.getCno());
//			logger.info("ono : " + item.getName());
		}
	}
	
	@Test
	@Ignore
	public void testBoardList() throws Exception{
		
		List<BoardVo> boardList = boardDao.getBoardList();
		logger.info("\nBoard List\n");
		if(boardList.size() > 0) {
			for(BoardVo list:boardList) {
				logger.info(list.getTitle());
			}
		}else {
			logger.info("데이터가 없습니다.");
		}
	}
	
	@Test
	@Ignore
	public void testInsertPosts() throws Exception{
		
		BoardVo posts = new BoardVo();
		posts.setTitle("test");
		posts.setContent("test");
		
		boardDao.insertPosts(posts);
	}
	
	@Test
	@Ignore
	public void testDetailPosts() throws Exception{
		
		int bno = 2;
		BoardVo post = boardDao.detailPosts(bno);
		
		logger.info(post.getTitle());
	}
	
	@Test
	@Ignore
	public void testDeletePosts() throws Exception{
		
		int bno = 3;
		boardDao.deletePosts(bno);
	}
	
	@Test
	@Ignore
	public void testUpdatePosts() throws Exception{
		
		BoardVo posts = new BoardVo();
		posts.setBno(1);
		posts.setTitle("test");
		posts.setContent("contents");
		
		boardDao.updatePosts(posts);
	}
}
