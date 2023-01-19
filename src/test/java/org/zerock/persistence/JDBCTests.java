package org.zerock.persistence;
				// persistence 연속성 연속적인 데이터 관리


// 프로젝트의 JDBC 테스트 코드
//JDBC 드라이버가 정상적으로 추가되었고, 데이터베이스의 연결이 가능하다면 이를 눈으로 확인할 수 있게 테스트 코드를 작성해야한다.
// 테스트 코드는 JAVA와 JDBC 드라이버마능로 구현해서 먼저 테스트를 진행해야한다.
// 데이터 베이스 연결이 가능하다면 정상적으로 데이터 베이스가 연결된 Connection 객체가 출력된다.
//핵심!!! 만일 데이터베이스에 어떤 문제가 있거나, JDBC드라이버에 문제가 있다면 이후의 코딩을 작성할 수 없기 때문에 반드시 테스트 코드를 만들어서 확인해야한다!!!
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("에러가 발생했습니다.");
			e.printStackTrace();
		}
		
		
		
	}
	@Test
	public void testConnection() {
		try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "book_ex", "book_ex")) {
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
}
