package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoPorCategoria {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Categoria categoria = new Categoria();
		categoria.setId(1);
		
		
		String jpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria";
		
		Query query = manager.createQuery(jpql);
		query.setParameter("pCategoria", categoria);
		
		List<Movimentacao> resultados = query.getResultList();
		
		for (Movimentacao movimentacao : resultados) {
			System.out.println("Descricao: " + movimentacao.getDescricao());
			System.out.println("Descricao: " + movimentacao.getConta().getId());
		}
		
		manager.getTransaction().commit();
		manager.close();
		
		
	}
}
