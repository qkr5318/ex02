package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


//@AllArgsConstructor // 생성자 만들어줌
//@RequiredArgsConstructor
@Getter
@ToString
@Component
public class SampleHotel {

//	@NonNull
	private Chef chef;
	
		// 스프링 4.3 버전 이후에 단일 생성자의 묵시적 자동 주입이 가능하게 되었습니다.
	   // Restaurant.java 소스에서 13행의 @Setter(onMethod_ = @Autowired) 비교 바랍니다.
	public SampleHotel(Chef chef) {   //@AllArgsConstructor 어노테이션을 기술하면 생성자 자동 생성됨
		this.chef = chef;
	}
	
	
}
