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
import com.example.demo.bean.Cinema;
import com.example.demo.bean.Movie;
import com.example.demo.util.Utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/cinema/detail")
public class CinemaDetailController {

	@Value("${cinema}")
    private String file;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String cinemaDetail(@RequestParam(value = "cinemaId") String cinemaId) throws Exception {
	    	
		File f = new File(file);
    	JSONObject data=new JSONObject();
    	List<Cinema> cinemas = new ArrayList<Cinema>();

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
	             Cinema cinema = (Cinema)JSONObject.toBean(jsonObject, Cinema.class);
	             cinemas.add(cinema);
	         }
	 
	        for (Cinema cinema: cinemas) {
	        	
             if(cinema.getCinemaId().equals(cinemaId)) {
                  data.put("status","200");
		    	  data.put("msg","返回成功");
		    	  MovieDetailController movieDetailController=new MovieDetailController();
		    	  Movie  cinema1= movieDetailController.CinemaMovie(cinemaId);
		    	  int a=Integer.parseInt(cinemaId);
		    	  Movie  cinema2= movieDetailController.CinemaMovie(String.valueOf((a+1)));
		    	  
		    	  JSONObject json=new JSONObject();
		      	  List<Movie> cinemaList = new ArrayList<Movie>();
		      	  cinemaList.add(cinema1);
		      	  cinemaList.add(cinema2);
		      	  json.put("cinemaId",cinema.getCinemaId());
		      	  json.put("cineName",cinema.getCineName());
		      	  json.put("location",cinema.getLocation());
		      	  json.put("miniprice",cinema.getMiniprice());
		      	  json.put("label",cinema.getLabel());
		      	  json.put("longitude",cinema.getLongitude());
		      	  json.put("latitude",cinema.getLatitude());
		      	  json.put("movieList",cinemaList);
		      	  data.put("result",json);
		    	  break;
			  }else{
			     data.put("status","400");
			     data.put("msg","响应失败");
			  }
	    	}
    	};
    	 //System.out.println(JSON.toJSONString(data));
         return JSON.toJSONString(data);

	    }
}
