package com.example.springbootrabbitmqdemo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Map;

@Slf4j
public class JsonUtils {

    public static ObjectMapper mapper = new ObjectMapper();

    public static <T> T deserialize (String s, Class<T> clazz) {
        try {
            return mapper.readValue(s, clazz);
        } catch (IOException e) {
            log.error("JsonUtils:deserialize | Error while converting Json String to Object", e);
            throw new RuntimeException("Error while converting Json String to Object", e);
        }
    }

    public static String serialize (Object o) {
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            log.error("JsonUtils:deserialize | Error while converting Object to String", e);
            throw new RuntimeException("Error while converting Object to String", e);
        }
    }

    public static <T> T convertValue (Object o, Class<T> clazz) {
        return mapper.convertValue(o, clazz);
    }

    public static Map<String, Object> toMap (Object o) {
        return mapper.convertValue(o, new TypeReference<Map<String, Object>>() {});
    }
}
