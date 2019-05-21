package com.example.springbootrabbitmqdemo.services;

import com.example.springbootrabbitmqdemo.beans.message.MessageBean;

import java.util.Map;

public interface  MessageService {

    Object handle (MessageBean messageBean);

}
