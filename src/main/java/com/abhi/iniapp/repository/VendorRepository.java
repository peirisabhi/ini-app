package com.abhi.iniapp.repository;

import com.abhi.iniapp.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 28/03/2023
 * Time: 12:51
 */
public interface VendorRepository extends JpaRepository<Vendor, Integer> {
    Vendor findByUserId(int userId);
}
