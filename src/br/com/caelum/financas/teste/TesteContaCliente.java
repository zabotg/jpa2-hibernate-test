package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Cliente;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteContaCliente {
	
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		
		cliente.setNome("Leonardo");
		cliente.setEndereco("Rua Universitaria, 615");
		cliente.setProfissao("Professor");
		
		Conta conta = new Conta();
		conta.setId(2);
		
		
		cliente.setConta(conta);
		
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		manager.persist(cliente);
		
		
		manager.getTransaction().commit();
		manager.close();
		
		
		
		
	}

}
