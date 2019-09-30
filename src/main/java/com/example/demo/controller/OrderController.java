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
import com.example.demo.bean.Order;
import com.example.demo.util.Utils;
@RestController
@RequestMapping("/user/order/list")
public class OrderController {
	
	@Value("${pro.order}")
    private String orderFile;
	
	@RequestMapping(method = RequestMethod.GET)
	//@RequestParam String userId
	 public String getOrderLists(@RequestParam String userId) throws Exception {
	    	File f = new File(orderFile);
	    	String printOrder=null;
		/*
		 * if(!f.exists()) { JSONObject json=new JSONObject(); json.put("status","400");
		 * json.put("msg","返回失败"); printOrder=JSON.toJSONString(json); };
		 */
	    	String strJon=Utils.FileToString(f);
	    	List<Order> orderList = new ArrayList<Order>();
	    	JSONArray jsonArray = JSONArray.fromObject(strJon);
		/*
		 * if(jsonArray.size()==0){ JSONObject json=new JSONObject();
		 * json.put("status","400"); json.put("msg","返回失败");
		 * printOrder=JSON.toJSONString(json); }
		 */
	        for (int i = 0; i < jsonArray.size(); i++ )
	        {
	            JSONObject jsonObject = jsonArray.getJSONObject(i);
	            Order  order = (Order)JSONObject.toBean(jsonObject, Order.class);
	            orderList.add(order);
	        }
		
		  List<Order> orderList2=new ArrayList<Order>(); 
		  for(Order order:orderList){
			  if(order.getUserId().equals(userId)){ 
				  orderList2.add(order);
			  } 
		  }
		 
		/*
		 * if(orderList2.isEmpty()){ JSONObject json=new JSONObject();
		 * json.put("status","400"); json.put("msg","返回失败");
		 * printOrder=JSON.toJSONString(json); }
		 */
	       /* else{*/
	        	JSONObject json=new JSONObject();
		       	json.put("status","200");
		       	json.put("msg","返回成功");
		       	json.put("result",orderList2);
			    printOrder=JSON.toJSONString(json); 
		/* } */
	      //  System.out.println(printOrder);
	        return printOrder;
	  }   

	
}
