package org.zerock.domain;

import lombok.Data;

@Data // 특정하게 객체를 만들지 않고 기본 자동으로 상성하려면 @Data 어노테이션을 쓴다.
public class SampleDTO {

	// VO (value object) 클래스
	//DTO(Data Transfer Object) 클래스 VO랑 DTO 비슷한거
	// 계층간 데이터 교환을 하기 위해 사용하는 객체
	
	private String name;
	private int age;
	
	
}
