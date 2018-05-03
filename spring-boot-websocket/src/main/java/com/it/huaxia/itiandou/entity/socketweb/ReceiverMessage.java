package com.it.huaxia.itiandou.entity.socketweb;

/**
 * @author fengqigui
 * @description 接受者
 * @date 2018/02/28 11:52
 */
public class ReceiverMessage {

    /**
     * 用户的ID
     */
    private int id;

    /**
     * 用户的图像
     */
    private String avatar;

    /**
     * 签名
     */
    private String sign;

    /**
     * 消息类型 (friend/group)
     */
    private String type;

    /**
     * 用户的名字
     */
    private String name;

    public ReceiverMessage() {
    }

    public ReceiverMessage(int id, String avatar, String sign, String type, String name) {
        this.id = id;
        this.avatar = avatar;
        this.sign = sign;
        this.type = type;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ReceiverMessage{" +
                "id=" + id +
                ", avatar='" + avatar + '\'' +
                ", sign='" + sign + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
