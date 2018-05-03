package com.it.huaxia.itiandou.service.websocket.manager;

import com.it.huaxia.itiandou.entity.UserSocket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author fengqigui
 * @description
 * @date 2018/02/28 16:20
 */
public class UserManager implements IUserManager{

    private static Map<String,UserSocket> socketUserMap;



    private UserManager(){
        socketUserMap = new ConcurrentHashMap<>();
    }

    private static UserManager manager = new UserManager();

    public static IUserManager getInstance(){
        return manager;
    }


    @Override
    public boolean addUser(UserSocket user) {

        String sessionUserId = Integer.toString(user.getUserId());
        removeUser(sessionUserId);
        socketUserMap.put(sessionUserId, user);
        return true;
    }


    @Override
    public boolean removeUser(UserSocket user) {
        String sessionUserId =  Integer.toString(user.getUserId());
        return removeUser(sessionUserId);
    }


    @Override
    public int getOnlineCount() {
        return socketUserMap.size();
    }

    @Override
    public UserSocket getUser(int userId){
        String key = Integer.toString(userId);
        if(socketUserMap.containsKey(key)){
            return socketUserMap.get(key);
        }
        return new UserSocket();
    }

    private boolean removeUser(String sessionUserId) {
        socketUserMap.remove(sessionUserId);
        return true;
    }

}
