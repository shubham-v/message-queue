package com.example.springbootrabbitmqdemo.rabbitmq.consumer;

import com.example.springbootrabbitmqdemo.beans.message.MessageBean;
import com.example.springbootrabbitmqdemo.rabbitmq.messaging.MessageSink;
import com.example.springbootrabbitmqdemo.rabbitmq.publisher.MessagePublisher;
import com.example.springbootrabbitmqdemo.services.MessageService;
import com.example.springbootrabbitmqdemo.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@Slf4j
@EnableBinding(value = {
        MessageSink.class,
        MessagePublisher.class
})
public class MessageConsumer {

    @Autowired
    private MessageService messageService;

    @Autowired
    private MessagePublisher publisher;

    @StreamListener(target = MessageSink.INPUT_MESSAGE_PUBLISHED)
    public void inputMessagePublished (String message) {
        try {
            log.info("Published message received | Message: {}", message);
            MessageBean messageBean = JsonUtils.deserialize(message, MessageBean.class);
            Object result           = messageService.handle(messageBean);

            String outputMessage    = JsonUtils.serialize(result);
            log.info("Publishing output message | Message: {}", outputMessage);
            publisher.publishOutputMessage().send(message(outputMessage));
        } catch (Exception e) {
            log.error("Exception while consuming message | Message: {}", message, e);

            log.info("Republishing as failed message | Message: {}", message);
            publisher.publishFailedMessage().send(message(message));
        } finally {
            log.info("Completed processing of the message | Message: {}", message);
        }
    }

    private <T> Message<T> message (T t) {
        return MessageBuilder.withPayload(t).build();
    }

}
