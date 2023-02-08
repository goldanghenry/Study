package com.example.hello.Controller;

import com.example.hello.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {
    // 1. RequestBody PUT API - 서버로 어떤 값이 들어올지 모를 경우
    // http://localhost:8080/api/v1/put-api/member
    @PutMapping(value="/member")
    public String putMember(@RequestBody Map<String, Object> putData){
        StringBuilder sb = new StringBuilder();
        putData.entrySet().forEach(map ->{
            sb.append(map.getKey() + " : " + map.getValue()+"\n");
        });
        return sb.toString();
    }

    // 2. RequestBody + DTO object PUT API - 정해져 있는 경우
    // http://localhost:8080/api/v1/put-api/member1
    @PutMapping(value = "/member1")
    public String putMemberDto1(@RequestBody MemberDto memberDto){
        return memberDto.toString();
    }
    @PutMapping(value="member2")
    public MemberDto putMemberDto2(@RequestBody MemberDto memberDto){
        return memberDto;
    }

    // 3. ResponseEntity를 활용한 PUT API
    // http://localhost:8080/api/v1/put-api/member3
    @PutMapping(value="member3")
    public ResponseEntity<MemberDto> putMemberDto3(@RequestBody MemberDto memberDto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDto);
    }
}
