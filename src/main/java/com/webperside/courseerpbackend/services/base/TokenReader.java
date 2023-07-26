package com.webperside.courseerpbackend.services.base;

public interface TokenReader <T> {

    T read(String token);

}
