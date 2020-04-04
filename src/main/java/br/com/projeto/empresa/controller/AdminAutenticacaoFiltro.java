package br.com.projeto.empresa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AdminAutenticacaoFiltro
 */
@WebFilter("/admin/*")
public class AdminAutenticacaoFiltro implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
 
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);
 
        boolean isLoggedIn = (session != null && session.getAttribute("adm") != null);
 
System.out.println(session+""+session.getAttribute("adm"));
        String loginURI = httpRequest.getContextPath() + "/login";
 
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
 
        boolean isLoginPage = httpRequest.getRequestURI().endsWith("login.jsp");
 
        if (isLoggedIn && (isLoginRequest || isLoginPage)) {
        	System.out.println("if adm");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
            dispatcher.forward(request, response);
 
        } else if (isLoggedIn || isLoginRequest) {
            // continua a cadeia de filtro
            //permite que a solicitação chegue ao destino
        	System.out.println("if else adm");
            chain.doFilter(request, response);
 
        } else {
            // o administrador não está logado, portanto, a autenticação é necessária
           
        	PrintWriter out = response.getWriter();
        	out.println("<html>");
            out.println("<body>");
            out.println("<h1>");
            out.println("O administrador não está logado, portanto, a autenticação é necessária!");
            out.println("<h1>");
            out.println("</body>");
            out.println("</html>");
        	
 
        }
 
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}


	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
