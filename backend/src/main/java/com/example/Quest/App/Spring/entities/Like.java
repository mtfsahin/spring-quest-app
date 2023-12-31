package com.example.Quest.App.Spring.entities;

import org.hibernate.annotations.OnDelete;

import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "p_like")
@Data

public class Like {
	
	@Id
	Long id;
	
	//I used "FetchType.LAZY" because I didn't want to relevant user object to come when i pulled the post
	@ManyToOne(fetch = FetchType.LAZY)
	//Actually here, it connects to then user table of the user_id in the like table,
	//"nullable = false" because i don't want it to be null object 
	@JoinColumn(name="post_id", nullable=false)
	//I used OnDelete because I want to delete relevant all user object
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	Post post;
	
	//I used "FetchType.LAZY" because I didn't want to relevant user object to come when i pulled the post
	@ManyToOne(fetch = FetchType.LAZY)
	//Actually here, it connects to then user table of the user_id in the like table, 
	//"nullable = false" because i don't want it to be null object 
	@JoinColumn(name="user_id", nullable=false)
	//I used OnDelete because I want to delete relevant all user object
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	User user;
	
	
}
