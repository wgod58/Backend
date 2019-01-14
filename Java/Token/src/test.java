import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class test {
	public static void main(String[] args) throws UnsupportedEncodingException {
		final long ONE_MINUTE_IN_MILLIS = 1000;// millisecs
		Calendar date = Calendar.getInstance();
		long t = date.getTimeInMillis();
		Date afterAddingTenMins = new Date(t + (10 * ONE_MINUTE_IN_MILLIS));
		@SuppressWarnings("deprecation")
		String jwt = Jwts.builder().setSubject("users/TzMUocMF4p").setExpiration(afterAddingTenMins)
				.claim("name", "Robert Token Man").claim("scope", "self groups/admins").claim("pwd", "w87878787")
				.signWith(SignatureAlgorithm.HS256, "secret".getBytes("UTF-8")).compact();
		System.out.println(jwt);

		Jws<Claims> jws = Jwts.parser().setSigningKey("secret".getBytes("UTF-8")).parseClaimsJws(jwt);
		System.out.println(jws.toString());

	}
}
