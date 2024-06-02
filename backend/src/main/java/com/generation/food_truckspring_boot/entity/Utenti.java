package com.generation.food_truckspring_boot.entity;


import java.time.LocalDate;
import java.util.List;

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
@Table(name = "utenti")
public class Utenti {

	/**
	 * @param id
	 * @param nome
	 * @param cognome
	 * @param data_nascita
	 * @param email
	 * @param password
	 * @param ruolo
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String nome;
	@Column(nullable = true)
	private String cognome;
	@Column(nullable = false)
	private LocalDate data_nascita;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Ruolo ruolo;
	
	
	@OneToMany(mappedBy = "utenti")
	private List<Ordini> ordini;
	
	
	public Utenti() {}
	
	public Utenti(long id, String nome, String cognome, LocalDate data_nascita, String email, String password,
			Ruolo ruolo) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.data_nascita = data_nascita;
		this.email = email;
		this.password = password;
		this.ruolo = ruolo;
	}

	

	public Utenti(String nome, String cognome, LocalDate data_nascita, String email, String password, Ruolo ruolo) {
		this.nome = nome;
		this.cognome = cognome;
		this.data_nascita = data_nascita;
		this.email = email;
		this.password = password;
		this.ruolo = ruolo;
		
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getData_nascita() {
		return data_nascita;
	}

	public void setData_nascita(LocalDate data_nascita) {
		this.data_nascita = data_nascita;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

	public List<Ordini> getOrdini() {
		return ordini;
	}

	public void setOrdini(List<Ordini> ordini) {
		this.ordini = ordini;
	}
	
	
	
	
	
	
	
}

