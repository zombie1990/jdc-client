package com.jsu.DAO;

import java.io.Serializable;
import java.util.List;


/**
 * General for DAO interfaces.
 * @author Sherry
 * Notice: ID is a database-table identifier class, for example: your POJO id.
 */
public interface GeneralDAO<T, ID extends Serializable> {

	/**
	 * Find a Templet by id.
	 * @param id
	 * @param lock
	 */
	T findById(ID id, boolean lock);
	
	/**
	 * Find all Templets.
	 */
	List<T> findAll();
	
	/**
	 * Find Templets by Example exclude some properties.
	 * @param exampleInstance
	 * @param excludeProperty
	 */
	List<T> findByExample(T exampleInstance, String... excludeProperty);
	
	/**
	 * Make the entity persistent.
	 * @param entity
	 */
	T makePersistent(T entity);
	
	/**
	 * Make the entity transient.
	 * @param entity
	 */
	void makeTransient(T entity);
	
	/**
	 * Manage your persistence context.
	 */
	void flush();
	void clear();
	
}
