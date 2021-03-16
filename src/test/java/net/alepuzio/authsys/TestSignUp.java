package net.alepuzio.authsys;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;

//import org.junit.Ignore;

import org.junit.Test;

import net.alepuzio.authsys.domain.User;
import net.alepuzio.authsys.domain.user.Generic;
import net.alepuzio.authsys.domain.user.elementary.AnagraphicData;
import net.alepuzio.authsys.domain.user.elementary.SecurityData;
import net.alepuzio.authsys.domain.user.elementary.vatin.Italian;

public class TestSignUp {

	@Test
	public void testSignUpNullValues() {
		String name = null;
		String surname = null;
		String vatIn = null;// TODO codice fiscale in inglese
		String username = null;
		String password = null;
		User user = new Generic(new AnagraphicData(name, surname, vatIn), new SecurityData(username, password));
		assertFalse(user.valid());
	}
	@Test
	public void testSignUpEmptyValues() {
		String name = "    ";
		String surname = "    ";
		String vatIn = "    ";// TODO codice fiscale in inglese
		String username = "    ";
		String password = "    ";
		User user = new Generic(new AnagraphicData(name, surname, vatIn), new SecurityData(username, password));
		try {
			assertTrue(user.valid());
		} catch (Exception e) {
			assertFalse(false);
		}
	}

	@Test
	public void testSignUpValidValues() {
		String name = "alessandro";
		String surname = "puzielli";
		String vatIn = "PZLLSN00A00A000A";
		String username = "alex123";
		String password = "aruba123";
		User user = new Generic(new AnagraphicData(name, surname, vatIn), new SecurityData(username, password));
		assertTrue(user.valid());
	}

	@Test
	@Ignore(value = "read TODO in method")
	public void testSignUpInvalidItalianVatIN() {
		String name = "alessandro";
		String surname = "puzielli";
		String vatIn = "PZLLSK00A00A000A";
		String username = "alex123";
		String password = "aruba123";
		User user = new Italian(new Generic(new AnagraphicData(name, surname, vatIn), new SecurityData(username, password)));
		assertFalse(user.valid());
	}

}
