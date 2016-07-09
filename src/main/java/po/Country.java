package po;

import java.util.Date;

public class Country {
	private short country_id;
	private String country;
	private Date last_update;
	
	public short getCountry_id() {
		return country_id;
	}
	public void setCountry_id(short country_id) {
		this.country_id = country_id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getLast_update() {
		return last_update;
	}
	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}
}
