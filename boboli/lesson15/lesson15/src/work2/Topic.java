package work2;

public class Topic {

	private int topicId;//������
	private String topicTitle;//����
	private String topicContent;//����
	private String pubtime;//����ʱ��
	public Topic(int topicId, String topicTitle, String topicContent,
			String pubtime) {
		super();
		this.topicId = topicId;
		this.topicTitle = topicTitle;
		this.topicContent = topicContent;
		this.pubtime = pubtime;
	}
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public String getTopicTitle() {
		return topicTitle;
	}
	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}
	public String getTopicContent() {
		return topicContent;
	}
	public void setTopicContent(String topicContent) {
		this.topicContent = topicContent;
	}
	public String getPubtime() {
		return pubtime;
	}
	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}
	
	
	@Override
	public String toString() {
		
		return "���: "+this.topicId+",����: "+this.topicTitle+",����: "+this.topicContent+",����ʱ��:"+this.pubtime;
	}
}
