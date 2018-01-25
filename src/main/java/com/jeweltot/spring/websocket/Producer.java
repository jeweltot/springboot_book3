package com.jeweltot.spring.websocket;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer
{
    private static final SimpleDateFormat dataFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

    @Autowired
    private SimpMessagingTemplate template;

    public void sendMessageTo(String topic, String message)
    {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        builder.append(dataFormatter.format(new Date()));
        builder.append("] ");
        builder.append(message);

        this.template.convertAndSend("/topic/"+ topic, builder.toString());
    }
}
