package boot.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.spring.mapper.DwbMapper;
import boot.spring.pagemodel.DwNode;
import boot.spring.po.Dwb;
import boot.spring.service.DwService;

@Service
public class DwServiceImpl implements DwService {
	
	@Autowired
	DwbMapper dwbMapper;

	@Override
	public List<Dwb> listDwb() {
		return dwbMapper.listDwb();
	}
	
	/**
	 * 将PO转化为树节点对象
	 */
	@Override
	public DwNode transformDwbToNode(Dwb dwb) {
		DwNode node = new DwNode();
		node.setPid(dwb.getSjdwbh());
		node.setId(dwb.getDwbh());
		node.setLabel(dwb.getDwbh());
		node.setXzqh(dwb.getXzqh());
		node.setName(dwb.getDwmc());
		return node;
	}

}
