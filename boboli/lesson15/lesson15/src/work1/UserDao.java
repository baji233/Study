package work1;

public interface UserDao {

	// �����û��������û�

	public User findUser(String name);

	// ����û�
	public boolean addUser(User user);

	// �޸��û�
	public boolean updateUser(User user);
}
