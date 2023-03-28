package com.abhi.iniapp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 28/03/2023
 * Time: 12:48
 */
@Entity
@Table(name = "order_installments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class OrderInstallments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double price;

    @Column(name = "order_id")
    private int orderId;

    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
}
