package boot.spring.pagemodel;

/**
 * 单位树的节点
 * @author dell
 *
 */
public class DwNode extends Node {
	/**
	 * 把单位的行政区划字段附带到树结构中展示
	 **/
	private String xzqh;
	
	public String getXzqh() {
		return xzqh;
	}
	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}
	
}
