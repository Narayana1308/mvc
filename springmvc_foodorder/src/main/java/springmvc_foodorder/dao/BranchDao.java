package springmvc_foodorder.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvc_foodorder.dto.Branch;
import springmvc_foodorder.dto.User;

@Repository
public class BranchDao {
	@Autowired
	private EntityManager entityManager;
	@Autowired
	private UserDao userDao;

	public Branch saveBranch(Branch branch) {
		EntityTransaction transaction = entityManager.getTransaction();
		// User user=userDao.getUserByRole("Admin");
		transaction.begin();
		// branch.setUser(user);
		entityManager.persist(branch);
		transaction.commit();
		return branch;
	}

	public List<Branch> getAllBranchs() {
		Query query = entityManager.createQuery("select b from Branch b");
		List<Branch> list = query.getResultList();
		return list;
	}

	public Branch getById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Branch.class, id);
	}

	public Branch updateBranch(Branch branch) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(branch);
		transaction.commit();
		return branch;
	}

	public Branch deleteBranch(int id) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Branch branch = entityManager.find(Branch.class, id);
		entityManager.remove(branch);
		transaction.commit();
		return branch;

	}
}
