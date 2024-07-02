package exam3;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="JpaMember3")
@NoArgsConstructor
@AllArgsConstructor
public class Member3 {
	
	@Id
	private String email;
	
	private String name;
	
	@Column(name="create_date")
	private LocalDate createDate;
	
	public String getEmail() {
		return email;
	}
	
	public String getName() {
		return name;
	}
	
	public LocalDate getCreateDate() {
		return createDate;
	}
	
	public void changeName(String newName) {
		this.name = newName;
	}
}
