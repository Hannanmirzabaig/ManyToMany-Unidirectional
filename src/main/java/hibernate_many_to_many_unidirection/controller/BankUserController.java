package hibernate_many_to_many_unidirection.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate_many_to_many_unidirection.dto.Bank;
import hibernate_many_to_many_unidirection.dto.User;
import hibernate_many_to_many_unidirection.service.BankUserService;

public class BankUserController {
	public static void main(String[] args) {
		
		BankUserService bankUserService=new BankUserService();
		
		Scanner sc=new Scanner(System.in);
		
		
		while(true) {
			
			System.out.println("1-insert \n2-display all details user and bank by user id \n3-display all detail");
			System.out.println("4-update user name by id \n5-update bank name and branch code name");
			System.out.println("6-delete bank detail but first we have to null bank user association");
			System.out.println("7-association between user with car by primary key");
			
			int n=sc.nextInt();
			switch(n) {
			
			
			case 1:{
				
				Bank bank1=new Bank(231, "HDFC", "NOIDA", "hdfc567", 420);
				Bank bank2=new Bank(232, "SBI", "BANGLORE", "sbi5635", 9211);
				List<Bank> banks=Arrays.asList(bank1,bank2);
				
				
				User user1=new User("mirza", 2345656, 563457634,LocalDate.of(2032,03, 3),"123abc", banks);
				User user2=new User("hannan", 52653, 54743673, LocalDate.of(2025,02,8), "12fvv", banks);
				List<User> users=Arrays.asList(user1,user2);
				
				bankUserService.saveUserBankService(users, banks);
				
			}break;
			
			case 2:{
				System.out.println("enter the user id");
				int id=sc.nextInt();
				User c=bankUserService.getDisplayByUserIdService(id);
				if(c!=null) {
					System.out.println(c);
					List<Bank> bnk=c.getBank();
					if(!bnk.isEmpty()) {
						
						for (Bank bank : bnk) {
							System.out.println(bank);
						}
					}else {
						System.out.println("user have not bank");
					}
				}else {
					System.out.println("plz check code");
				}
				
			}break;
			
			case 3:{
				List<User> usr=bankUserService.getDisplayAllDetailsService();
				if(usr!=null) {
					
					for (User user : usr) {
						System.out.println(user);
						
						List<Bank> bnk=user.getBank();
						if(!bnk.isEmpty()) {
							
							for (Bank Bank2 : bnk) {
								
								System.out.println();
								
							}
						
						}
						
					}
					
				}else {
					System.out.println("no user available");
				}
				
				
			}break;
			case 4:{
				System.out.println("enter the user id");
				int id=sc.nextInt();
				System.out.println("enter the user new name");
				String name=sc.next();
				
				User user=bankUserService.getUpdateUserNameByIdService(id, name);
				if(user!=null) {
					System.out.println("successfully updated");
				}else {
					System.out.println("name does not updated");
				}
				
			}break;
			case 5:{
				System.out.println("enter the bank id");
				int id=sc.nextInt();
				System.out.println("enter the bank new name");
				String name=sc.next();
				System.out.println("enter the branch  new code  ");
				String code=sc.next();
				
				Bank bnk=bankUserService.getUpdateBankNameAndBranchCodeByBankIdService(id, name, code);
				if(bnk!=null) {
					System.out.println("successfully updated");
				}else {
					System.out.println("bank details does not updated");
				}
				
				
			}break;
			case 6:{
				
				System.out.println("enter the user id");
				int userId=sc.nextInt();
				System.out.println("enter the bank id");
				int bankId=sc.nextInt();
				
				User user=bankUserService.AssociationNullByIdService(userId, bankId);
				
				if(user!=null) {
					System.out.println("successfully deleted");
				}else {
					System.out.println("not deleted");
				}
				
				
			}break;
			
			case 7:{
				System.out.println("enter the user id");
				int userId=sc.nextInt();
				System.out.println("enter the bank id");
				int bankId=sc.nextInt();
				
				User user=bankUserService.AssociationByIdService(userId, bankId);
				if(user!=null) {
					System.out.println("successfully associated");
				}else {
					System.out.println("does not associateo7"
							);
				}
				
			}break;
//			case 8:{
//				EntityManagerFactory emf=Persistence.createEntityManagerFactory("Hannan");
//				EntityManager em=emf.createEntityManager();
//				EntityTransaction et=em.getTransaction();
//				et.begin();
//				
//				User user=em.find(User.class, 4);
//				Bank bank=em.find(Bank.class, 231);
//				user.getBank().remove(bank);
//				em.merge(user);
//				et.commit();	
//			}break;
			
			default:{
				System.out.println("plz valid option");
			}
			
			}
		}
		
	}
}


