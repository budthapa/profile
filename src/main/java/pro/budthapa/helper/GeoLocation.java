package pro.budthapa.helper;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.bfsmith.geotimezone.TimeZoneLookup;
import com.github.bfsmith.geotimezone.TimeZoneResult;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

public class GeoLocation {
	Logger log = LoggerFactory.getLogger(GeoLocation.class);

	private String dbLocation = "/home/budthapa/";
	private String fileName = "GeoLite2-City.mmdb";
	private final String SERVER_ADDRESS = "173.255.252.131";

	private DatabaseReader dbr;

	public void geoLocationReader() throws IOException {
		File file = new File(dbLocation + fileName);
		dbr = new DatabaseReader.Builder(file).build();

	}

	public GeoLocationHelper getLocation(String ip) throws IOException {

		geoLocationReader();

		InetAddress ipAddress = InetAddress.getByName(ip);
		System.out.println("ipAddress " + ipAddress);

		GeoLocationHelper geoLocationHelper = new GeoLocationHelper();

		try {
			CityResponse response = dbr.city(ipAddress);
			geoLocationHelper = setGeoDetail(response);
		} catch (GeoIp2Exception e) {
			log.info("IP Address not found, falling back to server IP Address");
			ipAddress = InetAddress.getByName(SERVER_ADDRESS);
			CityResponse response;
			try {
				response = dbr.city(ipAddress);
				geoLocationHelper = setGeoDetail(response);
			} catch (GeoIp2Exception e1) {
				log.info("IP Address not found, falling back to server IP Address");
			}
		}
		return geoLocationHelper;
	}

	private GeoLocationHelper setGeoDetail(CityResponse response) {
		String cityName = response.getCity().getName();
		String countryName = response.getCountry().getName();
		String timeZone = response.getLocation().getTimeZone();
		String latitude = response.getLocation().getLatitude().toString();
		String longitude = response.getLocation().getLongitude().toString();

		ZoneId zoneId=null;
		if (timeZone != null) {
			// Get zoneid wrt to supplied timezone
			zoneId = ZoneId.of(timeZone);
		}else{
			try {
				TimeZoneResult result = new TimeZoneLookup().getTimeZone(Double.parseDouble(latitude), Double.parseDouble(longitude));
				zoneId = ZoneId.of(result.getResult());
				log.info("Using alternative approach to get zoneId. Nearest zone id is "+result.getResult());
			} catch (Exception e) {
				log.warn("ZoneId not found. Fallback to server zoneID : America/Los_Angeles");
				zoneId = ZoneId.of("America/Los_Angeles");
			}
		}
		// get zoned date time wrt supplied zoneid
		LocalDate date = LocalDate.now(zoneId);
		LocalTime time = LocalTime.now(zoneId);

		return new GeoLocationHelper(cityName, countryName, timeZone, date, time, longitude, latitude);
	}

}
