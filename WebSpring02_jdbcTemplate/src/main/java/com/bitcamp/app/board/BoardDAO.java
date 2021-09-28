package com.bitcamp.app.board;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.bitcamp.app.Constants;

public class BoardDAO implements BoardDAOimp {
	public JdbcTemplate template;

	public BoardDAO() {
		template = Constants.template;
	}

	@Override
	public List<BoardVO> allRecord() {
		String sql = "select no, subject, userid, hit, to_char(writedate,'MM-DD HH:MI') writedate from board order by no desc";
		return template.query(sql, new BeanPropertyRowMapper<BoardVO>(BoardVO.class));
	}
	

	@Override
	public BoardVO oneRecord(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardInsert(final BoardVO vo) {
		String sql = "insert into board(no, userid, subject, content, ip) values(boardSq.nextval, ?,?,?,?)";
		return template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, vo.getUserid());
				ps.setString(2, vo.getSubject());
				ps.setString(3, vo.getContent());
				ps.setString(4, vo.getIp());
			}
		});
	}

	@Override
	public int boardDelete(int no) {
		// TODO Auto-generated method stub
		return 0;
	}
}
