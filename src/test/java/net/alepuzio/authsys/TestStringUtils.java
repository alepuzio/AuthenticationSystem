package net.alepuzio.authsys;

import static org.junit.Assert.*;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class TestStringUtils {

	
	@Test
	public void testEmptyIsNull(){
		String value = null;
		assertTrue(StringUtils.isEmpty(value));
	}
}
