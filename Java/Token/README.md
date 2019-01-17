JJWT
===========================
****

###### The JwtBuilder provides convenient setter methods for standard registered Claim names defined in the JWT specification. They are:

* setIssuer: sets the iss (Issuer) Claim
* setSubject: sets the sub (Subject) Claim
* setAudience: sets the aud (Audience) Claim
* setExpiration: sets the exp (Expiration Time) Claim
* setNotBefore: sets the nbf (Not Before) Claim
* setIssuedAt: sets the iat (Issued At) Claim
* setId: sets the jti (JWT ID) Claim
###### [reference](https://github.com/jwtk/jjwt/blob/master/README.md)
###### [https://jwt.io/](https://jwt.io/)
```java
  import java.io.UnsupportedEncodingException;
  import java.util.Calendar;
  import java.util.Date;

  import io.jsonwebtoken.Claims;
  import io.jsonwebtoken.Jws;
  import io.jsonwebtoken.Jwts;
  import io.jsonwebtoken.SignatureAlgorithm;
  final long ONE_MINUTE_IN_MILLIS = 1000;// millisecs
  Calendar date = Calendar.getInstance();
  long t = date.getTimeInMillis();
  Date afterAddingTenMins = new Date(t + (10 * ONE_MINUTE_IN_MILLIS));
  String jwt = Jwts.builder().
  setSubject("users/TzMUocMF4p").
  setExpiration(afterAddingTenMins)
      .claim("name", "Robert Token Man")
      .claim("scope", "self groups/admins")
      .claim("pwd", "w87878787")
      .signWith(SignatureAlgorithm.HS256, "secret".getBytes("UTF-8"))
      .compact();
    System.out.println(jwt);

  Jws<Claims> jws = Jwts
    .parser()
    .setSigningKey("secret".getBytes("UTF-8"))
    .parseClaimsJws(jwt);//come out exception when time expire
  System.out.println(jws.toString());
```
