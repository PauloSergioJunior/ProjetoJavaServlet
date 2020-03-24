<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>

<mt:admin_tamplate title="Projeto" breadcrumb="Empresas">

	<jsp:attribute name="content">
	
	<section class="content">
			
		  <section class="content-header">
		  
		  	 <p class="h4 mb-4 text-center border border-light p-5">Empresas</p>
			
			<table class="table table-sm">
			  <thead>
			    <tr>
			      <th scope="col">Id</th>
			      <th scope="col">Nome</th>
			      <th scope="col">E-mail</th>
			      <th scope="col">CNPJ</th>
			      <th scope="col">Descrição</th>
			      <th scope="col">Ações</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <th scope="row">1</th>
			      <td>Mark</td>
			      <td>Otto</td>
			      <td>@mdo</td>
			      <td>@mdo</td>
			    </tr>
			    <tr>
			      <th scope="row">2</th>
			      <td>Jacob</td>
			      <td>Thornton</td>
			      <td>@fat</td>
			      <td>@mdo</td>
			    </tr>
			    <tr>
			      <th scope="row">3</th>
			      <td>@twitter</td>
			      <td>@twitter</td>
			      <td>@mdo</td>
			      <td>@mdo</td>
			    </tr>
			  </tbody>
			</table>
	     </section>
	     
	     <br/>
	      <!-- Listar -->
	      <div align="center">
			  <a href="${pageContext.request.contextPath}/admin/empresas/add_empresas.jsp" class="btn btn-info btn-sm" type="submit">Novo</a>
	      </div>
     
     </section>

</jsp:attribute>

</mt:admin_tamplate>


