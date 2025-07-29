package ra.java_service_16.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ra.java_service_16.model.dto.request.UserLogin;
import ra.java_service_16.model.dto.request.UserRegister;
import ra.java_service_16.model.dto.response.APIDataResponse;
import ra.java_service_16.model.dto.response.JWTResponse;
import ra.java_service_16.model.entity.Customer;
import ra.java_service_16.service.CustomerService;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<APIDataResponse<Customer>> register(@RequestBody UserRegister userRegister) {
        Customer customer = customerService.register(userRegister);
        return new ResponseEntity<>(new APIDataResponse<>(true, "Success", customer, HttpStatus.OK), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<APIDataResponse<JWTResponse>> login(@RequestBody UserLogin login) {
        JWTResponse customer = customerService.login(login);
        return new ResponseEntity<>(new APIDataResponse<>(true, "Success", customer, HttpStatus.OK), HttpStatus.OK);
    }


}
