package cn.gt.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.gt.utils.JDBCUtils;
import cn.gt.vo.User;

public class UserDaoImple implements UserDao {

	public User login(User user) {
        // 创建QueryRunner对象
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        // SQL
		String sql = "select * from user where username = ? and password = ?";
		User existUser;
		try {
            // 执行并返回login方法（in UserServlet）
			existUser = queryRunner.query(sql, new BeanHandler<User>(User.class), user.getUsername(),user.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("用户登录失败!");
		}
		return existUser;
	}

}
