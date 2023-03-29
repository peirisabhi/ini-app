package com.abhi.iniapp.entity;

import com.abhi.iniapp.util.Transformer;
import lombok.*;

import javax.persistence.*;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 28/03/2023
 * Time: 12:27
 */
@Entity
@Table(name = "order_types")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class OrderTypes implements Transformer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;
}
