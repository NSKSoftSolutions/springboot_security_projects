package com.nsk.product.mgmt;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

@SpringBootTest
class ProductmgmtserviceApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("BcryptPassword for Name Sajjad=" + new BCryptPasswordEncoder().encode("sajjad"));
		System.out.println("Pbk2Password for Name Sajjd=" + new Pbkdf2PasswordEncoder().encode("sajjad"));
	}
}
