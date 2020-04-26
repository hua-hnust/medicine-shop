package com.medicine.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

/**  购物车
 * @Author xhua
 * @Date 2020/4/26 15:49
 **/
@TableName("shop_cart")
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShopCart {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer productId;
    private Integer status;
    private Date createTime;
    @TableField(update = "now()")
    private Date updateTime;

}
