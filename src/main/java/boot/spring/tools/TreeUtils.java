package boot.spring.tools;


import java.util.*;

import boot.spring.pagemodel.Node;

public class TreeUtils {

	/**
	 * @Description: 生成单一树形结构
	 * 根节点的pid是NULL，从根节点开始构建子树
	 */
	public static <T extends Node> T buildTree(List<T> list) {
		T tree = null;
		for (int i = 0; i < list.size(); i++) {
			if ( list.get(i).getPid() == null ) {
				// 构建子树
				tree = buildChildTree(list.get(i), 0, list);
			}
		}
		return tree;
	}


	/**
	 * @Description: 递归，建立子树形结构
	 * @Param: 父节点，父节点深度（根节点深度为1），全部节点列表
	 */
	private static <T extends Node> T buildChildTree(T pNode, Integer depth, List<? extends Node> list) {
		List<Node> childrenTree = new ArrayList<>();
		depth += 1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPid() != null && list.get(i).getPid().equals(pNode.getId())) {
				childrenTree.add(buildChildTree(list.get(i), depth, list));
			}
		}
		pNode.setDepth(depth);
		pNode.setChildren(childrenTree);
		return pNode;
	}
	
	/**
	 * 根据在树结构中用lable快速查找指定的节点
	 * @param label
	 * @param tree
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Node> T getNodeByLabel(String label, T node) {
		T resultNode = null;
		if (node.getLabel().equals(label)) {
			return node;
		}

		if (node.getChildren() != null && node.getChildren().size() == 0) {
			return null;
		}
		// 到孩子节点中去递归查找
		for (int i = 0; i < node.getChildren().size(); i++) {
			resultNode = getNodeByLabel(label, (T)node.getChildren().get(i));
			if (resultNode != null) {
				break;
			}
		}
		return resultNode;
	}
	
	/**
	 * @Description: 获取当前节点及所有子节点的label标签集合
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Node> List<String> getAllLabel(T node) {
		List<String> labels = new ArrayList<>();
		// 添加当前节点的标签
		labels.add(node.getLabel());
		for (int i = 0; i < node.getChildren().size(); i++) {
			T children = (T) node.getChildren().get(i);
			if (children != null && children.getChildren().size() <= 0) {
				// 如果是叶子结点，就添加到结果中
				labels.add(children.getLabel());
			} else {
				// 非叶子节点需要递归添加整合列表到结果
				List<String> clist = getAllLabel(children);
				if (clist != null) {
					labels.addAll(clist);
				}
			}
		}
		return labels;
	}
	
	/**
	 * @Description: 生成多颗平行树形结构
	 * 适用于根节点有多个的场景
	 */
	public static <T extends Node> List<T> buildMultiTree(List<T> list) {
		List<T> treeMenus = new ArrayList<T>();
		List<T> rootNodes = getRootNode(list);
		for (int i = 0; i < rootNodes.size(); i++) {
			T a = rootNodes.get(i);
			a = buildChildTree(rootNodes.get(i), 0, list);
			treeMenus.add(a);
		}
		return treeMenus;
	}

	/**
	 * @Description: 获取根节点,根节点可以有多个
	 * 根节点的pid为NULL
	 */
	public static <T extends Node> List<T> getRootNode(List<T> list) {
		List<T> rootLists = new ArrayList<>();
		for (T node : list) {
			if (node.getPid() == null) {
				rootLists.add(node);
			}
		}
		return rootLists;
	}
	
	/**
	 * 递归清空节点及其子节点的统计数据
	 */
	public static <T extends Node> void clearNodeCount(T node) {
		if (node != null) {
			node.setChildrenNumCount(0);
			node.setNodeNum(0);
		}
		if (node.getChildren()!=null && node.getChildren().size() > 0) {
			// 有子节点则递归清空
			for (int i = 0; i < node.getChildren().size(); i++) {
				clearNodeCount(node.getChildren().get(i));
			}
		}
	}
	
	/**
	 * @Description: 根据Label给节点计数赋值
	 * @Param: Map<String,Long> {"label": 0L}
	 */
	public static <T extends Node> void setNodeValueByLabel(Map<String, Long> map, T root) {
		Iterator<String> keySet = map.keySet().iterator();
		while (keySet.hasNext()) {
			String key = (String) keySet.next();
			T node = TreeUtils.getNodeByLabel(key, root);
			if (node == null) {
				// 找不到就查询下一个
				continue;
			}
			node.setNodeNum(map.get(key).intValue());
		}
	}	
	
	/**
	 * @Description: 递归统计,把每个节点的下级所有节点统计之和加上本节点的NodeNum值放进childrenNumCount
	 * 
	 */
	public static <T extends Node> Integer caculateNodeCount(T node) {
		Integer count = node.getNodeNum();
		if (node.getChildren() != null && node.getChildren().size() == 0) {
			// 没有孩子节点直接返回当前数据,设置子节点加和为当前数据
			node.setChildrenNumCount(count);
			return count;
		}
		for (int i = 0; i < node.getChildren().size(); i++) {
			// 把子节点的统计值都加进来
			count += caculateNodeCount(node.getChildren().get(i));
		}
		node.setChildrenNumCount(count);
		return count;
	}
	
	/**
	 * @Description: 根据根节点获取指定depth的节点
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Node> List<T> getNodeByDepth(T root, Integer depth) {
		List<T> nodes = new ArrayList<>();
		if (root.getDepth().equals(depth)) {
			nodes.add(root);
		} else {
			if (root.getChildren() == null && root.getChildren().size() == 0) {
				return nodes;
			}
			// 有孩子节点则递归添加
			for (int i = 0; i < root.getChildren().size(); i++) {
				T node = (T) root.getChildren().get(i);
				if (node != null && node.getDepth().equals(depth)) {
					nodes.add(node);
				} else {
					List<T> list = getNodeByDepth(node, depth);
					if (list != null && list.size() > 0) {
						nodes.addAll(list);
					}
				}
			}
		}
		return nodes;
	}
	
	/**
	 * @Description: 递归计算树的节点总数
	 */
	public static <T extends Node> Integer getTotalNodes(T node) {
		int count = 1;
		if (node != null) {
			for (int i = 0; i < node.getChildren().size(); i++) {
				// 把子节点的统计值都加进来
				count += getTotalNodes(node.getChildren().get(i));
			}
			return count;
		}
		return count;
	}
	
	/**
	 * @Description: 删除指定的lable节点
	 */
	public static <T extends Node> Integer deleteNodeByLabel(String label, T root) {
		 T node = TreeUtils.getNodeByLabel(label, root);
		 if (node == null) {
			 return 0;
		 } else {
			 String pid = node.getPid();
			 T pnode = TreeUtils.getNodeByLabel(pid, root);
			 List<T> children = (List<T>)pnode.getChildren();
			 Iterator<T> it = children.iterator();
			 while(it.hasNext()){
				    T temp = it.next();
				    if (label.equals(temp.getLabel())) {
				    	it.remove();
				    	return 1;
				    }
			 }
			 return 0;
		 }
		 
	}	
}
