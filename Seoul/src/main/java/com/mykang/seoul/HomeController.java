package com.mykang.seoul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mykang.seoul.board.BoardDAO;
import com.mykang.seoul.board.PagingVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
		BoardDAO dao = new BoardDAO();
		@RequestMapping(value = "/", method = RequestMethod.GET)
		public ModelAndView boardList(PagingVO pVo) {
			ModelAndView mav = new ModelAndView();
			dao.totalRecordCount(pVo);
			mav.addObject("pVo", pVo);
			mav.addObject("list", dao.boardPageSelect(pVo));
			mav.setViewName("index");
		return mav;
	}
	
}
