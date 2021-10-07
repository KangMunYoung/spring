package com.bitcamp.myhome.transaction;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.myhome.board.BoardDAOImp;
import com.bitcamp.myhome.board.BoardVO;

@Controller
public class TransactionController {
	@Autowired
	SqlSession sqlSession;
	
	//*********************transaction 객체
	@Autowired
	DataSourceTransactionManager transactionManager;
	
	@RequestMapping("/transactionTest")
	@Transactional(rollbackFor= {Exception.class, RuntimeException.class})
	public ModelAndView tran() {
		//**********Transaction 처리를 위한 객체생성 *********************************************
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = transactionManager.getTransaction(def);
		//*******************************************************
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/list");
		BoardDAOImp dao =sqlSession.getMapper(BoardDAOImp.class);
		
		try {
			//첫번쨰 추가할 레코드
			BoardVO vo = new BoardVO();
			vo.setUserid("goguma");
			vo.setSubject("트랜잭션 테스트중");
			vo.setContent("~~~~~~~~~~");
			vo.setIp("123.123.123.123");
			
			BoardVO vo2 = new BoardVO();
			vo2.setUserid("gogumasdf");
			vo2.setSubject("Transaction Test");
			vo2.setContent("*******");
			vo2.setIp("111.222.333.444");
			
			dao.boardWriteOk(vo);//첫번쨰 추가
			dao.boardWriteOk(vo2);//두번쨰 추가
			
			transactionManager.commit(status);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
}
