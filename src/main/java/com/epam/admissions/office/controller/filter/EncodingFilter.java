package com.epam.admissions.office.controller.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * CacheFilter class.
 * Filter, that sets request and response encoding.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class EncodingFilter implements Filter {
    private static final String CHARACTER_ENCODING = "encoding";

    private String encoding;

    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter(CHARACTER_ENCODING);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encoding);
        servletResponse.setCharacterEncoding(encoding);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
