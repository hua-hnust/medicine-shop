package com.medicine.shop.dto.req;

import lombok.Data;
import lombok.ToString;

/**  登录请求
 * @Author xhua
 * @Date 2020/3/24 16:19
 **/
@Data
@ToString
public class LoginParamsDTO {

    private String phone;
    private String password;

}
