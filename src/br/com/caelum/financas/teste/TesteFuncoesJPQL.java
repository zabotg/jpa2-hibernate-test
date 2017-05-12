 package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteFuncoesJPQL { 	
	
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		
		String jpql = "select distinct avg(m.valor) from Movimentacao m where m.conta.id = conta" +
		" and m.tipo = :pTipo" +
		" group by m.data";
		
		TypedQuery<Double> query = manager.createQuery(jpql, Double.class);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Double> medias = query.getResultList();
		Double double1 = medias.get(0);
		
		for (Double media : medias) {
			System.out.println("A média é: " + media);
		}
		
		manager.getTransaction().commit();
		manager.close();
		
		
	}

}
