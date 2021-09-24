package com.bitcamp.myapp.board;

import java.util.List;

public interface BoardDAOImpl {
  // 총레코드수
  public void totalRecordCount(PagingVO pVo);

  // 해당페이지 레코드 선택
  public List<BoardVO> boardPageSelect(PagingVO pVo);
  // 글내용보기
//  public List<BoardVO> boardSelect(int no);
//  public List<BoardVO> boardSelect(BoardVO vo);
  public void boardSelect(BoardVO vo);
}
