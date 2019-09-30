package com.example.demo.bean;

public class CinemaList {
	 
	private String cinemaId;//影院编号
	private String cineName;//影院名称
	private String location;//影院位置
	private String miniprice;//最低价格
	private String label;  //标签说明
	
	public String getCinemaId() {
		return cinemaId;
	}
	public void setCinemaId(String cinemaId) {
		this.cinemaId = cinemaId;
	}
	public String getCineName() {
		return cineName;
	}
	public void setCineName(String cineName) {
		this.cineName = cineName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMiniprice() {
		return miniprice;
	}
	public void setMiniprice(String miniprice) {
		this.miniprice = miniprice;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	@Override
	public String toString() {
		return "CinemaList [cinemaId=" + cinemaId + ", cineName=" + cineName + ", location=" + location + ", miniprice="
				+ miniprice + ", label=" + label + "]";
	}
	
}
