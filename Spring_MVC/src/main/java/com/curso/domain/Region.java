package com.curso.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="REGIONS")
@NamedQueries({
	@NamedQuery(name = "Region.findAll", 
				query = "SELECT r FROM Region r"),
})
public class Region {

	@Id
	@Column(name="REGION_ID")
	private int regionId;
	@Column(name="REGION_NAME")
	private String nombre;
	
	public Region() {
		
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Region [regionId=" + regionId + ", nombre=" + nombre + "]";
	}
	
	
	
}
