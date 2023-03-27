package com.abhi.iniapp.entity;

import com.abhi.iniapp.util.Transformer;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 27/03/2023
 * Time: 23:35
 */
@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User implements Transformer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fname;

    private String lname;

    private String email;

    @Column(name = "user_role_id")
    private int userRoleId;

    private String password;

    @Column(length = 1)
    private int status;

    @Column(name = "registered_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date registeredAt;
}
