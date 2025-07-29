package ra.java_service_16.security.principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ra.java_service_16.model.entity.Customer;
import ra.java_service_16.repository.CustomerRepository;

@Service
public class CustomerPrincipalService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return CustomerPrincipal.builder()
                .username(customer.getUsername())
                .password(customer.getPassword())
                .fullName(customer.getFullName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .isLogin(customer.getIsLogin())
                .status(customer.getStatus())
                .build();
    }

}
