package springmvc_foodorder.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvc_foodorder.dto.Menu;

@Repository
public class MenuDao {
	@Autowired
	private EntityManager entityManager;

	public Menu saveMenu(Menu menu) {
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(menu);
		transaction.commit();
		return menu;
	}
	
	public List<Menu> getAllMenu(){
		Query query=entityManager.createQuery("select menu from Menu menu ");
		List<Menu> list=query.getResultList();
		return list;
	}
	
	public Menu deleteMenu(int id) {
		EntityTransaction  entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		Menu menu=entityManager.find(Menu.class, id);
		entityManager.remove(menu);
		entityTransaction.commit();
		return menu;
	}
	public Menu getMenuById(int id) {
		return entityManager.find(Menu.class, id);
	}

	public Menu updateMenu(Menu menu) {
		
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(menu);
		transaction.commit();
		return menu;
		// TODO Auto-generated method stub
		
	}
	
	
}
