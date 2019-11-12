package com.mds.model;

import java.util.List;

public class User {

	private Integer id;
	private String name;
	private Long salary;

	private List<Dog> dogs;

	public List<Dog> getDogs() {
		return dogs;
	}

	public void setDogs(List<Dog> dogs) {
		this.dogs = dogs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Users [name=" + name + ", salary=" + salary + ", id=" + id + "]";
	}

}
