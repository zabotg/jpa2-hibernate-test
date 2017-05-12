 package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.dao.MoviementacaoDao;
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
		
		
		MoviementacaoDao dao = new MoviementacaoDao(manager);
		List<Double> medias = dao.getMediasPorDiaETipo(TipoMovimentacao.SAIDA, conta);
		
		
		for (Double media : medias) {
			System.out.println("A média é: " + media);
		}
		
		manager.getTransaction().commit();
		manager.close();
		
		
	}

}
