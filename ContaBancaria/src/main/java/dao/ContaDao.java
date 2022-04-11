package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import entidades.ContaBancaria;
import entidades.Pessoa;

public class ContaDao extends DAO {
	public void save (ContaBancaria conta) throws PersistenciaDacException{
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(conta);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar salvar a conta.", pe);
		} finally {
			em.close();
		}
	}
	
	public ContaBancaria getByID(int contaID) throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		ContaBancaria resultado = null;
		try {
			resultado = em.find(ContaBancaria.class, contaID);
			
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar recuperar o usuário com base no ID.", pe);
		} finally {
			em.close();
		}

		return resultado;
	}
	
	
	public void delete(ContaBancaria conta) throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			conta = em.find(ContaBancaria.class, conta.getId());
			em.remove(conta);
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
	
	public List<ContaBancaria> getAll() throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		List<ContaBancaria> resultado = null;
		try {
			TypedQuery<ContaBancaria> query = em.createQuery("SELECT u FROM Pessoa u", ContaBancaria.class);
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar recuperar todos os usuários.", pe);
		} finally {
			em.close();
		}
		return resultado;
	}
	
	public ContaBancaria update(ContaBancaria conta) throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		ContaBancaria resultado = conta;
		try {
			resultado = em.merge(conta);
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
