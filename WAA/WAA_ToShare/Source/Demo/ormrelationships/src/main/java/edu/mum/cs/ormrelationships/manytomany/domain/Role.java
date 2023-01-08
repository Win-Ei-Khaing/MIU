package edu.mum.cs.ormrelationships.manytomany.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "ROLE")
public class Role implements Serializable{

	private static final long serialVersionUID = 7359591984285268537L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RID")
	private long id;
	
	private String role;

	@ManyToMany
	@JoinTable
	private Set<User> users;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
