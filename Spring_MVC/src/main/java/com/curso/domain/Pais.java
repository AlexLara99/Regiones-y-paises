package com.curso.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="COUNTRIES")
@NamedQueries({
	@NamedQuery(name = "Pais.findByRegion", 
		 		query = "SELECT p FROM Pais p  WHERE p.region.regionId = :idRegion")
})
public class Pais {

	@Id
	@Column(name="COUNTRY_ID")
	private String paisId;
	
	@Column(name="COUNTRY_NAME")
	private String nombre;
	/*
	@Column(name="REGION_ID")
	private int regionId; */
	
	
	@JoinColumn(name ="REGION_ID",
			referencedColumnName = "REGION_ID")
	@ManyToOne(optional = false)
	private Region region;
		
	public Pais() {
		
	}
	
	public String getPaisId() {
		return paisId;
	}

	public void setPaisId(String paisId) {
		this.paisId = paisId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
	
/*
	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	*/
}
