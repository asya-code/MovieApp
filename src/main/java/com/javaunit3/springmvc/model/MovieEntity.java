package com.javaunit3.springmvc.model;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="movies")

public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = " movie_id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name="maturity_rating")
    private String maturityRating;

    @Column(name="genre")
    private String genre;

    public String getMaturityRating() {
        return maturityRating;
    }

    public Integer getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setMaturityRating(String maturityRating) {
        this.maturityRating = maturityRating;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
