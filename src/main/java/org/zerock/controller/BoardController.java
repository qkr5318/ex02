package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Controller // 스프링의 빈으로 인식할 수 있게 
@Log4j 	// 로그 활용
@RequestMapping("/board/*") // borad로 시작하는 모든 처리를 BoardController가 하도록 지정
@AllArgsConstructor
public class BoardController {

		private BoardService service; // BoardService 생성자에 모든 인자값을 파라미터로 사용
		
		@GetMapping("/list")
		public void list(Model model) {
			log.info("list");
			model.addAttribute("list", service.getList());
		}
	
		// register() 메서드는 조금 다르게 String을 리턴 타입으로 지정하고,
		// RedirectAttributes를 파라미터로 지정합니다. 이것은 등록 작업이(register) 끝난 후
		// 다시 목록화면으로 이동하기 위함인데, 추가적으로 새롭게 등록된 게시물의 번호를 같이 전달하기 위해서
		// RedirectAttributes를 이용합니다. 리턴 시에는 'redirect:' 접두어를 사용하는
		// 이를 이용하면 스프링 MVC가 내부적으로 response.sendRedirect()를 처리해 주기 때문에 편리합니다.
		@PostMapping("/register")
		public String register(BoardVO board, RedirectAttributes rttr) {
			log.info("register : " + board);
			service.register(board);
			rttr.addFlashAttribute("result", board.getBno());
			return "redirect:/board/list";
		}
		
		@GetMapping("/get")
		public void  get(@RequestParam("bno") Long bno, Model model) {
			log.info("/get");
			model.addAttribute("board", service.get(bno));
		}
		
		@PostMapping("/modify")
		public String modify(BoardVO board, RedirectAttributes rttr) {
			log.info("modify : " + board);
			
			if (service.modify(board)) {
				rttr.addFlashAttribute("result", "success");
				
			}
			return "redirect:/board/list";
		}
		
		@PostMapping("/remove")
		public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
			log.info("remove.........." + bno);
			
			if(service.remove(bno)) {
				rttr.addFlashAttribute("result", "success");
			}
			return "redirect:/board/list";
		}
	
	
	
}
