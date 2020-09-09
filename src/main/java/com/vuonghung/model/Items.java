package com.vuonghung.model;

public class Items {

	private String id;
	private String name;
	private String sup_id;
	private String sec_id;
	private float price;
	private String unit;
	private int status;
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
	public String getSup_id() {
		return sup_id;
	}
	public void setSup_id(String sup_id) {
		this.sup_id = sup_id;
	}
	public String getSec_id() {
		return sec_id;
	}
	public void setSec_id(String sec_id) {
		this.sec_id = sec_id;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Items(String id, String name, String sup_id, String sec_id, float price, String unit, int status) {
		super();
		this.id = id;
		this.name = name;
		this.sup_id = sup_id;
		this.sec_id = sec_id;
		this.price = price;
		this.unit = unit;
		this.status = status;
	}
	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*@Override
	public String toString() {
		return "Items [id=" + id + ", name=" + name + ",sup_id="+sup_id+",sec_id="+sec_id+",price="+price+",unit="+unit+", status=" + status + "]";
	}*/
}
