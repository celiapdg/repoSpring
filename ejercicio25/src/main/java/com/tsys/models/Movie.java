package com.tsys.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "movies")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Movie {
	@Id
	@Column(name = "movies_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private Integer year;
	private String imageUrl;
	private String certificate;
	private Integer runtime;
	private Float imdbRating;
	private String description;
	private Integer metascore;
	private Integer votes;
	private Integer gross;


	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "movies_directors",
			joinColumns = {@JoinColumn(name = "movies_id")},
			inverseJoinColumns = {@JoinColumn(name = "directors_id")}
			)
	private List<Director> directors;

	@ManyToMany
	@JoinTable(
			name = "movies_stars",
			joinColumns = {@JoinColumn(name = "movies_id")},
			inverseJoinColumns = {@JoinColumn(name = "stars_id")}
			)
	private List<Star> stars;
	
	@ManyToMany //(fetch = FetchType.EAGER)
	@JoinTable(
			name = "movies_genres",
			joinColumns = {@JoinColumn(name = "movies_id")},
			inverseJoinColumns = {@JoinColumn(name = "genres_id")}
			)
	private List<Genre> genres;
}


