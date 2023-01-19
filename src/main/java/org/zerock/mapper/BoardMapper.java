package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

// mybatis와 연계해주어 사용하려고 만드는 인터페이스
public interface BoardMapper {
	
	
	// page185 마이바티스 @Select 애노테이션 활용 게시판 글 조회
	// SQL을 작성할떄는 반드시 ';'이 없도록 작성해야한다.
//	// tbl_board에 bno가 0보다 큰거를 보여달라고 하는 쿼리문
//	@Select("select * from tbl_board where bno > 0")
//	public List<BoardVO> getList();
//	
	
	// page187 mybatis xml 활용 게시판 글 조회 연습
	public List<BoardVO> getList();
	
	public void insert(BoardVO vo);
	
	public void insertSelectKey(BoardVO board);
	
	// BoardVO 객체에 있는  bno를 기준을 읽겠다. bno를 지정한 이유는 NotNull이면서 중복되지 않는 값인 bno이기 때문에 bno를 기준으로 조회하겠다 라는 의미
	//즉, bno는 식별번호 주민등록번호같은 거다.
	public BoardVO read(Long bno);
	
	public int delete(long bno);
	
	// 기존 내용을 업데이트 메소드가 처리하겠다는 말  즉, 게시물이 있는 상태에서 update를 하겠다는 (BoardVO)
	public int update(BoardVO board);
	
	
	
	
}
