package boot.spring.service;

import java.util.List;

import boot.spring.pagemodel.XzqhNode;
import boot.spring.po.Xzqh;

public interface XzqhService {
	List<Xzqh> listXzqh();
	
	XzqhNode transformXzqhToNode(Xzqh xzqh);
}
