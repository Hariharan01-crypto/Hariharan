package com.example.Book_Store_Management.BookStoreEntity;


import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long UserId;
	
	@NotBlank(message = "Please fill UserName")
	private String UserName;
	
	@NotBlank(message = "Please fill UserPhoneNo")
	private String UserPhoneNo;
	
	@NotBlank(message = "Please fill UserEmail")
	private String UserEmail;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name ="UserId" )
	private List<BookEntity> book;
}
