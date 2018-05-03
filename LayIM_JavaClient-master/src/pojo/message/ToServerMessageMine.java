package pojo.message;

/**
 * 服务器的消息到用户
 */
public class ToServerMessageMine {


    /**
     * 用户的图像
     */
    private String avatar;

    /**
     * 发送用户的id
     */
    private int id;

    /**
     * 消息内容
     */
    private String content;
    /**
     * 用户的名字
     */
    private String username;


    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
