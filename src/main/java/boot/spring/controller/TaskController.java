package boot.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import boot.spring.bootstrap.DwCache;
import boot.spring.bootstrap.XzqhCache;
import boot.spring.pagemodel.ActorGrid;
import boot.spring.pagemodel.DwNode;
import boot.spring.pagemodel.MSG;
import boot.spring.pagemodel.Node;
import boot.spring.pagemodel.XzqhNode;
import boot.spring.po.Actor;
import boot.spring.po.Dwb;
import boot.spring.service.ActorService;
import boot.spring.service.DwService;
import boot.spring.tools.TreeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "异步任务接口")
@Controller
public class TaskController {
	@Autowired
	ActorService actorService;
	
	@Autowired
	DwService dwService;
	
	private static final Logger LOG = LoggerFactory.getLogger(TaskController.class);
	
	@ApiOperation("异步任务接口")
	@RequestMapping(value="/asyncTask",method = RequestMethod.GET)
	@ResponseBody
	public MSG asyncTask(){
		LOG.info("开始异步任务");
		String result = actorService.asyncTask();
		LOG.info("结束异步任务");
		return new MSG(result);
	}
	
	@ApiOperation("查询单位树层级结构")
	@RequestMapping(value="/buildDwTree",method = RequestMethod.GET)
	@ResponseBody
	public DwNode buildDwTree(){
		DwNode tree =	DwCache.getDwCache();
		DwNode dwNode = TreeUtils.getNodeByLabel("10001", tree);
		System.out.println("lable 10001 的 id是 " + dwNode.getId());
		System.out.println("lable 10001 的 name是 " + dwNode.getName());
		System.out.println("lable 10001 的 深度是 " + dwNode.getDepth());
		System.out.println("lable 10001 的 子节点列表是(包括自己) " + TreeUtils.getAllLabel(dwNode));
		// 测试统计,清空、赋值、累加
		TreeUtils.clearNodeCount(dwNode);
		Map<String, Long> map = new HashMap<>();
		map.put("10", 10L);
		map.put("10001", 20L);
		map.put("10001001", 30L);
		map.put("10001002", 20L);
		map.put("10002", 10L);
		map.put("10002001", 20L);
		map.put("10002002", 30L);
		map.put("10003", 40L);
		map.put("10003001", 10L);
		TreeUtils.setNodeValueByLabel(map, tree);
		TreeUtils.caculateNodeCount(tree);
		System.out.println("深度为1的节点有" + TreeUtils.getNodeByDepth(tree, 1).size() + "个");
		System.out.println("深度为2的节点有" + TreeUtils.getNodeByDepth(tree, 2).size() + "个");
		System.out.println("深度为3的节点有" + TreeUtils.getNodeByDepth(tree, 3).size() + "个");
		System.out.println("深度为4的节点有" + TreeUtils.getNodeByDepth(tree, 4).size() + "个");
		System.out.println("节点总数"+TreeUtils.getTotalNodes(tree));
		System.out.println("删除节点10003");
		TreeUtils.deleteNodeByLabel("10003", tree);
		System.out.println("删除节点10002");
		TreeUtils.deleteNodeByLabel("10002", tree);
		System.out.println("节点总数"+TreeUtils.getTotalNodes(tree));
		return tree;
	}	
	
	@ApiOperation("查询行政区划树层级结构")
	@RequestMapping(value="/buildXzqhTree",method = RequestMethod.GET)
	@ResponseBody
	public List<XzqhNode> buildXzqhTree(){
		List<XzqhNode> tree =	XzqhCache.getXzqhCache();
		XzqhNode xzqhNode = TreeUtils.getNodeByLabel("420102000000", tree.get(0));
		System.out.println("lable 420102000000 的 id是 " + xzqhNode.getId());
		System.out.println("lable 420102000000 的 name是 " + xzqhNode.getName());
		System.out.println("lable 420102000000 的 深度是 " + xzqhNode.getDepth());
		System.out.println("lable 420102000000 的 子节点列表是(包括自己) " + TreeUtils.getAllLabel(xzqhNode));
		return tree;
	}
}
