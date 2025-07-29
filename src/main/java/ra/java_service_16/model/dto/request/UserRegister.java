package ra.java_service_16.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegister {
    private String username;
    private String fullName;
    private String password;
    private String email;
    private String phone;
}
