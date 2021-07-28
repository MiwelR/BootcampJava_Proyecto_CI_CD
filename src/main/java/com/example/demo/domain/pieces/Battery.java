package com.example.demo.domain.pieces;

public class Battery {

	private Long id;
	private String capacity;
	private Boolean on = false;
	
	public Battery(Long id, String capacity) {
		this.id = id;
		this.capacity = capacity;
	}
	
	public void start() {
		this.on = true;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public Boolean getOn() {
		return on;
	}
	public void setOn(Boolean on) {
		this.on = on;
	}

	@Override
	public String toString() {
		return "Battery [id=" + id + ", capacity=" + capacity + ", on=" + on + "]";
	}
	
}
