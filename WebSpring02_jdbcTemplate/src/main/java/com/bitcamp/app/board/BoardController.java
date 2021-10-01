package com.bitcamp.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@Autowired
	public BoardDAO dao;
	// public BoardDAO dao = new BoardDAO();

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

	@RequestMapping(value = "/board/writeOk", method = RequestMethod.POST)
	public ModelAndView writeOk(BoardVO vo, HttpServletRequest req, HttpSession ses) {
		ModelAndView mav = new ModelAndView();
		vo.setIp(req.getRemoteAddr());
		vo.setUserid((String) ses.getAttribute("userid"));
		int result = dao.boardInsert(vo);

		mav.setViewName("redirect:list");
		return mav;
	}

	@RequestMapping("/board/view")
	public ModelAndView view(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo", dao.oneRecord(no));
		mav.setViewName("board/view");
		return mav;
	}

	@RequestMapping("/board/edit")
	public ModelAndView edit(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo", dao.oneRecord(no));
		mav.setViewName("board/edit");
		return mav;
	}

	@RequestMapping(value = "/board/editOk", method = RequestMethod.POST)
	public ModelAndView editOk(BoardVO vo) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("no", vo.getNo());

		int result = dao.boardUpdate(vo);
		if (result > 0) { // 수정시 글내용 보기로
			mav.setViewName("redirect:view");
		} else { // 수정실패시 글수정폼으로
			mav.setViewName("redirect:edit");
		}
		return mav;
	}

	@RequestMapping("/board/del")
	public ModelAndView del(int no) {
		ModelAndView mav = new ModelAndView();
		int result = dao.boardDelete(no);
		if (result > 0) { // 삭제시
			mav.setViewName("redirect:list");
		} else {// 삭제못할시
			mav.addObject("no", no);
			mav.setViewName("redirect:view");
		}
		return mav;
	}
}
