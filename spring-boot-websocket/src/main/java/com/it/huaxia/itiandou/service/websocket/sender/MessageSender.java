package com.it.huaxia.itiandou.service.websocket.sender;

import com.it.huaxia.itiandou.dataa.GroupUserManager;
import com.it.huaxia.itiandou.entity.UserSocket;
import com.it.huaxia.itiandou.entity.result.ToClientMessageResult;
import com.it.huaxia.itiandou.entity.socketweb.SenderMessage;
import com.it.huaxia.itiandou.entity.socketweb.ToClientMessageType;
import com.it.huaxia.itiandou.entity.socketweb.ToClientTextMessage;
import com.it.huaxia.itiandou.entity.socketweb.ToServerTextMessage;
import com.it.huaxia.itiandou.util.ConvertFactory;

import javax.websocket.Session;
import java.util.List;

/**
 * @author fengqigui
 * @description 发送信息类
 *      所有从客户端到服务端的消息转发到此类进行消息处理
 *      ToServerTextMessage转换为ToClientTextMessage
 *      如果是单聊，直接从缓存取出对象的session进行消息发送，群聊则需要从缓存中取出该群里所有人的id进行遍历发送消息，
 *      遍历过后需要优化在线与否，假如100人中只有一个人在线，则会浪费99次（未做优化）
 * @date 2018/02/28 11:44
 * // TODO 待测试发消息
 */
public class MessageSender {

    /**
     * 发送消息的业务逻辑
     */
    public void sendMessage(ToServerTextMessage message){

        // 接收人的ID
        int toUserId = message.getReceiverMessage().getId();
        // 获取发送人的ID
        String sendUserId = Integer.toString(message.getSenderMessage().getId());
        // 获得接收消息的类型(friend/group)
        String type =  message.getReceiverMessage().getType();
        //消息提前生成，否则进行循环内生成会浪费资源
        String toClientMessage = getToClientMessage(message);

        System.out.println("当前消息类型是"+type);
        //不能用==做比较，因为一个是static final 值，另外一个是在对象中 == 为false
        if("group".equals(type)){
            //群聊，需要遍历该群组里的所有人
            //第一次从缓存中取userId，否则，从数据库中取在存到缓存中
            List<Integer> users =  new GroupUserManager().getGroupMembers(message.getReceiverMessage().getId());
            for (Integer userid : users) {
                //遍历发送消息 自己过滤，不给自己发送(发送人id和群成员内的某个id相同)
                if (!sendUserId.equals(userid)) {
                    sendMessage(userid, toClientMessage);
                }
            }
        }else {
            sendMessage(toUserId, toClientMessage);
        }

        //最后保存到数据库
        //saveMessage(message);


    }
    //给单个用户发
    private  void sendMessage(Integer userId,String message){
        UserSocket user = ConvertFactory.createManager().getUser(userId);
        if (user.isExist()) {
            if (user.getSession() == null) {
                throw new IllegalArgumentException("用户不存在");
            } else {
                Session session = user.getSession();
                if (session.isOpen()) {
                    //构造用户需要接收到的消息
                    session.getAsyncRemote().sendText(message);
                }
            }
        }else{
            throw new IllegalArgumentException("该用户不在线");
        }
    }
     /**根据客户端发送来的消息，构造发送出去的消息
      *  username: data.mine.username
      *      , avatar: data.mine.avatar
      *      , id: data.mine.id
      *      , type: data.to.type
      *      , content:data.mine.content
      *      , timestamp: new Date().getTime()
      */
    private String getToClientMessage(ToServerTextMessage message) {

        ToClientTextMessage toClientTextMessage = new ToClientTextMessage();

        SenderMessage mine = message.getSenderMessage();

        toClientTextMessage.setUsername(mine.getUsername());
        toClientTextMessage.setAvatar(mine.getAvatar());
        toClientTextMessage.setContent(mine.getContent());
        toClientTextMessage.setType(message.getReceiverMessage().getType());

        //群组和好友直接聊天不同，群组的id 是 组id，否则是发送人的id
        if ("group".equals(toClientTextMessage.getType())) {
            toClientTextMessage.setId(message.getReceiverMessage().getId());
        } else {
            toClientTextMessage.setId(mine.getId());
        }
        toClientTextMessage.setTimestamp(System.currentTimeMillis());

        // 返回统一消息接口
        ToClientMessageResult result = new ToClientMessageResult();
        result.setMsg(toClientTextMessage);
        result.setType(ToClientMessageType.TYPE_TEXT_MESSAGE);
        return ConvertFactory.createSerializer().toJSON(result);

    }


}
