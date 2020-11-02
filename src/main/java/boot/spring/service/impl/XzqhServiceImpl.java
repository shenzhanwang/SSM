package boot.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.spring.mapper.XzqhMapper;
import boot.spring.pagemodel.DwNode;
import boot.spring.pagemodel.XzqhNode;
import boot.spring.po.Xzqh;
import boot.spring.service.XzqhService;

@Service
public class XzqhServiceImpl implements XzqhService {
	
	@Autowired
	XzqhMapper xzqhMapper;

	@Override
	public List<Xzqh> listXzqh() {
		return xzqhMapper.listAll();
	}

	@Override
	public XzqhNode transformXzqhToNode(Xzqh xzqh) {
		XzqhNode node = new XzqhNode();
		node.setPid(xzqh.getSjbm());
		node.setId(xzqh.getBm());
		node.setLabel(xzqh.getBm());
		node.setName(xzqh.getMc());
		return node;
	}
	
	
	
}
