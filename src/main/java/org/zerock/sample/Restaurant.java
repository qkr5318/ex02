package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Restaurant {
	
	
	@Setter(onMethod_ = @Autowired)// Chef get set를 사용할수 있게 @Autowired 의존성 주입)
	private Chef chef;

}
