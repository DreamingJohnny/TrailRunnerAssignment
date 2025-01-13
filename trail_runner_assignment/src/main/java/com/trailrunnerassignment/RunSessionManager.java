package com.trailrunnerassignment;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class RunSessionManager {

	private final AtomicInteger idCounter = new AtomicInteger(1);
	private final HashMap<Integer, RunSession> runSessions = new HashMap<>();

	public int addRunSession(RunSession runSession) {
		int uniqueId = idCounter.getAndIncrement();
		runSession.setId(uniqueId);
		runSessions.put(uniqueId, runSession);

		return uniqueId;
	}

	// Vid korrekt id nummer, visa all info för löprundan.
	// sök runsession
	public RunSession getRunSession(int id) {
		return runSessions.get(id);
	}

	// Radera en löprunda via id nummer.
	public void deleteRunSession(int id) {
		runSessions.remove(id);
	}

	public boolean isHashMapEmpty() {
		return runSessions.isEmpty();
	}

	// Total distance för alla ens löprundor.
	public int daysSinceLastRun() {
		// If user doesn't have any runSessions saved, this function returns zero
		if (isHashMapEmpty()) {
			return 0;
		}

		// TODO: Look into moving this code to other function.
		LocalDate today = LocalDate.now();
		long smallestDifference = Long.MAX_VALUE;

		Set<Integer> keys = runSessions.keySet();

		for (Integer key : keys) {

			if (smallestDifference >= Math.abs(ChronoUnit.DAYS.between(runSessions.get(key).getDate(), today))) {
				smallestDifference = Math.abs(ChronoUnit.DAYS.between(runSessions.get(key).getDate(), today));
			}
		}

		// Possible loss in casting here, might want to make not of it for later.
		return Math.toIntExact(smallestDifference);
	}

	// returnerar senaste runsessionen
	public RunSession getLastestRunSession() {
		// If user doesn't have any runSessions saved, this function returns zero
		if (isHashMapEmpty()) {
			return null;
		}

		RunSession temp = null;
		// TODO: Look into moving this code to other function.
		LocalDate today = LocalDate.now();
		long smallestDifference = Long.MAX_VALUE;

		Set<Integer> keys = runSessions.keySet();

		for (Integer key : keys) {

			if (smallestDifference >= Math.abs(ChronoUnit.DAYS.between(runSessions.get(key).getDate(), today))) {
				smallestDifference = Math.abs(ChronoUnit.DAYS.between(runSessions.get(key).getDate(), today));
				temp = runSessions.get(key);
			}
		}

		return temp;
	}

	public Float getTotalDistanceRun() {
		if (isHashMapEmpty()) {
			return 0.00f;
		}

		float totalDistance = 0.00f;

		Set<Integer> keys = runSessions.keySet();

		for (Integer key : keys) {
			totalDistance += runSessions.get(key).getDistance();
		}

		return totalDistance;
	}

	// Medel distances för alla ens sparade löpturer.
	public Float getAverageDistanceOfRunSession() {
		if (isHashMapEmpty()) {
			return 0.00f;
		}

		return getTotalDistanceRun() / runSessions.size();
	}
	public int getNumberOfRuns()
	{
		return runSessions.size();
	}
	public Set<Integer> getSetOfIds()
	{
		if (isHashMapEmpty()) {
			return null;
		}
		return runSessions.keySet();
	}
}
