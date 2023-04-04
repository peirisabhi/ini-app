package com.abhi.iniapp.dto;

import com.abhi.iniapp.entity.OrderInstallments;
import com.abhi.iniapp.util.Transformer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 29/03/2023
 * Time: 13:10
 */
@Getter
@Setter
@ToString
public class OrderDto implements Transformer {

    private int id;

    @JsonProperty("product_id")
    private int productId;

    @JsonProperty("product_desc")
    private String productDesc;

    @JsonProperty("product_title")
    private String productTitle;

    @JsonProperty("order_type_id")
    private int orderTypeId;

    @JsonProperty("user_id")
    private int userId;

    private String status;

    @JsonProperty("order_date")
     private Date orderDate;

    @JsonProperty("order_details_list")
    private List<OrderInstallments> orderInstalmentsList;
}
