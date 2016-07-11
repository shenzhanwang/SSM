package mapper;

import java.util.List;

import po.City;

public interface CityMapper {
	List<City> getCitys();
	List<City> getCountrycity(String countryname);//获取某国家城市列表
}
