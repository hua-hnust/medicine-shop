package com.medicine.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

/**  订单
 * @Author xhua
 * @Date 2020/4/26 15:25
 **/
@TableName("order")
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Long orderNo;
    private Integer productId;
    private Double payAmount;
    private Integer addressId;
    private Integer orderStatus;
    private Date createTime;
    @TableField(update = "now()")
    private Date updateTime;

}
