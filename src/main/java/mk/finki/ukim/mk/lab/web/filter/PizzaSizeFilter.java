package mk.finki.ukim.mk.lab.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter
public class PizzaSizeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;

        String pizzaSize = (String) request
                .getParameter("pizza_size");

        String path = request.getServletPath();

        if(path.equals("/PizzaOrder.do") && (pizzaSize==null || pizzaSize.isEmpty()))
        {
            response.sendRedirect("/selectPizza.do");
        }
        else
        {
            filterChain.doFilter(servletRequest,servletResponse);
        }




    }

    @Override
    public void destroy() {

    }
}
