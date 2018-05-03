package pojo.message;



/**
 * 存储到数据库的po
 */
public class ToDBMessage {

    /**
     * 发送消息的用户的id
     */
    private int sendUserId;

    /**
     * 群组id
     */
    private long groupId;

    /**
     * 消息
     */
    private String msg;

    /**
     * 聊天类型：friend 和 group
     */
    private int chatType;
    /**
     * 发送的时间，毫秒数
     */
    private long addTime;

    /**
     * 消息的类型
     */
    private int msgType;

    public int getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(int sendUserId) {
        this.sendUserId = sendUserId;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getChatType() {
        return chatType;
    }

    public void setChatType(int chatType) {
        this.chatType = chatType;
    }

    public long getAddtime() {
        return addTime;
    }

    public void setAddtime(long addtime) {
        this.addTime = addtime;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

}

