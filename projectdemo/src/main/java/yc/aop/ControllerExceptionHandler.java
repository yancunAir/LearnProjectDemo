package yc.aop;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler({Exception.class})
    public Map handleException(Exception ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = new HashMap();
        resultMap.put("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
        resultMap.put("message", "发生了内部异常，请查看相关日志.");
        return resultMap;
    }

}
