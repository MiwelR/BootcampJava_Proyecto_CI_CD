package com.example.demo.domain.pieces;

public class GasTank {

	private Long id;
	private Integer litersGas;
	
	public GasTank(Long id, Integer liters) {
		this.id = id;
		this.litersGas = liters;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getLitersGas() {
		return litersGas;
	}
	public void setLitersGas(Integer liters) {
		this.litersGas = liters;
	}

	@Override
	public String toString() {
		return "GasTank [id=" + id + ", liters=" + litersGas + "]";
	}
	
}
