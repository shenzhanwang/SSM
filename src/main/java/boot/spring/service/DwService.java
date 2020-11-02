package boot.spring.service;

import java.util.List;

import boot.spring.pagemodel.DwNode;
import boot.spring.po.Dwb;

public interface DwService {
	List<Dwb> listDwb();
	
	DwNode transformDwbToNode(Dwb dwb);
}
