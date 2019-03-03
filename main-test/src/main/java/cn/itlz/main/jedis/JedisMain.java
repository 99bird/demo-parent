package cn.itlz.main.jedis;

import redis.clients.jedis.Jedis;

/**
 * @author Liuzd QQ: 77822013
 * @since 2018/09/28 0028
 */
public class JedisMain {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.88.134",6379);
        String result = jedis.set("hello", "jedis");
        System.out.println(result);
        String value = jedis.get("hello");
        System.out.println(value);
    }
}
