package nl.workingspirit.ws_bootcampappbackend.domein;

import org.junit.Test;
import org.junit.Assert;

public class UserTest {
	
	@Test
	public void testGebruiker() {
	User sut = makeNewUser();
	Assert.assertEquals("testtest", sut.getPassword());
	}
	
	public User makeNewUser() {
	User user = new User();
	user.setLastName("testGebruiker");
	user.setFirstName("Testelien");
	user.setId(100);
	user.setEmailaddress("Testelien@testGebruiker.nl");
	user.setPassword("testtest");
	user.setRole(Role.STUDENT);
	return user;
}

}