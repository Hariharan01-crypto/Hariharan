package com.example.restapi.ent;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="User_details")
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
    @NotBlank(message="name not supposed to be null")
	private String firstName;
	@Size(min=5,message="is required")
	private String lastName;
	private String email;
	
@OneToMany(targetEntity=WatchDetails.class,cascade=CascadeType.ALL)
@JoinColumn(name="user_id",referencedColumnName="id")
	public List<WatchDetails>  watchdetails;
	
	
	public List<WatchDetails> getWatchdetails() {
		return watchdetails;
	}

	public void setWatchdetails(List<WatchDetails> watchdetails) {
		this.watchdetails = watchdetails;
	}

	public UserDetails() {
		
	}
	
	public UserDetails(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	} 

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}
	

}
