package com.example.demo.domain.pieces;

public class AirConditioner {

	private Long id;
	private Integer numAirVents;
	private Boolean on = false;
	
	public AirConditioner(Long id, Integer numAirVents) {
		this.id = id;
		this.numAirVents = numAirVents;
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
	public Integer getNumAirVents() {
		return numAirVents;
	}
	public void setNumAirVents(Integer numAirVents) {
		this.numAirVents = numAirVents;
	}
	public Boolean getOn() {
		return on;
	}
	public void setOn(Boolean on) {
		this.on = on;
	}

	@Override
	public String toString() {
		return "AirConditioner [id=" + id + ", numAirVents=" + numAirVents + ", on=" + on + "]";
	}
	
}
