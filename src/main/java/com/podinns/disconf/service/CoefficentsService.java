package com.podinns.disconf.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.baidu.disconf.client.common.annotations.DisconfItem;
import com.podinns.disconf.config.Coefficients;
@Service
@Scope("singleton")
public class CoefficentsService {
	
	 public static final String key = "moneyInvest";

	 private Double moneyInvest = 1000d;
	
    protected static final Logger LOGGER = LoggerFactory
            .getLogger(CoefficentsService.class);

    @Autowired
    private Coefficients coefficients;

    /**
     *
     *
     * @return
     */
  /*  public double calcMoney() {
        return 10000 * coefficients.getDiscount();
    }*/
    
    /**
     * 投资的钱，分布式配置 <br/>
     * <br/>
     * 这里切面无法生效，因为SpringAOP不支持。<br/>
     * 但是这里还是正确的，因为我们会将值注入到Bean的值里.
     *
     * @return
     */
    @DisconfItem(key = key)
    public Double getMoneyInvest() {
        return moneyInvest;
    }

    public void setMoneyInvest(Double moneyInvest) {
        this.moneyInvest = moneyInvest;
    }
    /**
    *
    * @return
    */
   public double calcMoney() {
	   System.out.println(coefficients.getDiscount());
       return coefficients.getDiscount()
               * getMoneyInvest();
   }
}
