package com.bin.liu.springboot.demo.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @program: springboot-parent
 * @description: sessionListener
 * @author: bin.liu
 * @create: 2019-03-16 20:59
 **/

@WebListener
@Slf4j
public class CustomContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        log.info("CustomContextListener contextInitialized......");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("CustomContextListener contextDestroyed......");

    }
}
