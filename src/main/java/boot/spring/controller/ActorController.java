package boot.spring.controller;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import boot.spring.pagemodel.ActorGrid;
import boot.spring.pagemodel.MSG;
import boot.spring.po.Actor;
import boot.spring.service.ActorService;
import boot.spring.tools.FtpUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(tags = "演员接口")
@Controller
public class ActorController {
	@Autowired
	private ActorService actorservice;
	
	@Autowired
	FtpUtil ftpUtil;
	
	private static final Logger LOG = LoggerFactory.getLogger(ActorController.class);
	
	@ApiOperation("获取所有演员列表")
	@RequestMapping(value="/actors",method = RequestMethod.GET)
	@ResponseBody
	public ActorGrid getactorlist(@RequestParam(value="current") int current,@RequestParam(value="rowCount") int rowCount){
		int total=actorservice.getactornum();
		List<Actor> list=actorservice.getpageActors(current,rowCount);
		ActorGrid grid=new ActorGrid();
		grid.setCurrent(current);
		grid.setRowCount(rowCount);
		grid.setRows(list);
		grid.setTotal(total);
		LOG.info("获取所有演员列表");
		return grid;
	}
	
	@ApiOperation("修改一个演员")
	@RequestMapping(value="/actors",method = RequestMethod.PUT)
	@ResponseBody
	public Actor updateactor(@RequestBody Actor a){
		Actor actor=actorservice.updateactor(a);
		LOG.info("修改一个演员");
		return actor;
	}
	
	@ApiOperation("获取一个演员")
	@RequestMapping(value="/actors/{id}",method = RequestMethod.GET)
	@ResponseBody
	public Actor getactorbyid(@PathVariable("id") short id){
		Actor a=actorservice.getActorByid(id);
		LOG.info("获取一个演员");
		return a;
	}
	
	@ApiOperation("添加一个演员")
	@RequestMapping(value="/actors",method = RequestMethod.POST)
	@ResponseBody
	public Actor add(@RequestBody Actor a){
		Actor actor=actorservice.addactor(a);
		LOG.info("添加一个演员");
		return actor;
	}
	
	@ApiOperation("删除一个演员")
	@RequestMapping(value="/actors/{id}",method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@PathVariable("id") String id){
		actorservice.delete(Short.valueOf(id));
		LOG.info("删除一个演员");
		return "success";
	}
	
	@ApiOperation("把演员导出为Excel")
	@RequestMapping(value="/exportactor",method = RequestMethod.POST)
	@ResponseBody
	public void export(HttpServletResponse response, @RequestBody HashMap<String, String> a) throws Exception{
//		System.out.print(a.get("first_name") + "=======" + a.get("last_name"));
		InputStream is=actorservice.getInputStream();
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=AllUsers.xls");
		ServletOutputStream output = response.getOutputStream();
		IOUtils.copy(is, output);
	}
	
	@RequestMapping(value="/showactor",method = RequestMethod.GET)
	String showactor(){
		return "showactor";
	}
	
	@ApiOperation("从FTP服务器下载文件")
	@RequestMapping(value="/downloadFTP",method = RequestMethod.GET)
	@ResponseBody
	public void downloadFTP() throws Exception{
		ftpUtil.downloadFiles("/wsz", "/测试1dd.png","D://pic");
    	ftpUtil.downloadFiles("/to 吴方涛 from 王海伟", "/郑州110 科所队系统用户操作手册.doc","D://pic");
	}	
	
	@ApiOperation("从FTP服务器导出文件")
	@RequestMapping(value="/exportFTP",method = RequestMethod.GET)
	@ResponseBody
	public void exportFTP(HttpServletResponse response) throws Exception{
    	InputStream is=ftpUtil.exportFile("/王深湛", "/测试1.png");
		response.setContentType("application/x-png");
		response.setHeader("Content-Disposition","attachment;filename=1.png");
		ServletOutputStream output = response.getOutputStream();
		IOUtils.copy(is, output);
	}	
	
	@ApiOperation("从FTP服务器导出base64编码")
	@RequestMapping(value="/exportBase64",method = RequestMethod.GET)
	@ResponseBody
	public MSG exportBase64(HttpServletResponse response) throws Exception{
    	String base64=ftpUtil.exportBase64("/王深湛", "/测试1.png");
    	return new MSG(base64);
	}	
}
