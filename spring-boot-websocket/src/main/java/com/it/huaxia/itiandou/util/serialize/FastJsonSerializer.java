package com.it.huaxia.itiandou.util.serialize;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * @author fengqigui
 * @description 对象、字符串的相互转化
 * @date 2018/02/28 13:37
 */
public class FastJsonSerializer implements IJsonSerializer{

    @Override
    public <T> String toJSON(T t) {
        ObjectMapper objectMapper = new ObjectMapper();
        if(t==null){
            return null;
        }
        //加上WriteMapNullValue 使得null值也被序列化
        return JSON.toJSONString(t, SerializerFeature.WriteMapNullValue);
    }

    @Override
    public <T> T toObject(String json, Class<T> clazz) {

        T t = null;
        try {
            t = JSON.parseObject(json,clazz);
        }catch (Exception e){
            e.printStackTrace();
        }
        return t;

    }

    @Override
    public <T> List<T> toArray(String json, Class<T> clazz) {
        try {
            List<T> list = JSON.parseArray(json, clazz);
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
