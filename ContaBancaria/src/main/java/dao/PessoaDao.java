package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;


import entidades.Pessoa;

public class PessoaDao extends DAO{
	public void save (Pessoa pessoa) throws PersistenciaDacException{
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(pessoa);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar salvar o usuário.", pe);
		} finally {
			em.close();
		}
	}
	
	public Pessoa getByID(int userId) throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		Pessoa resultado = null;
		try {
			resultado = em.find(Pessoa.class, userId);
			//System.out.println("o nome é " + resultado.getNome());
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar recuperar o usuário com base no ID.", pe);
		} finally {
			em.close();
		}

		return resultado;
	}
	
	
	public void delete(Pessoa user) throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			user = em.find(Pessoa.class, user.getId());
			em.remove(user);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar remover o usuário.", pe);
		} finally {
			em.close();
		}
	}
	
	public List<Pessoa> getAll() throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		List<Pessoa> resultado = null;
		try {
			TypedQuery<Pessoa> query = em.createQuery("SELECT u FROM Pessoa u", Pessoa.class);
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar recuperar todos os usuários.", pe);
		} finally {
			em.close();
		}
		return resultado;
	}
	
	public Pessoa update(Pessoa user) throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Pessoa resultado = user;
		try {
			resultado = em.merge(user);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar atualizar o usuário.", pe);
		} finally {
			em.close();
		}
		return resultado;
	}
}
