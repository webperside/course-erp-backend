package com.webperside.courseerpbackend.services.redis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Service
@Slf4j
@RequiredArgsConstructor
public class RedisService {

    private final RedissonClient redissonClient;

    public <T> void set(String key, T value, long minutes) {
        set(key, value, Duration.ofMinutes(minutes));
    }

    public <T> void set(String key, T value, Duration duration) {
        RBucket<T> testKey = redissonClient.getBucket(key);
        testKey.set(value, duration);
    }

    public <T> T get(String key) {
        RBucket<T> testKey1 = redissonClient.getBucket(key);
        return testKey1.get();
    }

}
