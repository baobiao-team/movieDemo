package com.example.demo.bean;

public class Order {
	
	private String userId;
	
	private String orderId;
	
	private String cinemaId;
	
	private String cineName;
	
	private String location;
	
	private String movieId;
	
	private String movieName;
	
	private String showTime;
	
	private int pieces;
	
	private double totalPrice;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Order(String userId, String orderId, String cinemaId, String cineName, String location, String movieId,
			String movieName, String showTime, int pieces, double totalPrice) {
		super();
		this.userId = userId;
		this.orderId = orderId;
		this.cinemaId = cinemaId;
		this.cineName = cineName;
		this.location = location;
		this.movieId = movieId;
		this.movieName = movieName;
		this.showTime = showTime;
		this.pieces = pieces;
		this.totalPrice = totalPrice;
	}


	
	
	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

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

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public int getPieces() {
		return pieces;
	}

	public void setPieces(int pieces) {
		this.pieces = pieces;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}



	@Override
	public String toString() {
		return "Order [userId=" + userId + ", orderId=" + orderId + ", cinemaId=" + cinemaId + ", cineName=" + cineName
				+ ", location=" + location + ", movieId=" + movieId + ", movieName=" + movieName + ", showTime="
				+ showTime + ", pieces=" + pieces + ", totalPrice=" + totalPrice + "]";
	}

	
	
	
	
}
