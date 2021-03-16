package net.alepuzio.authsys;


//import org.junit.Ignore;

import org.junit.Test;

import net.alepuzio.authsys.domain.User;
import net.alepuzio.authsys.domain.data.AnagraphicData;
import net.alepuzio.authsys.domain.data.SecurityData;

import static org.junit.Assert.*;

public class TestSignUp {

	@Test
	public void testSignUpNullValues() {
		String name = null;
		String surname = null;
		String vatIn = null;// TODO codice fiscale in inglese
		String username = null;
		String password = null;
		User user = new User(new AnagraphicData(name, surname, vatIn), new SecurityData(username, password));
		assertFalse(user.readyToRecord());
	}
	@Test
	public void testSignUpEmptyValues() {
		String name = "    ";
		String surname = "    ";
		String vatIn = "    ";// TODO codice fiscale in inglese
		String username = "    ";
		String password = "    ";
		User user = new User(new AnagraphicData(name, surname, vatIn), new SecurityData(username, password));
		try {
			assertTrue(user.readyToRecord());
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
		User user = new User(new AnagraphicData(name, surname, vatIn), new SecurityData(username, password));
		assertTrue(user.readyToRecord());
	}

	@Test
	public void testSignUpInvalidItalianVatIN() {
		String name = "alessandro";
		String surname = "puzielli";
		String vatIn = "PZLLSK00A00A000A";
		String username = "alex123";
		String password = "aruba123";
		User user = new User(new AnagraphicData(name, surname, vatIn), new SecurityData(username, password));
		assertFalse(user.readyToRecord());
	}

}
