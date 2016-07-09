package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import pagemodel.ActorGrid;
import po.Actor;
import service.ActorService;

@Controller
public class ActorController {
	@Autowired
	private ActorService actorservice;
	
	@RequestMapping("/actorlist")
	@ResponseBody
	public String getactorlist(@RequestParam("current") int current,@RequestParam("rowCount") int rowCount){
		int total=actorservice.getactornum();
		List<Actor> list=actorservice.getpageActors(current,rowCount);
		ActorGrid grid=new ActorGrid();
		grid.setCurrent(current);
		grid.setRowCount(rowCount);
		grid.setRows(list);
		grid.setTotal(total);
		return JSON.toJSONString(grid);
	}
	
	@RequestMapping("/showactor")
	public String showactor(){
		return "showactor";
	}
	
	@RequestMapping(value="/updateactor",method = RequestMethod.POST)
	public String updateactor(@RequestParam("id") short id,@RequestParam("first_name") String first_name,
			@RequestParam("last_name") String last_name,@RequestParam("last_update") String last_update
			){
		Actor a=new Actor();
		a.setFirst_name(first_name);
		a.setId(id);
		a.setLast_name(last_name);
		a.setLast_update(last_update);
		actorservice.updateactor(a);
		return "showactor";
	}
	
	@RequestMapping(value="/getActorInfo")
	@ResponseBody
	public String getactorbyid(@RequestParam("id") short id){
		Actor a=actorservice.getActorByid(id);
		return JSON.toJSONString(a);
	}
	
	@RequestMapping("/addactor")
	public String add(@RequestParam("first_name") String first_name,
			@RequestParam("last_name") String last_name,@RequestParam("last_update") String last_update
			){
				Actor a=new Actor();
				a.setFirst_name(first_name);
				a.setLast_name(last_name);
				a.setLast_update(last_update);
				actorservice.addactor(a);
				return "showactor";
	}
	
	@RequestMapping(value="/deleteactor")
	public String delete(@RequestParam("id") short id){
		actorservice.delete(id);
		return "showactor";
	}
}
