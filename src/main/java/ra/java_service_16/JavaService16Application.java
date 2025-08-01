package ra.java_service_16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class JavaService16Application {

    public static void main(String[] args) {
        SpringApplication.run(JavaService16Application.class, args);

    }

    @Bean
    public PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();
    }

}
