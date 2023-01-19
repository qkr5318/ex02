package org.zerock.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapperTests;

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
public class BoardServiceTests {

	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	// 존재하는지 테스트 메소드
	@Test
	public void testExist() {
		
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void testRegister() {
		
		//BoardVO 생성자 호출 --> 생성자는 new 연산자를 통해서 인스턴스를 생성할 때 반드시 호출이 되고 제일 먼저 실행되는 일종의 메소드(하지만 메소드와는 다르다.)이다. 
		//생성자는 인스턴스 변수(필드 값 등)를 초기화 시키는 역할을 한다. 
		
		BoardVO board = new BoardVO();
		board.setTitle("서비스 : 새로 작성하는 글");
		board.setContent("서비스 : 새로 작성하는 내용");
		board.setWriter("감스트 작성함");
		
		service.register(board);// DB에서 확인
		
		log.info("생성된 게시물의 번호: " + board.getBno());//application에서 확인
	}
	
	@Test// 글들이 있다면 하나 하나 리스트를 	보여달라고 하는 테스트
	public void testGetList() {
		service.getList().forEach(board -> log.info(board));
	}
	
	@Test // 글 상세 보기
	public void testGet() {
		log.info(service.get(13L));
	}
	
	@Test
	public void testDelete() {
		// 게시물의 번호가 존재하는지 여부를 확인하고 테스트해 봅니다.
		log.info("REMOVE RESULT : " + service.remove(4L));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = service.get(6L);
		if (board == null) {
			return;
		}
		board.setTitle("서비스 : 제목 수정합니다.");
		log.info("MODIFY RESULT : " + service.modify(board));
	}
	
	
	
}
