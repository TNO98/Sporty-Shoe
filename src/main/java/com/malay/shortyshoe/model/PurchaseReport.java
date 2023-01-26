package com.malay.shortyshoe.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="purchase_report")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class PurchaseReport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "c_id",nullable = false)
	private User customer;
	
	@Column(name="shoes")
	private List<Shoe> shoe;

	public PurchaseReport(User customer, List<Shoe> shoe) {
		this.customer = customer;
		this.shoe = shoe;
	}
	
	
	
	
}
