package com.nsk.product.mgmt.dto;

import java.math.BigDecimal;

import com.nsk.product.mgmt.domain.Product;

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
public class ProductDto {
	private long id;
	private String name;
	private BigDecimal price;
	private String description;
	private String code;

	public static Product convertDtoToProduct(ProductDto productDto) {
		return new Product(productDto.getId(), productDto.getName(), productDto.getPrice(), productDto.getDescription(),
				productDto.getCode());
	}

}
