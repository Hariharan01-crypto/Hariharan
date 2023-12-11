package com.example.Book_Store_Management.BookStoreEntity;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class BookEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long BookId;
	
	@NotBlank(message = "Please fill BookName")
	private String BookName;
	
	
	@NotBlank(message = "Please fill BookGenre")
	private String BookGenre;
	
	
	@NotBlank(message = "Please fill BookCost")
	private String BookCost;
	
	/*
	 * @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name = "UserId") private UserEntity user;
	 */
}
