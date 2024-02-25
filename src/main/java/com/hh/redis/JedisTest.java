package com.hh.redis;

import redis.clients.jedis.Jedis;

/**
 * 普通jedis连接
 *
 * @author HH
 * @version 1.0
 * @time 2024/02/23  Fri  18:39
 */
public class JedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("", 6379);
        //redis密码
        jedis.auth("");
        jedis.set("demo_key", "demo_value");
        String demoKey = jedis.get("demo_key");
        System.out.println(demoKey);
    }
}
