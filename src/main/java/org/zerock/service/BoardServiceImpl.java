package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

//BoardService 구현 클래스 작성
@Log4j
@Service// 객층 구조상 주로 비즈니스 영역을 담당하는 객체임을 표시하기 위해 사용 패키지를 읽어 들이는 동안 처리된다.
@AllArgsConstructor // 모든 파라미터를 이용하는 생성자를 만들기 때문에 BoardMapper를 주입받는 생성자가 만들어지게 된다.
public class BoardServiceImpl implements BoardService {// 정삭적으로 동작하기 위해서는 BoardMapper 객체가 필요

	
	// 아래와 같이 @AutoWired를 직접 설정해 줄 수도 있고, Setter를 이용해서 처리할 수도 있지만
	// @Setter(onMethod_ = @Autowired)
	// 스프링 4.3부터는 단일 파라미터를 받는 생성자의 경우에는 필요한 파라미터를 자동으로 주입할 수 있다.
	// @AllArgsConstructor는 모든 파라미터를 이용하는 생성자를 만들기 때문에
	// 실제 코드는 BoardMapper를 주입받는 생성자가 만들어 진다.
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {
		
		log.info("register............." + board);
		
		mapper.insertSelectKey(board);		
	}

	@Override// 완성되어 있는 글들을 글상세 보기 하나만 전체적으로 보는거
	public BoardVO get(Long bno) {
		log.info("get.............." + bno);
		// BoardMapper에 bno를 이용해서 게시물을 읽어 리턴
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify..........." + board);
		// 정상적으로 수정 처리가 이루어지면 1이라는 값이 반환되기 때문에 '==' 연산자를 이용해서
		// true/false를 처리할 수 있습니다.
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove/..................." + bno);
		// 정상적으로 삭제 처리가 이루어지면 1이라는 값이 반환되기 때문에 '==' 연산자를 이용해서
		// true/false를 처리할 수 있습니다.
		return mapper.delete(bno) == 1;
	}

	@Override// 글목록 보기 
	public List<BoardVO> getList() {
		log.info("getList..........");
		
		return mapper.getList();
	}
	
	
	
	
}
