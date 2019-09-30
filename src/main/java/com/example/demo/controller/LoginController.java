package com.example.demo.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.alibaba.fastjson.JSON;
import com.example.demo.bean.User;
import com.example.demo.util.Utils;





@RestController
@RequestMapping("/user/login")
public class LoginController {
	
		@Value("${pro.user}")
		private String userFile;
		
	    @RequestMapping(method = RequestMethod.GET)
	    public String pro(@RequestParam(value = "username") String username,
	    		@RequestParam(value = "password") String password) throws Exception {
	    	File f = new File(userFile);
	    	String printUser=null;
		/*
		 * if(!f.exists()) {
		 * 
		 * JSONObject json=new JSONObject(); json.put("status","400");
		 * json.put("msg","返回失败"); printUser=JSON.toJSONString(json);
		 * 
		 * };
		 */
	    	String strJon=Utils.FileToString(f);
	    	List<User> userList = new ArrayList<User>();
	    	JSONArray jsonArray = JSONArray.fromObject(strJon);
		/*
		 * if(jsonArray.size()==0){ JSONObject json=new JSONObject();
		 * json.put("status","400"); json.put("msg","返回失败");
		 * printUser=JSON.toJSONString(json);
		 * 
		 * }
		 */
	        for (int i = 0; i < jsonArray.size(); i++ )
	        {
	            JSONObject jsonObject = jsonArray.getJSONObject(i);
	            User  user = (User)JSONObject.toBean(jsonObject, User.class);
	            userList.add(user);
	        }
		/* int count=0; */
	        for (User user : userList) {
	    	    if(user.getUsername().equals(username)&&user.getPassword().equals(password)) { 
	    	    	 JSONObject json=new JSONObject();
			    	 json.put("status","200");
			    	 json.put("msg","返回成功");
			    	 json.put("result",user);
	    		     printUser=JSON.toJSONString(json);
	    		     //count++;
	    		     break;
	    	    }else {		 
	    	    	 JSONObject json=new JSONObject();
			    	 json.put("status","400");
			    	 json.put("msg","返回失败");
	    		     printUser=JSON.toJSONString(json); 
	    		  }
	        }
		/*
		 * if(count==0){ JSONObject json=new JSONObject(); json.put("status","400");
		 * json.put("msg","返回失败"); printUser=JSON.toJSONString(json); }
		 */
	      //  System.out.println(printUser);
	        return printUser;
	 }

	
	
}
