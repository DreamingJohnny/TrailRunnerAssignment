package com.trailrunnerassignment;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RunSessionTest {

	private RunSession runSession;

	private final float distance = 10;
	private final int time = 3600;
	private LocalDate date;
	private final String expectedTime = "1:00:00";

	@BeforeEach
	public void setup() {

		date = LocalDate.now();
		runSession = new RunSession(date, distance,time);
	}

	@Test
	public void hasCorrectInfo() {
		assertEquals(distance, runSession.getDistance());

		assertEquals(expectedTime, runSession.getTime());

		assertEquals(date, runSession.getDate());
	}

	@Test
	public void hasCorrectAverageSpeedPerHour() {
		double expectedValue = 10.0;
		assertEquals(expectedValue, runSession.getAverageSpeedPerHour());
	}

	@Test
	public void hasCorrectMinutesPerKilometer() {
		double expectedValue = 6.0;
		assertEquals(expectedValue, runSession.getMinutesPerKilometer());
	}

	@Test
	public void shouldSetTodaysDate() {
		runSession = new RunSession(distance,time);

		assertTrue(runSession != null);

		assertEquals(LocalDate.now(), runSession.getDate());
	}
}
