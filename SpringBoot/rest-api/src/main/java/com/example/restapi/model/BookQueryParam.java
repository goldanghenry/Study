package com.example.restapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // lombok을 사용하면, structure에 자동으로 default constructor, get, set 메소드가 만들어진다.
@AllArgsConstructor // 모든 arguments 가 포함된 constructor 가 생성
@NoArgsConstructor  // parameter를 받지 않는 기본 생성자
public class BookQueryParam {
    private String category;
    private String issuedYear;
    private String issuedMonth;
    private String issuedDay;
}
