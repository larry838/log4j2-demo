package com.podinns.disconf.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baidu.disconf.client.usertools.DisconfDataGetter;
import com.podinns.disconf.config.AutoDemo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-disconf.xml" })
public class AutoDemoTest {
	protected static final Logger LOGGER = LoggerFactory.getLogger(AutoDemoTest.class);
	@Autowired
	private AutoDemo autoDemo;
	
	@Test
	public void  testAutoDemo() {
		try {
			while (true) {
				Thread.sleep(5000);
				LOGGER.info("auto(" + autoDemo.getAuto() + ") ,no_auto("
						+ autoDemo.getNo_auto() + ")"); 
			}

		} catch (Exception e) {

			LOGGER.error(e.toString(), e);
		}
	}

}
