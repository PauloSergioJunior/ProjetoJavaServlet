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
 * Servlet Filter implementation class AutenticaçãoPaginas
 */
@WebFilter("/*")
public class AutenticaçãoPaginas implements Filter {

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
	            // o usuário já está logado e está tentando fazer login novamente
	            // depois avance para a página inicial
	        	System.out.println("if");
	            httpRequest.getRequestDispatcher("/").forward(request, response);
	 
	        } else if (!isLoggedIn && isLoginRequired()) {
	            // o usuário não está logado e a página solicitada requer
	            //autenticação e, em seguida, encaminhe para a página de login
	        	System.out.println("else if ");
	            String loginPage = "/login.jsp";
	            RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(loginPage);
	            dispatcher.forward(request, response);
	        } else {
	            //para outras páginas solicitadas que não requerem autenticação
	            //ou se o usuário já estiver conectado, continue no destino
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
