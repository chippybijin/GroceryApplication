package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	Faker fake = new Faker();


	public String randomUserName() {
		return fake.name().username();
	}
	
	public String randomPassword() {
		return fake.internet().password();
	}
	
	public String randomFullName() {
		return fake.name().fullName();
	}
	
	public String randomEmail() {
		return fake.internet().emailAddress();
	}
	
	public String randomMobileNumber() {
		return fake.phoneNumber().cellPhone();
	}
}
