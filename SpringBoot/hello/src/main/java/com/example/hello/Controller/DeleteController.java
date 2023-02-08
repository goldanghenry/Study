package com.example.hello.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {
    // 1. RequestVariable + RequestParam
    // http://localhost:8080/api/v1/delete-api/{String 값}
    @DeleteMapping(value="/{variable}")
    public String deleteRequestParam1(@RequestParam String variable){
        return variable;
    }
    // 2. RequestVariable + RequestParam + queryString
    // http://localhost:8080/api/v1/delete-api/request1?email=value
    @DeleteMapping(value = "/request1")
    public String deleteRequestPraram2(@RequestParam String email){
        return "e-mail : " + email;
    }




}
