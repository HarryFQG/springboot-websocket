package m.itiandou.com.websocket2.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import m.itiandou.com.websocket2.entity.MessageVO;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author fengqigui
 * @description
 * @date 2018/05/02 15:44
 */
/*@Component
@ServerEndpoint("/webSocket")*/
public class WebSocket {

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    private static CopyOnWriteArraySet<WebSocket> webSockets = new CopyOnWriteArraySet<>();

    private MessageVO messageVO = new MessageVO();
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSockets.add(this);
        messageVO.setType(1);
        messageVO.setUserNum(webSockets.size());
        messageVO.setMessage("有新的连接");

        ObjectMapper mapper = new ObjectMapper();

        String Json = "";
        try {
            Json = mapper.writeValueAsString(messageVO);
        } catch (Exception ex) {
            System.out.println("-onOpen--"+ex.getMessage());
        }

        this.sendMessage(Json);
        System.out.println("【websocket消息】有新的连接, 总数:{}"+ webSockets.size());
    }


    @OnClose
    public void onClose() {
        webSockets.remove(this);

        messageVO.setType(2);
        messageVO.setUserNum(webSockets.size());
        messageVO.setMessage("有用户离开");

        ObjectMapper mapper = new ObjectMapper();

        String Json = "";
        try {
            Json = mapper.writeValueAsString(messageVO);
        } catch (Exception ex) {
            System.out.println("-onClose--"+ex.getMessage());
        }

        this.sendMessage(Json);


        System.out.println("【websocket消息】连接断开, 总数:{}"+ webSockets.size());
    }

    @OnMessage
    public void onMessage(String message) {

        messageVO.setType(3);
        messageVO.setUserNum(webSockets.size());
        messageVO.setMessage(message);

        ObjectMapper mapper = new ObjectMapper();

        String Json = "";
        try {
            Json = mapper.writeValueAsString(messageVO);
        } catch (Exception ex) {
            System.out.println("-onMessage--"+ex.getMessage());
        }

        this.sendMessage(Json);

        System.out.println("【websocket消息】收到客户端发来的消息:{}"+ message);
    }

    public void sendMessage(String message) {
        for (WebSocket webSocket : webSockets) {
            System.out.println("【websocket消息】广播消息, message={}"+ message);
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
            session.getBasicRemote().sendText(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
