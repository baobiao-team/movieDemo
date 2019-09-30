package com.example.demo.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import com.example.demo.bean.Movie;
import com.example.demo.bean.MovieList;
import com.example.demo.util.Utils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/movie/movieList")
public class MovieListController {

	@Value("${movie}")
    private String file;
	
	@RequestMapping(method = RequestMethod.GET)
	public String movieList() throws Exception {
	    	File f = new File(file);
	    	JSONObject data=new JSONObject();
	    	List<Movie> movies = new ArrayList<Movie>();
	       	List<MovieList> moviesList = new ArrayList<MovieList>();
	    	if(!f.exists()) {
	    		data.put("status","400");
		    	data.put("msg","响应失败");
	    		//throw new Exception("no file:"+f.toString());
	    		
	    	}else{
	    		 String strJon=Utils.FileToString(f);
		    	 JSONArray jsonArray = JSONArray.fromObject(strJon);
		         for (int i = 0; i < jsonArray.size(); i++ )
		         {
		             JSONObject jsonObject = jsonArray.getJSONObject(i);
		             Movie movie = (Movie)JSONObject.toBean(jsonObject, Movie.class);
		             movies.add(movie);
		         }
		 
		        for (Movie movie: movies) {
	              MovieList movieList=new MovieList();
	              movieList.setMovieId(movie.getMovieId());
	              movieList.setMovieImg(movie.getMovieImg());
	              movieList.setMovieName(movie.getMovieName());
	              movieList.setMovieScore(movie.getMovieScore());
	              moviesList.add(movieList);
				  }
		        
		          data.put("status","200");
		    	  data.put("msg","返回成功");
		    	  data.put("result",moviesList);
	    	};
	         return JSON.toJSONString(data);
	    }

}
