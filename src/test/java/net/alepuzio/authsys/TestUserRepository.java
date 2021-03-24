package net.alepuzio.authsys;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.alepuzio.authsys.domain.user.Generic;
import net.alepuzio.authsys.domain.user.elementary.AnagraphicData;
import net.alepuzio.authsys.domain.user.elementary.SecurityData;
import net.alepuzio.authsys.domain.user.persistence.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserRepository {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void testSave() {
		Generic user = new Generic(new AnagraphicData("User", "recorded", "PALSS"),
				new SecurityData("username", "password"));
		try {
			Generic  persistentUser = this.userRepository.save(user);
			assertEquals(persistentUser.getAnagraphicData().getName(), user.getAnagraphicData().getName());
		} catch (Exception e) {
			assertFalse(true);
		}
	}
	

}
