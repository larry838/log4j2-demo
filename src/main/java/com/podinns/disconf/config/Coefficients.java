package com.podinns.disconf.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;


/**
 * 金融系数文件
 *
 **/
@Service
@Scope("singleton")
@DisconfFile(filename = "coefficients.properties")
public class Coefficients {

	public static final String key = "discountRate";
	
    @Value(value = "2.0d")
    private Double discount;


    /**
     * 折扣率，分布式配置
     *
     * @return
     */
    @DisconfFileItem(name = key)
    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
