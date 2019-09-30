package com.example.demo.bean;

public class MovieList {
	
	private String movieId;  //电影Id
	private String movieName; //电影名称
	private String movieScore; //电影评分
	private String movieImg;  //电影图片链接
	
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
	public String getMovieScore() {
		return movieScore;
	}
	public void setMovieScore(String movieScore) {
		this.movieScore = movieScore;
	}
	public String getMovieImg() {
		return movieImg;
	}
	public void setMovieImg(String movieImg) {
		this.movieImg = movieImg;
	}
	
	@Override
	public String toString() {
		return "MovieList [movieId=" + movieId + ", movieName=" + movieName + ", movieScore=" + movieScore
				+ ", movieImg=" + movieImg + "]";
	}
}
