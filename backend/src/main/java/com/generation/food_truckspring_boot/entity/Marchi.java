package com.generation.food_truckspring_boot.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "marchi")
public class Marchi {

	/**
	 * 
	 */
	public Marchi() {
	}
	/**
	 * @param id
	 * @param nome
	 * @param descrizione
	 * @param genere
	 * @param logo
	 */
	public Marchi(long id, String nome, String descrizione, Genere genere, String logo) {
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.genere = genere;
		this.logo = logo;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String descrizione;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Genere genere;
	@Column(nullable = false)
	private String logo;
	
	@Column()
	private String video;
	
	//ONE TO MANY A FOODTRUCKS
	@OneToMany(mappedBy = "marchi")
	
	private List<Foodtrucks> foodtrucks;
	
	//ONE TO MANY A PIATTI
	@OneToMany(mappedBy = "marchi")
	@JsonIgnore
	private List<Piatti> piatti;
	
	public List<Piatti> getPiatti() {
		return piatti;
	}
	public void setPiatti(List<Piatti> piatti) {
		this.piatti = piatti;
	}
	public List<Foodtrucks> getFoodtrucks() {
		return foodtrucks;
	}
	public void setFoodtrucks(List<Foodtrucks> foodtrucks) {
		this.foodtrucks = foodtrucks;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Genere getGenere() {
		return genere;
	}
	public void setGenere(Genere genere) {
		this.genere = genere;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	
	
	
}
