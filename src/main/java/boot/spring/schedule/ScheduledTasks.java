package boot.spring.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import boot.spring.po.Actor;
import boot.spring.service.ActorService;

@Component
public class ScheduledTasks {
	
	@Autowired
	private ActorService actorservice;
		
		// 五秒钟一次，默认单线程的，每次任务执行完后，再等五秒钟开始执行下一次
//	    @Scheduled(cron="*/5 * * * * ?")
	    public void reportCurrentTime() throws Exception {
	        Thread.sleep(10000);
	        System.out.println(System.currentTimeMillis());
	    }
}
