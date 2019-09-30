package com.example.demo.bean;

public class Cinema {
	
     private String cinemaId;//影院编号
     private String cineName;//影院名称
     private String location;//影院位置
     private String miniprice;//最低价格
     private String label;  //标签说明
     private String longitude;//精度
     private String latitude;//纬度
	
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
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	@Override
	public String toString() {
		return "Cinema [cinemaId=" + cinemaId + ", cineName=" + cineName + ", location=" + location + ", miniprice="
				+ miniprice + ", label=" + label + ", longitude=" + longitude + ", latitude=" + latitude + "]";
	}
     
     
}
