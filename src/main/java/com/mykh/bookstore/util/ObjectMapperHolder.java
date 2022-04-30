package com.mykh.bookstore.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Objects;

public class ObjectMapperHolder {

    private static ObjectMapper mapper = null;

    public static ObjectMapper getObjectMapper() {
        if (Objects.isNull(mapper)) {
            mapper = new ObjectMapper();
        }

        return mapper;
    }
}
