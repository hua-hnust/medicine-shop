package com.medicine.shop.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/** 分页查询
 * @Author xhua
 * @Date 2020/3/22 0:55
 **/
@Data
@ToString
@Builder
public class PageResult<A> {

    private Integer page;
    private Integer size;
    private Integer total;
    private List<?> data;

}
