package com.nsk.coupon.mgmt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsk.coupon.mgmt.domain.Coupon;
import com.nsk.coupon.mgmt.dto.CouponDto;
import com.nsk.coupon.mgmt.services.CouponServices;

@RestController
@RequestMapping("/coupon-api")
public class CouponController {

	private static final String InternalServerError = "InternalServer Error";
	@Autowired
	CouponServices couponServices;

	@PostMapping("/coupons")
	public ResponseEntity addNewCoupon(@RequestBody CouponDto couponDto) {

		CouponDto coupons = couponServices.addCoupon(couponDto);
		if (coupons != null) {
			return new ResponseEntity<CouponDto>(coupons, HttpStatus.OK);
		} else {
			return new ResponseEntity(InternalServerError, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/coupons/{code}")
	public ResponseEntity addNewCoupon(@PathVariable String code) {

		CouponDto coupons = couponServices.retCoupon(code);
		if (coupons != null) {
			return new ResponseEntity<CouponDto>(coupons, HttpStatus.OK);
		} else {
			return new ResponseEntity(InternalServerError, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/coupons")
	public ResponseEntity retAllCoupons() {

		List<Coupon> listOfCouponse = couponServices.retAll();
		if (listOfCouponse != null) {
			return new ResponseEntity<List>(listOfCouponse, HttpStatus.OK);
		} else {
			return new ResponseEntity(InternalServerError, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/coupons/{code}")
	public ResponseEntity delSpecCoupon(@PathVariable String code) {

		String message = couponServices.delCoupon(code);
		if (message.equalsIgnoreCase("deleted Successfully")) {
			return new ResponseEntity<String>(code + "Coupon code deleted successfuly", HttpStatus.OK);
		} else {
			return new ResponseEntity(code, HttpStatus.OK);
		}

	}

}
