package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")//sample/url 경로 지정해서 mapping 처리
@Log4j // @log4j붉은색 에러나면 pom.xml 파일에서 log4j에 <scope>runtime</scope> 삭제 처리
public class SampleController {
	
	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	//메시지 파일 [/WEB-INF/views/sample.jsp]을(를) 찾을 수 없습니다.
	//p144쪽 void 타입은 url를 jsp파일로 인식한다. 
	// view폴더에 sample.jsp를 삭제하면 404 오류가 뜨며 위에 오류 문구가 나온다
	@RequestMapping("")
	public void basic() {
		log.info("basic..............");
	}
	
	// controller에 파라미터 수집
	
	//ex01메소드는 파라미터값으로 SampleDTO에 @Data 어노테이션으로 만들어진 set메소드가 파라미터 값을 수 집하여 get값으로 호출한다
	// 이때 String name과 int age로 자동 타입 변환시켜주어 콘솔에 호출해준다
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info("" + dto);
		return "ex01";
	}
	
	//@RequestParm 어노테이션을 이용하여 String type에 name 파라미터 , int type에 age를 이용하여 사용가능
	// 기본 자료형이나 문자열 등을 이용한다면 파라미터의 타입만을 맞게 선언해주는 방식을 사용할 수 있다.
	//@RequestParm을 이용하는 이유는 파라미터로 사용된 변수의 이름과 전달되는 파라미터의 이름이 다른 경우에 유용하게 사용가능하다.
	//즉 위방식에 클래스파일에 변수명과 다르게 사용되어질때 코드를 추가하지않고 @RequestParm을 이용하면 유용하다라는 뜻
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name : " + name);
		log.info("age : " + age);
		return "ex02";
	}
	
	// 동일한 이름의 파라미터가 여러 개 전달되는 경우에는 ArrayList<>등을 이용해서 처리 가능
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ids : " + ids);
		return "ex02List";
	}
	
	// SampleDTO와 같이 객체 타입이고 여러개를 처리하야 한다면 SampleDTOList클래스 List<> 사용하여 만들수 있다 
	// 톰캣 버전에 따라 '[]'문자를 특수문자로 허용하지 않을때 '['는 %5B , ']' %5d로 변경하도록한다.
	// 예 : http://localhost:9007/sample/ex02Bean?list%5B0%5D.name=gamst&list%5B2%5D.name=chulgu
		@GetMapping("/ex02Bean")
		public String ex02Bean(SampleDTOList list) {
			log.info("list dtos: " + list);
			return "ex02Bean";
		}
		
		@GetMapping("/ex03")
		public String ex03(TodoDTO todo) {
			log.info("todo : " + todo);
			return "ex03";
		}

		//Model이라는 데이터 전달자
//		@ModelAttribute는 강제로 전달받은 파라미터를 SampleDTO에 담아서 전달하도록 할때 필요한 어노테이션 타입에 관계없이 무조건 DTO에 담아서 전달됨으로 파라미터로
//		전달된 데이터를 다시 화면에서 상요해야할 경우에 사용
		//쿼리문은 디폴트가 String 이라서 int 타입인 page는 값을 브라우저에 호출하지 못한다. 하지만 log에서는 호출값을 받아온다
		@GetMapping("/ex04")
		public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
			log.info("dto : " + dto);
			log.info("page : " + page);
			
			return "/sample/ex04";
		}
		
		// 예제로는 위에 void basic메소드가 더 좋다 
		//메시지 파일 [/WEB-INF/views/sample/ex05.jsp]을(를) 찾을 수 없습니다.
		//p144쪽 void 타입은 url를 jsp파일로 인식한다. 
		// view폴더에 ex05.jsp를 삭제하면 404 오류가 뜨며 위에 오류 문구가 나온다
		@GetMapping("/ex05")
		public void ex05() {
			log.info("/ex05........");
		}
		
		// JSON데이터 사용 p.146 이내용 중요 JSON DATA로 리턴을 받을땐 jackson=datbind 가 필요
		@GetMapping("/ex06")
		public @ResponseBody SampleDTO ex06() {
			log.info("/ex06...............");
			SampleDTO dto = new SampleDTO();
			dto.setAge(30);
			dto.setName("감스트");
			
			return dto;
		}
		
		// ResponseEntity 타입 p148
		@GetMapping("/ex07")
		public ResponseEntity<String> ex07(){
			log.info("/ex07..................");
			
			// {"name" : "감스트"} 웹에는 특수문자로 인식을 못함으로 \를 아래와 같이 사용해야한다
			String msg = "{\"name\" : \"감스트\"}";
			
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", "application/json;charset=UTF-8");
			
			return new ResponseEntity<String>(msg, header, HttpStatus.OK);
		}
		
	

}
