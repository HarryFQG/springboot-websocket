package com.it.huaxia.itiandou.entity.socketweb;

/**
 * @author fengqigui
 * @description 消息发送者与接受者
 * @date 2018/02/28 11:49
 */
public class ToServerTextMessage {

    /**
     * 发送者
     */
    private SenderMessage senderMessage;

    /**
     * 接受者
     */
    private ReceiverMessage receiverMessage;

    public ToServerTextMessage() {
    }


    public ToServerTextMessage(SenderMessage senderMessage, ReceiverMessage receiverMessage) {
        this.senderMessage = senderMessage;
        this.receiverMessage = receiverMessage;
    }

    public SenderMessage getSenderMessage() {
        return senderMessage;
    }

    public void setSenderMessage(SenderMessage senderMessage) {
        this.senderMessage = senderMessage;
    }

    public ReceiverMessage getReceiverMessage() {
        return receiverMessage;
    }

    public void setReceiverMessage(ReceiverMessage receiverMessage) {
        this.receiverMessage = receiverMessage;
    }
    @Override
    public String toString() {
        return "ToServerTextMessage{" +
                "senderMessage=" + senderMessage +
                ", receiverMessage=" + receiverMessage +
                '}';
    }

}
