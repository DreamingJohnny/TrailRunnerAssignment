package com.trailrunnerassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RunSessionTest {

	private RunSession runSession;

	//TODO: These really needs to be remade to be in better formats.
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

		//TODO: Check so it has the correct userId here also.
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
