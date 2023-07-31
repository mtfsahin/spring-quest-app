package com.example.Quest.App.Spring.request;

import lombok.Data;

@Data
public class PostUpdateRequest {
	String title;
	String text;
	
	//getter and setter values
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
