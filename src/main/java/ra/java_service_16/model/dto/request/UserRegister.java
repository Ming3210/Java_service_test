package ra.java_service_16.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegister {
    @NotBlank (message = "Username cannot be empty or null")
    private String username;

    @NotBlank (message = "Password cannot be empty or null")
    private String fullName;

    @NotBlank (message = "Password cannot be empty or null")
    private String password;

    @NotBlank (message = "Password cannot be empty or null")
    @Pattern (regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "Invalid email format")
    private String email;

    @NotBlank (message = "Password cannot be empty or null")
    private String phone;
}
