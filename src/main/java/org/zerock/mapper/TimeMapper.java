package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
		// sysdate는 오라클에 현재시간을 알려주는 명령문
	@Select("SELECT SYSDATE FROM DUAL")
	public String getTime();
	
		//위처럼 어노테이션 Select를 이용하지 않고 xml을 만들어서 쿼리문과 맵핑해서 현재시간을 가져오는 것을 만드는
		// xml을 사용하는 이유는 큰규모에서 사용할때 정리하기가 어렵기 때문에 xml에 정의를 하여 유지보수에 편의성을 갖게되어 큰 규모에 xml에 정의하는 식으로 사용한다.
	//  xml을 인지하려면 같은 패키지 위치에 있어야 한다. 
	public String getTime2();
	
	
}
