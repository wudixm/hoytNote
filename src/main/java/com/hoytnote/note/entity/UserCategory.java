package com.hoytnote.note.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_category")
public class UserCategory {

	@Id
	@Column(name="id")
	private Long id ;

	@Column(name="user_id")
	private Long userId ;

	@Column(name="name")
	private String name ;

	@Column(name="properties")
	private String properties ;

	@Column(name="created_at")
	private String createdAt ;

	@Column(name="updated_at")
	private String updatedAt ;

	public UserCategory(){
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

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getProperties(){
		return this.properties;
	}

	public void setProperties(String properties){
		this.properties = properties;
	}

	public String getCreatedAt(){
		return this.createdAt;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getUpdatedAt(){
		return this.updatedAt;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

}