package com.bionexo.ubs.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {

    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
