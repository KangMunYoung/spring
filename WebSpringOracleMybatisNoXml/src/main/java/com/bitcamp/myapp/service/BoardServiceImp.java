package com.bitcamp.myapp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bitcamp.myapp.dao.BoardDAO;
import com.bitcamp.myapp.vo.BoardVO;

@Service
public class BoardServiceImp implements BoardService {
	@Inject
	BoardDAO boardDAO;

	@Override
	public List<BoardVO> boardList() {
		// TODO Auto-generated method stub
		return boardDAO.boardList();
	}

	@Override
	public BoardVO boardView(int no) {
		return boardDAO.boardView(no);
	}

	@Override
	public int boardInsert(BoardVO vo) {
		return boardDAO.boardInsert(vo);
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		return boardDAO.boardUpdate(vo);
	}

	@Override
	public int boardDelete(int no, String userid) {
		// TODO Auto-generated method stub
		return boardDAO.boardDelete(no, userid);
	}

	@Override
	public int boardDelArray(int[] noDelArray) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * @Override public int boardDelArray(int[] noDelArray) { // TODO Auto-generated
	 * method stub return boardDAO.boardDelArray(noDelArray); }
	 */
	
	
	
}
