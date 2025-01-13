package com.trailrunnerassignment;

import java.util.Scanner;

public class TrailRunner {

	private Scanner myScanner;

	private UserInfo userInfo;

	public void Run() {

		myScanner = new Scanner(System.in);
		userInfo = createUser();

		displayMainMenu(userInfo);
	}

	private UserInfo createUser() {

		System.out.println("Whazzap! Hur lång är du?");
		int length = myScanner.nextInt();

		System.out.println("Whazzap! Hur mycket väger du?");
		int weight = myScanner.nextInt();

		System.out.println("Whazzap! Hur gammal är du?");
		int age = myScanner.nextInt();

		return new UserInfo(length, weight, age);
	}

	private void displayMainMenu(UserInfo userInfo) {
		while (true) {

			System.out.println("Vad vill du göra?");
			System.out.println("1. Dina stats?");
			System.out.println("2. Pilla på dina löprundor?");

			switch (myScanner.nextInt()) {
				case 1:
					showStatsMenu(userInfo);
					break;
				case 2:
					showRunSessions(userInfo);
					break;
				default:
					System.out.println("Jag förstod inte, välj igen!");
					break;
			}
		}
	}

	private void showStatsMenu(UserInfo userInfo) {

		System.out.println("Ålder:   " + userInfo.getAge());
		System.out.println("Längd:   " + userInfo.getAge());

	}

	private void showRunSessions(UserInfo userInfo) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
