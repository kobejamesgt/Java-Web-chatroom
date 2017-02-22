package cn.gt.service;

import cn.gt.dao.UserDao;
import cn.gt.dao.UserDaoImple;
import cn.gt.vo.User;

public class UserService {

	public User login(User user) {
		UserDao dao = new UserDaoImple();
		return dao.login(user);
	}
		
}
