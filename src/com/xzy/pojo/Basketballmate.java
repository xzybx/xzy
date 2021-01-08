package com.xzy.pojo;

public class Basketballmate {

	private String name;
	private int age;
	private int score;
	private int id;
	private String position;
	public Basketballmate() {}
	
	public Basketballmate(String name, int age, int score, int id, String position) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
		this.id = id;
		this.position = position;
	}

	@Override
	public String toString() {
		return "Basketballmate [name=" + name + ", age=" + age + ", score=" + score + ", id=" + id + ", position="
				+ position + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
}
