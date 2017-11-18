package com.gsau.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gsau.entity.UserDetails;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 HttpServletRequest Srequest = (HttpServletRequest)request;  
	        HttpServletResponse Sresponse = (HttpServletResponse)response;  
	        request.setCharacterEncoding("UTF-8");  
	        response.setContentType("text/html;charset=UTF-8");  
	        HttpSession session = Srequest.getSession();  
	        PrintWriter out = Sresponse.getWriter();  
	        String user= (String)session.getAttribute("exitUser");
	        StringBuffer path = Srequest.getRequestURL();
	        /*if (Srequest.getServletPath().endsWith(".css") || Srequest.getServletPath().endsWith(".js") || Srequest.getServletPath ().contains(".jpg")
	        		|| Srequest.getServletPath ().contains(".png") || Srequest.getServletPath ().contains(".gif")) {          
	        		    //ÒÑµÇÂ¼             
	            chain.doFilter(Srequest,Sresponse);  
	        }*/
	        if(user!=null && !user.equals("")){
	        	chain.doFilter(Srequest,Sresponse);  
	        }else{  
	            out.println("Äú»¹Î´µÇÂ½£¬¶þÃëÖÓºóÌø×ªÖÁµÇÂ¼Ò³Ãæ................................");  
	            //out.println("<script language='javascript'>alert('Äã»¹Î´µÇÂ¼');");  
	            Sresponse.setHeader("refresh","2;/jwgl/login.jsp");  
	            //response.sendRedirect("/pages/users/login.jsp");  
	            //request.getRequestDispatcher("/pages/users/login.jsp").forward(request,response);  
	        }  
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
