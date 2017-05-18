package pro.budthapa.helper;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

public class GeoLocation {
	private String dbLocation = "/home/budthapa/";
	private String fileName = "GeoLite2-City.mmdb";
	private DatabaseReader dbr;

	public void geoLocationReader() throws IOException {
		File file = new File(dbLocation + fileName);
		dbr = new DatabaseReader.Builder(file).build();

	}

	public GeoLocationHelper getLocation(String ip) throws IOException, GeoIp2Exception {
		geoLocationReader();

		InetAddress ipAddress = InetAddress.getByName(ip);
		System.out.println("ip " + ipAddress);

		CityResponse response = dbr.city(ipAddress);

		String cityName = response.getCity().getName();
		String countryName = response.getCountry().getName();
		String timeZone = response.getLocation().getTimeZone();
		String latitude = response.getLocation().getLatitude().toString();
		String longitude = response.getLocation().getLongitude().toString();
		
		// Get zoneid wrt to supplied timezone
		ZoneId zoneId = ZoneId.of(timeZone);
		
		// get zoned date time wrt supplied zoneid
		LocalDate date = LocalDate.now(zoneId);
		LocalTime time = LocalTime.now(zoneId);
		
		return new GeoLocationHelper(cityName, countryName, timeZone, date, time,longitude, latitude);

	}

}
