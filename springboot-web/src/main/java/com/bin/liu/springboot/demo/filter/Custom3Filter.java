package com.bin.liu.springboot.demo.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * @program: springboot-parent
 * @description: 通过FilterRegistrationBean注册的filter
 * @author: bin.liu
 * @create: 2019-03-16 20:36
 **/

@Slf4j
public class Custom3Filter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("customFilter3 start.....");

    }

    @Override
    public void destroy() {
        log.info("customFilter3 destroy.....");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("customFilter3 filter");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
