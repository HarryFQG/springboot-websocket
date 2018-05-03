package com.it.huaxia.itiandou.service.websocket.manager;

import com.it.huaxia.itiandou.entity.UserSocket;

/**
 * @author fengqigui
 * @description 用户管理
 * @date 2018/02/28 16:20
 */
public interface IUserManager {
    boolean addUser(UserSocket user);

    boolean removeUser(UserSocket user);

    int getOnlineCount();

    UserSocket getUser(int userId);
}
