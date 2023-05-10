package work2;

public class TopicDaoImpl implements TopicDao {

	Topic[] topics = new Topic[3];

	@Override
	public boolean addTopic(Topic topic) {
		for(int i=0;i<3;i++)
		{
			if(topics[i]==null)
			{
				topics[i]=topic;
				return true;
			}
		}
		return false;
	}

	@Override
	public Topic findTopic(int topicId) {
		for(Topic topic:topics)
		{
			if(topic.getTopicId()==topicId)
			{
				return topic;
			}
		}
		return null;
	}

	@Override
	public boolean deleteTopic(int topicId) {
		for(int i=0;i<3;i++)
		{
			if(topics[i].getTopicId()==topicId)
			{
				topics[i]=null;
				return true;
			}
		}
		return false;
	}

}
