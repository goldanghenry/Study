package com.example.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    private String name;
    private String number;
    private String category;
}
/* json 에 담을 수 있는 형태
- String, Number(소숫점, int, double.. 구분x), Boolean, Object{}, Array[]
{
    "name" : "Spring Boot",
    "number" : "100",
    "category" : "java"
}
*/