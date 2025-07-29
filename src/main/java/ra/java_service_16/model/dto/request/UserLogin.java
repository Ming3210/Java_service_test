package ra.java_service_16.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLogin {
    @NotBlank(message = "Username cannot be empty or null")
    private String username;

    @NotBlank(message = "Password cannot be empty or null")
    private String password;
}
