package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
//@RunWith 어노테이션은 현재 테스트 코드가 스프링을 실행하는 역할을 할 것이이라는 것을 나타냅니다.
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration 어노테이션은 속성값의 문자열 설정으로 지정된 클래스나 문자열을 이용해서
//필요한 객체들을 스프링 내에 객체로 등록하게 됩니다(이것을 스프링의 빈으로 등록된다고 표현합니다)
//이때, SpringMVC 프로젝트 생성시 자동으로 생성된 root-context.xml 경로 지정을 할 수도 있으며,
//보통 문자열은 'classpath:'나 'file:'을 이용할 수 있습니다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//@Log4j 어노테이션은 Lombok을 이용해서 로그를 기록하는 Logger를 변수로 생성합니다.
//별도의 Logger 객체의 선언이 없이도 Log4j 라이브러리와 설정이 존재한다면 바로 사용이 가능합니다.

@Log4j
public class BoardMapperTests {
	
	@Setter(onMethod_ = @Autowired )
	private BoardMapper mapper;

//	@Test
//	public void testGetList() {
//		mapper.getList().forEach(board -> log.info(board));// 보드객체를 보여달라고 하는거 BoardVO클래스에 필드멤버들
//	}
//	
//	@Test
//	public void testInsert() {
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 작성하는 글");
//		board.setContent("새로 작성하는 내용");
//		board.setWriter("newbie");
//		mapper.insert(board);
//		
//		log.info(board);
//		
//	}
//	
//	@Test
//	public void testInsertSelectKey() {
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 작성하는 글 select key");
//		board.setContent("새로 잓성하는 내용 select key");
//		board.setWriter("kimgs");
//		
//		mapper.insertSelectKey(board);
//		
//		log.info(board);
//	}
	
//	@Test
//	public void testRead() {
//		// 기존에 존재하는 게시물 번호(bno)로 테스트
//		BoardVO board = mapper.read(5L);
//		
//		log.info(board);
//		
//	}
//	
//	@Test
//	public void testDelete() {
//		log.info("DELETE COUNT = " + mapper.delete(3L));
//	}
//	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		// 수정 (update) 실행 전에 , 먼저 존재하는 번호인지 확인을 하게 합니다.
		board.setBno(5L);
		board.setTitle("수정된 글 update");
		board.setContent("수정된 내용 update");
		board.setWriter("chulgu");
		//updateDate는 안건드려도됨 sysDate로 사용중이기 때문
		
		int count = mapper.update(board); // 여기서 갱신된 값을 count에 저장
		log.info("UPDATE COUNT : " + count); // count값을 로그로 보여준다.
		
	}

}
