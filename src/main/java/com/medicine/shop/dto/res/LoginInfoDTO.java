package com.medicine.shop.dto.res;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**  会话信息
 * @Author xhua
 * @Date 2020/3/24 21:31
 **/
@Data
@ToString
@Builder
public class LoginInfoDTO {

    private String token;
    private int userType;
    private String userName;
    private String roleDesc;

}
