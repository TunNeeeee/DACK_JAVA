package com.dacs.HoiThaoHutech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class HoiThaoHutechApplication {

	public static void main(String[] args) {
		SpringApplication.run(HoiThaoHutechApplication.class, args);
		// Tạo một instance của PasswordEncoder
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		// Mật khẩu gốc
		String rawPassword = "Anh123";

		// Mã hóa mật khẩu
		String encodedPassword = passwordEncoder.encode(rawPassword);

		// In ra mật khẩu đã mã hóa
		System.out.println("Mật khẩu gốc: " + rawPassword);
		System.out.println("Mật khẩu đã mã hóa: " + encodedPassword);
	}

}
