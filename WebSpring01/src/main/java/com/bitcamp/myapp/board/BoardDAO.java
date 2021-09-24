package com.bitcamp.myapp.board;

import java.util.ArrayList;
import java.util.List;

import com.bitcamp.myapp.DBConnection;

public class BoardDAO extends DBConnection implements BoardDAOImpl {

	@Override
	public void totalRecordCount(PagingVO pVo) {
		try {
			dbConn();
			sql = "select count(no) from board ";
			//검색어가 있을때
			if(pVo.getSearchWord() != null && !pVo.getSearchWord().equals("")) {
				sql += " where "+ pVo.getSearchKey() +" like'%"+pVo.getSearchWord()+"%'";
			}
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				pVo.setTotalRecord(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}

	@Override
	public List<BoardVO> boardPageSelect(PagingVO pVo) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			dbConn();
			sql = "select * from "
					+ "(select * from "
					+ "(select no, subject, userid, hit, to_char(writedate, 'MM-DD HH:MI') writedate from board";
					
					//검색어가 있으면
					if(pVo.getSearchWord() != null && !pVo.getSearchWord().equals("")) {
						sql += " where " + pVo.getSearchKey() + " like '%" + pVo.getSearchWord() + "%'";
					}
					
					sql += " order by no desc)"
					+ " where rownum<=? order by no asc)"
					+ " where rownum<=? order by no desc";
			pstmt = con.prepareStatement(sql);
			// 한페이지당 레코드수*현재페이지
			pstmt.setInt(1, pVo.getOnePageRecord() * pVo.getNowPage());
			// 한페이지당 레코드수
			//남은 레코드 수
			int lastPageRecord = pVo.getTotalRecord() % pVo.getOnePageRecord();	// 1
			if(pVo.getTotalPage()== pVo.getNowPage() && lastPageRecord != 0) {//마지막페이지일때
				pstmt.setInt(2, lastPageRecord);
			}else {
				pstmt.setInt(2, pVo.getOnePageRecord());// 1,2,3,4,5
			}
//			pstmt.setInt(2, pVo.getOnePageRecord());

			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setUserid(rs.getString(3));
				vo.setHit(rs.getInt(4));
				vo.setWritedate(rs.getString(5));
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}

	@Override
	public void boardSelect(BoardVO vo) {
		try {
			dbConn();
			sql = "select no,userid, subject, content, hit, writedate from board where no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getNo());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setNo(rs.getInt(1));
				vo.setUserid(rs.getString(2));
				vo.setSubject(rs.getNString(3));
				vo.setContent(rs.getString(4));
				vo.setHit(rs.getInt(5));
				vo.setWritedate(rs.getString(6));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}

}
