package com.example.addressbookapp.dto;

public class ResponseDto
{
    public ResponseDto(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public String message;
    public Object data;

}
