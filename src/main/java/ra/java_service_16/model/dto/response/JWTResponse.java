package ra.java_service_16.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JWTResponse {
    private String username;
    private String password;
    private String token;
    private String fullName;
    private String email;
    private String phone;
    private Boolean status;
}
