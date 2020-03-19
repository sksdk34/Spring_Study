package com.ms.board;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/dataSource-context.xml"})
public class MySqlConnectionTest {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MySqlConnectionTest.class);
	
	@Inject
	private DataSource ds;
	
	@Test
	public void testConnection() throws SQLException {
		try(Connection con = ds.getConnection()){
			logger.info("MySQL Connection Success : " + con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
