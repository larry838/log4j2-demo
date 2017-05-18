package com.podinns.demo.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.podinns.demo.config.JedisConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:demo/applicationContext-simple.xml" })
public class SimpleDemoTask {
	protected static final Logger LOGGER = LoggerFactory.getLogger(SimpleDemoTask.class);
	@Autowired
	private JedisConfig jedisConfig;
	
	@Test
	public void testRedisConfig() {
		System.out.println("redis( " + jedisConfig.getHost() + "," + jedisConfig.getPort()+")");
		LOGGER.info("redis( " + jedisConfig.getHost() + "," + jedisConfig.getPort()+")");
	}

}
