package service;

import java.util.List;
import po.City;

public interface CityService {
	List<City> getCitylist();
	List<City> getpagecitylist(int pagenum, int pagesize);
}
