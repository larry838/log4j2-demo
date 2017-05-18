package com.podinns;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
public class Test {
	// log4j2方式
	// private static final Logger logger =LogManager.getLogger(Test.class);
	// slf4j方式
	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Test.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  logger.info("[GET] /user/all getAllUsers");
		  logger.debug("debug");
		  logger.trace("trace");
		  logger.error("error");
		  for(int i=0;i<=1000;i++){
			  
		  logger.error("这个会打印出所有的error及以下级别的信息，每次大小超过size，则这size大小的日志会自动存入按年份-月份建立的文件夹下面并进行压缩，作为存档");
		 }

	}

}
