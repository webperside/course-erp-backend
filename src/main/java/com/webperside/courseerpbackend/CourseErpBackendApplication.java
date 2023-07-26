package com.webperside.courseerpbackend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webperside.courseerpbackend.models.enums.user.UserStatus;
import com.webperside.courseerpbackend.models.mybatis.user.User;
import com.webperside.courseerpbackend.models.properties.security.SecurityProperties;
import com.webperside.courseerpbackend.repository.UserRepository;
import com.webperside.courseerpbackend.services.security.AccessTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

@SpringBootApplication
@RequiredArgsConstructor
public class CourseErpBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CourseErpBackendApplication.class, args);
	}

//	private final SecurityProperties securityProperties;

	private final AccessTokenManager accessTokenManager;

	@Override
	public void run(String... args) throws Exception {


//		User user = User.builder().email("email@email.com").build();
//		user.setId(1L);
//
//		final String token = accessTokenManager.generate(user);
//
//		System.out.println(token);
//
//		System.out.println(
//				accessTokenManager.read(token).get("email", String.class)
//		);
//

//		System.out.println(securityProperties);

//		KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("RSA");
//		keyGenerator.initialize(2048);
//		KeyPair kp = keyGenerator.genKeyPair();
//		PublicKey publicKey = kp.getPublic();
//		PrivateKey privateKey = kp.getPrivate();
//
//		String encodedPublicKey = Base64.getEncoder().encodeToString(publicKey.getEncoded());
//		String encodedPrivateKey = Base64.getEncoder().encodeToString(privateKey.getEncoded());
//
//		System.out.println(convertToPublicKey(encodedPublicKey));
//
//		System.out.println();
//
//		System.out.println(convertToPrivateKey(encodedPrivateKey));

	}

	private static String convertToPrivateKey(String key) {
		StringBuilder result = new StringBuilder();
		result.append("-----BEGIN PRIVATE KEY-----\n");
		result.append(key);
		result.append("\n-----END PRIVATE KEY-----");
		return result.toString();
	}

	private static String convertToPublicKey(String key) {
		StringBuilder result = new StringBuilder();
		result.append("-----BEGIN PUBLIC KEY-----\n");
		result.append(key);
		result.append("\n-----END PUBLIC KEY-----");
		return result.toString();
	}
}
