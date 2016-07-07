package service.impl;

import java.util.List;

import mapper.ActorMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import po.Actor;
import service.ActorService;

@Service("actorservice")
public class ActorServiceImpl implements ActorService{
	@Autowired
	public ActorMapper actorMapper;
	    
	public Actor getActorByid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateactor(Actor a) {
		// TODO Auto-generated method stub
		
	}

	public void addactor(short id) {
		// TODO Auto-generated method stub
		
	}

	public List<Actor> getpageActors(int pagenum, int pagesize) {
		PageHelper.startPage(pagenum,pagesize);  
		List<Actor> l=actorMapper.getAllactors();
		return l;
	}

	public int getactornum() {
		List<Actor> l=actorMapper.getAllactors();
		return l.size();
	}

}
