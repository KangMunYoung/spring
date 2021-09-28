package com.bitcamp.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	public BoardDAO dao = new BoardDAO();

	@RequestMapping("/board/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.allRecord());
		mav.setViewName("board/list");
		return mav;
	};
	@RequestMapping("/board/write")
	public String write() {
		return "board/write";
	}
	@RequestMapping(value="/board/writeOk", method = RequestMethod.POST)
	public ModelAndView writeOk(BoardVO vo, HttpServletRequest req, HttpSession ses ) {
		ModelAndView mav = new ModelAndView();
		vo.setIp(req.getRemoteAddr());
		vo.setUserid((String)ses.getAttribute("userid"));
		int result = dao.boardInsert(vo);
		
		mav.setViewName("redirect:list");
		return mav;
	}
}
