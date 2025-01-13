package com.trailrunnerassignment;

import java.time.Duration;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserInfoTest {

	// Standin values for testUserInfo
	public UserInfo userInfo;
	private float length;
	private float weight;
	private int age = 30;

	// Standin values for testRunSession
	public RunSession runSession;
	private float distance;
	private Duration time;
	private LocalDate date;
	private int id;

	private float expectedValue;
	private String expectedAnswer;

	/*
	 * Går det att skapa en användare med korrekt uppgifter?
	 */
	@BeforeEach
	public void setup() {
		userInfo = new UserInfo(length, weight, age);

		assertEquals(age, userInfo.getAge());
	}

	/* Innan första löprundan är fitness score noll? */
	@Test
	public void fitnessScoreZeroAtStart() {
		expectedAnswer = "0.00";

		assumeTrue(userInfo.getRunSessionsAmount() == 0,
				"Test cannot run if the user has one or more running sessions logged already.");

		assertEquals(expectedAnswer, userInfo.getFitnessScore());
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

		// TODO: Look @ moving these rounds to separate function or script, similar to
		// parameterized.
		userInfo.addRunSession(new RunSession(LocalDate.of(2024, 12, 28), 7,4500));
		userInfo.addRunSession(new RunSession(LocalDate.of(2025, 1, 1), 6,4400));
		userInfo.addRunSession(new RunSession(LocalDate.of(2025, 1, 3), 7,4700));
		userInfo.addRunSession(new RunSession(LocalDate.of(2025, 1, 6), 8,4500));

		// TODO: If time, would like to test this test several times to see if it really
		// works.
		assertEquals(expectedValue, userInfo.daysSinceLastRun());
	}

	/* Går det att få ut ett korrekt fitness score? */
	@Test
	public void getCorrectFitnessScore() {

		userInfo.addRunSession(new RunSession(LocalDate.of(2025, 1, 8), 10,3600));

		String expectedString = "9,67";

		assertEquals(expectedString, userInfo.getFitnessScore());
	}

	/* Kan fitness score vara lägre än noll? */
	@Test
	public void fitnessScoreNeverBelowZero() {
		expectedAnswer = "0";

		userInfo.addRunSession(new RunSession(LocalDate.of(2023, 1, 8), 10,3600));

		assertEquals(expectedAnswer, userInfo.getFitnessScore());
	}

	@Test
	public void shouldShowDaysSinceLatRun() {

		expectedValue = 5f;
		userInfo.addRunSession(new RunSession(LocalDate.of(2025, 1, 8), 10,3600));

		assertEquals(expectedValue, userInfo.daysSinceLastRun());
	}

	/* Totala distansen för ens sparade löprundor */
	@Test
	public void shouldShowTotalDistanceRun() {

		expectedValue = 20;

		userInfo.addRunSession(new RunSession(LocalDate.of(2025, 1, 8), 10,3600));
		userInfo.addRunSession(new RunSession(LocalDate.of(2025, 1, 6), 10,3600));

		assertEquals(expectedValue, userInfo.getTotalDistanceRun());
	}

	/* Medeldistansen för ens sparade löprundor */
	@Test
	public void shouldShowAverageDistanceOfRunSession() {
		expectedValue = 10f;

		userInfo.addRunSession(new RunSession(LocalDate.of(2025, 1, 3), 10,3600));
		userInfo.addRunSession(new RunSession(LocalDate.of(2025, 1, 5), 12,3600));
		userInfo.addRunSession(new RunSession(LocalDate.of(2025, 1, 8), 8,3600));

		assertEquals(expectedValue, userInfo.getAverageDistanceOfRunSession());
	}
}
