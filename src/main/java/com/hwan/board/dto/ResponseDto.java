package com.hwan.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
public class ResponseDto<T> {
    HttpStatus httpStatus;
    T data;
}
