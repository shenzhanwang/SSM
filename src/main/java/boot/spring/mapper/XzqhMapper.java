package boot.spring.mapper;

import java.util.List;

import boot.spring.po.Xzqh;

public interface XzqhMapper {
    int deleteByPrimaryKey(String bm);

    int insert(Xzqh record);

    int insertSelective(Xzqh record);

    Xzqh selectByPrimaryKey(String bm);

    int updateByPrimaryKeySelective(Xzqh record);

    int updateByPrimaryKey(Xzqh record);
    
    List<Xzqh> listAll();
}