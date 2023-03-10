package com.stevedutch.assignment14.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.gson.annotations.SerializedName;

@Entity // Class name = User, DB Table name = user
@Table(name = "users")// changed into users
public class User {
	@SerializedName("username")
	@Column(unique=true)
	public String username;
	
	@SerializedName("userId")
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
	private Long userId;
	@JsonManagedReference
	@SerializedName("messages")
	@OneToMany(mappedBy = "user")
	private List<Message> messages = new ArrayList<>();
	
	
	
	/**
	 * @param username
	 * @param messages
	 */
	public User(String username, List<Message> messages) {
		super();
		this.username = username;
		this.messages = messages;
	}


	public User(String username) {
		super();
		this.username = username;
//		this.userId = getUserId();
	
	}

	
	public User() {
		// TODO Auto-generated constructor stub
		// XXX why it's better to write it out? Ullman wrote about it,I think
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", userId=" + userId + "messages: "+ messages +"]";
	}

}
