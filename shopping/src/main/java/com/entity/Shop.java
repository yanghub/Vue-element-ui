package com.dropshoping.dropshoping.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
//(name = "shop")可不加也可映射到shop表
@Entity
@Data
public class Shop {
//设置id自增GeneratedValue--->IDENTITY

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String style;


}
