package com.rodolfo.dsmeta.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_sales")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sale implements Serializable {

	private static final long serialVersionUID = 5970699043635972441L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "seller_name")
	private String sellerName;

	@Column(name = "visited")
	private Integer visited;

	@Column(name = "deals")
	private Integer deals;

	@Column(name = "amount")
	private Double amount;

	@Column(name = "date")
	private LocalDate date;
}