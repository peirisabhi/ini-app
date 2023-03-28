package com.abhi.iniapp.service;

import com.abhi.iniapp.dto.VendorDto;

import java.util.List;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 28/03/2023
 * Time: 13:07
 */
public interface VendorService {

    VendorDto saveVendor(VendorDto vendorDto);

    VendorDto updateVendor(VendorDto vendorDto);

    VendorDto removeVendor(int id);

    VendorDto getVendor(int id);

    List<VendorDto> getVendors();
}
