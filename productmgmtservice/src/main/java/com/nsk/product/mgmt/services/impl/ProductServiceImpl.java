package com.nsk.product.mgmt.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nsk.product.mgmt.domain.Product;
import com.nsk.product.mgmt.dto.CouponDto;
import com.nsk.product.mgmt.dto.ProductDto;
import com.nsk.product.mgmt.repos.ProductRepository;
import com.nsk.product.mgmt.services.ProductServices;

@Service
public class ProductServiceImpl implements ProductServices {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	RestTemplate restTemplate;

	public static final String COUPONCODEURL = "http://localhost:2000/NSK/coupon-api/coupons/";

	@Override
	public ProductDto insertProductInfo(ProductDto productDto) {
		Product product = productRepository.save(ProductDto.convertDtoToProduct(productDto));
		return Product.convertToProductDto(product);

	}

	@Override
	public ProductDto retSpcProductInfo(String name) {
		ProductDto productDto = null;
		Optional<Product> product = productRepository.findByName(name);
		if (product.isPresent()) {
			productDto = Product.convertToProductDto(product.get());
		}
		return productDto;
	}

	@Override
	public List<ProductDto> retAll() {
		return productRepository.findAll().stream().map(product -> Product.convertToProductDto(product))
				.collect(Collectors.toList());
	}

	@Override
	public ProductDto discountForCoupon(ProductDto productDto) {

		ResponseEntity<CouponDto> dto = restTemplate.getForEntity(COUPONCODEURL + productDto.getCode(),
				CouponDto.class);
		productDto.setPrice(productDto.getPrice().subtract(dto.getBody().getDiscount()));
		Product p = productRepository.save(ProductDto.convertDtoToProduct(productDto));
		return Product.convertToProductDto(p);
	}

}
