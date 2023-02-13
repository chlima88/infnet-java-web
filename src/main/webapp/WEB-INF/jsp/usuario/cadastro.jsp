<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="https://livejs.com/live.js"></script>
  
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <meta charset="ISO-8859-1">
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
    </style>
	<title>Cadastro de usuários</title>
</head>
<body>
	<div class="container">
	
	       <nav class="navbar navbar-expand-lg bg-primary navbar-dark mb-4">
          <div class="container-fluid">
            <a class="navbar-brand" href="/home">Home</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDarkDropdown" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
              <ul class="navbar-nav">
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Menu
                  </a>
                  <ul class="dropdown-menu">
                    <li>
                        <a class="dropdown-item" href="#">Geral &raquo;</a>
                        <ul class="dropdown-menu dropdown-submenu">
                            <li><a class="dropdown-item" href="/login">Login</a></li>
                            <li><a class="dropdown-item" href="/error">Pagina de erro</a></li>
                        </ul>
                    </li>
                    <li>
                        <a class="dropdown-item" href="#">Usuários &raquo;</a>
                        <ul class="dropdown-menu dropdown-submenu">   
                            <li><a class="dropdown-item" href="/usuario/incluir">Cadastro</a></li>
                            <li><a class="dropdown-item" href="/usuario/listar">Listagem</a></li>
                            <li><a class="dropdown-item" href="/usuario/buscar">Buscar</a></li>
                            <li><a class="dropdown-item" href="/usuario">Dados</a></li>
                        </ul>
                    </li>
                  </ul>
                  
                </li>
              </ul>
            </div>
          </div>
        </nav>
        
	
		<h1>Cadastrar usuário</h1>
	
		<form action="/usuario/incluir" method="post">
		
			<div class="row row-cols-1 row-cols-md-4">
				<div class="col mb-3">
					<label class="form-label" for="nome">Nome:</label>
					<input class="form-control" value="Charles" type="text" name="nome" />
					
					<label class="form-label" for="contato">E-mail: </label>
					<input class="form-control" value="1@1.com" type="email" name="email"/>
					
					<label class="form-label" for="documento">Senha: </label>
					<input class="form-control" value="12345" type="password" name="senha"/>
	
				</div>
				
				<div class="col mb-3">
					<p>Tipo: </p>
					<div class="form-group">
						<input class="form-check-input" checked value="P" type="radio" name="tipo"/>
						<label class="form-check-label" for="tipoPadrao">Padrão</label>
					</div>
					<div class="form-group">
						<input class="form-check-input" value="D" type="radio" name="tipo"/>
						<label class="form-check-label" for="tipoDiretor">Diretor</label>
					</div>
					<div class="form-group">
						<input class="form-check-input" value="A" type="radio" name="tipo"/>
						<label class="form-check-label" for="tipoDatabase">Administrador</label>
					</div>
				</div>
			
				<div class="col mb-3">
				
					<p>Características:</p>
	
					<div class="form-group">
						<input class="form-check-input" type="checkbox" name="caracteristicas" id="caracteristicasDev" value="Dev" checked />
						<label class="form-check-label" for="caracteristicasDev">Developer</label>
					</div>
					
					<div class="form-group">
						<input class="form-check-input" type="checkbox" name="caracteristicas" id="caracteristicasAnl" value="Anl"/>
						<label class="form-check-label" for="caracteristicasAnl">Analista</label>
					</div>
					
					<div class="form-group">
						<input class="form-check-input" type="checkbox" name="caracteristicas" id="caracteristicasDb" value="Db" />
						<label class="form-check-label" for="caracteristicasDb">Database</label>
					</div>
				
				</div>
			
				<div class="col mb-3">
					<p>Setor:</p>
					<select name="setor">
						<option value=1>Comercial</option>
						<option value=2>Diretoria</option>
						<option value=3 selected>Desenvolvimento</option>
					</select>
					
				
				</div>
			</div>
		
			<button class="w-25 btn btn-primary" type="submit">Cadastrar</button>
			<a class="w-25 btn btn-primary" role="button" href="javascript:void(0)" onClick="history.go(-1); return false;">Voltar</a>
			
		</form>
	</div>
	

</body>
</html>