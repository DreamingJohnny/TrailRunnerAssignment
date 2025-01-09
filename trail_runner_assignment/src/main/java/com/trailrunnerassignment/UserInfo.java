package com.trailrunnerassignment;

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

	public UserInfo(float length, float weight, int age)
	{
		this.length=length;
		this.weight=weight;
		this.age=age;
		runList = new ArrayList<>();
	}

	public float getFitnessScore() {
		return 0;
	}

	public int getRunSessionsAmount()
	{
		return 0;
	}

	public int daysSinceLastRun()
	{
		return 0;
	}

	public void addRunSession(RunSession firstRun)
	{

	}

}
