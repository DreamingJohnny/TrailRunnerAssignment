package com.trailrunnerassignment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RunSessionTest {

	private RunSession runSession;

	// TODO: These really needs to be remade to be in better formats.
	private float distance = 10;
	private int time = 3600;
	private LocalDate date;
	private int id;
	private String todaysDate;
	private String expectedTime = "1:00:00";

	@BeforeEach
	public void setup() {

		date = LocalDate.now();
		runSession = new RunSession(date, distance, id, time);
	}

	@Test
	public void hasCorrectInfo() {
		assertEquals(distance, runSession.getDistance());

		assertEquals(expectedTime, runSession.getTime());

		assertEquals(date, runSession.getDate());

		// TODO: Check so it has the correct userId here also.
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
		runSession = new RunSession(distance, id, time);
		LocalDate tempDate = LocalDate.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		todaysDate = tempDate.format(myFormatObj);

		assertTrue(runSession != null);

		assertEquals(LocalDate.now(), runSession.getDate());
	}
}
