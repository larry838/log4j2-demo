package com.podinns.disconf.config;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;

/**
 * 静态 配置文件 示例
 *
 * @author Carry xie
 * @version 2017-6-17
 */
@DisconfFile(filename = "static.properties")
public class StaticConfig {

    private static int staticVar;

    @DisconfFileItem(name = "staticVar", associateField = "staticVar")
    public static int getStaticVar() {
        return staticVar;
    }

    public static void setStaticVar(int staticVar) {
        StaticConfig.staticVar = staticVar;
    }

}