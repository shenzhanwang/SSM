package boot.spring.controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "jdbcTemplate接口")
@Controller
public class JdbcTemplateController {
	
	@Autowired
	@Qualifier("mysqlTemplate")
	JdbcTemplate mysqlTemplate;
	
	@Autowired
	@Qualifier("pgTemplate")
	JdbcTemplate pgTemplate;
	
	@Autowired
	@Qualifier("oracleTemplate")
	JdbcTemplate oracleTemplate;
	
	@ApiOperation("查询mysql")
	@RequestMapping(value="/jdbc/actors/{id}/{name}",method = RequestMethod.GET)
	@ResponseBody
	public List<Actor> getactorlist(@PathVariable("id")Short id,@PathVariable("name")String name){
		List<Actor> list = mysqlTemplate.query("select * from actor where actor_id = ? or first_name = ?",new Object[]{id,name}, new BeanPropertyRowMapper<>(Actor.class));
		return list;
	}
	
	@ApiOperation("查询potgresql")
	@RequestMapping(value="/jdbc/hotwords/{word}",method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> gethotwords(@PathVariable("word")String word){
		List<Map<String, Object>> list = pgTemplate.queryForList("select * from hotwords where hotword = ?", new Object[]{word});
		return list;
	}	

	@ApiOperation("查询oracle")
	@RequestMapping(value="/jdbc/dw",method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> gethotwords(){
		List<Map<String, Object>> list = oracleTemplate.queryForList("select * from HBHZK.dwb " );
		return list;
	}	
	
	@ApiOperation("修改mysql")
	@RequestMapping(value="/actors/jdbc/update",method = RequestMethod.GET)
	@ResponseBody
	public MSG actor(){
		
		int number = mysqlTemplate.update("update actor set first_name = ?, last_name=?, last_update=?"
				+ " where actor_id=?", new PreparedStatementSetter() {
					
					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setString(1, "wsz");
						ps.setString(2, "zsw");
						ps.setString(3, "2020-03-03");
						ps.setShort(4, (short)5);
					}
				});
		return new MSG("update success, affect " + number + "rows");
	}	

	@ApiOperation("新增mysql")
	@RequestMapping(value="/actors/jdbc/insert",method = RequestMethod.GET)
	@ResponseBody
	public MSG actorinsert(){
		List<Actor> list = new ArrayList<>();
		list.add(new Actor("aa","szw","2020-9-9"));
		list.add(new Actor("cc","szw","2020-9-9"));
		list.add(new Actor("bb","szw","2020-9-9"));
		int[] number = mysqlTemplate.batchUpdate("insert into actor (first_name,last_name,last_update) values (?,?,?) ", new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setString(1, list.get(i).getFirst_name());
				ps.setString(2, list.get(i).getLast_name());
				ps.setString(3, list.get(i).getLast_update());
			}
			
			@Override
			public int getBatchSize() {
				return list.size();
			}
		});
		int affact = 0;
		for (int a :  number) {
			if (a > 0)
			{
				affact++;
			}
		}
		return new MSG("insert success, affect " + affact + " rows");
	}	
	
	@ApiOperation("删除mysql")
	@RequestMapping(value="/actors/jdbc/delete",method = RequestMethod.GET)
	@ResponseBody
	public MSG delete(){
		short[] ids = {217,218,219};
		int[] number = mysqlTemplate.batchUpdate("delete from actor where actor_id=? ", new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setShort(1, ids[i]);
			}
			
			@Override
			public int getBatchSize() {
				return ids.length;
			}
		});
		int affact = 0;
		for (int a :  number) {
			if (a > 0)
			{
				affact++;
			}
		}
		return new MSG("delete success, affect " + affact + " rows");
	}	
}
