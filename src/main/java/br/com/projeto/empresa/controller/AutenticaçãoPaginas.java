package br.com.projeto.empresa.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Autentica��oPaginas
 */
@WebFilter("/*")
public class Autentica��oPaginas implements Filter {

	 private HttpServletRequest httpRequest;
	 
	    private static final String[] loginRequiredURLs = {
	            "/dashboard", "/index.jsp"
	    };
	 
	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	            throws IOException, ServletException {
	        httpRequest = (HttpServletRequest) request;
	 
	        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
	 
	        if (path.startsWith("/admin/")) {
	            chain.doFilter(request, response);
	            return;
	        }
	 
	        HttpSession session = httpRequest.getSession(false);
	 
	        boolean isLoggedIn = (session != null && session.getAttribute("adm") != null);
	 
	        String loginURI = httpRequest.getContextPath() + "/login";
	        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
	        boolean isLoginPage = httpRequest.getRequestURI().endsWith("login.jsp");
	 
	        if (isLoggedIn && (isLoginRequest || isLoginPage)) {
	            // o usu�rio j� est� logado e est� tentando fazer login novamente
	            // depois avance para a p�gina inicial
	        	System.out.println("if");
	            httpRequest.getRequestDispatcher("/").forward(request, response);
	 
	        } else if (!isLoggedIn && isLoginRequired()) {
	            // o usu�rio n�o est� logado e a p�gina solicitada requer
	            //autentica��o e, em seguida, encaminhe para a p�gina de login
	        	System.out.println("else if ");
	            String loginPage = "/login.jsp";
	            RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(loginPage);
	            dispatcher.forward(request, response);
	        } else {
	            //para outras p�ginas solicitadas que n�o requerem autentica��o
	            //ou se o usu�rio j� estiver conectado, continue no destino
	        	System.out.println("else");
	            chain.doFilter(request, response);
	        }
	    }
	 
	 
	    private boolean isLoginRequired() {
	        String requestURL = httpRequest.getRequestURL().toString();
	 
	        for (String loginRequiredURL : loginRequiredURLs) {
	            if (requestURL.contains(loginRequiredURL)) {
	                return true;
	            }
	        }
	 
	        return false;
	    }

}
