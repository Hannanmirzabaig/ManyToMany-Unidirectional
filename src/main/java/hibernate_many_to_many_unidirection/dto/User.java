package hibernate_many_to_many_unidirection.dto;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

//@RequiredArgsConstructor agar ye lete h to no ar or all args constructor to delete kra pdega
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;
	private long userAccount;
	private long phone;
	private LocalDate userDob;
	@CreationTimestamp
	private LocalDate userCreationDate;

	@Transient
	private String userPassword;
	
	@ManyToMany
	private List<Bank> bank;

	public User(String userName, long userAccount, long phone, LocalDate userDob,
			String userPassword, List<Bank> bank) {
		super();
		this.userName = userName;
		this.userAccount = userAccount;
		this.phone = phone;
		this.userDob = userDob;
		this.userPassword = userPassword;
		this.bank = bank;
	}
	
	
	
	
}
// what is use of transient 
// data permanent save nahi hoga jis column k upar transient laga hoga take transisent javax.persistence
//or table me coulmn bhi create nh krega data base me but ham iin future me use krengai to islye hamne isey lye or transient krdya


