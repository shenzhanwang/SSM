package mapper;

import java.util.List;

import po.City;
import po.Country;

public interface CityMapper {
	List<City> getCitys();
	List<Country> getCountrycity(String countryname);
}
