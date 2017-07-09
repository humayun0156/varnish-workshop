package varnish.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author humayun
 */

@Component
@Order(1)
public class MyLogFilter implements Filter {

    private final static Logger LOGGER = LoggerFactory.getLogger(MyLogFilter.class);

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
        LOGGER.info("MyLogFilter init");
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        LOGGER.info("RequestURL: " + req.getRequestURI());

        //System.out.println("Filter: " + req.getRequestURI() + ", URL: " + req.getRequestURL());

        //System.out.println("Header: " + req.getHeader("X-Device"));

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        LOGGER.warn("Destroying MyLogFilter");
    }
}

    // Now, confgure the Filter implemented above in Spring configuration class. Take a look
