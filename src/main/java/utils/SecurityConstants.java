package utils;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

//we will define some reusable constants and defaults for generation and validation of JWTs
public final class SecurityConstants {

    public static final String AUTH_LOGIN_URL = "/api/authenticate";

    // Signing key for HS512 algorithm
    // You can use the page http://www.allkeysgenerator.com/ to generate all kinds of keys
    public static final String JWT_SECRET = "qasimovey";

    // JWT token defaults
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_ISSUER = "mobile-app-api";
    public static final String TOKEN_AUDIENCE = "mobile-app-clients";
    public static final long TOKEN_EXPIRATION = 864000000L;
    public static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    private SecurityConstants() {
        throw new IllegalStateException("Cannot create instance of static util class");
    }
}