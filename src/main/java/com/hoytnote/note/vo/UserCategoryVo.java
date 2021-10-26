package com.hoytnote.note.vo;

import java.time.LocalDateTime;

public class UserCategoryVo {

	private Long id ;

	private Long userId ;

	private String name ;

	private String properties ;

	private LocalDateTime createdAt ;

	private LocalDateTime updatedAt ;

	public UserCategoryVo(){
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