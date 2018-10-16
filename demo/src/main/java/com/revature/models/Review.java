package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="REVIEW")
public class Review implements Serializable{
	
	@Id
	@Column(name="REVIEW_ID")
	@SequenceGenerator(name = "INCREMENTOR", sequenceName="INCREMENTOR")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INCREMENTOR")
	private int review_id;
	
	@Column(name="CREATOR_ID")
	private int creator_id;
	
	@Column(name="MOVIE_ID")
	private int movie_id;
	
	@Column(name="REVIEW_TITLE")
	private String review_title;
	
	@Column(name="REVIEW_BODY")
	private String review_body;
	
	@ManyToOne
	@JoinColumn(name="CREATOR_ID", insertable= false, updatable= false)
	private Users user;
	
	@ManyToOne
	@JoinColumn(name="MOVIE_ID", insertable= false, updatable= false)
	private Movies movie;
	
	public Review () {}

	public Review(int review_id, int creator_id, int movie_id, String review_title, String review_body) {
		super();
		this.review_id = review_id;
		this.creator_id = creator_id;
		this.movie_id = movie_id;
		this.review_title = review_title;
		this.review_body = review_body;
	}

	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public int getCreator_id() {
		return creator_id;
	}

	public void setCreator_id(int creator_id) {
		this.creator_id = creator_id;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public String getReview_title() {
		return review_title;
	}

	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}

	public String getReview_body() {
		return review_body;
	}

	public void setReview_body(String review_body) {
		this.review_body = review_body;
	}

	@Override
	public String toString() {
		return "Review [review_id=" + review_id + ", creator_id=" + creator_id + ", movie_id=" + movie_id
				+ ", review_title=" + review_title + ", review_body=" + review_body + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + creator_id;
		result = prime * result + movie_id;
		result = prime * result + ((review_body == null) ? 0 : review_body.hashCode());
		result = prime * result + review_id;
		result = prime * result + ((review_title == null) ? 0 : review_title.hashCode());
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
		Review other = (Review) obj;
		if (creator_id != other.creator_id)
			return false;
		if (movie_id != other.movie_id)
			return false;
		if (review_body == null) {
			if (other.review_body != null)
				return false;
		} else if (!review_body.equals(other.review_body))
			return false;
		if (review_id != other.review_id)
			return false;
		if (review_title == null) {
			if (other.review_title != null)
				return false;
		} else if (!review_title.equals(other.review_title))
			return false;
		return true;
	}	

}