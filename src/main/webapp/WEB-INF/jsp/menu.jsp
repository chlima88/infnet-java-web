<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
    .dropdown-menu li {
        position: relative;
    }
    .dropdown-menu .dropdown-submenu {
        display: none;
        position: absolute;
        left: 100%;
        top: -7px;
    }
    .dropdown-menu .dropdown-submenu-left {
        right: 100%;
        left: auto;
    }
    .dropdown-menu > li:hover > .dropdown-submenu {
      display: block;
    }

	.avatar {
		border: 2px solid lime;
		height: 40px;
		width: 40px;
	}
</style>
<body>

       <nav class="navbar navbar-expand-lg bg-primary navbar-dark mb-4">
          <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="/home">CarServices</a>
		    </div>
	            <div class="collapse navbar-collapse" id="navbarNavDropdown">
	              <ul class="nav navbar-nav">
	                <li class="nav-item">
	                  <a class="nav-link" href="/home">
	                    Home
	                  </a>
	                 </li>
                    <c:if test="${ not empty usuarioLogado }">
	                <li class="nav-item dropdown">
                      <a class="nav-link dropdown-toggle ${usuarioLogado.tipo.equals('P') ? 'd-none' :''}" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Usuários
                      </a>
                      <ul class="dropdown-menu">  
                          <li><a class="dropdown-item ${usuarioLogado.tipo.equals('D') ? 'disabled' :''}" href="/usuario/incluir">Cadastro</a></li>
                          <li><a class="dropdown-item" href="/usuario/listar">Listagem</a></li>
                          <li><a class="dropdown-item" href="/usuario/buscar">Buscar</a></li>
                      </ul>
                    </li>
                    <li class="nav-item dropdown">
                      <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Clientes
                      </a>
                      <ul class="dropdown-menu">  
                          <li><a class="dropdown-item ${usuarioLogado.tipo.equals('P') ?'disabled' :''}" href="/cliente/incluir">Cadastro</a></li>
                          <li><a class="dropdown-item" href="/cliente/listar">Listagem</a></li>
                          <li><a class="dropdown-item" href="/cliente/buscar">Buscar</a></li>
                      </ul>
                    </li>
                    <li class="nav-item dropdown">
	                  <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	                    Serviços
	                  </a>
	                  <ul class="dropdown-menu">  
	                       <a class="dropdown-item" href="/servico/listar">Listar</a>  
                         
                          <c:if test="${usuarioLogado.caracteristicas.contains('Ele')}" >
	                          <li>
	                              <a class="dropdown-item" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	                                Elétrica &raquo;
	                              </a>
	                              <ul class="dropdown-menu dropdown-submenu">  
	                                  <li><a class="dropdown-item ${usuarioLogado.tipo.equals('P') ?'disabled' :''}" href="/eletrica/incluir">Cadastro</a></li>
	                                  <li><a class="dropdown-item" href="/eletrica/listar">Listagem</a></li>
	                                  <li><a class="dropdown-item" href="/eletrica/buscar">Buscar</a></li>
	                              </ul>
	                          </li>    
                          </c:if>
                          <c:if test="${usuarioLogado.caracteristicas.contains('Lan')}" >
	                          <li>
	                              <a class="dropdown-item" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	                                Laternagem &raquo;
	                              </a>
	                              <ul class="dropdown-menu dropdown-submenu">  
	                                  <li><a class="dropdown-item ${usuarioLogado.tipo.equals('P') ?'disabled' :''}" href="/lanternagem/incluir">Cadastro</a></li>
	                                  <li><a class="dropdown-item" href="/lanternagem/listar">Listagem</a></li>
	                                  <li><a class="dropdown-item" href="/lanternagem/buscar">Buscar</a></li>
	                              </ul>
	                          </li>  
                          </c:if>
                          <c:if test="${usuarioLogado.caracteristicas.contains('Mec')}" >
	                          <li>
	                              <a class="dropdown-item" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	                                Mecânico &raquo;
	                              </a>
	                              <ul class="dropdown-menu dropdown-submenu">  
	                                  <li><a class="dropdown-item ${usuarioLogado.tipo.equals('P') ?'disabled' :''}" href="/mecanica/incluir">Cadastro</a></li>
	                                  <li><a class="dropdown-item" href="/mecanica/listar">Listagem</a></li>
	                                  <li><a class="dropdown-item" href="/mecanica/buscar">Buscar</a></li>
	                              </ul>
	                          </li>
                          </c:if>
	                  </ul>
	                </li>
                    <li class="nav-item dropdown">
	                  <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	                    Agendamentos
	                  </a>
	                  <ul class="dropdown-menu">  
	                      <li><a class="dropdown-item ${usuarioLogado.tipo.equals('P') ?'disabled' :''}" href="/agendamento/incluir">Cadastro</a></li>
	                      <li><a class="dropdown-item" href="/agendamento/listar">Listagem</a></li>
	                      <li><a class="dropdown-item" href="/agendamento/buscar">Buscar</a></li>
	                  </ul>
	                </li>
                   </c:if>
	              </ul>
	            </div>
            <ul class="nav navbar-nav navbar-right">
							<c:if test="${empty usuarioLogado}">
								<li><a class="nav-link" href="/usuario/incluir"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
								<li><a class="nav-link" href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
							</c:if>
							<c:if test="${not empty usuarioLogado}">
								<li class="row">
									<a class="nav-link col" href="/logout">
										Logout, ${usuarioLogado.nome}
										<img class="rounded-circle avatar" src="${usuarioLogado.imagemUrl!=null ? usuarioLogado.imagemUrl : 'https://cj-lab.s3.us-east-1.amazonaws.com/fallback-user.jpeg'}" />
									</a>
								</li>
							</c:if>
            </ul>
          </div>
        </nav>

</body>
</html>