package com.wping.seed.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

@Component
public class ApplicationConfig implements ApplicationContextAware, InitializingBean, ServletContextAware, ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);

    private static volatile boolean flag = false;

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("afterPropertiesSet start...");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("setApplicationContext start...");
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        logger.info("onApplicationEvent start...");

        if (!flag) {

            flag = true;
        }

        logger.info("========= application seed is startup =========");
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        logger.info("setServletContext start...");
    }
}
