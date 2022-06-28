package com.tsys.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "directors")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Director {
	@Id
	@Column(name = "directors_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;
	String about;
	
	@ManyToMany(mappedBy = "directors", fetch = FetchType.LAZY)
	@JsonIgnore
    private List<Movie> movies;
}