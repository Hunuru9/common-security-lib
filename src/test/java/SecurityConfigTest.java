import com.hunuru.common.commonsecuritylib.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.core.GrantedAuthority;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SecurityConfigTest {

    @Test
    void jwtAuthenticationConverter_shouldExtractRolesCorrectly() {
        // Given
        Map<String, Object> realmAccess = new HashMap<>();
        realmAccess.put("roles", List.of("admin", "user"));

        Map<String, Object> claims = new HashMap<>();
        claims.put("realm_access", realmAccess);

        Jwt jwt = new Jwt("tokenValue", null, null, Map.of("alg", "none"), claims);

        SecurityConfig config = new SecurityConfig();
        JwtAuthenticationConverter converter = config.jwtAuthenticationConverter();

        // When
        var auth = converter.convert(jwt);

        // Then
        assertNotNull(auth);
        List<String> authorities = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        assertTrue(authorities.contains("ROLE_admin"));
        assertTrue(authorities.contains("ROLE_user"));
    }
}

