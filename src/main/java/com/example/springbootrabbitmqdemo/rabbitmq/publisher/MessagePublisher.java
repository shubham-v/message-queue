package com.example.springbootrabbitmqdemo.rabbitmq.publisher;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MessagePublisher {

    String PUBLISH_OUTPUT_MESSAGE  = "publishOutputMessage";
    String PUBLISH_FAILED_MESSAGE  = "publishFailedMessage";

    @Output(PUBLISH_OUTPUT_MESSAGE)
    MessageChannel publishOutputMessage();

    @Output(PUBLISH_FAILED_MESSAGE)
    MessageChannel publishFailedMessage();

}
