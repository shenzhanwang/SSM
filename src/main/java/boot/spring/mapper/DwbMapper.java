package boot.spring.mapper;

import java.util.List;

import boot.spring.po.Dwb;

public interface DwbMapper {
    int deleteByPrimaryKey(String dwbh);

    int insert(Dwb record);

    int insertSelective(Dwb record);

    Dwb selectByPrimaryKey(String dwbh);

    int updateByPrimaryKeySelective(Dwb record);

    int updateByPrimaryKey(Dwb record);
    
    List<Dwb> listDwb();
}