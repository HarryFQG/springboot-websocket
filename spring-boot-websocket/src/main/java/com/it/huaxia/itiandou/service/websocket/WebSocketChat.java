package com.it.huaxia.itiandou.service.websocket;

import com.it.huaxia.itiandou.entity.UserSocket;
import com.it.huaxia.itiandou.entity.socketweb.ToServerTextMessage;
import com.it.huaxia.itiandou.service.websocket.sender.MessageSender;
import com.it.huaxia.itiandou.util.ConvertFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author fengqigui
 * @description 聊天的处理类
 * @date 2018/02/28 11:10
 */

@ServerEndpoint("/chatWebSocket/{uid}")
@Component
public class WebSocketChat {

    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     */
    private static AtomicInteger count = new AtomicInteger(0);

    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的UserSocket对象。
     * ConcurrentHashMap 也是线程安全的
     */
    private static CopyOnWriteArraySet<UserSocket> webSocketSet = new CopyOnWriteArraySet<UserSocket>();

    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;


    /**
     * 连接建立成功是调用得方法
     * @param session session
     * @param uid 用户的id
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("uid") int uid){

        UserSocket userSocket = new UserSocket(session, uid);
        //加入set中
        webSocketSet.add(userSocket);
        //在线数加1
        count.incrementAndGet();
        System.out.println("有新连接加入！当前在线人数为" + count.get());

    }

    /**
     * 收到客户端的消息后调用的方法
     * @param message 客户端发送的消息
     * @param session 客户端对应的session
     */
    @OnMessage
    public void receiveMessage(String message,Session session){

        System.out.println("来自客户端的消息:" + message);
        ToServerTextMessage toServerTextMessage = ConvertFactory.createSerializer().toObject(message, ToServerTextMessage.class);
        //得到接收的对象
        MessageSender sender = new MessageSender();
        sender.sendMessage(toServerTextMessage);


    }


}
