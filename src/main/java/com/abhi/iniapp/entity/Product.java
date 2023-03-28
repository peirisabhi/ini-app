package com.abhi.iniapp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 28/03/2023
 * Time: 12:22
 */
@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String desc;

    private double price;

    private String img;

    @Column(name = "vendor_id")
    private int vendorId;

    @Column(length = 1)
    private int status;

    @Column(name = "registered_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date registeredAt;


}
