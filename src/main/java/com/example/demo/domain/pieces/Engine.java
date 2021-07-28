package com.example.demo.domain.pieces;

public class Engine {

	private Long id;
	private Double cc;
	private Double cv;
	private Boolean on = false;
	
	public Engine(Long id, Double cc, Double cv) {
		this.id = id;
		this.cc = cc;
		this.cv = cv;
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
	public Double getCc() {
		return cc;
	}
	public void setCc(Double cc) {
		this.cc = cc;
	}
	public Double getCv() {
		return cv;
	}
	public void setCv(Double cv) {
		this.cv = cv;
	}
	public Boolean getOn() {
		return on;
	}
	public void setOn(Boolean on) {
		this.on = on;
	}

	@Override
	public String toString() {
		return "Engine [id=" + id + ", cc=" + cc + ", cv=" + cv + ", on=" + on + "]";
	}
	
}
