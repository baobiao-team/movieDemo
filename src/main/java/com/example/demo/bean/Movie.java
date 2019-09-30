package com.example.demo.bean;

public class Movie {
	
	private String movieId;  //电影Id
	private String movieName; //电影名称
	private String movieScore; //电影评分
	private String movieActor;//电影主演
	private String movieTime; //上映时间
	private String moviePath; //电影饰品链接
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
	public String getMovieActor() {
		return movieActor;
	}
	public void setMovieActor(String movieActor) {
		this.movieActor = movieActor;
	}
	public String getMovieTime() {
		return movieTime;
	}
	public void setMovieTime(String movieTime) {
		this.movieTime = movieTime;
	}
	public String getMoviePath() {
		return moviePath;
	}
	public void setMoviePath(String moviePath) {
		this.moviePath = moviePath;
	}
	public String getMovieImg() {
		return movieImg;
	}
	public void setMovieImg(String movieImg) {
		this.movieImg = movieImg;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieScore=" + movieScore + ", movieActor="
				+ movieActor + ", movieTime=" + movieTime + ", moviePath=" + moviePath + ", movieImg=" + movieImg + "]";
	}
	
	
	
}
