package com.bin.liu.springboot.demo.socket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @program: springboot-parent
 * @description: websock
 * @author: bin.liu
 * @create: 2019-03-19 15:02
 **/

@Component
@ServerEndpoint(value = "/my-chat/{usernick}")
@Slf4j
public class WebSocketController {


    /**
     * 连接事件
     * @param userNick
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam("usernick") String userNick, Session session){
        String message = "有新游客[" + userNick + "]加入聊天室";
        log.info(message);
        WebSocketUtil.addSession(userNick, session);
        WebSocketUtil.sendMessageForAll(message);
    }

    /**
     * 关闭事件
     * @param userNick
     * @param session
     */
    @OnClose
    public void onClose(@PathParam("usernick") String userNick,Session session){
        String message = "游客[" + userNick + "]退出聊天室";
        log.info(message);
        WebSocketUtil.remoteSession(userNick);
        WebSocketUtil.sendMessageForAll(message);
    }

    /**
     * 发消息事件
     * @param userNick
     * @param message
     */
    @OnMessage
    public void onMessage(@PathParam(value = "usernick") String userNick, String message){
        String info = "游客[" + userNick + "]:" + message;
        log.info(info);
        WebSocketUtil.sendMessageForAll(info);
    }
    
    @OnError
    public void onError(Session session,Throwable throwable){
        log.error("异常",throwable);
        try {
            session.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        throwable.printStackTrace();
    }


}
