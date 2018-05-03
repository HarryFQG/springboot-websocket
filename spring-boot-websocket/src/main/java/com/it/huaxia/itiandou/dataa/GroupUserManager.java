package com.it.huaxia.itiandou.dataa;

import com.it.huaxia.itiandou.entity.User;
import com.it.huaxia.itiandou.entity.group.BigGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author fengqigui
 * @description 伪造的数据
 * @date 2018/02/28 14:22
 */
public class GroupUserManager {

    private static List<User> listUser = new ArrayList<>();
    private static List<BigGroup> listBigGroup = new ArrayList<>();

    static{

        listUser.add(new User(1001, 12,"王小贱", "个性签名1", "图像1"));
        listUser.add(new User(1002, 11, "李大同", "个性签名2", "图像2"));
        listUser.add(new User(1562, 11,  "孙建新", "个性签名3","图像3"));
        listUser.add(new User(1898, 15, "陈寻", "个性签名4","图像4"));
        listUser.add(new User(4561, 11, "方茴", "个性签名5","图像5"));
        listUser.add(new User(3622, 12, "静秋", "个性签名6","图像6"));

        listBigGroup.add(new BigGroup(11, "那些年", "分组图像1", null));
        listBigGroup.add(new BigGroup(12, "致青春", "分组图像2", null));
        listBigGroup.add(new BigGroup(15, "匆匆那年", "分组图像3", null));

    }

    /**
     * 根据分组的Id查找组员的信息
     * @param groupId
     * @return
     */
    public List<Integer> getGroupMembers(int groupId){

        List<Integer> collect = listUser.stream().filter(p -> p.getFgid() == groupId).map(User::getId).collect(Collectors.toList());
        return collect;

    }

}
