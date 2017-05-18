package com.podinns.disconf.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.podinns.disconf.service.SimpleStaticService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-disconf.xml" })
public class StaticDemo {
	protected static final Logger LOGGER = LoggerFactory.getLogger(StaticDemo.class);
	
	@Test
	public void  testStatic() {
		try {
			while (true) {
				Thread.sleep(5000);
				LOGGER.info("staticVar:"+ SimpleStaticService.getStaticFileData());
				LOGGER.info("staticItem:"+ SimpleStaticService.getStaticItem());
				
			}

		} catch (Exception e) {

			LOGGER.error(e.toString(), e);
		
		}
	}
}
