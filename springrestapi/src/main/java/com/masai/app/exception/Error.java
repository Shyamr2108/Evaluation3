package com.masai.app.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Error {

    private LocalDateTime loacaldatetime;
    private String message;
    private String details;
}
