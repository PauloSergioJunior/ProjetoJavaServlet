package br.com.projeto.empresa.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projeto.empresa.model.Empresa;

/**
 * Servlet implementation class EmpresaController
 */
@WebServlet("/EmpresaController")
public class EmpresaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Empresa empresa;
	
	public EmpresaController() {
		this.empresa = new Empresa();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String nome = 
//		String email = 
//		String cnpj = 
//		String descricao = 
	}

}
