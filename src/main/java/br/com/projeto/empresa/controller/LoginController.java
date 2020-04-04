package br.com.projeto.empresa.controller;

import java.awt.Window;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginAutentic")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		if(email.equals("paulo@gmail.com") && senha.equals("123")) {
			System.out.println("post aqui");
			HttpSession session = request.getSession(false);
			session.setAttribute("adm", email);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("erro", "Login ou Senha incorretos!");
			rd.forward(request, response);
		}
	}

}
