package work2;

public interface TopicDao {

	//添加主题
	public boolean addTopic(Topic topic);
	/**
	 * 根据主题编号查找主题,返回Topic对象
	 * @param topicId 主题编号
	 * @return 对象
	 */
	public Topic findTopic(int topicId);
	//根据主题编号删除主题
	public boolean deleteTopic(int topicId);
	
	
	
	
}
