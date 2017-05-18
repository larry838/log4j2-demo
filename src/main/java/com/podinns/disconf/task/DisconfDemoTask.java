package com.podinns.disconf.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.podinns.disconf.config.JedisConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-disconf.xml" })
public class DisconfDemoTask {
	protected static final Logger LOGGER = LoggerFactory.getLogger(DisconfDemoTask.class);
	@Autowired
	private JedisConfig jedisConfig;
	private static final String REDIS_KEY = "disconf_key";
	@Test
	public void testRedisConfig() {
		//System.out.println("redis( " + jedisConfig.getHost() + "," + jedisConfig.getPort()+")");
		//LOGGER.info("redis( " + jedisConfig.getHost() + "," + jedisConfig.getPort()+")");
		run();
	}

	public int run() {

        try {

            while (true) {

                Thread.sleep(5000);

                LOGGER.info("redis( " + jedisConfig.getHost() + ","
                        + jedisConfig.getPort() + ")  get key: " + REDIS_KEY);

            }

        } catch (Exception e) {

            LOGGER.error(e.toString(), e);
        }

        return 0;
    }

}
