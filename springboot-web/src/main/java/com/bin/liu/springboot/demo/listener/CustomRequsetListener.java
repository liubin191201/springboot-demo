package com.bin.liu.springboot.demo.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @program: springboot-parent
 * @description: customRequstListrner
 * @author: bin.liu
 * @create: 2019-03-16 20:53
 **/

@WebListener
@Slf4j
public class CustomRequsetListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        ServletRequest request = sre.getServletRequest();
        log.info("CustomRequsetListener requestDestroyed .....");
        log.info("url:" + request.getRemoteHost());

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ServletRequest request = sre.getServletRequest();
        log.info("CustomRequsetListener requestInitialized .....");
        log.info("url" + request.getRemoteHost());
    }
}
