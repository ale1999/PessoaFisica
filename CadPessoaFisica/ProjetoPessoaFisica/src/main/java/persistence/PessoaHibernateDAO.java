package persistence;

import java.util.List;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

import model.PessoaFisica;

public class PessoaHibernateDAO<T> implements IDAO<T> {

	Logger logger = Logger.getLogger(PessoaHibernateDAO.class.getName());
	private Transaction currentTransaction;
	Session session;
	
	public PessoaHibernateDAO(Session session) {
		this.session = session;
	}
	
	public void persistir(T o){
		session.save(o);
	}
	
	public List<T> Listar() {
		CriteriaBuilder cB = null;
		CriteriaQuery<PessoaFisica> qry = cB.createQuery(PessoaFisica.class);
		qry.select(qry.from(PessoaFisica.class));
		Query<T> createdQuery = (Query<T>) this.session.createQuery(qry);
		return createdQuery.getResultList();
	}
	
	public void closeSession() {
		this.session.close();
	}
	
	public void beginTransaction() {
		this.currentTransaction = this.session.beginTransaction();
	}
	
	public void commit() {
		this.currentTransaction.commit();
	}
}
