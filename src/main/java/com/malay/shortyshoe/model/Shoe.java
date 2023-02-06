package com.malay.shortyshoe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "shoe")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shoe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "s_id")
	private int id;
	
	@Column(name = "s_name")
	private String name;
	
	@Column(name = "s_size")
	private int[] size;
	
	@Column(name = "s_price")
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "pr_id")
	private PurchaseReport pr;

	public Shoe(String name, int[] size, double price, Category category) {
		
		this.name = name;
		this.size = size;
		this.price = price;
		this.category = category;
	}
	
	

}
