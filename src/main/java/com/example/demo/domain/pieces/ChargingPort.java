package com.example.demo.domain.pieces;

public class ChargingPort {

	private Long id;
	private Integer numPorts;
	private String timeCharge;
	
	public ChargingPort(Long id, Integer numPorts, String timeCharge) {
		this.id = id;
		this.numPorts = numPorts;
		this.timeCharge = timeCharge;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNumPorts() {
		return numPorts;
	}
	public void setNumPorts(Integer numPorts) {
		this.numPorts = numPorts;
	}
	public String getTimeCharge() {
		return timeCharge;
	}
	public void setTimeCharge(String timeCharge) {
		this.timeCharge = timeCharge;
	}

	@Override
	public String toString() {
		return "ChargingPort [id=" + id + ", numPorts=" + numPorts + ", timeCharge=" + timeCharge + "]";
	}
	
}
