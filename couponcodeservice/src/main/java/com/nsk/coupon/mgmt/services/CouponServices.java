package com.nsk.coupon.mgmt.services;

import java.util.List;

import com.nsk.coupon.mgmt.domain.Coupon;
import com.nsk.coupon.mgmt.dto.CouponDto;

public interface CouponServices {

	public CouponDto addCoupon(CouponDto couponDto);

	public CouponDto retCoupon(String code);

	public List<Coupon> retAll();

	public String delCoupon(String code);

}
