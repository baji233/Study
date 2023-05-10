package work1;

public interface UserDao {

	// 根据用户名查找用户

	public User findUser(String name);

	// 添加用户
	public boolean addUser(User user);

	// 修改用户
	public boolean updateUser(User user);
}
