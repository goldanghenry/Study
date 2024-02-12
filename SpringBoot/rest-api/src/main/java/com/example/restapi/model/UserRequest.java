package com.example.restapi.model;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(value= PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRequest {
    private String userName;
    private Integer userAge;
    private String email;
    private Boolean isKorean;
}
// JsonNaming 을 사용하는 경우, snake-case 로 받은 request body 의 내용을 camel-case 로 작성된 객체에 매핑 응답도 snake-case
/*
{
    "user_name" : "홍길동",
    "user_age" : 10,
    "email" : "hong@email.com"
}
*/
/*
1. snake case
- 언더바로 구분
user_name

2. camel case
- 변수의 경우 사용
- 소문자로 시작해서 대문자로 구분
userName
 */