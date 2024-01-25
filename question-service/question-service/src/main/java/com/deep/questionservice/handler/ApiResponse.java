package com.deep.questionservice.handler;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiResponse {

    private int statusCode;
    private String message;


}
