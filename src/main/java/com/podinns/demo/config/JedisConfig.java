package com.podinns.demo.config;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Redis配置文件
 *
 * @author Carry xie
 * @version 2017-6-17
 */
@Service
@Scope("singleton")
public class JedisConfig {

    // 代表连接地址
    private String host;

    // 代表连接port
    private int port;

    /**
     * 地址
     *
     * @return
     */
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    /**
     * 端口
     *
     * @return
     */
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
