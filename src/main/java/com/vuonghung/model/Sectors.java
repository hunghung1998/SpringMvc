package com.vuonghung.model;

public class Sectors {
	private String id;
	private String name;
	private String image;
	private String status;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Sectors(String id, String name, String image, String status) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.status = status;	
	}
	public Sectors() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Sectors [id=" + id + ", name=" + name + ",image="+ image +", status=" + status + "]";
	}
}
