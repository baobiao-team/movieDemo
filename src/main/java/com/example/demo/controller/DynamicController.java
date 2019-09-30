package com.example.demo.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Dynamic;
import com.example.demo.util.Utils;
import com.alibaba.fastjson.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/dynamic")
public class DynamicController {

	@Value("${pro.dynamic}")
	private String dynamicFile;

	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public String getDynamicLists() throws Exception {
		File f = new File(dynamicFile);
		String printDynamic = null;
		/*
		 * if(!f.exists()) {
		 * 
		 * JSONObject json=new JSONObject(); json.put("status","400");
		 * json.put("msg","返回失败"); printDynamic=JSON.toJSONString(json);
		 * 
		 * };
		 */
		String strJon = Utils.FileToString(f);
		List<Dynamic> dynamicList = new ArrayList<Dynamic>();
		JSONArray jsonArray = JSONArray.fromObject(strJon);
		/*
		 * if(jsonArray.size()==0){ JSONObject json=new JSONObject();
		 * json.put("status","400"); json.put("msg","返回失败");
		 * printDynamic=JSON.toJSONString(json);
		 * 
		 * }
		 */
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			Dynamic dynamic = (Dynamic) JSONObject.toBean(jsonObject, Dynamic.class);
			dynamicList.add(dynamic);
		}
		JSONObject json = new JSONObject();
		json.put("status", "200");
		json.put("msg", "返回成功");
		json.put("result", dynamicList);
		printDynamic = JSON.toJSONString(json);
		//System.out.println(printDynamic);
		return printDynamic;
	}

	/*
	 * @RequestMapping(path="/detail",method = RequestMethod.GET) public String
	 * detatil(@RequestParam String dynamicId){ File f = new File(dynamicFile);
	 * String printDynamic=null;
	 * 
	 * if(!f.exists()) {
	 * 
	 * JSONObject json=new JSONObject(); json.put("status","400");
	 * json.put("msg","返回失败"); printDynamic=JSON.toJSONString(json);
	 * 
	 * };
	 * 
	 * String strJon=Utils.FileToString(f); List<Dynamic> dynamicList = new
	 * ArrayList<Dynamic>(); JSONArray jsonArray = JSONArray.fromObject(strJon);
	 * 
	 * if(jsonArray.size()==0){ JSONObject json=new JSONObject();
	 * json.put("status","400"); json.put("msg","返回失败");
	 * printDynamic=JSON.toJSONString(json);
	 * 
	 * }
	 * 
	 * for(int i = 0; i < jsonArray.size(); i++){ JSONObject jsonObject =
	 * jsonArray.getJSONObject(i); Dynamic dynamic =
	 * (Dynamic)JSONObject.toBean(jsonObject, Dynamic.class);
	 * dynamicList.add(dynamic); } int count=0; for(Dynamic dynamic:dynamicList){
	 * if(dynamic.getDynamicId()==dynamicId){ JSONObject json=new JSONObject();
	 * json.put("status","200"); json.put("msg","返回成功"); json.put("result",dynamic);
	 * printDynamic=JSON.toJSONString(json); count++; break; } } if(count==0){
	 * JSONObject json=new JSONObject(); json.put("status","400");
	 * json.put("msg","返回失败"); printDynamic=JSON.toJSONString(json); }
	 * System.out.println(printDynamic); return printDynamic;
	 * 
	 * }
	 */
}
