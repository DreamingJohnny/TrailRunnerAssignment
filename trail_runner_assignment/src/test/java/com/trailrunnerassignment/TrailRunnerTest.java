package com.trailrunnerassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TrailRunnerTest {
	/*
	 * Kunna fylla i user info och skapa upp en userInfo utifrån det.
	 * Se dina userInfo värden
	 * Se din fitnessScore
	 * Kunna lägga till runSessions
	 * Visa upp nytt fitnessScore varje gång du lägger till en run
	 * 
	 * Får användaren ett fitness score i slutet av varje avslutad löprunda?
	 * 
	 * 
	 * 
	 * 1 Skapa din användare.
	 * 
	 * 2.1 Hantera dina löprundor
	 * Radera en löprunda.
	 * Sök efter en löprunda via ID,
	 * Skapa en löprunda.
	 * Se alla dina löprundor
	 * 2.2 Se dina stats
	 * Visa ålder, vikt, längd.
	 * FitnessScore
	 * Totala distansen
	 * Snittdistansen
	 */

	private UserInfo userInfo;

	private int length = 180;
	private int weight = 85;
	private int age = 28;

	@BeforeEach
	public void setup() {
		userInfo = new UserInfo(length,weight,age);
	}

	@Test
	public void hasCorrectUserInfo() {
		assertEquals(length, userInfo.getLength());
	}

	@Test
	public void displayAllRunSessionStats() {

	}
}
