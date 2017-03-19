package cn.digitalScene.Filter;

import cn.digitalScene.Model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 25065 on 2017/3/19.
 */
public class PermissionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       HttpServletRequest request=(HttpServletRequest) servletRequest;
        User user=(User) request.getSession().getAttribute("loginUser");
        if (user==null){
            servletRequest.setAttribute("message","登录时效已过，请重新登录！！！5秒后转到登录页面");
            servletRequest.getRequestDispatcher("/fail").forward(servletRequest,servletResponse);
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
