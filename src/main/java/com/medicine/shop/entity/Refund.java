package com.medicine.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

/**  退款表
 * @Author xhua
 * @Date 2020/4/26 15:51
 **/
@TableName("refund")
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Refund {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Long orderNo;
    private String refundReason;
    private Integer verifyUserId;
    private Integer status;
    private Date createTime;
    @TableField(update = "now()")
    private Date updateTime;

}
