package com.medicine.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

/** 产品
 * @Author xhua
 * @Date 2020/4/26 15:06
 **/
@TableName("product")
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String productDesc;
    private Double price;
    private Integer type;
    private String images;
    private Integer stock;
    private Integer remainStock;
    private Date createTime;
    @TableField(update = "now()")
    private Date updateTime;

}
