package pojo.message;

/**
 * 消息的发送
 */
public class ToServerTextMessage {

    /**
     * 发送者
     */
    private ToServerMessageMine mine;

    /**
     * 接受者
     */
    private ToServerMessageTo to;

    public ToServerMessageMine getMine() {
        return mine;
    }

    public void setMine(ToServerMessageMine mine) {
        this.mine = mine;
    }

    public ToServerMessageTo getTo() {
        return to;
    }

    public void setTo(ToServerMessageTo to) {
        this.to = to;
    }

}
