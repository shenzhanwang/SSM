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
	    
	public Actor getActorByid(short id) {
		Actor a=actorMapper.getactorbyid(id);
		return a;
	}

	public void updateactor(Actor a) {
		actorMapper.updateActorbyid(a);
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

	public void addactor(Actor a) {
		actorMapper.insertActor(a);
	}

	public void delete(short id) {
		actorMapper.delete(id);
	}

}
