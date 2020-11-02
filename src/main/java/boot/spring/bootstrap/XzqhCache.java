package boot.spring.bootstrap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import boot.spring.pagemodel.DwNode;
import boot.spring.pagemodel.XzqhNode;
import boot.spring.po.Dwb;
import boot.spring.po.Xzqh;
import boot.spring.service.XzqhService;
import boot.spring.tools.TreeUtils;

/**
 * 缓存预热，在spring boot启动时执行
 * 初始化行政区划树状结构到内存
 * @author shanzhanwang
 *
 */
@Component
public class XzqhCache implements ApplicationRunner {
	
	@Autowired
	XzqhService xzqhService;
	
	private static List<XzqhNode> xzqhCache;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("===========初始化行政区划树开始=========");
        long startTime = System.currentTimeMillis();
        // 查询所有行政区
        List<Xzqh> xzqlist = xzqhService.listXzqh();
        List<XzqhNode> nodes = new ArrayList<>();
        // 把PO数据转化为节点对象列表
        xzqlist.stream().forEach(xzqh->{
        	XzqhNode node = xzqhService.transformXzqhToNode(xzqh);
        	nodes.add(node);
        });
        // 将节点列表转化为节点树，从根节点开始递归构建
        List<XzqhNode> tree = TreeUtils.buildMultiTree(nodes);
        XzqhCache.xzqhCache = tree;
        long endTime = System.currentTimeMillis();
        System.out.println("初始化行政区划树结束,耗时"+(endTime-startTime));
	}

	public XzqhService getXzqhService() {
		return xzqhService;
	}

	public void setXzqhService(XzqhService xzqhService) {
		this.xzqhService = xzqhService;
	}

	public static List<XzqhNode> getXzqhCache() {
		return xzqhCache;
	}

	public static void setXzqhCache(List<XzqhNode> xzqhCache) {
		XzqhCache.xzqhCache = xzqhCache;
	}

}
