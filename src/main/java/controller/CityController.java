package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import pagemodel.CityGrid;
import po.City;
import service.CityService;

@Controller
public class CityController {
	@Autowired
	CityService cityservice;
	@RequestMapping("/getcitys")
	@ResponseBody
	String getcitys(@RequestParam("current") int current,@RequestParam("rowCount") int rowCount){
		int total=cityservice.getCitylist().size();
		List<City> list=cityservice.getpagecitylist(current,rowCount);
		CityGrid grid=new CityGrid();
		grid.setCurrent(current);
		grid.setRowCount(rowCount);
		grid.setRows(list);
		grid.setTotal(total);
		return JSON.toJSONString(grid);
	}
	
	@RequestMapping("/country_city")
	String city(){
		return "city";
	}
}
