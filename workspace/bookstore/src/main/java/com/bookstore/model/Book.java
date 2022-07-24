package com.bookstore.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Book {
	
	@Id
	private Long id;
	private String name;
	private BigDecimal price;
	private Integer quantity;
	private String category;
	private String img;

}
