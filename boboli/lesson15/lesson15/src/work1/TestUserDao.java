package work1;

public class TestUserDao {

	public static void main(String[] args) {
		UserDao userDao=new UserDaoImpl();
		User _user=new User("s1","1111",0);
		boolean flag=userDao.addUser(_user);
		if(flag==true)
		{
			System.out.println("�û���ӳɹ�");
		}else{
			System.out.println("�û����ʧ��");
		}
		
		User user2=userDao.findUser("s1");
		if(user2==null){
			System.out.println("�û�������");
		}else{
			user2.getUserInfo();
		}
		
		flag=userDao.updateUser(user2);
		System.out.println(flag==true?"�޸ĳɹ�":"�޸�ʧ��");
	}
}
