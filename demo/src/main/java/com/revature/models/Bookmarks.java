package com.revature.models;

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
@Table(name="BOOKMARKS")
public class Bookmarks {
	
	@Id
	@Column(name="BOOKMARK_ID")
	@SequenceGenerator(name = "INCREMENTOR", sequenceName="INCREMENTOR")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INCREMENTOR")
	private int bookmarkId;
	
	@Column(name="MOVIE_ID")
	private int movieId;
	
	@Column(name="USER_ID")
	private int userId;
	
	@ManyToOne
	@JoinColumn(name="MOVIE_ID", insertable= false, updatable= false)
	private Movies movieBookmark;
	
	@ManyToOne
	@JoinColumn(name="USER_ID", insertable= false, updatable= false)
	private Users usersBookmark;

	public Bookmarks() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bookmarks(int bookmarkId, int movieId, int userId, Movies movieBookmark, Users usersBookmark) {
		super();
		this.bookmarkId = bookmarkId;
		this.movieId = movieId;
		this.userId = userId;
		this.movieBookmark = movieBookmark;
		this.usersBookmark = usersBookmark;
	}

	public int getBookmarkId() {
		return bookmarkId;
	}

	public void setBookmarkId(int bookmarkId) {
		this.bookmarkId = bookmarkId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Movies getMovieBookmark() {
		return movieBookmark;
	}

	public void setMovieBookmark(Movies movieBookmark) {
		this.movieBookmark = movieBookmark;
	}

	public Users getUsersBookmark() {
		return usersBookmark;
	}

	public void setUsersBookmark(Users usersBookmark) {
		this.usersBookmark = usersBookmark;
	}

	@Override
	public String toString() {
		return "Bookmarks [bookmarkId=" + bookmarkId + ", movieId=" + movieId + ", userId=" + userId
				+ ", movieBookmark=" + movieBookmark + ", usersBookmark=" + usersBookmark + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookmarkId;
		result = prime * result + ((movieBookmark == null) ? 0 : movieBookmark.hashCode());
		result = prime * result + movieId;
		result = prime * result + userId;
		result = prime * result + ((usersBookmark == null) ? 0 : usersBookmark.hashCode());
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
		Bookmarks other = (Bookmarks) obj;
		if (bookmarkId != other.bookmarkId)
			return false;
		if (movieBookmark == null) {
			if (other.movieBookmark != null)
				return false;
		} else if (!movieBookmark.equals(other.movieBookmark))
			return false;
		if (movieId != other.movieId)
			return false;
		if (userId != other.userId)
			return false;
		if (usersBookmark == null) {
			if (other.usersBookmark != null)
				return false;
		} else if (!usersBookmark.equals(other.usersBookmark))
			return false;
		return true;
	}

}
