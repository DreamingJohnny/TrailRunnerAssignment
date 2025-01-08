package com.trailrunnerassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserInfoTest {

	public UserInfo userInfo;

	private float length;
	private float weight;
	private float age;

	public RunSession runSession;

	private float distance;
	private float time;
	private float date;

	private float expectedValue;

	/*
	 * Går det att skapa en användare med korrekt uppgifter?
	 */
	@BeforeEach
	public void setup() {
		userInfo = new UserInfo(length, weight, age);

		assertTrue(userInfo != null);
	}

	/* Går det att få ut ett korrekt fitness score? */
	@Test
	public void getCorrectFitnessScore() {
		expectedValue = 10;

		assertEquals(expectedValue, userInfo.getFitnessScore());
	}

	/* Kan fitness score vara lägre än noll? */
	@Test
	public void fitnessScoreNeverBelowZero() {
		expectedValue = 0;

		assertEquals(expectedValue, userInfo.getFitnessScore());
	}

	/* Innan första löprundan är fitness score noll? */
	@Test
	public void fitnessScoreZeroAtStart() {
		expectedValue = 0;

		assumeTrue(userInfo.getRunSessionsAmount() == 0,
				"Test cannot run if the user has one or more running sessions logged already.");

		assertEquals(expectedValue, userInfo.getFitnessScore());
	}

	/* Innan första löprundan, är dagar sen senaste löpturen noll? */
	@Test
	public void daysSinceLastRunZeroAtStart() {
		expectedValue = 0;

		assumeTrue(userInfo.getRunSessionsAmount() == 0,
				"Test cannot run if the user has one or more running sessions logged already.");

		assertEquals(expectedValue, userInfo.daysSinceLastRun());
	}

	/* Är dagar sen senaste löpturen korrekt? */
	@Test
	public void setsDateSinceLastRunCorrectly() {

		expectedValue = 7;

		// So, here I'll want to begin by sending in a run with a date then, and then
		// check so that it sets it correctly then
		userInfo.addRunSession(new RunSession(distance, time, date));

		assertEquals(expectedValue, userInfo.daysSinceLastRun());
	}
}
