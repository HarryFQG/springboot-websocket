package com.it.huaxia.itiandou.entity.group;

import com.it.huaxia.itiandou.entity.User;

import java.util.List;

/**
 * @author fengqigui
 * @description
 * @date 2018/02/28 15:51
 */
public class BigGroup extends Group {

    /**
     * 图像
     */
    private String avatar;
    /**
     * 群组的成员
     */
    private List<User> listUser;

    public BigGroup() {
    }

    public BigGroup(String avatar, List<User> listUser, int groupId, String groupName) {
        super(groupId, groupName);
        this.avatar = avatar;
        this.listUser = listUser;
    }

    public BigGroup(int groupId, String groupName, String avatar, List<User> listUser) {
        super(groupId, groupName);
        this.avatar = avatar;
        this.listUser = listUser;
    }

    public  void setAvatar(String avatar){
        this.avatar = avatar;
    }

    public String getAvatar(){
        return this.avatar;
    }
}
