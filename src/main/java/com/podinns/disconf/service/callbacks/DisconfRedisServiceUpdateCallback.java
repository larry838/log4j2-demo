package com.podinns.disconf.service.callbacks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;
import com.podinns.disconf.config.JedisConfig;
import com.podinns.disconf.service.DisconfRedisService;
import com.podinns.disconf.config.Coefficients;

/**
 * 更新Redis配置时的回调函数
 *
 * @author Carry xie
 * @version 2017-6-17
 */
@Service
@Scope("singleton")
@DisconfUpdateService(classes = {JedisConfig.class}, itemKeys = { Coefficients.key })
public class DisconfRedisServiceUpdateCallback implements IDisconfUpdate {

    protected static final Logger LOGGER = LoggerFactory.getLogger(DisconfRedisServiceUpdateCallback.class);

    @Autowired
    private DisconfRedisService disconfRedisService;

    /**
     *
     */
    public void reload() throws Exception {

    	disconfRedisService.changeJedis();
    }

}