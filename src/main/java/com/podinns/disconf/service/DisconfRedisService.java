package com.podinns.disconf.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

import com.podinns.disconf.config.JedisConfig;
import com.podinns.utils.JedisUtil;

/**
 * 一个简单的Redis服务
 *
 * @author Carry xie
 * @version 2017-6-17
 */
@Service
@Scope("singleton")
public class DisconfRedisService implements InitializingBean, DisposableBean {

    protected static final Logger LOGGER = LoggerFactory.getLogger(DisconfRedisService.class);

    // jedis 实例
    private Jedis jedis = null;

    /**
     * 分布式配置
     */
    @Autowired
    private JedisConfig jedisConfig;

    /**
     * 关闭
     */
    public void destroy() throws Exception {

        if (jedis != null) {
            jedis.disconnect();
        }
    }

    /**
     * 进行连接
     */
    public void afterPropertiesSet() throws Exception {

        jedis = JedisUtil.createJedis(jedisConfig.getHost(),
                jedisConfig.getPort());
    }

    /**
     * 获取一个值
     *
     * @param key
     * @return
     */
    public String getKey(String key) {
        if (jedis != null) {
            return jedis.get(key);
        }

        return null;
    }
    
    /**
     * 更改Jedis
     */
    public void changeJedis() {

        LOGGER.info("start to change jedis hosts to: " + jedisConfig.getHost()
                + " : " + jedisConfig.getPort());

        jedis = JedisUtil.createJedis(jedisConfig.getHost(),
                jedisConfig.getPort());

        LOGGER.info("change ok.");
    }

}
