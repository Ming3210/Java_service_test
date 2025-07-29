package ra.java_service_16.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Customer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String fullName;

    private String password;

    private String email;

    private String phone;

    private Boolean isLogin;

    private Boolean status;


}
