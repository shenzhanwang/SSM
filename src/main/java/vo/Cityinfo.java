package vo;

import java.util.Date;

public class Cityinfo {
	private short city_id;
	private String city;
	private String countryname;
	private Date last_update;
	public short getCity_id() {
		return city_id;
	}
	public void setCity_id(short city_id) {
		this.city_id = city_id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountryname() {
		return countryname;
	}
	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}
	public Date getLast_update() {
		return last_update;
	}
	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}
	
}
