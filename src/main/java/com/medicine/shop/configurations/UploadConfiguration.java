package com.medicine.shop.configurations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/** 上传资源路径
 * @Author xhua
 * @Date 2020/4/6 17:50
 **/
@Component
@ConfigurationProperties(prefix = "upload")
@Data
public class UploadConfiguration {

    private String filePath;

}
