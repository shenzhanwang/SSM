package schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import po.Actor;
import service.ActorService;

@Component
public class AddActor {
	@Autowired
	private ActorService actorservice;
	
	@Scheduled(cron="0 0/3 * * * ?") 
	void runTask() {
		System.out.println("开始自动调度添加演员");
		// 调用业务逻辑方法
		Actor a = new Actor();
		a.setFirst_name("AUTO");
		a.setLast_name("hehe");
		a.setLast_update("2018-1-1");
		actorservice.addactor(a);
	}

}
