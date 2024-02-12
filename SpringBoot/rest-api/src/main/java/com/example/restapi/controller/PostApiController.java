package com.example.restapi.controller;


import com.example.restapi.model.BookRequest;
import com.example.restapi.model.UserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController {

    // POST 요청의 경우 기본적으로 객체로 받아야 한다.
    // http://localhost:8080/api/post
    // Todo post method 기본적인 형태
    @PostMapping("/post")
    public BookRequest post(
            // get, put 으로 들어오는 데이터를 객체로 매핑
            // json은 key와 value 형태
        @RequestBody BookRequest bookRequest
    ) {
        System.out.println(bookRequest);
        return bookRequest; // client 에게 json 타입으로 body에 리턴해줌
    }

    // Todo RequestBody 로 사용자의 이름, 전화번호, 이메일을 받는 POST Method 만들기
    @PostMapping("/user")
    public UserRequest User(
            @RequestBody UserRequest userRequest
    ){
        System.out.println(userRequest);
        return userRequest;
    }
}
