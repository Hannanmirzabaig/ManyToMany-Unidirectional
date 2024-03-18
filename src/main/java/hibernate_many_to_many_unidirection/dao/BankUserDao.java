package hibernate_many_to_many_unidirection.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate_many_to_many_unidirection.dto.Bank;
import hibernate_many_to_many_unidirection.dto.User;

public class BankUserDao {
	
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Hannan");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	
	/**
	 * for case 1
	 * @param users
	 * @param banks
	 * @return
	 */
	public List<User> saveUserBankDao(List<User> users,List<Bank> banks){
		et.begin();
		for (Bank bank : banks) {
			em.persist(bank);
		}
		for(User user : users) {
			em.persist(user);
		}
		et.commit();
		return users;
	}
	
	/**
	 * for case 2
	 * @param userId
	 * @return
	 */
	public User getDisplayByUserIdDao(int userId) {
//		User user=em.find(User.class, userId);
//		if(user!=null) {
//			user.getBank();
//			return user;
//		}
//		return null;
		
		return em.find(User.class, userId);
	}
	
	
	public List<User> getDisplayAllDetailsDao(){
		String query="from User";
		List l= em.createQuery(query).getResultList();
		return l;
	}
	
	/**
	 * for case 4
	 * @param userId
	 * @param userName
	 * @return
	 */
	public User getUpdateUserNameByIdDao(int userId ,String userName) {
		User user=em.find(User.class,userId);
		if(user!=null) {
			et.begin();
			user.setUserName(userName);
			em.merge(user);
			et.commit();
			return user;
		}
		return null;
	}
	
	/**
	 * for case 5
	 * @param id
	 * @param name
	 * @param branchCode
	 * @return
	 */
	public Bank getUpdateBankNameAndBranchCodeByBankIdDao(int id,String name,String branchCode) {
		Bank bnk=em.find(Bank.class, id);
		if(bnk!=null) {
			bnk.setName(name);
			bnk.setBranchCode(id);
			et.begin();
			em.merge(bnk);
			et.commit();
			return bnk;
		}else {
			return null;
		}
	}
		
		/**
		 * for case 6
		 * first we have to null of connection 
		 */
	
	public  User AssociationNullByIdDao(int userId ,int bankId) {
		User user=em.find(User.class, userId);
		Bank bank=em.find(Bank.class, bankId);
		
		
		if(user!=null && bank!=null) {
			et.begin();
			user.getBank().remove(bankId);
			em.merge(user);
			et.commit();
			return user;
		}
		return user;
	}
	
	public  User AssociationByIdDao(int userId ,int bankId) {
		User user=em.find(User.class, userId);
		Bank bank=em.find(Bank.class, bankId);
		
		
		if(user!=null && bank!=null) {
			et.begin();
			user.getBank().add(bank);
			em.merge(bank);
			et.commit();
			return user;
		}
		return user;
	}
	
}







