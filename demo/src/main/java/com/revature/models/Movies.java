package com.revature.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="MOVIES")
public class Movies implements Serializable {
	
	@Id
	@Column(name="MOVIE_ID")
	@SequenceGenerator(name = "INCREMENTOR", sequenceName="INCREMENTOR")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INCREMENTOR")
	private int movieId;
	
	@Column(name="MOVIE_TITLE")
	private String movieTitle;
	
	@Column(name="SYNOPSIS")
	private String synopsis;
	
	@Column(name="MOVIE_IMAGE")
	private String movieImage;

	@OneToMany(mappedBy="movie", fetch=FetchType.EAGER)
	private Set<Review> reviews = new HashSet<>();

	@OneToMany(mappedBy="movieBookmark", fetch=FetchType.LAZY)
	private Set<Bookmarks> bookmarks = new HashSet<>();

	public Movies() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movies(int movieId, String movieTitle, String synopsis, String movieImage, Set<Review> reviews,
			Set<Bookmarks> bookmarks) {
		super();
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.synopsis = synopsis;
		this.movieImage = movieImage;
		this.reviews = reviews;
		this.bookmarks = bookmarks;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getMovieImage() {
		return movieImage;
	}

	public void setMovieImage(String movieImage) {
		this.movieImage = movieImage;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	public Set<Bookmarks> getBookmarks() {
		return bookmarks;
	}

	public void setBookmarks(Set<Bookmarks> bookmarks) {
		this.bookmarks = bookmarks;
	}

	@Override
	public String toString() {
		return "Movies [movieId=" + movieId + ", movieTitle=" + movieTitle + ", synopsis=" + synopsis + ", movieImage="
				+ movieImage + ", reviews=" + reviews + ", bookmarks=" + bookmarks + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookmarks == null) ? 0 : bookmarks.hashCode());
		result = prime * result + movieId;
		result = prime * result + ((movieImage == null) ? 0 : movieImage.hashCode());
		result = prime * result + ((movieTitle == null) ? 0 : movieTitle.hashCode());
		result = prime * result + ((reviews == null) ? 0 : reviews.hashCode());
		result = prime * result + ((synopsis == null) ? 0 : synopsis.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movies other = (Movies) obj;
		if (bookmarks == null) {
			if (other.bookmarks != null)
				return false;
		} else if (!bookmarks.equals(other.bookmarks))
			return false;
		if (movieId != other.movieId)
			return false;
		if (movieImage == null) {
			if (other.movieImage != null)
				return false;
		} else if (!movieImage.equals(other.movieImage))
			return false;
		if (movieTitle == null) {
			if (other.movieTitle != null)
				return false;
		} else if (!movieTitle.equals(other.movieTitle))
			return false;
		if (reviews == null) {
			if (other.reviews != null)
				return false;
		} else if (!reviews.equals(other.reviews))
			return false;
		if (synopsis == null) {
			if (other.synopsis != null)
				return false;
		} else if (!synopsis.equals(other.synopsis))
			return false;
		return true;
	}

}
