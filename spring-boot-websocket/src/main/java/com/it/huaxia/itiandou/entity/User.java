package com.it.huaxia.itiandou.entity;

/**
 * @author fengqigui
 * @description 用户
 * @date 2018/02/27 17:11
 * Created by pz on 16/11/23.
 * "username": "纸飞机"
 *,"id": "100000"
 *,"status": "online"
 *,"sign": "在深邃的编码世界，做一枚轻盈的纸飞机"
 *,"avatar": "http://cdn.firstlinkapp.com/upload/2016_6/1465575923433_33812.jpg"
 */
public class User {

    /**
     * 用户ID
     */
    private int id;

    /**
     * 分组/朋友id,应该使用list，因为一个人可以再多个群聊中
     */
    private int fgid;

    /**
     * 个性签名
     */
    private String sign;

    /**
     * 个性签名
     */
    private String avatar;

    /**
     * 姓名
     */
    private String username;


    public User(){

    }

    public User(int id,int fgid, String username,String sign,String avatar){
        this.id = id;
        this.fgid = fgid;
        this.username = username;
        this.sign = sign;
        this.avatar = avatar;
    }

    public int getFgid() {
        return fgid;
    }

    public void setFgid(int fgid) {
        this.fgid = fgid;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
