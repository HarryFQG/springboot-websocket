package com.it.huaxia.itiandou.entity.group;

import com.it.huaxia.itiandou.entity.User;

import java.util.List;

/**
 * @author fengqigui
 * @description 用户分组
 * @date 2018/02/28 15:44
 */
public class Group {

    /**
     * 分组的ID
     */
    private int groupId;

    /**
     * 分组的名字
     */
    private String groupName;



    public Group() {
    }

    public Group(int groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }



    @Override
    public String toString() {
        return "GroupUser{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
