package com.abhi.iniapp.repository;

import com.abhi.iniapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 27/03/2023
 * Time: 23:38
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
