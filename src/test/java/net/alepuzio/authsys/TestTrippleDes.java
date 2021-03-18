package net.alepuzio.authsys;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import net.alepuzio.authsys.crypto.TrippleDes;

public class TestTrippleDes {

	@Test
	public void testDecrypt() {
		try {
			String result = new TrippleDes().decrypt("FdBNaYWfjpWN9eYghMpbRA==");
			String expected = "imparator";
			assertEquals(expected, result);
		} catch (Exception e) {
			assertFalse(true);
		}
	}
	@Test
	public void testEncrypt() {
		try {
			String result = new TrippleDes().encrypt("imparator");
			String expected = "FdBNaYWfjpWN9eYghMpbRA==";
			assertEquals(expected, result);
		} catch (Exception e) {
			assertFalse(true);
		}
	}
/**
 * String To Encrypt: imparator
Encrypted String:FdBNaYWfjpWN9eYghMpbRA==
Decrypted String:imparator
 * */

}