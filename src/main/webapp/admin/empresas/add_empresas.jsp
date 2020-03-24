<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>

<mt:admin_tamplate title="Projeto" breadcrumb="Cadastrar Empresas">

	<jsp:attribute name="content">
	
	<section class="content">
			
		  <section class="content-header">
			<form class="text-center border border-light p-5" action="#!">
			
			    <p class="h4 mb-4">Nova Empresa</p>
				
				<div class="form-group">
				    <!-- Name -->
				    <input name="nome" type="text" id="nome" class="form-control mb-4" placeholder="Name">
			    </div>
			
				<div class="form-group">
				    <!-- Email -->
				    <input name="email" type="email" id="email" class="form-control mb-4" placeholder="E-mail">
			    </div>
			    
			    <div class="form-group">
				     <!-- CNPJ -->
				    <input name="cnpj" type="text" id="cnpj" class="form-control mb-4" placeholder="CNPJ">
			    </div>
			
			    <!-- Message -->
			    <div class="form-group">
			        <textarea name="descricao" class="form-control rounded-0" id="descricao" rows="3" placeholder="Descrição"></textarea>
			    </div>
			
			
			    <!-- Enviar -->
			    <button class="btn btn-info btn-sm" type="submit">Salvar</button>
			    
			    <!-- Listar -->
			    <a href="${pageContext.request.contextPath}/admin/empresas/empresas.jsp" class="btn btn-info btn-sm" type="submit">Empresas</a>
			
			</form>
	     </section>
     
     </section>

</jsp:attribute>

</mt:admin_tamplate>