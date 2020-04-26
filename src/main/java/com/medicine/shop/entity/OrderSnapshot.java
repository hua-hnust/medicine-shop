package com.medicine.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

/**  订单快照(记录下单时商品、订单、地址信息)
 * @Author xhua
 * @Date 2020/4/26 15:55
 **/
@TableName("order_snapshot")
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderSnapshot {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Long orderNo;
    private String content;
    private Date createTime;
    @TableField(update = "now()")
    private Date updateTime;

}
