package edu.DAOImpl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;

import edu.DAO.GenericDAO;

/**
 * @author xiyu
 *
 */
public abstract class GenericHibernateDAO<T, ID extends Serializable> implements GenericDAO<T, ID> {

	private Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public GenericHibernateDAO() {
		this.persistentClass = (Class<T>)
										 ( (ParameterizedType) getClass().getGenericSuperclass() )
										 .getActualTypeArguments()[0];
	}

	protected Session getSession() {
		return HibernateUtil.getSession();
	}
	
	private Class<T> getPersistentClass() {
		return persistentClass;
	}

	@SuppressWarnings("unchecked")
	public T findById(ID id, boolean lock) {
		T entity;
		if(lock) {
			entity = (T) getSession().get(getPersistentClass(), id, LockMode.UPGRADE);
		} else {
			entity = (T) getSession().get(getPersistentClass(), id);
		}
		return entity;
	}
	
	public List<T> findAll() {
		return findByCriteria();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findByExample(T exampleInstance, String... excludeProperty) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		Example example = Example.create(exampleInstance);
		for (String exclude : excludeProperty) {
			example.excludeProperty(exclude);
		}
		crit.add(example);
		return crit.list();
	}
	
	public void makePersistent(T entity) {
		getSession().saveOrUpdate(entity);
	}
	
	public void makeTransient(T entity) {
		getSession().delete(entity);
	}
	
	public void flush() {
		getSession().flush();
	}
	
	public void clear() {
		getSession().clear();
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Criterion... criterion) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		for (Criterion c : criterion) {
			crit.add(c);
		}
		return crit.list();
	}
}
