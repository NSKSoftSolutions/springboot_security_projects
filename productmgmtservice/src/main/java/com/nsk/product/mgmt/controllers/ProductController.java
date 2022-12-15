package com.nsk.product.mgmt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.nsk.product.mgmt.dto.ProductDto;
import com.nsk.product.mgmt.services.ProductServices;

@RestController
@RequestMapping("/product-api")
public class ProductController {

	@Autowired
	ProductServices productServices;

	@PostMapping("/products")
	public ResponseEntity addProduct(@RequestBody ProductDto productDto) {
		ProductDto isSaved = productServices.insertProductInfo(productDto);
		if (isSaved != null) {
			return new ResponseEntity(isSaved, HttpStatus.OK);
		} else {
			return new ResponseEntity(InternalServerError.class, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/products/{name}")
	public ResponseEntity retProduct(@PathVariable String name) {
		ProductDto prodcutDto = productServices.retSpcProductInfo(name);
		if (prodcutDto != null) {
			return new ResponseEntity(prodcutDto, HttpStatus.OK);
		} else {
			return new ResponseEntity(InternalServerError.class, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/products")
	public ResponseEntity retAllProducts() {
		List<ProductDto> listOfProducts = productServices.retAll();
		if (listOfProducts != null) {
			return new ResponseEntity(listOfProducts, HttpStatus.OK);
		} else {
			return new ResponseEntity(InternalServerError.class, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/products/apply-discount")
	public ProductDto applyDiscount(@RequestBody ProductDto productDto) {

		ProductDto productdto = productServices.discountForCoupon(productDto);
		return productdto;
	}

}
