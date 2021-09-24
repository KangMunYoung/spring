package com.bitcamp.myapp.board;

import java.util.List;

public interface BoardDAOImpl {
  // 총레코드수
  public void totalRecordCount(PagingVO pVo);

  // 해당페이지 레코드 선택
  public List<BoardVO> boardPageSelect(PagingVO pVo);
}
