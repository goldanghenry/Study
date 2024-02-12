package com.example.restapi.controller;

import com.example.restapi.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j  // 로그백 사용
@RestController
@RequestMapping("/api")
public class PutApiController {
    @PutMapping("/put")
    public void put(
        @RequestBody
        UserRequest userRequest
    ){
        // log 의 info 레벨로 찍겠다. 중괄호에는 객체가 매핑되고 toString 호출
        // system.out.println 과 다른 점은, system.out은 한줄 실행 후 다음 줄이 실행된다.
        // 많이 출력한다면 서버의 처리 속도가 저하된다.
        // 로그백을 사용하면, 버퍼를 사용해서 진행되는 속도에 영향을 크게 주지 않는다.
        // 로그백을 사용하면, 커스텀해서 정보를 출력할 수 있다.
        log.info("Request : {}", userRequest);

    }
}
