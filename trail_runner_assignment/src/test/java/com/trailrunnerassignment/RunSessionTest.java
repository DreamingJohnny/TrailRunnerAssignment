package com.trailrunnerassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RunSessionTest {

	private RunSession runSession;

	private float distance;
	private float time;
	private float date;

	@BeforeEach
	public void setup() {
		runSession = new RunSession(distance,time,date);
	}

	@Test
	public void hasCorrectInfo() {
		assertEquals(distance, runSession.getDistance());

		assertEquals(time, runSession.getTime());

		assertEquals(date, runSession.getDate());
	}

	@Test
	public void hasCorrectAverageSpeedPerHour() {
		int expectedValue = 10;
		assertEquals(expectedValue, runSession.getAverageSpeedPerHour());
	}

	@Test
	public void hasCorrectMinutesPerKilometer() {
		int expectedValue = 10;
		assertEquals(expectedValue, runSession.getMinutesPerKilometer());
	}

	@Test
	public void shouldSetTodaysDate() {
		runSession = new RunSession(distance,time);

		assertTrue(runSession!=null);

		assertEquals(todaysDate, runSession.getDate());
	}
}
