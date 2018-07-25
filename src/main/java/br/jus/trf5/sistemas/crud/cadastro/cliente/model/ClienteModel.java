package br.jus.trf5.sistemas.crud.cadastro.cliente.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity// � uma estrutura de mapeamento objeto relacional e corresponde a uma refernecia a uma tabela
@Table(name="teste")// corresponde a tabela do banco
@SequenceGenerator(name = "sq_teste", sequenceName= "teste_id_seq")

public class ClienteModel {
	
	
		@Id//foi especificado que o Id eh a chave primaria
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_teste")// a chave primaria deve ser gerada automaticamente
		private int id;
		
		@Column(name="nome")//coluna na tabela do banco
		private String nome;
		
		@Column(name="idade")
		private int idade;
			
		public int getId_teste(){
			return id;
		}
		public String getNome(){
			return nome;
		}
		public int getIdade(){
			return idade;
		}
		
		
		public void setNome(String nome){
			this.nome =nome;
		}
		public void setIdade(int idade){
			this.idade=idade;
		}
		
		
		
	}
	


