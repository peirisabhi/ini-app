package com.abhi.iniapp.dto;

import com.abhi.iniapp.util.Transformer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 28/03/2023
 * Time: 13:08
 */
@Getter
@Setter
@ToString
public class VendorDto implements Transformer {
    private int id;

    private String fname;

    private String lname;

    private String email;

    @JsonProperty("vendor_name")
    private String vendorName;

    private String address;

    private String contact;

    private String password;

    @JsonProperty("registered_at")
    private String registeredAt;

}
