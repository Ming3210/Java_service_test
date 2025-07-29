package ra.java_service_16.service;

import ra.java_service_16.model.dto.request.UserLogin;
import ra.java_service_16.model.dto.request.UserRegister;
import ra.java_service_16.model.dto.response.JWTResponse;
import ra.java_service_16.model.entity.Customer;

public interface CustomerService {
    Customer register(UserRegister userRegister);
    JWTResponse login(UserLogin userLogin);

}
