package service;

import java.util.List;

import po.Actor;

	public interface ActorService {
		List<Actor> getpageActors(int pagenum,int pagesize);
		int getactornum();
		Actor getActorByid(int id);
		void updateactor(Actor a);
		void addactor(short id);
	}
