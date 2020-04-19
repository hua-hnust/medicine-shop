package com.medicine.shop.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author xhua
 * @Date 2020/4/13 21:51
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdatePasswordDTO implements Serializable {

    private String oldPassword;
    private String newPassword;

}
