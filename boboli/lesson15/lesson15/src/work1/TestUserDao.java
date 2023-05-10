package work1;

public class TestUserDao {

	public static void main(String[] args) {
		UserDao userDao=new UserDaoImpl();
		User _user=new User("s1","1111",0);
		boolean flag=userDao.addUser(_user);
		if(flag==true)
		{
			System.out.println("用户添加成功");
		}else{
			System.out.println("用户添加失败");
		}
		
		User user2=userDao.findUser("s1");
		if(user2==null){
			System.out.println("用户不存在");
		}else{
			user2.getUserInfo();
		}
		
		flag=userDao.updateUser(user2);
		System.out.println(flag==true?"修改成功":"修改失败");
	}
}
