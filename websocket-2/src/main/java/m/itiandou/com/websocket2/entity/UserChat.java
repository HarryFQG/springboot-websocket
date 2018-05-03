package m.itiandou.com.websocket2.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author fengqigui
 * @description 用户聊天记录
 * @date 2018/05/02 16:50
 */
@Document(collection = "userChat")
public class UserChat {

    private String Id;

    private Integer user1Id;

    private Integer user2Id;

    private String user1Content;

    private String user2Content;

    private Date date;

    public UserChat() {
    }

    public UserChat(String id, Integer user1Id, Integer user2Id, String user1Content, String user2Content, Date date) {
        Id = id;
        this.user1Id = user1Id;
        this.user2Id = user2Id;
        this.user1Content = user1Content;
        this.user2Content = user2Content;
        this.date = date;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Integer getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(Integer user1Id) {
        this.user1Id = user1Id;
    }

    public Integer getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(Integer user2Id) {
        this.user2Id = user2Id;
    }

    public String getUser1Content() {
        return user1Content;
    }

    public void setUser1Content(String user1Content) {
        this.user1Content = user1Content;
    }

    public String getUser2Content() {
        return user2Content;
    }

    public void setUser2Content(String user2Content) {
        this.user2Content = user2Content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "UserChat{" +
                "Id='" + Id + '\'' +
                ", user1Id=" + user1Id +
                ", user2Id=" + user2Id +
                ", user1Content='" + user1Content + '\'' +
                ", user2Content='" + user2Content + '\'' +
                ", date=" + date +
                '}';
    }
}
