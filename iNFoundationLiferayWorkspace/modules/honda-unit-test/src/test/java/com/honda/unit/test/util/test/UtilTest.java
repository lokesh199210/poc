package com.honda.unit.test.util.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UtilTest {

	@Before
	public void setUp() {
		this.userId = 10101;
	}
	
	@Test
	public void addUser() {
		Assert.assertEquals(10101, this.userId);
	}
	
	@After
	public void cleanUp() {
		this.userId = 0;
	}
	private long userId;
}
