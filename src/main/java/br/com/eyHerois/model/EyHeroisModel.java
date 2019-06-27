package br.com.eyHerois.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import java.time.*;

@Table(name="Heroes")
@Entity
@SQLDelete(sql ="insert into INACTIVE_HEROES (nome, poder, universo)" + 
		"select nome, poder, universo from heroes where id = ?" + "delete")
public class EyHeroisModel {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	private String nome;
	
	private String poder;
	
	private String universo;
	
	private LocalDate dataCadastro;

	public Integer getIdHeroi() {
		return id;
	}

	public void setIdHeroi(Integer idHeroi) {
		this.id = idHeroi;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPoder() {
		return poder;
	}

	public void setPoder(String poder) {
		this.poder = poder;
	}

	public String getUniverso() {
		return universo;
	}

	public void setUniverso(String universo) {
		this.universo = universo;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}
