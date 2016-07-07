package controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
