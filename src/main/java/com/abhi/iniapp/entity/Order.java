package com.abhi.iniapp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 28/03/2023
 * Time: 12:29
 */
@Entity
@Table(name = "order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "order_type_id")
    private int orderTypeId;

    @Column(name = "user_id")
    private int userId;

    private int status;

    private double price;

    @Column(name = "registered_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date registeredAt;
}