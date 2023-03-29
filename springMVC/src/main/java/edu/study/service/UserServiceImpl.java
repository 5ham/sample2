package edu.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.study.dao.UserDAO;
import edu.study.vo.UserVO;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public int insert(UserVO vo) {
		return userDAO.insert(vo);
	}

	@Override
	public UserVO selectLogin(UserVO vo) {
		return userDAO.selectLogin(vo);
	}

	@Override
	public int selectById(String id) {
		return userDAO.selectById(id);
	}
	
}





