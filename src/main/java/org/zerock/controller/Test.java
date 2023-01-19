package org.zerock.controller;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter// @getter @setter에노테이션으로 자바 소스코드에는 없지만 컴파일된 class 파일에는 get set 메소드가 만들어 지는데 이 기능이 되는 것은 lombok가 해준다 
public class Test {
	
	private String name;
	private int age;
}

