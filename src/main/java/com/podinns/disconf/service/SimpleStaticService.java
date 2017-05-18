package com.podinns.disconf.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.baidu.disconf.client.common.annotations.DisconfItem;
import com.podinns.disconf.config.StaticConfig;

/**
 * 使用静态配置文件的示例<br/>
 * Plus <br/>
 * 静态配置项 使用示例
 *
 * @author Carry xie
 * @version 2017-8-14
 */
public class SimpleStaticService {

    private static int staticItem = 56;

    /**
     *
     * @return
     */
    public static int getStaticFileData() {

        return StaticConfig.getStaticVar();
    }
    
    @DisconfItem(key = "staticItem")
    public static int getStaticItem() {
        return staticItem;
    }

    public static void setStaticItem(int staticItem) {
        SimpleStaticService.staticItem = staticItem;
    }
}
