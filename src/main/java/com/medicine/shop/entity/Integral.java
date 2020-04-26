package com.medicine.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

/**  积分表
 * @Author xhua
 * @Date 2020/4/26 15:47
 **/
@TableName("integral")
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Integral {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer productId;
    private Integer integral;
    private Date createTime;
    @TableField(update = "now()")
    private Date updateTime;

}
