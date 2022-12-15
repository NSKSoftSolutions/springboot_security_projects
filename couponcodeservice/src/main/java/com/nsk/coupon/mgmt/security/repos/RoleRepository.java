package com.nsk.coupon.mgmt.security.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nsk.coupon.mgmt.security.pojo.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
