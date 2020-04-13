package com.ims;


import org.apache.log4j.Logger;

/**
 * Hello world!
 */
public class App {
    private static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("普通Info信息");
        logger.debug("调试debug信息");
        logger.error("报错error信息");
        logger.error("这种形式报错信息", new IllegalArgumentException("非法参数"));
        logger.warn("警告warn信息");
        logger.fatal("严重错误fatal信息");
    }
}
