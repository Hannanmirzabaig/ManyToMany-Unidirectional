package hibernate_many_to_many_unidirection.service;

import java.util.List;

import hibernate_many_to_many_unidirection.dao.BankUserDao;
import hibernate_many_to_many_unidirection.dto.Bank;
import hibernate_many_to_many_unidirection.dto.User;

public class BankUserService {
	
		BankUserDao bankUserDao=new BankUserDao();
	
	public List<User> saveUserBankService(List<User> users,List<Bank> banks){
		return bankUserDao.saveUserBankDao(users, banks);
	}
	
	public User getDisplayByUserIdService(int userId) {
		return bankUserDao.getDisplayByUserIdDao(userId);
	}
	
	public List<User> getDisplayAllDetailsService(){
		return bankUserDao.getDisplayAllDetailsDao();
	}
	
	public User getUpdateUserNameByIdService(int userId ,String userName) {
		return bankUserDao.getUpdateUserNameByIdDao(userId, userName);
	}
	
	public Bank getUpdateBankNameAndBranchCodeByBankIdService(int id,String name,String branchCode) {
		return bankUserDao.getUpdateBankNameAndBranchCodeByBankIdDao(id, name, branchCode);
	}
	
	public  User AssociationNullByIdService(int userId ,int bankId) {
		return bankUserDao.AssociationNullByIdDao(userId, bankId);
	}
	public  User AssociationByIdService(int userId,int bankId) {
		return bankUserDao.AssociationByIdDao(userId, bankId);
	}

}
