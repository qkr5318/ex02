package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;

// 기능명세서 == 설계도 같은거 프레젠테이션 계층과 영속 계층의 중간 다리 역할
public interface BoardService {

	// BoardVO에 register가 등록을 시켜주는 
	public void register(BoardVO board);
	
	// 번호글 식별번호 bno(특정한)로 게시글을 가져오는 get() 메서드는 처음부터 메서드의 리턴 타입을 결정해서 진행할 수 있다.
	public BoardVO  get(Long bno);
	
	// 게시물을 수정하겠다는
	public boolean modify(BoardVO board);
	
	// bno로 게시글을 삭제하겠다는
	public boolean remove(Long bno);
	
	// 전체 리스트를 구하는 getList() 메서드는 처음부터 메서드의 리턴 타입을 결정해서 진행할 수 있다.
	public List<BoardVO> getList();
	
}
