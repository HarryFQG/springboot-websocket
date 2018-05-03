package pojo.message;


/**
 *  username: "范月盘"
 * ,avatar: ""
 * ,id: 4803920
 * ,type:"friend"
 * ,content: "我在测试发消息"
 * ,timestamp: new Date().getTime()
 * 客户端的消息
 */
public class ToClientTextMessage {

    /**
     * 用户的名字
     */
    private String username;

    /**
     * 用户的 ID
     */
    private int id;

    /**
     * 类型：friend 或者 group
     */
    private String type;

    /**
     * 消息的内容
     */
    private String content;

    /**
     * 发送的时间戳
     */
    private long timestamp;

    /**
     * 图像
     */
    private String avatar;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }


    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "ToClientTextMessage{" +
                "username='" + username + '\'' +
                ", id=" + id +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
