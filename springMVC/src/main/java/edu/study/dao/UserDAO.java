package edu.study.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.study.vo.UserVO;

@Repository
public class UserDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public int insert(UserVO vo) {
		return sqlSession.insert("edu.study.mapper.userMapper.insert", vo);
	}
	
	public UserVO selectLogin(UserVO vo) {
		return sqlSession.selectOne("edu.study.mapper.userMapper.selectLogin", vo);
	}
	
	public int selectById(String id) {
		return sqlSession.selectOne("edu.study.mapper.userMapper.selectById", id);
	}
	
}




