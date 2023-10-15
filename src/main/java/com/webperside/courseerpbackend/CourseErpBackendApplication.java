package com.webperside.courseerpbackend;

import com.webperside.courseerpbackend.models.mybatis.country.Country;
import com.webperside.courseerpbackend.models.mybatis.user.User;
import com.webperside.courseerpbackend.services.country.CountryService;
import com.webperside.courseerpbackend.services.otp.OTPProceedTokenManager;
import com.webperside.courseerpbackend.services.security.AccessTokenManager;
import com.webperside.courseerpbackend.services.user.settings.UserSettingsBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class CourseErpBackendApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CourseErpBackendApplication.class, args);
    }

//	private final SecurityProperties securityProperties;

    private final UserSettingsBusinessService userSettingsBusinessService;
    private final AccessTokenManager accessTokenManager;
    private final CountryService countryService;

    private final OTPProceedTokenManager otpProceedTokenManager;
    @Override
    public void run(String... args) throws Exception {
        System.out.println(otpProceedTokenManager.generate(User.builder().id(1L).name("sdfsdf").build()));
//		User user = User.builder()
//				.name("Test")
//				.surname("test")
//				.password(passwordEncoder.encode("123123"))
//				.roleId(2L)
//				.phoneNumber("123123")
//				.status(UserStatus.ACTIVE)
//				.email("sultanzadeh@gmail.com")
//				.build();
//
//		userService.insert(user);

//		System.out.println(userService.getByEmail("sultanzadeh@gmail.com"));

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

        // Testing Country Services Methods (Insert, Update, FindById, FindAll)
//		testingCountryServices();

        userSettingsBusinessService.updateUserDefaultLanguage(1l,"ru");
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

    // I believe we will remove this method later or rename, edit and move to unit testing
    void testingCountryServices() {

        // ------------ INSERT -----------
        List<Country> countries = new ArrayList<Country>();
        countries.add(new Country("Azerbaijan"));
        countries.add(new Country("Turkey"));
        countries.add(new Country("Georgia"));
        countries.add(new Country("Russia"));
        countries.add(new Country("Iran"));
        countries.add(new Country("United States"));

        for (Country c : countries) {
            countryService.insert(c);
        }

        // --------- FIND ALL ----------


        for (Country c : countryService.findAll()) {
            System.out.println(c.getId() + " " + c.getName() + " - " + c.isDeleted());
        }

        // ------------ FIND by ID
        long id = 2;
        Country cntry = countryService.findById(id);
        System.out.println("-------- Before Update --------");
        System.out.println(cntry.getId() + " " + cntry.getName() + " - " + cntry.isDeleted());

        // ------------- UPDATE -----------

        cntry.setName("Testing update");
        cntry.setId(Long.valueOf(id));
        countryService.update(cntry);
        cntry = countryService.findById(id);
        System.out.println("-------- After Update --------");
        System.out.println(cntry.getId() + " " + cntry.getName() + " - " + cntry.isDeleted());

        // ------------ FIND by ID Exception not sure how to test

    }

}