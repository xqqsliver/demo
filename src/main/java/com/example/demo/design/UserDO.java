package com.example.demo.design;

/**
 * userDao
 * 
 * @author aries
 *
 */
public class UserDO extends AbstractDao {

	public String findUser(int userId) {
		String sql = "select * from t_user where userId = ?";
		Object[] params = new Object[] { userId };
		Object user = super.find(sql);
		System.out.println(user);
		return user.toString();
	}

	@Override
	protected Object rowMapper(String name) {
		name = "come on xuqq" + name;
		return name;
	}
}
