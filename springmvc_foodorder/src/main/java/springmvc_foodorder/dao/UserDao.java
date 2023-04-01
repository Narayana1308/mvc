package springmvc_foodorder.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvc_foodorder.dto.User;

@Repository
public class UserDao {
	@Autowired
	private EntityManager entityManager;

	public User saveUser(User user) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(user);
		transaction.commit();
		return user;
	}

	public User getUserByEmail(String email) {
		Query query = entityManager.createQuery("select user from User user where user.email=?1");
		query.setParameter(1, email);
		User user = (User) query.getSingleResult();
		return user;
	}

	public List<User> showManagers(String role) {
		Query query = entityManager.createQuery("select user from User user where user.role=?1");
		query.setParameter(1, role);
		List<User> list = query.getResultList();
		return list;
	}

	public User getUserByRole(String role) {
		Query query = entityManager.createQuery("select user from User user where user.role=?1");
		query.setParameter(1, role);
		User user = (User) query.getSingleResult();
		return user;
	}

	public User deleteUser(int id) {
		EntityTransaction entityTransaction=entityManager.getTransaction();

		User user=entityManager.find(User.class,id);
		entityTransaction.begin();
		entityManager.remove(user);
		entityTransaction.commit();
		return user;
		
	}

	public User getUserByID(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(User.class, id);
	}

	public User updateUser(User user) {
	    EntityTransaction entityTransaction=entityManager.getTransaction();
	    entityTransaction.begin();
	    entityManager.merge(user);
	    entityTransaction.commit();
	    return user;
		
	}
}
