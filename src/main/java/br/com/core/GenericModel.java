package br.com.core;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;



public class GenericModel<T> {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void create(T Entity) {
		getSession().persist(Entity);
		return;
	}

	public void delete(T Entity) {
		if (getSession().contains(Entity))
			getSession().delete(Entity);
		else
			getSession().delete(getSession().merge(Entity));
		return;
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll(Class<T> Entity) {
		return getSession().createQuery("from" + Entity.getName()).list();
	}

	public T getById(Class<T> Entity, int id) {
		return getSession().load(Entity, id);
	}

	public void update(T Entity) {
		getSession().merge(Entity);
		return;
	}
}
