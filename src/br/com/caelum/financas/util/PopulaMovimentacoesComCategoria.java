package br.com.caelum.financas.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class PopulaMovimentacoesComCategoria {

	public static void main(String[] args) {
		
		Categoria categoria1 = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Negocios");
		
		Conta conta = new Conta();
		conta.setId(2);
		
		Movimentacao movimentacao1 = new Movimentacao();
		movimentacao1.setData(Calendar.getInstance()); //hoje
		movimentacao1.setDescricao("Viagem à São Paulo");
		movimentacao1.setTipo(TipoMovimentacao.SAIDA);
		movimentacao1.setValor(new BigDecimal("100.0"));
		movimentacao1.setCategorias(Arrays.asList(categoria1, categoria2));
		
		movimentacao1.setConta(conta);
		
		Movimentacao movimentacao2 = new Movimentacao();
		
		Calendar amanha = Calendar.getInstance();
		amanha.add(Calendar.DAY_OF_MONTH, 1);
		
		movimentacao2.setData(amanha); //amanha
		
		movimentacao2.setDescricao("Viagem ao Rio de Janeiro");
		movimentacao2.setTipo(TipoMovimentacao.SAIDA);
		movimentacao2.setValor(new BigDecimal("300.0"));
		movimentacao2.setCategorias(Arrays.asList(categoria1, categoria2));
		
		movimentacao2.setConta(conta);
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		manager.persist(categoria1);
		manager.persist(categoria2);
		
		manager.persist(movimentacao1);
		manager.persist(movimentacao2);
		
		manager.getTransaction().commit();
		manager.close();
		
	}
	
}
