package com.abhi.iniapp.entity;

import com.abhi.iniapp.util.Transformer;
import lombok.*;

import javax.persistence.*;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 28/03/2023
 * Time: 12:14
 */
@Entity
@Table(name = "vendor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Vendor implements Transformer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "vendor_name")
    private String vendorName;

    private String address;

    private String contact;

    @Column(name = "user_id")
    private int userId;


}
