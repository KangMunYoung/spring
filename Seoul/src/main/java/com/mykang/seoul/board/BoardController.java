package com.mykang.seoul.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
  BoardDAO dao = new BoardDAO();

  @RequestMapping("/boardList")
  public ModelAndView boardList(PagingVO pVo) {
    ModelAndView mav = new ModelAndView();

    // 총레코드수
    dao.totalRecordCount(pVo);
    mav.addObject("pVo", pVo);
    mav.addObject("list", dao.boardPageSelect(pVo));
    mav.setViewName("board/boardList");
    return mav;
  }

  // 글내용보기
  @RequestMapping("/boardView")
  public ModelAndView boardView(BoardVO vo, PagingVO pVo) {
    ModelAndView mav = new ModelAndView();
    dao.boardSelect(vo);// 레코드선택
    mav.addObject("vo", vo);
    mav.addObject("pVo", pVo);
    mav.setViewName("board/boardView");
    
    return mav;
  }
}
