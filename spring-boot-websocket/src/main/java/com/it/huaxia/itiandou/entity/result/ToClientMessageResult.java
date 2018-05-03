package com.it.huaxia.itiandou.entity.result;

import com.it.huaxia.itiandou.entity.socketweb.ToClientMessageType;

/**
 * @author fengqigui
 * @description 返回客户端消息的统一接口
 * @date 2018/02/28 14:09
 */
public class ToClientMessageResult {

    public ToClientMessageType getType() {
        return type;
    }

    public void setType(ToClientMessageType type) {
        this.type = type;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    private ToClientMessageType type;
    private Object msg;


}
