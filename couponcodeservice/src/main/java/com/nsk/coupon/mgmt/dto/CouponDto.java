package com.nsk.coupon.mgmt.dto;

import java.math.BigDecimal;

import com.nsk.coupon.mgmt.domain.Coupon;

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
public class CouponDto {

	private long id;
	private String code;
	private BigDecimal discount;
	private String expDate;

	public static Coupon convertDtoToCoupon(CouponDto coupon) {
		return new Coupon(coupon.getId(), coupon.getCode(), coupon.getDiscount(), coupon.getExpDate());
	}
}
