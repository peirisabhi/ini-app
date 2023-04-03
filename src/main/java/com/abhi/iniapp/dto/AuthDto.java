package com.abhi.iniapp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuthDto {
    private String email;
    private String password;
}
