package com.it.huaxia.itiandou.entity;

import java.util.Date;

/**
 * @author fengqigui
 * @description 消息实体
 * @date 2018/02/27 17:06
 */
public class MessageContent {

    /**
     * 消息
     */
    private String message;

    /**
     * 发送时间
     */
    private Date sendDate;

    public MessageContent() {
    }

    public MessageContent(String message, Date sendDate) {
        this.message = message;
        this.sendDate = sendDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }
}
