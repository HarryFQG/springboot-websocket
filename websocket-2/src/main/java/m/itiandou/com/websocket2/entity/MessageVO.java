package m.itiandou.com.websocket2.entity;

import javax.websocket.Session;
import java.util.List;

/**
 * @author fengqigui
 * @description
 * @date 2018/05/02 15:42
 */
public class MessageVO {

    /**
     * 在线人数
     */
    private Integer userNum;

    /**
     * 状态 ：连接还是断开等
     */
    private Integer type;


    /**
     * 发送的消息
     */
    private String message;

    /**
     * 聊天会话的
     */
    private List<String> sessions;

    /**
     * 当前的聊天会话SessionID
     */
    private String sessionId;

    public MessageVO() {

    }

    public MessageVO(Integer userNum, Integer type, String message, List<String> sessions, String sessionId) {
        this.userNum = userNum;
        this.type = type;
        this.message = message;
        this.sessions = sessions;
        this.sessionId = sessionId;
    }

    public Integer getUserNum() {
        return userNum;
    }

    public void setUserNum(Integer userNum) {
        this.userNum = userNum;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getSessions() {
        return sessions;
    }

    public void setSessions(List<String> sessions) {
        this.sessions = sessions;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String toString() {
        return "MessageVO{" +
                "userNum=" + userNum +
                ", type=" + type +
                ", message='" + message + '\'' +
                ", sessions=" + sessions +
                ", sessionId='" + sessionId + '\'' +
                '}';
    }
}
