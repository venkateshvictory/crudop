package com.trainee.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIES")
public class Movies {
	@Id
	@GeneratedValue

	@Column(name = "ID")
	private Long id;
	@Column(name = "TCONST")
	private String tconst;
	@Column(name = "TITELE_TYPE")
	private String titleType;
	@Column(name = "PRIMARY_TITLE")
	private String primaryTitle;
	@Column(name = "RUN_TIME_MINUTES")

	private String runtimeMinutes;
	@Column(name = "GENRES")
	private String genres;

	public String getTconst() {
		return tconst;
	}

	public void setTconst(String tconst) {
		this.tconst = tconst;
	}

	public String getTitleType() {
		return titleType;
	}

	public void setTitleType(String titleType) {
		this.titleType = titleType;
	}

	public String getPrimaryTitle() {
		return primaryTitle;
	}

	public void setPrimaryTitle(String primaryTitle) {
		this.primaryTitle = primaryTitle;
	}

	public String getRuntimeMinutes() {
		return runtimeMinutes;
	}

	public void setRuntimeMinutes(String runtimeMinutes) {
		this.runtimeMinutes = runtimeMinutes;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Movies [id=" + id + ", tconst=" + tconst + ", titleType=" + titleType + ", primaryTitle=" + primaryTitle
				+ ", runtimeMinutes=" + runtimeMinutes + ", genres=" + genres + "]";
	}
	

}
