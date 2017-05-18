package com.podinns.disconf.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baidu.disconf.client.usertools.DisconfDataGetter;
import com.podinns.disconf.config.Coefficients;
import com.podinns.disconf.service.CoefficentsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-disconf.xml" })
public class CoefficentsDemo {
	protected static final Logger LOGGER = LoggerFactory.getLogger(CoefficentsDemo.class);
	 @Autowired
	 private CoefficentsService coefficentsService;
	   @Autowired
	    private Coefficients coefficients;
	
	@Test
	public void  testCoefficients() {
		try {
			while (true) {
				Thread.sleep(5000);
				LOGGER.info("discountRate(" + coefficients.getDiscount() + ") ,calcMoney("
						+ coefficentsService.calcMoney() + ")");
				if (DisconfDataGetter.getByFileItem("autoconfig.properties", "auto") != null) {
                    LOGGER.info(DisconfDataGetter.getByFileItem("coefficients.properties", "discountRate").toString());
                }
                    
                
				LOGGER.info("moneyInvest:"+DisconfDataGetter.getByItem("moneyInvest").toString());
			}

		} catch (Exception e) {

			LOGGER.error(e.toString(), e);
		}
	}

}
