package edu.study.service;

import edu.study.vo.UserVO;

public interface UserService {

	int insert(UserVO vo);
	UserVO selectLogin(UserVO vo);
	int selectById(String id);
}
