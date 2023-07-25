package com.webperside.courseerpbackend.services.base;

public interface TokenGenerator <T> {

    String generate(T obj);

}
