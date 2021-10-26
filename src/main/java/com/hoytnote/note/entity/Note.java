package com.hoytnote.note.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="note")
public class Note {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private Long id ;

	@Column(name="user_id")
	private Long userId ;

	@Column(name="category_id")
	private Long categoryId ;

	@Column(name="title")
	private String title ;

	@Column(name="content")
	private String content ;

	@Column(name="properties")
	private String properties ;

	@Column(name="created_at")
	@CreationTimestamp
	private LocalDateTime createdAt ;

	@Column(name="updated_at")
	@UpdateTimestamp
	private LocalDateTime updatedAt ;

	public Note(){
		super();
	}

	public Long getId(){
		return this.id;
	}

	public void setId(Long id){
		this.id = id;
	}

	public Long getUserId(){
		return this.userId;
	}

	public void setUserId(Long userId){
		this.userId = userId;
	}

	public Long getCategoryId(){
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId){
		this.categoryId = categoryId;
	}

	public String getTitle(){
		return this.title;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getContent(){
		return this.content;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getProperties(){
		return this.properties;
	}

	public void setProperties(String properties){
		this.properties = properties;
	}

	public LocalDateTime getCreatedAt(){
		return this.createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt){
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt(){
		return this.updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt){
		this.updatedAt = updatedAt;
	}

}