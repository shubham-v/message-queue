package com.example.springbootrabbitmqdemo.rabbitmq.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MessageSink /*extends Sink*/ {

    String INPUT_MESSAGE_PUBLISHED = "inputMessagePublished";

    @Input(INPUT_MESSAGE_PUBLISHED)
    SubscribableChannel inputMessagePublished();

}
