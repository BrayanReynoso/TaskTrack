package com.mx.tasktrack.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Response <T> {
    private T data;
    private int code;
    private String message;
    private Boolean error;
}
