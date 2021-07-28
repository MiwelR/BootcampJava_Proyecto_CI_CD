package com.example.demo.domain.pieces;

public class GasolineTank {

	private Long id;
	private Integer liters;
	
	public GasolineTank(Long id, Integer liters) {
		this.id = id;
		this.liters = liters;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getLiters() {
		return liters;
	}
	public void setLiters(Integer liters) {
		this.liters = liters;
	}

	@Override
	public String toString() {
		return "GasolineTank [id=" + id + ", liters=" + liters + "]";
	}
	
}
