package work2;

public class Topic {

	private int topicId;//主题编号
	private String topicTitle;//标题
	private String topicContent;//内容
	private String pubtime;//发布时间
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
		
		return "编号: "+this.topicId+",标题: "+this.topicTitle+",内容: "+this.topicContent+",发布时间:"+this.pubtime;
	}
}
