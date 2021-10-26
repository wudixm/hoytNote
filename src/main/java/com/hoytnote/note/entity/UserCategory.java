package com.hoytnote.note.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="user_category")
public class UserCategory {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private Long id ;

	@Column(name="user_id")
	private Long userId ;

	@Column(name="name")
	private String name ;

	@Column(name="properties")
	private String properties ;

	@Column(name="created_at")
	@CreationTimestamp
	private LocalDateTime createdAt ;

	@Column(name="updated_at")
	@UpdateTimestamp
	private LocalDateTime updatedAt ;

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
//
//	@PrePersist
//	protected void onCreate() {
//		createdAt = new LocalDateTime();
//	}
//
//	@PreUpdate
//	protected void onUpdate() {
//		updatedAt = new Date();
//	}
//

}