package com.chat.socket.ProjectWebSocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker //con esta anotacion no permitira configurar un broker para que se conencten nuestros clientes
public class webSocketConfiguration implements WebSocketMessageBrokerConfigurer { //Al implementar la clase "" debemos implementar unos metodos


    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) { //Este metodo nos permite habiliatar un broker
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app"); //path de destino de los mensajes

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {  //Este metodo no permite configurar los endpoints
        registry.addEndpoint("/chat-socket"). //con esto estamos declarando el path con que el front se conectara a nuestro servidor
        setAllowedOrigins("http://localhost:4200") //aqui vamos a darle permiso a los cleintes que puedan conectarse al endpoint
                .withSockJS();
    }
}
