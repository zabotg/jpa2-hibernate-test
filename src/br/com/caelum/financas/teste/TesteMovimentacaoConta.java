package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.sound.midi.Soundbank;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoConta {
	
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Movimentacao movimentacao = manager.find(Movimentacao.class, 3);
		
		Conta conta = movimentacao.getConta();
		
		System.out.println(conta.getTitular());
		
		System.out.println(conta.getMovimentacoes().size());
		
		
	
	}

}
