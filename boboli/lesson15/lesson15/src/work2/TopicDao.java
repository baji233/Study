package work2;

public interface TopicDao {

	//�������
	public boolean addTopic(Topic topic);
	/**
	 * ���������Ų�������,����Topic����
	 * @param topicId ������
	 * @return ����
	 */
	public Topic findTopic(int topicId);
	//����������ɾ������
	public boolean deleteTopic(int topicId);
	
	
	
	
}
