package com.zserver.db;

import redis.clients.jedis.Jedis;

/**
 * Created by ZZZ on 2017/8/26.
 */
public class RedisClient {
    private static String IP = "1.1.1.1";
    private static int PORT = 6379;
    private Jedis jedis;

    public void Connet() {
        jedis = new Jedis(IP, PORT);
    }

    public void Close() {
        jedis.close();
    }

    public void Set(String key, String val) {
        jedis.set(key, val);
    }

    public void Set(byte[] key, byte[] val) {
        jedis.set(key, val);
    }

    public String Get(String key) {
        return jedis.get(key);
    }

    public byte[] Get(byte[] key) {
        return jedis.get(key);
    }

    public Long Remove(String key) {
        return jedis.del(key);
    }


}
