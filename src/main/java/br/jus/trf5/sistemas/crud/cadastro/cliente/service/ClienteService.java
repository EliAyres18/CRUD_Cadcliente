package br.jus.trf5.sistemas.crud.cadastro.cliente.service;

import java.awt.List;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.ws.rs.Consumes; // javax.ws.rs são interface de alto nivél de anotação
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import br.jus.trf5.sistemas.crud.cadastro.cliente.EntityManager.JpaEntityManager;
import br.jus.trf5.sistemas.crud.cadastro.cliente.model.ClienteModel;


	//Codigo REST
	
@Path("/teste")//URL de acesso aos recursos do servidor
public class ClienteService{
		
	private EntityManager objEm = JpaEntityManager.em();//criado objEM: objeto que ira  possibilitar o acesso a dados	

		
	@GET //este metodo so pode ser requisitado por uma requisicao do tipo get no HTTP
	@Path("/listar") // aqui recebe o nome do servidor que aparece no nome final da url que aponta pra recurso no servidor
	@Produces("appication/json") // serve pra informar ao Jersey q ele deve retornar ao cliente no formato json
	public java.util.List<ClienteModel> Listar(){
		
		String comando = "SELECT c FROM ClienteModel c";// query recebe a consulta a ser realizada no banco, porém aqui deve constar o nome da classe que esta sendo mapeada
		try {
			System.out.println("Vou passar");
			
			java.util.List<ClienteModel> clientes = objEm.createQuery(comando, ClienteModel.class).getResultList(); //o metodo createQuery faz a buscar no banco onde clientes recebe essa busca
			//sobre java.util = Contém as classes e as interfaces usadas para tratar coleções como tabelas, as listas vinculadas, pilhas e dicionários 
			return clientes; // retorno da busca, que eh uma lista do banco
			
		} catch(RollbackException e) {
			System.out.println("Deu erro!");
			throw new WebApplicationException(500); //para recuperar possiveis erros durante a execucao
		}
	}
	
	@POST
	@Path("/cadastrar")
	public Response cadastrar (@FormParam("nome") String nome, @FormParam("idade") int idade){ //foi necessario incluir os parametros nome e idade para ser visto pelo metodo
		
		System.out.println("entrando");
		
		ClienteModel objClient = new ClienteModel(); //instanciando o objeto para a classe ClienteModel
		 
		try {
			System.out.println("Vou passar");
				 
			objClient.setIdade(idade); //leitura de entrada de dados (via teclado)
			objClient.setNome(nome);

				
			objEm.getTransaction().begin(); // inicia a transacao
			objEm.persist(objClient); //novo cliente é persistido
			objEm.getTransaction().commit(); //para que o novo cliente seja gravado permanentemente
			
			objEm.close();
			
			System.out.println("Adicionado!"); //retorna a informacao da acao
	
						
			return Response.status(200).entity("cadastro realizado com sucesso!").build(); //Isto informa que ao usuario foi cadastrado com sucesso
	
		} catch (RollbackException e) {
			throw new WebApplicationException(500);
		}
		
		
	}
		
		@DELETE
		@Path("excluir/{id}")
		public Response excluir (@FormParam("id")int id){ //informado como parâmetro o id do cliente a ser excluído da base de dados.Para que o serviço possa receber o parâmetro é necessário informar o ID do cliente no final da URL no index
			
			ClienteModel cliente = new ClienteModel(); //instanciando o objeto  a classe ClienteModel
						
			try {
				System.out.println("Vou passar");
							
				objEm.getTransaction().begin(); // inicia a transacao
				cliente = objEm.find(ClienteModel.class, id); //faz a busca no bando de dados do cliente a ser excluído
				objEm.remove(cliente); //método remove() exclui o cliente
				objEm.getTransaction().commit(); //para que o usuario seja excluido permanentemente
				objEm.close();
				
				return Response.status(200).entity("usuário excluido").build();
				
			} catch (RollbackException e) {
				throw new WebApplicationException(500);
				}
			}
		
	}



	
	
	

