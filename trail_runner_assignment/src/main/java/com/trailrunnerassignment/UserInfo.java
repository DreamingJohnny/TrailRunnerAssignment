package com.trailrunnerassignment;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class UserInfo {

	private float length;
	private float weight;
	private int age;
	private ArrayList<RunSession> runList = new ArrayList<>();

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public UserInfo(float length, float weight, int age) {
		this.length = length;
		this.weight = weight;
		this.age = age;
		runList = new ArrayList<>();
	}

	public float getFitnessScore() {

		// If the user haven't run anything yet, their fitnessScore should return as
		// zero.
		if (runList.isEmpty()) {
			return 0;
		}

		return 0;
	}

	public int getRunSessionsAmount() {
		return 0;
	}

	public int daysSinceLastRun() {

		// If user doesn't have any runSessions saved, this function returns zero
		if (runList.isEmpty()) {
			return 0;
		}

		// TODO: Look into moving this code to other function.
		LocalDate today = LocalDate.now();
		long smallestDifference = Long.MAX_VALUE;

		for (RunSession runSession : runList) {

			if (smallestDifference >= Math.abs(ChronoUnit.DAYS.between(runSession.getDate(), today))) {
				smallestDifference = Math.abs(ChronoUnit.DAYS.between(runSession.getDate(), today));
			}
		}

		// Possible loss in casting here, might want to make not of it for later.
		return Math.toIntExact(smallestDifference);
	}

	public void addRunSession(RunSession newRun) {
		runList.add(newRun);
	}

}
