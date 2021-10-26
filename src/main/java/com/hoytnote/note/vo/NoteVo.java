package com.hoytnote.note.vo;

import java.time.LocalDateTime;

public class NoteVo {

	private Long id ;

	private Long userId ;

	private Long categoryId ;

	private String title ;

	private String content ;

	private String properties ;

	private LocalDateTime createdAt ;

	private LocalDateTime updatedAt ;

	public NoteVo(){
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

	@Override
	public String toString() {
		return "NoteVo{" +
				"id=" + id +
				", userId=" + userId +
				", categoryId=" + categoryId +
				", title='" + title + '\'' +
				", content='" + content + '\'' +
				", properties='" + properties + '\'' +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				'}';
	}
}