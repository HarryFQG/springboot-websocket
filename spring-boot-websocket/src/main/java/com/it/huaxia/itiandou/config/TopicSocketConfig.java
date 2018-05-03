package com.it.huaxia.itiandou.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * 方式1：继承
 * @author fengqigui
 * @description 广播的形式进行消息推送 ，
 * @date 2018/02/27 16:52
 *
 *  通过EnableWebSocketMessageBroker 开启使用STOMP协议来传输基于代理(message broker)的消息,此时浏览器支持使用@MessageMapping 就像支持@RequestMapping一样。
 */
/*
@Configuration
@EnableWebSocketMessageBroker
public class TopicSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) { // endPoint 注册协议节点,并映射指定的URl

        registry.addEndpoint("/weChat").withSockJS();

    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {// 配置消息代理(message broker)

        // 点对点式增加一个/queue 消息代理
        registry.enableSimpleBroker("/queue");

    }


}
*/
