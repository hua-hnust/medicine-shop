package com.medicine.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

/**  收货地址
 * @Author xhua
 * @Date 2020/4/26 15:23
 **/
@TableName("address")
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private String address;
    private String phone;
    private Date createTime;
    @TableField(update = "now()")
    private Date updateTime;

}
