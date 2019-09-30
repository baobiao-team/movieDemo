package com.example.demo.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import com.example.demo.bean.Cinema;
import com.example.demo.bean.CinemaList;
import com.example.demo.util.Utils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/cinema/list")
public class CinemaListController {

	@Value("${cinema}")
    private String file;
	
	@RequestMapping(method = RequestMethod.GET)
	public String cinemaList() throws Exception {
		
		    	File f = new File(file);
		    	JSONObject data=new JSONObject();
		    	List<Cinema> cinemas = new ArrayList<Cinema>();
		       	List<CinemaList> cinemasList = new ArrayList<CinemaList>();
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
			          CinemaList cinemaList=new CinemaList();
			          cinemaList.setCinemaId(cinema.getCinemaId());
			          cinemaList.setCineName(cinema.getCineName());
			          cinemaList.setLocation(cinema.getLocation());
			          cinemaList.setMiniprice(cinema.getMiniprice());
			          cinemaList.setLabel(cinema.getLabel());
			          cinemasList.add(cinemaList);
					  }
			        
			          data.put("status","200");
			    	  data.put("msg","返回成功");
			    	  data.put("result",cinemasList);
		    	};
		         return JSON.toJSONString(data);
		    
	    }
}
