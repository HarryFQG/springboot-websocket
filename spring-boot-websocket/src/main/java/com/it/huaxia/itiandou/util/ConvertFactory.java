package com.it.huaxia.itiandou.util;

import com.it.huaxia.itiandou.service.websocket.manager.IUserManager;
import com.it.huaxia.itiandou.service.websocket.manager.UserManager;
import com.it.huaxia.itiandou.util.serialize.FastJsonSerializer;
import com.it.huaxia.itiandou.util.serialize.IJsonSerializer;

/**
 * @author fengqigui
 * @description 转换工厂
 * @date 2018/02/28 13:31
 */
public class ConvertFactory {

    /**
     * 创建序列化器
     * @return
     */
    public static IJsonSerializer createSerializer(){
        return new FastJsonSerializer();
    }

    /**
     * 创建在线人员管理工具
     * @return
     */
    public static IUserManager createManager(){
        return UserManager.getInstance();
    }
}
