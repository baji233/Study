package work1;

import java.util.Scanner;

public class UserDaoImpl implements UserDao {

	User[] users = new User[3];// �û�����

	@Override
	public User findUser(String name) {
		for (User user : users) {
			if (user.getName().equals(name)) {
				return user;
			}
		}

		return null;
	}

	@Override
	public boolean addUser(User user) {
		boolean flag = false;// Ĭ�����ʧ��
		for (int i = 0; i < 3; i++) {
			if (users[i] == null) {
				users[i] = user;
				flag = true;
				break;
			}
		}
		return flag;
	}

	@Override
	public boolean updateUser(User user) {
		Scanner input = new Scanner(System.in);
		System.out.println("�������µ��û���");
		String _name = input.next();
		user.setName(_name);

		System.out.println("�������µ�����");
		String _pass = input.next();
		user.setPass(_pass);
		return true;
	}

}
