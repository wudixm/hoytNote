package com.hoytnote.note.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="note")
public class Note {

	@Id
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
	private Date createdAt ;

	@Column(name="updated_at")
	private Date updatedAt ;

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

	public Date getCreatedAt(){
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt){
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt(){
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt){
		this.updatedAt = updatedAt;
	}

}