package m.itiandou.com.websocket2.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import m.itiandou.com.websocket2.entity.MessageVO;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author fengqigui
 * @description
 * @date 2018/05/02 16:25
 */
@ServerEndpoint("/webSocket")
@Component
public class WebSocketOfMy {

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    private static CopyOnWriteArraySet<WebSocketOfMy> webSockets = new CopyOnWriteArraySet<>();
    //统计在线人数
    private static int onlineCount = 0;
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        onlineCount--;
    }
    private MessageVO messageVO = new MessageVO();

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSockets.add(this);
        messageVO.setType(1);
        messageVO.setUserNum(webSockets.size());
        messageVO.setMessage("有新的连接");
        messageVO.setSessionId(session.getId());
        List<String> sessions = new  ArrayList<>();
        for(WebSocketOfMy webSocketOfMy:webSockets){
            Session session1 = webSocketOfMy.session;
            sessions.add(session1.getId());
        }
        messageVO.setSessions(sessions);

        ObjectMapper mapper = new ObjectMapper();

        String Json = "";
        try {
            Json = mapper.writeValueAsString(messageVO);
        } catch (Exception ex) {
            System.out.println("-onOpen--"+ex.getMessage());
        }

        this.sendMessage(Json);
        // 单点返回消息
        messageVO.setMessage("连接成功");

        try {
            Json = mapper.writeValueAsString(messageVO);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        sendMsg(session, Json);
        System.out.println("websocket消息】有新的连接, 总数:"+ webSockets.size());
    }

    @OnClose
    public void onClose() {

        webSockets.remove(this);
        messageVO.setType(2);
        messageVO.setUserNum(webSockets.size());
        messageVO.setMessage("有用户离开");
        webSockets.remove(this);

        List<String> sessions = new  ArrayList<>();
        for(WebSocketOfMy webSocketOfMy:webSockets){
            Session session1 = webSocketOfMy.session;
            sessions.add(session1.getId());
        }
        messageVO.setSessions(sessions);

        ObjectMapper mapper = new ObjectMapper();

        String Json = "";
        try {
            Json = mapper.writeValueAsString(messageVO);
        } catch (Exception ex) {
            System.out.println("onClose--"+ex.getMessage());
        }

        this.sendMessage(Json);


        System.out.println("【websocket消息】连接断开, 总数:"+ webSockets.size());
    }

    @OnMessage
    public void onMessage(Session session,String message) {

        messageVO.setType(3);
        messageVO.setUserNum(webSockets.size());
        messageVO.setMessage(message);

        messageVO.setSessionId(session.getId());
        List<String> sessions = new  ArrayList<>();
        for(WebSocketOfMy webSocketOfMy:webSockets){
            Session session1 = webSocketOfMy.session;
            sessions.add(session1.getId());
        }
        messageVO.setSessions(sessions);

        ObjectMapper mapper = new ObjectMapper();

        String Json = "";
        try {
            Json = mapper.writeValueAsString(messageVO);
        } catch (Exception ex) {
            System.out.println("onMessage--"+ex.getMessage());
        }

        this.sendMessage(Json);

        System.out.println("【websocket消息】收到客户端发来的消息:"+ message);
    }

    public void sendMessage(String message) {
        System.out.println("");
        for (WebSocketOfMy webSocket : webSockets) {
            System.out.println("websocket消息】广播消息, message="+ message);
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //统一的发送消息方法
    public synchronized void sendMsg(Session session, String msg) {
        try {
            System.out.println("websocket消息】点对点消息, message="+ msg );
            session.getBasicRemote().sendText(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
