package customer.myapp.utils;
import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpStatus;

import customer.myapp.errors.ApiError;


public class AppUtils {
    
    public static String getBasicAuth(String user, String password) {
        final String auth = Base64
                .encodeBase64String(String.format("%s:%s", user, password).getBytes(StandardCharsets.UTF_8));
        return auth;
    }

    // public static ApiError getErrorDetails(BusinessException ex) {
    //     return new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getErrorDescription(),
    //             ex.getErrorDescription(), ex.getErrorCode());

    // }

    public static ApiError getErrorDetails(Exception ex) {
        return new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(),
                ex.getMessage(), null);

    }
}
