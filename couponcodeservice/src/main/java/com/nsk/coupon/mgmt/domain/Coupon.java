package com.nsk.coupon.mgmt.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.nsk.coupon.mgmt.dto.CouponDto;

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
public class Coupon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String code;
	private BigDecimal discount;
	private String expDate;

	public static CouponDto convertToCouponDto(Coupon coupon) {
		return new CouponDto(coupon.getId(), coupon.getCode(), coupon.getDiscount(), coupon.getExpDate());
	}

}
