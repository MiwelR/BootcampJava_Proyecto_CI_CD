package com.example.demo.domain.pieces;

public class CarDoors {

	private Long id;
	private Integer doors;
	
	public CarDoors(Long id, Integer doors) {
		this.id = id;
		this.doors = doors;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getDoors() {
		return doors;
	}
	public void setDoors(Integer doors) {
		this.doors = doors;
	}

	@Override
	public String toString() {
		return "CarDoors [id=" + id + ", doors=" + doors + "]";
	}
	
}
