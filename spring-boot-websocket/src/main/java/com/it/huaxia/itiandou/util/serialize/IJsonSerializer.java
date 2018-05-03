package com.it.huaxia.itiandou.util.serialize;

import java.util.List;

/**
 * @author fengqigui
 * @description 字符串与对象的序列化
 * @date 2018/02/28 13:34
 */
public interface IJsonSerializer {

    /**
     * 序列化某个对象
     */
    <T> String toJSON(T t);

    /**
     * 反序列化
     */
    <T> T toObject(String json,Class<T> clazz);

    /**
     * 序列化成数组
     */
    <T> List<T> toArray(String json, Class<T> clazz);

}
