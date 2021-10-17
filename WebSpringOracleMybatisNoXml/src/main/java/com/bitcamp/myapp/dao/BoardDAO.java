package com.bitcamp.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bitcamp.myapp.vo.BoardVO;

public interface BoardDAO {
	//게시판목록
	@Select("select no, subject, userid, hit, to_char(writedate, 'MM-DD HH:MI') writedate from board order by no desc")
	public List<BoardVO> boardList();
	
	@Select("select no, subject, userid, hit,content, writedate from board where no=#{no}")
	public BoardVO boardView(int no);
	
	@Insert("insert into board(no, subject, content, userid, writedate, hit, ip) values(boardsq.nextval, #{subject}, #{content}, #{userid}, sysdate, 0, #{ip}")
	public int boardInsert(BoardVO vo);
	
	@Update("update board set subject=#{subject}, content=#{content} where no=#{no} and userid=#{userid}")
	public int boardUpdate(BoardVO vo);
	
	@Delete("delete from board where no=#{param1} and userid=#{param2}")
	public int boardDelete(int no, String userid);
	
//	//배열을 이용한 여러개이 레코드 한번에 삭제
//	@Delete({
//		"<script>",
//		" delete from board where no in",
//		" <foreach item=\"item\"collection=\"array\" open=\"(\" separator=\",\" close=\")\">",
//		" #{item} ",
//		" </foreach>",
//		" </script>"
//		})
//	public int boardDelArray(int[] noDelArray);
}
