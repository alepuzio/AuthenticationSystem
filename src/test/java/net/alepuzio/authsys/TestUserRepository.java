package net.alepuzio.authsys;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import net.alepuzio.authsys.domain.user.Generic;
import net.alepuzio.authsys.domain.user.UserRepository;
import net.alepuzio.authsys.domain.user.elementary.AnagraphicData;
import net.alepuzio.authsys.domain.user.elementary.SecurityData;
import net.alepuzio.authsys.domain.user.persistence.Persistent;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserRepository {

	@Autowired
	private UserRepository userRepository;

	@Before
	public void setUp() throws Exception {
		Generic user1 = new Generic(new AnagraphicData("User", "recorded", "PALSS"),
				new SecurityData("username", "password"));
		Persistent persistentUser = this.userRepository.save(user1);
		assertNotNull(persistentUser.getId());
	}
	
	@Test
	public void testSave() {
		assertTrue(true);
	}
}
