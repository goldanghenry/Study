package com.example.restapi.controller;

import com.example.restapi.model.BookQueryParam;
import org.springframework.web.bind.annotation.*;

/* IntelliJ 한글 설정 */
// 윈도우는 기본적으로 MS949를 바탕으로 인코딩 한다 -> 2byte -> (EUC-KR)
// web은 UTF-8 인코딩 -> 3byte
// intelliJ -> file -> setting -> encoding -> File Encoding, console -> UTF-8(global, project, Default)

@RestController                 // RestController를 사용할 것
@RequestMapping("/api")      // 이 컨트롤러는 /api라는 주소를 모두 받아들이겠다
public class RestApiController {

    // 1. simple path
    @GetMapping(path = "/hello")    // http://localhost/api/hello
    public String hello() {
        var html = "<html> <body><h1>Hello Spring Boot</h1></body></html>";
        return html;
    }

    // 2. path variable
    // 주소 내에 정보를 전달하는 방법
    // 특정한 사용자나 정보에 접근할 때
    // 단점은 주소가 노출되기 때문에 보안을 신경써야 한다.
    // http://localhost:8080/api/echo/stv/age/20/is-man/true
    @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(
            @PathVariable(name = "message") String msg,
            // Integer type : reference type, null 할당 가능 -> 주소에 부적합 - 주소 자체가 값이기 때문에 null이 올 수x
            // int type : null 할당x, default = 0           -> 주소에 적합, primitive
            @PathVariable int age,
            @PathVariable boolean isMan
    ){
        System.out.println("echo message : " +msg);
        System.out.println("echo message : " +age);
        System.out.println("echo message : " +isMan);
        // TODO 대문자로 변환해서 RETURN => toUpperCase()
        return msg.toUpperCase();
    }

    // 3.1. query parameter
    // 특정 정보의 필터링을 걸때 사용, 쿼리가 적을 때
    // ex) http://localhost:8080/book?category=IT&issuedYear=2023&issued-month=01&issued_day=31
    // ?로 시작하고 &로 묶어줌
    // 자바에서 사용하는 명명법 때문에 카멜케이스, 또는 (name = " ")을 사용해서 원칙을 따라가는 방법이 좋다
    @GetMapping(path = "/book")
    public String queryParam(
        @RequestParam String category,
        @RequestParam String issuedYear,
        @RequestParam (name="issued-month") String issuedMonth,
        @RequestParam String issued_day
    ) {
        System.out.println(category);
        System.out.println(issuedYear);
        System.out.println(issuedMonth);
        System.out.println(issued_day);

        return category + issuedYear + issuedMonth + issued_day;
    }

    // 3.2. query parameter 객체를 사용한 방법 + lombok
    // ex) http://localhost:8080/api/book2?category=IT&issuedYear=2023&issued-month=01&issued_day=31
    // ex) http://localhost:8080/api/book2?category=IT&issuedYear=2023&issuedMonth=01&issuedDay=31
    @GetMapping(path = "/book2")
    public void queryParamDTO(
            BookQueryParam bookQueryParam
    ){
        System.out.println(bookQueryParam);
        // BookQueryParam(category=IT, issuedYear=2023, issuedMonth=null, issuedDay=null)
        // 객체로 받을 때는 이름이 일치해야함. 주소 설계시 카멜 케이스로 통일
    }

    // TODO Parameter 2개를 int type으로 받아서 두 수의 뎃셈, 곱셈을 리턴하는 메서드

}
