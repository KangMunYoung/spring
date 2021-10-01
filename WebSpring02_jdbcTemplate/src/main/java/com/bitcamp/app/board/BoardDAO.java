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
		String sql = "select no, userid, subject, content, hit, writedate from board where no=?";
		return template.queryForObject(sql, new BeanPropertyRowMapper<BoardVO>(BoardVO.class), no);
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		String sql = "update board set subject=?, content=? where no=?";
		return template.update(sql, vo.getSubject(), vo.getContent(), vo.getNo());
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
		String sql = "delete from board where no=?";
		return template.update(sql, no);
	}
}
