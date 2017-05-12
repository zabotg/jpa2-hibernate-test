package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class MoviementacaoDao {

	private EntityManager manager;
	
	public MoviementacaoDao(EntityManager manager) {
		super();
		this.manager = manager;
	}



	public List<Double> getMediasPorDiaETipo(TipoMovimentacao saida, Conta conta) {
		String jpql = "select distinct avg(m.valor) from Movimentacao m where m.conta.id = conta"
				+ " and m.tipo = :pTipo" + " group by m.data";

		TypedQuery<Double> query = manager.createQuery(jpql, Double.class);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);

		return query.getResultList();
	}

}
