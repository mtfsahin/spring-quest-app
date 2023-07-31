package com.example.Quest.App.Spring.entities;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "comment")
@Data


public class Comment {

	@Id
	Long id;
	 
	//I used "FetchType.LAZY" because I didn't want to relevant user object to come when i pulled the post
	@ManyToOne(fetch = FetchType.LAZY)
	//Actually here, it connects to then user table of the user_id in the comment table, nullable = false because i don't want it to be null object 
	@JoinColumn(name="post_id", nullable=false)
	//I used OnDelete because I want to delete relevant all user object
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	Post post;
	
	//I used "FetchType.LAZY" because I didn't want to relevant user object to come when i pulled the post
	@ManyToOne(fetch = FetchType.LAZY)
	//Actually here, it connects to then user table of the user_id in the comment table, nullable = false because i don't want it to be null object 
	@JoinColumn(name="user_id", nullable=false)
	//I used OnDelete because I want to delete relevant all user object
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	User user;
	
	@Lob
	@Column(columnDefinition="text")
	String text;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	
}
