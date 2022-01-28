package com.ty.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Item_InvoiceDao {
	EntityManager entityManager = null;
	EntityTransaction entityTransaction = null;

	private EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OneToOne");
		entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void save(Invoice invoice, Item item) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(invoice);
		entityManager.persist(item);
		entityTransaction.commit();

	}

	public Invoice get(int id) {
		entityManager = getEntityManager();
		return entityManager.find(Invoice.class, id);
	}

	public void removeInvoice(int id) {
		entityManager = getEntityManager();
		Invoice invoice = entityManager.find(Invoice.class, id);
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		if (invoice != null) {
			entityManager.remove(invoice);
		}
		Item item = invoice.getItems();
		if (item != null) {
			entityManager.remove(item);
		}
		entityTransaction.commit();
	}

	public void updateInvoice(Invoice invoice) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(invoice);
	}
}
