package com.abhi.iniapp.dto;

import com.abhi.iniapp.util.Transformer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 27/03/2023
 * Time: 23:40
 */
@Getter
@Setter
@ToString
public class UserDto implements Transformer {

    private int id;

    private String fname;

    private String lname;

    private String email;

    @JsonProperty("user_role_id")
    private int userRoleId;

    private String password;

    @Column(length = 1)
    private int status;

    @JsonProperty("registered_at")
    private String registeredAt;
}
