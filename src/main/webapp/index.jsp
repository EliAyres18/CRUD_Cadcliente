<!DOCTYPE html>
<html>
<head>
	<title>crud_cadastro_cliente</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="jquery-3.1.1.js"></script>
	<script>
	
	$(document).ready(function() {
		$('#excluir').click(function() {
			var id = $("#idPessoa").val();// aqui seleciono o valor do atributo da classe excluir do botão e guardo na variável id
			console.log("entrei")
			$.ajax({ // aqui o jQuery ajax está usando o método POST logo abaixo para o envio do ID do registro que deve ser apagado.
				url : "/crud_cadastro_cliente/rest/teste/excluir/" + id, // aqui a chamada do arquivo que executará a exclusão do Registro
				type : "DELETE",
				//dataType: "text/plain",
				data : {
					id : id,	// aqui envio o valor do id com a variável 			
				}}).done(function() {  // aqui é o retorno na div 
					alert("Usuário excluido com sucesso");
				}).fail(function(req, status, error) {
					console.log("deu erro");
				});		
			});
	})
	
	$(document).ready(function() {
		$('#go').click(function() {// aqui eu coloquei uma classe no botão
			var nome = $("#nomePessoa").val();// aqui seleciono o valor do atributo da classe cadastrar do botão e guardo na variável id
			var idade = $("#idadePessoa").val();
			console.log("entrei")
			$.ajax({ // aqui o jQuery ajax está usando o método POST logo abaixo para o envio do ID do registro que deve ser cadastrado.
				url : "/crud_cadastro_cliente/rest/teste/cadastrar", // aqui a chamada do arquivo que executará o cadastro do Registro
				type : "POST",
				//dataType: "text/plain",
				data : {
					nome : nome, // aqui envio o valor do nome e idade com a variável 
					idade : idade
				}}).done(function() {   // aqui é o retorno na div 
					alert("Usuário salvo com sucesso");
				}).fail(function(req, status, error) { 
					console.log("deu erro");
				});		
			});
	})
	
	
	</script>
</head>
<body>
<form method="post" accept-charset="utf-8">
	<div class="form-group">
		<div class="modal-body">

			<label for="nomePessoa" class="control-label">Nome</label> <input
				type="text" class="form-control" id="nomePessoa" maxlength="50">

			<label for="idadePessoa" class="control-label">Idade</label> <input
				type="text" class="form-control" id="idadePessoa"
				maxlength="50"> 
		</div>
	</div>
	<input id="go" type="button" value="Salvar"/>
	</form>
	<div>
	
	</div>
	<div class="form-group">
		<div class="modal-body">

			<label for="idPessoa" class="control-label">ID</label> <input
				type="text" class="form-control" id="idPessoa" maxlength="50">
		
		</div>
	</div>
	<input id="excluir" type="button" value="Excluir"/>

	
</body>
</html>
