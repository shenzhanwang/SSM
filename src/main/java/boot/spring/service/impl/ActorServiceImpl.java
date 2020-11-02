package boot.spring.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import boot.spring.controller.ActorController;
import boot.spring.mapper.ActorMapper;
import boot.spring.po.Actor;
import boot.spring.poi.WriteExcel;
import boot.spring.service.ActorService;

import com.github.pagehelper.PageHelper;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=5)
@Service("actorservice")
public class ActorServiceImpl implements ActorService{
	@Autowired
	public ActorMapper actorMapper;
	
	private static final Logger LOG = LoggerFactory.getLogger(ActorServiceImpl.class);
	    
	public Actor getActorByid(short id) {
		Actor a=actorMapper.getactorbyid(id);
		return a;
	}

	public Actor updateactor(Actor a) {
		actorMapper.updateActorbyid(a);
		return a;
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

	public Actor addactor(Actor a) {
		actorMapper.insertActor(a);
		return a;
	}

	public void delete(short id) {
		actorMapper.delete(id);
	}

	public InputStream getInputStream() throws Exception {
		String[] title=new String[]{"id","first_name","last_name","last_update"};
		List<Actor> plist=actorMapper.getAllactors();
		List<Object[]>  dataList = new ArrayList<Object[]>();  
		for(int i=0;i<plist.size();i++){
			Object[] obj=new Object[4];
			obj[0]=plist.get(i).getActor_id();
			obj[1]=plist.get(i).getFirst_name();
			obj[2]=plist.get(i).getLast_name();
			obj[3]=plist.get(i).getLast_update();
			dataList.add(obj);
		}
		WriteExcel ex = new WriteExcel(title, dataList);  
		InputStream in;
		in = ex.export();
		return in;
	}

	@Override
	@Async
	public String asyncTask() {
		LOG.info("start sleep");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LOG.info("end sleep");
		return "ok";
	}

}
