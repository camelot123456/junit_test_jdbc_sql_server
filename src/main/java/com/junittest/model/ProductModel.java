package com.junittest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class ProductModel {

	private String id;
	private String name;
	private Integer quantity;
	private Double price;
	private CategoryModel category;
	
}
