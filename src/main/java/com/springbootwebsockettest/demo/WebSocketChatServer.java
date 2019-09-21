package com.springbootwebsockettest.demo;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint("/chat")

public class WebSocketChatServer {
    private static Map<String , Session> onlineSessions= new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session){
        onlineSessions.put(session.getId(),session);
        sendMessageToAll(Message.jsonStr(Message.Enter,"","",onlineSessions.size()));

    }
    @OnMessage
    public void onMessage(Session session,String jsonStr){
        Message message= JSON.parseObject(jsonStr,Message.class);
        sendMessageToAll(Message.jsonStr(Message.Speak,message.getUsername(),message.getMsg(),onlineSessions.size()));
    }
    @OnClose
     public void onClose(Session session){
        onlineSessions.remove(session.getId());
        sendMessageToAll(Message.jsonStr(Message.Quit,"","",onlineSessions.size()));
    }

    @OnError
    public void onError(Session session,Throwable error){
        error.printStackTrace();

    }
    public static void sendMessageToAll(String msg){
        onlineSessions.forEach((id,session)-> {
            try {
                session.getBasicRemote().sendText(msg);
            }catch (IOException e){
                e.printStackTrace();

            }

        }

        );

    }
}
