package com.example.exception.GlobalException.exceptionformatter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageBody
{
    private LocalDateTime localDateTime;
    private HttpStatus httpStatus;
    private String errMsg;
    private String detail;
}
