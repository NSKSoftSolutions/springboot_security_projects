package com.nsk.product.mgmt.services;

import java.util.List;

import com.nsk.product.mgmt.dto.ProductDto;

public interface ProductServices {

	ProductDto insertProductInfo(ProductDto product);

	ProductDto retSpcProductInfo(String name);

	List<ProductDto> retAll();

	ProductDto discountForCoupon(ProductDto productDto);

}
