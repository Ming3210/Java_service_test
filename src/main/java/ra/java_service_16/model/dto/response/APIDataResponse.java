package ra.java_service_16.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class APIDataResponse <T>{
    private Boolean success;
    private String message;
    private T data;
    private HttpStatus status;
}
