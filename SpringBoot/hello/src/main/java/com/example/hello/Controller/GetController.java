package com.example.hello.Controller;

import com.example.hello.dto.MemberDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

// RestController와 RequestMapping을 붙여 내부에 선언되는 메서드에서 사용할 공통 URL을 설정
// 클래스 수준에서 RequestMapping을 설정하면 내부에 선언한 메서드의 URL 리소스 앞에 @RequestMapping의 값이 공통 값으로 추가 된다
@RestController
@RequestMapping("api/v1/get-api")
public class GetController {
    // 1. RequestMapping GET API
    // http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String getHello() {
        return "Hello World!";
    }

    // 2. 매개 변수가 없는 GET API
    // http://localhost:8080/api/v1/get-api/name
    @GetMapping(value="name")
    public String getName(){
        return "Fature";
    }

    // 3.1 @PathVariable을 활용한 GET API
    // http://localhost:8080/api/v1/get-api/variable1/{String 값}
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        return variable;
    }

    // 3.2 @PathVariable에 변수명을 매핑하는 방법
    // http://localhost:8080/api/v1/get-api/variable2/{String 값}
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){
        return var;
    }

    // 4.1 @RequestParam을 활용한 GET API
    // http://localhost:8080/api/v1/get-api/request1?name=value1&email=value2&organization=value3
    @ApiOperation(value = "GET 메서드 예제", notes = "@RequestParam을 활용한 GET Method")
    @GetMapping(value = "/request1")
    public String getRequestParam(
            @ApiParam(value="이름", required = true) @RequestParam String name,
            @ApiParam(value="이메일", required = true) @RequestParam String email,
            @ApiParam(value="회사", required = true) @RequestParam String organizaion){
        return name + " " + email + " " + organizaion;
    }

    // 4.2 @RequestParam과 Map을 조합한 GET 메서드 구현
    // http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2
    @GetMapping(value="request2")
    public String getRequestParam2( @RequestParam Map<String, String> param ) {

        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    // 5. DTO 객체를 활용한 GET 메서드 구현
    // http://localhost:8080/api/v1/get-api/request3?name=value1&email=value2&organization=value3
    @GetMapping(value="/request3")
    public String getRequestParam3(MemberDto memberDto){
        // return memberDto.getName() + memberDto.getEmail();
        return memberDto.toString();
    }

}
