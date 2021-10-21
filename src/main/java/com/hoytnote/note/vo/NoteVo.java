package com.hoytnote.note.vo;

import java.util.Date;

public class NoteVo {

	private Long id ;

	private Long userId ;

	private Long categoryId ;

	private String title ;

	private String content ;

	private String properties ;

	private Date createdAt ;

	private Date updatedAt ;

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