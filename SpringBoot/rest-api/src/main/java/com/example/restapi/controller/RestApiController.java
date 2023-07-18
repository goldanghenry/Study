package com.example.restapi.controller;
// 클라이언트가 서버로 요청을 할 때, 어떤 주소(진입점)로 요청할지 작성해야 함
// SpringBoot는 Annotaion 기반으로 작성되어 있다. 각 클래스와 메서드들의 역할을 지정해줄 수 있다.
// 서버에 컨트롤러가 띄워져 있고, /api 라는 주소가 들어오면 RestController가 처리하는데 /hello 는 GetMapping으로 처리하겠다.

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController         // Rest API를 처리하는 컨트롤러를 지정하는 어노테이션
@RequestMapping("/api") // "/api"라는 주소를 모두 받아들이겠다.
public class RestApiController {
    // http://localhost:8080/api/hello
    // 요청이 들어오면 무엇을 return 해줄 것인가? 문자, 미디어,,,
    // 통신이란 결국 문자를 전달해주는 것
    @GetMapping(path = "/hello" )    // 이 주소 중에서도 어떠한 주소를 처리하겠다.
    public String hello(){
        var html ="<html> <body> <h1> Hello Spring Boot </h1> </body> </html>";
        return html;
        //return "Hello Spring Boot"
    }
}
