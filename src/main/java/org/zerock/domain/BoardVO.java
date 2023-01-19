package org.zerock.domain;

import java.util.Date;

import lombok.Data;

// VO를 만든 이유는 오라클DB의 접속해서 db에 있는 데이터를 웹애플리케이션에서 처리하여 이 클래스에서 대응이 되는 필드를 만들어준다.(오라클 db에서 데이터를 저장)
// 오라클 db를 불러와서 값을 저장 받고 그값을 사용하려하는 클래스
// 예를 들어 게시판을 저장한다고 할때 사용 게시판의 값 그 차제이다. 보통의 데이터베이스의 칼럼과 VO객체는 같다고 보면 된다.
@Data
public class BoardVO {
	
	private Long bno; // 나중에 db에서 데이터가 오면  그값을 쓸는거
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;
	
	
	
}
