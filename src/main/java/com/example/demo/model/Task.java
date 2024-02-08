package com.example.demo.model;


import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDate deadline; // Deadline of the task
    private String status; // Status of the task (completed, pending, working)

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Task() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Task(Long id, String title, String description, LocalDate deadline, String status, User user) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.deadline = deadline;
		this.status = status;
		this.user = user;
	}

    // Constructors, getters, and setters
    
    
}
