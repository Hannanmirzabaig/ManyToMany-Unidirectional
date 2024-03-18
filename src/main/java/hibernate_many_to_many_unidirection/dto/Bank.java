package hibernate_many_to_many_unidirection.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bank {
	@Id
	private int id;
	private String name;
	private String addres;
	private String ifcsCode;
	private int branchCode;
	
	

}
