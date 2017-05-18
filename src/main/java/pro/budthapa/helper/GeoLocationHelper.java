package pro.budthapa.helper;

import java.time.LocalDate;
import java.time.LocalTime;

public class GeoLocationHelper {
	private String cityName;
	private String country;
	private String timeZone;
	private String longitude;
	private String latitude;
	private LocalDate currentUserDate;
	private LocalTime currentUserTime;

	public GeoLocationHelper(String cityName, String country, String timeZone, LocalDate currentUserDate, 
			LocalTime currentUserTime, String longitude, String latitude) {
		this.cityName = cityName;
		this.country = country;
		this.timeZone = timeZone;
		this.currentUserDate = currentUserDate;
		this.currentUserTime = currentUserTime;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public LocalTime getCurrentUserTime() {
		return currentUserTime;
	}

	public void setCurrentUserTime(LocalTime currentUserTime) {
		this.currentUserTime = currentUserTime;
	}

	public LocalDate getCurrentUserDate() {
		return currentUserDate;
	}

	public void setCurrentUserDate(LocalDate currentUserDate) {
		this.currentUserDate = currentUserDate;
	}

}
