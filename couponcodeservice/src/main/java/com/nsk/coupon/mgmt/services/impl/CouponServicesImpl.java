package com.nsk.coupon.mgmt.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsk.coupon.mgmt.domain.Coupon;
import com.nsk.coupon.mgmt.dto.CouponDto;
import com.nsk.coupon.mgmt.repos.CouponRepository;
import com.nsk.coupon.mgmt.services.CouponServices;

@Service
public class CouponServicesImpl implements CouponServices {

	@Autowired
	CouponRepository couponRepository;

	@Override
	public CouponDto addCoupon(CouponDto coupon) {
		Coupon coupons = couponRepository.save(CouponDto.convertDtoToCoupon(coupon));
		return Coupon.convertToCouponDto(coupons);
	}

	@Override
	public CouponDto retCoupon(String code) {
		return couponRepository.findByCode(code).map(Coupon::convertToCouponDto).get();
	}

	@Override
	public List<Coupon> retAll() {
		return couponRepository.findAll();
	}

	@Override
	public String delCoupon(String code) {
		Optional<Coupon> isDeleted = couponRepository.findByCode(code);
		couponRepository.delete(isDeleted.get());
		return "deleted Successfully";
	}

}
