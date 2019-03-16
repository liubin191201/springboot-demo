package com.bin.liu.springboot.demo.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @program: springboot-parent
 * @description: 自定义过滤器
 * @author: bin.liu
 * @create: 2019-03-16 20:09
 **/

@WebFilter(filterName = "customFilter",urlPatterns = {"/*"})
@Slf4j
public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("customFilter start.....");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

            log.info("doFilter 请求处理");
            servletRequest.setCharacterEncoding("utf-8");
            servletResponse.setCharacterEncoding("utf-8");

            filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        log.info("customFilter destroy.....");

    }
}
