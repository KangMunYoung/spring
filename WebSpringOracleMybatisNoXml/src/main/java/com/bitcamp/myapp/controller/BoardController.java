package com.bitcamp.myapp.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.myapp.service.BoardService;
import com.bitcamp.myapp.vo.BoardVO;

@Controller
public class BoardController {
	@Inject
	BoardService boardService;
	//게시판 목록
	@RequestMapping("/boardList")
	public String boardList(Model model) {
		model.addAttribute("list", boardService.boardList());
		return "board/list";
	}
	
	@RequestMapping("/boardView")
	public String boardView(Model model, int no) {
		model.addAttribute("vo",boardService.boardView(no));
		return "board/boardView";
	}
	//글쓰기
	@RequestMapping(value="/boardWrite")
	public String boardWrite() {
		return "board/boardWrite";
	}
	@RequestMapping(value="/boardWriteOk", method=RequestMethod.POST)
	public ModelAndView boardWriteOk(BoardVO vo, HttpSession session, HttpServletRequest req) {
		vo.setUserid((String)session.getAttribute("logid"));
		vo.setIp(req.getRemoteAddr());
		
		int cnt = boardService.boardInsert(vo);
		
		ModelAndView mav = new ModelAndView();
		
		if(cnt>0) {
			mav.setViewName("redirect:boardList");
		}else {
			mav.setViewName("redirect:boardWrite");
		}
		return mav;
	}
	@RequestMapping("/boardEdit")
	public ModelAndView boardEdit(int no) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("vo", boardService.boardView(no));
		mav.setViewName("board/boardEdit");
		return mav;
	}
	
	//글수정
	@RequestMapping(value="/boardEditOk", method=RequestMethod.POST)
	public ModelAndView boardEditOk(BoardVO vo, HttpSession session) {
		vo.setUserid((String)session.getAttribute("logid"));
		
		int result = boardService.boardUpdate(vo);
		
		ModelAndView mav = new ModelAndView();
		if(result>0) {//수정
			mav.addObject("no",vo.getNo());
			mav.setViewName("redirect:boardView");
		}else {//실패
			mav.setViewName("/board/result");
			
		}
		return mav;
	}
	
	//삭제
	@RequestMapping("/boardDel")
	public ModelAndView boardDel(int no, HttpSession session) {
		
		String userid = (String)session.getAttribute("logid");
		int cnt = boardService.boardDelete(no, userid);
		
		ModelAndView mav = new ModelAndView();
		if(cnt>0) {
			mav.setViewName("redirect:boardList");
		}else {
			mav.addObject("no", no);
			mav.setViewName("redirect:boardView");
		}
		return mav;
	}
	
//	//여러레코드를 배열로 삭제하기
//	@RequestMapping(value="/arrayBoardDel" , method=RequestMethod.POST)
//	public ModelAndView arrayBoardDel(BoardVO vo) {
//		ModelAndView mav = new ModelAndView();
//		int result = boardService.boardDelArray(vo.getNoDelArray());
//		System.out.println("삭제된 레코드 수 :"+result);
//		mav.setViewName("redirect:list");
//	}
//	
//	
	
	
	
	
	
}
