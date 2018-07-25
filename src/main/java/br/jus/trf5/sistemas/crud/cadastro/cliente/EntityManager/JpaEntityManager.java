//eh o EntityManager que disponibiliza todos os métodos que precisamos para conseguir acesso ao banco de dados


package br.jus.trf5.sistemas.crud.cadastro.cliente.EntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaEntityManager {
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("app_crud_cliente"); //aqui foi criado o objeto factory, que instanciado  e recebeu o parâmetro que foi infor no persistence-unit
	
	public static EntityManager em() { //aqui foi definido um metodo que retorna o objeto factory (EntityManger) para realizar as operações do CRUD através de seus metodos.
		return factory.createEntityManager();
	}

}
