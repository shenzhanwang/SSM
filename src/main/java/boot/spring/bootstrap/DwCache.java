package boot.spring.bootstrap;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import boot.spring.pagemodel.DwNode;
import boot.spring.pagemodel.Node;
import boot.spring.po.City;
import boot.spring.po.Dwb;
import boot.spring.service.CityService;
import boot.spring.service.DwService;
import boot.spring.tools.TreeUtils;

/**
 * 缓存预热，在spring boot启动时执行
 * 初始化单位树状结构到内存
 * @author shanzhanwang
 *
 */
@Component
public class DwCache implements ApplicationRunner {
	
	
	@Autowired
    DwService dwService;
	
	private static DwNode dwCache;
	
	@Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("===========初始化单位树开始=========");
        long startTime = System.currentTimeMillis();
        // 查询所有单位
        List<Dwb> dwblist = dwService.listDwb();
        List<DwNode> nodes = new ArrayList<>();
        // 把单位数据转化为节点对象列表
        dwblist.stream().forEach(dw->{
        	DwNode node = dwService.transformDwbToNode(dw);
        	nodes.add(node);
        });
        // 将节点列表转化为节点树，从根节点开始递归构建
        DwNode tree = TreeUtils.buildTree(nodes);
        DwCache.dwCache = tree;
        long endTime = System.currentTimeMillis();
        System.out.println("初始化单位结束,耗时"+(endTime-startTime));
    }

	public static DwNode getDwCache() {
		return dwCache;
	}

	public static void setDwCache(DwNode dwCache) {
		DwCache.dwCache = dwCache;
	}
	
	
}
