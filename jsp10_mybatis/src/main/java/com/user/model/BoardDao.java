package com.user.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class BoardDao {
	public int insertBoard(BoardDto boardDto) {
		int result = 0;

		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("insertBoard", boardDto);

		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();

		return result;
	}

	public List<BoardDto> getAllBoard() {
		List<BoardDto> boardList = null;

		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		boardList = sqlSession.selectList("getAllBoard");
		sqlSession.close();

		return boardList;
	}

	public BoardDto getSelectOne(int no) {
		BoardDto boardDto = null;

		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		boardDto = sqlSession.selectOne("getSelectOne", no);
		sqlSession.close();

		return boardDto;
	}

	public int updateHit(int no) {
		int result = 0;

		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("updateHit", no);
		sqlSession.commit();
		sqlSession.close();

		return result;
	}

	public int updateBoard(BoardDto boardDto) {
		int result = 0;

		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("updateBoard", boardDto);

		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();

		return result;
	}
}
