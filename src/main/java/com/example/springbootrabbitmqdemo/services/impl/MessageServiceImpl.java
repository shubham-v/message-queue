package com.example.springbootrabbitmqdemo.services.impl;

import com.example.springbootrabbitmqdemo.beans.message.MessageBean;
import com.example.springbootrabbitmqdemo.services.MessageService;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    @Override
    public Object handle(MessageBean messageBean) {
//        switch () {
//            default:
//        }
        return messageBean;
    }
}
