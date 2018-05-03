package com.it.huaxia.itiandou.entity.socketweb;

/**
 * @author fengqigui
 * @description 发送者名字
 * @date 2018/02/28 11:51
 */
public class SenderMessage {

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

    public SenderMessage() {
    }

    public SenderMessage(String avatar, int id, String content, String username) {
        this.avatar = avatar;
        this.id = id;
        this.content = content;
        this.username = username;
    }

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
