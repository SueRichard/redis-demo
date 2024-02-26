package com.hh.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * jedis cluster test
 *
 * @author HH
 * @version 1.0
 * @time 2024/02/24  Sat  14:33
 */
public class JedisClusterTest {
    public static void main(String[] args) throws IOException {
        //集合保存集群信息
        Set<HostAndPort> set = new HashSet<>();
        set.add(new HostAndPort("", 7001));
        set.add(new HostAndPort("", 7002));
        set.add(new HostAndPort("", 7003));
        set.add(new HostAndPort("", 7004));
        set.add(new HostAndPort("", 7005));
        set.add(new HostAndPort("", 7006));
        //创建集群操作对象
        JedisCluster jedisCluster = new JedisCluster(set);
        //操作数据
        //jedis中的方法和redis中的命令是相同的
        jedisCluster.set("demo25", "demo25-1");
        String value = jedisCluster.get("demo25");
        System.out.println(value);
        //关闭资源
        jedisCluster.close();
    }
}
