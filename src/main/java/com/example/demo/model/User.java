   	package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="user")
public class User {
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Id
	private Long id;
	
	@NotBlank
	private String Fullname;
	
	@NotBlank
	@javax.validation.constraints.Email
	private String email;
	
	@NotNull
	private Long phoneNumber;
	
	@NotBlank
    @Size(min = 4, max = 20)
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Only alphanumeric characters are allowed")
	private String Username;
	
	@NotBlank
	@Size(min = 8, max = 20)
	private String Password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> tasks;
	
    
    
	public User() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullname() {
		return Fullname;
	}

	public void setFullname(String fullname) {
		Fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public User(Long id, String fullname, String email, Long phoneNumber, String username, String password,List<Task> tasks) {
		super();
		this.id = id;
		Fullname = fullname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		Username = username;
		Password = password;
		this.tasks = tasks;
	}
	
	}
