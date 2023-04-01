package springmvc_foodorder.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvc_foodorder.dto.FoodProduct;

@Repository
public class FoodProductDao {
	@Autowired
	private EntityManager entityManager;
	public FoodProduct saveFoodProduct(FoodProduct foodProduct) {
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(foodProduct);
		transaction.commit();
		return foodProduct;
	}
	public List<FoodProduct> getAllFoodProducts() {
		Query query=entityManager.createQuery("select food from FoodProduct food");
		List<FoodProduct> list=query.getResultList();
		return list;
	}
	public FoodProduct getById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(FoodProduct.class, id);
	}
	public FoodProduct updateFoodProduct(FoodProduct foodProduct) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(foodProduct);
		entityTransaction.commit();
		return foodProduct;
		
	}
	public FoodProduct deleteFood(int id) {
		// TODO Auto-generated method stub
	
		EntityTransaction entityTransaction=entityManager.getTransaction();
		FoodProduct foodProduct=entityManager.find(FoodProduct.class, id);
		entityTransaction.begin();
		entityManager.remove(foodProduct);
		entityTransaction.commit();
		return foodProduct;
	}

}
