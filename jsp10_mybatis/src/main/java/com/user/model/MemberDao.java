package com.user.model;

import org.apache.ibatis.session.SqlSession;

public class MemberDao {
	public int insertMember(MemberDto memberDto) {
		int result = 0;
		
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("insertMember", memberDto);
		
		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return result;
	}
	
	public MemberDto getLoggedMember(MemberDto memberDto) {
		MemberDto loggedMember = new MemberDto();
		
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		loggedMember = sqlSession.selectOne("getLoggedMember", memberDto);
		sqlSession.close();
		
		return loggedMember;
	}
}
