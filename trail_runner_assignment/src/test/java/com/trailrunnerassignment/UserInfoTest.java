package com.trailrunnerassignment;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserInfoTest {

	/*
	 * Går det att skapa en användare?
	 * Har den ett fitness score?
	 * Har den dagar sen senaste löpturen?
	 * Kan fitness score vara lägre än noll?
	 * Innan första löprundan är fitness score noll?
	 * Innan första löprundan, är dagar sen senaste löpturen noll?
	 */

	public UserInfo userInfo;

	@BeforeEach
	public void setup() {
		userInfo = new UserInfo();
	}

	@Test
	public void canCreateUserInfo() {
		userInfo = null;

		assertTrue(userInfo != null);
	}

	@Test
	public void canGetFitnessScore() {
		assertTrue(userInfo.getFitnessScore() != -1);
	}

}
