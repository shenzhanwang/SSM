package boot.spring.pagemodel;

import java.util.ArrayList;
import java.util.List;

/**
 * 树节点
 * @author dell
 * @param <T>
 */
public class Node {
	// 当前节点id
	private String id;
	// 父节点id
	private String pid;
	// 深度
	private Integer depth = 0;
	// 节点名称
	private String name;
	// 节点标签，用于遍历和查找。是节点的唯一标识
	private String label;
	/**
	 * 节点计数
	 **/
	private Integer nodeNum = 0;
	/**
	 * 下级节点计数sum
	 * childrenNumCount = 所有子节点的nodeNum加和 + 本节点的nodeNum值
	 **/
	private Integer childrenNumCount = 0;
	// 子节点
	private List<? extends Node> children = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public Integer getDepth() {
		return depth;
	}

	public void setDepth(Integer depth) {
		this.depth = depth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<? extends Node> getChildren() {
		return children;
	}

	public void setChildren(List<? extends Node> children) {
		this.children = children;
	}

	public Integer getNodeNum() {
		return nodeNum;
	}

	public void setNodeNum(Integer nodeNum) {
		this.nodeNum = nodeNum;
	}

	public Integer getChildrenNumCount() {
		return childrenNumCount;
	}

	public void setChildrenNumCount(Integer childrenNumCount) {
		this.childrenNumCount = childrenNumCount;
	}

	@Override
	public String toString() {
		return "Node [id=" + id + ", pid=" + pid + ", depth=" + depth + ", name=" + name + ", label=" + label
				+ ", children=" + children + "]";
	}

}
