package com.it.huaxia.itiandou.entity.group;

import com.it.huaxia.itiandou.entity.User;

import java.util.List;

/**
 * @author fengqigui
 * @description 好友列表
 * @date 2018/02/28 15:51
 */
public class FriendGroup extends Group {

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    private int online;
    private List<User> list;

}
