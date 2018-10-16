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
@Table(name="Comments")
public class Comments implements Serializable {
	
	@Id
	@Column(name="COMMENT_ID")
	@SequenceGenerator(name = "INCREMENTOR", sequenceName="INCREMENTOR")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INCREMENTOR")
	private int comment_id;
	
	@Column(name="CREATOR_ID")
	private int creator_id;
	
	@Column(name="REVIEW_ID")
	private int review_id;
	
	@Column(name="COMMENT_BODY")
	private String comment_body;
	
	@ManyToOne
	@JoinColumn(name="CREATOR_ID", insertable= false, updatable= false)
	private Users commentUser;
	
	@ManyToOne
	@JoinColumn(name="REVIEW_ID", insertable= false, updatable= false)
	private Review review;
	
	public Comments () {}

	public Comments(int comment_id, int creator_id, int review_id, String comment_body) {
		super();
		this.comment_id = comment_id;
		this.creator_id = creator_id;
		this.review_id = review_id;
		this.comment_body = comment_body;
	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public int getCreator_id() {
		return creator_id;
	}

	public void setCreator_id(int creator_id) {
		this.creator_id = creator_id;
	}

	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public String getComment_body() {
		return comment_body;
	}

	public void setComment_body(String comment_body) {
		this.comment_body = comment_body;
	}

	@Override
	public String toString() {
		return "Comments [comment_id=" + comment_id + ", creator_id=" + creator_id + ", review_id=" + review_id
				+ ", comment_body=" + comment_body + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment_body == null) ? 0 : comment_body.hashCode());
		result = prime * result + comment_id;
		result = prime * result + creator_id;
		result = prime * result + review_id;
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
		Comments other = (Comments) obj;
		if (comment_body == null) {
			if (other.comment_body != null)
				return false;
		} else if (!comment_body.equals(other.comment_body))
			return false;
		if (comment_id != other.comment_id)
			return false;
		if (creator_id != other.creator_id)
			return false;
		if (review_id != other.review_id)
			return false;
		return true;
	}
	

}