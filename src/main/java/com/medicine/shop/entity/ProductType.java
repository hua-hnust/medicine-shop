package com.medicine.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

/**
 * @Author xhua
 * @Date 2020/4/26 15:35
 **/
@TableName("product_type")
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductType {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String typeDesc;
    private Date createTime;
    @TableField(update = "now()")
    private Date updateTime;

}
