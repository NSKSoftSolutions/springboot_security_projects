package com.nsk.product.mgmt.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.nsk.product.mgmt.dto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private BigDecimal price;
	private String description;
	@Transient
	private String code;

	public static ProductDto convertToProductDto(Product product) {
		return new ProductDto(product.getId(), product.getName(), product.getPrice(), product.getDescription(),
				product.getCode());
	}
}
