package com.trailrunnerassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RunSessionTest {

	private RunSession runSession;

	// TODO: These really needs to be remade to be in better formats.
	private float distance = 10;
	private int time = 3600;
	private String date;
	private String id;
	private float todaysDate;

	@BeforeEach
	public void setup() {
		runSession = new RunSession(date, distance, id, time);
	}

	@Test
	public void hasCorrectInfo() {
		assertEquals(distance, runSession.getDistance());

		assertEquals(time, runSession.getTime());

		assertEquals(date, runSession.getDate());

		// TODO: Check so it has the correct userId here also.
	}

	@Test
	public void hasCorrectAverageSpeedPerHour() {
		String expectedValue = "10.00";
		assertEquals(expectedValue, runSession.getAverageSpeedPerHour());
	}

	@Test
	public void hasCorrectMinutesPerKilometer() {
		String expectedValue = "6.00";
		assertEquals(expectedValue, runSession.getMinutesPerKilometer());
	}

	@Test
	public void shouldSetTodaysDate() {
		runSession = new RunSession(distance, id, time);

		assertTrue(runSession != null);

		assertEquals(todaysDate, runSession.getDate());
	}
}
