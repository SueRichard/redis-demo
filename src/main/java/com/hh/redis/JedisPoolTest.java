package com.hh.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * jedis pool test
 *
 * @author HH
 * @version 1.0
 * @time 2024/02/24  Sat  10:05
 */
public class JedisPoolTest {
    public static void main(String[] args) {
        //1.创建连接池配置的工具类对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //jedis连接的空闲数
        jedisPoolConfig.setMaxIdle(5);
        //总连接数
        jedisPoolConfig.setMaxTotal(10);
        JedisPool jedisPool = null;
        Jedis jedis = null;
        try {
            //2.创建连接池对象
            jedisPool = new JedisPool(jedisPoolConfig, "", 6379);
            //3.1获取redis资源
            jedis = jedisPool.getResource();
            //3.2设置密码认证
            jedis.auth("");
            //4.操作数据
            jedis.set("stu1", "student1");
            String stu1 = jedis.get("stu1");
            System.out.println(stu1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (jedis != null) {
                jedis.close();
            }
            if (jedisPool != null) {
                jedisPool.close();
            }
        }
    }
}
