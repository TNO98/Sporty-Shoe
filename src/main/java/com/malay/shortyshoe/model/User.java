package com.malay.shortyshoe.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;
	
	@Column(name ="name")
	private String name;
	
	@Column(name ="email")
	private String email;
	
	@Column(name ="password")
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private List<PurchaseReport> purchaseReport;

	public User(String name, String email, String password) {

		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	
	

}
