package com.example.demo.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import com.example.demo.bean.Movie;
import com.example.demo.util.Utils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/movie/movieDetail")
public class MovieDetailController {

	@Value("${movie}")
    private String file;
	

	
	static String res=null;
	@RequestMapping(method = RequestMethod.GET)
	public String movieDetail(@RequestParam(value = "movieId") String movieId) throws Exception {
	    	File f = new File(file);
	    	JSONObject data=new JSONObject();
	    	List<Movie> movies = new ArrayList<Movie>();

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
		        	
	             if(movie.getMovieId().equals(movieId)) {
	                  data.put("status","200");
			    	  data.put("msg","返回成功");
			    	  data.put("result",movie);
			    	  break;
				  }else{
				     data.put("status","400");
				     data.put("msg","响应失败");
				  }
		    	}
	    	};
	         return JSON.toJSONString(data);
	    }

	public Movie CinemaMovie(String movieId) throws Exception {
    	File f = new File("/home/wangwc/demo/data/moviesInfo.json");
    	JSONObject data=new JSONObject();
    	List<Movie> movies = new ArrayList<Movie>();
    
        String strJon=Utils.FileToString(f);
	    JSONArray jsonArray = JSONArray.fromObject(strJon);
	    for (int i = 0; i < jsonArray.size(); i++ )
	        {
	             JSONObject jsonObject = jsonArray.getJSONObject(i);
	             Movie movie = (Movie)JSONObject.toBean(jsonObject, Movie.class);
	             movies.add(movie);
	         }
	 
	        for (Movie movie: movies) {
	        	
             if(movie.getMovieId().equals(movieId)) {
		    	//JSONObject json=JSONObject.fromObject(movie);
            	//res=json.toString();
            	 return movie;
		    	
			  }
	    	}
         return null;
    }
}
