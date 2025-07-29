package ra.java_service_16.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ra.java_service_16.model.dto.request.UserLogin;
import ra.java_service_16.model.dto.request.UserRegister;
import ra.java_service_16.model.dto.response.JWTResponse;
import ra.java_service_16.model.entity.Customer;
import ra.java_service_16.repository.CustomerRepository;
import ra.java_service_16.security.jwt.JWTAuthFilter;
import ra.java_service_16.security.jwt.JWTProvider;
import ra.java_service_16.security.principal.CustomerPrincipal;
import ra.java_service_16.service.CustomerService;

import java.util.NoSuchElementException;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTProvider jwtProvider;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public Customer register(UserRegister userRegister) {
        Customer customer = Customer.builder()
                .username(userRegister.getUsername())
                .fullName(userRegister.getFullName())
                .password(passwordEncoder.encode(userRegister.getPassword()))

                .email(userRegister.getEmail())
                .phone(userRegister.getPhone())
                .isLogin(false)
                .status(true)
                .build();

        return customerRepository.save(customer);
    }

    @Override
    public JWTResponse login(UserLogin userLogin) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUsername(), userLogin.getPassword()));
            CustomerPrincipal principal = (CustomerPrincipal) authentication.getPrincipal();
            String token = jwtProvider.generateToken(principal.getUsername());
            return JWTResponse.builder()
                    .username(principal.getUsername())
                    .password(principal.getPassword())
                    .token(token)
                    .fullName(principal.getFullName())
                    .email(principal.getEmail())
                    .phone(principal.getPhone())
                    .status(principal.getStatus())
                    .build();
        } catch (AuthenticationException e) {
            throw new NoSuchElementException("User not found");
        }
    }

    @Override
    public void logout(String token) {
        String username = jwtProvider.getUsernameFromToken(token);
        Customer customer = customerRepository.findByUsername(username).orElseThrow(()-> new NoSuchElementException("User not found"));
        customer.setIsLogin(false);
        customerRepository.save(customer);
    }
}
