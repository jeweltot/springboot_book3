package com.jeweltot.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer
{
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry)
    {
        /*
        STOMP(https://stomp.github.io/) 끝점을 등록하는 메서드
        여기선 /stomp라는 끝점을 등록하고
        자바스크립트 라이브러리는 SockJS(https://github.com/sockJs)를 사용한다.
         */
        registry.addEndpoint("/stomp").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config)
    {
        // 클라이언트가 /topic으로 시작하는 경로로 접속해아 웹소캣 중개기를 사용
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }
}
