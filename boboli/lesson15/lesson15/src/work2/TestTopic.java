package work2;

public class TestTopic {

	public static void main(String[] args) {
		TopicDao topicDao = new TopicDaoImpl();
		Topic topic = new Topic(11, "�ӿ�ѧϰ", "�����", "2010-10-10");
		topicDao.addTopic(topic);

		Topic t1 = topicDao.findTopic(11);
		if (t1 == null) {
			System.out.println("û�и�����");
		} else {
			System.out.println(t1);
		}
		
		boolean flag = topicDao.deleteTopic(11);
		System.out.println(flag == true ? "ɾ���ɹ�" : "ɾ��ʧ��");
	}
}
