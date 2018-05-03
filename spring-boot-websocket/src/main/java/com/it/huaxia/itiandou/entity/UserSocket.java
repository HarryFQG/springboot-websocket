package com.it.huaxia.itiandou.entity;

import javax.websocket.Session;

/**
 * @author fengqigui
 * @description 用于用户连接
 * @date 2018/02/28 11:30
 */
public class UserSocket {

    /**
     * 会话
     */
    private Session session;

    /**
     * 用户的ID
     */
    private int userId;

    public UserSocket() {
    }

    public UserSocket(Session session, int userId) {
        this.session = session;
        this.userId = userId;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public boolean isExist(){
        return this.userId > 0;
    }
    @Override
    public String toString() {
        return "UserSocket{" +
                "session=" + session +
                ", userId=" + userId +
                '}';
    }
}
