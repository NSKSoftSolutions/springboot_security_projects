package com.nsk.coupon.mgmt.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nsk.coupon.mgmt.domain.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {

	Optional<Coupon> findByCode(String code);

	Optional<Coupon> deleteByCode(String code);

}
